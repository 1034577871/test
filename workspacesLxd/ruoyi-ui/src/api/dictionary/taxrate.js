import request from '@/utils/request'

// 查询税率字典列表
export function listTaxrate(query) {
  return request({
    url: '/dictionary/taxrate/list',
    method: 'get',
    params: query
  })
}

// 查询税率字典详细
export function getTaxrate(id) {
  return request({
    url: '/dictionary/taxrate/' + id,
    method: 'get'
  })
}

// 新增税率字典
export function addTaxrate(data) {
  return request({
    url: '/dictionary/taxrate',
    method: 'post',
    data: data
  })
}

// 修改税率字典
export function updateTaxrate(data) {
  return request({
    url: '/dictionary/taxrate',
    method: 'put',
    data: data
  })
}

// 删除税率字典
export function delTaxrate(id) {
  return request({
    url: '/dictionary/taxrate/' + id,
    method: 'put'
  })
}

// 导出税率字典
export function exportTaxrate(query) {
  return request({
    url: '/dictionary/taxrate/export',
    method: 'get',
    params: query
  })
}
