package com.ruoyi.collection.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ruoyi.collection.domain.CtBuInvoiceInfoReq;
import com.ruoyi.collection.domain.CtBuInvoiceReq;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ruoyi.collection.domain.CtBuInvoiceInfo;
import com.ruoyi.collection.service.ICtBuInvoiceInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 财务开票Controller
 *
 * @author ruoyi
 * @date 2020-12-11
 */
@RestController
@RequestMapping("/collection/financial")
public class CtBuInvoiceInfoController extends BaseController {
    @Autowired
    private ICtBuInvoiceInfoService ctBuInvoiceInfoService;

    /**
     * 查询财务开票列表
     */
//    @PreAuthorize("@ss.hasPermi('collection:financial:list')")
    @GetMapping("/list")
    public TableDataInfo list(CtBuInvoiceInfoReq ctBuInvoiceInfo) {
        startPage();
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (ctBuInvoiceInfo.getCtBuInvoiceReq() == null) {
            ctBuInvoiceInfo.setCtBuInvoiceReq(new CtBuInvoiceReq());
        }
        if (ctBuInvoiceInfo != null && ctBuInvoiceInfo.getStatus() != null && ctBuInvoiceInfo.getStatus() == 100) {
            ctBuInvoiceInfo.setStatus(2);
            ctBuInvoiceInfo.setCreateBy(loginUser.getUser().getUserId().toString());
            ctBuInvoiceInfo.setHandoverUsername("xxxxx");
        }
        if (ctBuInvoiceInfo != null && ctBuInvoiceInfo.getStatus() != null && ctBuInvoiceInfo.getStatus() == 200) {
            ctBuInvoiceInfo.setStatus(1);
            //ctBuInvoiceInfo.setCreateBy(loginUser.getUser().getUserId().toString());
        }
        List<CtBuInvoiceInfoReq> list = ctBuInvoiceInfoService.selectCtBuInvoiceInfoList(ctBuInvoiceInfo);
        return getDataTable(list);
    }
    /**
     * 查询财务开票列表
     */
//    @PreAuthorize("@ss.hasPermi('collection:financial:list')")
    @GetMapping("/pzhlist")
    public TableDataInfo Pzhlist(CtBuInvoiceInfo ctBuInvoiceInfo) {
        startPage();
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (ctBuInvoiceInfo.getCtBuInvoiceReq() == null) {
            ctBuInvoiceInfo.setCtBuInvoiceReq(new CtBuInvoiceReq());
        }
        if (ctBuInvoiceInfo != null && ctBuInvoiceInfo.getStatus() != null && ctBuInvoiceInfo.getStatus() == 100) {
            ctBuInvoiceInfo.setStatus(2);
            ctBuInvoiceInfo.setCreateBy(loginUser.getUser().getUserId().toString());
        }
        if (ctBuInvoiceInfo != null && ctBuInvoiceInfo.getStatus() != null && ctBuInvoiceInfo.getStatus() == 200) {
            ctBuInvoiceInfo.setStatus(1);
            //ctBuInvoiceInfo.setCreateBy(loginUser.getUser().getUserId().toString());
        }
        List<CtBuInvoiceInfo> list = ctBuInvoiceInfoService.selectCtBuInvoiceQrInfoandPzhsList(ctBuInvoiceInfo);
        return getDataTable(list);
    }
    /**
     * 导出财务开票列表
     */
    @PreAuthorize("@ss.hasPermi('collection:financial:export')")
    @Log(title = "财务开票", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(CtBuInvoiceInfoReq ctBuInvoiceInfo) {
        List<CtBuInvoiceInfoReq> list = ctBuInvoiceInfoService.selectCtBuInvoiceInfoList(ctBuInvoiceInfo);
        ExcelUtil<CtBuInvoiceInfoReq> util = new ExcelUtil<CtBuInvoiceInfoReq>(CtBuInvoiceInfoReq.class);
        return util.exportExcel(list, "financial");
    }

    /**
     * 获取财务开票详细信息
     */
    // @PreAuthorize("@ss.hasPermi('collection:financial:query')")
    @GetMapping(value = "/{id}/{rid}")
    public AjaxResult getInfo(@PathVariable("id") String id, @PathVariable("rid") String rid) {
        CtBuInvoiceInfo ctBuInvoiceInfo = ctBuInvoiceInfoService.selectCtBuInvoiceInfoById(id);
        /** 判断当前登录人 **/
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if (ctBuInvoiceInfo == null) {
            ctBuInvoiceInfo = new CtBuInvoiceInfo();
            ctBuInvoiceInfo.setReqId(rid);
            ctBuInvoiceInfo.setInvoiceDrawer(loginUser.getUser().getNickName());
            ctBuInvoiceInfo.setVoucherDept(loginUser.getUser().getDept().getParentName());
            ctBuInvoiceInfo.setRemark(loginUser.getUser().getDept().getDeptName());
            ctBuInvoiceInfo.setVoucherTime(new Date());
        }else{
            if(ctBuInvoiceInfo.getVoucherDept()==null){
                ctBuInvoiceInfo.setVoucherDept(loginUser.getUser().getCompanyId().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("MM");
                java.util.Date dd  = Calendar.getInstance().getTime();
                ctBuInvoiceInfo.setVoucherMonth( sdf.format(dd));
                ctBuInvoiceInfo.setVoucherTime(new Date());
            }
        }
        return AjaxResult.success(ctBuInvoiceInfo);
    }


    /**
     * 获取财务开票详细信息
     */
    // @PreAuthorize("@ss.hasPermi('collection:financial:query')")
    @GetMapping(value = "/getVoInfo/{id}/{rid}")
    public AjaxResult getVoInfo(@PathVariable("id") String id, @PathVariable("rid") String rid) {
        CtBuInvoiceInfo ctBuInvoiceInfo = ctBuInvoiceInfoService.selectCtBuInvoiceInfoById(id);
        if (ctBuInvoiceInfo == null || ctBuInvoiceInfo.getVoucherNo() == null) {
            /** 判断当前登录人 **/
            LoginUser loginUser = SecurityUtils.getLoginUser();
            ctBuInvoiceInfo = new CtBuInvoiceInfo();
            ctBuInvoiceInfo.setReqId(rid);
            ctBuInvoiceInfo.setInvoiceDrawer(loginUser.getUser().getNickName());
            ctBuInvoiceInfo.setVoucherDept(loginUser.getUser().getDept().getDeptName());
            ctBuInvoiceInfo.setRemark(loginUser.getUser().getDept().getDeptName());
            ctBuInvoiceInfo.setVoucherTime(new Date());
        }
        return AjaxResult.success(ctBuInvoiceInfo);
    }

    /**
     * 新增财务开票
     */
    //@PreAuthorize("@ss.hasPermi('collection:financial:add')")
    @Log(title = "财务开票", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CtBuInvoiceInfo ctBuInvoiceInfo) {
        return toAjax(ctBuInvoiceInfoService.insertCtBuInvoiceInfo(ctBuInvoiceInfo));
    }

    /**
     * 修改财务开票
     */
    // @PreAuthorize("@ss.hasPermi('collection:financial:edit')")
    @Log(title = "财务开票", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CtBuInvoiceInfo ctBuInvoiceInfo) {
        return toAjax(ctBuInvoiceInfoService.updateCtBuInvoiceInfo(ctBuInvoiceInfo));
    }

    /**
     * 删除财务开票
     */
    @PreAuthorize("@ss.hasPermi('collection:financial:remove')")
    @Log(title = "财务开票", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(ctBuInvoiceInfoService.deleteCtBuInvoiceInfoByIds(ids));
    }

    /**
     * 移交财务开票
     */
    //@PreAuthorize("@ss.hasAnyPermi('collection:financial:moveFinal,collection:financial:confirmFinal,collection:financial:query')")
    @Log(title = "财务开票")
    @GetMapping("/moveFinal/{id}/{flag}")
    public AjaxResult moveFinal(@PathVariable String id, @PathVariable String flag) {
        String[] ids = null;
        if (id != null && !"".equals(id)) {
            if (id.indexOf(",") > 0) {
                ids = id.split(",");
            } else {
                ids = new String[1];
                ids[0] = id;
            }
        }
        return toAjax(ctBuInvoiceInfoService.updateCtBuInvoiceInfoByIds(ids, flag));
    }

    /**
     * 凭证号录入
     */
    //@PreAuthorize("@ss.hasAnyPermi('collection:financial:saveVoucher')")
    @Log(title = "凭证号录入")
    @GetMapping("/saveVoucher/{id}/{vocher}/{datees}/{vodept}/{status}")
    public AjaxResult saveVoucher(@PathVariable String id, @PathVariable String vocher,
                                  @PathVariable String datees, @PathVariable String vodept
            , @PathVariable("status") String status) {
        String[] ids = new String[1];
        if (id != null && !"".equals(id)) {
            if (id.indexOf(",") > 0) {
                ids = id.split(",");
            } else {
                ids[0] = id;
            }
        }
        return toAjax(ctBuInvoiceInfoService.updateVocherInfoByIds(ids, vocher, datees, vodept,status));
    }

    /**
     * 开票统计
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    @Log(title = "开票统计")
    @GetMapping("/invoiceStatistics")
    public List invoiceStatistics(Date beginTime, Date endTime) {
        List list = ctBuInvoiceInfoService.invoiceStatistics1(beginTime, endTime);
        return list;
    }

    /**
     * 查询本月未录入凭证号列表
     *
     * @return
     */
    @GetMapping("/voucherWarning")
    public TableDataInfo voucherWarning() {
        startPage();
        List<CtBuInvoiceInfo> list = ctBuInvoiceInfoService.voucherWarning();
        return getDataTable(list);
    }


    @GetMapping(value = "/selectTotalInfo/{rid}")
    public List<CtBuInvoiceInfoReq> selectTotalInfo(@PathVariable("rid") String rid) {
        CtBuInvoiceInfoReq ctBuInvoiceInfo = new CtBuInvoiceInfoReq();
        ctBuInvoiceInfo.setReqId(rid);
        return (ctBuInvoiceInfoService.selectTotalInfo(ctBuInvoiceInfo));

    }


    @GetMapping(value = "/getInfoById/{id}")
    public AjaxResult getInfoById(@PathVariable("id") String id) {
        CtBuInvoiceInfo ctBuInvoiceInfo = ctBuInvoiceInfoService.selectCtBuInvoiceInfoById(id);
        return AjaxResult.success(ctBuInvoiceInfo);
    }
}
