package com.ruoyi.paymentManagement.payinfo.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.paymentManagement.payinfoDt.domain.CtBuPayinfoDt;
import com.ruoyi.paymentManagement.ticketRecord.domain.TicketRecord;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 付款申请单主对象 ct_bu_payinfo
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
public class CtBuPayinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 唯一主键 */
    private String id;
    private String cbcId;
    @Excel(name = "合同编号")
    private String cbcContractNo;
    @Excel(name = "合同名称")
    private String cbcContractName;
    @Excel(name = "项目编号")
    private String projectNo;
    @Excel(name = "项目名称")
    private String projectName;
    @Excel(name = "对方单位名称")
    private String cbcOppositeName;

    /** 项目编号 */
//    @Excel(name = "项目编号")
    private String proNo;

    /** 项目名称 */
//    @Excel(name = "项目名称")
    private String proName;

    /** 合同ID */
//    @Excel(name = "合同ID")
    private String contractId;

    /** 合同编号 */
//    @Excel(name = "合同编号")
    private String contractNo;

    /** 合同名称 */
//    @Excel(name = "合同名称")
    private String contractName;

    /** 付款类型 */
    @Excel(name = "付款类型")
    private String paytype;

    /** 付款金额 */
    @Excel(name = "付款金额")
    private BigDecimal paymoney;

    /** 不含税金额 */
    @Excel(name = "不含税金额")
    private BigDecimal ntaxmoney;

    /** 税额 */
    @Excel(name = "税额")
    private BigDecimal taxmoney;

    /** 对方单位名称 */
//    @Excel(name = "对方单位名称")
    private String oppositeName;

    /** 对方单位银行账户 */
//    @Excel(name = "对方单位银行账户")
    private String oppositeBank;

    /** 对方单位银行账号 */
//    @Excel(name = "对方单位银行账号")
    private String oppositeBankId;

    /** 对方单位联系人 */
    @Excel(name = "对方单位联系人")
    private String oppositeContacts;

    /** 对方单位联系电话 */
//    @Excel(name = "对方单位联系电话")
    private String oppositePhone;

    /** 对方单位联系地址 */
//    @Excel(name = "对方单位联系地址")
    private String oppositeAddress;

    /** 影像资料 */
//    @Excel(name = "影像资料")
    private String imageData;

    /** 状态 */
//    @Excel(name = "状态")
    private Integer status;

    /** 状态说明 */
    @Excel(name = "状态说明")
    private String statusps;

    /** 删除标志 */
    private String delFlag;

    /** 核销人编号 */
//    @Excel(name = "核销人编号")
    private String writeOffUserid;

    /** 核销人姓名 */
    @Excel(name = "核销人姓名")
    private String writeOffUsername;

    /**
     * 核销时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date writeOffTime;

    /**
     * 付款时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date paymentTime;

    /**
     * 付款凭证
     */
    private String paymentEvidence;

    /** 实例ID */
    @Excel(name = "实例ID")
    private String instanceId;

    /**
     * 申请金额
     */
    private BigDecimal appliedAmount;

    /**
     * 申请人姓名
     */
    private String applicant;

    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applicationTime;

    /**
     * 付款人
     */
    private String payer;

    /**
     * 已申请金额
     */
    private BigDecimal haveAppliedAmount;

    private List<CtBuPayinfoDt> ctBuPayinfoDtList;

    private List<TicketRecord> ticketRecordList;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setProNo(String proNo) 
    {
        this.proNo = proNo;
    }

    public String getProNo() 
    {
        return proNo;
    }
    public void setProName(String proName) 
    {
        this.proName = proName;
    }

    public String getProName() 
    {
        return proName;
    }
    public void setContractId(String contractId) 
    {
        this.contractId = contractId;
    }

    public String getContractId() 
    {
        return contractId;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setContractName(String contractName) 
    {
        this.contractName = contractName;
    }

    public String getContractName() 
    {
        return contractName;
    }
    public void setPaytype(String paytype)
    {
        this.paytype = paytype;
    }

    public String getPaytype()
    {
        return paytype;
    }
    public void setPaymoney(BigDecimal paymoney) 
    {
        this.paymoney = paymoney;
    }

    public BigDecimal getPaymoney() 
    {
        return paymoney;
    }
    public void setNtaxmoney(BigDecimal ntaxmoney) 
    {
        this.ntaxmoney = ntaxmoney;
    }

    public BigDecimal getNtaxmoney() 
    {
        return ntaxmoney;
    }
    public void setTaxmoney(BigDecimal taxmoney) 
    {
        this.taxmoney = taxmoney;
    }

    public BigDecimal getTaxmoney() 
    {
        return taxmoney;
    }
    public void setOppositeName(String oppositeName) 
    {
        this.oppositeName = oppositeName;
    }

    public String getOppositeName() 
    {
        return oppositeName;
    }
    public void setOppositeBank(String oppositeBank) 
    {
        this.oppositeBank = oppositeBank;
    }

    public String getOppositeBank() 
    {
        return oppositeBank;
    }
    public void setOppositeBankId(String oppositeBankId) 
    {
        this.oppositeBankId = oppositeBankId;
    }

    public String getOppositeBankId() 
    {
        return oppositeBankId;
    }
    public void setOppositeContacts(String oppositeContacts) 
    {
        this.oppositeContacts = oppositeContacts;
    }

    public String getOppositeContacts() 
    {
        return oppositeContacts;
    }
    public void setOppositePhone(String oppositePhone) 
    {
        this.oppositePhone = oppositePhone;
    }

    public String getOppositePhone() 
    {
        return oppositePhone;
    }
    public void setOppositeAddress(String oppositeAddress) 
    {
        this.oppositeAddress = oppositeAddress;
    }

    public String getOppositeAddress() 
    {
        return oppositeAddress;
    }
    public void setImageData(String imageData) 
    {
        this.imageData = imageData;
    }

    public String getImageData() 
    {
        return imageData;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setStatusps(String statusps) 
    {
        this.statusps = statusps;
    }

    public String getStatusps() 
    {
        return statusps;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setWriteOffUserid(String writeOffUserid) 
    {
        this.writeOffUserid = writeOffUserid;
    }

    public String getWriteOffUserid() 
    {
        return writeOffUserid;
    }
    public void setWriteOffUsername(String writeOffUsername) 
    {
        this.writeOffUsername = writeOffUsername;
    }

    public String getWriteOffUsername() 
    {
        return writeOffUsername;
    }
    public void setInstanceId(String instanceId) 
    {
        this.instanceId = instanceId;
    }

    public String getInstanceId() 
    {
        return instanceId;
    }

    public List<CtBuPayinfoDt> getCtBuPayinfoDtList() {
        return ctBuPayinfoDtList;
    }

    public void setCtBuPayinfoDtList(List<CtBuPayinfoDt> ctBuPayinfoDtList) {
        this.ctBuPayinfoDtList = ctBuPayinfoDtList;
    }

    public Date getWriteOffTime() {
        return writeOffTime;
    }

    public void setWriteOffTime(Date writeOffTime) {
        this.writeOffTime = writeOffTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPaymentEvidence() {
        return paymentEvidence;
    }

    public void setPaymentEvidence(String paymentEvidence) {
        this.paymentEvidence = paymentEvidence;
    }

    public BigDecimal getAppliedAmount() {
        return appliedAmount;
    }

    public void setAppliedAmount(BigDecimal appliedAmount) {
        this.appliedAmount = appliedAmount;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public List<TicketRecord> getTicketRecordList() {
        return ticketRecordList;
    }

    public void setTicketRecordList(List<TicketRecord> ticketRecordList) {
        this.ticketRecordList = ticketRecordList;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getCbcId() {
        return cbcId;
    }

    public void setCbcId(String cbcId) {
        this.cbcId = cbcId;
    }

    public String getCbcContractNo() {
        return cbcContractNo;
    }

    public void setCbcContractNo(String cbcContractNo) {
        this.cbcContractNo = cbcContractNo;
    }

    public String getCbcContractName() {
        return cbcContractName;
    }

    public void setCbcContractName(String cbcContractName) {
        this.cbcContractName = cbcContractName;
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

    public String getCbcOppositeName() {
        return cbcOppositeName;
    }

    public void setCbcOppositeName(String cbcOppositeName) {
        this.cbcOppositeName = cbcOppositeName;
    }

    public BigDecimal getHaveAppliedAmount() {
        return haveAppliedAmount;
    }

    public void setHaveAppliedAmount(BigDecimal haveAppliedAmount) {
        this.haveAppliedAmount = haveAppliedAmount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("proNo", getProNo())
            .append("proName", getProName())
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("contractName", getContractName())
            .append("paytype", getPaytype())
            .append("paymoney", getPaymoney())
            .append("ntaxmoney", getNtaxmoney())
            .append("taxmoney", getTaxmoney())
            .append("oppositeName", getOppositeName())
            .append("oppositeBank", getOppositeBank())
            .append("oppositeBankId", getOppositeBankId())
            .append("oppositeContacts", getOppositeContacts())
            .append("oppositePhone", getOppositePhone())
            .append("oppositeAddress", getOppositeAddress())
            .append("imageData", getImageData())
            .append("status", getStatus())
            .append("statusps", getStatusps())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("writeOffUserid", getWriteOffUserid())
            .append("writeOffUsername", getWriteOffUsername())
            .append("instanceId", getInstanceId())
            .toString();
    }
}
