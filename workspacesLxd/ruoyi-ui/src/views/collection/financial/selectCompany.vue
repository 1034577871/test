<template>
  <div>
    <el-input placeholder="请选择税率"  :value="title" :readonly='true' @focus='dialogVisible = true'/>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      append-to-body
      width="40%">
          <el-table
            ref="multipleTable"
            :data="companyList"
            tooltip-effect="dark"
             highlight-current-row
            style="width: 100%"
            @row-click="rowClick">
            <!-- <el-table-column
              label="单位ID"
              width="100%" v-if="show">
              <template slot-scope="scope">{{ scope.row.id }}</template>
            </el-table-column> -->
            <el-table-column
              label="税率"
             >
              <template slot-scope="scope">{{ scope.row.taxrate }}</template>
            </el-table-column>

          </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confirm">确 定</el-button>
      </span>
    </el-dialog>
  </div>


</template>


<script>
  import request from '@/utils/request'
  export default {
    name: 'seleccompanyList',
    props:{
      objId:{
        type:String,
        default:'',
      }
    },
    data() {
      return {
        show: false,
        desc: '选择项目对话框',
        title:'',
        dialogVisible:false,
        companyList:[],
        selectItem:'',
      }
    },
    created() {
      // this.getObjectList().then(res=>{
      //   this.dataSource = res.rows;
      // });
      this.getCompanyList().then(res=>{
        this.companyList = res.rows;
      });

    },
    methods: {
      getCompanyList(){
        //查询企业信息列表
        return request({
          url:'/dictionary/taxrate/list',
          methods:'get'
        });
      },
      rowClick(e){
        this.selectItem = e;//点击后 选中当前行的数据
      },
      confirm(){
        this.$emit('ok',this.selectItem.id,this.selectItem.taxrate)
        this.dialogVisible = false;
      }
    },

  }
</script>

<style>
</style>
