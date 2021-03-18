package com.ruoyi.contract.payinfoInvoice.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.contract.payinfoInvoice.domain.CtBuPayinfoInvoice;

/**
 * 付款周期-发票对应关系Mapper接口
 *
 * @author ruoyi
 * @date 2021-01-14
 */
public interface CtBuPayinfoInvoiceMapper {
    /**
     * 查询付款周期-发票对应关系
     *
     * @param id 付款周期-发票对应关系ID
     * @return 付款周期-发票对应关系
     */
    public CtBuPayinfoInvoice selectCtBuPayinfoInvoiceById(String id);

    /**
     * 查询付款周期-发票对应关系列表
     *
     * @param ctBuPayinfoInvoice 付款周期-发票对应关系
     * @return 付款周期-发票对应关系集合
     */
    public List<CtBuPayinfoInvoice> selectCtBuPayinfoInvoiceList(CtBuPayinfoInvoice ctBuPayinfoInvoice);

    /**
     * 新增付款周期-发票对应关系
     *
     * @param ctBuPayinfoInvoice 付款周期-发票对应关系
     * @return 结果
     */
    public int insertCtBuPayinfoInvoice(CtBuPayinfoInvoice ctBuPayinfoInvoice);

    /**
     * 修改付款周期-发票对应关系
     *
     * @param ctBuPayinfoInvoice 付款周期-发票对应关系
     * @return 结果
     */
    public int updateCtBuPayinfoInvoice(CtBuPayinfoInvoice ctBuPayinfoInvoice);

    /**
     * 删除付款周期-发票对应关系
     *
     * @param id 付款周期-发票对应关系ID
     * @return 结果
     */
    public int deleteCtBuPayinfoInvoiceById(String id);

    /**
     * 逻辑删除付款周期-发票对应关系
     *
     * @param id 付款周期-发票对应关系ID
     * @return 结果
     */
    public int updateCtBuPayinfoInvoiceById(String id);

    /**
     * 逻辑删除付款周期-发票对应关系
     *
     * @param bid 付款周期-发票对应关系BID
     * @return 结果
     */
    public int updateCtBuPayinfoInvoiceByBid(String bid);

    /**
     * 批量删除付款周期-发票对应关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuPayinfoInvoiceByIds(String[] ids);

    public Map<String, String> selectPayinfoInvoiceContractIdConcat(String paymentCycleId);

    /**
     * 查询付款周期-发票对应关系
     *
     * @param bid 付款周期-发票对应关系BID
     * @return 付款周期-发票对应关系
     */
    public CtBuPayinfoInvoice selectCtBuPayinfoInvoiceByBid(String bid);

}
