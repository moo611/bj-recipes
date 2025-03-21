package com.example.recipes.service;

import com.example.recipes.domain.CpRating;

import java.util.List;

/**
 * 评分Service接口
 *
 * @author ruoyi
 * @date 2025-03-11
 */
public interface ICpRatingService
{
    /**
     * 查询评分
     *
     * @param id 评分主键
     * @return 评分
     */
    public CpRating selectCpRatingById(Long id);

    /**
     * 查询评分列表
     *
     * @param cpRating 评分
     * @return 评分集合
     */
    public List<CpRating> selectCpRatingList(CpRating cpRating);

    /**
     * 新增评分
     *
     * @param cpRating 评分
     * @return 结果
     */
    public int insertCpRating(CpRating cpRating);

    /**
     * 修改评分
     *
     * @param cpRating 评分
     * @return 结果
     */
    public int updateCpRating(CpRating cpRating);

    /**
     * 批量删除评分
     *
     * @param ids 需要删除的评分主键集合
     * @return 结果
     */
    public int deleteCpRatingByIds(Long[] ids);

    /**
     * 删除评分信息
     *
     * @param id 评分主键
     * @return 结果
     */
    public int deleteCpRatingById(Long id);
}
