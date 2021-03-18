<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" label-width="90px">
      <el-row :gutter="15">
        <el-col :span="6">
          <el-form-item label="合同编号" prop="contractId">
            <el-input v-model="queryParams.contractId" placeholder="请输入合同编号" clearable size="small" @keyup.enter.native="handleQuery" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="项目类型" prop="contentType">
            <el-select v-model="queryParams.contentType" placeholder="请选择项目类型" clearable size="small">
              <el-option v-for="dict in contentTypeList" :key="dict.dictValue" :label="dict.dictLabel" :value="dict.dictValue" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="类型名称" prop="contentName">
            <el-input v-model="queryParams.contentName" placeholder="请输入类型名称" clearable size="small" @keyup.enter.native="handleQuery" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item>
           <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
           <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-col>
        <!-- <el-form-item label="类型税率" prop="contentTaxrate">
          <el-input
            v-model="queryParams.contentTaxrate"
            placeholder="请输入类型税率"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item> -->

        <!-- <el-form-item label="含税金额" prop="intaxAmount">
          <el-input
            v-model="queryParams.intaxAmount"
            placeholder="请输入含税金额"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item> -->
        <!-- <el-form-item label="不含税金额" prop="extaxAmount">
          <el-input
            v-model="queryParams.extaxAmount"
            placeholder="请输入不含税金额"
            clearable
            size="small"
            @keyup.enter.native="handleQuery"
          />
        </el-form-item> -->
      </el-row>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['dictionary:contractContent:add']"
        >新增</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button type="success" icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate" v-hasPermi="['contract:contractContent:edit']">修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="danger" icon="el-icon-delete" size="mini" :disabled="multiple" @click="handleDelete" v-hasPermi="['contract:contractContent:remove']">删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button type="warning" icon="el-icon-download" size="mini" @click="handleExport" v-hasPermi="['contract:contractContent:export']">导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="contractContentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <!-- <el-table-column label="不含税金额" align="center" prop="id" /> -->
      <el-table-column label="合同编号" align="center" prop="contractId" />
      <el-table-column label="项目类型" align="center" prop="contentType" />
      <el-table-column label="类型税率" align="center" prop="contentTaxrate" />
      <el-table-column label="类型名称" align="center" prop="contentName" />
      <el-table-column label="含税金额" align="center" prop="intaxAmount" />
      <el-table-column label="不含税金额" align="center" prop="extaxAmount" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button size="mini" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)" v-hasPermi="['contract:contractContent:edit']">修改</el-button>
          <el-button size="mini" type="text" icon="el-icon-delete" @click="handleDelete(scope.row)" v-hasPermi="['contract:contractContent:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize" @pagination="getList" />

    <!-- 添加或修改合同内容对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="合同编号" prop="contractId"><el-input v-model="form.contractId" placeholder="请输入合同编号" /></el-form-item>
        <el-form-item label="项目类型" prop="contentType">
          <el-select v-model="form.contentType" placeholder="请选择项目类型"><el-option label="请选择字典生成" value="" /></el-select>
        </el-form-item>
        <el-form-item label="类型税率" prop="contentTaxrate"><el-input v-model="form.contentTaxrate" placeholder="请输入类型税率" /></el-form-item>
        <el-form-item label="类型名称" prop="contentName"><el-input v-model="form.contentName" placeholder="请输入类型名称" /></el-form-item>
        <el-form-item label="含税金额" prop="intaxAmount"><el-input v-model="form.intaxAmount" placeholder="请输入含税金额" /></el-form-item>
        <el-form-item label="不含税金额" prop="extaxAmount"><el-input v-model="form.extaxAmount" placeholder="请输入不含税金额" /></el-form-item>
        <el-form-item label="删除标志" prop="delFlag"><el-input v-model="form.delFlag" placeholder="请输入删除标志" /></el-form-item>
        <el-form-item label="备注" prop="remark"><el-input v-model="form.remark" type="textarea" placeholder="请输入内容" /></el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listContractContent, getContractContent, delContractContent, addContractContent, updateContractContent, exportContractContent } from '@/api/contract/contractContent';

export default {
  name: 'ContractContent',
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 合同内容表格数据
      contractContentList: [],
      contentTypeList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contractId: null,
        contentType: null,
        contentTaxrate: null,
        contentName: null,
        intaxAmount: null,
        extaxAmount: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
    this.getDicts('content_type').then(response => {
      this.contentTypeList = response.data;
    });
  },
  methods: {
    /** 查询合同内容列表 */
    getList() {
      this.loading = true;
      listContractContent(this.queryParams).then(response => {
        this.contractContentList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
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
        contractId: null,
        contentType: null,
        contentTaxrate: null,
        contentName: null,
        intaxAmount: null,
        extaxAmount: null,
        delFlag: null,
        remark: null
      };
      this.resetForm('form');
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm');
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id);
      this.single = selection.length !== 1;
      this.multiple = !selection.length;
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = '添加合同内容';
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getContractContent(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = '修改合同内容';
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs['form'].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateContractContent(this.form).then(response => {
              this.msgSuccess('修改成功');
              this.open = false;
              this.getList();
            });
          } else {
            addContractContent(this.form).then(response => {
              this.msgSuccess('新增成功');
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除合同内容编号为"' + ids + '"的数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(function() {
          return delContractContent(ids);
        })
        .then(() => {
          this.getList();
          this.msgSuccess('删除成功');
        });
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有合同内容数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(function() {
          return exportContractContent(queryParams);
        })
        .then(response => {
          this.download(response.msg);
        });
    }
  }
};
</script>
