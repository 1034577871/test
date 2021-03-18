package com.ruoyi.collection.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.collection.domain.CtBuInvoiceReqDto;
import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.contract.contractPayinfo.domain.CtBuContractPayinfo;
import com.ruoyi.projectApproval.ApprovalNg.domain.CtBuApprovalNg;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.collection.domain.CtBuInvoiceReq;
import com.ruoyi.collection.service.ICtBuInvoiceReqService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 发票申请Controller
 * 
 * @author ruoyi
 * @date 2020-12-09
 */
@RestController
@RequestMapping("/collection/collection")
public class CtBuInvoiceReqController extends BaseController
{
    @Autowired
    private ICtBuInvoiceReqService ctBuInvoiceReqService;

    /**
     * 获取当前用户信息
     */
    @GetMapping("/getUserInfo")
    public AjaxResult getUserInfo() {
        return AjaxResult.success(ctBuInvoiceReqService.getUserInfo());
    }
    @GetMapping("/getUserInfoCon/{id}")
    public AjaxResult getUserInfoCon(@PathVariable("id") String id) {
        return AjaxResult.success(ctBuInvoiceReqService.getUserInfoCon(id));
    }
    /**
     * 查询发票申请列表
     */
    @PreAuthorize("@ss.hasPermi('collection:collection:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuInvoiceReq ctBuInvoiceReq)
    {
        startPage();
        List<CtBuInvoiceReq> list = ctBuInvoiceReqService.selectCtBuInvoiceReqList(ctBuInvoiceReq);
        return getDataTable(list);
    }

    /**
     * 导出发票申请列表
     */
    @PreAuthorize("@ss.hasPermi('collection:collection:export')")
    @Log(title = "发票申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuInvoiceReq ctBuInvoiceReq)
    {
        List<CtBuInvoiceReq> list = ctBuInvoiceReqService.selectCtBuInvoiceReqList(ctBuInvoiceReq);
        ExcelUtil<CtBuInvoiceReq> util = new ExcelUtil<CtBuInvoiceReq>(CtBuInvoiceReq.class);
        return util.exportExcel(list, "collection");
    }

    /**
     * 获取发票申请详细信息
     */
    //@PreAuthorize("@ss.hasPermi('collection:collection:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        //CtBuInvoiceReqDto dto =ctBuInvoiceReqService.selectCtBuInvoiceReqById(id);
        return AjaxResult.success(ctBuInvoiceReqService.selectCtBuInvoiceReqById(id));
    }

    /**
     * 新增发票申请
     */
    @PreAuthorize("@ss.hasPermi('collection:collection:add')")
    @Log(title = "发票申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuInvoiceReqDto ctBuInvoiceReq)
    {
        return toAjax(ctBuInvoiceReqService.insertCtBuInvoiceReq(ctBuInvoiceReq));
    }

    /**
     * 修改发票申请
     */
    @PreAuthorize("@ss.hasPermi('collection:collection:edit')")
    @Log(title = "发票申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuInvoiceReqDto ctBuInvoiceReq)
    {
        return toAjax(ctBuInvoiceReqService.updateCtBuInvoiceReq(ctBuInvoiceReq));
    }

    /**
     * 删除发票申请
     */
    @PreAuthorize("@ss.hasPermi('collection:collection:remove')")
    @Log(title = "发票申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {

        return toAjax(ctBuInvoiceReqService.deleteCtBuInvoiceReqByIds(ids));
    }

    /**
     * 确认发票申请
     */
    //@PreAuthorize("@ss.hasPermi('collection:collection:confirmInvoice')")
    @Transactional(rollbackFor = Exception.class)
    @Log(title = "发票申请", businessType = BusinessType.UPDATE)
    @GetMapping("/confirmInvoice/{id}")
    public AjaxResult edit(@PathVariable("id") String id)
    {
        CtBuInvoiceReqDto ctBuInvoiceReqDto = ctBuInvoiceReqService.selectCtBuInvoiceReqById(id);
        CtBuInvoiceReqDto ctBuInvoiceReq = new CtBuInvoiceReqDto();
        ctBuInvoiceReq.setId(id);
        ctBuInvoiceReq.setStatus(2);
//        ctBuInvoiceReq.setDelFlag("2");
//        if("1".equals(ctBuInvoiceReqDto.getIfysk())){
//            ctBuInvoiceReq.setDelFlag("2");
//        }
        int num = ctBuInvoiceReqService.updatesCtBuInvoiceReqByid(ctBuInvoiceReq);
        if(num>0){
            if(ctBuInvoiceReqDto.getIfysk()!=null && "1".equals(ctBuInvoiceReqDto.getIfysk())){
                ctBuInvoiceReqDto.setPid(ctBuInvoiceReqDto.getId());
                ctBuInvoiceReqDto.setId(UUID.fastUUID().toString(true));
                ctBuInvoiceReqDto.setInvoiceAmountNtax((ctBuInvoiceReqDto.getInvoiceAmountNtax().negate()));
                ctBuInvoiceReqDto.setInvoiceAmountTax(ctBuInvoiceReqDto.getInvoiceAmountTax().negate());
                ctBuInvoiceReqDto.setState("2");
                ctBuInvoiceReqDto.setDelFlag("2");
                ctBuInvoiceReqService.insertCtBuInvoiceReq(ctBuInvoiceReqDto);
            }

            /** 判断当前登录人 **/
            LoginUser loginUser = SecurityUtils.getLoginUser();
            Map map = new HashMap();
            map.put("formKey","jbrqr");
            map.put("businessKey",id);
            map.put("controlId","jbrqr");
            map.put("controlName","审批意见");
            map.put("controlValue","已确认");
            map.put("taskNodeName","经办人确认");
            map.put("createTime",DateUtils.getNowDate());
            map.put("createName",loginUser.getUser().getUserName());
            map.put("createBy",loginUser.getUser().getUserId().toString());

            ctBuInvoiceReqService.insertSubActWorkflowFormData(map);
        }
            return  toAjax(num);
    }

    /**
     * 获取发票申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('collection:collection:getApproNgByid')")
    @GetMapping(value = "/getApproNgByid/{id}")
    public AjaxResult getApproNgByid(@PathVariable("id") String id)
    {
        CtBuApprovalNg ctBuApprovalNg = ctBuInvoiceReqService.getApproNgByid(id);
        return AjaxResult.success(ctBuApprovalNg);
    }


    /**
     * 获取发票申请详细信息
     */
    //@PreAuthorize("@ss.hasPermi('collection:collection:query')")
    @GetMapping(value = "/getInfoByInstanceId/{id}")
    public AjaxResult getInfoByInstanceId(@PathVariable("id") String id)
    {
        //CtBuInvoiceReqDto dto =ctBuInvoiceReqService.selectCtBuInvoiceReqById(id);
        return AjaxResult.success(ctBuInvoiceReqService.selectCtBuInvoiceReqByInstanceId(id));
    }

    /**
     * 查询发票申请列表
     */
    @PreAuthorize("@ss.hasPermi('collection:collection:list')")
    @DataScope(deptAlias = "u")
    @GetMapping("/sklist")
    public List sklist(CtBuContractPayinfo ctBuInvoiceReq)
    {
        List<CtBuContractPayinfo> list = ctBuInvoiceReqService.selectContractPayinfoById(ctBuInvoiceReq);
        return list;
    }
}
