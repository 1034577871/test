<!-- 审批详情弹出页 -->
<template>
  <div>
     <el-form ref="form" :model="form" label-width="180px">
        <el-dialog title="查看" :visible.sync="modalShow" width="80%" :before-close="modalClose">
       <el-row>
         <el-col :span="12">
           <el-form-item label="合同类别" prop="contractCategory">
             <el-input v-model="form.contractCategory" placeholder="合同类别"  disabled="true" v-if="show"/>
           </el-form-item>
         </el-col>
         <el-col :span="12"   v-if="show">
           <el-form-item label="申请单号" prop="reqId">
             <el-input v-model="form.reqId" placeholder="请输入申请单号"  disabled="true" v-if="show"/>
           </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="发票代码" prop="invoiceCode">
              <el-input v-model="form.invoiceCode"  disabled="true" placeholder="请输入发票代码" />
            </el-form-item>
          </el-col>
       </el-row>
       <el-row>

          <el-col :span="12">
           <el-form-item label="发票号码" prop="invoiceNo">
             <el-input v-model="form.invoiceNo"  disabled="true" placeholder="请输入发票号码" />
           </el-form-item>


         </el-col>

         <el-col :span="12">
           <el-form-item label="发票开具日期" prop="invoiceDate">
             <el-date-picker clearable size="small" :style="{ width: '100%' }"
               v-model="form.invoiceDate"
               type="date"  disabled="true"
               value-format="yyyy-MM-dd"
               placeholder="选择发票开具日期">
             </el-date-picker>
           </el-form-item>
         </el-col>
       </el-row>
       <el-row>

         <el-col :span="12" >
           <el-form-item label="开票人" prop="invoiceDrawer">
             <el-input v-model="form.invoiceDrawer"  disabled="true" readonly="true" placeholder="请输入开票人" />
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item label="复核人" prop="invoiceReviewer">
             <el-input v-model="form.invoiceReviewer"  disabled="true" placeholder="请输入复核人" />
           </el-form-item>
         </el-col>
       </el-row>
       <el-row>

         <el-col :span="12">
           <el-form-item label="收款人" prop="invoicePayee">
             <el-input v-model="form.invoicePayee"  disabled="true" placeholder="请输入收款人xx" />
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item label="发票金额" prop="invoiceAmountTax">
             <el-input v-model="form.invoiceAmountTax"  disabled="true"  v-on:input="changeNum()" oninput="value=value.replace(/[^0-9.]/g,'')" placeholder="请输入发票金额" />
           </el-form-item>
         </el-col>
       </el-row>
       <el-row>

         <el-col :span="12">
           <el-form-item label="税率" prop="invoiceTaxrate">
            <!-- <selectCompany ref='company'  @ok='companyOk'/> -->
             <el-input v-model="form.invoiceTaxrate"  disabled="true"  @focus="getSlLists" oninput="value=value.replace(/[^0-9.]/g,'')" placeholder="请输入税率" />
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item label="金额（不含税）" prop="invoiceAmountNtax">
             <el-input v-model="form.invoiceAmountNtax"   disabled="true" placeholder="请输入金额" />
           </el-form-item>
         </el-col>
       </el-row>
       <el-row>

      <el-col :span="12">
        <el-form-item label="发票图片" prop="archiveFiles">
          <el-upload
            ref="field101"
            :file-list="field101fileList"
            :action="field101Action"
            :on-success="handleAvatarSuccess"
            :on-remove="removeFile"
            :auto-upload="autoUploadFalg"
            multiple
            :limit="20"
            :before-upload="field101BeforeUpload"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
            <!-- <div slot="tip" class="el-upload__tip">
              只能上传jpg/png文件，且不超过500kb
            </div> -->
          </el-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="企业资质图片" prop="archiveFiles">
          <el-upload
            ref="field101"
            :file-list="field101fileList"
            :action="field101Action"
            :on-success="handleAvatarSuccess"
            :on-remove="removeFile"
            :auto-upload="autoUploadFalg"
            multiple
            :limit="20"
            :before-upload="field101BeforeUpload"
          >
            <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
            <!-- <div slot="tip" class="el-upload__tip">
              只能上传jpg/png文件，且不超过500kb
            </div> -->
          </el-upload>
        </el-form-item>
      </el-col>
       </el-row>
       </el-dialog>
     </el-form>

  </div>
</template>

<script>
  import { findWorkFlowFormData ,listApplyCollection,detailNgcApproval,findContract,detailhtCon,getUserInfo  } from "@/api/collection/common";
    import { historyFromData,getCollection } from '@/api/activiti/historyFormdata'
    import { getFinancial } from "@/api/collection/financial";

    export default {
        name: "index",
        data() {
            return {
               tableData:[], //审批信息
                addOrUpdateVisible:false,
               invoiceDataList:[], //开票信息
              show:false,
                modalShow:false,
                 projectCategoryTypeList:[],
                 form: {
                   proNo: null,
                    proName:null,
                    contractNo:null,
                    contractName:null,
                    reqUsername:null,
                    reqDeptname:null,
                    reqDate:null,
                    invoiceAmountTax:null,
                    invoiceAmountNtax:null,
                    businessKey:null
                  },
            }
        },

        methods:{
            init(row){
              this.form.businessKey = row.id;

this.modalShow = true;
          getFinancial(row.id).then(response => {
            this.modalShow = true;
              this.form = response.data;
              this.title = "查看详情";

              let type = response.data.contractCategory;

              this.getDicts("contract_category_type").then((response1) => {
                    for(let item of response1.data) {
                      if(item.dictValue==type){
                        this.form.contractCategory = item.dictLabel;
                      }
                    }
              });
            });



             // getCollection(this.form.businessKey).then(response => {
             //     this.form = response.data
             //     let proName_ = response.data;
             //    this.modalShow = true;
             //     this.tableData = response.data.actWorkflowFormData;
             // //项目类型列表
             //    this.getDicts("project_category_type").then((response1) => {
             //      for(let item of response1.data) {
             //        if(item.dictValue==proName_.approvalType){
             //          this.form.approvalType = item.dictLabel;
             //        }
             //      }
             //    });

             //    this.getDicts("bill_type").then((response2) => {
             //      for(let item of response2.data) {
             //        if(item.dictValue==proName_.invoiceType){
             //          this.form.invoiceType = item.dictLabel;
             //        }
             //      }
             //    });
             //    this.invoiceDataList = [];
             //     for(let item of response.data.ctBuInvoiceReqDetail) {
             //        this.taxrate =   item.invoiceAmountTaxs;
             //       this.invoiceDataList.push({
             //         id: item.id,
             //         invoiceProName: item.invoiceProName,
             //         invoiceSpec: item.invoiceSpec,
             //         invoiceType: item.invoiceType,
             //         invoicePrice: item.invoicePrice,
             //         invoiceMount: item.invoiceMount,
             //         invoiceAmountTax: item.invoiceAmountTax,
             //         invoiceTaxrate: item.invoiceTaxrate,
             //         invoiceAmountNtax: item.invoiceAmountNtax,
             //       });
             //     }

             //   })

              //this.findWork();
            },
            findWork(){
              findWorkFlowFormData(this.form).then(responses => {
                this.tableData = responses;
              });
            },
            modalClose(){
                this.modalShow = false;
            }
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
