<template>
  <div>
    <el-row :gutter="15">
      <el-col :span="24" >
        <el-divider content-position="center" ><el-link type="primary"><b>付款申请单</b></el-link></el-divider>
      </el-col>
		<el-form ref="form" :model="form"  label-width="80px">

           <el-row :gutter="15">
             <el-col :span="8" >
               <el-form-item label="项目编号 : " prop="proNo" >
                 <span>{{form.proNo}}</span>
               </el-form-item>
             </el-col>
             <el-col :span="8">
               <el-form-item label="项目名称 : " prop="proName">
                 <span>{{form.proName}}</span>
               </el-form-item>
              </el-col>
              <el-col :span="8">
                <el-form-item label="合同编号 : "    prop="contractNo">
                  <span>{{form.contractNo}}</span>
                </el-form-item>
              </el-col>
           </el-row>
           <el-row :gutter="15">
             <el-col :span="8">
               <el-form-item label="合同名称 : " prop="contractName" >
                 <span>{{form.contractName}}</span>
               </el-form-item>
             </el-col>
             <el-col :span="8">
               <el-form-item label="申请日期 : " prop="applicationTime">
                 <span>{{form.applicationTime}}</span>
               </el-form-item>
             </el-col>
             <el-col :span="8">
               <el-form-item label="申请金额 : " prop="appliedAmount" >
                 <span>{{form.appliedAmount}}</span>
               </el-form-item>
             </el-col>
           </el-row>

           <el-row :gutter="15">
             <el-col :span="8">
               <el-form-item label="付款类型 : " prop="paytype" >
                 	<span v-if="form.paytype == 1">发票付款</span>
                 	<span v-if="form.paytype == 2">预付款</span>
               </el-form-item>
             </el-col>
             <el-col :span="8">
               <el-form-item label="备注 : " prop="remark" >
                 <span>{{form.remark}}</span>
               </el-form-item>
             </el-col>
           </el-row>
	    </el-form>
    </el-row>
  <el-row :gutter="15">
    <el-col :span="24" >
      <el-divider content-position="center" ><el-link type="primary"><b>审核信息</b></el-link></el-divider>
    </el-col>
  </el-row>

  <el-card class="box-card" v-for="(historyData, index) in fromData"  :key="index" >
    <div slot="header" class="clearfix">
      <span>{{historyData.taskNodeName}}</span>
      <!-- <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button> -->
    </div>
    <el-alert  type="success"  :closable="false" style="margin-bottom: 10px;">
      <span class="in-text">审批人：{{historyData.createName}}</span>
      <span class="in-text">审批时间：{{historyData.createdDate}}</span>
    </el-alert>
    <el-form v-for="(fistoryFormData, indexH) in historyData.formHistoryDataDTO" :key="indexH" label-width="80px">
      <el-form-item :label=fistoryFormData.title >
        <el-input v-model="fistoryFormData.value"/>
      </el-form-item>
    </el-form>
  </el-card>

</div>
</template>

<script>
  import { getLeave } from '@/api/workflow/leave'
  import { getNgcAudit ,historyFromData,getCollectionAudit } from '@/api/activiti/historyFormdata'
  import { listPayinfo, getPayinfo, delPayinfo, addPayinfo, updatePayinfo, exportPayinfo, editRemovePayinfo } from "@/api/paymentManagement/payinfo";
  export default {
    name: "leaveHistoryForm",
    props: {
      businessKey: {
        type: String
      }
    },
    data(){
      return{
        show:false,
        // 表单参数
        form: {},
        invoiceDataList:[], //开票信息
        fromData:[],
      }
    },
    created() {
      this.getLeave()
      this.historyFromData()
    },
    methods:{
      getLeave() {
        this.form.instanceId = this.businessKey;
        getPayinfo(this.businessKey).then(response => {
          this.form = response.data
          let proName_ = response.data;
        })
      },
      historyFromData() {
        historyFromData(this.businessKey).then(response => {
          this.fromData = response.data
        })
      },
    }

  }
</script>

<style scoped lang="scss">
  .input-noborder ::v-deep {
    .el-input__inner {
      border: 0;
      background-color: #f8f8f9;
    }
  }
  .el-alert  ::v-deep {
    .el-alert__content {
      width: 100%;
    }
  }
  .box-card {
    width: 50%;
  }
  .in-text {
    display:inline-block;width: 50%;
    font-size: 14px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

</style>
