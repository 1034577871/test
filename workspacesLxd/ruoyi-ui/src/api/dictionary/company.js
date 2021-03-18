import request from '@/utils/request'

// 查询企业信息列表
export function listCompany(query) {
  return request({
    url: '/dictionary/company/list',
    method: 'get',
    params: query
  })
}

// 查询企业信息详细
export function getCompany(id) {
  return request({
    url: '/dictionary/company/' + id,
    method: 'get'
  })
}

// 新增企业信息
export function addCompany(data) {
  return request({
    url: '/dictionary/company',
    method: 'post',
    data: data
  })
}

// 修改企业信息
export function updateCompany(data) {
  return request({
    url: '/dictionary/company',
    method: 'put',
    data: data
  })
}

// 删除企业信息
export function delCompany(id) {
  return request({
    url: '/dictionary/company/' + id,
    method: 'delete'
  })
}

// 导出企业信息
export function exportCompany(query) {
  return request({
    url: '/dictionary/company/export',
    method: 'get',
    params: query
  })
}

// 导出企业信息
export function findAreaList(query) {
  return request({
    url: '/dictionary/area/findAreaList',
    method: 'get',
    params: query
  })
}