package com.example.recipes.service.impl;

import com.example.recipes.domain.CpRating;
import com.example.recipes.mapper.CpRatingMapper;
import com.example.recipes.service.ICpRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 评分Service业务层处理
 *
 * @author ruoyi
 * @date 2025-03-11
 */
@Service
public class CpRatingServiceImpl implements ICpRatingService
{
    @Autowired
    private CpRatingMapper cpRatingMapper;

    /**
     * 查询评分
     *
     * @param id 评分主键
     * @return 评分
     */
    @Override
    public CpRating selectCpRatingById(Long id)
    {
        return cpRatingMapper.selectCpRatingById(id);
    }

    /**
     * 查询评分列表
     *
     * @param cpRating 评分
     * @return 评分
     */
    @Override
    public List<CpRating> selectCpRatingList(CpRating cpRating)
    {
        return cpRatingMapper.selectCpRatingList(cpRating);
    }

    /**
     * 新增评分
     *
     * @param cpRating 评分
     * @return 结果
     */
    @Override
    public int insertCpRating(CpRating cpRating)
    {

        CpRating old = cpRatingMapper.selectCpRatingByUser(cpRating.getUsername(),cpRating.getFoodId());
        if (old != null){
            return -32001;
        }
        cpRating.setCreateTime(new Date());
        return cpRatingMapper.insertCpRating(cpRating);
    }

    /**
     * 修改评分
     *
     * @param cpRating 评分
     * @return 结果
     */
    @Override
    public int updateCpRating(CpRating cpRating)
    {
        cpRating.setUpdateTime(new Date());
        return cpRatingMapper.updateCpRating(cpRating);
    }

    /**
     * 批量删除评分
     *
     * @param ids 需要删除的评分主键
     * @return 结果
     */
    @Override
    public int deleteCpRatingByIds(Long[] ids)
    {
        return cpRatingMapper.deleteCpRatingByIds(ids);
    }

    /**
     * 删除评分信息
     *
     * @param id 评分主键
     * @return 结果
     */
    @Override
    public int deleteCpRatingById(Long id)
    {
        return cpRatingMapper.deleteCpRatingById(id);
    }
}
