package com.ruoyi.activiti.domain;

import com.ruoyi.activiti.domain.dto.ActWorkflowFormDataDTO;
import org.activiti.api.task.model.Task;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态单对象 act_workflow_formdata
 *
 * @author danny
 * @date 2020-11-02
 */
public class Invoice extends BaseEntity {

    public Long fcwstate;
    public Long fgsstate;

    public Long getFcwstate() {
        return fcwstate;
    }

    public void setFcwstate(Long fcwstate) {
        this.fcwstate = fcwstate;
    }

    public Long getFgsstate() {
        return fgsstate;
    }

    public void setFgsstate(Long fgsstate) {
        this.fgsstate = fgsstate;
    }

    public Long getBcwstate() {
        return bcwstate;
    }

    public void setBcwstate(Long bcwstate) {
        this.bcwstate = bcwstate;
    }

    public Long bcwstate;

}