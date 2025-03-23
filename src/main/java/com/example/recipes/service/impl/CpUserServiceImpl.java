package com.example.recipes.service.impl;

import com.example.recipes.config.auth.UserUtil;
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
    private CpUserMapper cpUserMapper;
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
        return cpUserMapper.selectCpUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param cpUser 用户
     * @return 用户
     */
    @Override
    public List<CpUser> selectCpUserList(CpUser cpUser)
    {
        return cpUserMapper.selectCpUserList(cpUser);
    }

    /**
     * 新增用户
     *
     * @param cpUser 用户
     * @return 结果
     */
    @Override
    public int insertCpUser(CpUser cpUser)
    {
        CpUser old = cpUserMapper.selectCpUserByUsername(cpUser.getUsername());
        if (old != null){
            return -32001;
        }
        String encodedPassword = passwordEncoder.encode(cpUser.getPassword());
        cpUser.setPassword(encodedPassword);
        cpUser.setCreateTime(new Date());
        
        return cpUserMapper.insertCpUser(cpUser);
    }

    /**
     * 修改用户
     *
     * @param cpUser 用户
     * @return 结果
     */
    @Override
    public int updateCpUser(CpUser cpUser)
    {

        CpUser old = cpUserMapper.selectCpUserByUsername(cpUser.getUsername());
        if (old!=null && !old.getId().equals(cpUser.getId())){
            return -32001;
        }

        cpUser.setUpdateTime(new Date());
        return cpUserMapper.updateCpUser(cpUser);
    }

    @Override
    public int changePwd(String oldPwd, String newPwd) {

        String username = UserUtil.getCurrentUsername();
        CpUser old = cpUserMapper.selectCpUserByUsername(username);

        if (old!=null && !passwordEncoder.matches(oldPwd, old.getPassword())){
            return -32001;
        }

        old.setPassword(passwordEncoder.encode(newPwd));
        return cpUserMapper.updateCpUser(old);

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
        return cpUserMapper.deleteCpUserByIds(ids);
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
        return cpUserMapper.deleteCpUserById(id);
    }

    @Override
    public CpUser selectRtUserByUsername(String username) {
        return cpUserMapper.selectCpUserByUsername(username);
    }
}
