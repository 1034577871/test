package com.ruoyi.contract.contractContent.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;

/**
 * 合同内容对象 ct_bu_contract_content
 *
 * @author ruoyi
 * @date 2020-12-09
 */
public class CtBuContractContent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 合同编号
     */
    @Excel(name = "合同编号")
    private String contractId;

    /**
     * 项目类型
     */
    @Excel(name = "项目类型")
    private String contentType;

    /**
     * 类型税率
     */
    @Excel(name = "类型税率")
    private BigDecimal contentTaxrate;

    /**
     * 类型名称
     */
    @Excel(name = "类型名称")
    private String contentName;

    /**
     * 含税金额
     */
    @Excel(name = "含税金额")
    private BigDecimal intaxAmount;

    /**
     * 不含税金额
     */
    @Excel(name = "不含税金额")
    private BigDecimal extaxAmount;

    /**
     * 删除标志
     */
    private Integer delFlag;
    /**
     * 备注
     */
    private String remark;

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

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentTaxrate(BigDecimal contentTaxrate) {
        this.contentTaxrate = contentTaxrate;
    }

    public BigDecimal getContentTaxrate() {
        return contentTaxrate;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public String getContentName() {
        return contentName;
    }

    public void setIntaxAmount(BigDecimal intaxAmount) {
        this.intaxAmount = intaxAmount;
    }

    public BigDecimal getIntaxAmount() {
        return intaxAmount;
    }

    public void setExtaxAmount(BigDecimal extaxAmount) {
        this.extaxAmount = extaxAmount;
    }

    public BigDecimal getExtaxAmount() {
        return extaxAmount;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
                .append("contentType", getContentType())
                .append("contentTaxrate", getContentTaxrate())
                .append("contentName", getContentName())
                .append("intaxAmount", getIntaxAmount())
                .append("extaxAmount", getExtaxAmount())
                .append("delFlag", getDelFlag())
                .append("remark", getRemark())
                .toString();
    }
}
