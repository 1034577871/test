<template>
  <div>
	<el-form ref="form" :model="form"  label-width="100px">
	       <el-row :gutter="15">
	         <el-col :span="24" style="margin-top: 0;">
	           <el-divider content-position="center" ><el-link type="primary"><b>申请信息</b></el-link></el-divider>
	         </el-col>
	       </el-row>
	       <el-row :gutter="15">
	         <el-col :span="8" >
	           <el-form-item label="项目类型" prop="ApprovalType" >
	             <el-input v-model="form.approvalType" :readonly="true" class="input-noborder" />
	           </el-form-item>
	         </el-col>
	         <el-col :span="8">
	           <el-form-item label="项目编号" prop="proNo" v-if="show">
	             <el-input v-model="form.proNo" :readonly="true" class="input-noborder" />
	           </el-form-item>
	          </el-col>
	          <el-col :span="8">
	           <el-form-item label="项目名称" prop="proName" >
	             <el-input v-model="form.proName"  :readonly="true"  class="input-noborder" />
	           </el-form-item>
	         </el-col>
           <el-col :span="8">
             <el-form-item label="合同名称"    prop="contractName">
               <el-input v-model="form.contractName" :readonly="true"  class="input-noborder" />
             </el-form-item>
           </el-col>
	       </el-row>
	       <el-row :gutter="15">
	          <el-col :span="8">
	            <el-form-item label="事前审批表ID 关联事前审批表ID" prop="approvalId" v-if="show">
	               <el-input v-model="form.contractId" class="input-noborder"/>
	            </el-form-item>
	           <el-form-item label="合同编号"  v-if="show"   prop="contractNo">
	               <el-input v-model="form.contractNo"  :readonly="true" class="input-noborder" />
	           </el-form-item>
	         </el-col>

	         <el-col :span="8">
	           <el-form-item label="发票种类" prop="invoiceType" >
	             <el-input v-model="form.invoiceType"  :readonly="true"  class="input-noborder" />
	           </el-form-item>
	          </el-col>
            <el-col :span="8">
             <el-form-item label="部门名称" prop="reqDeptname">
               <el-input v-model="form.reqDeptname"   :readonly="true"  class="input-noborder"/>
             </el-form-item>
            </el-col>
            <el-col :span="8">
              <el-form-item label="申请人姓名" prop="reqUsername">
                <el-input v-model="form.reqUsername"  :readonly="true"  class="input-noborder" />
              </el-form-item>
            </el-col>
	       </el-row>
	       <el-row :gutter="15">
	         <el-col :span="8">
	           <el-form-item label="部门编号" v-if="show" prop="reqDeptid">
	             <el-input v-model="form.reqDeptid"    :readonly="true"  class="input-noborder" />
	           </el-form-item>
	         </el-col>

	         <el-col :span="8">

	         </el-col>
	       </el-row>
	       <el-row :gutter="15">
	         <el-col :span="8">
	           <el-form-item  label="申请人编号" v-if="show" prop="reqUserid">
	             <el-input v-model="form.reqUserid"   :readonly="true"  class="input-noborder"/>
	           </el-form-item>
	         </el-col>

	         <el-col :span="8">
	           <el-form-item label="申请日期" prop="reqDate">
	             <el-input v-model="form.reqDate"  :readonly="true"  class="input-noborder" />
	           </el-form-item>
	         </el-col>
           <el-col :span="8">
             <el-form-item label="单位名称" prop="payerName">
               <el-input v-model="form.payerName"  :readonly="true" class="input-noborder"/>
             </el-form-item>
           </el-col>
           <el-col :span="8">
             <el-form-item label="单位地址" prop="payerAddress">
               <el-input v-model="form.payerAddress"  :readonly="true" class="input-noborder"/>
             </el-form-item>
           </el-col>
	       </el-row>
	       <el-row :gutter="15">

	         <el-col :span="8">
	           <el-form-item label="纳税人识别号" prop="creditCode" >
	             <el-input v-model="form.creditCode" :readonly="true" class="input-noborder"/>
	           </el-form-item>
	         </el-col>
           <el-col :span="8">
             <el-form-item label="单位电话"    prop="payerPhone">
               <el-input v-model="form.payerPhone"   :readonly="true" class="input-noborder"/>
             </el-form-item>
           </el-col>
           <el-col :span="8">
             <el-form-item label="单位开户行"    prop="payerOpeningBank">
               <el-input v-model="form.payerOpeningBank" :readonly="true" class="input-noborder"/>
             </el-form-item>
           </el-col>
	       </el-row>
	       <el-row :gutter="15">

	         <el-col :span="8">
	           <el-form-item label="单位账号"    prop="payerAccount">
	             <el-input v-model="form.payerAccount" :readonly="true" class="input-noborder"/>
	           </el-form-item>
	         </el-col>
           <el-col :span="8">
             <el-form-item label="开票金额(含税)" prop="invoiceAmountTax" label-width="120px">
               <el-input v-model="form.invoiceAmountTax" :readonly="true" class="input-noborder" @blur='takeAcc(this)' oninput="value=value.replace(/[^0-9.]/g,'')"/>
             </el-form-item>
           </el-col>
           <el-col :span="8">
             <el-form-item label="开票金额(不含税)"  prop="invoiceAmountNtax" label-width="130px">
               <el-input v-model="form.invoiceAmountNtax"  :readonly="true" class="input-noborder"/>
             </el-form-item>
           </el-col>
	       </el-row>
	       <el-row :gutter="15">

	             <el-col :span="8">
	               <el-form-item label="预计回款时间" prop="expectedCollectionTime" >
	                 <el-input v-model="form.expectedCollectionTime" :readonly="true" class="input-noborder"/>
	               </el-form-item>
	             </el-col>

           <el-col :span="8">

             <el-form-item
               label="系统录入记录" prop="record">
               <el-upload
                 :disabled="authenStatus"
                 ref="field111"
                 :file-list="record"
                 :action="field111Action"
                 :headers="token"
                 :on-success="contractApprovalFileSuccess"
                 :on-remove="removeContractApprovalFile"
                 :auto-upload="autoUploadFalg"
                 multiple
                 :limit="20"
                 :before-upload="field111BeforeUpload"
                 :on-preview="handlePictureCardPreview"
               >
                 <el-button slot="trigger"  size="small" type="primary">选取文件</el-button>
                 <!-- <div slot="tip" class="el-upload__tip">  v-if="uploadVis"
                     只能上传jpg/png文件，且不超过500kb
                   </div> -->
               </el-upload>


             </el-form-item>
           </el-col>
           <el-col :span="8">

             <el-form-item label-width="150px"
                           label="一般纳税人证明材料" prop="zmcl">
               <el-upload
                 :disabled="authenStatus"
                 ref="field111"
                 :file-list="zmcl"
                 :action="field111Action"
                 :headers="token"
                 :on-success="zmclApprovalFileSuccess"
                 :on-remove="removeZmclApprovalFile"
                 :auto-upload="autoUploadFalg"
                 multiple
                 :limit="20"
                 :before-upload="field111BeforeUpload"
                 :on-preview="handlePictureCardPreview"
               >
                 <el-button slot="trigger"  size="small" type="primary">选取文件</el-button>
                 <!-- <div slot="tip" class="el-upload__tip">  v-if="uploadVis"
                     只能上传jpg/png文件，且不超过500kb
                   </div> -->
               </el-upload>


             </el-form-item>
           </el-col>
	       </el-row>
	       <el-row>
	         <el-col :span="24" style="margin-top: 0;">
	          <el-divider content-position="center" ><el-link type="primary"><b>开票信息</b></el-link></el-divider>
	         </el-col>
	       </el-row>
         <el-row :gutter="15">
           <el-table :data="invoiceDataList">
             <el-table-column label="项目名称" prop="invoiceProName" header-align="center" align="center">
             </el-table-column>
             <el-table-column label="规格" prop="invoiceSpec" header-align="center" align="center">
             </el-table-column>
             <el-table-column label="型号" prop="invoiceType" header-align="center" align="center">
             </el-table-column>
             <el-table-column label="单价" prop="invoicePrice"   header-align="center" align="center">
             </el-table-column>
             <el-table-column label="数量" prop="invoiceMount"   header-align="center" align="center">
             </el-table-column>
             <el-table-column label="金额(含税)" prop="invoiceAmountTax"   header-align="center" align="center">
             </el-table-column>
             <el-table-column label="税率" prop="invoiceTaxrate"   header-align="center" align="center">
             </el-table-column>
             <el-table-column label="金额(不含税)" prop="invoiceAmountNtax"   header-align="center" align="center">
             </el-table-column>

           </el-table>
         </el-row>
	</el-form>
  <el-row :gutter="15">
    <el-col :span="24" >
      <el-divider content-position="center" ><el-link type="primary"><b>审核信息</b></el-link></el-divider>
    </el-col>
  </el-row>
    <el-row :gutter="15">
      <el-table
        :data="fromData"
        border
        style="width: 100%">
        <el-table-column
          prop="taskNodeName"
          label="审批部门"
          width="250">
        </el-table-column>
        <el-table-column
          prop="createName"
          label="审批人"
          width="180">
        </el-table-column>
        <el-table-column
          prop="createdDate"
          width="180"
          label="审批时间">
        </el-table-column>
        <el-table-column
          width="100"
          prop="formHistoryDataDTO[0].value"
          label="是否同意">
        </el-table-column>
        <el-table-column
          prop="formHistoryDataDTO[1].value"
          label="审批意见(批注)">
        </el-table-column>
      </el-table>
    </el-row>
 
<!--  <el-card class="box-card" v-for="(historyData, index) in fromData"  :key="index" >-->
<!--    <div slot="header" class="clearfix">-->
<!--      <span>{{historyData.taskNodeName}}</span>-->
<!--    </div>-->
<!--    <el-alert  type="success"  :closable="false" style="margin-bottom: 10px;">-->
<!--      <span class="in-text">审批人：{{historyData.createName}}</span>-->
<!--      <span class="in-text">审批时间：{{historyData.createdDate}}</span>-->
<!--    </el-alert>-->
<!--    <el-form v-for="(fistoryFormData, indexH) in historyData.formHistoryDataDTO" :key="indexH" label-width="80px">-->
<!--      <el-form-item :label=fistoryFormData.title >-->
<!--        <el-input v-model="fistoryFormData.value" :readonly="true"/>-->
<!--      </el-form-item>-->
<!--    </el-form>-->
<!--  </el-card>-->

</div>
</template>

<script>
  import { getLeave } from '@/api/workflow/leave'
  import { historyFromData,getCollection } from '@/api/activiti/historyFormdata'
  import { getToken } from "@/utils/auth";
  import { findProjectType, findBranchOffice,findFileListByPidPtype,delFileById } from "@/api/utils";
  import { findWorkFlowFormData ,listApplyCollection,detailNgcApproval,findContract,detailhtCon,getUserInfo  } from "@/api/collection/common";

  export default {
    name: "leaveHistoryForm",
    props: {
      businessKey: {
        type: String
      }
    },
    data(){
      return{
        authenStatus:true,
        record:[],
        zmcl:[],
        token: {},
        autoUploadFalg: true,
        field111Action: this.$fieldPathAction,
        fromData:[],
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
        getCollection(this.businessKey).then(response => {
          this.form = response.data
          let proName_ = response.data;
      //项目类型列表
         this.getDicts("project_category_type").then((response) => {
           for(let item of response.data) {
             if(item.dictValue==proName_.approvalType){
               this.form.approvalType = item.dictLabel;
             }
           }
         });

         this.getDicts("bill_type").then((response) => {
           for(let item of response.data) {
             if(item.dictValue==proName_.invoiceType){
               this.form.invoiceType = item.dictLabel;
             }
           }
         });
          for(let item of response.data.ctBuInvoiceReqDetail) {
             this.taxrate =   item.invoiceAmountTaxs;
            this.invoiceDataList.push({
              id: item.id,
              invoiceProName: item.invoiceProName,
              invoiceSpec: item.invoiceSpec,
              invoiceType: item.invoiceType,
              invoicePrice: item.invoicePrice,
              invoiceMount: item.invoiceMount,
              invoiceAmountTax: item.invoiceAmountTax,
              invoiceTaxrate: item.invoiceTaxrate,
              invoiceAmountNtax: item.invoiceAmountNtax,
            });
          }

          if(this.form.id!=null && this.form.id!=''){
            findFileListByPidPtype(this.form.id,1).then(response => {
              this.record= response.data;
            });
            findFileListByPidPtype(this.form.id,2).then(response => {
              this.zmcl= response.data;
            });
          }else{
            this.$nextTick(() => {
              this.$refs.field111.clearFiles();
            })
          }

        })
      },
      historyFromData() {
        historyFromData(this.businessKey).then(response => {
          this.fromData = response.data
        })
      },
      /** 文件上传检测 **/
      field111BeforeUpload(file) {
        let isRightSize = file.size / 1024 / 1024 < 20;
        if (!isRightSize) {
          this.$message.error('文件大小超过 20MB');
        }
        return isRightSize;
      },
      /** 上传附件成功操作 **/
      zmclApprovalFileSuccess(res, file, fileList) {
        for (let index = 0; index < fileList.length; index++) {
          const element = fileList[index];
          if (element.uid == file.uid) {
            element.uid = res.msg;
          }
        }
        if (this.form.zmcl) {
          this.form.zmcl += res.msg + ",";
        } else {
          this.form.zmcl = res.msg + ",";
        }
        this.uploadVal1 = true;
      },
      /** 上传附件成功操作 **/
      contractApprovalFileSuccess(res, file, fileList) {
        for (let index = 0; index < fileList.length; index++) {
          const element = fileList[index];
          if (element.uid == file.uid) {
            element.uid = res.msg;
          }
        }
        if (this.form.record) {
          this.form.record += res.msg + ",";
        } else {
          this.form.record = res.msg + ",";
        }
        this.uploadVal1 = true;
      },
      /** 删除附件操作 **/
      removeContractApprovalFile(file, fileList) {
        delFileById(file.uid).then(response => {
          if (response.code == 200) {
            this.form.record = null;
            for (let index = 0; index < fileList.length; index++) {
              const element = fileList[index];
              if (this.form.record) {
                this.form.record += element.uid + ",";
              } else {
                this.form.record = element.uid + ",";
              }
            }
          }
        });
      },
      removeZmclApprovalFile(file, fileList) {
        delFileById(file.uid).then(response => {
          if (response.code == 200) {
            this.form.zmcl = null;
            for (let index = 0; index < fileList.length; index++) {
              const element = fileList[index];
              if (this.form.zmcl) {
                this.form.zmcl += element.uid + ",";
              } else {
                this.form.zmcl = element.uid + ",";
              }
            }
          }
        });
      },

      /** 上传附件成功操作 **/
      invoiceImgFileSuccess(res, file, fileList) {
        for (let index = 0; index < fileList.length; index++) {
          const element = fileList[index];
          if (element.uid == file.uid) {
            element.uid = res.msg;
          }
        }
        if (this.form.invoiceImg) {
          this.form.invoiceImg += res.msg + ",";
        } else {
          this.form.invoiceImg = res.msg + ",";
        }
        this.uploadVal = true;
      },
      /** 删除附件操作 **/
      removeInvoiceImglFile(file, fileList) {
        delFileById(file.uid).then(response => {
          if (response.code == 200) {
            this.form.invoiceImg = null;
            for (let index = 0; index < fileList.length; index++) {
              const element = fileList[index];
              if (this.form.invoiceImg) {
                this.form.invoiceImg += element.uid + ",";
              } else {
                this.form.invoiceImg = element.uid + ",";
              }
            }
          }
        });
      },
      handlePictureCardPreview(file) {//点击放大图片
        if((file.url).indexOf("profile")>=0){
          let files = (file.url).split("profile");
          let url = window.location.hostname;
          if(url.indexOf("http")<0){
            url = "http://"+url;
          }
          // var url_ = url+":9001/profile"+files[1];
          window.open(url+":9001/dictionary/fileManage/dwonLoadFile/"+file.uid+'/'+file.ptype);
        }
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
