package com.ruoyi.paymentManagement.payinfo.service;


import com.ruoyi.paymentManagement.payinfo.domain.CtBuPayinfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 付款申请单主Service接口
 * 
 * @author ruoyi
 * @date 2021-01-12
 */
public interface ICtBuPayinfoService 
{
    /**
     * 查询付款申请单主
     * 
     * @param id 付款申请单主ID
     * @return 付款申请单主
     */
    public CtBuPayinfo selectCtBuPayinfoById(String id);

    /**
     * 查询付款申请单主列表
     * 
     * @param ctBuPayinfo 付款申请单主
     * @return 付款申请单主集合
     */
    public List<CtBuPayinfo> selectCtBuPayinfoList(CtBuPayinfo ctBuPayinfo);

    /**
     * 新增付款申请单主
     * 
     * @param ctBuPayinfo 付款申请单主
     * @return 结果
     */
    public int insertCtBuPayinfo(CtBuPayinfo ctBuPayinfo);

    /**
     * 修改付款申请单主
     * 
     * @param ctBuPayinfo 付款申请单主
     * @return 结果
     */
    public int updateCtBuPayinfo(CtBuPayinfo ctBuPayinfo);

    /**
     * 批量删除付款申请单主
     * 
     * @param ids 需要删除的付款申请单主ID
     * @return 结果
     */
    public int deleteCtBuPayinfoByIds(String[] ids);

    /**
     * 删除付款申请单主信息
     * 
     * @param id 付款申请单主ID
     * @return 结果
     */
    public int deleteCtBuPayinfoById(String id);

    /**
     * 删除付款申请单主信息
     *
     * @param ids 付款申请单主ID
     * @return 结果
     */
    public int updateCtBuPayinfoByIds(String[] ids);

    /**
     * 根据实例ID修改付款申请单主
     *
     * @param ctBuPayinfo 付款申请单主
     * @return 结果
     */
    public int updateCtBuPayinfoByInstanceId(CtBuPayinfo ctBuPayinfo);

    /**
     * 付款核销
     *
     * @param ctBuPayinfo 付款申请单主
     * @return 结果
     */
    public int paymentWriteOff(CtBuPayinfo ctBuPayinfo);

    /**
     * 根据实例ID查询付款申请单主
     *
     * @param id 付款申请单主ID
     * @return 付款申请单主
     */
    public CtBuPayinfo selectCtBuPayinfoByInstanceId(String id);

    /**
     * 查询付款申请单主列表
     *
     * @param ctBuPayinfo 付款申请单主
     * @return 付款申请单主集合
     */
    public List<CtBuPayinfo> selectCtBuPayinfoList1(CtBuPayinfo ctBuPayinfo);


    public String countAppliedAmountByContractIdPayment(String contractId);
}
