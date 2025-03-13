package com.example.recipes.mapper;

import com.example.recipes.domain.CpUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * 
 * @date 2024-10-19
 */
@Mapper
public interface CpUserMapper
{
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    public CpUser selectCpUserById(Long id);

    /**
     * 查询用户列表
     *
     * @param sptUser 用户
     * @return 用户集合
     */
    public List<CpUser> selectCpUserList(CpUser sptUser);

    /**
     * 新增用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    public int insertCpUser(CpUser sptUser);

    /**
     * 修改用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    public int updateCpUser(CpUser sptUser);

    /**
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteCpUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCpUserByIds(Long[] ids);

    CpUser selectCpUserByUsername(String username);

}
