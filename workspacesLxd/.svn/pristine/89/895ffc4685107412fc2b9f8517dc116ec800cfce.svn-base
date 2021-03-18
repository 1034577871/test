<!-- 审批详情弹出页 -->
<template>
  <div ref="payInfo">
    <el-form ref="form" :model="form" label-width="100px">
      <el-dialog title="付款申请审核" :visible.sync="modalShow" width="80%" :before-close="modalClose">
        <el-row :gutter="15">
          <el-col :span="24" style="margin-top: 0;">
            <el-divider content-position="center">
              <el-link type="primary"><b>付款审核信息</b></el-link>
            </el-divider>
          </el-col>
        </el-row>
        <el-row :gutter="15">
          <el-col :span="8">
            <el-form-item label="项目编号 : ">
              <span>{{form.proNo}}</span>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="项目名称 : " prop="proName">
              <span>{{form.proName}}</span>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="合同编号 : " prop="contractNo">
              <span>{{form.contractNo}}</span>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="15">
          <el-col :span="8">
            <el-form-item label="合同名称 : " prop="contractName">
              <span>{{form.contractName}}</span>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="申请日期 : " prop="applicationTime">
              <span>{{form.applicationTime}}</span>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="申请金额 : " prop="appliedAmount">
              <span>{{form.appliedAmount}}</span>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="15">
          <el-col :span="8">
            <el-form-item label="付款类型 : " prop="paytype">
              <span v-if="form.paytype == 1">发票付款</span>
              <span v-if="form.paytype == 2">预付款</span>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="备注 : " prop="remark">
              <span>{{form.remark}}</span>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row :gutter="15">
          <el-table :data="tableData">
            <el-table-column label="任务节点" prop="taskNodeName" header-align="center" align="center">
            </el-table-column>
            <el-table-column label="审批人" prop="createName" header-align="center" align="center">
            </el-table-column>
            <el-table-column label="审批意见" prop="controlValue" header-align="center" align="center">
            </el-table-column>
            <el-table-column label="审批时间" prop="createTime" header-align="center" align="center">
            </el-table-column>
          </el-table>
        </el-row>
        <div slot="footer" class="no-print">
          <div slot="footer" class="dialog-footer">
            <el-button type="primary" @click="print_sp">打 印</el-button>
          </div>
        </div>
      </el-dialog>
    </el-form>

  </div>
</template>

<script>
  import {
    findWorkFlowFormData,
    listApplyCollection,
    detailNgcApproval,
    findContract,
    detailhtCon,
    getUserInfo
  } from "@/api/collection/common";
  import {
    listPayinfo,
    getPayinfo,
    delPayinfo,
    addPayinfo,
    updatePayinfo,
    exportPayinfo,
    editRemovePayinfo
  } from "@/api/paymentManagement/payinfo";
  import {
    getByBusinessKey
  } from '@/api/activiti/historyFormdata.js';
  export default {
    name: "index",
    data() {
      return {
        tableData: [], //审批信息
        invoiceDataList: [], //开票信息
        show: false,
        modalShow: false,
        projectCategoryTypeList: [],
        form: {
          id: null,
          proNo: null,
          proName: null,
          contractId: null,
          contractNo: null,
          contractName: null,
          payinfoid: null,
          paymentPeriod: null,
          invoiceDate: null,
          invoiceCode: null,
          invoiceNo: null,
          invoiceMoney: null,
          taxrate: null,
          invoiceNomoney: null,
          oppositeName: null,
          oppositeBank: null,
          oppositeBankId: null,
          oppositeContacts: null,
          oppositePhone: null,
          oppositeAddress: null,
          invoiceVoucher: null,
          unitQualification: null,
          status: 0,
          statusps: null,
          delFlag: null,
          remark: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,

        },
      }
    },
    created() {},
    methods: {
      init(row) {
        console.log(row)
        this.tableData = [];
        getPayinfo(row.id).then(response => {
          this.form = response.data
          let proName_ = response.data;
          this.modalShow = true;
          getByBusinessKey(row.id).then(response1 => {
            this.tableData = response1;
            console.log(this.tableData)
          });
          /** 获取文件列表 **/
          findFileListByPidPtype(row.id, 1).then(response => {
            this.invoiceVoucher = response.data;
          });

        })
      },
      modalClose() {
        this.modalShow = false;
      },
      //打印
      print_sp() {
        this.$print(this.$refs.payInfo)
      },
    },
  }
</script>

<style scoped lang="scss">
  ::v-deep .input-noborder {
    .el-input__inner {
      border: 0;
      background-color: #f8f8f9;
    }
  }

  ::v-deep .el-dialog {
    .el-dialog__body {
      padding: 0px 20px !important;
    }
  }
</style>
