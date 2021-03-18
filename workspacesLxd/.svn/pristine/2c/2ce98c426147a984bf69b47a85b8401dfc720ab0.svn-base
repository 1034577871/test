<template>
  <div>
    <el-dialog title="提示" :visible.sync="dialogVisible" append-to-body width="40%" v-on:close="quXiao">

      <el-form ref="form" :model="form" label-width="100px">
        <el-form-item label="发票号码" prop="invoiceId">
          <el-input v-model="form.invoiceId" placeholder="请输入发票号码" />
        </el-form-item>
        <el-form-item label="发票含税金额" prop="invoiceMoney">
          <el-input v-model="form.invoiceMoney" placeholder="请输入发票含税金额" oninput="value=value.replace(/[^0-9.]/g,'')" />
        </el-form-item>
        <el-form-item label="发票代码" prop="invoiceCode">
          <el-input v-model="form.invoiceCode" placeholder="请输入发票代码" />
        </el-form-item>
        <el-form-item label="发票时间" prop="invoiceTime">
          <el-date-picker clearable size="small" style="width: 100%"
            v-model="form.invoiceTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择发票时间">
          </el-date-picker>
        </el-form-item>
      </el-form>

      <span slot="footer" class="dialog-footer">
        <el-button @click="quXiao">取 消</el-button>
        <el-button type="primary" @click="confirm">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import request from '@/utils/request';
import {listAppNgc} from '../../../api/projectApproval/appNgc';
export default {
  name: 'addDialog',
  props: {
    objId: {
      type: String,
      default: ''
    },

    dialogVisible:{
      type:Boolean,
      default:false
    }

  },
  data() {
    return {
      dialogVisible: false,
      form:{
        invoiceId:null,
        invoiceMoney:null,
        invoiceCode:null,
        invoiceTime:null
      }
    };
  },
  created() {

  },
  methods: {

    confirm() {
      this.dialogVisible = false;
      this.$emit('ok', this.form,false);
    },

    quXiao(){
      this.dialogVisible = false
      this.$emit('ok', "1",false);
    }
  }
};
</script>

<style></style>
