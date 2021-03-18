package com.ruoyi.contract.contractInfo.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.contract.contractContent.domain.CtBuContractContent;
import com.ruoyi.contract.contractIncomeType.domain.CtBuContractIncomeType;
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合同信息录入主对象 ct_bu_contract
 *
 * @author ruoyi
 * @date 2020-12-08
 */
public class CtBuContract extends BaseEntity {
    private static final long serialVersionUID = 1L;


    private int isOldCon;

    public int getIsOldCon() {
        return isOldCon;
    }

    public void setIsOldCon(int isOldCon) {
        this.isOldCon = isOldCon;
    }

    private String cbanId;
    @Excel(name = "项目编号")
    private String cbanReqNo;
    @Excel(name = "项目名称")
    private String cbanProName;
//    @Excel(name = "项目类别")
    private String cbanProType;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 项目类别1:集客类 2:非集客类
     */
//    @Excel(name = "项目类别 1:集客类 2:非集客类")
    private Integer projectCategory;

    /**
     * 项目类别名称
     */
    @Excel(name = "项目类别")
    private String projectCategoryName;


    /**
     * 项目ID
     */
//    @Excel(name = "项目ID")
    private String projectId;

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
     * 月份
     */
//    @Excel(name = "月份")
    private String month;

    /**
     * 合同类别
     */
//    @Excel(name = "合同类别")
    private String contractCategory;

    /**
     * 合同类别名称
     */
    @Excel(name = "合同类别名称")
    private String contractCategoryName;

    /**
     * 收入类型（一次性、分期）
     */
//    @Excel(name = "收入类型", readConverterExp = "一=次性、分期")
    private String incomeType;

    /**
     * 对方单位名称
     */
    @Excel(name = "对方单位名称")
    private String oppositeName;

    /**
     * 对方单位银行账户
     */
//    @Excel(name = "对方单位银行账户")
    private String oppositeBank;

    /**
     * 对方单位银行账号
     */
//    @Excel(name = "对方单位银行账号")
    private String oppositeBankId;

    /**
     * 对方单位联系人
     */
//    @Excel(name = "对方单位联系人")
    private String oppositeContacts;

    /**
     * 对方单位联系电话
     */
//    @Excel(name = "对方单位联系电话")
    private String oppositePhone;

    /**
     * 对方单位联系地址
     */
//    @Excel(name = "对方单位联系地址")
    private String oppositeAddress;

    /**
     * 对方单位纳税人识别号
     */
    private String oppositeCreditCode;

    /**
     * 我方单位名称
     */
    @Excel(name = "我方单位名称")
    private String ourName;

    /**
     * 我方单位联系人
     */
//    @Excel(name = "我方单位联系人")
    private String ourContacts;

    /**
     * 我方单位联系电话
     */
//    @Excel(name = "我方单位联系电话")
    private String ourPhone;

    /**
     * 我方单位银行账户
     */
//    @Excel(name = "我方单位银行账户")
    private String ourBank;

    /**
     * 我方单位银行账号
     */
//    @Excel(name = "我方单位银行账号")
    private String ourBankId;

    /**
     * 我方单位联系地址
     */
//    @Excel(name = "我方单位联系地址")
    private String ourAddress;

    /**
     * 合同签订日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同签订日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date starttime;

    /**
     * 合同截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "合同截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /**
     * 合同服务开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "合同服务开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractServeStart;

    /**
     * 服务期限
     */
//    @Excel(name = "服务期限")
    private Integer serviceTerm;

    /**
     * 合同服务截止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Excel(name = "合同服务截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date contractServeEnd;

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
     * 付款方式
     */
//    @Excel(name = "付款方式")
    private String payMethod;

    /**
     * 付款方式名称
     */
    @Excel(name = "付款方式名称")
    private String payMethodName;

    /**
     * 合同归档资料
     */
//    @Excel(name = "合同归档资料")
    private String archiveFiles;

    /**
     * 分公司ID
     */
    private String manageCompany;

    /**
     * 分公司名称
     */
    private String manageCompanyName;

    /**
     * 经办部门
     */
//    @Excel(name = "经办部门")
    private String manageDeptment;

    /**
     * 经办部门名称
     */
    @Excel(name = "经办部门")
    private String manageDeptmentName;

    /**
     * 经办人
     */
//    @Excel(name = "经办人")
    private String manageUser;

    /**
     * 经办人姓名
     */
    @Excel(name = "经办人")
    private String manageUserName;

    /**
     * 变更之前ID
     */
//    @Excel(name = "变更之前ID")
    private String originalId;

    /**
     * 状态
     */
//    @Excel(name = "状态")
    private Integer status;

    /**
     * 状态说明
     */
    @Excel(name = "状态说明")
    private String statusPs;

    /**
     * 合同扫描件
     */
//    @Excel(name = "合同扫描件")
    private String contractScanningFile;

    /**
     * 合同签订审批流程附件
     */
//    @Excel(name = "合同签订审批流程附件")
    private String contractApprovalFile;

    /**
     * 其他附件
     */
//    @Excel(name = "其他附件")
    private String otherFiles;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 备注信息
     */
//    @Excel(name = "备注信息")
    private String remarks;

    /**
     * 已收金额
     */
//    @Excel(name = "已收金额")
    private BigDecimal receiveAmount;

    /**
     * 未收金额
     */
//    @Excel(name = "未收金额")
    private BigDecimal outstandingAmount;

    /**
     * 已核销金额
     */
//    @Excel(name = "已核销金额")
    private BigDecimal writeOffAmount;

    /**
     * 未核销金额
     */
//    @Excel(name = "未核销金额")
    private BigDecimal nwriteOffAmount;


    /**
     * 合同内容对象
     */
//    @Excel(name = "合同内容对象")
    private List<CtBuContractContent> ctBuContractContentList;

    /**
     * 合同付款对象
     */
//    @Excel(name = "合同付款对象")
    private List<CtBuContractPayinfo> ctBuContractPayinfoList;

    private List<CtBuContractIncomeType> ctBuContractIncomeTypeList;

    /**
     * 实例ID
     */
    private String instanceId;

    /**
     * 终止时间
     */
    private Date expiryDate;

    private Date endtime1;
    private Date endtime2;

    private Date contractServeStart1;
    private Date contractServeStart2;

    private Date contractServeEnd1;
    private Date contractServeEnd2;


    private String cbcpId;
    private Date estimateTime;

    private BigDecimal estimateMoney;

    private BigDecimal actualMoney;

    /**
     * 是否归档
     */
    private Integer isArchive;
    /**
     * 最终归档资料
     */
    private String finalArchiveFile;
    /**
     * 未归档原因
     */
    private String unfinishedArchiveCause;

    /**
     * 是否为虚拟合同(1=是,2=否)
     */
    private Integer isVirtual;

    private String contractNo1;
    private String contractNo2;
    private String contractNo3;
    private String contractNo4;


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setProjectCategory(Integer projectCategory) {
        this.projectCategory = projectCategory;
    }

    public Integer getProjectCategory() {
        return projectCategory;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractName() {
        return contractName;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setContractCategory(String contractCategory) {
        this.contractCategory = contractCategory;
    }

    public String getContractCategory() {
        return contractCategory;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setOppositeName(String oppositeName) {
        this.oppositeName = oppositeName;
    }

    public String getOppositeName() {
        return oppositeName;
    }

    public void setOppositeBank(String oppositeBank) {
        this.oppositeBank = oppositeBank;
    }

    public String getOppositeBank() {
        return oppositeBank;
    }

    public void setOppositeBankId(String oppositeBankId) {
        this.oppositeBankId = oppositeBankId;
    }

    public String getOppositeBankId() {
        return oppositeBankId;
    }

    public void setOppositeContacts(String oppositeContacts) {
        this.oppositeContacts = oppositeContacts;
    }

    public String getOppositeContacts() {
        return oppositeContacts;
    }

    public void setOppositePhone(String oppositePhone) {
        this.oppositePhone = oppositePhone;
    }

    public String getOppositePhone() {
        return oppositePhone;
    }

    public void setOppositeAddress(String oppositeAddress) {
        this.oppositeAddress = oppositeAddress;
    }

    public String getOppositeAddress() {
        return oppositeAddress;
    }

    public void setOurName(String ourName) {
        this.ourName = ourName;
    }

    public String getOurName() {
        return ourName;
    }

    public void setOurContacts(String ourContacts) {
        this.ourContacts = ourContacts;
    }

    public String getOurContacts() {
        return ourContacts;
    }

    public void setOurPhone(String ourPhone) {
        this.ourPhone = ourPhone;
    }

    public String getOurPhone() {
        return ourPhone;
    }

    public void setOurBank(String ourBank) {
        this.ourBank = ourBank;
    }

    public String getOurBank() {
        return ourBank;
    }

    public void setOurBankId(String ourBankId) {
        this.ourBankId = ourBankId;
    }

    public String getOurBankId() {
        return ourBankId;
    }

    public void setOurAddress(String ourAddress) {
        this.ourAddress = ourAddress;
    }

    public String getOurAddress() {
        return ourAddress;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setContractServeStart(Date contractServeStart) {
        this.contractServeStart = contractServeStart;
    }

    public Date getContractServeStart() {
        return contractServeStart;
    }

    public void setServiceTerm(Integer serviceTerm) {
        this.serviceTerm = serviceTerm;
    }

    public Integer getServiceTerm() {
        return serviceTerm;
    }

    public void setContractServeEnd(Date contractServeEnd) {
        this.contractServeEnd = contractServeEnd;
    }

    public Date getContractServeEnd() {
        return contractServeEnd;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setNotTaxMoney(BigDecimal notTaxMoney) {
        this.notTaxMoney = notTaxMoney;
    }

    public BigDecimal getNotTaxMoney() {
        return notTaxMoney;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setArchiveFiles(String archiveFiles) {
        this.archiveFiles = archiveFiles;
    }

    public String getArchiveFiles() {
        return archiveFiles;
    }

    public void setManageDeptment(String manageDeptment) {
        this.manageDeptment = manageDeptment;
    }

    public String getManageDeptment() {
        return manageDeptment;
    }

    public void setManageUser(String manageUser) {
        this.manageUser = manageUser;
    }

    public String getManageUser() {
        return manageUser;
    }

    public void setOriginalId(String originalId) {
        this.originalId = originalId;
    }

    public String getOriginalId() {
        return originalId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatusPs(String statusPs) {
        this.statusPs = statusPs;
    }

    public String getStatusPs() {
        return statusPs;
    }

    public void setContractScanningFile(String contractScanningFile) {
        this.contractScanningFile = contractScanningFile;
    }

    public String getContractScanningFile() {
        return contractScanningFile;
    }

    public void setContractApprovalFile(String contractApprovalFile) {
        this.contractApprovalFile = contractApprovalFile;
    }

    public String getContractApprovalFile() {
        return contractApprovalFile;
    }

    public void setOtherFiles(String otherFiles) {
        this.otherFiles = otherFiles;
    }

    public String getOtherFiles() {
        return otherFiles;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setCtBuContractContentList(List<CtBuContractContent> ctBuContractContentList) {
        this.ctBuContractContentList = ctBuContractContentList;
    }

    public List<CtBuContractContent> getCtBuContractContentList() {
        return ctBuContractContentList;
    }

    public void setCtBuContractPayinfoList(List<CtBuContractPayinfo> ctBuContractPayinfoList) {
        this.ctBuContractPayinfoList = ctBuContractPayinfoList;
    }

    public List<CtBuContractPayinfo> getCtBuContractPayinfoList() {
        return ctBuContractPayinfoList;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public BigDecimal getWriteOffAmount() {
        return writeOffAmount;
    }

    public BigDecimal getNwriteOffAmount() {
        return nwriteOffAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public void setWriteOffAmount(BigDecimal writeOffAmount) {
        this.writeOffAmount = writeOffAmount;
    }

    public void setNwriteOffAmount(BigDecimal nwriteOffAmount) {
        this.nwriteOffAmount = nwriteOffAmount;
    }


    public Date getEstimateTime() {
        return estimateTime;
    }

    public BigDecimal getEstimateMoney() {
        return estimateMoney;
    }

    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }

    public void setEstimateMoney(BigDecimal estimateMoney) {
        this.estimateMoney = estimateMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getCbcpId() {
        return cbcpId;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    public String getContractCategoryName() {
        return contractCategoryName;
    }

    public void setContractCategoryName(String contractCategoryName) {
        this.contractCategoryName = contractCategoryName;
    }

    public String getPayMethodName() {
        return payMethodName;
    }

    public void setPayMethodName(String payMethodName) {
        this.payMethodName = payMethodName;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getOppositeCreditCode() {
        return oppositeCreditCode;
    }

    public void setOppositeCreditCode(String oppositeCreditCode) {
        this.oppositeCreditCode = oppositeCreditCode;
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

    public String getManageCompany() {
        return manageCompany;
    }

    public void setManageCompany(String manageCompany) {
        this.manageCompany = manageCompany;
    }

    public String getManageCompanyName() {
        return manageCompanyName;
    }

    public void setManageCompanyName(String manageCompanyName) {
        this.manageCompanyName = manageCompanyName;
    }

    public Date getEndtime1() {
        return endtime1;
    }

    public void setEndtime1(Date endtime1) {
        this.endtime1 = endtime1;
    }

    public Date getEndtime2() {
        return endtime2;
    }

    public void setEndtime2(Date endtime2) {
        this.endtime2 = endtime2;
    }

    public Date getContractServeStart1() {
        return contractServeStart1;
    }

    public void setContractServeStart1(Date contractServeStart1) {
        this.contractServeStart1 = contractServeStart1;
    }

    public Date getContractServeStart2() {
        return contractServeStart2;
    }

    public void setContractServeStart2(Date contractServeStart2) {
        this.contractServeStart2 = contractServeStart2;
    }

    public Date getContractServeEnd1() {
        return contractServeEnd1;
    }

    public void setContractServeEnd1(Date contractServeEnd1) {
        this.contractServeEnd1 = contractServeEnd1;
    }

    public Date getContractServeEnd2() {
        return contractServeEnd2;
    }

    public void setContractServeEnd2(Date contractServeEnd2) {
        this.contractServeEnd2 = contractServeEnd2;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<CtBuContractIncomeType> getCtBuContractIncomeTypeList() {
        return ctBuContractIncomeTypeList;
    }

    public void setCtBuContractIncomeTypeList(List<CtBuContractIncomeType> ctBuContractIncomeTypeList) {
        this.ctBuContractIncomeTypeList = ctBuContractIncomeTypeList;
    }

    public String getCbanId() {
        return cbanId;
    }

    public void setCbanId(String cbanId) {
        this.cbanId = cbanId;
    }

    public String getCbanReqNo() {
        return cbanReqNo;
    }

    public void setCbanReqNo(String cbanReqNo) {
        this.cbanReqNo = cbanReqNo;
    }

    public String getCbanProName() {
        return cbanProName;
    }

    public void setCbanProName(String cbanProName) {
        this.cbanProName = cbanProName;
    }

    public String getCbanProType() {
        return cbanProType;
    }

    public void setCbanProType(String cbanProType) {
        this.cbanProType = cbanProType;
    }

    public Integer getIsArchive() {
        return isArchive;
    }

    public void setIsArchive(Integer isArchive) {
        this.isArchive = isArchive;
    }

    public String getFinalArchiveFile() {
        return finalArchiveFile;
    }

    public void setFinalArchiveFile(String finalArchiveFile) {
        this.finalArchiveFile = finalArchiveFile;
    }

    public String getUnfinishedArchiveCause() {
        return unfinishedArchiveCause;
    }

    public void setUnfinishedArchiveCause(String unfinishedArchiveCause) {
        this.unfinishedArchiveCause = unfinishedArchiveCause;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getContractNo1() {
        return contractNo1;
    }

    public void setContractNo1(String contractNo1) {
        this.contractNo1 = contractNo1;
    }

    public String getContractNo2() {
        return contractNo2;
    }

    public void setContractNo2(String contractNo2) {
        this.contractNo2 = contractNo2;
    }

    public String getContractNo3() {
        return contractNo3;
    }

    public void setContractNo3(String contractNo3) {
        this.contractNo3 = contractNo3;
    }

    public String getContractNo4() {
        return contractNo4;
    }

    public void setContractNo4(String contractNo4) {
        this.contractNo4 = contractNo4;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("projectCategory", getProjectCategory())
                .append("projectId", getProjectId())
                .append("projectNo", getProjectNo())
                .append("projectName", getProjectName())
                .append("contractNo", getContractNo())
                .append("contractName", getContractName())
                .append("month", getMonth())
                .append("contractCategory", getContractCategory())
                .append("incomeType", getIncomeType())
                .append("oppositeName", getOppositeName())
                .append("oppositeBank", getOppositeBank())
                .append("oppositeBankId", getOppositeBankId())
                .append("oppositeContacts", getOppositeContacts())
                .append("oppositePhone", getOppositePhone())
                .append("oppositeAddress", getOppositeAddress())
                .append("ourName", getOurName())
                .append("ourContacts", getOurContacts())
                .append("ourPhone", getOurPhone())
                .append("ourBank", getOurBank())
                .append("ourBankId", getOurBankId())
                .append("ourAddress", getOurAddress())
                .append("starttime", getStarttime())
                .append("endtime", getEndtime())
                .append("contractServeStart", getContractServeStart())
                .append("serviceTerm", getServiceTerm())
                .append("contractServeEnd", getContractServeEnd())
                .append("totalMoney", getTotalMoney())
                .append("taxrate", getTaxrate())
                .append("notTaxMoney", getNotTaxMoney())
                .append("payMethod", getPayMethod())
                .append("archiveFiles", getArchiveFiles())
                .append("manageDeptment", getManageDeptment())
                .append("manageUser", getManageUser())
                .append("originalId", getOriginalId())
                .append("status", getStatus())
                .append("statusPs", getStatusPs())
                .append("contractScanningFile", getContractScanningFile())
                .append("receiveAmount", getReceiveAmount())
                .append("contractApprovalFile", getContractApprovalFile())
                .append("outstandingAmount", getOutstandingAmount())
                .append("writeOffAmount", getWriteOffAmount())
                .append("otherFiles", getOtherFiles())
                .append("delFlag", getDelFlag())
                .append("nwriteOffAmount", getNwriteOffAmount())
                .append("remarks", getRemarks())
                .append("projectCategoryName", getProjectCategoryName())
                .append("contractCategoryName", getContractCategoryName())
                .append("payMethodName", getPayMethodName())
                .append("oppositeCreditCode", getOppositeCreditCode())
                .append("instanceId", getInstanceId())
                .append("isArchive", getIsArchive())
                .toString();
    }
}
