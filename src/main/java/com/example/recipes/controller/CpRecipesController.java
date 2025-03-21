package com.example.recipes.controller;

import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.example.recipes.domain.CpRecipes;
import com.example.recipes.domain.base.AjaxResult;
import com.example.recipes.domain.base.R;
import com.example.recipes.domain.req.CpRecipesListReq;
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

import com.example.recipes.domain.CpRecipes;
import com.example.recipes.service.ICpRecipesService;

/**
 * 菜谱Controller
 *
 * @author ruoyi
 * @date 2025-03-13
 */
@RestController
@RequestMapping("/recipes")
public class CpRecipesController extends BaseController
{
    @Autowired
    private ICpRecipesService cpRecipesService;

    /**
     * 查询菜谱列表
     */
    
    @GetMapping("/list")
    public R list(CpRecipesListReq cpRecipesListReq)
    {
        PageHelper.startPage(cpRecipesListReq.getPageNum(), cpRecipesListReq.getPageSize());
        CpRecipes cpRecipes = new CpRecipes();
        BeanUtils.copyProperties(cpRecipesListReq, cpRecipes);

        List<CpRecipes> cpRecipess = cpRecipesService.selectCpRecipesList(cpRecipes);
        if (cpRecipess.size() > 0) {
            PageInfo<CpRecipes> pageInfo = new PageInfo<>(cpRecipess);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<CpRecipes>(Collections.emptyList()));
    }

    /**
     * 协同过滤
     * @param cpRecipesListReq
     * @return
     */
    @GetMapping("/recommend")
    public AjaxResult recommend(CpRecipesListReq cpRecipesListReq){

        return AjaxResult.success(cpRecipesService.recommendFoods());
    }
 

    /**
     * 获取菜谱详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cpRecipesService.selectCpRecipesById(id));
    }

    /**
     * 新增菜谱
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody CpRecipes cpRecipes)
    {
        return toAjax(cpRecipesService.insertCpRecipes(cpRecipes));
    }

    /**
     * 修改菜谱
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody CpRecipes cpRecipes)
    {
        return toAjax(cpRecipesService.updateCpRecipes(cpRecipes));
    }

    /**
     * 删除菜谱
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cpRecipesService.deleteCpRecipesByIds(ids));
    }
}
