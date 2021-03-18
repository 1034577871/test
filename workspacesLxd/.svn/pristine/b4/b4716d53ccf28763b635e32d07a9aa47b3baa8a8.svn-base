<template>
  <div class="app-container">
    <el-form
      :model="queryParams"
      ref="queryForm"
      :inline="true"
      v-show="showSearch"
      label-width="68px"
    >
      <el-form-item label="父类ID" prop="parentId">
        <el-input
          v-model="queryParams.parentId"
          placeholder="请输入父类ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="名称" prop="cname">
        <el-input
          v-model="queryParams.cname"
          placeholder="请输入名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型" prop="ctype">
        <el-select
          v-model="queryParams.ctype"
          placeholder="请选择类型"
          clearable
          size="small"
        >
          <el-option
            v-for="dict in areaTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button
          type="cyan"
          icon="el-icon-search"
          size="mini"
          @click="handleQuery"
          >搜索</el-button
        >
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery"
          >重置</el-button
        >
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['dictionary:area:add']"
          >新增</el-button
        >
      </el-col>
      <right-toolbar
        :showSearch.sync="showSearch"
        @queryTable="getList"
      ></right-toolbar>
    </el-row>

    <el-table
      v-loading="loading"
      :data="areaList"
      row-key="id"
      default-expand-all
      :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
    >
      <el-table-column label="父类ID" align="center" prop="parentId" />
      <el-table-column label="名称" align="center" prop="cname" />
      <el-table-column label="类型" align="center" prop="ctype" :formatter="typeForMatter"/>
      <el-table-column
        label="操作"
        align="center"
        class-name="small-padding fixed-width"
      >
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['dictionary:area:edit']"
            >修改</el-button
          >
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['dictionary:area:remove']"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <!-- 添加或修改地区信息字典对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="父类ID" prop="parentId">
          <treeselect
            v-model="form.parentId"
            :options="areaOptions"
            :normalizer="normalizer"
            placeholder="请选择父类ID"
          />
        </el-form-item>
        <el-form-item label="名称" prop="cname">
          <el-input v-model="form.cname" placeholder="请输入名称" />
        </el-form-item>
        <el-form-item label="类型" prop="ctype">
          <el-select v-model="form.ctype" placeholder="请选择类型">
            <el-option
              v-for="dict in areaTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            />
          </el-select>
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
import {
  listArea,
  getArea,
  delArea,
  addArea,
  updateArea,
  exportArea
} from "@/api/dictionary/area";
import Treeselect from "@riophae/vue-treeselect";
import "@riophae/vue-treeselect/dist/vue-treeselect.css";

export default {
  name: "Area",
  components: {
    Treeselect
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 显示搜索条件
      showSearch: true,
      // 地区信息字典表格数据
      areaList: [],
      // 地区信息字典树选项
      areaOptions: [],
      // 地区信息字典树选项
      areaTypeOptions: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        parentId: null,
        cname: null,
        ctype: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        parentId: [
          { required: true, message: "父类ID不能为空", trigger: "blur" }
        ],
        cname: [{ required: true, message: "名称不能为空", trigger: "blur" }],
        ctype: [{ required: true, message: "类型不能为空", trigger: "change" }]
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("area_type").then(response => {
      this.areaTypeOptions = response.data;
    });
  },
  methods: {
    /** 查询地区信息字典列表 */
    getList() {
      this.loading = true;
      listArea(this.queryParams).then(response => {
        this.areaList = this.handleTree(response.data, "id", "parentId");
        this.loading = false;
      });
    },
    typeForMatter(row){
        return this.selectDictLabel(this.areaTypeOptions, row.ctype);
    },
    /** 转换地区信息字典数据结构 */
    normalizer(node) {
      if (node.children && !node.children.length) {
        delete node.children;
      }
      return {
        id: node.id,
        label: node.cname,
        children: node.children
      };
    },
    /** 查询部门下拉树结构 */
    getTreeselect() {
      listArea().then(response => {
        this.areaOptions = [];
        const data = { id: 0, cname: "顶级节点", children: [] };
        data.children = this.handleTree(response.data, "id", "parentId");
        this.areaOptions.push(data);
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
        parentId: null,
        cname: null,
        ctype: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.getTreeselect();
      this.open = true;
      this.title = "添加地区信息字典";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.getTreeselect();
      if (row != null) {
        this.form.parentId = row.id;
      }
      getArea(row.id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改地区信息字典";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateArea(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addArea(this.form).then(response => {
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
      this.$confirm(
        '是否确认删除地区信息字典编号为"' + row.id + '"的数据项?',
        "警告",
        {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }
      )
        .then(function() {
          return delArea(row.id);
        })
        .then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        });
    }
  }
};
</script>
