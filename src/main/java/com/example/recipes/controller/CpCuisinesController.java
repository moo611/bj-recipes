package com.example.recipes.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.recipes.domain.base.AjaxResult;
import com.example.recipes.domain.base.R;
import com.example.recipes.domain.req.CpCuisinesListReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipes.domain.CpCuisines;
import com.example.recipes.service.ICpCuisinesService;


/**
 * 菜系Controller
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@RestController
@RequestMapping("/cuisines")
public class CpCuisinesController extends BaseController
{
    @Autowired
    private ICpCuisinesService cpCuisinesService;

    /**
     * 查询菜系列表
     */
    
    @GetMapping("/list")
    public R list(CpCuisinesListReq cpCuisinesListReq)
    {
        PageHelper.startPage(cpCuisinesListReq.getPageNum(), cpCuisinesListReq.getPageSize());
        CpCuisines cpCuisines = new CpCuisines();
        BeanUtils.copyProperties(cpCuisinesListReq, cpCuisines);

        List<CpCuisines> cpCuisiness = cpCuisinesService.selectCpCuisinesList(cpCuisines);
        if (cpCuisiness.size() > 0) {
            PageInfo<CpCuisines> pageInfo = new PageInfo<>(cpCuisiness);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<CpCuisines>(Collections.emptyList()));
    }

  

    /**
     * 获取菜系详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cpCuisinesService.selectCpCuisinesById(id));
    }

    /**
     * 新增菜系
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody CpCuisines cpCuisines)
    {
        return toAjax(cpCuisinesService.insertCpCuisines(cpCuisines));
    }

    /**
     * 修改菜系
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody CpCuisines cpCuisines)
    {
        return toAjax(cpCuisinesService.updateCpCuisines(cpCuisines));
    }

    /**
     * 删除菜系
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cpCuisinesService.deleteCpCuisinesByIds(ids));
    }
}
