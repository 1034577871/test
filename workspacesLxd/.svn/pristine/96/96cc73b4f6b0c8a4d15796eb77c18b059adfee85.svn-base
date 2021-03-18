import request from '@/utils/request'

// 查询非集客项目列表
export function listAppNgc(query) {
  return request({
    url: '/projectApproval/appNgc/list',
    method: 'get',
    params: query
  })
}

// 查询非集客项目详细
export function getAppNgc(id) {
  return request({
    url: '/projectApproval/appNgc/' + id,
    method: 'get'
  })
}

// 新增非集客项目
export function addAppNgc(data) {
  return request({
    url: '/projectApproval/appNgc',
    method: 'post',
    data: data
  })
}

// 修改非集客项目
export function updateAppNgc(data) {
  return request({
    url: '/projectApproval/appNgc',
    method: 'put',
    data: data
  })
}

// 删除非集客项目
export function delAppNgc(id) {
  return request({
    url: '/projectApproval/appNgc/' + id,
    method: 'delete'
  })
}

// 导出非集客项目
export function exportAppNgc(query) {
  return request({
    url: '/projectApproval/appNgc/export',
    method: 'get',
    params: query
  })
}