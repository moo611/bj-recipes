package com.example.recipes.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.recipes.mapper.CpCuisinesMapper;
import com.example.recipes.domain.CpCuisines;
import com.example.recipes.service.ICpCuisinesService;

/**
 * 菜系Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@Service
public class CpCuisinesServiceImpl implements ICpCuisinesService
{
    @Autowired
    private CpCuisinesMapper cpCuisinesMapper;

    /**
     * 查询菜系
     *
     * @param id 菜系主键
     * @return 菜系
     */
    @Override
    public CpCuisines selectCpCuisinesById(Long id)
    {
        return cpCuisinesMapper.selectCpCuisinesById(id);
    }

    /**
     * 查询菜系列表
     *
     * @param cpCuisines 菜系
     * @return 菜系
     */
    @Override
    public List<CpCuisines> selectCpCuisinesList(CpCuisines cpCuisines)
    {
        return cpCuisinesMapper.selectCpCuisinesList(cpCuisines);
    }

    /**
     * 新增菜系
     *
     * @param cpCuisines 菜系
     * @return 结果
     */
    @Override
    public int insertCpCuisines(CpCuisines cpCuisines)
    {
        cpCuisines.setCreateTime(new Date());
        return cpCuisinesMapper.insertCpCuisines(cpCuisines);
    }

    /**
     * 修改菜系
     *
     * @param cpCuisines 菜系
     * @return 结果
     */
    @Override
    public int updateCpCuisines(CpCuisines cpCuisines)
    {
        cpCuisines.setUpdateTime(new Date());
        return cpCuisinesMapper.updateCpCuisines(cpCuisines);
    }

    /**
     * 批量删除菜系
     *
     * @param ids 需要删除的菜系主键
     * @return 结果
     */
    @Override
    public int deleteCpCuisinesByIds(Long[] ids)
    {
        return cpCuisinesMapper.deleteCpCuisinesByIds(ids);
    }

    /**
     * 删除菜系信息
     *
     * @param id 菜系主键
     * @return 结果
     */
    @Override
    public int deleteCpCuisinesById(Long id)
    {
        return cpCuisinesMapper.deleteCpCuisinesById(id);
    }
}
