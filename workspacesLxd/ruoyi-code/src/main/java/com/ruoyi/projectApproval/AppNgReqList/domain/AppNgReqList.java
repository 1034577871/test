package com.ruoyi.projectApproval.AppNgReqList.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @Title: AppNgReqList.java
 * @Description: 成本子类
 * @Author M.Mu
 * @Date 2020-12-18
 */
public class AppNgReqList extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一ID
     */
    private String id;

    /**
     * 所属事前审批ID
     */
    @Excel(name = "所属事前审批ID")
    private String pid;

    /**
     * 项目名称
     */
    @Excel(name = "项目名称")
    private String name;

    /**
     * 合同金额
     */
    @Excel(name = "合同金额")
    private BigDecimal money;

    /**
     * 税率
     */
    @Excel(name = "税率")
    private BigDecimal taxRate;

    /**
     * 不含税金额
     */
    @Excel(name = "不含税金额")
    private BigDecimal noTaxMoney;

    /**
     * 销项税额
     */
    @Excel(name = "销项税额")
    private BigDecimal incomeMoney;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remarks;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPid() {
        return pid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setNoTaxMoney(BigDecimal noTaxMoney) {
        this.noTaxMoney = noTaxMoney;
    }

    public BigDecimal getNoTaxMoney() {
        return noTaxMoney;
    }

    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId()).append("pid", getPid())
                .append("name", getName()).append("money", getMoney()).append("taxRate", getTaxRate())
                .append("noTaxMoney", getNoTaxMoney()).append("incomeMoney", getIncomeMoney())
                .append("remarks", getRemarks()).toString();
    }
}
