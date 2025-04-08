package com.example.recipes.mapper;

import java.util.List;
import java.util.Set;

import com.example.recipes.domain.CpRecipes;
import com.example.recipes.domain.req.CpRecipesListReq2;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜谱Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Mapper
public interface CpRecipesMapper
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
     * 删除菜谱
     *
     * @param id 菜谱主键
     * @return 结果
     */
    public int deleteCpRecipesById(Long id);

    /**
     * 批量删除菜谱
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCpRecipesByIds(Long[] ids);


    List<Long> selectSfFoodIds();


    List<CpRecipes> selectSfFoodListByIds(Set<Long> foodIds);

    List<CpRecipes> selectCpRecipesListTopk(CpRecipesListReq2 cpRecipesListReq2);

}
