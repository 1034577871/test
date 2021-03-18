package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ctBuMaterielInfo对象 ct_bu_materiel_info
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public class CtBuMaterielInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
    /** 主键 */
    private Long id;

    /** 第一级 */
    @Excel(name = "第一级")
    private String fir;

    /** 第二级 */
    @Excel(name = "第二级")
    private String sec;

    /** 第三级 */
    @Excel(name = "第三级")
    private String thr;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private String code;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String name;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 单位 */
    @Excel(name = "单位")
    private String units;

    /** 单价 */
    @Excel(name = "单价")
    private String price;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFir(String fir) 
    {
        this.fir = fir;
    }

    public String getFir() 
    {
        return fir;
    }
    public void setSec(String sec) 
    {
        this.sec = sec;
    }

    public String getSec() 
    {
        return sec;
    }
    public void setThr(String thr) 
    {
        this.thr = thr;
    }

    public String getThr() 
    {
        return thr;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setUnits(String units) 
    {
        this.units = units;
    }

    public String getUnits() 
    {
        return units;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fir", getFir())
            .append("sec", getSec())
            .append("thr", getThr())
            .append("code", getCode())
            .append("name", getName())
            .append("type", getType())
            .append("units", getUnits())
            .append("price", getPrice())
            .toString();
    }
}
