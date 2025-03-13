package com.example.recipes.service;

import java.util.List;
import com.example.recipes.domain.CpCuisines;

/**
 * 菜系Service接口
 *
 * @author ruoyi
 * @date 2025-03-13
 */
public interface ICpCuisinesService
{
    /**
     * 查询菜系
     *
     * @param id 菜系主键
     * @return 菜系
     */
    public CpCuisines selectCpCuisinesById(Long id);

    /**
     * 查询菜系列表
     *
     * @param cpCuisines 菜系
     * @return 菜系集合
     */
    public List<CpCuisines> selectCpCuisinesList(CpCuisines cpCuisines);

    /**
     * 新增菜系
     *
     * @param cpCuisines 菜系
     * @return 结果
     */
    public int insertCpCuisines(CpCuisines cpCuisines);

    /**
     * 修改菜系
     *
     * @param cpCuisines 菜系
     * @return 结果
     */
    public int updateCpCuisines(CpCuisines cpCuisines);

    /**
     * 批量删除菜系
     *
     * @param ids 需要删除的菜系主键集合
     * @return 结果
     */
    public int deleteCpCuisinesByIds(Long[] ids);

    /**
     * 删除菜系信息
     *
     * @param id 菜系主键
     * @return 结果
     */
    public int deleteCpCuisinesById(Long id);
}
