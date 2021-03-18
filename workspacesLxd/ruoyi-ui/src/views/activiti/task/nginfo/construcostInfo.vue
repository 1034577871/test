<template>
  <div>
    <el-form ref="elForm" :model="formData" size="medium" label-width="100px">
      <table class="curr-table ">
        <tbody>
          <tr>
            <th width="10%">序号</th>
            <th width="10%">施工项目</th>
            <th width="25%">内容说明</th>
            <th width="10%">单位</th>
            <th width="10%">所需工日</th>
            <th width="10%">工日单价</th>
            <th width="15%">金额</th>
           
          </tr>
          <tr v-for="(value, index) in dataList" :key="index">
            <td>
              {{ index+1 }}
            </td>
            <td>
              <el-input
                v-model="value.projectName"
                :name="'appMateList[' + index + '].projectName'"
              />
            </td>
            <td>
              <el-input
                v-model="value.description"
                :name="'appMateList[' + index + '].description'"
              />
            </td>
            <td>
              <el-input
                v-model="value.projectUnit"
                :name="'appMateList[' + index + '].projectUnit'"
              />
            </td>
            <td>
              <el-input
                v-model="value.days"
                :name="'appMateList[' + index + '].days'"
                v-on:input="changeNum(index)"
              />
            </td>
            <td>
              <el-input
                v-model="value.daysPrice"
                :name="'appMateList[' + index + '].daysPrice'"
                v-on:input="changeNum(index)"
              />
            </td>
            <td>
              <el-input
                v-model="value.daysAmount"
                :name="'appMateList[' + index + '].daysAmount'"
              />
            </td>
           
          </tr>
        </tbody>
      </table>
    </el-form>

  </div>
</template>
<script>
export default {
  components: {},
  props: {
    construcostInfoDate: {}
  },
  data() {
    return {
      formData: null,
      dataList: []
    };
  },
  created() {
    if (!this.construcostInfoDate) {
      this.dataList.push({
        id: null,
        projectName: null,
        description: null,
        projectUnit: null,
        days: null,
        daysPrice: null,
        daysAmount: null
      });
    }
  },
  methods: {
    /** 添加行 **/
    loadMore: function() {
      this.dataList.push({
        id: null,
        projectName: null,
        description: null,
        projectUnit: null,
        days: null,
        daysPrice: null,
        daysAmount: null
      });
    },
    /** 删除行 **/
    removeTodo: function(index) {
      this.dataList.splice(index, 1);
    },
    /** 计算金额,格式化信息 **/
    changeNum(indexNum) {
      let price = this.dataList[indexNum].materialPrice;
      let mount = this.dataList[indexNum].materialMount;
      if (price && mount) {
        this.dataList[indexNum].materialAmount = this.formatPrice(
          price * mount
        );
      }
    },
    /** 格式化金额 **/
    formatPrice(value) {
      let tempVal = parseFloat(value).toFixed(3);
      let realVal = tempVal.substring(0, tempVal.length - 1);
      return realVal;
    }
  }
};
</script>

<style scoped  lang="scss">
.curr-table {
  text-align: center;
  width: 100%;
  vertical-align: middle;
  border-spacing: 0px;
  border-style: none;
  border-collapse: collapse;
}
.curr-table td,th {
  padding: 5px 10px;
}
.curr-table th {
  font-weight: bold;
  background-color: #eff3fa;
  height: 40px;
}

</style>
