import request from '@/utils/request'

// 查询合同付款列表
export function listContractPayinfo(query) {
  return request({
    url: '/contract/contractPayinfo/list',
    method: 'get',
    params: query
  })
}

// 查询合同付款列表
export function selectCtBuContractPayinfoListConcat(query) {
  return request({
    url: '/contract/contractPayinfo/selectCtBuContractPayinfoListConcat',
    method: 'get',
    params: query
  })
}

// 查询合同付款详细
export function getContractPayinfo(id) {
  return request({
    url: '/contract/contractPayinfo/' + id,
    method: 'get'
  })
}

// 新增合同付款
export function addContractPayinfo(data) {
  return request({
    url: '/contract/contractPayinfo',
    method: 'post',
    data: data
  })
}

// 修改合同付款
export function updateContractPayinfo(data) {
  return request({
    url: '/contract/contractPayinfo',
    method: 'put',
    data: data
  })
}

// 删除合同付款
export function delContractPayinfo(id) {
  return request({
    url: '/contract/contractPayinfo/' + id,
    method: 'delete'
  })
}

// 导出合同付款
export function exportContractPayinfo(query) {
  return request({
    url: '/contract/contractPayinfo/export',
    method: 'get',
    params: query
  })
}