package com.ruoyi.projectApproval.ApprovalNg.mapper;

import java.util.Date;
import java.util.List;

import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuApprovalNg;
import org.apache.ibatis.annotations.Param;

/**
 * 事前审批主(集客类)Mapper接口
 *
 * @author Mu
 * @date 2020-12-08
 */
public interface CtBuApprovalNgMapper {


    /**
     * 精确而查询事前审批主(集客类)
     *
     * @param id 事前审批主(集客类)ID
     * @return 事前审批主(集客类)
     */
    public CtBuApprovalNg selectCtBuApprovalNgById(String id);

    /**
     * jingue查询事前审批主(集客类)列表
     *
     * @param ctBuApprovalNg 事前审批主(集客类)
     * @return 事前审批主(集客类)集合
     */
    public List<CtBuApprovalNg> selectCtBuApprovalNgListByJq(CtBuApprovalNg ctBuApprovalNg);

    /**
     * 查询事前审批主(集客类)列表
     *
     * @param ctBuApprovalNg 事前审批主(集客类)
     * @return 事前审批主(集客类)集合
     */
    public List<CtBuApprovalNg> selectCtBuApprovalNgList(CtBuApprovalNg ctBuApprovalNg);

    /**
     * 新增事前审批主(集客类)
     *
     * @param ctBuApprovalNg 事前审批主(集客类)
     * @return 结果
     */
    public int insertCtBuApprovalNg(CtBuApprovalNg ctBuApprovalNg);

    /**
     * 修改事前审批主(集客类)
     *
     * @param ctBuApprovalNg 事前审批主(集客类)
     * @return 结果
     */
    public int updateCtBuApprovalNg(CtBuApprovalNg ctBuApprovalNg);

    /**
     * 根据市里id修改状态
     *
     * @param ctBuApprovalNg 事前审批主(集客类)
     * @return 结果
     */
    public int updateCtBuApprovalNgByInstanceId(CtBuApprovalNg ctBuApprovalNg);

    /**
     * 删除事前审批主(集客类)
     *
     * @param id 事前审批主(集客类)ID
     * @return 结果
     */
    public int deleteCtBuApprovalNgById(String id);

    /**
     * 批量删除事前审批主(集客类)
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCtBuApprovalNgByIds(String[] ids);

    /**
     * 集客立项统计
     *
     * @param companyId
     * @return
     */
    public int countApprovalNgByCompanyId(@Param("companyId") Long companyId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}