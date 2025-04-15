package com.example.recipes.domain;


import com.example.recipes.domain.base.BaseEntity;

/**
 * 菜谱对象 cp_recipes
 *
 * @author ruoyi
 * @date 2025-03-13
 */
public class CpRecipes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String name;

    /** $column.columnComment */
    
    private String description;

    /** $column.columnComment */
    
    private String imageUrl;

    /** 菜系id */
    
    private Long cuisineId;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;


    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    private Double rating;

    public String getCuisineName() {
        return cuisineName;
    }

    public void setCuisineName(String cuisineName) {
        this.cuisineName = cuisineName;
    }

    private String cuisineName;

    /** 0、待审核1、已审核2、已拒绝 */
    
    private String status;

    /** 0、管理员1、用户 */
    
    private String source;

    /** 删除标识 */
    private String delFlag;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    public void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
    public void setCuisineId(Long cuisineId)
    {
        this.cuisineId = cuisineId;
    }

    public Long getCuisineId()
    {
        return cuisineId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

  
}
