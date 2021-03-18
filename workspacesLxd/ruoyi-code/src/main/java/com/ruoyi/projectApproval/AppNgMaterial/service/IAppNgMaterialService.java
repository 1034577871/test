package com.ruoyi.projectApproval.AppNgMaterial.service;

import java.util.List;

import com.ruoyi.projectApproval.AppNgMaterial.domain.AppNgMaterial;

/**
 * 事前审批明细(集客类-材料使用情况)Service接口
 *
 * @author Mu
 * @date 2020-12-09
 */
public interface IAppNgMaterialService {

    /**
     * 查询事前审批明细(集客类-材料使用情况)
     *
     * @param id 事前审批明细(集客类-材料使用情况)ID
     * @return 事前审批明细(集客类 - 材料使用情况)
     */
    public AppNgMaterial selectAppNgMaterialById(String id);

    /**
     * @Title: IAppNgMaterialService.java
     * @Description: 根据事前审批主表ID获取材料使用信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    public AppNgMaterial selectAppNgMaterialByBid(String id);

    /**
     * 查询事前审批明细(集客类-材料使用情况)列表
     *
     * @param appNgMaterial 事前审批明细(集客类-材料使用情况)
     * @return 事前审批明细(集客类 - 材料使用情况)集合
     */
    public List<AppNgMaterial> selectAppNgMaterialList(AppNgMaterial appNgMaterial);

    /**
     * 新增事前审批明细(集客类-材料使用情况)
     *
     * @param appNgMaterial 事前审批明细(集客类-材料使用情况)
     * @return 结果
     */
    public int insertAppNgMaterial(AppNgMaterial appNgMaterial);

    /**
     * 修改事前审批明细(集客类-材料使用情况)
     *
     * @param appNgMaterial 事前审批明细(集客类-材料使用情况)
     * @return 结果
     */
    public int updateAppNgMaterial(AppNgMaterial appNgMaterial);

    /**
     * 批量删除事前审批明细(集客类-材料使用情况)
     *
     * @param ids 需要删除的事前审批明细(集客类-材料使用情况)ID
     * @return 结果
     */
    public int deleteAppNgMaterialByIds(String[] ids);

    /**
     * 删除事前审批明细(集客类-材料使用情况)信息
     *
     * @param id 事前审批明细(集客类-材料使用情况)ID
     * @return 结果
     */
    public int deleteAppNgMaterialById(String id);

    /**
     * @Title: IAppNgMaterialService.java
     * @Description: 根据事前审批主表ID逻辑删除材料使用信息
     * @Author M.Mu
     * @Date 2020-12-09
     */
    public int deleteAppNgMaterialByBid(String id);
}