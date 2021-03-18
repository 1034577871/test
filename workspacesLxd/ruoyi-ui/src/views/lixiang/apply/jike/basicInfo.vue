<template>
  <div>
    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-form-item label="涉及分公司" >
          <el-select v-model="formData.branchInvolvedId" multiple placeholder="请选择" :style="{width: '100%'}">
              <el-option
                v-for="item in branchInvolvedOptions"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
          </el-select>
        </el-form-item>
        <el-col :span="12">
          <el-form-item label="项目类别">
          		<el-select v-model="formData.projectTypeId" placeholder="请选择" clearable >
          			<el-option v-for="(item, index) in projectTypeOptions" :key="index" :label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
          		</el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公司负责人">
              <el-input v-model="formData.companyCharge"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="部门负责人">
              <el-input v-model="formData.departCharge"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="项目负责人">
              <el-input v-model="formData.proCharge"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="建筑物数量" :style="{width: '80%'}">
          	<el-input-number v-model="formData.buildingsNumber" :min="0" :step="1" ></el-input-number>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="涉及建筑户数" :style="{width: '80%'}">
          		<el-input-number v-model="formData.buildingsInvolvedNumber" :min="0" :step="1" ></el-input-number>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数字TV用户数" :style="{width: '80%'}">
          	<el-input-number v-model="formData.digitalTVNumber" :min="0" :step="1" ></el-input-number>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="宽带用户数" :style="{width: '80%'}">
          		<el-input-number v-model="formData.broadbandNumber" :min="0" :step="1" ></el-input-number>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="材料预算" >
          	<el-input v-model="formData.budgetMaterial" ></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="人工预算" >
          		<el-input v-model="formData.budgetLabor"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="预算总额" >
              <el-input v-model="formData.budgetTotal" :disabled="true"></el-input>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="设计时间" >
              <el-date-picker v-model="formData.designTime" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                :style="{width: '100%'}" placeholder="请选择日期" clearable></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="入场时间" >
            <el-date-picker v-model="formData.dmissionTime" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
              :style="{width: '100%'}" placeholder="请选择日期" clearable></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="完工时间" >
            <el-date-picker v-model="formData.completionTime" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
              :style="{width: '100%'}" placeholder="请选择日期" clearable></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="备注">
              <el-input type="textarea" v-model="formData.remark"></el-input>
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
        buildingsNumber:0,
        buildingsInvolvedNumber:0,
        digitalTVNumber:0,
        broadbandNumber:0,
        budgetMaterial:0,
        budgetLabor:0,
        budgetTotal:0,
      },
    }
  },

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
