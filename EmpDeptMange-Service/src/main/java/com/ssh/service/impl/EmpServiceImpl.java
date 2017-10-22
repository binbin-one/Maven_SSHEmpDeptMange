package com.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ssh.dao.IEmpDao;
import com.ssh.entity.Emp;
import com.ssh.service.IEmpService;

@Service("empService")
@Transactional(propagation = Propagation.REQUIRED)
public class EmpServiceImpl implements IEmpService {
	// 声明数据层接口
	@Resource(name = "empDao")
	private IEmpDao empDao;

	/**
	 * 添加员工方法
	 */
	@Override
	public boolean addEmp(Emp emp) {
		return empDao.addEmp(emp);
	}

	/**
	 * 删除员工方法
	 */
	@Override
	public boolean deleteEmp(Emp emp) {
		return empDao.deleteEmp(emp);
	}

	/**
	 * 修改员工方法
	 */
	@Override
	public boolean updateEmp(Emp emp) {
		return empDao.updateEmp(emp);
	}

	/**
	 * 查询所有学生方法
	 */
	@Override
	public List selectAllEmp() {
		String hql="from Emp e inner join e.dept";
		return empDao.selectAllEmp(hql);
	}

	/**
	 * 查询指定员工方法
	 */
	@Override
	public Emp selectByIdEmp(Emp emp) {
		return empDao.selectByIdEmp(emp);
	}

	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}
	
}
