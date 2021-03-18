<template>
  <div style="padding: 0 15px;">
    <h2 style="text-align: center;color:#3388ee;">集客项目事前审批表</h2>

    <el-row :gutter="15">
      <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px">
        <table class="table table-bordered" style="text-align: center;width: 100%;vertical-align:middle;">
        	<tbody>
        		<tr>
        			<td colspan="2" width="10%" style="text-align: right;"><span class="labelX">申请公司</span></td>
        			<td colspan="2" width="30%">
        				{{formData.applycompany}}
        			</td>
        			<td colspan="3" width="30%" style="text-align: right;"><span class="labelX">审批编号</span></td>
        			<td colspan="2" width="30%">
        				{{formData.approvalno}}
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2" style="text-align: right;"><span class="labelX">项目名称</span></td>
        			<td colspan="7" style="text-align: left;">
        				<el-input v-model="formData.projectName" placeholder="请输入项目名称" style="border: none;"></el-input>
        			</td>
        		</tr>

        		<tr>
        			<td colspan="2" style="text-align: right;"><span class="labelX">项目类别</span></td>
        			<td colspan="2">
                <el-select v-model="formData.projectTypeId" placeholder="请选择" clearable >
                	<el-option v-for="(item, index) in projectTypeOptions" :key="index" :label="item.label" :value="item.value" :disabled="item.disabled"></el-option>
                </el-select>
        			</td>
        			<td colspan="3" style="text-align: right;"><span class="labelX">申请日期</span></td>
        			<td colspan="2">
                {{formData.applydate}}
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2" rowspan="10" >
        				<span class="labelX title" style="color: #1AA034;">项<br>目<br>收<br>入</span>
        			</td>
        		</tr>
        		<tr style="background-color:#eff3fa">
        			<td width="20%"><span class="labelX">项目名称</span></td>
        			<td width="10%"><span class="labelX">合同金额(元)</span></td>
        			<td width="10%"><span class="labelX">税率(%)</span></td>
        			<td width="10%"><span class="labelX">不含税金额(元)</span></td>
        			<td width="10%"><span class="labelX">销项税额(元)</span></td>
        			<td colspan="2"><span class="labelX">备注</span></td>
        		</tr>
        		<tr>
        			<td><span class="labelX">传输收入</span></td>
        			<td>
        					<el-input v-model="formData.tranrevenue" ></el-input>
        			</td>
        			<td>
        					<el-input v-model="formData.trantaxrate" ></el-input>
        			</td>
        			<td>
        					<el-input v-model="formData.tranrevenueno" :disabled="true"></el-input>
        			</td>
        			<td>
        					<el-input v-model="formData.tranoutput" :disabled="true"></el-input>
        			</td>
        			<td>
        					<el-input type="textarea" v-model="formData.tranremarks"></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">设备收入</span></td>
        			<td>
        				<el-input v-model="formData.devicerevenue" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.devicetaxrate" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.devicerevenueno" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.deviceoutput" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.deviceremarks"></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">技术服务收入</span></td>
        			<td>
        				<el-input v-model="formData.serverevenue" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.servetaxrate" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.serverevenueno" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.serveoutput" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.serveremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">工程收入</span></td>
        			<td>
        				<el-input v-model="formData.projectrevenue" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.projecttaxrate" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.projectrevenueno" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.projectoutput" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.projectremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">租赁收入</span></td>
        			<td>
        				<el-input v-model="formData.leaserevenue" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.leasetaxrate" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.leaserevenueno" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.leaseoutput" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.leaseremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">软件收入</span></td>
        			<td>
        				<el-input v-model="formData.softwarerevenue" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.softwaretaxrate" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.softwarerevenueno" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.softwareoutput" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.softwareremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">广告收入</span></td>
        			<td>
        				<el-input v-model="formData.advertrevenue" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.adverttaxrate" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.advertrevenueno" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.advertoutput" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.advertremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX title red">收入合计</span></td>
        			<td>
        				<span class="red" >{{formData.incomerevenue}}</span>
        			</td>
        			<td></td>
        			<td>
                <span class="red" >{{formData.incomerevenueno}}</span>
        			</td>
        			<td>
                <span class="red" >{{formData.incomeoutput}}</span>
        			</td>
        			<td></td>
        		</tr>
        		<tr>
        			<td colspan="2" rowspan="13" id="addPay">
        				<span class="title red labelX">项<br>目<br>支<br>出</span>
        			</td>
        		</tr>
        		<tr style="background-color: #eff3fa;">
        			<td><span class="labelX">项目名称</span></td>
        			<td><span class="labelX">合同金额(元)</span></td>
        			<td ><span class="labelX">税率(%)</span></td>
        			<td><span class="labelX">不含税金额(元)</span></td>
        			<td><span class="labelX">进项税额(元)</span></td>
        			<td colspan="2"><span class="labelX">备注</span></td>
        		</tr>
        		<tr>
        			<td><span class="labelX">设备成本</span></td>
        			<td>
        				<el-input v-model="formData.devicecostmoney" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.devicecosttaxrate" ></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.devicecostmoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input v-model="formData.devicecostincome" :disabled="true"></el-input>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.devicecostremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">材料成本</span></td>
        			<td>
                <el-input v-model="formData.stuffcostmoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.stuffcosttaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.stuffcostmoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.stuffcostincome" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input type="textarea" v-model="formData.stuffcostremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">工程转包成本(包工包料)</span></td>
        			<td>
                <el-input v-model="formData.turncostmoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.turncosttaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.turncostmoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.turncostincome" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input type="textarea" v-model="formData.turncostremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">服务费</span></td>
        			<td>
                <el-input v-model="formData.servecostmoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.servecosttaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.servecostmoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.servecostincome" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input type="textarea" v-model="formData.servecostremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">施工费</span></td>
        			<td>
                <el-input v-model="formData.buildcostmoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.buildcosttaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.buildcostmoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.buildcostincome" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.buildcostremarks" type="textarea"></el-input>
        			</td>
        		</tr>

        		<tr>
        			<td><span class="labelX">自有产权设备投资</span></td>
        			<td>
                <el-input v-model="formData.havedevicemoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.havedevicetaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.havedevicemoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.havedeviceincome" :disabled="true"></el-input>
        			</td>
        			<td rowspan="2">
                <el-input v-model="formData.havedeviceremarks" type="textarea"></el-input>
        			</td>
        		</tr>

        		<tr>
        			<td><span class="labelX">自有产权线路投资</span></td>
        			<td>
                <el-input v-model="formData.havelinemoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.havelinetaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.havelinemoneyno" :disabled="true"></el-input>
        			</td>
              <td>
                <el-input v-model="formData.havelineincome" :disabled="true"></el-input>
              </td>
        		</tr>
        		<tr>
        			<td>
                <span class="labelX">维护成本(年维护费用*服务年度)</span>
                <div v-for="item in formData.upholdcostname" class="mrg">
                  <el-input v-model="item.value" placeholder="请输入费用名称"></el-input>
                </div>
              </td>
        			<td>
                <div v-for="item in formData.upholdcostmoney" class="mrg">
                  <el-input v-model="item.value" ></el-input>
                </div>
                <!-- <el-input v-model="formData.upholdcostmoney" ></el-input> -->
        			</td>
        			<td>
                <div v-for="item in formData.upholdcosttaxrate" class="mrg">
                  <el-input v-model="item.value" ></el-input>
                </div>
                <!-- <el-input v-model="formData.upholdcosttaxrate" ></el-input> -->
        			</td>
        			<td>
                <div v-for="item in formData.upholdcostmoneyno" class="mrg">
                  <el-input v-model="item.value" ></el-input>
                </div>
                <!-- <el-input v-model="formData.upholdcostmoneyno" :disabled="true"></el-input> -->
        			</td>
        			<td>
                <div v-for="item in formData.upholdcostincome" class="mrg">
                  <el-input v-model="item.value" ></el-input>
                </div>
                <!-- <el-input v-model="formData.upholdcostincome" :disabled="true"></el-input> -->
        			</td>
        			<td>
                <div style="width: 75%;float: left;">
                  <div v-for="item in formData.upholdcostremarks" class="mrg">
                    <el-input v-model="item.value" ></el-input>
                  </div>
                  <!-- <el-input  v-model="formData.upholdcostremarks" type="textarea"></el-input> -->
                </div>
                <div style="width: 25%;float: right;margin-top: 10px;">
                  <el-button size="mini" type="success" @click="addRow()" style="margin:5px 10px;">新增</el-button>
                  <div  v-for="item in formData.btnList" style="margin: 15px 10px;">
                    <el-button size="mini" type="warning" @click.prevent="delRow(item)">删除</el-button>
                  </div>
                </div>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">中标服务费、鉴证费等</span></td>
        			<td>
                <el-input v-model="formData.othercostmoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.othercosttaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.othercostmoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.othercostincome" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input type="textarea" v-model="formData.othercostremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX">垫资利息</span></td>
        			<td>
                <el-input v-model="formData.interestcostmoney" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.interestcosttaxrate" ></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.interestcostmoneyno" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input v-model="formData.interestcostincome" :disabled="true"></el-input>
        			</td>
        			<td>
                <el-input type="textarea" v-model="formData.interestcostremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td><span class="labelX title red">成本合计</span></td>
        			<td>
        					<span class="red" >{{formData.costmoney}}</span>
        			</td>
        			<td></td>
              <td>
        					<span class="red" >{{formData.costmoneyno}}</span>
        			</td>
        			<td>
        				<span class="red" >{{formData.costincome}}</span>
        			</td>
        			<td></td>
        		</tr>
        		<tr>
        			<td colspan="2" rowspan="4"><span class="labelX title" style="color: #FFA500;">其<br>他<br>费<br>用</span></td>
        		</tr>
        		<tr>
        			<td colspan="2" ><span class="labelX">增值税</span></td>
        			<td colspan="2" rowspan="5"></td>
        			<td>
        				<span >{{formData.foincrementtaxrate}}</span>
        			</td>
        			<td>
                <el-input type="textarea" v-model="formData.incrementremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2"><span class="labelX">附加税</span></td>
        			<td>
                {{formData.attachtaxrate}}
        			</td>
        			<td>
                <el-input type="textarea" v-model="formData.attachremarks" ></el-input>
        			</td>
        		</tr>
        		<tr>
        			<td colspan="2"><span class="labelX">文化事业建设费</span></td>
        			<td> {{formData.culturebuild}}	</td>
        			<td>
                <el-input type="textarea" v-model="formData.culturebuildremarks" ></el-input>
              </td>
        		</tr>
        		<tr>
        			<td colspan="4"><span  class="labelX title green">预计利润</span></td>
        			<td> <div class="green">	{{formData.estimateprofit}}	</div></td>
        			<td> <el-input type="textarea" v-model="formData.estimateprofitremarks" ></el-input></td>
        		</tr>

        		<tr>
        			<td colspan="4"><span class="labelX title green">预计利润率</span></td>
        			<td>
        				<div class="green">	{{formData.epmargin}}	</div>
        			</td>
        			<td>
        				<el-input type="textarea" v-model="formData.epmarginremarks" ></el-input>
        			</td>
        		</tr>
        	</tbody>
        </table>
      </el-form>
    </el-row>
  </div>
</template>
<script>
export default {
  components: {},
  props: [],
  data() {
    return {
      formData: {
        applycompany: "山东广电网络有限公司济南分公司",
        approvalno:"JN202008002",
        applydate:"2020-12-09",
        projectName:"",
        projectTypeOptions:[],
        incomerevenue:0.00,
        culturebuild:0.00,
        epmargin:0.00,
        incomerevenue:0.00,
        incomerevenueno:0.00,
        incomeoutput:0.00,
        estimateprofit:0.00,
        culturebuild:0.00,
        attachtaxrate:0.00,
        costincome:0.00,
        costmoney:0.00,
        foincrementtaxrate:0,
        costmoneyno:0.00,
        attachremarks:"综合税率12.5%（城市维护建设税7%，教育费附加3%，地方教育费附加2%，地方水利建设基金0.5%",
        culturebuildremarks:"费率3%，暂减按1.5%征收，文化事业建设费=广告收入*1.5%",
        upholdcostname: [],
        upholdcostmoney: [{
          value: ''
        }],
        upholdcosttaxrate: [{
          value: ''
        }],
        upholdcostmoneyno: [{
          value: ''
        }],
        upholdcostincome: [{
          value: ''
        }],
        upholdcostremarks: [{
          value: ''
        }],
        btnList: [],
      },
      rules: {
        field102: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
        field101: [{
          required: true,
          message: '请选择日期选择',
          trigger: 'change'
        }],
      },
    }
  },
  computed: {},
  watch: {},
  created() {},
  mounted() {},
  methods: {
    addRow() {
      this.formData.upholdcostname.push({
        value: '',
        key: Date.now()
      });
      this.formData.upholdcostmoney.push({
        value: '',
        key: Date.now()
      });
      this.formData.upholdcosttaxrate.push({
        value: '',
        key: Date.now()
      });
      this.formData.upholdcostmoneyno.push({
        value: '',
        key: Date.now()
      });
      this.formData.upholdcostincome.push({
        value: '',
        key: Date.now()
      });
      this.formData.upholdcostremarks.push({
        value: '',
        key: Date.now()
      });
      this.formData.btnList.push({
        value: '',
        key: Date.now()
      });
    },
    delRow(item){
      var index = this.formData.btnList.indexOf(item)
      alert(index);
      if (index !== -1) {
        this.formData.upholdcostname.splice(index, 1);
        this.formData.btnList.splice(index, 1);
        index +=1;
        this.formData.upholdcostmoney.splice(index, 1);
        this.formData.upholdcosttaxrate.splice(index, 1);
        this.formData.upholdcostmoneyno.splice(index, 1);
        this.formData.upholdcostincome.splice(index, 1);
        this.formData.upholdcostremarks.splice(index, 1);
      }
    }
  }
}

</script>
<style scoped  lang="scss">
	.table-bordered {
		border: 1px solid #ddd;
		border-collapse: collapse;
		border-spacing: 0;
	}
	.table-bordered td {
		border: 1px solid #ddd;
	}
	.labelX {
    display: inline-block;
		max-width: 100%;
		margin: 8px 5px;
		font-weight: bold;
		font-size: 14px;
	}
  .marks{
    padding: 10px;width: 300px;text-align:left;
  }
  .title{
    font-weight: bold;
    font-size: 20px;
  }
  .green{ color: rgb(0, 191, 255);}
  .red{color: red;}

</style>
