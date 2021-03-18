import request from '@/utils/request'


// 查询收款单录入列表
export function listFinancialList(query) {
  return request({
    url: '/collection/receiptInfo/hxlist',
    method: 'get',
    params: query
  })
}
// 查询收款单录入列表
export function listReceiptInfo(query) {
  return request({
    url: '/collection/receiptInfo/list',
    method: 'get',
    params: query
  })
}

// 查询收款单录入详细
export function getReceiptInfo(id) {
  return request({
    url: '/collection/receiptInfo/' + id,
    method: 'get'
  })
}

// 新增收款单录入
export function addReceiptInfo(data) {
  return request({
    url: '/collection/receiptInfo',
    method: 'post',
    data: data
  })
}

// 修改收款单录入
export function updateReceiptInfo(data) {
  return request({
    url: '/collection/receiptInfo',
    method: 'put',
    data: data
  })
}

// 删除收款单录入
export function delReceiptInfo(id) {
  return request({
    url: '/collection/receiptInfo/' + id,
    method: 'delete'
  })
}

// 导出收款单录入
export function exportReceiptInfo(query) {
  return request({
    url: '/collection/receiptInfo/export',
    method: 'get',
    params: query
  })
}

export function uploadAnnex(data) {
  return request({
    url: '/collection/receiptInfo/add',
    method: 'post',
    data: data
  })
}


export function moveFinancial_(id,flag) {
  return request({
    url: '/collection/financial/moveFinal/'+id+'/'+flag,
    method: 'get'
  })
}
