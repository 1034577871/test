<template>
  <div>
    <el-row :gutter="15">
		<el-form ref="form" :model="form"  label-width="150px">

          <el-row :gutter="15">
            <el-col :span="24" style="margin-top: 0;">
              <el-divider content-position="center" ><el-link type="primary"><b>合同信息</b></el-link></el-divider>
            </el-col>
          </el-row>
          <el-row :gutter="15">
             <el-col :span="8">
               <el-form-item label="合同编号 : "    prop="contractNo">
                 <span>{{form.contractNo}}</span>
               </el-form-item>
             </el-col>
             <el-col :span="8">
               <el-form-item label="合同名称 : " prop="contractName" >
                 <span>{{form.contractName}}</span>
               </el-form-item>
             </el-col>
             <el-col :span="8">
               <el-form-item label="对方单位名称 : " prop="oppositeName">
                 <span>{{form.oppositeName}}</span>
               </el-form-item>
             </el-col>

          </el-row>
          <el-row :gutter="15">
            <el-col :span="8">
              <el-form-item label="对方银行账户 : " prop="oppositeBank">
                <span>{{form.oppositeBank}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="对方银行账号 : " prop="oppositeBankId">
                <span>{{form.oppositeBankId}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="对方联系人 : " prop="oppositeContacts">
                <span>{{form.oppositeContacts}}</span>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="15">
            <el-col :span="8">
              <el-form-item label="对方联系电话 : " prop="oppositePhone">
                <span>{{form.oppositeBank}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="对方联系地址 : " prop="oppositeAddress">
                <span>{{form.oppositeAddress}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="合同金额 : " prop="totalMoney">
                <span>{{form.totalMoney}}</span>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row :gutter="15">
            <el-col :span="8">
              <el-form-item label="已支付金额 : " prop="paidMoney">
                <span>{{form.paidMoney}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="待支付金额 : " prop="unpaidMoney">
                <span>{{form.unpaidMoney}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="付款周期 : " prop="payment_period">
                <span>{{form.paymentPeriod}}</span>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="15">
            <el-col :span="24" style="margin-top: 0;">
              <el-divider content-position="center" ><el-link type="primary"><b>发票信息</b></el-link></el-divider>
            </el-col>
          </el-row>
          <el-row :gutter="15">
            <el-col :span="8">
              <el-form-item label="发票代码 : " prop="invoiceCode">
                <span>{{form.invoiceCode}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="发票号码 : " prop="invoiceNo">
                <span>{{form.invoiceNo}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="税率(%) : " prop="taxrate">
                <span>{{form.taxrate}}</span>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row :gutter="15">
            <el-col :span="8">
              <el-form-item label="发票金额(含税) : " prop="invoiceNomoney" >
                <span>{{form.invoiceMoney}}</span>
              </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="发票金额(不含税) : " prop="invoiceNomoney">
                <span>{{form.invoiceNomoney}}</span>
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
  import {
  	listTicketRecord,
  	getTicketRecord,
  	delTicketRecord,
  	addTicketRecord,
  	updateTicketRecord,
  	exportTicketRecord
  } from "@/api/paymentManagement/ticketRecord";
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
        getTicketRecord(this.businessKey).then(response => {
          console.log(response.data);
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
