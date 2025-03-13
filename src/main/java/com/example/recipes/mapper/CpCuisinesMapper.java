package com.example.recipes.mapper;

import java.util.List;
import com.example.recipes.domain.CpCuisines;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜系Mapper接口
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Mapper
public interface CpCuisinesMapper
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
     * 删除菜系
     *
     * @param id 菜系主键
     * @return 结果
     */
    public int deleteCpCuisinesById(Long id);

    /**
     * 批量删除菜系
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCpCuisinesByIds(Long[] ids);
}
