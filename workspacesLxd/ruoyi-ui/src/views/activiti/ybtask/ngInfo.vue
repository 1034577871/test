<template>
  <div>
    <el-dialog title="集客项目立项详情" :visible.sync="modalShow" width="80%" :before-close="modalClose">
    <el-row :gutter="15">

        <el-form ref="form" :model="form"  label-width="80px">

          <el-tabs v-model="activeName" v-if="ngAudit">
            <el-tab-pane label="基本信息" name="base" prop="appNgBase">
              <basicInfo
                ref="basicInfo"
                :baseInfoDate="form.appNgBase"
              ></basicInfo>
            </el-tab-pane>
            <el-tab-pane label="材料信息" name="second" prop="appNgMaterialList"
              ><materialsInfo
                ref="materialsInfo"
                :materialsInfoDate="form.appNgMaterialList"
              ></materialsInfo
            ></el-tab-pane>
            <el-tab-pane label="施工费信息" name="third" prop="appNgConstList"
              ><construcostInfo
                ref="construcostInfo"
                :construcostInfoDate="form.appNgConstList"
              ></construcostInfo
            ></el-tab-pane>
            <el-tab-pane label="事前审批表" name="fourth" prop="appxNgReq"
              ><approvalInfo
                ref="approvalInfo"
                :approvalInfoDate="form.appxNgReq"
              ></approvalInfo
            ></el-tab-pane>
          </el-tabs>


	      </el-form>
         </el-row>
  <el-row :gutter="15">
    <el-col :span="24" >
      <el-divider content-position="center" ><el-link type="primary"><b>审核信息</b></el-link></el-divider>
    </el-col>
  </el-row>

  <el-row :gutter="15">
    <el-table :data="tableData">
      <el-table-column label="任务节点" prop="taskNodeName" header-align="center" align="center">
      </el-table-column>
      <el-table-column label="审批人" prop="createName" header-align="center" align="center">
      </el-table-column>
      <el-table-column label="审批意见" prop="controlValue" header-align="center" align="center">
      </el-table-column>
      <el-table-column label="审批时间" prop="createTime"   header-align="center" align="center">
      </el-table-column>
    </el-table>
  </el-row>
</el-dialog>
</div>
</template>

<script>
  import { getLeave } from '@/api/workflow/leave'
  import { getNgcAudit ,historyFromData,getCollectionAudit } from '@/api/activiti/historyFormdata'
  import basicInfo from "../task/nginfo/basicInfo.vue";
  import materialsInfo from "../task/nginfo/materialsInfo.vue";
  import construcostInfo from "../task/nginfo/construcostInfo.vue";
  import approvalInfo from "../task/nginfo/approvalInfo";
  import {getCollectProject} from "@/api/projectApproval/collectProject";
  export default {
    name: "leaveHistoryForm",
    components: {
      basicInfo,materialsInfo,construcostInfo,approvalInfo},
    props: {
      businessKey: {
        type: String
      }
    },
    data(){
      return{
        ngAudit:false,
        modalShow:false,
        tableData:[],
        show:false,
        // 表单参数
        // 表单参数
        form: {
          formData:[]
        },
        invoiceDataList:[], //开票信息
        fromData:[],
      }
    },
    created() {
      // this.getLeave()
      // this.historyFromData()
    },
    methods:{
       init(row) {
          this.tableData=[];
        //添加表单
        
        this.$nextTick(() =>{
          getCollectProject(row.businessKey).then(response1 => {
             this.tableData = response1.data.actWorkflowFormDatas;
            /** 基本信息赋值 **/
            this.$refs.basicInfo.formData = response1.data.appNgBase;
            this.$refs.basicInfo.formData.projectTypeId =
              response1.data.appNgBase.projectTypeId + "";
            /** 材料信息 **/
            this.$refs.materialsInfo.dataList = response1.data.appNgMaterialList;
            /** 施工费信息 **/
            this.$refs.construcostInfo.dataList = response1.data.appNgConstList;
            if (response1.data.appxNgReq.dataList) {
              this.$refs.approvalInfo.rowspanNum =
                13 + response1.data.appxNgReq.dataList.length;
            }
            /** 事前审批 **/
            this.$refs.approvalInfo.formData = response1.data.appxNgReq;
          });
        })
        
        
        



      },
      modalClose(){
          this.modalShow = false;
      },
      historyFromData() {
        historyFromData(this.businessKey).then(response => {
          this.fromData = response.data
        })
      },
    }

  }
</script>

<style scoped lang="scss">
  .input-noborder ::v-deep {
    .el-input__inner {
      border: 0;
      background-color: #f8f8f9;
    }
  }
  .el-alert  ::v-deep {
    .el-alert__content {
      width: 100%;
    }
  }
  .box-card {
    width: 50%;
  }
  .in-text {
    display:inline-block;width: 50%;
    font-size: 14px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

</style>
