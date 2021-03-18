package com.ruoyi.contract.payinfoInvoice.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.contract.payinfoInvoice.mapper.CtBuPayinfoInvoiceMapper;
import com.ruoyi.contract.payinfoInvoice.domain.CtBuPayinfoInvoice;
import com.ruoyi.contract.payinfoInvoice.service.ICtBuPayinfoInvoiceService;

/**
 * 付款周期-发票对应关系Service业务层处理
 *
 * @author ruoyi
 * @date 2021-01-14
 */
@Service
public class CtBuPayinfoInvoiceServiceImpl implements ICtBuPayinfoInvoiceService {
    @Autowired
    private CtBuPayinfoInvoiceMapper ctBuPayinfoInvoiceMapper;

    /**
     * 查询付款周期-发票对应关系
     *
     * @param id 付款周期-发票对应关系ID
     * @return 付款周期-发票对应关系
     */
    @Override
    public CtBuPayinfoInvoice selectCtBuPayinfoInvoiceById(String id) {
        return ctBuPayinfoInvoiceMapper.selectCtBuPayinfoInvoiceById(id);
    }

    /**
     * 查询付款周期-发票对应关系列表
     *
     * @param ctBuPayinfoInvoice 付款周期-发票对应关系
     * @return 付款周期-发票对应关系
     */
    @Override
    public List<CtBuPayinfoInvoice> selectCtBuPayinfoInvoiceList(CtBuPayinfoInvoice ctBuPayinfoInvoice) {
        return ctBuPayinfoInvoiceMapper.selectCtBuPayinfoInvoiceList(ctBuPayinfoInvoice);
    }

    /**
     * 新增付款周期-发票对应关系
     *
     * @param ctBuPayinfoInvoice 付款周期-发票对应关系
     * @return 结果
     */
    @Override
    public int insertCtBuPayinfoInvoice(CtBuPayinfoInvoice ctBuPayinfoInvoice) {
        ctBuPayinfoInvoice.setCreateTime(DateUtils.getNowDate());
        return ctBuPayinfoInvoiceMapper.insertCtBuPayinfoInvoice(ctBuPayinfoInvoice);
    }

    /**
     * 修改付款周期-发票对应关系
     *
     * @param ctBuPayinfoInvoice 付款周期-发票对应关系
     * @return 结果
     */
    @Override
    public int updateCtBuPayinfoInvoice(CtBuPayinfoInvoice ctBuPayinfoInvoice) {
        ctBuPayinfoInvoice.setUpdateTime(DateUtils.getNowDate());
        return ctBuPayinfoInvoiceMapper.updateCtBuPayinfoInvoice(ctBuPayinfoInvoice);
    }

    /**
     * 批量删除付款周期-发票对应关系
     *
     * @param ids 需要删除的付款周期-发票对应关系ID
     * @return 结果
     */
    @Override
    public int deleteCtBuPayinfoInvoiceByIds(String[] ids) {
        return ctBuPayinfoInvoiceMapper.deleteCtBuPayinfoInvoiceByIds(ids);
    }

    /**
     * 删除付款周期-发票对应关系信息
     *
     * @param id 付款周期-发票对应关系ID
     * @return 结果
     */
    @Override
    public int deleteCtBuPayinfoInvoiceById(String id) {
        return ctBuPayinfoInvoiceMapper.deleteCtBuPayinfoInvoiceById(id);
    }
}
