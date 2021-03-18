<template>
	<div>
    <el-row>
		<el-form ref="elForm" :model="formData" size="medium" label-width="100px">

        <el-form-item label="事前审批类型 1:集客类 2:非集客类" prop="approvalType">
                  <el-select v-model="formData.approvalType" placeholder="请选择事前审批类型 1:集客类 2:非集客类">
                    <el-option label="请选择字典生成" value="" />
                  </el-select>
                </el-form-item>
        <el-col :span="12">
          <el-form-item label="项目编号" prop="proNo">
            <el-input v-model="formData.proNo" placeholder="请输入项目编号" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="项目名称" prop="proName">
            <el-input v-model="formData.proName" placeholder="请输入项目名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
         <el-form-item label="合同编号" prop="contractNo">
           <el-input v-model="formData.contractNo" placeholder="请输入合同编号" />
         </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="合同名称" prop="contractName">
            <el-input v-model="formData.contractName" placeholder="请输入合同名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">

         <el-form-item label="发票类型" prop="invoiceType">
           <el-select
             v-model="formData.invoiceType"
             placeholder="发票类型"
           >
             <el-option
               v-for="dict in billTypeOptions"
               :key="dict.dictValue"
               :label="dict.dictLabel"
               :value="dict.dictValue"
             />
           </el-select>
 </el-form-item>
        </el-col>
        <el-col :span="12">
         <el-form-item label="申请部门编号" prop="reqDeptid">
           <el-input v-model="formData.reqDeptid" placeholder="请输入申请部门编号" />
         </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="申请部门名称" prop="reqDeptname">
            <el-input v-model="formData.reqDeptname" placeholder="请输入申请部门名称" />
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="申请人编号" prop="reqUserid">
            <el-input v-model="formData.reqUserid" placeholder="请输入申请人编号" />
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="申请人姓名" prop="reqUsername">
            <el-input v-model="formData.reqUsername" placeholder="请输入申请人姓名" />
          </el-form-item>
        </el-col>
      <el-col :span="24">
        <el-form-item label="申请日期" prop="reqDate">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="formData.reqDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择申请日期">
          </el-date-picker>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="付款单位名称" prop="payerName">
          <el-input v-model="formData.payerName" placeholder="请输入付款单位名称" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="纳税人识别号" prop="creditCode">
          <el-input v-model="formData.creditCode" placeholder="请输入纳税人识别号" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="付款单位地址" prop="payerAddress">
          <el-input v-model="formData.payerAddress" placeholder="请输入付款单位地址" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="付款单位电话" prop="payerPhone">
          <el-input v-model="formData.payerPhone" placeholder="请输入付款单位电话" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="付款单位开户行" prop="payerOpeningBank">
          <el-input v-model="formData.payerOpeningBank" placeholder="请输入付款单位开户行" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
       <el-form-item label="付款单位账号" prop="payerAccount">
         <el-input v-model="formData.payerAccount" placeholder="请输入付款单位账号" />
       </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="开票金额(含税)" prop="invoiceAmountTax">
          <el-input v-model="formData.invoiceAmountTax" placeholder="请输入开票金额" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="开票金额(不含税)" prop="invoiceAmountNtax">
          <el-input v-model="formData.invoiceAmountNtax" placeholder="请输入开票金额" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="预计回款时间" prop="expectedCollectionTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="formData.expectedCollectionTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择预计回款时间">
          </el-date-picker>
        </el-form-item>
      </el-col>
      <!--
      <el-col :span="12">
        <el-form-item label="状态">
          <el-radio-group v-model="formData.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-col>
-->
<el-col :span="24">
          <el-form-item size="large">
            <el-button type="primary" @click="submitForm">提交</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-col>
		</el-form>
    </el-row>
	</div>
</template>
<script>
  import { listCollection, getCollection, delCollection, addCollection, updateCollection, exportCollection } from "@/api/collection/collection";

	export default {
		components: {},
		props: [],
		data() {
			return {
          show: false,
				formData: {
          approvalType:"",
            approvalId:"",
            proNo:"",
            proName:"",
            contractNo:"",
            contractName:"",
            invoiceType:"",
            reqDeptid:"",
            reqDeptname:"",
            reqUserid:"",
            reqUsername:"",
            reqDate:"",
            payerName:"",
            creditCode:"",
            payerAddress:'',

				},
        branchInvolvedOptions: [{
					"label": "历下区",
					"value": 1
				}, {
					"label": "市中区",
					"value": 2
				}],
				projectTypeOptions: [{
					"label": "新建项目",
					"value": 1
				}, {
					"label": "改造项目",
					"value": 2
				}],
         billTypeOptions: [],
			}
		},
    rules: {
        field102: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
      },
		computed: {},
		watch: {},
		created() {

      this.getDicts("bill_type").then((response) => {
        this.billTypeOptions = response.data;
        console.log(billTypeOptions);
      });
    },
		mounted() {},
		methods: {
    submitForm() {
      this.$refs["elForm"].validate(valid => {
        if (valid) {
          addCollection(this.formData).then(response => {
            this.msgSuccess("新增成功");
            this.open = false;
            this.getList();
          });
        }
      });
    },

			resetForm() {
				this.$refs['elForm'].resetFields()
			},
		}
	}
</script>
