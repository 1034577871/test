package com.ruoyi.activiti.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;
import org.activiti.api.task.model.Task;
import org.activiti.engine.runtime.ProcessInstance;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ActTaskVO   extends BaseEntity implements Comparable<ActTaskVO>{

    private static final long serialVersionUID = 1L;

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    private String applyName;
    private String statusName;
    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    private String assignee;

    private String id;

    private String name;

    private String status;


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;
    private String instanceName;
    private String definitionKey;
    private String businessKey;

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    private String instanceId;

    public ActTaskVO() {
    }

    public ActTaskVO(Task task, ProcessInstance processInstance) {
        this.id = task.getId();
        this.name = task.getName();
        this.status = task.getStatus().toString();
        this.createdDate = task.getCreatedDate();
        this.instanceName = processInstance.getName();
        this.definitionKey=processInstance.getProcessDefinitionKey();
        this.businessKey=processInstance.getBusinessKey();
        this.instanceId=processInstance.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public String getDefinitionKey() {
        return definitionKey;
    }

    public void setDefinitionKey(String definitionKey) {
        this.definitionKey = definitionKey;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    @Override
    public int compareTo(ActTaskVO o) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date dt1 = (this.getCreatedDate());
            Date dt2 = o.getCreatedDate();
            // 这是由大向小排序   如果要由小向大转换比较符号就可以
            if (dt1.getTime() > dt2.getTime()) {
                return -1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
