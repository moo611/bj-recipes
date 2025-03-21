package com.example.recipes.service.impl;

import java.util.*;
import java.util.stream.Collectors;

import com.example.recipes.config.auth.UserUtil;
import com.example.recipes.domain.CpRating;
import com.example.recipes.domain.CpUser;
import com.example.recipes.mapper.CpRatingMapper;
import com.example.recipes.mapper.CpUserMapper;
import com.example.recipes.utils.CosineSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.recipes.mapper.CpRecipesMapper;
import com.example.recipes.domain.CpRecipes;
import com.example.recipes.service.ICpRecipesService;

/**
 * 菜谱Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Service
public class CpRecipesServiceImpl implements ICpRecipesService
{
    @Autowired
    private CpRecipesMapper cpRecipesMapper;
    @Autowired
    private CpRatingMapper cpRatingMapper;
    @Autowired
    private CpUserMapper cpUserMapper;

    /**
     * 查询菜谱
     *
     * @param id 菜谱主键
     * @return 菜谱
     */
    @Override
    public CpRecipes selectCpRecipesById(Long id)
    {
        return cpRecipesMapper.selectCpRecipesById(id);
    }

    /**
     * 查询菜谱列表
     *
     * @param cpRecipes 菜谱
     * @return 菜谱
     */
    @Override
    public List<CpRecipes> selectCpRecipesList(CpRecipes cpRecipes)
    {
        return cpRecipesMapper.selectCpRecipesList(cpRecipes);
    }

    /**
     * 新增菜谱
     *
     * @param cpRecipes 菜谱
     * @return 结果
     */
    @Override
    public int insertCpRecipes(CpRecipes cpRecipes)
    {
        cpRecipes.setCreateTime(new Date());
        return cpRecipesMapper.insertCpRecipes(cpRecipes);
    }

    /**
     * 修改菜谱
     *
     * @param cpRecipes 菜谱
     * @return 结果
     */
    @Override
    public int updateCpRecipes(CpRecipes cpRecipes)
    {
        cpRecipes.setUpdateTime(new Date());
        return cpRecipesMapper.updateCpRecipes(cpRecipes);
    }

    /**
     * 批量删除菜谱
     *
     * @param ids 需要删除的菜谱主键
     * @return 结果
     */
    @Override
    public int deleteCpRecipesByIds(Long[] ids)
    {
        return cpRecipesMapper.deleteCpRecipesByIds(ids);
    }

    /**
     * 删除菜谱信息
     *
     * @param id 菜谱主键
     * @return 结果
     */
    @Override
    public int deleteCpRecipesById(Long id)
    {
        return cpRecipesMapper.deleteCpRecipesById(id);
    }

    @Override
    public List<CpRecipes> recommendFoods() {


        String username = UserUtil.getCurrentUsername();
        List<String> similarUsers = findSimilarCpUsers(username);
        Set<Long> recommendedFoodIds = new HashSet<>();

        for (String similarUser : similarUsers) {
            List<Long> foodIds = cpRatingMapper.selectFoodIdsByUsername(similarUser);
            recommendedFoodIds.addAll(foodIds);
        }
        if (recommendedFoodIds.isEmpty()){
            return Collections.emptyList();
        }
        return cpRecipesMapper.selectSfFoodListByIds(recommendedFoodIds);
        
        
    }


    public List<String> findSimilarCpUsers(String username) {
        List<String> similarCpUsers = new ArrayList<>();
        List<CpUser> users = cpUserMapper.selectCpUserList(null);

        CpUser currentCpUser = cpUserMapper.selectCpUserByUsername(username);
        if (currentCpUser == null) return similarCpUsers;

        Map<String, Double> similarityScores = new HashMap<>();
        for (CpUser user : users) {
            if (!user.getUsername().equals(username)) {
                double similarity = CosineSimilarity.calculateSimilarity(getUserRatings(username), getUserRatings(user.getUsername()));
                similarityScores.put(user.getUsername(), similarity);
            }
        }

        return similarityScores.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public List<Integer> getUserRatings(String username) {
        // 获取所有美食ID，确保向量维度一致
        List<Long> allFoodIds = cpRecipesMapper.selectSfFoodIds();

        // 获取该用户的评分数据（foodId -> rating）
        Map<Long, Integer> userRatings = cpRatingMapper.findRatingsByUsername(username)
                .stream()
                .collect(Collectors.toMap(CpRating::getFoodId, CpRating::getRating));

        // 生成评分列表，如果用户未评分则填充 0
        List<Integer> ratings = new ArrayList<>();
        for (Long foodId : allFoodIds) {
            ratings.add(userRatings.getOrDefault(foodId, 0));
        }

        return ratings;
    }
}
