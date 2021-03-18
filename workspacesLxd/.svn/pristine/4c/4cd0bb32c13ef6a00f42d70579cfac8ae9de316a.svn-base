<template>
  <div>
    <!-- <el-input placeholder="请选择对方单位" :value="title" :readonly='true' @focus='dialogVisible = true'/> -->
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
        <el-form-item label="企业名称" prop="companyName">
          <el-input
            v-model="queryParams.companyName"
            placeholder="请输入企业名称"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item>
        <!-- <el-form-item label="联系人" prop="linkMan">
          <el-input
            v-model="queryParams.linkMan"
            placeholder="请输入联系人"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item> -->
        <el-form-item>
          <el-button
            type="cyan"
            icon="el-icon-search"
            size="mini"
            @click="handleQuery"
          >搜索
          </el-button
          >
          <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置
          </el-button
          >
        </el-form-item>
      </el-form>
      <el-table
        ref="multipleTable"
        :data="companyList"
        tooltip-effect="dark"
        highlight-current-row
        style="width: 100%"
      >
        <!-- <el-table-column
          label="单位ID"
          width="100%" v-if="show">
          <template slot-scope="scope">{{ scope.row.id }}</template>
        </el-table-column> -->
        <el-table-column label="单位名称">
          <template slot-scope="scope">{{ scope.row.companyName }}</template>
        </el-table-column>
        <!-- <el-table-column
            label="对方单位银行账户"
            width="120">
            <template slot-scope="scope">{{ scope.row.openingBank }}</template>
        </el-table-column>
        <el-table-column
            label="对方单位银行账号"
            width="120" v-if="show">
            <template slot-scope="scope">{{ scope.row.openingAccount }}</template>
        </el-table-column> -->
        <el-table-column
          label="对方单位联系人"
          width="120">
          <template slot-scope="scope">{{ scope.row.linkMan }}</template>
        </el-table-column>
        <!-- <el-table-column
            label="对方单位联系方式"
            width="120" v-if="show">
            <template slot-scope="scope">{{ scope.row.linkPhone }}</template>
        </el-table-column> -->
        <!-- <el-table-column
            label="对方单位地址"
            width="120">
            <template slot-scope="scope">{{ scope.row.address }}</template>
        </el-table-column> -->
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
            >选择
            </el-button
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
  import {listCompany, findAreaList} from '../../../api/dictionary/company.js';

  export default {
    name: 'seleccompanyList',
    props: {
      objId: {
        type: String,
        default: '',
      },
      companyType: {
        type: String,
        default: ''
      },
    },
    data() {
      return {
        show: false,
        desc: '选择项目对话框',
        title: '',
        dialogVisible: true,
        companyList: [],
        selectItem: '',
        // companyType:{companyType:2},
        // 显示搜索条件
        showSearch: true,
        // 总条数
        total: 0,
        // 查询参数
        queryParams: {
          pageNum: 1,
          pageSize: 10,
          creditCode: null,
          companyName: null,
          companyType:null,
        },
      }
    },
    created() {
      this.getList();
    },
    methods: {
      /** 选择企业 */
      submithtForm(row) {
        this.$emit('ok', row.id, row.companyName, row.openingBank, row.openingAccount, row.linkMan, row.linkPhone, row.address, row.creditCode)
        this.title = row.companyName;
        this.dialogVisible = true;
        this.open = false;
      },

      close() {
        this.$emit('ok', "", "", "", "", "", "", "", "")
        this.dialogVisible = true;
      },
      /** 查询企业信息列表 */
      getList() {
        this.loading = true;
        this.queryParams.companyType = Number(this.companyType);
        listCompany(this.queryParams).then((response) => {
          this.companyList = response.rows;
          this.total = response.total;
          this.loading = false;
        });
        findAreaList().then((response) => {
          this.field101Options = response.data;
        });
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
          companyName: null,
          provinceId: null,
          provinceName: null,
          cityId: null,
          cityName: null,
          address: null,
          linkMan: null,
          linkPhone: null,
          openingBank: null,
          openingAccount: null,
          creditCode: null,
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
