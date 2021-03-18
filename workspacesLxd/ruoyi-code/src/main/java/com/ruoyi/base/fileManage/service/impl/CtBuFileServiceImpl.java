package com.ruoyi.base.fileManage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.base.fileManage.domain.CtBuFile;
import com.ruoyi.base.fileManage.mapper.CtBuFileMapper;
import com.ruoyi.base.fileManage.service.ICtBuFileService;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.uuid.UUID;

/**
 * 文件管理Service业务层处理
 * 
 * @author Mu
 * @date 2020-12-11
 */
@Service
public class CtBuFileServiceImpl implements ICtBuFileService {

	@Autowired
	private CtBuFileMapper ctBuFileMapper;

	/**
	 * 查询文件管理
	 * 
	 * @param id 文件管理ID
	 * @return 文件管理
	 */
	@Override
	public CtBuFile selectCtBuFileById(String id) {
		return ctBuFileMapper.selectCtBuFileById(id);
	}

	/**
	 * 查询文件管理列表
	 * 
	 * @param ctBuFile 文件管理
	 * @return 文件管理
	 */
	@Override
	public List<CtBuFile> selectCtBuFileList(CtBuFile ctBuFile) {
		return ctBuFileMapper.selectCtBuFileList(ctBuFile);
	}

	/**
	 * 新增文件管理
	 * 
	 * @param ctBuFile 文件管理
	 * @return 结果
	 */
	@Override
	public int insertCtBuFile(CtBuFile ctBuFile) {
		ctBuFile.setCreateTime(DateUtils.getNowDate());
		return ctBuFileMapper.insertCtBuFile(ctBuFile);
	}

	/**
	 * 修改文件管理
	 * 
	 * @param ctBuFile 文件管理
	 * @return 结果
	 */
	@Override
	public int updateCtBuFile(CtBuFile ctBuFile) {
		return ctBuFileMapper.updateCtBuFile(ctBuFile);
	}

	/**
	 * 批量删除文件管理
	 * 
	 * @param ids 需要删除的文件管理ID
	 * @return 结果
	 */
	@Override
	public int deleteCtBuFileByIds(String[] ids) {
		return ctBuFileMapper.deleteCtBuFileByIds(ids);
	}

	/**
	 * 删除文件管理信息
	 * 
	 * @param id 文件管理ID
	 * @return 结果
	 */
	@Override
	public int deleteCtBuFileById(String id) {
		Integer nums = 0;
		if (StringUtils.isNotBlank(id)) {
			nums = ctBuFileMapper.deleteCtBuFileById(id);
		}
		return nums;
	}

	/**
	 * @Title: CtBuFileController.java
	 * @Description: 保存文件
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	@Override
	public String addSaveFile(MultipartFile file) {
		CtBuFile ctBuFile = new CtBuFile();
		ctBuFile.setId(UUID.fastUUID().toString(true));
		/** 防止出现BUG默认写入 **/
		ctBuFile.setPid("1");
		ctBuFile.setPtype(1);
		try {
			// 上传文件路径
			String filePath = RuoYiConfig.getUploadPath();
			// 上传并返回新文件名称
			String fileName = FileUploadUtils.upload(filePath, file);
			System.err.println(fileName);
			ctBuFile.setPath(fileName);
			ctBuFile.setDelFlag(1);
			ctBuFile.setCreateTime(DateUtils.getNowDate());
			String userid = SecurityUtils.getLoginUser().getUser().getUserId().toString();
			ctBuFile.setCreateBy(userid);
			ctBuFileMapper.insertCtBuFile(ctBuFile);
		} catch (Exception e) {

		}
		return ctBuFile.getId();
	}
	
	/**
	 * @Title: ICtBuFileService.java
	 * @Description: 根据文件所属ID获取信息
	 * @Author M.Mu
	 * @Date 2020-12-14
	 */
	@Override
	public List<Map<String,Object>> findFileListByPid(String pid) {
		List<Map<String,Object>> listMap = new ArrayList<>();
		/** 判断所属PID是否为空 **/
		if(StringUtils.isNotBlank(pid)) {
			CtBuFile file = new CtBuFile();
			file.setPid(pid);
			List<CtBuFile> list = ctBuFileMapper.findFileListByPid(file);
			if(list != null && !list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					Map<String,Object> map = new HashMap<>();
					// 本地资源路径
					String filePath = RuoYiConfig.getUploadPath() + list.get(i).getPath();
					String downloadName = StringUtils.substringAfterLast(list.get(i).getPath(), "/");
					map.put("url", filePath);
					map.put("name", downloadName);
					map.put("uid", list.get(i).getId());
					listMap.add(map);
				}
				return listMap;
			}
		}
		return new ArrayList<>();
	}


	@Override
	public List<Map<String, Object>> findFileListByPidPtype(String pid, Integer ptype) {
		List<Map<String,Object>> listMap = new ArrayList<>();
		/** 判断所属PID是否为空 **/
		if(StringUtils.isNotBlank(pid) && ptype != null) {
			CtBuFile file = new CtBuFile();
			file.setPid(pid);
			file.setPtype(ptype);
			List<CtBuFile> list = ctBuFileMapper.findFileListByPidPtype(file);
			if(list != null && !list.isEmpty()) {
				for (int i = 0; i < list.size(); i++) {
					Map<String,Object> map = new HashMap<>();
					// 本地资源路径
					String filePath = RuoYiConfig.getUploadPath() + list.get(i).getPath();
					String downloadName = StringUtils.substringAfterLast(list.get(i).getPath(), "/");
					map.put("url", filePath);
					map.put("name", downloadName);
					map.put("uid", list.get(i).getId());
					map.put("ptype",list.get(i).getPtype());
					listMap.add(map);
				}
				return listMap;
			}
		}
		return new ArrayList<>();
	}
}