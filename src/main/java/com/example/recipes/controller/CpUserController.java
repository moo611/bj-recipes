package com.example.recipes.controller;

import com.example.recipes.config.auth.JwtUtil;
import com.example.recipes.config.auth.MyUserDetailsService;
import com.example.recipes.config.auth.UserUtil;
import com.example.recipes.domain.CpUser;
import com.example.recipes.domain.base.AjaxResult;
import com.example.recipes.domain.base.R;
import com.example.recipes.domain.req.LoginReq;
import com.example.recipes.domain.req.CpUserListReq;
import com.example.recipes.service.ICpUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * 用户Controller
 *
 * 
 * @date 2024-10-19
 */
@RestController
@RequestMapping("/user")
public class CpUserController extends BaseController {
    @Autowired
    private ICpUserService cpUserService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/login")
    @ApiOperation("登录")
    public AjaxResult login(@RequestBody LoginReq loginReq) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
            );
        }catch (Exception e){
            return AjaxResult.error("用户名或密码错误");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginReq.getUsername());
        return AjaxResult.success("ok",jwtUtil.generateToken(userDetails.getUsername()));

    }


    /**
     * 查询用户列表
     */

    @GetMapping("/list")
    public R list(CpUserListReq cpUserListReq) {
        PageHelper.startPage(cpUserListReq.getPageNum(), cpUserListReq.getPageSize());
        CpUser cpUser = new CpUser();
        BeanUtils.copyProperties(cpUserListReq, cpUser);

        List<CpUser> cpUsers = cpUserService.selectCpUserList(cpUser);
        if (cpUsers.size() > 0) {
            PageInfo<CpUser> pageInfo = new PageInfo<>(cpUsers);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<CpUser>(Collections.emptyList()));
    }


    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(cpUserService.selectCpUserById(id));
    }

    /**
     * 获取用户详细信息
     */

    @GetMapping(value = "/info")
    @ApiOperation("获取用户详细信息")
    public AjaxResult getInfo()
    {
        String username = UserUtil.getCurrentUsername();
        return success(cpUserService.selectRtUserByUsername(username));
    }

    /**
     * 新增用户
     */


    @PostMapping
    public AjaxResult add(@RequestBody CpUser cpUser) {

        int res = cpUserService.insertCpUser(cpUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);


    }

    /**
     * 修改用户
     */


    @PutMapping
    public AjaxResult edit(@RequestBody CpUser cpUser) {
        int res = cpUserService.updateCpUser(cpUser);
        if (res == -32001){
            return AjaxResult.error("用户名已存在");
        }
        return toAjax(res);
    }

    /**
     * 删除用户
     */


    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(cpUserService.deleteCpUserByIds(ids));
    }
}
