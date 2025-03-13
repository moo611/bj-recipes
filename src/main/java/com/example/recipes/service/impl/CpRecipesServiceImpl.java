package com.example.recipes.service.impl;

import java.util.Date;
import java.util.List;
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
}
