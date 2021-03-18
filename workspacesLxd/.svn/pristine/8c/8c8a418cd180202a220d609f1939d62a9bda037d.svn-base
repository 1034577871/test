import request from '@/utils/request'

// 查询付款周期-发票对应关系列表
export function listPayinfoInvoice(query) {
  return request({
    url: '/contract/payinfoInvoice/list',
    method: 'get',
    params: query
  })
}

// 查询付款周期-发票对应关系详细
export function getPayinfoInvoice(id) {
  return request({
    url: '/contract/payinfoInvoice/' + id,
    method: 'get'
  })
}

// 新增付款周期-发票对应关系
export function addPayinfoInvoice(data) {
  return request({
    url: '/contract/payinfoInvoice',
    method: 'post',
    data: data
  })
}

// 修改付款周期-发票对应关系
export function updatePayinfoInvoice(data) {
  return request({
    url: '/contract/payinfoInvoice',
    method: 'put',
    data: data
  })
}

// 删除付款周期-发票对应关系
export function delPayinfoInvoice(id) {
  return request({
    url: '/contract/payinfoInvoice/' + id,
    method: 'delete'
  })
}

// 导出付款周期-发票对应关系
export function exportPayinfoInvoice(query) {
  return request({
    url: '/contract/payinfoInvoice/export',
    method: 'get',
    params: query
  })
}