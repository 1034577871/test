package com.ruoyi.collection.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.collection.domain.CtBuInvoiceReqDetail;

/**
 * 发票申请明细Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-09selectCtBuApprovalNgList
 */
public interface CtBuInvoiceReqDetailMapper 
{
    public Map selectTaskCount(String userName);
    /**
     * 查询发票申请明细
     * 
     * @param id 发票申请明细ID
     * @return 发票申请明细
     */
    public CtBuInvoiceReqDetail selectCtBuInvoiceReqDetailById(String id);

    /**
     * 查询发票申请明细列表
     * 
     * @param ctBuInvoiceReqDetail 发票申请明细
     * @return 发票申请明细集合
     */
    public List<CtBuInvoiceReqDetail> selectCtBuInvoiceReqDetailList(CtBuInvoiceReqDetail ctBuInvoiceReqDetail);

    /**
     * 新增发票申请明细
     * 
     * @param ctBuInvoiceReqDetail 发票申请明细
     * @return 结果
     */
    public int insertCtBuInvoiceReqDetail(CtBuInvoiceReqDetail ctBuInvoiceReqDetail);

    /**
     * 修改发票申请明细
     * 
     * @param ctBuInvoiceReqDetail 发票申请明细
     * @return 结果
     */
    public int updateCtBuInvoiceReqDetail(CtBuInvoiceReqDetail ctBuInvoiceReqDetail);

    public int updateCtBuInvoiceReqDetailById(CtBuInvoiceReqDetail ctBuInvoiceReqDetail);
    public int delCtBuInvoiceReqDetailByIds(String[] ids);

    /**
     * 删除发票申请明细
     * 
     * @param id 发票申请明细ID
     * @return 结果
     */
    public int deleteCtBuInvoiceReqDetailById(String id);

    /**
     * 批量删除发票申请明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuInvoiceReqDetailByIds(String[] ids);
}
