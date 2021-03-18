package com.ruoyi.projectApproval.ApprovalNg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ConstructionInfo对象 ct_bu_construction_info
 * 
 * @author ruoyi
 * @date 2021-02-23
 */
public class CtBuConstructionInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
    /** 方案名称 */
    @Excel(name = "方案名称")
    private String planName;

    /** 类别 */
    @Excel(name = "类别")
    private String type;

    /** 施工项名称 */
    @Excel(name = "施工项名称")
    private String sgxName;

    /** 施工内容 */
    @Excel(name = "施工内容")
    private String sgContent;

    /** 施工备注 */
    @Excel(name = "施工备注")
    private String sgRemark;

    /** 基准单价 */
    @Excel(name = "基准单价")
    private String price;

    /** 单位 */
    @Excel(name = "单位")
    private String units;

    /** 分公司名称 */
    @Excel(name = "分公司名称")
    private String companyName;

    /** 分公司id */
    @Excel(name = "分公司id")
    private String companyId;

    /** 分公司基准单价 */
    @Excel(name = "分公司基准单价")
    private String companyPrice;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPlanName(String planName) 
    {
        this.planName = planName;
    }

    public String getPlanName() 
    {
        return planName;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setSgxName(String sgxName) 
    {
        this.sgxName = sgxName;
    }

    public String getSgxName() 
    {
        return sgxName;
    }
    public void setSgContent(String sgContent) 
    {
        this.sgContent = sgContent;
    }

    public String getSgContent() 
    {
        return sgContent;
    }
    public void setSgRemark(String sgRemark) 
    {
        this.sgRemark = sgRemark;
    }

    public String getSgRemark() 
    {
        return sgRemark;
    }
    public void setPrice(String price) 
    {
        this.price = price;
    }

    public String getPrice() 
    {
        return price;
    }
    public void setUnits(String units) 
    {
        this.units = units;
    }

    public String getUnits() 
    {
        return units;
    }
    public void setCompanyName(String companyName) 
    {
        this.companyName = companyName;
    }

    public String getCompanyName() 
    {
        return companyName;
    }
    public void setCompanyId(String companyId) 
    {
        this.companyId = companyId;
    }

    public String getCompanyId() 
    {
        return companyId;
    }
    public void setCompanyPrice(String companyPrice) 
    {
        this.companyPrice = companyPrice;
    }

    public String getCompanyPrice() 
    {
        return companyPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("planName", getPlanName())
            .append("type", getType())
            .append("sgxName", getSgxName())
            .append("sgContent", getSgContent())
            .append("sgRemark", getSgRemark())
            .append("price", getPrice())
            .append("units", getUnits())
            .append("companyName", getCompanyName())
            .append("companyId", getCompanyId())
            .append("companyPrice", getCompanyPrice())
            .toString();
    }
}
