package com.ruoyi.collection.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.collection.mapper.CtBuInvoiceReqDetailMapper;
import com.ruoyi.collection.domain.CtBuInvoiceReqDetail;
import com.ruoyi.collection.service.ICtBuInvoiceReqDetailService;

/**
 * 发票申请明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@Service
public class CtBuInvoiceReqDetailServiceImpl implements ICtBuInvoiceReqDetailService 
{
    @Autowired
    private CtBuInvoiceReqDetailMapper ctBuInvoiceReqDetailMapper;

    /**
     * 查询发票申请明细
     * 
     * @param id 发票申请明细ID
     * @return 发票申请明细
     */
    @Override
    public CtBuInvoiceReqDetail selectCtBuInvoiceReqDetailById(String id)
    {
        return ctBuInvoiceReqDetailMapper.selectCtBuInvoiceReqDetailById(id);
    }

    /**
     * 查询发票申请明细列表
     * 
     * @param ctBuInvoiceReqDetail 发票申请明细
     * @return 发票申请明细
     */
    @Override
    public List<CtBuInvoiceReqDetail> selectCtBuInvoiceReqDetailList(CtBuInvoiceReqDetail ctBuInvoiceReqDetail)
    {
        return ctBuInvoiceReqDetailMapper.selectCtBuInvoiceReqDetailList(ctBuInvoiceReqDetail);
    }

    /**
     * 新增发票申请明细
     * 
     * @param ctBuInvoiceReqDetail 发票申请明细
     * @return 结果
     */
    @Override
    public int insertCtBuInvoiceReqDetail(CtBuInvoiceReqDetail ctBuInvoiceReqDetail)
    {
        ctBuInvoiceReqDetail.setCreateTime(DateUtils.getNowDate());
        return ctBuInvoiceReqDetailMapper.insertCtBuInvoiceReqDetail(ctBuInvoiceReqDetail);
    }

    /**
     * 修改发票申请明细
     * 
     * @param ctBuInvoiceReqDetail 发票申请明细
     * @return 结果
     */
    @Override
    public int updateCtBuInvoiceReqDetail(CtBuInvoiceReqDetail ctBuInvoiceReqDetail)
    {
        ctBuInvoiceReqDetail.setUpdateTime(DateUtils.getNowDate());
        return ctBuInvoiceReqDetailMapper.updateCtBuInvoiceReqDetail(ctBuInvoiceReqDetail);
    }

    /**
     * 批量删除发票申请明细
     * 
     * @param ids 需要删除的发票申请明细ID
     * @return 结果
     */
    @Override
    public int deleteCtBuInvoiceReqDetailByIds(String[] ids)
    {
        return ctBuInvoiceReqDetailMapper.deleteCtBuInvoiceReqDetailByIds(ids);
    }
    /**
     * 批量删除发票申请明细
     *
     * @param ids 需要删除的发票申请明细ID
     * @return 结果
     */
    @Override
    public int delCtBuInvoiceReqDetailByIds(String[] ids)
    {
        return ctBuInvoiceReqDetailMapper.delCtBuInvoiceReqDetailByIds(ids);
    }

    /**
     * 删除发票申请明细信息
     * 
     * @param id 发票申请明细ID
     * @return 结果
     */
    @Override
    public int deleteCtBuInvoiceReqDetailById(String id)
    {
        return ctBuInvoiceReqDetailMapper.deleteCtBuInvoiceReqDetailById(id);
    }
}
