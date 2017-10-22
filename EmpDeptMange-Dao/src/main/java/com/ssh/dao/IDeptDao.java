package com.ssh.dao;

import java.util.List;
import com.ssh.entity.Dept;

public interface IDeptDao {
	// 添加部门方法
	public boolean addDept(Dept dept);

	// 删除部门方法
	public boolean deleteDept(Dept dept);

	// 修改部门方法
	public boolean updateDept(Dept dept);

	// 查询部门方法
	public List selectAllDept(String hql);

	public Dept selectByIdDept(Dept dept);
}
