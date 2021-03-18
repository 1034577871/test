import request from '@/utils/request'

// 查询合同预警列表
export function listWarning(query) {
  return request({
    url: '/contract/warning/list',
    method: 'get',
    params: query
  })
}

// 查询合同预警详细
export function getWarning(id) {
  return request({
    url: '/contract/warning/' + id,
    method: 'get'
  })
}

// 新增合同预警
export function addWarning(data) {
  return request({
    url: '/contract/warning',
    method: 'post',
    data: data
  })
}

// 修改合同预警
export function updateWarning(data) {
  return request({
    url: '/contract/warning',
    method: 'put',
    data: data
  })
}

// 删除合同预警
export function delWarning(id) {
  return request({
    url: '/contract/warning/' + id,
    method: 'delete'
  })
}

// 导出合同预警
export function exportWarning(query) {
  return request({
    url: '/contract/warning/export',
    method: 'get',
    params: query
  })
}