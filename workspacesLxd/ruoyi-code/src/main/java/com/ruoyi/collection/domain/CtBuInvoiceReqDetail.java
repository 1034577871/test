package com.ruoyi.collection.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 发票申请明细对象 ct_bu_invoice_req_detail
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
public class CtBuInvoiceReqDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 发票申请表ID */
    @Excel(name = "发票申请表ID")
    private String invoiceId;

    /** 开票项目名称 */
    @Excel(name = "开票项目名称")
    private String invoiceProName;

    /** 规格 */
    @Excel(name = "规格")
    private String invoiceSpec;

    /** 型号 */
    @Excel(name = "型号")
    private String invoiceType;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal invoicePrice;

    public BigDecimal getInvoiceAmountTax() {
        return invoiceAmountTax;
    }

    public void setInvoiceAmountTax(BigDecimal invoiceAmountTax) {
        this.invoiceAmountTax = invoiceAmountTax;
    }

    /** 数量 */
    @Excel(name = "数量")
    private Long invoiceMount;

    /** 金额（含税） */
    @Excel(name = "金额", readConverterExp = "含=税")
    private BigDecimal invoiceAmountTax;

    /** 税率 */
    @Excel(name = "税率")
    private String invoiceTaxrate;

    /** 金额（不含税） */
    @Excel(name = "金额", readConverterExp = "不=含税")
    private BigDecimal invoiceAmountNtax;

    /** 删除标志 */
    private String delFlag;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setInvoiceId(String invoiceId) 
    {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceId() 
    {
        return invoiceId;
    }
    public void setInvoiceProName(String invoiceProName) 
    {
        this.invoiceProName = invoiceProName;
    }

    public String getInvoiceProName() 
    {
        return invoiceProName;
    }
    public void setInvoiceSpec(String invoiceSpec) 
    {
        this.invoiceSpec = invoiceSpec;
    }

    public String getInvoiceSpec() 
    {
        return invoiceSpec;
    }
    public void setInvoiceType(String invoiceType) 
    {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceType() 
    {
        return invoiceType;
    }
    public void setInvoicePrice(BigDecimal invoicePrice) 
    {
        this.invoicePrice = invoicePrice;
    }

    public BigDecimal getInvoicePrice() 
    {
        return invoicePrice;
    }
    public void setInvoiceMount(Long invoiceMount) 
    {
        this.invoiceMount = invoiceMount;
    }

    public Long getInvoiceMount() 
    {
        return invoiceMount;
    }

    public void setInvoiceTaxrate(String invoiceTaxrate) 
    {
        this.invoiceTaxrate = invoiceTaxrate;
    }

    public String getInvoiceTaxrate() 
    {
        return invoiceTaxrate;
    }
    public void setInvoiceAmountNtax(BigDecimal invoiceAmountNtax) 
    {
        this.invoiceAmountNtax = invoiceAmountNtax;
    }

    public BigDecimal getInvoiceAmountNtax() 
    {
        return invoiceAmountNtax;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("invoiceId", getInvoiceId())
            .append("invoiceProName", getInvoiceProName())
            .append("invoiceSpec", getInvoiceSpec())
            .append("invoiceType", getInvoiceType())
            .append("invoicePrice", getInvoicePrice())
            .append("invoiceMount", getInvoiceMount())
            .append("invoiceAmountTax", getInvoiceAmountTax())
            .append("invoiceTaxrate", getInvoiceTaxrate())
            .append("invoiceAmountNtax", getInvoiceAmountNtax())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("unit", getUnit())
            .toString();
    }
}
