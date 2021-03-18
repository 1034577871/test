<template>
  <div>
    <el-input
      v-model="filterText"
      placeholder="输入关键字进行过滤"
      clearable
      size="small"
    />
    <el-tree
      class="filter-tree"
      :filter-node-method="filterNode"
      :data="treeData"
      :props="defaultProps"
      node-key="id"
      ref="treeForm"
      show-checkbox
      check-strictly
      default-expand-all
      highlight-current
      @check-change="handleNodeClick"
    >
    </el-tree>
  </div>
</template>

<script>
export default {
  data() {
    return {
      filterText: "",
      checkedId: "", //选中节点的ID
      checkedlabel: "", //选中节点名称
      defaultProps: {
        label: "label",
        children: "children"
      },
      treeData: []
    };
  },
  watch: {
    filterText(val) {
      this.$refs.treeForm.filter(val);
    }
  },
  methods: {
    filterNode(value, data) {
      if (!value) return true;
      return data.label.indexOf(value) !== -1;
    },

    //树节点复选框实现单选
    handleNodeClick(data, checked, node) {
      if (checked === true) {
        this.checkedId = data.id;
        this.checkedlabel = data.label;
        this.$refs.treeForm.setCheckedKeys([data.id]);
      } else {
        if (this.checkedId == data.id) {
          this.$refs.treeForm.setCheckedKeys([data.id]);
        }
      }
    }
  }
};
</script>

<style scoped lang="scss">
::v-deep .el-tree-node {
  .el-tree-node__label {
    font-size: 16px;
  }
}
/* 只允许叶子节点有复选框 */
::v-deep .el-tree-node {
  .is-leaf + .el-checkbox .el-checkbox__inner {
    display: inline-block;
  }
  .el-checkbox .el-checkbox__inner {
    display: none;
  }
}
</style>
