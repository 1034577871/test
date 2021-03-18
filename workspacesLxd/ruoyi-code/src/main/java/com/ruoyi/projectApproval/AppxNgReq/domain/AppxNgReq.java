package com.ruoyi.projectApproval.AppxNgReq.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.projectApproval.AppNgReqList.domain.AppNgReqList;

/**
 * 事前审批对象 ct_bu_approvaldt_ng_req
 *
 * @author Mu
 * @date 2020-12-09
 */
public class AppxNgReq extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 申请公司,默认当前登录人所属公司
     **/
    private String applyCompany;

    /**
     * 审批编号
     **/
    private String appxNgNo;

    /**
     * 项目名称
     **/
    private String appxNgName;

    /**
     * 项目类别
     **/
    private String proType;

    /**
     * 申请日期
     **/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date applyDate;

    /**
     * 申请编号
     */
    @Excel(name = "申请编号")
    private String bid;

    /**
     * 传输收入-合同金额
     */
    @Excel(name = "传输收入-合同金额")
    private BigDecimal tranrevenue;

    /**
     * 传输收入-税率
     */
    @Excel(name = "传输收入-税率")
    private BigDecimal trantaxrate;

    /**
     * 传输收入-不含税金额
     */
    @Excel(name = "传输收入-不含税金额")
    private BigDecimal tranrevenueno;

    /**
     * 传输收入-销项税额
     */
    @Excel(name = "传输收入-销项税额")
    private BigDecimal tranoutput;

    /**
     * 传输收入-备注
     */
    @Excel(name = "传输收入-备注")
    private String tranremarks;

    /**
     * 设备收入-金额
     */
    @Excel(name = "设备收入-金额")
    private BigDecimal devicerevenue;

    /**
     * 设备收入-税率
     */
    @Excel(name = "设备收入-税率")
    private BigDecimal devicetaxrate;

    /**
     * 设备收入-不含税金额
     */
    @Excel(name = "设备收入-不含税金额")
    private BigDecimal devicerevenueno;

    /**
     * 设备收入-销项税额
     */
    @Excel(name = "设备收入-销项税额")
    private BigDecimal deviceoutput;

    /**
     * 设备收入-备注
     */
    @Excel(name = "设备收入-备注")
    private String deviceremarks;

    /**
     * 技术服务收入-金额
     */
    @Excel(name = "技术服务收入-金额")
    private BigDecimal serverevenue;

    /**
     * 技术服务收入-税率
     */
    @Excel(name = "技术服务收入-税率")
    private BigDecimal servetaxrate;

    /**
     * 技术服务收入-不含税金额
     */
    @Excel(name = "技术服务收入-不含税金额")
    private BigDecimal serverevenueno;

    /**
     * 技术服务收入-销项税额
     */
    @Excel(name = "技术服务收入-销项税额")
    private BigDecimal serveoutput;

    /**
     * 技术服务收入-备注
     */
    @Excel(name = "技术服务收入-备注")
    private String serveremarks;

    /**
     * 工程收入-金额
     */
    @Excel(name = "工程收入-金额")
    private BigDecimal projectrevenue;

    /**
     * 工程收入-税率
     */
    @Excel(name = "工程收入-税率")
    private BigDecimal projecttaxrate;

    /**
     * 工程收入-不含税金额
     */
    @Excel(name = "工程收入-不含税金额")
    private BigDecimal projectrevenueno;

    /**
     * 工程收入-销项税额
     */
    @Excel(name = "工程收入-销项税额")
    private BigDecimal projectoutput;

    /**
     * 工程收入-备注
     */
    @Excel(name = "工程收入-备注")
    private String projectremarks;

    /**
     * 租赁收入-金额
     */
    @Excel(name = "租赁收入-金额")
    private BigDecimal leaserevenue;

    /**
     * 租赁收入-税率
     */
    @Excel(name = "租赁收入-税率")
    private BigDecimal leasetaxrate;

    /**
     * 租赁收入-不含税金额
     */
    @Excel(name = "租赁收入-不含税金额")
    private BigDecimal leaserevenueno;

    /**
     * 租赁收入-销项税额
     */
    @Excel(name = "租赁收入-销项税额")
    private BigDecimal leaseoutput;

    /**
     * 租赁收入-备注
     */
    @Excel(name = "租赁收入-备注")
    private String leaseremarks;

    /**
     * 软件收入-金额
     */
    @Excel(name = "软件收入-金额")
    private BigDecimal softwarerevenue;

    /**
     * 软件收入-税率
     */
    @Excel(name = "软件收入-税率")
    private BigDecimal softwaretaxrate;

    /**
     * 软件收入-不含税金额
     */
    @Excel(name = "软件收入-不含税金额")
    private BigDecimal softwarerevenueno;

    /**
     * 软件收入-销项税额
     */
    @Excel(name = "软件收入-销项税额")
    private BigDecimal softwareoutput;

    /**
     * 软件收入-备注
     */
    @Excel(name = "软件收入-备注")
    private String softwareremarks;

    /**
     * 广告收入-金额
     */
    @Excel(name = "广告收入-金额")
    private BigDecimal advertrevenue;

    /**
     * 广告收入-税率
     */
    @Excel(name = "广告收入-税率")
    private BigDecimal adverttaxrate;

    /**
     * 广告收入-不含税金额
     */
    @Excel(name = "广告收入-不含税金额")
    private BigDecimal advertrevenueno;

    /**
     * 广告收入-销项税额
     */
    @Excel(name = "广告收入-销项税额")
    private BigDecimal advertoutput;

    /**
     * 广告收入-备注
     */
    @Excel(name = "广告收入-备注")
    private String advertremarks;

    /**
     * 合计收入-合同金额
     */
    @Excel(name = "合计收入-合同金额")
    private BigDecimal incomerevenue;

    /**
     * 合计收入-不含税金额
     */
    @Excel(name = "合计收入-不含税金额")
    private BigDecimal incomerevenueno;

    /**
     * 合计收入-销项税额
     */
    @Excel(name = "合计收入-销项税额")
    private BigDecimal incomeoutput;

    /**
     * 设备成本-合同金额
     */
    @Excel(name = "设备成本-合同金额")
    private BigDecimal devicecostmoney;

    /**
     * 设备成本-税率
     */
    @Excel(name = "设备成本-税率")
    private BigDecimal devicecosttaxrate;

    /**
     * 设备成本-不含税金额
     */
    @Excel(name = "设备成本-不含税金额")
    private BigDecimal devicecostmoneyno;

    /**
     * 设备成本-进项税额
     */
    @Excel(name = "设备成本-进项税额")
    private BigDecimal devicecostincome;

    /**
     * 设备成本-备注
     */
    @Excel(name = "设备成本-备注")
    private String devicecostremarks;

    /**
     * 材料成本-合同金额
     */
    @Excel(name = "材料成本-合同金额")
    private BigDecimal stuffcostmoney;

    /**
     * 材料成本-税率
     */
    @Excel(name = "材料成本-税率")
    private BigDecimal stuffcosttaxrate;

    /**
     * 材料成本-不含税金额
     */
    @Excel(name = "材料成本-不含税金额")
    private BigDecimal stuffcostmoneyno;

    /**
     * 材料成本-进项税额
     */
    @Excel(name = "材料成本-进项税额")
    private BigDecimal stuffcostincome;

    /**
     * 材料成本-备注
     */
    @Excel(name = "材料成本-备注")
    private String stuffcostremarks;

    /**
     * 工程转包成本(包工包料)-合同金额
     */
    @Excel(name = "工程转包成本(包工包料)-合同金额")
    private BigDecimal turncostmoney;

    /**
     * 工程转包成本(包工包料)-税率
     */
    @Excel(name = "工程转包成本(包工包料)-税率")
    private BigDecimal turncosttaxrate;

    /**
     * 工程转包成本(包工包料)-不含税金额
     */
    @Excel(name = "工程转包成本(包工包料)-不含税金额")
    private BigDecimal turncostmoneyno;

    /**
     * 工程转包成本(包工包料)-进项税额
     */
    @Excel(name = "工程转包成本(包工包料)-进项税额")
    private BigDecimal turncostincome;

    /**
     * 工程转包成本(包工包料)-备注
     */
    @Excel(name = "工程转包成本(包工包料)-备注")
    private String turncostremarks;

    /**
     * 服务费-合同金额
     */
    @Excel(name = "服务费-合同金额")
    private BigDecimal servecostmoney;

    /**
     * 服务费-税率
     */
    @Excel(name = "服务费-税率")
    private BigDecimal servecosttaxrate;

    /**
     * 服务费-不含税金额
     */
    @Excel(name = "服务费-不含税金额")
    private BigDecimal servecostmoneyno;

    /**
     * 服务费-进项税额
     */
    @Excel(name = "服务费-进项税额")
    private BigDecimal servecostincome;

    /**
     * 服务费-备注
     */
    @Excel(name = "服务费-备注")
    private String servecostremarks;

    /**
     * 施工费-合同金额
     */
    @Excel(name = "施工费-合同金额")
    private BigDecimal buildcostmoney;

    /**
     * 施工费-税率
     */
    @Excel(name = "施工费-税率")
    private BigDecimal buildcosttaxrate;

    /**
     * 施工费-不含税金额
     */
    @Excel(name = "施工费-不含税金额")
    private BigDecimal buildcostmoneyno;

    /**
     * 施工费-进项税额
     */
    @Excel(name = "施工费-进项税额")
    private BigDecimal buildcostincome;

    /**
     * 施工费-备注
     */
    @Excel(name = "施工费-备注")
    private String buildcostremarks;

    /**
     * 自有产权设备投资-合同金额
     */
    @Excel(name = "自有产权设备投资-合同金额")
    private BigDecimal havedevicemoney;

    /**
     * 自有产权设备投资-税率
     */
    @Excel(name = "自有产权设备投资-税率")
    private BigDecimal havedevicetaxrate;

    /**
     * 自有产权设备投资-不含税金额
     */
    @Excel(name = "自有产权设备投资-不含税金额")
    private BigDecimal havedevicemoneyno;

    /**
     * 自有产权设备投资-进项税额
     */
    @Excel(name = "自有产权设备投资-进项税额")
    private BigDecimal havedeviceincome;

    /**
     * 自有产权(设备、线路)投资备注
     */
    @Excel(name = "自有产权(设备、线路)投资备注")
    private String havedeviceremarks;

    /**
     * 自有产权线路投资-合同金额
     */
    @Excel(name = "自有产权线路投资-合同金额")
    private BigDecimal havelinemoney;

    /**
     * 自有产权线路投资-税率
     */
    @Excel(name = "自有产权线路投资-税率")
    private BigDecimal havelinetaxrate;

    /**
     * 自有产权线路投资-不含税金额
     */
    @Excel(name = "自有产权线路投资-不含税金额")
    private BigDecimal havelinemoneyno;

    /**
     * 自有产权线路投资-进项税额
     */
    @Excel(name = "自有产权线路投资-进项税额")
    private BigDecimal havelineincome;

    /**
     * 维护成本(年维护费用*服务年度)-合同金额
     */
    @Excel(name = "维护成本(年维护费用*服务年度)-合同金额")
    private BigDecimal upholdcostmoney;

    /**
     * 维护成本(年维护费用*服务年度)-税率
     */
    @Excel(name = "维护成本(年维护费用*服务年度)-税率")
    private BigDecimal upholdcosttaxrate;

    /**
     * 维护成本(年维护费用*服务年度)-不含税金额
     */
    @Excel(name = "维护成本(年维护费用*服务年度)-不含税金额")
    private BigDecimal upholdcostmoneyno;

    /**
     * 维护成本(年维护费用*服务年度)-进项税额
     */
    @Excel(name = "维护成本(年维护费用*服务年度)-进项税额")
    private BigDecimal upholdcostincome;

    /**
     * 维护成本(年维护费用*服务年度)-备注
     */
    @Excel(name = "维护成本(年维护费用*服务年度)-备注")
    private String upholdcostremarks;

    /**
     * 中标服务费、鉴证费等-合同金额
     */
    @Excel(name = "中标服务费、鉴证费等-合同金额")
    private BigDecimal othercostmoney;

    /**
     * 中标服务费、鉴证费等-税率
     */
    @Excel(name = "中标服务费、鉴证费等-税率")
    private BigDecimal othercosttaxrate;

    /**
     * 中标服务费、鉴证费等-不含税金额
     */
    @Excel(name = "中标服务费、鉴证费等-不含税金额")
    private BigDecimal othercostmoneyno;

    /**
     * 中标服务费、鉴证费等-进项税额
     */
    @Excel(name = "中标服务费、鉴证费等-进项税额")
    private BigDecimal othercostincome;

    /**
     * 中标服务费、鉴证费等-备注
     */
    @Excel(name = "中标服务费、鉴证费等-备注")
    private String othercostremarks;

    /**
     * 垫资利息-合同金额
     */
    @Excel(name = "垫资利息-合同金额")
    private BigDecimal interestcostmoney;

    /**
     * 垫资利息-税率
     */
    @Excel(name = "垫资利息-税率")
    private BigDecimal interestcosttaxrate;

    /**
     * 垫资利息-不含税金额
     */
    @Excel(name = "垫资利息-不含税金额")
    private BigDecimal interestcostmoneyno;

    /**
     * 垫资利息-进项税额
     */
    @Excel(name = "垫资利息-进项税额")
    private BigDecimal interestcostincome;

    /**
     * 垫资利息-备注
     */
    @Excel(name = "垫资利息-备注")
    private String interestcostremarks;

    /**
     * 成本合计-合同金额
     */
    @Excel(name = "成本合计-合同金额")
    private BigDecimal costmoney;

    /**
     * 成本合计-不含税金额
     */
    @Excel(name = "成本合计-不含税金额")
    private BigDecimal costmoneyno;

    /**
     * 成本合计-进项税额
     */
    @Excel(name = "成本合计-进项税额")
    private BigDecimal costincome;

    /**
     * 增值税
     */
    @Excel(name = "增值税")
    private BigDecimal incrementtaxrate;

    /**
     * 增值税备注
     */
    @Excel(name = "增值税备注")
    private String incrementremarks;

    /**
     * 附加税
     */
    @Excel(name = "附加税")
    private BigDecimal attachtaxrate;

    /**
     * 附加税备注
     */
    @Excel(name = "附加税备注")
    private String attachremarks;

    /**
     * 文化事业建设费
     */
    @Excel(name = "文化事业建设费")
    private BigDecimal culturebuild;

    /**
     * 文化事业建设费说明
     */
    @Excel(name = "文化事业建设费说明")
    private String culturebuildremarks;

    /**
     * 预计利润
     */
    @Excel(name = "预计利润")
    private BigDecimal estimateprofit;

    /**
     * 预计利润说明
     */
    @Excel(name = "预计利润说明")
    private String estimateprofitremarks;

    /**
     * 预计利润率
     */
    @Excel(name = "预计利润率")
    private BigDecimal epmargin;

    /**
     * 预计利润率说明
     */
    @Excel(name = "预计利润率说明")
    private String epmarginremarks;

    /**
     * 备注信息
     */
    @Excel(name = "备注信息")
    private String remarks;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 开始时间
     **/
    private String stime;

    /**
     * 结束时间
     **/
    private String etime;

    /**
     * 自增子类
     **/
    private List<AppNgReqList> dataList = new ArrayList<>();

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

    public void setTranrevenue(BigDecimal tranrevenue) {
        this.tranrevenue = tranrevenue;
    }

    public BigDecimal getTranrevenue() {
        return tranrevenue;
    }

    public void setTrantaxrate(BigDecimal trantaxrate) {
        this.trantaxrate = trantaxrate;
    }

    public BigDecimal getTrantaxrate() {
        return trantaxrate;
    }

    public void setTranrevenueno(BigDecimal tranrevenueno) {
        this.tranrevenueno = tranrevenueno;
    }

    public BigDecimal getTranrevenueno() {
        return tranrevenueno;
    }

    public void setTranoutput(BigDecimal tranoutput) {
        this.tranoutput = tranoutput;
    }

    public BigDecimal getTranoutput() {
        return tranoutput;
    }

    public void setTranremarks(String tranremarks) {
        this.tranremarks = tranremarks;
    }

    public String getTranremarks() {
        return tranremarks;
    }

    public void setDevicerevenue(BigDecimal devicerevenue) {
        this.devicerevenue = devicerevenue;
    }

    public BigDecimal getDevicerevenue() {
        return devicerevenue;
    }

    public void setDevicetaxrate(BigDecimal devicetaxrate) {
        this.devicetaxrate = devicetaxrate;
    }

    public BigDecimal getDevicetaxrate() {
        return devicetaxrate;
    }

    public void setDevicerevenueno(BigDecimal devicerevenueno) {
        this.devicerevenueno = devicerevenueno;
    }

    public BigDecimal getDevicerevenueno() {
        return devicerevenueno;
    }

    public void setDeviceoutput(BigDecimal deviceoutput) {
        this.deviceoutput = deviceoutput;
    }

    public BigDecimal getDeviceoutput() {
        return deviceoutput;
    }

    public void setDeviceremarks(String deviceremarks) {
        this.deviceremarks = deviceremarks;
    }

    public String getDeviceremarks() {
        return deviceremarks;
    }

    public void setServerevenue(BigDecimal serverevenue) {
        this.serverevenue = serverevenue;
    }

    public BigDecimal getServerevenue() {
        return serverevenue;
    }

    public void setServetaxrate(BigDecimal servetaxrate) {
        this.servetaxrate = servetaxrate;
    }

    public BigDecimal getServetaxrate() {
        return servetaxrate;
    }

    public void setServerevenueno(BigDecimal serverevenueno) {
        this.serverevenueno = serverevenueno;
    }

    public BigDecimal getServerevenueno() {
        return serverevenueno;
    }

    public void setServeoutput(BigDecimal serveoutput) {
        this.serveoutput = serveoutput;
    }

    public BigDecimal getServeoutput() {
        return serveoutput;
    }

    public void setServeremarks(String serveremarks) {
        this.serveremarks = serveremarks;
    }

    public String getServeremarks() {
        return serveremarks;
    }

    public void setProjectrevenue(BigDecimal projectrevenue) {
        this.projectrevenue = projectrevenue;
    }

    public BigDecimal getProjectrevenue() {
        return projectrevenue;
    }

    public void setProjecttaxrate(BigDecimal projecttaxrate) {
        this.projecttaxrate = projecttaxrate;
    }

    public BigDecimal getProjecttaxrate() {
        return projecttaxrate;
    }

    public void setProjectrevenueno(BigDecimal projectrevenueno) {
        this.projectrevenueno = projectrevenueno;
    }

    public BigDecimal getProjectrevenueno() {
        return projectrevenueno;
    }

    public void setProjectoutput(BigDecimal projectoutput) {
        this.projectoutput = projectoutput;
    }

    public BigDecimal getProjectoutput() {
        return projectoutput;
    }

    public void setProjectremarks(String projectremarks) {
        this.projectremarks = projectremarks;
    }

    public String getProjectremarks() {
        return projectremarks;
    }

    public void setLeaserevenue(BigDecimal leaserevenue) {
        this.leaserevenue = leaserevenue;
    }

    public BigDecimal getLeaserevenue() {
        return leaserevenue;
    }

    public void setLeasetaxrate(BigDecimal leasetaxrate) {
        this.leasetaxrate = leasetaxrate;
    }

    public BigDecimal getLeasetaxrate() {
        return leasetaxrate;
    }

    public void setLeaserevenueno(BigDecimal leaserevenueno) {
        this.leaserevenueno = leaserevenueno;
    }

    public BigDecimal getLeaserevenueno() {
        return leaserevenueno;
    }

    public void setLeaseoutput(BigDecimal leaseoutput) {
        this.leaseoutput = leaseoutput;
    }

    public BigDecimal getLeaseoutput() {
        return leaseoutput;
    }

    public void setLeaseremarks(String leaseremarks) {
        this.leaseremarks = leaseremarks;
    }

    public String getLeaseremarks() {
        return leaseremarks;
    }

    public void setSoftwarerevenue(BigDecimal softwarerevenue) {
        this.softwarerevenue = softwarerevenue;
    }

    public BigDecimal getSoftwarerevenue() {
        return softwarerevenue;
    }

    public void setSoftwaretaxrate(BigDecimal softwaretaxrate) {
        this.softwaretaxrate = softwaretaxrate;
    }

    public BigDecimal getSoftwaretaxrate() {
        return softwaretaxrate;
    }

    public void setSoftwarerevenueno(BigDecimal softwarerevenueno) {
        this.softwarerevenueno = softwarerevenueno;
    }

    public BigDecimal getSoftwarerevenueno() {
        return softwarerevenueno;
    }

    public void setSoftwareoutput(BigDecimal softwareoutput) {
        this.softwareoutput = softwareoutput;
    }

    public BigDecimal getSoftwareoutput() {
        return softwareoutput;
    }

    public void setSoftwareremarks(String softwareremarks) {
        this.softwareremarks = softwareremarks;
    }

    public String getSoftwareremarks() {
        return softwareremarks;
    }

    public void setAdvertrevenue(BigDecimal advertrevenue) {
        this.advertrevenue = advertrevenue;
    }

    public BigDecimal getAdvertrevenue() {
        return advertrevenue;
    }

    public void setAdverttaxrate(BigDecimal adverttaxrate) {
        this.adverttaxrate = adverttaxrate;
    }

    public BigDecimal getAdverttaxrate() {
        return adverttaxrate;
    }

    public void setAdvertrevenueno(BigDecimal advertrevenueno) {
        this.advertrevenueno = advertrevenueno;
    }

    public BigDecimal getAdvertrevenueno() {
        return advertrevenueno;
    }

    public void setAdvertoutput(BigDecimal advertoutput) {
        this.advertoutput = advertoutput;
    }

    public BigDecimal getAdvertoutput() {
        return advertoutput;
    }

    public void setAdvertremarks(String advertremarks) {
        this.advertremarks = advertremarks;
    }

    public String getAdvertremarks() {
        return advertremarks;
    }

    public void setIncomerevenue(BigDecimal incomerevenue) {
        this.incomerevenue = incomerevenue;
    }

    public BigDecimal getIncomerevenue() {
        return incomerevenue;
    }

    public void setIncomerevenueno(BigDecimal incomerevenueno) {
        this.incomerevenueno = incomerevenueno;
    }

    public BigDecimal getIncomerevenueno() {
        return incomerevenueno;
    }

    public void setIncomeoutput(BigDecimal incomeoutput) {
        this.incomeoutput = incomeoutput;
    }

    public BigDecimal getIncomeoutput() {
        return incomeoutput;
    }

    public void setDevicecostmoney(BigDecimal devicecostmoney) {
        this.devicecostmoney = devicecostmoney;
    }

    public BigDecimal getDevicecostmoney() {
        return devicecostmoney;
    }

    public void setDevicecosttaxrate(BigDecimal devicecosttaxrate) {
        this.devicecosttaxrate = devicecosttaxrate;
    }

    public BigDecimal getDevicecosttaxrate() {
        return devicecosttaxrate;
    }

    public void setDevicecostmoneyno(BigDecimal devicecostmoneyno) {
        this.devicecostmoneyno = devicecostmoneyno;
    }

    public BigDecimal getDevicecostmoneyno() {
        return devicecostmoneyno;
    }

    public void setDevicecostincome(BigDecimal devicecostincome) {
        this.devicecostincome = devicecostincome;
    }

    public BigDecimal getDevicecostincome() {
        return devicecostincome;
    }

    public void setDevicecostremarks(String devicecostremarks) {
        this.devicecostremarks = devicecostremarks;
    }

    public String getDevicecostremarks() {
        return devicecostremarks;
    }

    public void setStuffcostmoney(BigDecimal stuffcostmoney) {
        this.stuffcostmoney = stuffcostmoney;
    }

    public BigDecimal getStuffcostmoney() {
        return stuffcostmoney;
    }

    public void setStuffcosttaxrate(BigDecimal stuffcosttaxrate) {
        this.stuffcosttaxrate = stuffcosttaxrate;
    }

    public BigDecimal getStuffcosttaxrate() {
        return stuffcosttaxrate;
    }

    public void setStuffcostmoneyno(BigDecimal stuffcostmoneyno) {
        this.stuffcostmoneyno = stuffcostmoneyno;
    }

    public BigDecimal getStuffcostmoneyno() {
        return stuffcostmoneyno;
    }

    public void setStuffcostincome(BigDecimal stuffcostincome) {
        this.stuffcostincome = stuffcostincome;
    }

    public BigDecimal getStuffcostincome() {
        return stuffcostincome;
    }

    public void setStuffcostremarks(String stuffcostremarks) {
        this.stuffcostremarks = stuffcostremarks;
    }

    public String getStuffcostremarks() {
        return stuffcostremarks;
    }

    public void setTurncostmoney(BigDecimal turncostmoney) {
        this.turncostmoney = turncostmoney;
    }

    public BigDecimal getTurncostmoney() {
        return turncostmoney;
    }

    public void setTurncosttaxrate(BigDecimal turncosttaxrate) {
        this.turncosttaxrate = turncosttaxrate;
    }

    public BigDecimal getTurncosttaxrate() {
        return turncosttaxrate;
    }

    public void setTurncostmoneyno(BigDecimal turncostmoneyno) {
        this.turncostmoneyno = turncostmoneyno;
    }

    public BigDecimal getTurncostmoneyno() {
        return turncostmoneyno;
    }

    public void setTurncostincome(BigDecimal turncostincome) {
        this.turncostincome = turncostincome;
    }

    public BigDecimal getTurncostincome() {
        return turncostincome;
    }

    public void setTurncostremarks(String turncostremarks) {
        this.turncostremarks = turncostremarks;
    }

    public String getTurncostremarks() {
        return turncostremarks;
    }

    public void setServecostmoney(BigDecimal servecostmoney) {
        this.servecostmoney = servecostmoney;
    }

    public BigDecimal getServecostmoney() {
        return servecostmoney;
    }

    public void setServecosttaxrate(BigDecimal servecosttaxrate) {
        this.servecosttaxrate = servecosttaxrate;
    }

    public BigDecimal getServecosttaxrate() {
        return servecosttaxrate;
    }

    public void setServecostmoneyno(BigDecimal servecostmoneyno) {
        this.servecostmoneyno = servecostmoneyno;
    }

    public BigDecimal getServecostmoneyno() {
        return servecostmoneyno;
    }

    public void setServecostincome(BigDecimal servecostincome) {
        this.servecostincome = servecostincome;
    }

    public BigDecimal getServecostincome() {
        return servecostincome;
    }

    public void setServecostremarks(String servecostremarks) {
        this.servecostremarks = servecostremarks;
    }

    public String getServecostremarks() {
        return servecostremarks;
    }

    public void setBuildcostmoney(BigDecimal buildcostmoney) {
        this.buildcostmoney = buildcostmoney;
    }

    public BigDecimal getBuildcostmoney() {
        return buildcostmoney;
    }

    public void setBuildcosttaxrate(BigDecimal buildcosttaxrate) {
        this.buildcosttaxrate = buildcosttaxrate;
    }

    public BigDecimal getBuildcosttaxrate() {
        return buildcosttaxrate;
    }

    public void setBuildcostmoneyno(BigDecimal buildcostmoneyno) {
        this.buildcostmoneyno = buildcostmoneyno;
    }

    public BigDecimal getBuildcostmoneyno() {
        return buildcostmoneyno;
    }

    public void setBuildcostincome(BigDecimal buildcostincome) {
        this.buildcostincome = buildcostincome;
    }

    public BigDecimal getBuildcostincome() {
        return buildcostincome;
    }

    public void setBuildcostremarks(String buildcostremarks) {
        this.buildcostremarks = buildcostremarks;
    }

    public String getBuildcostremarks() {
        return buildcostremarks;
    }

    public void setHavedevicemoney(BigDecimal havedevicemoney) {
        this.havedevicemoney = havedevicemoney;
    }

    public BigDecimal getHavedevicemoney() {
        return havedevicemoney;
    }

    public void setHavedevicetaxrate(BigDecimal havedevicetaxrate) {
        this.havedevicetaxrate = havedevicetaxrate;
    }

    public BigDecimal getHavedevicetaxrate() {
        return havedevicetaxrate;
    }

    public void setHavedevicemoneyno(BigDecimal havedevicemoneyno) {
        this.havedevicemoneyno = havedevicemoneyno;
    }

    public BigDecimal getHavedevicemoneyno() {
        return havedevicemoneyno;
    }

    public void setHavedeviceincome(BigDecimal havedeviceincome) {
        this.havedeviceincome = havedeviceincome;
    }

    public BigDecimal getHavedeviceincome() {
        return havedeviceincome;
    }

    public void setHavedeviceremarks(String havedeviceremarks) {
        this.havedeviceremarks = havedeviceremarks;
    }

    public String getHavedeviceremarks() {
        return havedeviceremarks;
    }

    public void setHavelinemoney(BigDecimal havelinemoney) {
        this.havelinemoney = havelinemoney;
    }

    public BigDecimal getHavelinemoney() {
        return havelinemoney;
    }

    public void setHavelinetaxrate(BigDecimal havelinetaxrate) {
        this.havelinetaxrate = havelinetaxrate;
    }

    public BigDecimal getHavelinetaxrate() {
        return havelinetaxrate;
    }

    public void setHavelinemoneyno(BigDecimal havelinemoneyno) {
        this.havelinemoneyno = havelinemoneyno;
    }

    public BigDecimal getHavelinemoneyno() {
        return havelinemoneyno;
    }

    public void setHavelineincome(BigDecimal havelineincome) {
        this.havelineincome = havelineincome;
    }

    public BigDecimal getHavelineincome() {
        return havelineincome;
    }

    public void setUpholdcostmoney(BigDecimal upholdcostmoney) {
        this.upholdcostmoney = upholdcostmoney;
    }

    public BigDecimal getUpholdcostmoney() {
        return upholdcostmoney;
    }

    public void setUpholdcosttaxrate(BigDecimal upholdcosttaxrate) {
        this.upholdcosttaxrate = upholdcosttaxrate;
    }

    public BigDecimal getUpholdcosttaxrate() {
        return upholdcosttaxrate;
    }

    public void setUpholdcostmoneyno(BigDecimal upholdcostmoneyno) {
        this.upholdcostmoneyno = upholdcostmoneyno;
    }

    public BigDecimal getUpholdcostmoneyno() {
        return upholdcostmoneyno;
    }

    public void setUpholdcostincome(BigDecimal upholdcostincome) {
        this.upholdcostincome = upholdcostincome;
    }

    public BigDecimal getUpholdcostincome() {
        return upholdcostincome;
    }

    public void setUpholdcostremarks(String upholdcostremarks) {
        this.upholdcostremarks = upholdcostremarks;
    }

    public String getUpholdcostremarks() {
        return upholdcostremarks;
    }

    public void setOthercostmoney(BigDecimal othercostmoney) {
        this.othercostmoney = othercostmoney;
    }

    public BigDecimal getOthercostmoney() {
        return othercostmoney;
    }

    public void setOthercosttaxrate(BigDecimal othercosttaxrate) {
        this.othercosttaxrate = othercosttaxrate;
    }

    public BigDecimal getOthercosttaxrate() {
        return othercosttaxrate;
    }

    public void setOthercostmoneyno(BigDecimal othercostmoneyno) {
        this.othercostmoneyno = othercostmoneyno;
    }

    public BigDecimal getOthercostmoneyno() {
        return othercostmoneyno;
    }

    public void setOthercostincome(BigDecimal othercostincome) {
        this.othercostincome = othercostincome;
    }

    public BigDecimal getOthercostincome() {
        return othercostincome;
    }

    public void setOthercostremarks(String othercostremarks) {
        this.othercostremarks = othercostremarks;
    }

    public String getOthercostremarks() {
        return othercostremarks;
    }

    public void setInterestcostmoney(BigDecimal interestcostmoney) {
        this.interestcostmoney = interestcostmoney;
    }

    public BigDecimal getInterestcostmoney() {
        return interestcostmoney;
    }

    public void setInterestcosttaxrate(BigDecimal interestcosttaxrate) {
        this.interestcosttaxrate = interestcosttaxrate;
    }

    public BigDecimal getInterestcosttaxrate() {
        return interestcosttaxrate;
    }

    public void setInterestcostmoneyno(BigDecimal interestcostmoneyno) {
        this.interestcostmoneyno = interestcostmoneyno;
    }

    public BigDecimal getInterestcostmoneyno() {
        return interestcostmoneyno;
    }

    public void setInterestcostincome(BigDecimal interestcostincome) {
        this.interestcostincome = interestcostincome;
    }

    public BigDecimal getInterestcostincome() {
        return interestcostincome;
    }

    public void setInterestcostremarks(String interestcostremarks) {
        this.interestcostremarks = interestcostremarks;
    }

    public String getInterestcostremarks() {
        return interestcostremarks;
    }

    public void setCostmoney(BigDecimal costmoney) {
        this.costmoney = costmoney;
    }

    public BigDecimal getCostmoney() {
        return costmoney;
    }

    public void setCostmoneyno(BigDecimal costmoneyno) {
        this.costmoneyno = costmoneyno;
    }

    public BigDecimal getCostmoneyno() {
        return costmoneyno;
    }

    public void setCostincome(BigDecimal costincome) {
        this.costincome = costincome;
    }

    public BigDecimal getCostincome() {
        return costincome;
    }

    public void setIncrementtaxrate(BigDecimal incrementtaxrate) {
        this.incrementtaxrate = incrementtaxrate;
    }

    public BigDecimal getIncrementtaxrate() {
        return incrementtaxrate;
    }

    public void setIncrementremarks(String incrementremarks) {
        this.incrementremarks = incrementremarks;
    }

    public String getIncrementremarks() {
        return incrementremarks;
    }

    public void setAttachtaxrate(BigDecimal attachtaxrate) {
        this.attachtaxrate = attachtaxrate;
    }

    public BigDecimal getAttachtaxrate() {
        return attachtaxrate;
    }

    public void setAttachremarks(String attachremarks) {
        this.attachremarks = attachremarks;
    }

    public String getAttachremarks() {
        return attachremarks;
    }

    public void setCulturebuild(BigDecimal culturebuild) {
        this.culturebuild = culturebuild;
    }

    public BigDecimal getCulturebuild() {
        return culturebuild;
    }

    public void setCulturebuildremarks(String culturebuildremarks) {
        this.culturebuildremarks = culturebuildremarks;
    }

    public String getCulturebuildremarks() {
        return culturebuildremarks;
    }

    public void setEstimateprofit(BigDecimal estimateprofit) {
        this.estimateprofit = estimateprofit;
    }

    public BigDecimal getEstimateprofit() {
        return estimateprofit;
    }

    public void setEstimateprofitremarks(String estimateprofitremarks) {
        this.estimateprofitremarks = estimateprofitremarks;
    }

    public String getEstimateprofitremarks() {
        return estimateprofitremarks;
    }

    public void setEpmargin(BigDecimal epmargin) {
        this.epmargin = epmargin;
    }

    public BigDecimal getEpmargin() {
        return epmargin;
    }

    public void setEpmarginremarks(String epmarginremarks) {
        this.epmarginremarks = epmarginremarks;
    }

    public String getEpmarginremarks() {
        return epmarginremarks;
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

    public String getAppxNgNo() {
        return appxNgNo;
    }

    public void setAppxNgNo(String appxNgNo) {
        this.appxNgNo = appxNgNo;
    }

    public String getAppxNgName() {
        return appxNgName;
    }

    public void setAppxNgName(String appxNgName) {
        this.appxNgName = appxNgName;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyCompany() {
        return applyCompany;
    }

    public void setApplyCompany(String applyCompany) {
        this.applyCompany = applyCompany;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public List<AppNgReqList> getDataList() {
        return dataList;
    }

    public void setDataList(List<AppNgReqList> dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("id", getId())
                .append("createBy", getCreateBy()).append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("bid", getBid())
                .append("tranrevenue", getTranrevenue()).append("trantaxrate", getTrantaxrate())
                .append("tranrevenueno", getTranrevenueno()).append("tranoutput", getTranoutput())
                .append("tranremarks", getTranremarks()).append("devicerevenue", getDevicerevenue())
                .append("devicetaxrate", getDevicetaxrate()).append("devicerevenueno", getDevicerevenueno())
                .append("deviceoutput", getDeviceoutput()).append("deviceremarks", getDeviceremarks())
                .append("serverevenue", getServerevenue()).append("servetaxrate", getServetaxrate())
                .append("serverevenueno", getServerevenueno()).append("serveoutput", getServeoutput())
                .append("serveremarks", getServeremarks()).append("projectrevenue", getProjectrevenue())
                .append("projecttaxrate", getProjecttaxrate()).append("projectrevenueno", getProjectrevenueno())
                .append("projectoutput", getProjectoutput()).append("projectremarks", getProjectremarks())
                .append("leaserevenue", getLeaserevenue()).append("leasetaxrate", getLeasetaxrate())
                .append("leaserevenueno", getLeaserevenueno()).append("leaseoutput", getLeaseoutput())
                .append("leaseremarks", getLeaseremarks()).append("softwarerevenue", getSoftwarerevenue())
                .append("softwaretaxrate", getSoftwaretaxrate()).append("softwarerevenueno", getSoftwarerevenueno())
                .append("softwareoutput", getSoftwareoutput()).append("softwareremarks", getSoftwareremarks())
                .append("advertrevenue", getAdvertrevenue()).append("adverttaxrate", getAdverttaxrate())
                .append("advertrevenueno", getAdvertrevenueno()).append("advertoutput", getAdvertoutput())
                .append("advertremarks", getAdvertremarks()).append("incomerevenue", getIncomerevenue())
                .append("incomerevenueno", getIncomerevenueno()).append("incomeoutput", getIncomeoutput())
                .append("devicecostmoney", getDevicecostmoney()).append("devicecosttaxrate", getDevicecosttaxrate())
                .append("devicecostmoneyno", getDevicecostmoneyno()).append("devicecostincome", getDevicecostincome())
                .append("devicecostremarks", getDevicecostremarks()).append("stuffcostmoney", getStuffcostmoney())
                .append("stuffcosttaxrate", getStuffcosttaxrate()).append("stuffcostmoneyno", getStuffcostmoneyno())
                .append("stuffcostincome", getStuffcostincome()).append("stuffcostremarks", getStuffcostremarks())
                .append("turncostmoney", getTurncostmoney()).append("turncosttaxrate", getTurncosttaxrate())
                .append("turncostmoneyno", getTurncostmoneyno()).append("turncostincome", getTurncostincome())
                .append("turncostremarks", getTurncostremarks()).append("servecostmoney", getServecostmoney())
                .append("servecosttaxrate", getServecosttaxrate()).append("servecostmoneyno", getServecostmoneyno())
                .append("servecostincome", getServecostincome()).append("servecostremarks", getServecostremarks())
                .append("buildcostmoney", getBuildcostmoney()).append("buildcosttaxrate", getBuildcosttaxrate())
                .append("buildcostmoneyno", getBuildcostmoneyno()).append("buildcostincome", getBuildcostincome())
                .append("buildcostremarks", getBuildcostremarks()).append("havedevicemoney", getHavedevicemoney())
                .append("havedevicetaxrate", getHavedevicetaxrate()).append("havedevicemoneyno", getHavedevicemoneyno())
                .append("havedeviceincome", getHavedeviceincome()).append("havedeviceremarks", getHavedeviceremarks())
                .append("havelinemoney", getHavelinemoney()).append("havelinetaxrate", getHavelinetaxrate())
                .append("havelinemoneyno", getHavelinemoneyno()).append("havelineincome", getHavelineincome())
                .append("upholdcostmoney", getUpholdcostmoney()).append("upholdcosttaxrate", getUpholdcosttaxrate())
                .append("upholdcostmoneyno", getUpholdcostmoneyno()).append("upholdcostincome", getUpholdcostincome())
                .append("upholdcostremarks", getUpholdcostremarks()).append("othercostmoney", getOthercostmoney())
                .append("othercosttaxrate", getOthercosttaxrate()).append("othercostmoneyno", getOthercostmoneyno())
                .append("othercostincome", getOthercostincome()).append("othercostremarks", getOthercostremarks())
                .append("interestcostmoney", getInterestcostmoney())
                .append("interestcosttaxrate", getInterestcosttaxrate())
                .append("interestcostmoneyno", getInterestcostmoneyno())
                .append("interestcostincome", getInterestcostincome())
                .append("interestcostremarks", getInterestcostremarks()).append("costmoney", getCostmoney())
                .append("costmoneyno", getCostmoneyno()).append("costincome", getCostincome())
                .append("incrementtaxrate", getIncrementtaxrate()).append("incrementremarks", getIncrementremarks())
                .append("attachtaxrate", getAttachtaxrate()).append("attachremarks", getAttachremarks())
                .append("culturebuild", getCulturebuild()).append("culturebuildremarks", getCulturebuildremarks())
                .append("estimateprofit", getEstimateprofit())
                .append("estimateprofitremarks", getEstimateprofitremarks()).append("epmargin", getEpmargin())
                .append("epmarginremarks", getEpmarginremarks()).append("remarks", getRemarks())
                .append("delFlag", getDelFlag()).toString();
    }
}
