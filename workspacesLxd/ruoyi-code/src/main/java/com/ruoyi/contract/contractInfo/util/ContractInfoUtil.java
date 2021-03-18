package com.ruoyi.contract.contractInfo.util;


import com.ruoyi.contract.contractContent.domain.CtBuContractContent;
import com.ruoyi.contract.contractInfo.domain.CtBuContract;
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;

/**
 * 合同非空校验
 */
// @Component
public class ContractInfoUtil {


    public static void checkContractInfo(CtBuContract ctBuContract) {

//        AjaxError.byIsNull(ctBuContract.getProjectCategory(), "项目类别 不能为空");    // 验证: 项目类别
//        AjaxError.byIsNull(ctBuContract.getProjectId(), "项目名称 不能为空");    // 验证: 项目ID
//        AjaxError.byIsNull(ctBuContract.getProjectNo(), "项目名称 不能为空");    // 验证: 项目编号
        AjaxError.byIsNull(ctBuContract.getProjectName(), "项目名称 不能为空");    // 验证: 项目名称
        AjaxError.byIsNull(ctBuContract.getContractName(), "合同名称 不能为空");    // 验证: 合同名称
        AjaxError.byIsNull(ctBuContract.getContractCategory(), "合同类别 不能为空");    // 验证: 合同类别
//        AjaxError.byIsNull(ctBuContract.getIncomeType(), "收入类型 不能为空");    // 验证: 收入类型
        AjaxError.byIsNull(ctBuContract.getOppositeName(), "对方单位名称 不能为空");
        AjaxError.byIsNull(ctBuContract.getOurName(), "我方单位名称 不能为空");
        AjaxError.byIsNull(ctBuContract.getOurContacts(), "我方单位联系人 不能为空");
//        AjaxError.byIsNull(ctBuContract.getStarttime(), "合同签订日期 不能为空");
//        AjaxError.byIsNull(ctBuContract.getEndtime(), "合同截止日期 不能为空");
        AjaxError.byIsNull(ctBuContract.getContractServeStart(), "合同服务开始日期 不能为空");
        AjaxError.byIsNull(ctBuContract.getServiceTerm(), "服务期限 不能为空");
        AjaxError.byIsNull(ctBuContract.getTotalMoney(), "合同标的额 不能为空");
        AjaxError.byIsNull(ctBuContract.getTaxrate(), "税率 不能为空");
//        AjaxError.byIsNull(ctBuContract.getNotTaxMoney(), "不含税金额 不能为空");
//        AjaxError.byIsNull(ctBuContract.getPayMethod(), "付款方式 不能为空");
        AjaxError.byIsNull(ctBuContract.getManageDeptment(), "经办部门 不能为空");
        AjaxError.byIsNull(ctBuContract.getManageUser(), "经办人 不能为空");
//        AjaxError.byIsNull(ctBuContract.getArchiveFiles(), "合同归档资料 不能为空");
//        AjaxError.byIsNull(ctBuContract.getContractScanningFile(), "合同扫描件 不能为空");
//        AjaxError.byIsNull(ctBuContract.getContractApprovalFile(), "合同签订审批流程附件 不能为空");
//        AjaxError.byIsNull(ctBuContract.getCtBuContractContentList().size(), "合同内容 不能为空");
//        AjaxError.byIsNull(ctBuContract.getCtBuContractPayinfoList().size(), "合同付款 不能为空");

    }

    /**
     * 合同内容非空校验
     *
     * @param ctBuContractContent
     */
    public static void checkContractContent(CtBuContractContent ctBuContractContent) {

        //AjaxError.byIsNull(ctBuContractContent.getContractId(), "合同编号 不能为空");
        AjaxError.byIsNull(ctBuContractContent.getContentType(), "项目类型 不能为空");
        AjaxError.byIsNull(ctBuContractContent.getContentTaxrate(), "类型税率 不能为空");
//        AjaxError.byIsNull(ctBuContractContent.getContentName(), "类型名称 不能为空");
        AjaxError.byIsNull(ctBuContractContent.getIntaxAmount(), "含税金额 不能为空");
//        AjaxError.byIsNull(ctBuContractContent.getExtaxAmount(), "不含税金额 不能为空");

    }

    /**
     * 合同付款非空校验
     *
     * @param ctBuContractPayinfo
     */
    public static void checkContractPayInfo(CtBuContractPayinfo ctBuContractPayinfo) {

        //AjaxError.byIsNull(ctBuContractPayinfo.getContractId(), "合同编号 不能为空");
        AjaxError.byIsNull(ctBuContractPayinfo.getEstimateTime(), "预计付款时间 不能为空");
//        AjaxError.byIsNull(ctBuContractPayinfo.getConditionInfo(), "付款条件说明 不能为空");
        AjaxError.byIsNull(ctBuContractPayinfo.getPaymentRatio(), "付款比例 不能为空");
//        AjaxError.byIsNull(ctBuContractPayinfo.getEstimateMoney(), "应付款金额 不能为空");

    }


}
