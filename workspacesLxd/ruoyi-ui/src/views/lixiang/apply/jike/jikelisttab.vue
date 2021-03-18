<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="基本信息" name="first">
      <basicInfo></basicInfo>
    </el-tab-pane>
    <el-tab-pane label="材料信息" name="second">
      <materialsInfo></materialsInfo>
    </el-tab-pane>
    <el-tab-pane label="施工费信息" name="third">施工费信息</el-tab-pane>
    <el-tab-pane label="事前审批" name="fourth">事前审批</el-tab-pane>
  </el-tabs>
</template>

<script>

  import basicInfo from './basicInfo.vue'
  import materialsInfo from './materialsInfo.vue'

  export default {
    components: {
    	basicInfo,
      materialsInfo
    },

    data() {
      return {
        activeName: 'first',
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1517 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1519 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1516 弄'
        }]
      };
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>
<style>
</style>
