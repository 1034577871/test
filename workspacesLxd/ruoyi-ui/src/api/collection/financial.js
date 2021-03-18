import request from '@/utils/request'


// 新增财务开票
export function uploadFiles(data) {
  return request({
    url: '/collection/financial',
    method: 'post',
    data: data
  })
}



// 查询财务开票列表
export function listFinancial(query) {
  return request({
    url: '/collection/financial/list',
    method: 'get',
    params: query
  })
}

// 查询财务开票详细
export function getFinancial(id,rid) {
  return request({
    url: '/collection/financial/' + id+'/'+rid,
    method: 'get'
  })
}

// 新增财务开票
export function addFinancial(data) {
  return request({
    url: '/collection/financial',
    method: 'post',
    data: data
  })
}

// 修改财务开票
export function updateFinancial(data) {
  return request({
    url: '/collection/financial',
    method: 'put',
    data: data
  })
}

// 删除财务开票
export function delFinancial(id) {
  return request({
    url: '/collection/financial/' + id,
    method: 'delete'
  })
}

// 导出财务开票
export function exportFinancial(query) {
  return request({
    url: '/collection/financial/export',
    method: 'get',
    params: query
  })
}

export function getSlList(){
    //查询企业信息列表
    return request({
      url:'/dictionary/taxrate/list',
      methods:'get'
    });
  }

// 开票信息统计
export function invoiceStatistics(query) {
  return request({
    url: '/collection/financial/invoiceStatistics',
    method: 'get',
    params: query
  })
}

//本月未录入凭证号列表
export function voucherWarning(){
    return request({
      url:'/collection/financial/voucherWarning',
      methods:'get'
    });
  }

// 查询财务开票详细
export function selectTotalInfo(rid) {
  return request({
    url: '/collection/financial/selectTotalInfo/'+rid,
    method: 'get'
  })
}
// 查询财务开票详细
export function getInfoById(rid) {
  return request({
    url: '/collection/financial/getInfoById/'+rid,
    method: 'get'
  })
}
