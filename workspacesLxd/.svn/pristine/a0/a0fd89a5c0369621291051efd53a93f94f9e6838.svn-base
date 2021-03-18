package com.ruoyi.base.fileManage.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import cn.hutool.http.HttpResponse;
import com.ruoyi.collection.utils.DownLoadUtil;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.base.fileManage.domain.CtBuFile;
import com.ruoyi.base.fileManage.service.ICtBuFileService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件管理Controller
 * 
 * @author Mu
 * @date 2020-12-11
 */
@RestController
@RequestMapping("/dictionary/fileManage")
public class CtBuFileController extends BaseController {

	@Autowired
	private ICtBuFileService ctBuFileService;

	/**
	 * 查询文件管理列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:fileManage:list')")
	@GetMapping("/list")
	public TableDataInfo list(CtBuFile ctBuFile) {
		startPage();
		List<CtBuFile> list = ctBuFileService.selectCtBuFileList(ctBuFile);
		return getDataTable(list);
	}

	/**
	 * 导出文件管理列表
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:fileManage:export')")
	@Log(title = "文件管理", businessType = BusinessType.EXPORT)
	@GetMapping("/export")
	public AjaxResult export(CtBuFile ctBuFile) {
		List<CtBuFile> list = ctBuFileService.selectCtBuFileList(ctBuFile);
		ExcelUtil<CtBuFile> util = new ExcelUtil<CtBuFile>(CtBuFile.class);
		return util.exportExcel(list, "fileManage");
	}

	/**
	 * 获取文件管理详细信息
	 */
	@GetMapping(value = "/{pid}")
	public AjaxResult getInfo(@PathVariable("pid") String pid) {
		return AjaxResult.success(ctBuFileService.findFileListByPid(pid));
	}

	/**
	 * 获取文件管理详细信息
	 */
	@GetMapping("/byPidPtype/{pid}/{ptype}")
	public AjaxResult getFileListByPidPtype(@PathVariable("pid") String pid,@PathVariable("ptype") Integer ptype) {
		return AjaxResult.success(ctBuFileService.findFileListByPidPtype(pid,ptype));
	}

	/**
	 * 新增文件管理
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:fileManage:add')")
	@Log(title = "文件管理", businessType = BusinessType.INSERT)
	@PostMapping
	public AjaxResult add(@RequestBody CtBuFile ctBuFile) {
		return toAjax(ctBuFileService.insertCtBuFile(ctBuFile));
	}

	/**
	 * 修改文件管理
	 */
	@PreAuthorize("@ss.hasPermi('dictionary:fileManage:edit')")
	@Log(title = "文件管理", businessType = BusinessType.UPDATE)
	@PutMapping
	public AjaxResult edit(@RequestBody CtBuFile ctBuFile) {
		return toAjax(ctBuFileService.updateCtBuFile(ctBuFile));
	}

	/**
	 * 删除文件管理
	 */
//	@PreAuthorize("@ss.hasPermi('dictionary:fileManage:remove')")
	@Log(title = "文件管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
	public AjaxResult remove(@PathVariable String ids) {
		return toAjax(ctBuFileService.deleteCtBuFileById(ids));
	}

	/**
	 * @Title: CtBuFileController.java
	 * @Description: 保存文件
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	@PostMapping("/addSaveFile")
	public AjaxResult addSaveFile(@RequestParam("file") MultipartFile file) {

		return AjaxResult.success(ctBuFileService.addSaveFile(file));
	}

	@GetMapping("/dwonLoadFile/{pid}/{type}")
	public void dwonLoadFile(HttpServletResponse response,@PathVariable("pid") String pid,@PathVariable("type") String type) {

		try{

			CtBuFile ctBuFiles = ctBuFileService.selectCtBuFileById(pid);
			if(ctBuFiles!=null){
				String path = "";
				if(ctBuFiles.getPath()!=null){
					String[] paths = (ctBuFiles.getPath()).split("upload");
					path = paths[1];
				}
				// 上传文件路径
				String filePath = RuoYiConfig.getUploadPath();
				System.out.println(filePath+path);
				DownLoadUtil.download(filePath+path,response);
			}

		}catch (Exception e){
			e.printStackTrace();
		}

	}
}