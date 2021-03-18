<template>
  <div class="app-container">

    <el-table v-loading="loading" ref="itsmDataTable" :data="contractList" @selection-change="handleSelectionChange" border >
      <!-- <el-table-column type="selection" width="55" align="center" /> -->
      <!-- <el-table-column label="备注信息" align="center" prop="id" /> -->
      <el-table-column label="项目编号" align="center" prop="projectNo" width="130"/>
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="合同编号" align="center" prop="contractNo" width="130"/>
      <el-table-column label="合同名称" align="center" prop="contractName" />
      <el-table-column label="收入类型" align="center" prop="incomeType" >
        <template v-slot="scope">
          <p v-if="scope.row.incomeType == 1">一次性</p>
          <p v-if="scope.row.incomeType == 2">分期</p>
        </template>
      </el-table-column>
      <el-table-column label="对方单位名称" align="center" prop="oppositeName" width="110"/>
      <el-table-column label="应付款金额" align="center" prop="estimateMoney" width="110">
        <template slot-scope="scope">
          {{scope.row.estimateMoney.toFixed(2) }}
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total > 0" :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize" @pagination="getList" />
  </div>

</template>

<script>
import { listContract, getContract, delContract, addContract, updateContract, exportContract, collectionAndPaymentStatistics,contractWarningList } from '@/api/contract/contractInfo';

export default {
  name: 'Contract',
  components: {
  },

  data() {
    return {
      addOrUpdateVisible:false,
      activeName: 'first',
      formData:[],
      dialogVisible: false,
      dialogVisible1: false,
      // 合同信息录入主表格数据
      contractList: [],
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
      //项目类型
      projectCategoryTypeList: [],
      //合同类别
      contractCategoryTypeList: [],
      //收入类型
      incomeTypeList: [],
      //付款方式
      payMethodList: [],
      //合同状态
      contractStatusList: [],

      contentTypeList: [],
      // 日期范围
      createTime: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        contentType: null,
        contractNo: null,
        contractName: null,
        contractCategory: null,
        status: null,
      },

      form: {
        id: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        projectCategory: null,
        projectId: null,
        projectNo: null,
        projectName: null,
        contractNo: null,
        contractName: null,
        month: null,
        contractCategory: null,
        incomeType: null,
        oppositeName: null,
        oppositeBank: null,
        oppositeBankId: null,
        oppositeContacts: null,
        oppositePhone: null,
        oppositeAddress: null,
        ourName: null,
        ourContacts: null,
        ourPhone: null,
        ourBank: null,
        ourBankId: null,
        ourAddress: null,
        endtime: null,
        contractServeStart: null,
        serviceTerm: null,
        contractServeEnd: null,
        totalMoney: null,
        taxrate: null,
        notTaxMoney: null,
        payMethod: null,
        archiveFiles: null,
        manageDeptment: null,
        manageDeptmentName: null,
        manageUser: null,
        manageUserName: null,
        originalId: null,
        status: 0,
        statusPs: null,
        contractScanningFile: null,
        contractApprovalFile: null,
        otherFiles: null,
        delFlag: null,
        remarks: null,
        ctBuContractPayinfoList: [],
        ctBuContractContentList: [],
        field101fileList:[],
        pid:null,
        ptype:null
      }
    };
  },
  created() {
    this.getList();
    //合同类别
    this.getDicts('contract_category_type').then(response => {
      this.contractCategoryTypeList = response.data;
    });
  },
  methods: {
    //合同标的额传值给第三页面的总额
    onTabClick() {
      this.$refs.payInfo.number = this.$refs.basicInfo.formData.totalMoney;
    },

    /** 查询合同信息录入主列表 */
    getList() {
      this.loading = true;
      contractWarningList(this.queryParams).then(response => {
        this.contractList = response.rows;
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
        projectCategory: null,
        projectId: null,
        projectNo: null,
        projectName: null,
        contractNo: null,
        contractName: null,
        month: null,
        contractCategory: null,
        incomeType: null,
        oppositeName: null,
        oppositeBank: null,
        oppositeBankId: null,
        oppositeContacts: null,
        oppositePhone: null,
        oppositeAddress: null,
        ourName: null,
        ourContacts: null,
        ourPhone: null,
        ourBank: null,
        ourBankId: null,
        ourAddress: null,
        endtime: null,
        contractServeStart: null,
        serviceTerm: null,
        contractServeEnd: null,
        totalMoney: null,
        taxrate: null,
        notTaxMoney: null,
        payMethod: null,
        archiveFiles: null,
        manageDeptment: null,
        manageDeptmentName: null,
        manageUser: null,
        manageUserName: null,
        originalId: null,
        status: 0,
        statusPs: null,
        contractScanningFile: null,
        contractApprovalFile: null,
        otherFiles: null,
        delFlag: null,
        remarks: null,
        ctBuContractPayinfoList: [],
        ctBuContractContentList: [],
        contentInfo:null,
        payInfo:null,

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
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有合同信息录入主数据项?', '警告', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(function() {
          return exportContract(queryParams);
        })
        .then(response => {
          this.download(response.msg);
        });
    },
  }
};
</script>
<style scoped  lang="scss">
  .el-dialog__body{
    padding: 0px 20px;
  }
</style>
