<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="合同编号" prop="contractId">
        <el-input
          v-model="queryParams.contractId"
          placeholder="请输入合同编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="付款周期编号" prop="paymentCycleId">
        <el-input
          v-model="queryParams.paymentCycleId"
          placeholder="请输入付款周期编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="收票表或发票表ID" prop="bid">
        <el-input
          v-model="queryParams.bid"
          placeholder="请输入收票表或发票表ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发票号码" prop="invoiceNo">
        <el-input
          v-model="queryParams.invoiceNo"
          placeholder="请输入发票号码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发票含税金额" prop="invoiceMoney">
        <el-input
          v-model="queryParams.invoiceMoney"
          placeholder="请输入发票含税金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发票不含税金额" prop="invoiceNomoney">
        <el-input
          v-model="queryParams.invoiceNomoney"
          placeholder="请输入发票不含税金额"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发票代码" prop="invoiceCode">
        <el-input
          v-model="queryParams.invoiceCode"
          placeholder="请输入发票代码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="发票时间" prop="invoiceTime">
        <el-date-picker clearable size="small" style="width: 200px"
          v-model="queryParams.invoiceTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择发票时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['contract:payinfoInvoice:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['contract:payinfoInvoice:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['contract:payinfoInvoice:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['contract:payinfoInvoice:export']"
        >导出</el-button>
      </el-col>
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="payinfoInvoiceList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="唯一主键" align="center" prop="id" />
      <el-table-column label="合同编号" align="center" prop="contractId" />
      <el-table-column label="付款周期编号" align="center" prop="paymentCycleId" />
      <el-table-column label="收票表或发票表ID" align="center" prop="bid" />
      <el-table-column label="发票号码" align="center" prop="invoiceNo" />
      <el-table-column label="发票含税金额" align="center" prop="invoiceMoney" />
      <el-table-column label="发票不含税金额" align="center" prop="invoiceNomoney" />
      <el-table-column label="发票代码" align="center" prop="invoiceCode" />
      <el-table-column label="发票时间" align="center" prop="invoiceTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.invoiceTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['contract:payinfoInvoice:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['contract:payinfoInvoice:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改付款周期-发票对应关系对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="合同编号" prop="contractId">
          <el-input v-model="form.contractId" placeholder="请输入合同编号" />
        </el-form-item>
        <el-form-item label="付款周期编号" prop="paymentCycleId">
          <el-input v-model="form.paymentCycleId" placeholder="请输入付款周期编号" />
        </el-form-item>
        <el-form-item label="收票表或发票表ID" prop="bid">
          <el-input v-model="form.bid" placeholder="请输入收票表或发票表ID" />
        </el-form-item>
        <el-form-item label="发票号码" prop="invoiceNo">
          <el-input v-model="form.invoiceNo" placeholder="请输入发票号码" />
        </el-form-item>
        <el-form-item label="发票含税金额" prop="invoiceMoney">
          <el-input v-model="form.invoiceMoney" placeholder="请输入发票含税金额" />
        </el-form-item>
        <el-form-item label="发票不含税金额" prop="invoiceNomoney">
          <el-input v-model="form.invoiceNomoney" placeholder="请输入发票不含税金额" />
        </el-form-item>
        <el-form-item label="发票代码" prop="invoiceCode">
          <el-input v-model="form.invoiceCode" placeholder="请输入发票代码" />
        </el-form-item>
        <el-form-item label="发票时间" prop="invoiceTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.invoiceTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择发票时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPayinfoInvoice, getPayinfoInvoice, delPayinfoInvoice, addPayinfoInvoice, updatePayinfoInvoice, exportPayinfoInvoice } from "@/api/contract/payinfoInvoice";

export default {
  name: "PayinfoInvoice",
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
      // 付款周期-发票对应关系表格数据
      payinfoInvoiceList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contractId: null,
        paymentCycleId: null,
        bid: null,
        invoiceNo: null,
        invoiceMoney: null,
        invoiceNomoney: null,
        invoiceCode: null,
        invoiceTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询付款周期-发票对应关系列表 */
    getList() {
      this.loading = true;
      listPayinfoInvoice(this.queryParams).then(response => {
        this.payinfoInvoiceList = response.rows;
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
        contractId: null,
        paymentCycleId: null,
        bid: null,
        invoiceNo: null,
        invoiceMoney: null,
        invoiceNomoney: null,
        invoiceCode: null,
        invoiceTime: null,
        delFlag: null,
        remark: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
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
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加付款周期-发票对应关系";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPayinfoInvoice(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改付款周期-发票对应关系";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updatePayinfoInvoice(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPayinfoInvoice(this.form).then(response => {
              this.msgSuccess("新增成功");
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
      this.$confirm('是否确认删除付款周期-发票对应关系编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delPayinfoInvoice(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有付款周期-发票对应关系数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportPayinfoInvoice(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
