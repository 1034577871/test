import request from '@/utils/request'

// 获取当前用户信息
export function getUserInfoCon(data) {
  return request({
    url: '/collection/collection/getUserInfoCon/'+data,
    method: 'get'
  })
}


// 查询发票申请列表
export function sklistCollection(query) {
  return request({
    url: '/collection/collection/sklist',
    method: 'get',
    params: query
  })
}

// 流程表中增加一条记录
export function updateAct(data) {
  return request({
    url: '/workFlowFormData/add',
    method: 'post',
    data: data
  })
}

// 查询发票申请列表
export function listCollection(query) {
  return request({
    url: '/collection/collection/list',
    method: 'get',
    params: query
  })
}

// 查询发票申请详细
export function getCollection(id) {
  return request({
    url: '/collection/collection/' + id,
    method: 'get'
  })
}

// 新增发票申请
export function addCollection(data) {
  return request({
    url: '/collection/collection',
    method: 'post',
    data: data
  })
}

// 修改发票申请
export function updateCollection(data) {
  return request({
    url: '/collection/collection',
    method: 'put',
    data: data
  })
}

// 删除发票申请
export function delCollection(id) {
  return request({
    url: '/collection/collection/' + id,
    method: 'delete'
  })
}
// 删除发票申请详情
export function delDeatilCollection(id) {
  return request({
    url: '/collectionDetailDetail/collectionDetailDetail/delCtBuInvoiceReqDetailByIds/' + id,
    method: 'delete'
  })
}
// 确认发票申请
export function confrimCollection(id) {
  return request({
    url: '/collection/collection/confirmInvoice/' + id,
    method: 'get'
  })
}

// 导出发票申请
export function exportCollection(query) {
  return request({
    url: '/collection/collection/export',
    method: 'get',
    params: query
  })
}
