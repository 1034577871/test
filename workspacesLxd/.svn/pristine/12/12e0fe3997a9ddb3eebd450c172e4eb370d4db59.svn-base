<template>
  <div>
    <el-row>
      <el-button-group>
        <el-button type="primary" icon="el-icon-document-add" @click="dialogVisible = true">新增</el-button>
        <el-button type="primary" icon="el-icon-edit">编辑</el-button>
        <el-button type="primary" icon="el-icon-delete">删除</el-button>
      </el-button-group>
    </el-row>

    <el-dialog title="新增信息" :visible.sync="dialogVisible" width="50%">
      <infoAdd></infoAdd>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogVisible = false">保存</el-button>
      </span>
    </el-dialog>

    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="no" label="序号" width="60"></el-table-column>
      <el-table-column prop="reqNo" label="申请编号"></el-table-column>
      <el-table-column prop="proName" label="项目名称"></el-table-column>
      <el-table-column prop="proTypeName" label="项目类别"></el-table-column>
      <el-table-column prop="classification" label="项目分类"></el-table-column>
      <el-table-column prop="belongCompanyName" label="申请公司"></el-table-column>
      <el-table-column prop="contractAmountTotal" label="合同金额"></el-table-column>
      <el-table-column prop="contractAmountTax" label="不含税金额"></el-table-column>
    </el-table>
  </div>
</template>

<script>

  import infoAdd from './infoAdd.vue'

export default {
  components: {
    infoAdd
  },

  data() {
    return {
      dialogVisible: false,
      tableData: [
        {
          reqNo:"",
          proName:"",
          proTypeName:"",
          classification:"收入",
          belongCompanyName:"",
          contractAmountTotal:0,
          contractAmountTax:0,
        }
      ]
    };
  }
};
</script>
