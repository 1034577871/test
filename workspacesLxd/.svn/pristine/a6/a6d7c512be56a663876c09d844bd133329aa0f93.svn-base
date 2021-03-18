import request from '@/utils/request'

// 查询付款申请单明细列表
export function listPayinfoDt(query) {
  return request({
    url: '/paymentManagement/payinfoDt/list',
    method: 'get',
    params: query
  })
}

// 查询付款申请单明细详细
export function getPayinfoDt(id) {
  return request({
    url: '/paymentManagement/payinfoDt/' + id,
    method: 'get'
  })
}

// 新增付款申请单明细
export function addPayinfoDt(data) {
  return request({
    url: '/paymentManagement/payinfoDt',
    method: 'post',
    data: data
  })
}

// 修改付款申请单明细
export function updatePayinfoDt(data) {
  return request({
    url: '/paymentManagement/payinfoDt',
    method: 'put',
    data: data
  })
}

// 删除付款申请单明细
export function delPayinfoDt(id) {
  return request({
    url: '/paymentManagement/payinfoDt/' + id,
    method: 'delete'
  })
}

// 导出付款申请单明细
export function exportPayinfoDt(query) {
  return request({
    url: '/paymentManagement/payinfoDt/export',
    method: 'get',
    params: query
  })
}