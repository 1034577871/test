import request from '@/utils/request'

// 查询合同内容列表
export function listContractContent(query) {
  return request({
    url: '/contract/contractContent/list',
    method: 'get',
    params: query
  })
}

// 查询合同内容列表(付款吉记录查询)
export function ticketListContractContent(query) {
  return request({
    url: '/contract/contractContent/contractlist',
    method: 'get',
    params: query
  })
}

// 查询合同内容详细
export function getContractContent(id) {
  return request({
    url: '/contract/contractContent/' + id,
    method: 'get'
  })
}

// 新增合同内容
export function addContractContent(data) {
  return request({
    url: '/contract/contractContent',
    method: 'post',
    data: data
  })
}

// 修改合同内容
export function updateContractContent(data) {
  return request({
    url: '/contract/contractContent',
    method: 'put',
    data: data
  })
}

// 删除合同内容
export function delContractContent(id) {
  return request({
    url: '/contract/contractContent/' + id,
    method: 'delete'
  })
}

// 逻辑删除合同内容
export function updateCtBuContractContentByIds(id) {
  return request({
    url: '/contract/contractContent/updateCtBuContractContentByIds/' + id,
    method: 'put'
  })
}

// 导出合同内容
export function exportContractContent(query) {
  return request({
    url: '/contract/contractContent/export',
    method: 'get',
    params: query
  })
}
