package com.ruoyi.collection.service;

import java.util.List;
import com.ruoyi.collection.domain.CtBuInvoiceReqDetail;

/**
 * 发票申请明细Service接口
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
public interface ICtBuInvoiceReqDetailService 
{
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

    /**
     * 批量删除发票申请明细
     * 
     * @param ids 需要删除的发票申请明细ID
     * @return 结果
     */
    public int deleteCtBuInvoiceReqDetailByIds(String[] ids);

    /**
     * 删除发票申请明细信息
     * 
     * @param id 发票申请明细ID
     * @return 结果
     */
    public int deleteCtBuInvoiceReqDetailById(String id);

    /**
     * 批量删除发票申请明细
     *
     * @param ids 需要删除的发票申请明细ID
     * @return 结果
     */
    public int delCtBuInvoiceReqDetailByIds(String[] ids);
}
