package com.ruoyi.collection.mapper;

import java.util.*;

import com.ruoyi.collection.domain.CtBuInvoiceInfo;
import com.ruoyi.collection.domain.CtBuInvoiceInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * 财务开票Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-11
 */
public interface CtBuInvoiceInfoMapper 
{
    public List<CtBuInvoiceInfoReq> selectKpList(CtBuInvoiceInfoReq ctBuInvoiceInfoReq);

    public List<CtBuInvoiceInfoReq>  selectTotalInfo(CtBuInvoiceInfoReq ctBuInvoiceInfoReq);
    public List<CtBuInvoiceInfoReq>   selectRecInfo(CtBuInvoiceInfoReq ctBuInvoiceInfoReq);
    public List<CtBuInvoiceInfoReq>   selectRecInfoByRqId(CtBuInvoiceInfoReq ctBuInvoiceInfoReq);
    /**
     * 查询列表
     *
     * @param ctBuInvoiceInfo 财务开票
     * @return 财务开票集合
     */
    public List<CtBuInvoiceInfo>selectCtBuInvoiceQrInfoandReqsList(CtBuInvoiceInfo ctBuInvoiceInfo);
    public List<CtBuInvoiceInfo> selectCtBuInvoiceQrInfoandPzhsList(CtBuInvoiceInfo ctBuInvoiceInfo);
    /**
     * 移交发票
     * @param map
     * @return
     */
    public int updateCtBuInvoiceInfoByIds(Map map);
    /**
     * 查询财务开票
     * 
     * @param id 财务开票ID
     * @return 财务开票
     */
    public CtBuInvoiceInfo selectCtBuInvoiceInfoById(String id);

    /**
     * 查询确认列表
     *
     * @param ctBuInvoiceInfo 财务开票
     * @return 财务开票集合
     */
    public List<CtBuInvoiceInfo>selectCtBuInvoiceQrInfoList(CtBuInvoiceInfo ctBuInvoiceInfo);
    /**
     * 查询财务开票列表
     * 
     * @param ctBuInvoiceInfo 财务开票
     * @return 财务开票集合
     */
    public List<CtBuInvoiceInfo> selectCtBuInvoiceInfoList(CtBuInvoiceInfo ctBuInvoiceInfo);

    /**
     * 新增财务开票
     * 
     * @param ctBuInvoiceInfo 财务开票
     * @return 结果
     */
    public int insertCtBuInvoiceInfo(CtBuInvoiceInfo ctBuInvoiceInfo);

    /**
     * 修改财务开票
     * 
     * @param ctBuInvoiceInfo 财务开票
     * @return 结果
     */
    public int updateCtBuInvoiceInfo(CtBuInvoiceInfo ctBuInvoiceInfo);

    /**
     * 删除财务开票
     * 
     * @param id 财务开票ID
     * @return 结果
     */
    public int deleteCtBuInvoiceInfoById(String id);

    /**
     * 批量删除财务开票
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuInvoiceInfoByIds(String[] ids);

    /**
     * 开票统计
     * @param companyId  公司ID
     * @param invoiceType   发票类型
     * @param startDate     开始时间
     * @param endDate       结束时间
     * @return
     */
    public int invoiceStatistics(@Param("companyId")Long companyId, @Param("invoiceType") int invoiceType, @Param("startDate")Date startDate, @Param("endDate")Date endDate);

    /**
     * 开票统计
     * @param companyId  公司ID
     * @param startDate     开始时间
     * @param endDate       结束时间
     * @return
     */
    public HashMap<String,Object> invoiceStatistics1(@Param("companyId")Long companyId, @Param("startDate")Date startDate, @Param("endDate")Date endDate);


    /**
     * 查询本月未录入凭证号列表
     * @return
     */
    public List<CtBuInvoiceInfo> voucherWarning();
}
