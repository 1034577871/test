package com.ruoyi.collection.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 财务开票对象 ct_bu_invoice_info
 * 
 * @author ruoyi
 * @date 2020-12-11
 */
public class CtBuInvoiceInfoVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    public String getVoucherDept() {
        return voucherDept;
    }

    public void setVoucherDept(String voucherDept) {
        this.voucherDept = voucherDept;
    }

    private String voucherDept;

    /** 主键 */
    private String ids;
    public String getContractCategoryName() {
        return contractCategoryName;
    }

    public void setContractCategoryName(String contractCategoryName) {
        this.contractCategoryName = contractCategoryName;
    }

    @Excel(name = "合同类别名称")
    private String contractCategoryName;

    /** 合同类别 */
    @Excel(name = "合同类别")
    private String contractCategorys;

    /** 申请单号 */
    @Excel(name = "申请单号")
    private String reqIds;

    /** 发票代码 */
    @Excel(name = "发票代码")
    private String invoiceCodes;

    /** 发票号码 */
    @Excel(name = "发票号码")
    private String invoiceNos;

    /** 发票开具日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发票开具日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoiceDates;

    /** 开票人 */
    @Excel(name = "开票人")
    private String invoiceDrawers;

    /** 复核人 */
    @Excel(name = "复核人")
    private String invoiceReviewers;

    /** 收款人xx */
    @Excel(name = "收款人xx")
    private String invoicePayees;

    /** 发票金额（含税） */
    @Excel(name = "发票金额", readConverterExp = "含=税")
    private BigDecimal invoiceAmountTaxs;

    /** 税率 */
    @Excel(name = "税率")
    private String invoiceTaxrates;

    /** 金额（不含税） */
    @Excel(name = "金额", readConverterExp = "不=含税")
    private BigDecimal invoiceAmountNtaxs;

    /** 发票图片 */
    @Excel(name = "发票图片")
    private byte[] invoiceImgs;

    /** 企业资质图片 */
    @Excel(name = "企业资质图片")
    private byte[] companyImgs;

    /** 移交人编号 */
    @Excel(name = "移交人编号")
    private String handoverUserids;

    /** 移交人姓名 */
    @Excel(name = "移交人姓名")
    private String handoverUsernames;

    /** 移交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "移交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handoverTimes;

    /** 移交确认人编号 */
    @Excel(name = "移交确认人编号")
    private String confirmerUserids;

    /** 移交确认人姓名 */
    @Excel(name = "移交确认人姓名")
    private String confirmerUsernames;

    /** 移交确认时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "移交确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmerTimes;

    /** 凭证号 */
    @Excel(name = "凭证号")
    private String voucherNos;

    /** 凭证号录入人员编号 */
    @Excel(name = "凭证号录入人员编号")
    private String voucherUserids;

    /** 凭证号录入人员姓名 */
    @Excel(name = "凭证号录入人员姓名")
    private String voucherUsernames;

    /** 凭证号录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "凭证号录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date voucherTimes;

    /** 状态 */
    @Excel(name = "状态")
    private Integer statuss;

    /** 状态说明 */
    @Excel(name = "状态说明")
    private String statuspss;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getContractCategorys() {
        return contractCategorys;
    }

    public void setContractCategorys(String contractCategorys) {
        this.contractCategorys = contractCategorys;
    }

    public String getReqIds() {
        return reqIds;
    }

    public void setReqIds(String reqIds) {
        this.reqIds = reqIds;
    }

    public String getInvoiceCodes() {
        return invoiceCodes;
    }

    public void setInvoiceCodes(String invoiceCodes) {
        this.invoiceCodes = invoiceCodes;
    }

    public String getInvoiceNos() {
        return invoiceNos;
    }

    public void setInvoiceNos(String invoiceNos) {
        this.invoiceNos = invoiceNos;
    }

    public Date getInvoiceDates() {
        return invoiceDates;
    }

    public void setInvoiceDates(Date invoiceDates) {
        this.invoiceDates = invoiceDates;
    }

    public String getInvoiceDrawers() {
        return invoiceDrawers;
    }

    public void setInvoiceDrawers(String invoiceDrawers) {
        this.invoiceDrawers = invoiceDrawers;
    }

    public String getInvoiceReviewers() {
        return invoiceReviewers;
    }

    public void setInvoiceReviewers(String invoiceReviewers) {
        this.invoiceReviewers = invoiceReviewers;
    }

    public String getInvoicePayees() {
        return invoicePayees;
    }

    public void setInvoicePayees(String invoicePayees) {
        this.invoicePayees = invoicePayees;
    }

    public BigDecimal getInvoiceAmountTaxs() {
        return invoiceAmountTaxs;
    }

    public void setInvoiceAmountTaxs(BigDecimal invoiceAmountTaxs) {
        this.invoiceAmountTaxs = invoiceAmountTaxs;
    }

    public String getInvoiceTaxrates() {
        return invoiceTaxrates;
    }

    public void setInvoiceTaxrates(String invoiceTaxrates) {
        this.invoiceTaxrates = invoiceTaxrates;
    }

    public BigDecimal getInvoiceAmountNtaxs() {
        return invoiceAmountNtaxs;
    }

    public void setInvoiceAmountNtaxs(BigDecimal invoiceAmountNtaxs) {
        this.invoiceAmountNtaxs = invoiceAmountNtaxs;
    }

    public byte[] getInvoiceImgs() {
        return invoiceImgs;
    }

    public void setInvoiceImgs(byte[] invoiceImgs) {
        this.invoiceImgs = invoiceImgs;
    }

    public byte[] getCompanyImgs() {
        return companyImgs;
    }

    public void setCompanyImgs(byte[] companyImgs) {
        this.companyImgs = companyImgs;
    }

    public String getHandoverUserids() {
        return handoverUserids;
    }

    public void setHandoverUserids(String handoverUserids) {
        this.handoverUserids = handoverUserids;
    }

    public String getHandoverUsernames() {
        return handoverUsernames;
    }

    public void setHandoverUsernames(String handoverUsernames) {
        this.handoverUsernames = handoverUsernames;
    }

    public Date getHandoverTimes() {
        return handoverTimes;
    }

    public void setHandoverTimes(Date handoverTimes) {
        this.handoverTimes = handoverTimes;
    }

    public String getConfirmerUserids() {
        return confirmerUserids;
    }

    public void setConfirmerUserids(String confirmerUserids) {
        this.confirmerUserids = confirmerUserids;
    }

    public String getConfirmerUsernames() {
        return confirmerUsernames;
    }

    public void setConfirmerUsernames(String confirmerUsernames) {
        this.confirmerUsernames = confirmerUsernames;
    }

    public Date getConfirmerTimes() {
        return confirmerTimes;
    }

    public void setConfirmerTimes(Date confirmerTimes) {
        this.confirmerTimes = confirmerTimes;
    }

    public String getVoucherNos() {
        return voucherNos;
    }

    public void setVoucherNos(String voucherNos) {
        this.voucherNos = voucherNos;
    }

    public String getVoucherUserids() {
        return voucherUserids;
    }

    public void setVoucherUserids(String voucherUserids) {
        this.voucherUserids = voucherUserids;
    }

    public String getVoucherUsernames() {
        return voucherUsernames;
    }

    public void setVoucherUsernames(String voucherUsernames) {
        this.voucherUsernames = voucherUsernames;
    }

    public Date getVoucherTimes() {
        return voucherTimes;
    }

    public void setVoucherTimes(Date voucherTimes) {
        this.voucherTimes = voucherTimes;
    }

    public Integer getStatuss() {
        return statuss;
    }

    public void setStatuss(Integer statuss) {
        this.statuss = statuss;
    }

    public String getStatuspss() {
        return statuspss;
    }

    public void setStatuspss(String statuspss) {
        this.statuspss = statuspss;
    }

    public String getDelFlags() {
        return delFlags;
    }

    public void setDelFlags(String delFlags) {
        this.delFlags = delFlags;
    }

    /** 删除标志 */
    private String delFlags;


}
