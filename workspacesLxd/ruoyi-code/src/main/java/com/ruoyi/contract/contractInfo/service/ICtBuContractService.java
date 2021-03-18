package com.ruoyi.contract.contractInfo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import org.springframework.stereotype.Component;

/**
 * 合同信息录入主Service接口
 *
 * @author ruoyi
 * @date 2020-12-08
 */
@Component
public interface ICtBuContractService {
    /**
     * 查询合同信息录入主
     *
     * @param id 合同信息录入主ID
     * @return 合同信息录入主
     */
    public CtBuContract selectCtBuContractById(String id);

    /**
     * 查询合同信息录入主列表与金额统计
     *
     * @param ctBuContract 合同信息录入主
     * @return 合同信息录入主集合
     */
    public List<Object> selectCtBuContractListSum(CtBuContract ctBuContract);

    /**
     * 查询合同信息录入主列表与金额统计
     *
     * @param ctBuContract 合同信息录入主
     * @return 合同信息录入主集合
     */
    public Map<String, BigDecimal> selectCtBuContractSum(CtBuContract ctBuContract);

    /**
     * 查询合同信息录入主列表（带权限）
     *
     * @param ctBuContract 合同信息录入主
     * @return 合同信息录入主集合
     */
    public List<CtBuContract> selectCtBuContractList(CtBuContract ctBuContract);

    /**
     * 查询合同信息录入主列表（关联项目表）
     *
     * @param ctBuContract 合同信息录入主
     * @return 合同信息录入主集合
     */
    public List<CtBuContract> selectCtBuContractList1(CtBuContract ctBuContract);

    /**
     * 查询合同信息录入主列表
     *
     * @param ctBuContract 合同信息录入主
     * @return 合同信息录入主集合
     */
    public List<CtBuContract> selectCtBuContractList2(CtBuContract ctBuContract);

    /**
     * 新增合同信息录入主
     *
     * @param ctBuContract 合同信息录入主
     * @return 结果
     */
    public int insertCtBuContract(CtBuContract ctBuContract);

    /**
     * 修改合同信息录入主
     *
     * @param ctBuContract 合同信息录入主
     * @return 结果
     */
    public int updateCtBuContract(CtBuContract ctBuContract);

    /**
     * 批量删除合同信息录入主
     *
     * @param ids 需要删除的合同信息录入主ID
     * @return 结果
     */
    public int deleteCtBuContractByIds(String[] ids);

    /**
     * 删除合同信息录入主信息
     *
     * @param id 合同信息录入主ID
     * @return 结果
     */
    public int deleteCtBuContractById(String id);


    /**
     * 批量逻辑删除合同信息录入主
     *
     * @param ids 需要删除的合同信息录入主ID
     * @return 结果
     */
    public int updateCtBuContractByIds(String[] ids);

    /**
     * 查询需预警付款信息
     */
    public void selectWarning();

    /**
     * 保存付款记录信息
     */
    public int saveTicketInfo(CtBuContract ctBuContract);

    /**
     * 根据实例ID修改合同信息录入主
     *
     * @param ctBuContract 合同信息录入主
     * @return 结果
     */
    public int updateCtBuContractByInstanceId(CtBuContract ctBuContract);


    /**
     * 项目统计
     *
     * @return
     */
    public List<HashMap<String, Object>> projectCount();


    public List<CtBuContract> collectionAndPaymentStatistics(CtBuContract ctBuContract);


    /**
     * 合同统计列表查询
     *
     * @param companyId
     * @param type
     * @return
     */
    public List<CtBuContract> contractStatisticsList(String companyId, Integer type);


    public List<HashMap<String, Object>> contractCount(Date beginTime, Date endTime);


    /**
     * 合同预警列表
     *
     * @return
     */
    public List<HashMap<String, Object>> contractWarningList();

    /**
     * 首页本月合同统计
     * @return
     */
    public HashMap<String, Object> countContractIndex(CtBuContract ctBuContract);

    /**
     * 根据收付款周期预警
     * @param ctBuContract
     * @return
     */
    public List<HashMap<String, Object>> notReceivedWarning(CtBuContract ctBuContract);

    /**
     * 法务合同归档
     * @param ids
     * @return
     */
    public int updateIsArchiveByIds(String[] ids);

    /**
     * 取消归档
     * @param ids
     * @return
     */
    public int updateCancelIsArchiveByIds(String[] ids);
}
