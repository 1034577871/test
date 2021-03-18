package com.ruoyi.collection.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 发票申请对象 ct_bu_invoice_req
 * 
 * @author ruoyi
 * @date 2020-12-09
 */

public class CtBuInvoiceReqDto extends BaseEntity
{
    private static final long serialVersionUID = 1L;


    public int getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(int isVirtual) {
        this.isVirtual = isVirtual;
    }

    private int isVirtual;
    public List<CtBuContractPayinfo> getCtBuContractPayinfos() {
        return ctBuContractPayinfos;
    }

    public void setCtBuContractPayinfos(List<CtBuContractPayinfo> ctBuContractPayinfos) {
        this.ctBuContractPayinfos = ctBuContractPayinfos;
    }

    private List<CtBuContractPayinfo> ctBuContractPayinfos;
    private String payinfoid;

    public String getPayinfoid() {
        return payinfoid;
    }

    public void setPayinfoid(String payinfoid) {
        this.payinfoid = payinfoid;
    }

    public String getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(String paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    private String paymentPeriod;
    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getZmcl() {
        return zmcl;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    private String pid;
    public void setZmcl(String zmcl) {
        this.zmcl = zmcl;
    }

    private String ifysk;
    private String yskid;

    public String getIfysk() {
        return ifysk;
    }

    public void setIfysk(String ifysk) {
        this.ifysk = ifysk;
    }

    public String getYskid() {
        return yskid;
    }

    public void setYskid(String yskid) {
        this.yskid = yskid;
    }

    public String getYskamount() {
        return yskamount;
    }

    public void setYskamount(String yskamount) {
        this.yskamount = yskamount;
    }

    private String yskamount;
    private String zmcl;
    private String createByName;
    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    private String record;

    public String getInstanceId() {
        return instanceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String state;

    public String getInvoiceTaxrate() {
        return invoiceTaxrate;
    }

    public void setInvoiceTaxrate(String invoiceTaxrate) {
        this.invoiceTaxrate = invoiceTaxrate;
    }

    private String invoiceTaxrate;


    public List<ActWorkflowFormDatas> getActWorkflowFormData() {
        return actWorkflowFormData;
    }

    public void setActWorkflowFormData(List<ActWorkflowFormDatas> actWorkflowFormData) {
        this.actWorkflowFormData = actWorkflowFormData;
    }

    List<ActWorkflowFormDatas> actWorkflowFormData;
    public long getInvoiceMount() {
        return invoiceMount;
    }

    public void setInvoiceMount(long invoiceMount) {
        this.invoiceMount = invoiceMount;
    }

    public long invoiceMount;

    public List<CtBuInvoiceReqDetail> getCtBuInvoiceReqDetail() {
        return ctBuInvoiceReqDetail;
    }

    public void setCtBuInvoiceReqDetail(List<CtBuInvoiceReqDetail> ctBuInvoiceReqDetail) {
        this.ctBuInvoiceReqDetail = ctBuInvoiceReqDetail;
    }

    @Excel(name = "发票明细")
    private List<CtBuInvoiceReqDetail> ctBuInvoiceReqDetail;


    public String getContractCategory() {
        return contractCategory;
    }

    public void setContractCategory(String contractCategory) {
        this.contractCategory = contractCategory;
    }

    public String getContractCategoryName() {
        return contractCategoryName;
    }

    public void setContractCategoryName(String contractCategoryName) {
        this.contractCategoryName = contractCategoryName;
    }


    /** 合同类别 */
    private String contractCategory;
    /** 合同类别名称 */
    private String contractCategoryName;
    /** 流程实例 */
    private String instanceId;
    /** 主键 */
    private String id;

    /** 事前审批类型 1:集客类 2:非集客类 */
    @Excel(name = "事前审批类型 1:集客类 2:非集客类")
    private Integer approvalType;

    /** 事前审批表ID 关联事前审批表ID */
    @Excel(name = "事前审批表ID 关联事前审批表ID")
    private String approvalId;

    /** 项目编号自动关联 */
    @Excel(name = "项目编号自动关联")
    private String proNo;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String proName;

    /** 合同ID  */
    @Excel(name = "合同ID ")
    private String contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 发票种类  存储于系统字典表：增值税专票、增值税普票 */
    @Excel(name = "发票种类  存储于系统字典表：增值税专票、增值税普票")
    private String invoiceType;

    /** 申请部门编号 */
    @Excel(name = "申请部门编号")
    private String reqDeptid;

    /** 申请部门名称 */
    @Excel(name = "申请部门名称")
    private String reqDeptname;

    /** 申请人编号 */
    @Excel(name = "申请人编号")
    private String reqUserid;

    /** 申请人姓名 */
    @Excel(name = "申请人姓名")
    private String reqUsername;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reqDate;

    /** 付款单位名称 */
    @Excel(name = "付款单位名称")
    private String payerName;

    /** 纳税人识别号 */
    @Excel(name = "纳税人识别号")
    private String creditCode;

    /** 付款单位地址 */
    @Excel(name = "付款单位地址")
    private String payerAddress;

    /** 付款单位电话 */
    @Excel(name = "付款单位电话")
    private String payerPhone;

    /** 付款单位开户行 */
    @Excel(name = "付款单位开户行")
    private String payerOpeningBank;

    /** 付款单位账号 */
    @Excel(name = "付款单位账号")
    private String payerAccount;

    /** 开票金额（含税） */
    @Excel(name = "开票金额", readConverterExp = "含=税")
    private BigDecimal invoiceAmountTax;

    /** 开票金额（不含税） */
    @Excel(name = "开票金额", readConverterExp = "不=含税")
    private BigDecimal invoiceAmountNtax;

    /** 预计回款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计回款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedCollectionTime;

    /** 状态  0:保存1:提交2:审核通过3:审核驳回 */
    @Excel(name = "状态  0:保存1:提交2:审核通过3:审核驳回")
    private Integer status;

    /** 状态说明 */
    @Excel(name = "状态说明")
    private String statusps;

    /** 删除标志 */
    private String delFlag;


    private int isOldCon;

    public int getIsOldCon() {
        return isOldCon;
    }

    public void setIsOldCon(int isOldCon) {
        this.isOldCon = isOldCon;
    }

    //发票明细
    private String invoiceProName;
    private String invoiceSpec;

    private String invoiceTypes;
    private String unit;
    private BigDecimal invoicePrice;
    private BigDecimal invoiceAmountTaxs;

    public String getInvoiceProName() {
        return invoiceProName;
    }

    public void setInvoiceProName(String invoiceProName) {
        this.invoiceProName = invoiceProName;
    }

    public String getInvoiceSpec() {
        return invoiceSpec;
    }

    public void setInvoiceSpec(String invoiceSpec) {
        this.invoiceSpec = invoiceSpec;
    }

    public String getInvoiceTypes() {
        return invoiceTypes;
    }

    public void setInvoiceTypes(String invoiceTypes) {
        this.invoiceTypes = invoiceTypes;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(BigDecimal invoicePrice) {
        this.invoicePrice = invoicePrice;
    }


    public BigDecimal getInvoiceAmountTaxs() {
        return invoiceAmountTaxs;
    }

    public void setInvoiceAmountTaxs(BigDecimal invoiceAmountTaxs) {
        this.invoiceAmountTaxs = invoiceAmountTaxs;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    private BigDecimal invoiceAmount;


    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setApprovalType(Integer approvalType) 
    {
        this.approvalType = approvalType;
    }

    public Integer getApprovalType() 
    {
        return approvalType;
    }
    public void setApprovalId(String approvalId) 
    {
        this.approvalId = approvalId;
    }

    public String getApprovalId() 
    {
        return approvalId;
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
    public void setInvoiceType(String invoiceType) 
    {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceType() 
    {
        return invoiceType;
    }
    public void setReqDeptid(String reqDeptid) 
    {
        this.reqDeptid = reqDeptid;
    }

    public String getReqDeptid() 
    {
        return reqDeptid;
    }
    public void setReqDeptname(String reqDeptname) 
    {
        this.reqDeptname = reqDeptname;
    }

    public String getReqDeptname() 
    {
        return reqDeptname;
    }
    public void setReqUserid(String reqUserid) 
    {
        this.reqUserid = reqUserid;
    }

    public String getReqUserid() 
    {
        return reqUserid;
    }
    public void setReqUsername(String reqUsername) 
    {
        this.reqUsername = reqUsername;
    }

    public String getReqUsername() 
    {
        return reqUsername;
    }
    public void setReqDate(Date reqDate) 
    {
        this.reqDate = reqDate;
    }

    public Date getReqDate() 
    {
        return reqDate;
    }
    public void setPayerName(String payerName) 
    {
        this.payerName = payerName;
    }

    public String getPayerName() 
    {
        return payerName;
    }
    public void setCreditCode(String creditCode) 
    {
        this.creditCode = creditCode;
    }

    public String getCreditCode() 
    {
        return creditCode;
    }
    public void setPayerAddress(String payerAddress) 
    {
        this.payerAddress = payerAddress;
    }

    public String getPayerAddress() 
    {
        return payerAddress;
    }
    public void setPayerPhone(String payerPhone) 
    {
        this.payerPhone = payerPhone;
    }

    public String getPayerPhone() 
    {
        return payerPhone;
    }
    public void setPayerOpeningBank(String payerOpeningBank) 
    {
        this.payerOpeningBank = payerOpeningBank;
    }

    public String getPayerOpeningBank() 
    {
        return payerOpeningBank;
    }
    public void setPayerAccount(String payerAccount) 
    {
        this.payerAccount = payerAccount;
    }

    public String getPayerAccount() 
    {
        return payerAccount;
    }
    public void setInvoiceAmountTax(BigDecimal invoiceAmountTax) 
    {
        this.invoiceAmountTax = invoiceAmountTax;
    }

    public BigDecimal getInvoiceAmountTax() 
    {
        return invoiceAmountTax;
    }
    public void setInvoiceAmountNtax(BigDecimal invoiceAmountNtax) 
    {
        this.invoiceAmountNtax = invoiceAmountNtax;
    }

    public BigDecimal getInvoiceAmountNtax() 
    {
        return invoiceAmountNtax;
    }
    public void setExpectedCollectionTime(Date expectedCollectionTime) 
    {
        this.expectedCollectionTime = expectedCollectionTime;
    }

    public Date getExpectedCollectionTime() 
    {
        return expectedCollectionTime;
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




    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("approvalType", getApprovalType())
            .append("approvalId", getApprovalId())
            .append("proNo", getProNo())
            .append("proName", getProName())
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("contractName", getContractName())
            .append("invoiceType", getInvoiceType())
            .append("reqDeptid", getReqDeptid())
            .append("reqDeptname", getReqDeptname())
            .append("reqUserid", getReqUserid())
            .append("reqUsername", getReqUsername())
            .append("reqDate", getReqDate())
            .append("payerName", getPayerName())
            .append("creditCode", getCreditCode())
            .append("payerAddress", getPayerAddress())
            .append("payerPhone", getPayerPhone())
            .append("payerOpeningBank", getPayerOpeningBank())
            .append("payerAccount", getPayerAccount())
            .append("invoiceAmountTax", getInvoiceAmountTax())
            .append("invoiceAmountNtax", getInvoiceAmountNtax())
            .append("expectedCollectionTime", getExpectedCollectionTime())
            .append("status", getStatus())
            .append("statusps", getStatusps())
            .append("delFlag", getDelFlag())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
