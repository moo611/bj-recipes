package com.example.recipes.service;

import java.util.List;
import com.example.recipes.domain.CpRecipes;
import com.example.recipes.domain.req.CpRecipesListReq;
import com.example.recipes.domain.req.CpRecipesListReq2;

/**
 * 菜谱Service接口
 *
 * @author ruoyi
 * @date 2025-03-13
 */
public interface ICpRecipesService
{
    /**
     * 查询菜谱
     *
     * @param id 菜谱主键
     * @return 菜谱
     */
    public CpRecipes selectCpRecipesById(Long id);

    /**
     * 查询菜谱列表
     *
     * @param cpRecipes 菜谱
     * @return 菜谱集合
     */
    public List<CpRecipes> selectCpRecipesList(CpRecipes cpRecipes);

    /**
     * 新增菜谱
     *
     * @param cpRecipes 菜谱
     * @return 结果
     */
    public int insertCpRecipes(CpRecipes cpRecipes);

    /**
     * 修改菜谱
     *
     * @param cpRecipes 菜谱
     * @return 结果
     */
    public int updateCpRecipes(CpRecipes cpRecipes);

    /**
     * 批量删除菜谱
     *
     * @param ids 需要删除的菜谱主键集合
     * @return 结果
     */
    public int deleteCpRecipesByIds(Long[] ids);

    /**
     * 删除菜谱信息
     *
     * @param id 菜谱主键
     * @return 结果
     */
    public int deleteCpRecipesById(Long id);



    List<CpRecipes> recommendFoods();

    List<CpRecipes> recommendFoodsTopk(CpRecipesListReq2 cpRecipesListReq2);
}
