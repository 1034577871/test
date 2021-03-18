package com.ruoyi.projectApproval.AppxNgReq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projectApproval.AppxNgReq.domain.AppxNgReq;
import com.ruoyi.projectApproval.AppxNgReq.mapper.AppxNgReqMapper;
import com.ruoyi.projectApproval.AppxNgReq.service.IAppxNgReqService;

/**
 * 事前审批Service业务层处理
 *
 * @author Mu
 * @date 2020-12-09
 */
@Service
public class AppxNgReqServiceImpl implements IAppxNgReqService {

    @Autowired
    private AppxNgReqMapper appxNgReqMapper;

    /**
     * 查询事前审批
     *
     * @param id 事前审批ID
     * @return 事前审批
     */
    @Override
    public AppxNgReq selectAppxNgReqById(String id) {
        return appxNgReqMapper.selectAppxNgReqById(id);
    }

    /**
     * @Title: IAppxNgReqService.java
     * @Description: 根据事前审批主表ID获取事前审批信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    @Override
    public AppxNgReq selectAppxNgReqByBid(String id) {

        return appxNgReqMapper.selectAppxNgReqByBid(id);
    }

    /**
     * 查询事前审批列表
     *
     * @param appxNgReq 事前审批
     * @return 事前审批
     */
    @Override
    public List<AppxNgReq> selectAppxNgReqList(AppxNgReq appxNgReq) {
        return appxNgReqMapper.selectAppxNgReqList(appxNgReq);
    }

    /**
     * 新增事前审批
     *
     * @param appxNgReq 事前审批
     * @return 结果
     */
    @Override
    public int insertAppxNgReq(AppxNgReq appxNgReq) {
        appxNgReq.setCreateTime(DateUtils.getNowDate());
        return appxNgReqMapper.insertAppxNgReq(appxNgReq);
    }

    /**
     * 修改事前审批
     *
     * @param appxNgReq 事前审批
     * @return 结果
     */
    @Override
    public int updateAppxNgReq(AppxNgReq appxNgReq) {
        appxNgReq.setUpdateTime(DateUtils.getNowDate());
        return appxNgReqMapper.updateAppxNgReq(appxNgReq);
    }

    /**
     * 批量删除事前审批
     *
     * @param ids 需要删除的事前审批ID
     * @return 结果
     */
    @Override
    public int deleteAppxNgReqByIds(String[] ids) {
        return appxNgReqMapper.deleteAppxNgReqByIds(ids);
    }

    /**
     * 删除事前审批信息
     *
     * @param id 事前审批ID
     * @return 结果
     */
    @Override
    public int deleteAppxNgReqById(String id) {
        return appxNgReqMapper.deleteAppxNgReqById(id);
    }

    /**
     * @Title: IAppxNgReqService.java
     * @Description: 根据事前审批主表ID逻辑删除事前审批信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    @Override
    public int deleteAppxNgReqByBid(String id) {

        return appxNgReqMapper.deleteAppxNgReqByBid(id);
    }

    @Override
    public Integer findNumsByData(AppxNgReq appxNgReq) {

        return appxNgReqMapper.findNumsByData(appxNgReq);
    }
}