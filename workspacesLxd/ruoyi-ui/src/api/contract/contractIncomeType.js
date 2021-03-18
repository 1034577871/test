import request from '@/utils/request'

// 查询合同收入类型列表
export function listContractIncomeType(query) {
  return request({
    url: '/contractIncomeType/contractIncomeType/list',
    method: 'get',
    params: query
  })
}

// 查询合同收入类型详细
export function getContractIncomeType(id) {
  return request({
    url: '/contractIncomeType/contractIncomeType/' + id,
    method: 'get'
  })
}

// 新增合同收入类型
export function addContractIncomeType(data) {
  return request({
    url: '/contractIncomeType/contractIncomeType',
    method: 'post',
    data: data
  })
}

// 修改合同收入类型
export function updateContractIncomeType(data) {
  return request({
    url: '/contractIncomeType/contractIncomeType',
    method: 'put',
    data: data
  })
}

// 删除合同收入类型
export function delContractIncomeType(id) {
  return request({
    url: '/contractIncomeType/contractIncomeType/' + id,
    method: 'delete'
  })
}

// 导出合同收入类型
export function exportContractIncomeType(query) {
  return request({
    url: '/contractIncomeType/contractIncomeType/export',
    method: 'get',
    params: query
  })
}