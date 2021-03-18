package com.ruoyi.projectApproval.AppNgMaterial.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.projectApproval.AppNgMaterial.domain.AppNgMaterial;
import com.ruoyi.projectApproval.AppNgMaterial.mapper.AppNgMaterialMapper;
import com.ruoyi.projectApproval.AppNgMaterial.service.IAppNgMaterialService;

/**
 * 事前审批明细(集客类-材料使用情况)Service业务层处理
 *
 * @author Mu
 * @date 2020-12-09
 */
@Service
public class AppNgMaterialServiceImpl implements IAppNgMaterialService {

    @Autowired
    private AppNgMaterialMapper appNgMaterialMapper;

    /**
     * 查询事前审批明细(集客类-材料使用情况)
     *
     * @param id 事前审批明细(集客类-材料使用情况)ID
     * @return 事前审批明细(集客类 - 材料使用情况)
     */
    @Override
    public AppNgMaterial selectAppNgMaterialById(String id) {
        return appNgMaterialMapper.selectAppNgMaterialById(id);
    }

    /**
     * @Title: IAppNgMaterialService.java
     * @Description: 根据事前审批主表ID获取材料使用信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    @Override
    public AppNgMaterial selectAppNgMaterialByBid(String id) {

        return appNgMaterialMapper.selectAppNgMaterialByBid(id);
    }

    /**
     * 查询事前审批明细(集客类-材料使用情况)列表
     *
     * @param appNgMaterial 事前审批明细(集客类-材料使用情况)
     * @return 事前审批明细(集客类 - 材料使用情况)
     */
    @Override
    public List<AppNgMaterial> selectAppNgMaterialList(AppNgMaterial appNgMaterial) {
        return appNgMaterialMapper.selectAppNgMaterialList(appNgMaterial);
    }

    /**
     * 新增事前审批明细(集客类-材料使用情况)
     *
     * @param appNgMaterial 事前审批明细(集客类-材料使用情况)
     * @return 结果
     */
    @Override
    public int insertAppNgMaterial(AppNgMaterial appNgMaterial) {
        appNgMaterial.setCreateTime(DateUtils.getNowDate());
        return appNgMaterialMapper.insertAppNgMaterial(appNgMaterial);
    }

    /**
     * 修改事前审批明细(集客类-材料使用情况)
     *
     * @param appNgMaterial 事前审批明细(集客类-材料使用情况)
     * @return 结果
     */
    @Override
    public int updateAppNgMaterial(AppNgMaterial appNgMaterial) {
        appNgMaterial.setUpdateTime(DateUtils.getNowDate());
        return appNgMaterialMapper.updateAppNgMaterial(appNgMaterial);
    }

    /**
     * 批量删除事前审批明细(集客类-材料使用情况)
     *
     * @param ids 需要删除的事前审批明细(集客类-材料使用情况)ID
     * @return 结果
     */
    @Override
    public int deleteAppNgMaterialByIds(String[] ids) {
        return appNgMaterialMapper.deleteAppNgMaterialByIds(ids);
    }

    /**
     * 删除事前审批明细(集客类-材料使用情况)信息
     *
     * @param id 事前审批明细(集客类-材料使用情况)ID
     * @return 结果
     */
    @Override
    public int deleteAppNgMaterialById(String id) {
        return appNgMaterialMapper.deleteAppNgMaterialById(id);
    }

    /**
     * @Title: IAppNgMaterialService.java
     * @Description: 根据事前审批主表ID逻辑删除材料使用信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    @Override
    public int deleteAppNgMaterialByBid(String id) {

        return appNgMaterialMapper.deleteAppNgMaterialByBid(id);
    }
}