import request from '@/utils/request'

// 查询地区信息字典列表
export function listArea(query) {
  return request({
    url: '/dictionary/area/list',
    method: 'get',
    params: query
  })
}

// 查询地区信息字典详细
export function getArea(id) {
  return request({
    url: '/dictionary/area/' + id,
    method: 'get'
  })
}

// 新增地区信息字典
export function addArea(data) {
  return request({
    url: '/dictionary/area',
    method: 'post',
    data: data
  })
}

// 修改地区信息字典
export function updateArea(data) {
  return request({
    url: '/dictionary/area',
    method: 'put',
    data: data
  })
}

// 删除地区信息字典
export function delArea(id) {
  return request({
    url: '/dictionary/area/' + id,
    method: 'delete'
  })
}

// 导出地区信息字典
export function exportArea(query) {
  return request({
    url: '/dictionary/area/export',
    method: 'get',
    params: query
  })
}