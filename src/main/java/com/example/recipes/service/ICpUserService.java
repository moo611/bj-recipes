package com.example.recipes.service;

import com.example.recipes.domain.CpUser;

import java.util.List;

/**
 * 用户Service接口
 *
 * 
 * @date 2024-10-19
 */
public interface ICpUserService
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
     * @param cpUser 用户
     * @return 用户集合
     */
    public List<CpUser> selectCpUserList(CpUser cpUser);

    /**
     * 新增用户
     *
     * @param cpUser 用户
     * @return 结果
     */
    public int insertCpUser(CpUser cpUser);

    /**
     * 修改用户
     *
     * @param cpUser 用户
     * @return 结果
     */
    public int updateCpUser(CpUser cpUser);


    int changePwd(String oldPwd, String newPwd);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteCpUserByIds(Long[] ids);

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteCpUserById(Long id);

    CpUser selectRtUserByUsername(String username);
}
