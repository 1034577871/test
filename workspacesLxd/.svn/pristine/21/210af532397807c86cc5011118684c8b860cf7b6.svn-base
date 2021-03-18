package com.ruoyi.contract.contractPayinfo.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同付款对象 ct_bu_contract_payinfo
 *
 * @author ruoyi
 * @date 2020-12-10
 */
public class CtBuContractPayinfo extends BaseEntity {
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
     * 预计付款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date estimateTime;

    /**
     * 付款条件说明
     */
    @Excel(name = "付款条件说明")
    private String conditionInfo;

    /**
     * 付款比例
     */
    @Excel(name = "付款比例")
    private Integer paymentRatio;

    /**
     * 应付款金额
     */
    @Excel(name = "应付款金额")
    private BigDecimal estimateMoney;

    /**
     * 实际付款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private String actualTime;

    /**
     * 实际付款金额
     */
    @Excel(name = "实际付款金额")
    private String actualMoney;

    /**
     * 发票号码
     */
    @Excel(name = "发票号码")
    private String invoiceId;

    /**
     * 发票含税金额
     */
    @Excel(name = "发票含税金额")
    private String invoiceMoney;

    /**
     * 发票不含税金额
     */
    @Excel(name = "发票不含税金额")
    private String invoiceNomoney;

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
    private String invoiceTime;

    /**
     * 备注信息
     */
    @Excel(name = "备注信息")
    private String remarks;

    /**
     * 删除标记
     */
    private Integer delFlag;

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

    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }

    public Date getEstimateTime() {
        return estimateTime;
    }

    public void setConditionInfo(String conditionInfo) {
        this.conditionInfo = conditionInfo;
    }

    public String getConditionInfo() {
        return conditionInfo;
    }

    public void setPaymentRatio(Integer paymentRatio) {
        this.paymentRatio = paymentRatio;
    }

    public Integer getPaymentRatio() {
        return paymentRatio;
    }

    public void setEstimateMoney(BigDecimal estimateMoney) {
        this.estimateMoney = estimateMoney;
    }

    public BigDecimal getEstimateMoney() {
        return estimateMoney;
    }

    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }

    public String getActualTime() {
        return actualTime;
    }

    public void setActualMoney(String actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getActualMoney() {
        return actualMoney;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceMoney(String invoiceMoney) {
        this.invoiceMoney = invoiceMoney;
    }

    public String getInvoiceMoney() {
        return invoiceMoney;
    }

    public void setInvoiceNomoney(String invoiceNomoney) {
        this.invoiceNomoney = invoiceNomoney;
    }

    public String getInvoiceNomoney() {
        return invoiceNomoney;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceTime(String invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public String getInvoiceTime() {
        return invoiceTime;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("contractId", getContractId())
                .append("estimateTime", getEstimateTime())
                .append("conditionInfo", getConditionInfo())
                .append("paymentRatio", getPaymentRatio())
                .append("estimateMoney", getEstimateMoney())
                .append("actualTime", getActualTime())
                .append("actualMoney", getActualMoney())
                .append("invoiceId", getInvoiceId())
                .append("invoiceMoney", getInvoiceMoney())
                .append("invoiceNomoney", getInvoiceNomoney())
                .append("invoiceCode", getInvoiceCode())
                .append("invoiceTime", getInvoiceTime())
                .append("remarks", getRemarks())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
