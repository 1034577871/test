<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" v-show="showSearch" label-width="90px">
      <el-row :gutter="15">

               <el-col :span="6">
                 <el-form-item label="项目名称" prop="proName">
                   <el-input
                     v-model="queryParams.proName"
                     placeholder="请输入项目名称"
                     clearable
                     size="small"
                     @keyup.enter.native="handleQuery"
                   />
                 </el-form-item>
               </el-col>

               <el-col :span="6">
                 <el-form-item label="合同名称" prop="contractName">
                   <el-input
                     v-model="queryParams.contractName"
                     placeholder="请输入合同名称"
                     clearable
                     size="small"
                     @keyup.enter.native="handleQuery"
                   />
                 </el-form-item>
               </el-col>
               <el-col :span="6">
                 <el-form-item label="发票代码" prop="invoiceCode">
                   <el-input
                     v-model="queryParams.invoiceCode"
                     placeholder="请输入发票代码"
                     clearable
                     size="small"
                     @keyup.enter.native="handleQuery"
                   />
                 </el-form-item>
               </el-col>
               <el-col :span="6">
                 <el-form-item label="发票号码" prop="invoiceNo">
                   <el-input
                     v-model="queryParams.invoiceNo"
                     placeholder="请输入发票号码"
                     clearable
                     size="small"
                     @keyup.enter.native="handleQuery"
                   />
                 </el-form-item>
               </el-col>
      </el-row>
      <el-row :gutter="15">

        <el-col :span="6">
          <el-form-item label="单据编号" prop="documentNumber">
            <el-input
              v-model="queryParams.documentNumber"
              placeholder="请输入单据编号"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"
            />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="回款方式" prop="paymentMethod">

            <el-select :style="{ width: '100%' }"
              v-model="queryParams.paymentMethod"
              placeholder="回款方式"
            >
              <el-option
                v-for="dict in collectMethodList"
                :key="dict.dictValue"
                :label="dict.dictLabel"
                :value="dict.dictValue"
              />
            </el-select>

           <!-- <el-input
              v-model="queryParams.paymentMethod"
              placeholder="请输入回款方式"
              clearable
              size="small"
              @keyup.enter.native="handleQuery"
            /> -->
          </el-form-item>
        </el-col>
        <el-col :span="6" >
          <el-form-item>
            <el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
            <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-col>
      </el-row>

    </el-form>

    <el-row :gutter="10" class="mb8">
      <!-- <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['collection:receiptInfo:add']"
        >新增</el-button>
      </el-col> -->
     <!-- <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['collection:receiptInfo:edit']"
        >添加</el-button>
      </el-col> -->
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"

        >发票核销</el-button>
      </el-col>
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="warning"-->
<!--          icon="el-icon-download"-->
<!--          size="mini"-->
<!--          @click="handleExport"-->
<!--          v-hasPermi="['collection:receiptInfo:export']"-->
<!--        >导出</el-button>-->
<!--      </el-col>-->
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" ref="financialList"  :data="financialList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id"v-if="show" />
      <el-table-column label="主键" align="center" prop="invoiceId"v-if="show" />

     <el-table-column label="项目名称" align="center" prop="proName" />
     <el-table-column label="合同名称" align="center" prop="contractName" />

      <el-table-column label="发票代码" align="center" prop="invoiceCode" />
      <el-table-column label="发票号码" align="center" prop="invoiceNo" />
       <el-table-column label="单据编号" align="center" prop="documentNumber" />
      <el-table-column label="回款方式" align="center" prop="paymentMethod" >


        <template slot-scope="s">
         <p v-if="s.row.paymentMethod == 1">现金</p >
         <p v-if="s.row.paymentMethod == 2">电汇</p >
         <p v-if="s.row.paymentMethod == 3">银行转账</p >
        </template>
       </el-table-column>
      <el-table-column label="回款金额" align="center" prop="collectionAmount" />
        <el-table-column label="状态">
             <template slot-scope="s">
              <p v-if="s.row.statuss == 0">保存</p >
              <p v-if="s.row.statuss == 1">发票生成</p >
              <p v-if="s.row.statuss == 2">发票移交</p >
              <p v-if="s.row.statuss == 3">发票移交确认</p >
              <p v-if="s.row.statuss == 4">凭证号录入</p >
              <p v-if="s.row.statuss == 5">收款单录入</p >
              <p v-if="s.row.statuss == 6">收款单审核通过</p >
              <p v-if="s.row.statuss == 7">收款单审核不通过</p >
              <p v-if="s.row.statuss == 8">发票核销</p >
             </template>
             </el-table-column>

      <!-- <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['collection:receiptInfo:remove']"
          >发票核销</el-button>
        </template>
      </el-table-column> -->
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改收款单录入对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="60%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-col :span="8">
          <el-form-item label="项目类型" prop="approvalId">
            <el-select v-model="form.approvalId" placeholder="请选择项目类型" style="width: 100%;">
              <el-option
                v-for="dict in projectCategoryTypeList"
                :key="dict.dictValue"
                :label="dict.dictLabel"
                :value="dict.dictValue"
              />
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="8">

          <el-form-item label="项目编号" prop="proNo">
            <el-input v-model="form.proNo" :readonly="true"  />
          </el-form-item>
         </el-col>
         <el-col :span="8">
          <el-form-item label="项目名称" prop="proName">
            <el-input v-model="form.proName"  :readonly="true"    placeholder="请输入项目名称"  />
          </el-form-item>
        </el-col>

         <el-col :span="8">
           <el-form-item label="事前审批表ID 关联事前审批表ID" prop="approvalId" v-if="show">
              <el-input v-model="form.contractId" placeholder="" />
           </el-form-item>
          <el-form-item label="合同编号"     prop="contractNo">
              <el-input v-model="form.contractNo" :readonly="true"  placeholder="请输入合同编号" />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item
        label="合同名称"    prop="contractName">
            <el-input v-model="form.contractName" :readonly="true"  placeholder="请输入合同名称" />
          </el-form-item>
        </el-col>
        <el-form-item label="发票ID" prop="invoiceId"  v-if="show">
          <el-input v-model="form.invoiceId" placeholder="请输入发票ID" />
        </el-form-item>
         <el-col :span="8">
          <el-form-item label="发票代码" prop="invoiceCode">
            <el-input v-model="form.invoiceCode" placeholder="请输入发票代码" />
          </el-form-item>
         </el-col>
         <el-col :span="8">
          <el-form-item label="发票号码" prop="invoiceNo">
            <el-input v-model="form.invoiceNo" placeholder="请输入发票号码" />
          </el-form-item>
         </el-col>
         <el-col :span="8">
          <el-form-item label="回款时间" prop="collectionTime">
            <el-date-picker clearable size="small" :style="{ width: '100%' }"
              v-model="form.collectionTime"
              type="date"
              value-format="yyyy-MM-dd"
              placeholder="选择回款时间">
            </el-date-picker>
          </el-form-item>
         </el-col>
         <el-col :span="8">
          <el-form-item label="回款金额" prop="collectionAmount">
            <el-input v-model="form.collectionAmount" placeholder="请输入回款金额" />
          </el-form-item>
         </el-col>
         <el-col :span="8">
          <el-form-item label="单据编号" prop="documentNumber">
            <el-input v-model="form.documentNumber" placeholder="请输入单据编号" />
          </el-form-item>
         </el-col>
          <el-col :span="8">
          <el-form-item label="回款方式" prop="paymentMethod">
            <el-input v-model="form.paymentMethod" placeholder="请输入回款方式" />

          </el-form-item>
         </el-col>
        <el-form-item label="状态" v-if="show">
          <el-radio-group v-model="form.status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="状态说明" prop="statusps"  v-if="show">
          <el-input v-model="form.statusps" placeholder="请输入状态说明" />
        </el-form-item>
        <el-form-item label="删除标志" prop="delFlag"  v-if="show">
          <el-input v-model="form.delFlag" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="备注" prop="remark"  v-if="show">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
<!--         <el-col :span="8">-->
<!--          <el-form-item label="银行单据" prop="remark">-->
<!--            <el-upload-->
<!--              name = "form.voucher"-->
<!--              class="upload-demo"-->
<!--              action="https://jsonplaceholder.typicode.com/posts/"-->
<!--              :on-preview="handlePreview"-->
<!--              :on-remove="handleRemove"-->
<!--              :before-remove="beforeRemove"-->
<!--              multiple-->
<!--              :limit="3"-->
<!--              :on-exceed="handleExceed"-->
<!--              :file-list="fileList">-->
<!--              <el-button size="small" type="primary">点击上传</el-button>-->
<!--              <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>-->
<!--            </el-upload>-->
<!--          </el-form-item>-->
<!--</el-col>-->

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm(0)">保 存</el-button>
        <el-button type="primary" @click="submitForm(1)">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFinancialList ,moveFinancial_,listReceiptInfo, getReceiptInfo, delReceiptInfo, addReceiptInfo, updateReceiptInfo, exportReceiptInfo } from "@/api/collection/fphx";
import { listApplyCollection,detailNgcApproval,findContract,detailhtCon,getUserInfo  } from "@/api/collection/common";

export default {
  name: "ReceiptInfo",
  data() {
    return {
      statusList :[],
       collectMethodList:[],
      // 财务开票表格数据
      financialList: [],
       projectCategoryTypeList:[],
      show: false,
      innerVisible: false,
      innerhtVisible: false,
      loadings:false,
      // 遮罩层
      loading: true,
      // 项目信息列表
      projectList: [],
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
       innerhtVisible: false,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 收款单录入表格数据
      receiptInfoList: [],
      contractList:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
       htloading:true,
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        approvalId: null,
        proNo: null,
        proName: null,
        contractId: null,
        contractNo: null,
        contractName: null,
        invoiceId: null,
        invoiceCode: null,
        invoiceNo: null,
        collectionTime: null,
        collectionAmount: null,
        documentNumber: null,
        paymentMethod: null,
        voucher: null,
        status: null,
        statusps: null,

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
    //项目类型列表
    this.getDicts("project_category_type").then((response) => {
      console.log("************************************");
      this.approvalTypeOptions = response.data;
      this.projectCategoryTypeList = response.data;
    });
    //项目类型列表
    this.getDicts("collection_method_type").then((response) => {
      console.log("************************************");
      this.collectMethodList = response.data;
    });
  },
  methods: {
    handleRemove(file, fileList) {
            console.log(file, fileList);
          },
          handlePreview(file) {
            console.log(file);
          },
          handleExceed(files, fileList) {
            this.$message.warning(`当前限制选择 3 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
          },
          beforeRemove(file, fileList) {
            return this.$confirm(`确定移除 ${ file.name }？`);
          },

// 多选框选中数据
    handleXmSelectionChange(val) {
       this.ids = val.map(item => item.id)
        this.statusList = val.map(item => item.statuss)
       if (val.length > 1) {
       		this.$refs.Table.clearSelection()
       		this.$refs.Table.toggleRowSelection(val.pop())
       	} else {
       	}

    },
  /** 搜索按钮操作 */
    handlesQuery() {
      this.queryParams.pageNum = 1;
      this.getApplyList();
    },
    /** 搜索按钮操作 */
    handlehtQuery() {
      this.queryParams.pageNum = 1;
      this.getContractList();
    },
//获取项目信息
    getApplyList() {
      this.projectList = [];
      this.loadings = true;
      this.innerVisible = true;
      this.queryParams.pageNum = 1;
      this.apptype=this.form.approvalId;
    //  this.queryParams.approvalType = this.form.approvalType;
      listApplyCollection(this.form.approvalId,this.addDateRange(this.queryParams, this.dateRange)).then(response => {
         this.total = response.total;
         if(this.total==0){
           this.projectList = [];
         }else{
           this.projectList = response.rows;
         }


        this.loadings = false;

        this.innerVisible = true;
          this.title = "修改发票申请";
          this.apptype=this.form.approvalId;
      });
    },
    //获取合同信息
    getContractList() {
      this.htloading = true;
      this.innerhtVisible = true;
      this.queryParams.projectId = (this.form.approvalId);
      findContract(this.addDateRange(this.queryParams, this.dateRange)).then(response => {
        this.contractList = response.rows;
        this.total = response.total;
        this.htloading = false;
         this.innerhtVisible = true;
      });
    },
    /** 查询收款单录入列表 */
    getList() {
      this.loading = true;
      this.queryParams.status = 2;
      this.queryParams.createBy = '';
      this.queryParams.del_flag = "";
      listFinancialList(this.queryParams).then(response => {
        console.log(response.rows);
        this.financialList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
      // this.loading = true;
      // listReceiptInfo(this.queryParams).then(response => {
      //   this.receiptInfoList = response.rows;
      //   this.total = response.total;
      //   this.loading = false;
      // });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    cancelAppri() {
      this.innerVisible = false;
      this.form.reqNo = null;
      this.form.proName = null;
    },
    /** 修改按钮操作 */
    submitsForm(row) {
      const id = row.id || this.ids;
      detailNgcApproval(this.apptype,id).then(response => {
       this.form.approvalId=id;
       this.form.proNo=response.data.reqNo;
       this.form.proName=response.data.proName;
       this.innerVisible = false;
      });
    },
    /** 选择合同 */
    submithtForm(row) {
      const id = row.id || this.ids;
      detailhtCon(id).then(response => {
        this.taxrate = response.data.taxrate;
       this.form.contractId=id;
       this.form.contractNo=response.data.contractNo;
       this.form.contractName=response.data.contractName;
       this.innerhtVisible = false;
      });


    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        approvalId: null,
        proNo: null,
        proName: null,
        contractId: null,
        contractNo: null,
        contractName: null,
        invoiceId: null,
        invoiceCode: null,
        invoiceNo: null,
        collectionTime: null,
        collectionAmount: null,
        documentNumber: null,
        paymentMethod: null,
        voucher: null,
        status: 0,
        statusps: null,
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
       this.statusList = selection.map(item => item.statuss)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加收款单录入";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      let id = row.id || this.ids
      let approvalId_ = '';
      let proName_ ='';
      let proNo_ = '';
      let contractId_ = '';
      let contractNo_='';
      let contractName_='';
      let invoiceId_='';
      let invoiceCode_='';
      let invoiceNo_='';
      if(id==''){
        const _selectData = this.$refs.financialList.selection;
        if(_selectData==''){
           this.msgSuccess("请选择记录");
           return false;
        }

        this.queryParams.status = 1;
        this.queryParams.id_ = _selectData[0].ctBuInvoiceReqVo.id_;
        listFinancialList(this.queryParams).then(response => {
          this.form.approvalId = response.rows[0].ctBuInvoiceReqVo.approvalId_;
          this.form.proNo = response.rows[0].ctBuInvoiceReqVo.proNo_;
          this.form.proName = response.rows[0].ctBuInvoiceReqVo.proName_;
          this.form.contractId = response.rows[0].ctBuInvoiceReqVo.contractId_;
          this.form.contractNo = response.rows[0].ctBuInvoiceReqVo.contractNo_;
          this.form.contractName = response.rows[0].ctBuInvoiceReqVo.contractName_;
          this.form.invoiceId = response.rows[0].ctBuInvoiceReqVo.id_;
          this.form.invoiceCode = response.rows[0].ctBuInvoiceInfoVo.invoiceCodes;
          this.form.invoiceNo =response.rows[0].ctBuInvoiceInfoVo.invoiceNos;
          this.open = true;
          this.title = "收款单录入";

        });
      }else{
        getReceiptInfo(id).then(response => {
          this.form = response.data;
          this.open = true;
          this.title = "收款单录入";
        });
      }

    },
    /** 提交按钮 */
    submitForm(val) {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.status=val;
          if (this.form.id != null) {
            updateReceiptInfo(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReceiptInfo(this.form).then(response => {
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

        let ids = "";
        const _selectData = this.$refs.financialList.selection;
        if(_selectData!='' && _selectData.length>0){
          const state = 0;
          for(let item of _selectData) {
            ids += item.invoiceId+",";
          }
        }
        if(ids!=''){
          ids = ids.substring(0,ids.length);
        }
        if(this.statusList!=null){
          for(let item of this.statusList){
            if(item==8){
               this.msgSuccess("发票已核销，请选择其他记录");
               return false;
            }
          }
        }
      this.$confirm('是否确认核销选中的数据?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return moveFinancial_(ids,"100");
        }).then(() => {
          this.getList();
          this.msgSuccess("核销成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有收款单录入数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportReceiptInfo(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
