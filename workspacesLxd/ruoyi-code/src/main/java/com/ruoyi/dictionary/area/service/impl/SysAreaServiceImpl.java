package com.ruoyi.dictionary.area.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.dictionary.area.domain.SysArea;
import com.ruoyi.dictionary.area.mapper.SysAreaMapper;
import com.ruoyi.dictionary.area.service.ISysAreaService;

/**
 * 地区信息字典Service业务层处理
 * 
 * @author Mu
 * @date 2020-12-08
 */
@Service
public class SysAreaServiceImpl implements ISysAreaService {

	@Autowired
	private SysAreaMapper sysAreaMapper;

	@Autowired
	private RedisTemplate<String, Serializable> redis1;

	/**
	 * 查询地区信息字典
	 * 
	 * @param id 地区信息字典ID
	 * @return 地区信息字典
	 */
	@Override
	public SysArea selectSysAreaById(Integer id) {
		return sysAreaMapper.selectSysAreaById(id);
	}

	/**
	 * 查询地区信息字典列表
	 * 
	 * @param sysArea 地区信息字典
	 * @return 地区信息字典
	 */
	@Override
	public List<SysArea> selectSysAreaList(SysArea sysArea) {
		return sysAreaMapper.selectSysAreaList(sysArea);
	}

	/**
	 * 新增地区信息字典
	 * 
	 * @param sysArea 地区信息字典
	 * @return 结果
	 */
	@Override
	public int insertSysArea(SysArea sysArea) {
		return sysAreaMapper.insertSysArea(sysArea);
	}

	/**
	 * 修改地区信息字典
	 * 
	 * @param sysArea 地区信息字典
	 * @return 结果
	 */
	@Override
	public int updateSysArea(SysArea sysArea) {
		return sysAreaMapper.updateSysArea(sysArea);
	}

	/**
	 * 批量删除地区信息字典
	 * 
	 * @param ids 需要删除的地区信息字典ID
	 * @return 结果
	 */
	@Override
	public int deleteSysAreaByIds(Integer[] ids) {
		return sysAreaMapper.deleteSysAreaByIds(ids);
	}

	/**
	 * 删除地区信息字典信息
	 * 
	 * @param id 地区信息字典ID
	 * @return 结果
	 */
	@Override
	public int deleteSysAreaById(Integer id) {
		return sysAreaMapper.deleteSysAreaById(id);
	}

	@Override
	public Object findAreaList() {
		String key = "areaList";
		Object json = new Object();
		if (redis1.hasKey(key)) {
			json = redis1.opsForValue().get(key);
		} else {
			/** 获取数据顶级类 **/
			SysArea sysArea = new SysArea();
			sysArea.setParentId((long) 0);
			/** 国家列表 **/
			List<SysArea> list = sysAreaMapper.selectSysAreaList(sysArea);
			if (!list.isEmpty()) {
				List<Map<String, Object>> listMaps = new ArrayList<>();
				/** 遍历国家列表，根据国家的ID获取下属省份信息 **/
				for (int i = 0; i < list.size(); i++) {
					Map<String, Object> map = new HashMap<>();
					map.put("id", list.get(i).getId());
					map.put("value", list.get(i).getId());
					map.put("label", list.get(i).getCname());
					List<Map<String, Object>> proMapList = new ArrayList<>();
					SysArea province = new SysArea();
					province.setParentId(list.get(i).getId().longValue());
					/** 省级列表 **/
					List<SysArea> provinceList = sysAreaMapper.selectSysAreaList(province);
					if (!provinceList.isEmpty()) {
						for (int j = 0; j < provinceList.size(); j++) {
							Map<String, Object> provinceMap = new HashMap<>();
							provinceMap.put("id", provinceList.get(j).getId());
							provinceMap.put("value", provinceList.get(j).getId());
							provinceMap.put("label", provinceList.get(j).getCname());
							List<Map<String, Object>> cityMapList = new ArrayList<>();
							SysArea city = new SysArea();
							city.setParentId(provinceList.get(j).getId().longValue());
							/** 市级列表 **/
							List<SysArea> cityList = sysAreaMapper.selectSysAreaList(city);
							if (!cityList.isEmpty()) {
								for (int k = 0; k < cityList.size(); k++) {
									Map<String, Object> cityMap = new HashMap<>();
									cityMap.put("id", cityList.get(k).getId());
									cityMap.put("value", cityList.get(k).getId());
									cityMap.put("label", cityList.get(k).getCname());
									cityMapList.add(cityMap);
								}
							}
							provinceMap.put("children", cityMapList);
							proMapList.add(provinceMap);
						}
					}
					if (!proMapList.isEmpty()) {
						map.put("children", proMapList);
					}
					listMaps.add(map);
				}

				/** 封装获取到的数据 **/
				if (!listMaps.isEmpty()) {
					redis1.opsForValue().set(key, (Serializable) JSONArray.toJSON(listMaps), 10, TimeUnit.DAYS);
				}
			}
		}
		return json;
	}
}