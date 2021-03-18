<template>
  <el-row :gutter="40" class="panel-group">
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('newVisitis')">
        <div class="card-panel-icon-wrapper icon-people">
          <!-- <svg-icon icon-class="align-center" class-name="card-panel-icon" /> -->
          <img src="@/assets/image/new.png" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text ">
            本月新增
          </div>
          <count-to :start-val="0" :end-val="countContract.newContractCount" :duration="5" class="card-panel-num icon-shopping" />
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('messages')">
        <div class="card-panel-icon-wrapper icon-message">
          <!-- <svg-icon icon-class="message" class-name="card-panel-icon" /> -->
           <img src="@/assets/image/end.png" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            本月终止
          </div>
          <count-to :start-val="0" :end-val="countContract.expiryContractCount" :duration="10" class="card-panel-num icon-shopping" />
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('purchases')">
        <div class="card-panel-icon-wrapper icon-money">
          <!-- <svg-icon icon-class="money" class-name="card-panel-icon" /> -->
          <img src="@/assets/image/change.png" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            本月变更
          </div>
          <count-to :start-val="0" :end-val="countContract.alterContractCount" :duration="10" class="card-panel-num icon-shopping" />
        </div>
      </div>
    </el-col>
    <el-col :xs="12" :sm="12" :lg="6" class="card-panel-col">
      <div class="card-panel" @click="handleSetLineChartData('shoppings')">
        <div class="card-panel-icon-wrapper icon-shopping">
          <!-- <svg-icon icon-class="shopping" class-name="card-panel-icon" /> -->
          <img src="@/assets/image/jiesuan.png" />
        </div>
        <div class="card-panel-description">
          <div class="card-panel-text">
            本月待结算
          </div>
          <count-to :start-val="0" :end-val="countContract.accruedAssets" :duration="10" class="card-panel-num icon-shopping" />
        </div>
      </div>
    </el-col>
  </el-row>
</template>

<script>
  import CountTo from 'vue-count-to';
  import { listContract,  getContract, delContract, addContract, updateContract, exportContract, countContractIndex } from '@/api/contract/contractInfo';

  export default {
    components: {
      CountTo
    },
    data() {
      return {
        countContract: [],
      }
    },
    created() {
      this.countContractIndex();
    },
    methods: {
      handleSetLineChartData(type) {
        this.$emit('handleSetLineChartData', type)
      },
      countContractIndex(){
        countContractIndex().then(response => {
          this.countContract = response
        });
      }
    }
  }
</script>

<style lang="scss" scoped>
  .panel-group {
    margin-top: 18px;

    .card-panel-col {
      margin-bottom: 32px;
    }

    .card-panel {
      height: 108px;
      cursor: pointer;
      font-size: 12px;
      position: relative;
      overflow: hidden;
      color: #666;
      background: #fff;
      box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
      border-radius: 4px;
      border: 1px solid #ddd;

      &:hover {
        .card-panel-icon-wrapper {
          color: #fff;
        }

      }

      .icon-people {
        color: #40c9c6;
      }

      .icon-message {
        color: #36a3f7;
      }

      .icon-money {
        color: #f4516c;
      }

      .icon-shopping {
        color: #fea348;
      }

      .card-panel-icon-wrapper {
        float: left;
        margin: 14px 0 0 14px;
        padding: 16px;
        transition: all 0.38s ease-out;
        border-radius: 6px;
      }

      .card-panel-icon {
        float: left;
        font-size: 48px;
      }

      .card-panel-description {
        float: right;
        font-weight: bold;
        margin: 26px;
        margin-left: 0px;

        .card-panel-text {
          line-height: 18px;
          color: rgba(0, 0, 0, 0.45);
          font-size: 16px;
          margin-bottom: 12px;
        }

        .card-panel-num {
          font-size: 20px;
        }
      }
    }
  }

  @media (max-width:550px) {
    .card-panel-description {
      display: none;
    }

    .card-panel-icon-wrapper {
      float: none !important;
      width: 100%;
      height: 100%;
      margin: 0 !important;

      .svg-icon {
        display: block;
        margin: 14px auto !important;
        float: none !important;
      }
    }
  }
</style>
