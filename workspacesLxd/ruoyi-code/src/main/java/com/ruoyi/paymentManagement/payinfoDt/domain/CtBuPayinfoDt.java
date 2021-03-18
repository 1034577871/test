package com.ruoyi.paymentManagement.payinfoDt.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 付款申请单明细对象 ct_bu_payinfo_dt
 *
 * @author ruoyi
 * @date 2021-01-12
 */
public class CtBuPayinfoDt extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 付款申请单主表
     */
    @Excel(name = "付款申请单主表")
    private String bid;

    /**
     * 收款记录ID
     */
    private String ticketRecordId;

    /**
     * 付款金额
     */
    @Excel(name = "付款金额")
    private BigDecimal payMoney;

    /**
     * 不含税金额
     */
    @Excel(name = "不含税金额")
    private BigDecimal notaxmoney;

    /**
     * 税额
     */
    @Excel(name = "税额")
    private BigDecimal taxmoney;

    /**
     * 删除标志
     */
    private String delFlag;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBid() {
        return bid;
    }

    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public BigDecimal getPayMoney() {
        return payMoney;
    }

    public void setNotaxmoney(BigDecimal notaxmoney) {
        this.notaxmoney = notaxmoney;
    }

    public BigDecimal getNotaxmoney() {
        return notaxmoney;
    }

    public void setTaxmoney(BigDecimal taxmoney) {
        this.taxmoney = taxmoney;
    }

    public BigDecimal getTaxmoney() {
        return taxmoney;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public String getTicketRecordId() {
        return ticketRecordId;
    }

    public void setTicketRecordId(String ticketRecordId) {
        this.ticketRecordId = ticketRecordId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("bid", getBid())
                .append("payMoney", getPayMoney())
                .append("notaxmoney", getNotaxmoney())
                .append("taxmoney", getTaxmoney())
                .append("delFlag", getDelFlag())
                .append("remark", getRemark())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
