import request from '@/utils/request'


// 转派操作
export function confirmTransfer(id,userName) {
  return request({
    url: '/task/setAssigns/'+id+'/'+userName,
    method: 'get',
  })
}
// 查询本部其他人员
export function getUserByRole(query) {
  return request({
    url: '/system/user/getUserByRole/',
    method: 'get',
     params: query
  })
}
// 查看流程图
export const showDiagram = (params) => {
    return request({
        url: '/task/exportImage/',
        method: 'get',
        responseType: 'arraybuffer', // 留意这个需要是arraybuffer
      })
}


// g根据proessinstanceid查询busskey
export function findProcessPic(processInstanceId) {
  return request({
    url: '/task/exportImage/'+processInstanceId,
    method: 'get',
    responseType: 'arraybuffer', //
  })
}
// g根据proessinstanceid查询busskey
export function selectBuessKeyByExe(id) {
  return request({
    url: '/task/selectBuessKeyByExe/'+id,
    method: 'get',
  })
}
// 查询task列表
export function listTasks_(query) {
  return request({
    url: '/task/queryDoneTasks',
    method: 'get',
    params: query
  })
}



// 查询task列表
export function listTask(query) {
  return request({
    url: '/task/list',
    method: 'get',
    params: query
  })
}

// 查询表单
export function formDataShow(taskID) {
  return request({
    url: '/task/formDataShow/'+taskID,
    method: 'get',
  })
}

// 查询表单
export function formDataSave(taskID,data) {
  return request({
    url: '/task/formDataSave/'+taskID,
    method: 'post',
    data:data
  })
}
// 查询表单
export function formDataSaves(taskID,data,uploads,nid) {
  return request({
    url: '/task/formDataSaves/'+taskID+'/'+uploads+'/'+nid,
    method: 'post',
    data:data
  })
}
// 修改附件
export function updateCtBuApprovalNgOld(data,uploads,nid) {
  return request({
    url: '/projectApproval/collectProject/updateCtBuApprovalNgOld/'+uploads+'/'+nid,
    method: 'post',
    data:data
  })
}
