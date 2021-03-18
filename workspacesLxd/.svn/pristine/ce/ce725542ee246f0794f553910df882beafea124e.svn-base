package com.ruoyi.projectApproval.AppNgCompany.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.projectApproval.AppNgBase.domain.AppNgBase;
import com.ruoyi.projectApproval.AppNgConst.domain.AppNgConst;
import com.ruoyi.projectApproval.AppNgMaterial.domain.AppNgMaterial;
import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuApprovalNg;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 事前审批明细(集客类-涉及分公司)对象 ct_bu_approvaldt_ng_company
 *
 * @author ruoyi
 * @date 2021-01-19
 */
public class CtBuApprovaldtNgCompanys extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private String deptId;

    private List<AppNgBase> appNgBaseList;

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public List<AppNgBase> getAppNgBaseList() {
        return appNgBaseList;
    }

    public void setAppNgBaseList(List<AppNgBase> appNgBaseList) {
        this.appNgBaseList = appNgBaseList;
    }


    public List<List<AppNgMaterial>> getAppNgMaterialLists() {
        return appNgMaterialLists;
    }

    public void setAppNgMaterialLists(List<List<AppNgMaterial>> appNgMaterialLists) {
        this.appNgMaterialLists = appNgMaterialLists;
    }

    public List<List<AppNgConst>> getAppNgConstLists() {
        return appNgConstLists;
    }

    public void setAppNgConstLists(List<List<AppNgConst>> appNgConstLists) {
        this.appNgConstLists = appNgConstLists;
    }

    private List<List<AppNgMaterial>> appNgMaterialLists;
    private List<List<AppNgConst>> appNgConstLists;


}
