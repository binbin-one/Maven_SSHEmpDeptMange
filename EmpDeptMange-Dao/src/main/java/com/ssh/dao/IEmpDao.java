package com.ssh.dao;

import java.util.List;

import com.ssh.entity.Dept;
import com.ssh.entity.Emp;

public interface IEmpDao {
	// 添加员工方法
	public boolean addEmp(Emp emp);

	// 删除员工方法
	public boolean deleteEmp(Emp emp);

	// 修改员工方法
	public boolean updateEmp(Emp emp);

	// 查询员工方法
	public List selectAllEmp(String hql);

	public Emp selectByIdEmp(Emp emp);
}
