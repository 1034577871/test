import request from '@/utils/request'

// 查询预付款
export function findYfk(query) {
  return request({
    url: '/collection/receiptInfo/ysklist',
    method: 'get',
    params: query
  })
}
export function findFpContract(query) {
  return request({
    url: '/contract/contract/list',
    method: 'get',
    params: query
  })
}
// 查询申请记录
export function dwonLoadFile(query,type) {
  return request({
    url: '/dictionary/fileManage/dwonLoadFile/'+query+'/'+type,
    method: 'get'
  })
}

// 查询申请记录
export function findWorkFlowFormData(query) {
  return request({
    url: '/workFlowFormData/list',
    method: 'get',
    params: query
  })
}
// 查询项目信息  非极客
export function listApplyCollection(status,query) {
  var url = '';
  if(status==2){
    url = '/projectApproval/appNgc/list';
  }else{
    url = '/projectApproval/collectProject/list';
  }
  return request({
    url: url,
    method: 'get',
    params: query
  })
}
// 查询项目详情信息  非极客
export function detailNgcApproval(status,id) {
 var url = '';
 if(status==2){
   url = '/projectApproval/appNgc/';
 }else{
   url = '/collection/collection/getApproNgByid/';
 }
  return request({
   url: url + id,
   method: 'get'
  })
}

// 查询合同信息 zck
export function findContract(query) {
  return request({
    url: '/contract/contractInfo/list',
   method: 'get',
   params: query
  })
}
// 查询合同详情信息
export function detailhtCon(id) {
 var url = '/contract/contractInfo/';
  return request({
   url: url + id,
   method: 'get'
  })
}
// 获取当前用户信息
export function getUserInfo(data) {
  return request({
    url: '/collection/collection/getUserInfo',
    method: 'get'
  })
}
