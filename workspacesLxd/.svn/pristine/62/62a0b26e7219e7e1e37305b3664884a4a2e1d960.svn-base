import request from '@/utils/request'

// 查询项目类型字典列表
export function listProtype(query) {
  return request({
    url: '/dictionary/protype/list',
    method: 'get',
    params: query
  })
}

// 查询项目类型字典详细
export function getProtype(id) {
  return request({
    url: '/dictionary/protype/' + id,
    method: 'get'
  })
}

// 新增项目类型字典
export function addProtype(data) {
  return request({
    url: '/dictionary/protype',
    method: 'post',
    data: data
  })
}

// 修改项目类型字典
export function updateProtype(data) {
  return request({
    url: '/dictionary/protype',
    method: 'put',
    data: data
  })
}

// 删除项目类型字典
export function delProtype(id) {
  return request({
    url: '/dictionary/protype/' + id,
    method: 'delete'
  })
}

// 导出项目类型字典
export function exportProtype(query) {
  return request({
    url: '/dictionary/protype/export',
    method: 'get',
    params: query
  })
}