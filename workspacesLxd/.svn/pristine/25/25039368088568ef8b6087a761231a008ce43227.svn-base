<template>
  <el-form
        ref="elForm"
        :model="formData"
        size="medium"
        label-width="120px"
        :rules="rules"
      >
    <el-row :gutter="15">
      <el-col :span="12">
        <el-form-item label="项目名称" prop="proName">
          <el-input v-model="formData.id" placeholder="请输入项目名称" v-if="show"/>
          <el-input v-model="formData.status" placeholder="请输入项目名称" v-if="show"/>
          <el-input v-model="formData.proName" placeholder="请输入项目名称" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="预计投资金额" prop="expectAmount" >
          <el-input
            v-model="formData.expectAmount"
            clearable
            placeholder="请输入预计投资金额"
            oninput="value=value.replace(/[^0-9.]/g,'')"
          />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="规划部是否确认" prop="isPlanConfirm">
            <el-select
              v-model="formData.isPlanConfirm"
              placeholder="请选择"
              style="width: 100%;"
              @change="selectChanged"
            >
              <el-option
                v-for="dict in isPlanConfirmList"
                :key="dict.dictValue"
                :label="dict.dictLabel"
                :value="dict.dictValue"
              />
            </el-select>
          </el-form-item>
        </el-col>

        <el-col :span="12">
          <el-form-item label="企业是否垫资" prop="isAdvanceNeed">
              <el-select
                v-model="formData.isAdvanceNeed"
                placeholder="请选择"
                style="width: 100%;"
                @change="selectChangedNeed"
              >
                <el-option
                  v-for="dict in isAdvanceNeedList"
                  :key="dict.dictValue"
                  :label="dict.dictLabel"
                  :value="dict.dictValue"
                />
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="涉及分公司"  prop="selectComp">
              <el-select
                v-model="formData.selectComp"
                multiple
                placeholder="请选择"
                :style="{ width: '100%' }"
              >
                <el-option
                  v-for="dict in belongCompanyNameList"
                  :key="dict.deptId"
                  :label="dict.deptName"
                  :value="dict.deptId"
                />
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="项目描述" prop="projectDescription">
            <el-input
              type="textarea"
              :rows="3"
              placeholder="请输入内容"
              v-model="formData.projectDescription">
            </el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="项目效益说明" prop="benefitDescription">
            <el-input
              type="textarea"
              :rows="3"
              placeholder="请输入内容"
              v-model="formData.benefitDescription">
            </el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row :gutter="15" v-if="showInfo">
          <el-col :span="12">
              <el-form-item label="事前审批表" prop="isPlanConfirm">
                <el-button type="primary" size="small" plain @click="showApprovalInfo()">在线填写</el-button>
              </el-form-item>
          </el-col>
        </el-row>



    <el-dialog
      title="新增立项"
      :visible.sync="newProjectVisible"
      width="80%"
      @close=""
    >
      <newProject ref="newProject" :obj="elForm"></newProject>


      <div slot="footer" class="dialog-footer" >
        <el-button type="success" @click="submitForm_(0)">保 存</el-button>
        <el-button type="success" @click="submitForm_(1)">提 交</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


    </el-form>





</template>

<script>
  import {
    findBranchOffice
  } from "@/api/utils";

  import newProject from  "./newProjectAdd";
export default {
  name: "CollectProject",
  components: {
    newProject
  },
  data() {
    return {
      show:false,
      showInfo:false,
      belongCompanyNameList:[],
      isAdvanceNeedList:[],
      isPlanConfirmList:[],
      newProjectVisible:false,  //立项新增窗口
      formData: {
        id:null,
        status:null,
        proName:"",
        expectAmount:null,
        isPlanConfirm:null,
        isAdvanceNeed:null,
        selectComp:null,
        projectDescription:"",
        benefitDescription:"",
        newProject:null,
      },

      rules:{
        proName: [{ required: true, message: '项目名称不能为空', trigger: 'blur' }],
        expectAmount: [{ required: true, message: '投资金额不能为空', trigger: 'blur' }],
        isPlanConfirm: [{ required: true, message: '请选择是否规划部确认', trigger: 'blur' }],
        isAdvanceNeed: [{ required: true, message: '请选择企业是否垫资', trigger: 'blur' }],
        selectComp: [{ required: true, message: '请选择涉及分公司', trigger: 'blur' }],
      },

    }
  },
  created() {
    this.getDicts("sys_yes_no").then(response => {
      this.isPlanConfirmList = response.data;
      this.isAdvanceNeedList  = response.data;
    });
    findBranchOffice().then(response => {
      this.belongCompanyNameList = response.data;
    });

    if (!this.formData) {
      this.formData = {
        id:null,
        proName: null,
        status:null,
        companyCharge: "",
        departCharge: "",
        proCharge: "",
        projectTypeId: "",
        buildingsNumber: 0,
        buildingsInvolvedNumber: 0,
        digitaltvNumber: 0,
        broadbandNumber: 0,
        budgetMaterial: 0,
        budgetLabor: 0,
        budgetTotal: 0,
        designTime: ""
      };
    } else {
      this.formData.projectTypeId = this.formData.projectTypeId + "";
    }
  },
  methods: {
    validateForm() {
      let flag = false
      this.$refs['elForm'].validate((valid) => {
        flag = valid
      })
      return flag
    },
    //在线填写
    showApprovalInfo(){
      this.newProjectVisible =  true;
    },
    selectChanged(val){
      let amount = this.formData.expectAmount==null?0:this.formData.expectAmount;
      if(this.formData.isAdvanceNeed=='Y' && val=='Y'){
        this.showInfo = false;
      }else{
        this.showInfo = true;
      }
    },
    selectChangedNeed(val){
      let amount = this.formData.expectAmount==null?0:this.formData.expectAmount;

      if(val=='Y' && this.formData.isPlanConfirm=='Y'){
        this.showInfo = false;
      }else{
        this.showInfo = true;
      }
    },
  }
}
</script>
