package com.example.recipes.domain;


import com.example.recipes.domain.base.BaseEntity;

/**
 * 菜系对象 cp_cuisines
 *
 * @author ruoyi
 * @date 2025-03-13
 */
public class CpCuisines extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    
    private String name;

    /** $column.columnComment */
    
    private String description;

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
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

 
}
