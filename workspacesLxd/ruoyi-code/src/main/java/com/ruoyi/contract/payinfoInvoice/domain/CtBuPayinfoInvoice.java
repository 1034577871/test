package com.ruoyi.contract.payinfoInvoice.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 付款周期-发票对应关系对象 ct_bu_payinfo_invoice
 *
 * @author ruoyi
 * @date 2021-01-14
 */
public class CtBuPayinfoInvoice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 合同编号
     */
    @Excel(name = "合同编号")
    private String contractId;

    /**
     * 付款周期编号
     */
    @Excel(name = "付款周期编号")
    private String paymentCycleId;

    /**
     * 收票表或发票表ID
     */
    @Excel(name = "收票表或发票表ID")
    private String bid;

    /**
     * 发票号码
     */
    @Excel(name = "发票号码")
    private String invoiceNo;

    /**
     * 发票含税金额
     */
    @Excel(name = "发票含税金额")
    private BigDecimal invoiceMoney;

    /**
     * 发票不含税金额
     */
    @Excel(name = "发票不含税金额")
    private BigDecimal invoiceNomoney;

    /**
     * 发票代码
     */
    @Excel(name = "发票代码")
    private String invoiceCode;

    /**
     * 发票时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发票时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoiceTime;

    /**
     * 删除标志
     */
    private Integer delFlag;

    private String remark;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getContractId() {
        return contractId;
    }

    public void setPaymentCycleId(String paymentCycleId) {
        this.paymentCycleId = paymentCycleId;
    }

    public String getPaymentCycleId() {
        return paymentCycleId;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBid() {
        return bid;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceMoney(BigDecimal invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public BigDecimal getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceNomoney(BigDecimal invoiceNomoney) {
        this.invoiceNomoney = invoiceNomoney;
    }

    public BigDecimal getInvoiceNomoney() {
        return invoiceNomoney;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public Date getInvoiceTime() {
        return invoiceTime;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("contractId", getContractId())
                .append("paymentCycleId", getPaymentCycleId())
                .append("bid", getBid())
                .append("invoiceNo", getInvoiceNo())
                .append("invoiceMoney", getInvoiceMoney())
                .append("invoiceNomoney", getInvoiceNomoney())
                .append("invoiceCode", getInvoiceCode())
                .append("invoiceTime", getInvoiceTime())
                .append("delFlag", getDelFlag())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
