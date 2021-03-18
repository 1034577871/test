<template>
  <div>
    <el-row :gutter="15">
		<el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
		<el-col :span="12">
		 <el-form-item label="开票项目名称" prop="invoiceProName">
		     <el-input v-model="formData.invoiceProName"  placeholder="开票项目名称" />
		 </el-form-item>
		</el-col>
		<el-col :span="12">
		 <el-form-item label="规格" prop="invoiceSpec">
          <el-input v-model="formData.invoiceSpec"  placeholder="规格" />
      </el-form-item>
		</el-col>
		<el-col :span="12">
		 <el-form-item label="型号" prop="invoiceType">
          <el-input v-model="formData.invoiceType"  placeholder="型号" />
      </el-form-item>
		</el-col>
		<el-col :span="12">
		 <el-form-item label="单位" prop="unit">
		     <el-input v-model="formData.unit"  placeholder="单位" />
		 </el-form-item>
		</el-col>
		<el-col :span="12">
		 <el-form-item label="单价" prop="invoicePrice">
		     <el-input v-model="formData.invoicePrice"  placeholder="单价" />
		 </el-form-item>
		</el-col>
		<el-col :span="12">
		<el-form-item label="数量" prop="invoiceMount">
		    <el-input v-model="formData.invoiceMount"  placeholder="数量" />
		</el-form-item>
		</el-col>
    <el-col :span="12">
    <el-form-item label="金额（含税）" prop="invoiceAmount">
        <el-input v-model="formData.invoiceAmount"  placeholder="金额（含税）" />
    </el-form-item>
    </el-col>
    
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
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        invoiceProName:"",
        description:"",
        projectUnit:"",
        days:0,
        daysPrice:0,
        daysAmount:0
      },
      rules: {
        field102: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        field101: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}

</script>
<style>
</style>
