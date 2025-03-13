package com.example.recipes.service.impl;

import com.example.recipes.domain.CpUser;
import com.example.recipes.mapper.CpUserMapper;
import com.example.recipes.service.ICpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户Service业务层处理
 *
 * 
 * @date 2024-10-19
 */
@Service
public class CpUserServiceImpl implements ICpUserService
{
    @Autowired
    private CpUserMapper sptUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;  // 注入 PasswordEncode
    /**
     * 查询用户
     *
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public CpUser selectCpUserById(Long id)
    {
        return sptUserMapper.selectCpUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param sptUser 用户
     * @return 用户
     */
    @Override
    public List<CpUser> selectCpUserList(CpUser sptUser)
    {
        return sptUserMapper.selectCpUserList(sptUser);
    }

    /**
     * 新增用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int insertCpUser(CpUser sptUser)
    {
        CpUser old = sptUserMapper.selectCpUserByUsername(sptUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(sptUser.getPassword());
        sptUser.setPassword(encodedPassword);
        sptUser.setCreateTime(new Date());
        
        return sptUserMapper.insertCpUser(sptUser);
    }

    /**
     * 修改用户
     *
     * @param sptUser 用户
     * @return 结果
     */
    @Override
    public int updateCpUser(CpUser sptUser)
    {

        CpUser old = sptUserMapper.selectCpUserByUsername(sptUser.getUsername());
        if (!old.getId().equals(sptUser.getId())){
            return -32001;
        }

        sptUser.setUpdateTime(new Date());
        return sptUserMapper.updateCpUser(sptUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteCpUserByIds(Long[] ids)
    {
        return sptUserMapper.deleteCpUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteCpUserById(Long id)
    {
        return sptUserMapper.deleteCpUserById(id);
    }

    @Override
    public CpUser selectRtUserByUsername(String username) {
        return sptUserMapper.selectCpUserByUsername(username);
    }
}
