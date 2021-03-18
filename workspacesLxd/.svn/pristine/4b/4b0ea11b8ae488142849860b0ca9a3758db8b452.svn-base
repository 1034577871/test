package com.ruoyi.projectApproval.AppNgc.mapper;

import java.util.Date;
import java.util.List;

import com.ruoyi.projectApproval.AppNgc.domain.AppNgc;
import org.apache.ibatis.annotations.Param;

/**
 * 非集客项目Mapper接口
 *
 * @author ruoyi
 * @date 2020-12-11
 */
public interface AppNgcMapper {

    /**
     * 查询非集客项目
     *
     * @param id 非集客项目ID
     * @return 非集客项目
     */
    public AppNgc selectAppNgcById(String id);

    /**
     * 查询非集客项目列表
     *
     * @param appNgc 非集客项目
     * @return 非集客项目集合
     */
    public List<AppNgc> selectAppNgcList(AppNgc appNgc);

    /**
     * 查询非集客项目列表(加权限)
     *
     * @param appNgc 非集客项目
     * @return 非集客项目集合
     */
    public List<AppNgc> selectAppNgcList1(AppNgc appNgc);

    /**
     * 新增非集客项目
     *
     * @param appNgc 非集客项目
     * @return 结果
     */
    public int insertAppNgc(AppNgc appNgc);

    /**
     * 修改非集客项目
     *
     * @param appNgc 非集客项目
     * @return 结果
     */
    public int updateAppNgc(AppNgc appNgc);

    /**
     * 修改非集客项目genju instanceid
     *
     * @param appNgc 非集客项目
     * @return 结果
     */
    public int updateAppNgcByInstanceId(AppNgc appNgc);

    /**
     * 删除非集客项目
     *
     * @param id 非集客项目ID
     * @return 结果
     */
    public int deleteAppNgcById(String id);

    /**
     * 批量删除非集客项目
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAppNgcByIds(String[] ids);

    /**
     * @Title: AppNgcMapper.java
     * @Description: 根据时间获取对应时间内的条数
     * @Author M.Mu
     * @Date 2020-12-11
     */
    public Integer findNumsByData(AppNgc appNgc);

    /**
     * 校验项目名称是否唯一
     *
     * @param proName 项目名称
     * @return 结果
     */
    public int checkProNameUnique(String proName);

    /**
     * 逻辑删除非集客项目
     *
     * @param id 非集客项目ID
     * @return 结果
     */
    public int updateAppNgcById(String id);

    /**
     * 非集客立项统计
     *
     * @param companyId
     * @return
     */
    public int countAppNgcByCompanyId(@Param("companyId") Long companyId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}