<template>
  <div>
    <el-row>
      <el-button-group>
        <el-button type="primary" icon="el-icon-document-add" @click="dialogVisible = true">新增</el-button>
        <el-button type="primary" icon="el-icon-edit">编辑</el-button>
        <el-button type="primary" icon="el-icon-delete">删除</el-button>
      </el-button-group>
    </el-row>

    <el-dialog title="新增信息" :visible.sync="dialogVisible" width="80%">
      <infoAdd></infoAdd>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogVisible = false">保存</el-button>
      </span>
    </el-dialog>

    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="no" label="序号" width="60"></el-table-column>
      <el-table-column prop="proId" label="项目编号"></el-table-column>
      <el-table-column prop="proName" label="项目名称"></el-table-column>
      <el-table-column prop="proLeader" label="项目负责人"></el-table-column>
      <el-table-column prop="applyDate" label="申请时间"></el-table-column>
      <el-table-column prop="compApply" label="申报分公司"></el-table-column>
      <el-table-column prop="compAbout" label="涉及分公司"></el-table-column>
      <el-table-column prop="compLeader" label="公司负责人"></el-table-column>
      <el-table-column prop="departApply" label="申报部门"></el-table-column>
      <el-table-column prop="departLeader" label="部门负责人"></el-table-column>
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
          no: '',
          proId: '2019031005',
          proName: '历下经十东路光缆维护项目',
          proLeader: '宋强',
          applyDate: '2016-05-02',
          compApply: '历下分公司',
          compAbout: '历下分公司',
          compLeader: '王经理',
          departApply: '财务部',
          departLeader: '王小虎'
        }
      ]
    };
  }
};
</script>
