package com.ruoyi.contract.contractPayinfo.service;

import java.util.List;

import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;

/**
 * 合同付款Service接口
 *
 * @author ruoyi
 * @date 2020-12-10
 */
public interface ICtBuContractPayinfoService {
    /**
     * 查询合同付款
     *
     * @param id 合同付款ID
     * @return 合同付款
     */
    public CtBuContractPayinfo selectCtBuContractPayinfoById(String id);

    /**
     * 查询合同付款列表
     *
     * @param ctBuContractPayinfo 合同付款
     * @return 合同付款集合
     */
    public List<CtBuContractPayinfo> selectCtBuContractPayinfoList(CtBuContractPayinfo ctBuContractPayinfo);

    /**
     * 新增合同付款
     *
     * @param ctBuContractPayinfo 合同付款
     * @return 结果
     */
    public int insertCtBuContractPayinfo(CtBuContractPayinfo ctBuContractPayinfo);

    /**
     * 修改合同付款
     *
     * @param ctBuContractPayinfo 合同付款
     * @return 结果
     */
    public int updateCtBuContractPayinfo(CtBuContractPayinfo ctBuContractPayinfo);

    /**
     * 批量删除合同付款
     *
     * @param ids 需要删除的合同付款ID
     * @return 结果
     */
    public int deleteCtBuContractPayinfoByIds(String[] ids);

    /**
     * 删除合同付款信息
     *
     * @param id 合同付款ID
     * @return 结果
     */
    public int deleteCtBuContractPayinfoById(String id);

    /**
     * 查询合同付款列表
     *
     * @param ctBuContractPayinfo 合同付款
     * @return 合同付款集合
     */
    public List<CtBuContractPayinfo> selectCtBuContractPayinfoListConcat(CtBuContractPayinfo ctBuContractPayinfo);

    /**
     * 批量逻辑删除合同付款
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int updateCtBuContractPayinfoByIds(String[] ids);

}
