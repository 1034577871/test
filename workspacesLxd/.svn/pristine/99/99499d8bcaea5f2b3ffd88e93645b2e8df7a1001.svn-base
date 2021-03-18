package com.ruoyi.base.fileManage.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.base.fileManage.domain.CtBuFile;

/**
 * 文件管理Service接口
 * 
 * @author Mu
 * @date 2020-12-11
 */
public interface ICtBuFileService {

	/**
	 * 查询文件管理
	 * 
	 * @param id 文件管理ID
	 * @return 文件管理
	 */
	public CtBuFile selectCtBuFileById(String id);

	/**
	 * 查询文件管理列表
	 * 
	 * @param ctBuFile 文件管理
	 * @return 文件管理集合
	 */
	public List<CtBuFile> selectCtBuFileList(CtBuFile ctBuFile);
	
	/**
	 * @Title: ICtBuFileService.java
	 * @Description: 根据文件所属ID获取信息
	 * @Author M.Mu
	 * @Date 2020-12-14
	 */
	public List<Map<String,Object>> findFileListByPid(String pid);

	/**
	 * 根据文件所属PID与ptype获取信息
	 * @param pid
	 * @param ptype
	 * @return
	 */
	public List<Map<String,Object>> findFileListByPidPtype(String pid,Integer ptype);
	
	/**
	 * 新增文件管理
	 * 
	 * @param ctBuFile 文件管理
	 * @return 结果
	 */
	public int insertCtBuFile(CtBuFile ctBuFile);

	/**
	 * 修改文件管理
	 * 
	 * @param ctBuFile 文件管理
	 * @return 结果
	 */
	public int updateCtBuFile(CtBuFile ctBuFile);

	/**
	 * 批量删除文件管理
	 * 
	 * @param ids 需要删除的文件管理ID
	 * @return 结果
	 */
	public int deleteCtBuFileByIds(String[] ids);

	/**
	 * 删除文件管理信息
	 * 
	 * @param id 文件管理ID
	 * @return 结果
	 */
	public int deleteCtBuFileById(String id);
	
	/**
	 * @Title: ICtBuFileService.java
	 * @Description: 保存文件
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	public String addSaveFile(MultipartFile file);
}