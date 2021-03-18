<template>
<el-form :model="formData" ref="formData" label-width="100px" >

  <table class="table-bordered " style="width: 100%;">
    <tr>
      <td><el-form-item label="金额">
          <el-input v-model="formData.num" ></el-input>
      </el-form-item>
      </td>
      <td>
        <el-form-item label="税率">
            <el-input v-model="formData.rate" ></el-input>
        </el-form-item>
      </td>
      <td>
        <el-form-item label="税后金额">
            <el-input v-model="formData.total" ></el-input>
        </el-form-item>
      </td>
      <td></td>
    </tr>
    <tr>
      <td><span class="labelX">维护成本(年维护费用*服务年度)</span></td>
      <td>
        <div v-for="item in formData.aalist" style="margin: 10px;">
          <el-input v-model="item.value" ></el-input>
        </div>
      </td>
      <td>
        <div  v-for="item in formData.bblist" style="margin: 10px;">
          <el-input v-model="item.value" ></el-input>
        </div>
      </td>
      <td>
        <el-button size="mini" type="success" @click="addRow()" style="margin: 10px;">新增</el-button>
        <div  v-for="item in formData.btnlist" style="margin: 15px 10px;">
          <el-button size="mini" type="warning" @click.prevent="delRow(item)">删除</el-button>
        </div>
      </td>
      </tr>
  </table>

</el-form>
</template>
<script>
  export default {
    data() {
      return {
        formData: {
          num:0,
          rate:0.2,
          total:0,
          aalist: [{
            value: ''
          }],
          bblist: [{
            value: ''
          }],
          btnlist: [],
        }
      };
    },
    methods: {
      addRow() {
        this.formData.aalist.push({
          value: '',
          key: Date.now()
        });
        this.formData.bblist.push({
          value: '',
          key: Date.now()
        });
        this.formData.btnlist.push({
          value: '',
          key: Date.now()
        });
      },
      delRow(item){
        var index = this.formData.btnlist.indexOf(item)
        //alert(index);
        if (index !== -1) {
          this.formData.btnlist.splice(index, 1);
          index +=1;
          this.formData.aalist.splice(index, 1);
          this.formData.bblist.splice(index, 1);
        }
      }
    },
    watch: {
       'formData.num':function(val){
          //var self = this;
          this.formData.total= val * this.formData.rate;
        }
      }
  }
</script>
<style>
	.table-bordered {
		border: 1px solid #ddd;
		border-collapse: collapse;
		border-spacing: 0;
	}

	.table-bordered td {
		border: 1px solid #ddd;
	}
  </style>