
<template>
	<el-form ref="form" :model="form" label-width="120px">
	  <el-form-item label="统一社会信用代码">
		<el-input v-model="form.creditCode"></el-input>
	  </el-form-item>
	  <el-form-item label="企业名称">
	  		<el-input v-model="form.companyName"></el-input>
	  </el-form-item>
    <el-form-item label="企业类型">
    		<el-radio-group v-model="form.companyType">
    		  <el-radio label="甲方"></el-radio>
    		  <el-radio label="乙方"></el-radio>
    		</el-radio-group>
    </el-form-item>
    <el-col :span="12">
      <el-form-item label="所属省份">
      <el-select v-model="form.provinceId" placeholder="请选择">
        <el-option label="山东" value="shanghai"></el-option>
        <el-option label="河北" value="beijing"></el-option>
      </el-select>
      </el-form-item>
    </el-col>
    <el-col :span="12">
      <el-form-item label="所属地市">
          <el-select v-model="form.cityId" placeholder="请选择">
            <el-option label="济南" value="shanghai"></el-option>
            <el-option label="石家庄" value="beijing"></el-option>
          </el-select>
      </el-form-item>
    </el-col>
	  <el-form-item label="地址">
	  		<el-input v-model="form.address"></el-input>
	  </el-form-item>
    <el-col :span="12">
      <el-form-item label="联系人">
          <el-input v-model="form.linkman"></el-input>
      </el-form-item>
    </el-col>
    <el-col :span="12">
      <el-form-item label="联系电话">
      		<el-input v-model="form.linkphone"></el-input>
      </el-form-item>
    </el-col>
	  <el-form-item label="开户行">
	  		<el-input v-model="form.openingBank"></el-input>
	  </el-form-item>
	  <el-form-item label="开户账号">
	  		<el-input v-model="form.openingAccount"></el-input>
	  </el-form-item>
	  <el-form-item label="备注">
	  		<el-input type="textarea" v-model="form.remark"></el-input>
	  </el-form-item>

	</el-form>
</template>
<script>
  export default {
    data() {
      return {
        form: {
          creditCode: '',
          companyName: '',
          provinceId: '',
          provinceName: '',
          cityId: '',
          cityName: '',
          address: '',
          linkman: '',
          linkphone:'',
          openingBank:'',
          openingAccount:'',
          companyType:'',
          remark:''
        }
      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      }
    }
  }
</script>
