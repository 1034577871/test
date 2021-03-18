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
        <el-form-item label="收付款说明" prop="conditionInfo">
          <el-input
            v-model="queryParams.conditionInfo"
            placeholder="请输入收付款说明"
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
            :data="contractPayInfo"
            tooltip-effect="dark"
             highlight-current-row
            style="width: 100%"
            >
            <el-table-column label="收付款说明" >
              <template slot-scope="scope">{{ scope.row.conditionInfo }}</template>
            </el-table-column>
            <el-table-column label="预计付款时间" >
              <template slot-scope="scope">{{ scope.row.estimateTime }}</template>
            </el-table-column>
            <el-table-column
                label="付款比例%"
                width="120">
                <template slot-scope="scope">{{ scope.row.paymentRatio }}</template>
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
  import {listContractPayinfo,getContractPayinfo} from '../../../api/contract/contractPayinfo.js';
  export default {
    name: 'selecContractPayInfo',
    props:{
      objId:{
        type:String,
        default:'',
      },
      contractNo:{
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
        contractPayInfo:[],
        selectItem:'',
        // companyType:{companyType:2},
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          conditionInfo: null,
          contractId: null,
        },
      }
    },
    created() {
      this.getList();
    },
    methods: {
      /** 选择合同收付款 */
      submithtForm(row) {
        this.$emit('ok',row.id,row.contractId,row.estimateTime,row.conditionInfo,row.paymentRatio,row.estimateMoney)
        this.title = row.conditionInfo;
        this.dialogVisible = true;
        this.open = false;
      },

      close(){
        this.$emit('ok',"","","","","","")
        this.dialogVisible = true;
      },
      /** 查询合同收付款信息列表 */
      getList() {
        this.loading = true;
        if(this.contractNo != null){
          this.queryParams.contractId = this.contractNo;
          listContractPayinfo(this.queryParams).then((response) => {
            this.contractPayInfo = response.rows;
            this.total = response.total;
            this.loading = false;
          });
        }

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
          creditCode: null,
          contractName: null,
          provinceId: null,
          provinceName: null,
          cityId: null,
          cityName: null,
          address: null,
          linkMan: null,
          linkPhone: null,
          openingBank: null,
          openingAccount: null,
          creditCode:null,
          // companyType: null,
          delFlag: null,
          remark: null,
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
