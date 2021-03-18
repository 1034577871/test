package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 部门管理 数据层
 * 
 * @author ruoyi
 */
public interface SysDeptMapper {

	/**
	 * 查询部门管理数据
	 * 
	 * @param dept 部门信息
	 * @return 部门信息集合
	 */
	public List<SysDept> selectDeptList(SysDept dept);

	/**
	 * 根据角色ID查询部门树信息
	 * 
	 * @param roleId            角色ID
	 * @param deptCheckStrictly 部门树选择项是否关联显示
	 * @return 选中部门列表
	 */
	public List<Integer> selectDeptListByRoleId(@Param("roleId") Long roleId,
			@Param("deptCheckStrictly") boolean deptCheckStrictly);

	/**
	 * 根据部门ID查询信息
	 * 
	 * @param deptId 部门ID
	 * @return 部门信息
	 */
	public SysDept selectDeptById(Long deptId);

	/**
	 * 根据ID查询所有子部门
	 * 
	 * @param deptId 部门ID
	 * @return 部门列表
	 */
	public List<SysDept> selectChildrenDeptById(Long deptId);

	/**
	 * 根据ID查询所有子部门（正常状态）
	 * 
	 * @param deptId 部门ID
	 * @return 子部门数
	 */
	public int selectNormalChildrenDeptById(Long deptId);

	/**
	 * 是否存在子节点
	 * 
	 * @param deptId 部门ID
	 * @return 结果
	 */
	public int hasChildByDeptId(Long deptId);

	/**
	 * 查询部门是否存在用户
	 * 
	 * @param deptId 部门ID
	 * @return 结果
	 */
	public int checkDeptExistUser(Long deptId);

	/**
	 * 校验部门名称是否唯一
	 * 
	 * @param deptName 部门名称
	 * @param parentId 父部门ID
	 * @return 结果
	 */
	public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

	/**
	 * 新增部门信息
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	public int insertDept(SysDept dept);

	/**
	 * 修改部门信息
	 * 
	 * @param dept 部门信息
	 * @return 结果
	 */
	public int updateDept(SysDept dept);

	/**
	 * 修改所在部门的父级部门状态
	 * 
	 * @param dept 部门
	 */
	public void updateDeptStatus(SysDept dept);

	/**
	 * 修改子元素关系
	 * 
	 * @param depts 子元素
	 * @return 结果
	 */
	public int updateDeptChildren(@Param("depts") List<SysDept> depts);

	/**
	 * 删除部门管理信息
	 * 
	 * @param deptId 部门ID
	 * @return 结果
	 */
	public int deleteDeptById(Long deptId);

	/**
	 * @Title: SysDeptController.java
	 * @Description: 获取分公司列表
	 * @Author M.Mu
	 * @Date 2020-12-08
	 */
	public List<SysDept> findBranchOffice();
	
	/**
	 * @Title: ISysDeptService.java
	 * @Description: 根据用户ID返回所属分公司名称
	 * @Author M.Mu
	 * @Date 2020-12-16
	 */
	public String findLoginbyCompany(String userId);
	
	/**
	 * @Title: ISysDeptService.java
	 * @Description: 根据分公司ID获取下属部门信息
	 * @Author M.Mu
	 * @Date 2020-12-19
	 */
	public List<SysDept> findDeptByBranchOffice(String id);

	/**
	 * 根据父ID查询
	 * @param parentId
	 * @return
	 */
	public List<SysDept> selectDeptByParentId(Long parentId);
}