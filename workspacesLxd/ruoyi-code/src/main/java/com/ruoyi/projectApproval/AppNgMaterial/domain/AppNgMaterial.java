package com.ruoyi.projectApproval.AppNgMaterial.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 事前审批明细(集客类-材料使用情况)对象 ct_bu_approvaldt_ng_material
 *
 * @author Mu
 * @date 2020-12-09
 */
public class AppNgMaterial extends BaseEntity {

    private static final long serialVersionUID = 1L;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    private String cid;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 申请编号
     */
    @Excel(name = "申请编号")
    private String bid;

    /**
     * 材料编码
     */
    @Excel(name = "材料编码")
    private String materialCode;

    /**
     * 材料名称
     */
    @Excel(name = "材料名称")
    private String materialName;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String materialUnit;

    /**
     * 单价
     */
    @Excel(name = "单价")
    private BigDecimal materialPrice;

    /**
     * 数量
     */
    @Excel(name = "数量")
    private BigDecimal materialMount;

    /**
     * 金额
     */
    @Excel(name = "金额")
    private BigDecimal materialAmount;

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

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBid() {
        return bid;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialPrice(BigDecimal materialPrice) {
        this.materialPrice = materialPrice;
    }

    public BigDecimal getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialMount(BigDecimal materialMount) {
        this.materialMount = materialMount;
    }

    public BigDecimal getMaterialMount() {
        return materialMount;
    }

    public void setMaterialAmount(BigDecimal materialAmount) {
        this.materialAmount = materialAmount;
    }

    public BigDecimal getMaterialAmount() {
        return materialAmount;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
                .append("createBy", getCreateBy()).append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("bid", getBid())
                .append("materialCode", getMaterialCode()).append("materialName", getMaterialName())
                .append("materialUnit", getMaterialUnit()).append("materialPrice", getMaterialPrice())
                .append("materialMount", getMaterialMount()).append("materialAmount", getMaterialAmount())
                .append("remarks", getRemarks()).append("delFlag", getDelFlag()).toString();
    }
}
