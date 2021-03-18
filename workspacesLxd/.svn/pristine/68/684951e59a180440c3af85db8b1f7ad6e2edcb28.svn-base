package com.ruoyi.collection.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.collection.domain.ActWorkflowFormDatas;
import com.ruoyi.collection.domain.CtBuInvoiceReq;
import com.ruoyi.collection.domain.CtBuInvoiceReqDto;


/**
 * 发票申请Mapper接口
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
public interface CtBuInvoiceReqMapper 
{
    public List<com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo> selectContractPayinfoById(com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo info);
    /**
     * 修改发票申请 根据流程id
     *
     * @param ctBuInvoiceReq 发票申请
     * @return 结果
     */
    public int updateCtBuInvoiceReqByInstanceId(CtBuInvoiceReqDto ctBuInvoiceReq);
    /**
     * 查询发票申请总信息
     *
     * @param id 发票申请ID
     * @return 发票申请
     */
    public CtBuInvoiceReqDto selectCtBuInvoiceReqDtoById(String id);
    public CtBuInvoiceReqDto selectCtBuInvoiceReqDtoByInstanceId(String id);
    /**
     * 查询发票申请
     * 
     * @param id 发票申请ID
     * @return 发票申请
     */
    public CtBuInvoiceReq selectCtBuInvoiceReqById(String id);

    /**
     * 查询发票申请列表
     * 
     * @param ctBuInvoiceReq 发票申请
     * @return 发票申请集合
     */
    public List<CtBuInvoiceReq> selectCtBuInvoiceReqList(CtBuInvoiceReq ctBuInvoiceReq);

    /**
     * 新增发票申请
     * 
     * @param ctBuInvoiceReq 发票申请
     * @return 结果
     */
    public int insertCtBuInvoiceReq(CtBuInvoiceReqDto ctBuInvoiceReq);

    /**
     * 新增发票审核记录
     *
     * @return 结果
     */
    public int  insertSubActWorkflowFormData(Map map);

    /**
     * 修改发票申请
     * 
     * @param ctBuInvoiceReq 发票申请
     * @return 结果
     */
    public int updateCtBuInvoiceReq(CtBuInvoiceReqDto ctBuInvoiceReq);

    /**
     * 删除发票申请
     * 
     * @param id 发票申请ID
     * @return 结果
     */
    public int deleteCtBuInvoiceReqById(String id);

    /**
     * 批量删除发票申请
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuInvoiceReqByIds(String[] ids);
    public List<ActWorkflowFormDatas> selectGroupActWorkflowFormDataLists(ActWorkflowFormDatas ActWorkflowFormData);
}
