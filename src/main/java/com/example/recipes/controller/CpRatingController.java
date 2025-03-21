package com.example.recipes.controller;

import com.example.recipes.domain.CpRating;
import com.example.recipes.domain.base.AjaxResult;
import com.example.recipes.domain.base.R;
import com.example.recipes.domain.req.CpRatingListReq;
import com.example.recipes.service.ICpRatingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


/**
 * 评分Controller
 *
 * @author ruoyi
 * @date 2025-03-11
 */
@RestController
@RequestMapping("/rating")
public class CpRatingController extends BaseController
{
    @Autowired
    private ICpRatingService cpRatingService;

    /**
     * 查询评分列表
     */
    
    @GetMapping("/list")
    public R list(CpRatingListReq cpRatingListReq)
    {
        PageHelper.startPage(cpRatingListReq.getPageNum(), cpRatingListReq.getPageSize());
        CpRating cpRating = new CpRating();
        BeanUtils.copyProperties(cpRatingListReq, cpRating);

        List<CpRating> cpRatings = cpRatingService.selectCpRatingList(cpRating);
        if (cpRatings.size() > 0) {
            PageInfo<CpRating> pageInfo = new PageInfo<>(cpRatings);
            return R.ok(pageInfo);
        }
        return R.ok(new PageInfo<CpRating>(Collections.emptyList()));
    }


    /**
     * 获取评分详细信息
     */
    
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cpRatingService.selectCpRatingById(id));
    }

    /**
     * 新增评分
     */
    
    
    @PostMapping
    public AjaxResult add(@RequestBody CpRating cpRating)
    {
        int rows = cpRatingService.insertCpRating(cpRating);
        if (rows == -32001){
            return AjaxResult.error("您已经评价过了");
        }
        return toAjax(rows);
    }

    /**
     * 修改评分
     */
    
    
    @PutMapping
    public AjaxResult edit(@RequestBody CpRating cpRating)
    {
        return toAjax(cpRatingService.updateCpRating(cpRating));
    }

    /**
     * 删除评分
     */
    
    
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cpRatingService.deleteCpRatingByIds(ids));
    }
}
