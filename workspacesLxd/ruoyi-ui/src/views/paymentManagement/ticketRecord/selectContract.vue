<template>
  <div>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      append-to-body
      width="40%"
      v-on:close="close">
      <el-form
        :model="queryParams"
        ref="queryForm"
        :inline="true"
        v-show="showSearch"
        label-width="90px"
      >
        <el-form-item label="合同名称" prop="contractName">
          <el-input
            v-model="queryParams.contractName"
            placeholder="请输入合同名称"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <el-form-item>
          <el-button
            type="cyan"
            icon="el-icon-search"
            size="mini"
            @click="handleQuery"
            >搜索</el-button
          >
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
            >重置</el-button
          >
        </el-form-item>
      </el-form>
          <el-table
            ref="multipleTable"
            :data="contractCategoryList"
            tooltip-effect="dark"
             highlight-current-row
            style="width: 100%"
            >
            <el-table-column label="合同编号" >
              <template slot-scope="scope">{{ scope.row.contractNo }}</template>
            </el-table-column>
            <el-table-column label="合同名称" >
              <template slot-scope="scope">{{ scope.row.contractName }}</template>
            </el-table-column>
            <el-table-column
                label="对方单位名称"
                width="120">
                <template slot-scope="scope">{{ scope.row.oppositeName }}</template>
            </el-table-column>
            <el-table-column
              label="操作"
              align="center"
              class-name="small-padding fixed-width"
            >
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  type="text"
                  icon="el-icon-edit"
                  @click="submithtForm(scope.row)"
                  >选择</el-button
                >
              </template>
            </el-table-column>
          </el-table>
          <pagination
            v-show="total > 0"
            :total="total"
            :page.sync="queryParams.pageNum"
            :limit.sync="queryParams.pageSize"
            @pagination="getList"
          />
    </el-dialog>
  </div>


</template>



<script>
  import request from '@/utils/request';
  import {listContract,getContract} from '../../../api/contract/contractInfo.js';
  export default {
    name: 'selecContract',
    props:{
      objId:{
        type:String,
        default:'',
      },
      contractCategory:{
        type:String,
        default:''
      },
    },
    data() {
      return {
        show: false,
        desc: '选择项目对话框',
        title:'',
        dialogVisible:true,
        contractCategoryList:[],
        selectItem:'',
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          contractName: null,
        },
      }
    },
    created() {
      this.getList();
    },
    methods: {
      /** 选择合同 */
      submithtForm(row) {
        this.$emit('ok',row.id,row.projectId,row.projectNo,row.projectName,row.contractNo,row.contractName,
        row.oppositeName,row.oppositeBank,row.oppositeBankId,row.oppositeContacts,row.oppositePhone,row.oppositeAddress,
        row.taxrate,row.oppositeCreditCode,row.totalMoney,row.receiveAmount,row.outstandingAmount)
        this.title = row.contractName;
        this.dialogVisible = true;
        this.open = false;
      },

      close(){
        this.$emit('ok',"","","","","","","","","","","","","","","","","")
        this.dialogVisible = true;
      },
      /** 查询合同信息列表 */
      getList() {
        this.loading = true;
        this.queryParams.contractCategory = this.contractCategory;
        listContract(this.queryParams).then((response) => {
          this.contractCategoryList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
        // findAreaList().then((response) => {
        //   this.field101Options = JSON.parse(response.data);
        // });
      },
      czyFormat(row, column) {
        return this.selectDictLabel(this.companyTypeOptions, row.companyType);
      },
      // 取消按钮
      cancel() {
        this.open = false;
        this.reset();
      },
      // 表单重置
      reset() {
        this.form = {
          id: null,
          createBy: null,
          createTime: null,
          updateBy: null,
          updateTime: null,
        };
        this.resetForm("form");
      },
      /** 搜索按钮操作 */
      handleQuery() {
        this.queryParams.pageNum = 1;
        this.getList();
      },
      /** 重置按钮操作 */
      resetQuery() {
        this.resetForm("queryForm");
        this.handleQuery();
      },

    },

  }
</script>

<style>
</style>
