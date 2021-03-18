package com.ruoyi.contract.contractInfo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.contract.contractContent.domain.CtBuContractContent;
import com.ruoyi.contract.contractIncomeType.domain.CtBuContractIncomeType;
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 合同信息录入主对象 ct_bu_contract
 *
 * @author ruoyi
 * @date 2020-12-08
 */
public class CtBuContractVo extends BaseEntity {
    private static final long serialVersionUID = 1L;


    /**
     * $column.columnComment
     */
    private String id;


    /**
     * 项目类别名称
     */
//    @Excel(name = "项目类别")
    private String projectCategoryName;


    /**
     * 项目编号
     */
//    @Excel(name = "项目编号")
    private String projectNo;

    /**
     * 项目名称
     */
//    @Excel(name = "项目名称")
    private String projectName;

    /**
     * 合同编号
     */
    @Excel(name = "合同编号")
    private String contractNo;

    /**
     * 合同名称
     */
    @Excel(name = "合同名称")
    private String contractName;

    /**
     * 合同类别名称
     */
    @Excel(name = "合同类别名称")
    private String contractCategoryName;

    /**
     * 对方单位名称
     */
    @Excel(name = "对方单位名称")
    private String oppositeName;


    /**
     * 我方单位名称
     */
    @Excel(name = "我方单位名称")
    private String ourName;


    /**
     * 合同签订日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date starttime;


    /**
     * 合同标的额
     */
    @Excel(name = "合同金额")
    private BigDecimal totalMoney;

    /**
     * 税率
     */
    @Excel(name = "税率")
    private BigDecimal taxrate;

    /**
     * 不含税金额
     */
    @Excel(name = "不含税金额")
    private BigDecimal notTaxMoney;


    /**
     * 付款方式名称
     */
    @Excel(name = "付款方式名称")
    private String payMethodName;


    /**
     * 经办部门名称
     */
    @Excel(name = "经办部门")
    private String manageDeptmentName;

    /**
     * 经办人姓名
     */
    @Excel(name = "经办人")
    private String manageUserName;

    /**
     * 状态说明
     */
    @Excel(name = "状态说明")
    private String statusPs;


    /**
     * 是否归档
     */
    private Integer isArchive;

    @Excel(name = "是否归档")
    private String isArchiveName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractCategoryName() {
        return contractCategoryName;
    }

    public void setContractCategoryName(String contractCategoryName) {
        this.contractCategoryName = contractCategoryName;
    }

    public String getOppositeName() {
        return oppositeName;
    }

    public void setOppositeName(String oppositeName) {
        this.oppositeName = oppositeName;
    }

    public String getOurName() {
        return ourName;
    }

    public void setOurName(String ourName) {
        this.ourName = ourName;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getNotTaxMoney() {
        return notTaxMoney;
    }

    public void setNotTaxMoney(BigDecimal notTaxMoney) {
        this.notTaxMoney = notTaxMoney;
    }

    public String getPayMethodName() {
        return payMethodName;
    }

    public void setPayMethodName(String payMethodName) {
        this.payMethodName = payMethodName;
    }

    public String getManageDeptmentName() {
        return manageDeptmentName;
    }

    public void setManageDeptmentName(String manageDeptmentName) {
        this.manageDeptmentName = manageDeptmentName;
    }

    public String getManageUserName() {
        return manageUserName;
    }

    public void setManageUserName(String manageUserName) {
        this.manageUserName = manageUserName;
    }

    public String getStatusPs() {
        return statusPs;
    }

    public void setStatusPs(String statusPs) {
        this.statusPs = statusPs;
    }

    public Integer getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Integer isArchive) {
        this.isArchive = isArchive;
    }

    public String getIsArchiveName() {
        return isArchiveName;
    }

    public void setIsArchiveName(String isArchiveName) {
        this.isArchiveName = isArchiveName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("projectNo", getProjectNo())
                .append("projectName", getProjectName())
                .append("contractNo", getContractNo())
                .append("contractName", getContractName())
                .append("oppositeName", getOppositeName())
                .append("ourName", getOurName())
                .append("starttime", getStarttime())
                .append("totalMoney", getTotalMoney())
                .append("taxrate", getTaxrate())
                .append("notTaxMoney", getNotTaxMoney())
                .append("statusPs", getStatusPs())
                .append("projectCategoryName", getProjectCategoryName())
                .append("contractCategoryName", getContractCategoryName())
                .append("payMethodName", getPayMethodName())
                .append("isArchive", getIsArchive())
                .toString();
    }
}
