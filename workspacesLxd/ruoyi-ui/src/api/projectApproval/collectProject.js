import request from '@/utils/request'

// 查询发Fiji看详细
export function copyReqInfo(id) {
  return request({
    url: '/projectApproval/collectProject/copyReqInfo/' + id,
    method: 'get'
  })
}
// 查询发Fiji看详细
export function getFjkDetail(id) {
  return request({
    url: '/projectApproval/appNgc/' + id,
    method: 'get'
  })
}
// 查询事前审批主(集客类)列表
export function listCollectProject(query) {
  return request({
    url: '/projectApproval/collectProject/list',
    method: 'get',
    params: query
  })
}

// 查询事前审批主(集客类)详细
export function getCollectProject(id) {
  return request({
    url: '/projectApproval/collectProject/' + id,
    method: 'get'
  })
}

// 新增事前审批主(集客类)
export function addCollectProject(data) {
  return request({
    url: '/projectApproval/collectProject',
    method: 'post',
    data: data
  })
}

// 修改事前审批主(集客类)
export function updateCollectProject(data) {
  return request({
    url: '/projectApproval/collectProject',
    method: 'put',
    data: data
  })
}

// 删除事前审批主(集客类)
export function delCollectProject(id) {
  return request({
    url: '/projectApproval/collectProject/' + id,
    method: 'delete'
  })
}

// 导出事前审批主(集客类)
export function exportCollectProject(query) {
  return request({
    url: '/projectApproval/collectProject/export',
    method: 'get',
    params: query
  })
}

// 获取当前用户信息
export function getUserInfo(data) {
  return request({
    url: '/collection/collection/getUserInfo',
    method: 'get'
  })
}

// 新增事前审批主(集客类)
export function addCollectProject_(data) {
  return request({
    url: '/projectApproval/collectProject/addNg',
    method: 'post',
    data: data
  })
}

// 修改事前审批主(集客类)
export function updateCollectProject_(data) {
  return request({
    url: '/projectApproval/collectProject/editNg',
    method: 'put',
    data: data
  })
}

// 根据bid和cid查询(集客类)详细
export function getFxCollectProject(id,cid) {
  return request({
    url: '/projectApproval/collectProject/appInfo/' + id+'/'+cid,
    method: 'get'
  })
}

// 事项审批表
export function selectCtBuApprovalNgReqById(id) {
  return request({
    url: '/projectApproval/collectProject/appReqInfo/' + id,
    method: 'get'
  })
}

// 终止流程
export function exitFlow(id,status) {
  if(status==null || status==""){
    status = "ng";
  }
  return request({
    url: '/task/deleteTaskByProcessId/' + id+'/'+status,
    method: 'get'
  })
}

export function listCollectProjects(query) {
  return request({
    url: '/projectApproval/collectProject/lists',
    method: 'get',
    params: query
  })
}
