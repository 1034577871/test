<template>
  <div>
    <el-row :gutter="15">
      <el-col :span="24" >
        <el-divider content-position="center" ><el-link type="primary"><b>收款单信息</b></el-link></el-divider>
      </el-col>
	<el-form ref="form" :model="form"  label-width="80px">
	        <el-col :span="8">
	          <el-form-item label="项目类型" prop="approvalId">
	            <el-input v-model="form.approvalId" :readonly="true"  />
	          </el-form-item>
	        </el-col>

	        <el-col :span="8">

	          <el-form-item label="项目编号" prop="proNo">
	            <el-input v-model="form.proNo" :readonly="true"  />
	          </el-form-item>
	         </el-col>
	         <el-col :span="8">
	          <el-form-item label="项目名称" prop="proName">
	            <el-input v-model="form.proName"  :readonly="true"    placeholder="请输入项目名称"  />
	          </el-form-item>
	        </el-col>

	         <el-col :span="8">
	           <el-form-item label="事前审批表ID 关联事前审批表ID" prop="approvalId" v-if="show">
	              <el-input v-model="form.contractId" placeholder="" />
	           </el-form-item>
	          <el-form-item label="合同编号"     prop="contractNo">
	              <el-input v-model="form.contractNo" :readonly="true"  placeholder="请输入合同编号" />
	          </el-form-item>
	        </el-col>
	        <el-col :span="8">
	          <el-form-item
	        label="合同名称"    prop="contractName">
	            <el-input v-model="form.contractName" :readonly="true"  placeholder="请输入合同名称" />
	          </el-form-item>
	        </el-col>
	        <el-form-item label="发票ID" prop="invoiceId"  v-if="show">
	          <el-input v-model="form.invoiceId" placeholder="请输入发票ID" />
	        </el-form-item>
	         <el-col :span="8">
	          <el-form-item label="发票代码" prop="invoiceCode">
	            <el-input v-model="form.invoiceCode" placeholder="请输入发票代码" />
	          </el-form-item>
	         </el-col>
	         <el-col :span="8">
	          <el-form-item label="发票号码" prop="invoiceNo">
	            <el-input v-model="form.invoiceNo" placeholder="请输入发票号码" />
	          </el-form-item>
	         </el-col>
	         <el-col :span="8">
	          <el-form-item label="回款时间" prop="collectionTime">
	            <el-date-picker clearable size="small" :style="{ width: '100%' }"
	              v-model="form.collectionTime"
	              type="date"
	              value-format="yyyy-MM-dd"
	              placeholder="选择回款时间">
	            </el-date-picker>
	          </el-form-item>
	         </el-col>
	         <el-col :span="8">
	          <el-form-item label="回款金额" prop="collectionAmount">
	            <el-input v-model="form.collectionAmount" placeholder="请输入回款金额" />
	          </el-form-item>
	         </el-col>
	         <el-col :span="8">
	          <el-form-item label="单据编号" prop="documentNumber">
	            <el-input v-model="form.documentNumber" placeholder="请输入单据编号" />
	          </el-form-item>
	         </el-col>
	          <el-col :span="8">
	          <el-form-item label="回款方式" prop="paymentMethod">
              <el-input v-model="form.paymentMethod" placeholder="请输入单据编号" />

	          </el-form-item>
	         </el-col>
	        <el-form-item label="状态" v-if="show">
	          <el-radio-group v-model="form.status">
	            <el-radio label="1">请选择字典生成</el-radio>
	          </el-radio-group>
	        </el-form-item>
	        <el-form-item label="状态说明" prop="statusps"  v-if="show">
	          <el-input v-model="form.statusps" placeholder="请输入状态说明" />
	        </el-form-item>
	        <el-form-item label="删除标志" prop="delFlag"  v-if="show">
	          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
	        </el-form-item>
	        <el-form-item label="备注" prop="remark"  v-if="show">
	          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
	        </el-form-item>
<!--	         <el-col :span="8">-->
<!--             <el-form-item label="银行单据" prop="voucher">-->
<!--               <el-upload-->
<!--                 :disabled="true"-->
<!--                 ref="field101"-->
<!--                 :file-list="voucher"-->
<!--                 :action="field101Action"-->
<!--                 :headers="token"-->
<!--                 :on-success="contractApprovalFileSuccess"-->
<!--                 :on-remove="removeContractApprovalFile"-->
<!--                 :auto-upload="autoUploadFalg"-->
<!--                 multiple-->
<!--                 :limit="20"-->
<!--                 :before-upload="field101BeforeUpload"-->
<!--                 :on-preview="handlePictureCardPreview"-->
<!--               >-->
<!--                 <el-button slot="trigger" size="small"  :disabled="true" type="primary">选取文件</el-button>-->
<!--               </el-upload>-->
<!--             </el-form-item>-->
<!--	</el-col>-->

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
  import { historyFromData,getCollectionAudit } from '@/api/activiti/historyFormdata'
  import { getToken } from "@/utils/auth";
  export default {
    name: "leaveHistoryForm",
    props: {
      businessKey: {
        type: String
      }
    },
    data(){
      return{
        voucher:[],
        token: {},
        autoUploadFalg: true,
        field101Action: this.$fieldPathAction,
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
      /** 文件上传检测 **/
      field101BeforeUpload(file) {
        let isRightSize = file.size / 1024 / 1024 < 20;
        if (!isRightSize) {
          this.$message.error('文件大小超过 20MB');
        }
        return isRightSize;
      },
      /** 上传附件成功操作 **/
      contractApprovalFileSuccess(res, file, fileList) {
        for (let index = 0; index < fileList.length; index++) {
          const element = fileList[index];
          if (element.uid == file.uid) {
            element.uid = res.msg;
          }
        }
        if (this.form.voucher) {
          this.form.voucher += res.msg + ",";
        } else {
          this.form.voucher = res.msg + ",";
        }
      },
      /** 删除附件操作 **/
      removeContractApprovalFile(file, fileList) {
        delFileById(file.uid).then(response => {
          if (response.code == 200) {
            this.form.voucher = null;
            for (let index = 0; index < fileList.length; index++) {
              const element = fileList[index];
              if (this.form.voucher) {
                this.form.voucher += element.uid + ",";
              } else {
                this.form.voucher = element.uid + ",";
              }
            }
          }
        });
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePreview(file) {
        console.log(file);
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
      getLeave() {
        getCollectionAudit(this.businessKey).then(response => {
          this.form = response.data
          let proName_ = response.data;
      //项目类型列表
         this.getDicts("project_category_type").then((response) => {
           for(let item of response.data) {
             if(item.dictValue==proName_.approvalId){
               this.form.approvalId = item.dictLabel;
             }
           }
         });

         this.getDicts("collection_method_type").then((response) => {
           for(let item of response.data) {
             if(item.dictValue==proName_.paymentMethod){
               this.form.paymentMethod = item.dictLabel;
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
