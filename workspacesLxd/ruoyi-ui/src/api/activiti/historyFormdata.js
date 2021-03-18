import request from '@/utils/request'

//查询非极客10w一下详情
export function getNgcAudit(id) {
  return request({
    url: '/projectApproval/appNgc/'+id,
   method: 'get'
  })
}
// 查询请假详细
export function historyFromData(instanceId) {
  return request({
    url: '/historyFromData/ByInstanceId/' + instanceId,
    method: 'get'
  })
}

export function getCollection(bussKey) {
  return request({
    url: '/collection/collection/' + bussKey,
    method: 'get'
  })
}

export function getCollectionAudit(bussKey) {
  return request({
    url: '/collection/receiptInfo/' + bussKey,
    method: 'get'
  })
}

export function getByBusinessKey(bussKey) {
  return request({
    url: '/workFlowFormData/' + bussKey,
    method: 'get'
  })
}
