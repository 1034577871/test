package com.ruoyi.collection.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 收款单录入对象 ct_bu_receipt_info
 *
 * @author ruoyi
 * @date 2020-12-10
 */
public class CtBuReceiptInfoDto extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    private String reqIds;

    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    private String deptId;

    public String getReqIds() {
        return reqIds;
    }

    public void setReqIds(String reqIds) {
        this.reqIds = reqIds;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    private String reqId;

    public String getStatuss() {
        return statuss;
    }

    public void setStatuss(String statuss) {
        this.statuss = statuss;
    }

    private String statuss;
    private String payType;

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    private String payTypeName;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    private String instanceId;

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    private String id_;

    public String getIds() {
        return ids;
    }
    public List<ActWorkflowFormDatas> getActWorkflowFormData() {
        return actWorkflowFormData;
    }

    public void setActWorkflowFormData(List<ActWorkflowFormDatas> actWorkflowFormData) {
        this.actWorkflowFormData = actWorkflowFormData;
    }

    List<ActWorkflowFormDatas> actWorkflowFormData;
    public void setIds(String ids) {
        this.ids = ids;
    }

    private String ids;

    public CtBuInvoiceReqVo getCtBuInvoiceReqVo() {
        return ctBuInvoiceReqVo;
    }

    public void setCtBuInvoiceReqVo(CtBuInvoiceReqVo ctBuInvoiceReqVo) {
        this.ctBuInvoiceReqVo = ctBuInvoiceReqVo;
    }

    private CtBuInvoiceReqVo ctBuInvoiceReqVo;
    public CtBuInvoiceInfo getCtBuInvoiceInfo() {
        return ctBuInvoiceInfo;
    }

    public CtBuInvoiceInfoVo getCtBuInvoiceInfoVo() {
        return ctBuInvoiceInfoVo;
    }

    public void setCtBuInvoiceInfoVo(CtBuInvoiceInfoVo ctBuInvoiceInfoVo) {
        this.ctBuInvoiceInfoVo = ctBuInvoiceInfoVo;
    }

    private CtBuInvoiceInfoVo ctBuInvoiceInfoVo;

    public void setCtBuInvoiceInfo(CtBuInvoiceInfo ctBuInvoiceInfo) {
        this.ctBuInvoiceInfo = ctBuInvoiceInfo;
    }

    //开票信息
    private CtBuInvoiceInfo ctBuInvoiceInfo;
    /** 主键 */
    private String id;

    /** 事前审批表ID */
    @Excel(name = "事前审批表ID")
    private String approvalId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String proNo;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String proName;

    /** 合同ID */
    @Excel(name = "合同ID")
    private String contractId;

    /** 合同编号 */
    @Excel(name = "合同编号")
    private String contractNo;

    /** 合同名称 */
    @Excel(name = "合同名称")
    private String contractName;

    /** 发票ID */
    @Excel(name = "发票ID")
    private String invoiceId;

    /** 发票代码 */
    @Excel(name = "发票代码")
    private String invoiceCode;

    /** 发票号码 */
    @Excel(name = "发票号码")
    private String invoiceNo;

    /** 回款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date collectionTime;

    /** 回款金额 */
    @Excel(name = "回款金额")
    private BigDecimal collectionAmount;

    /** 单据编号 */
    @Excel(name = "单据编号")
    private String documentNumber;

    /** 回款方式 */
    @Excel(name = "回款方式")
    private String paymentMethod;

    /** 银行单据 */
    @Excel(name = "银行单据")
    private String voucher;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 状态说明 */
    @Excel(name = "状态说明")
    private String statusps;

    /** 删除标志 */
    private String delFlag;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
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
    public void setInvoiceId(String invoiceId)
    {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceId()
    {
        return invoiceId;
    }
    public void setInvoiceCode(String invoiceCode)
    {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceCode()
    {
        return invoiceCode;
    }
    public void setInvoiceNo(String invoiceNo)
    {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceNo()
    {
        return invoiceNo;
    }
    public void setCollectionTime(Date collectionTime)
    {
        this.collectionTime = collectionTime;
    }

    public Date getCollectionTime()
    {
        return collectionTime;
    }
    public void setCollectionAmount(BigDecimal collectionAmount)
    {
        this.collectionAmount = collectionAmount;
    }

    public BigDecimal getCollectionAmount()
    {
        return collectionAmount;
    }
    public void setDocumentNumber(String documentNumber)
    {
        this.documentNumber = documentNumber;
    }

    public String getDocumentNumber()
    {
        return documentNumber;
    }
    public void setPaymentMethod(String paymentMethod)
    {
        this.paymentMethod = paymentMethod;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public String getPaymentMethod()
    {
        return paymentMethod;
    }

    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
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
            .append("approvalId", getApprovalId())
            .append("proNo", getProNo())
            .append("proName", getProName())
            .append("contractId", getContractId())
            .append("contractNo", getContractNo())
            .append("contractName", getContractName())
            .append("invoiceId", getInvoiceId())
            .append("invoiceCode", getInvoiceCode())
            .append("invoiceNo", getInvoiceNo())
            .append("collectionTime", getCollectionTime())
            .append("collectionAmount", getCollectionAmount())
            .append("documentNumber", getDocumentNumber())
            .append("paymentMethod", getPaymentMethod())
            .append("voucher", getVoucher())
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
