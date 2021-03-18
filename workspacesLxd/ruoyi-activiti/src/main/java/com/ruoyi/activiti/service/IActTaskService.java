package com.ruoyi.activiti.service;

import com.github.pagehelper.Page;
import com.ruoyi.activiti.domain.dto.ActTaskVO;
import com.ruoyi.activiti.domain.dto.ActWorkflowFormDataDTO;
import com.ruoyi.activiti.domain.dto.ActTaskDTO;
import com.ruoyi.activiti.domain.dto.SearchTodoTaskVo;
import com.ruoyi.common.core.page.PageDomain;
import org.activiti.engine.history.HistoricTaskInstance;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IActTaskService {

    /**
     * 完结任务
     * @param processId
     */
    public void deleteTaskByProcessId(String processId,String status);
    /**
     * 转派审核人
     * @param taskID
     * @param userName
     */
    public int setAssign(String taskID,String userName);
    /**
     * 查看流程图
     * @param response
     * @param processInstanceId
     */
    public void exportImage(HttpServletResponse response, String processInstanceId);
    public InputStream findProcessPic(String procDefId);
    /**
     * 查询业务表id。
     *
     * @param assignee 用户
     * @return 已处理任务列表
     */

    public Map selectBuessKeyByExe(String id);
    public Page<ActTaskVO> selectProcessDefinitionList(PageDomain pageDomain, SearchTodoTaskVo searchTodoTaskVo);
    public List<String>formDataShow(String taskID);
    public int formDataSave(String taskID, List<ActWorkflowFormDataDTO> awfs,String uploads,String nid) throws ParseException;

    public Page<ActTaskDTO> queryDoneTasks(PageDomain pageDomain,String processDefinitionName,String taskName
            ,String startDueDate,String endDueDate);
}
