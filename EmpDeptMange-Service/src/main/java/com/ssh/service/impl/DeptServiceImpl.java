package com.ssh.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.ssh.dao.IDeptDao;
import com.ssh.entity.Dept;
import com.ssh.service.IDeptService;

@Service("deptService")
@Transactional(propagation = Propagation.REQUIRED)
public class DeptServiceImpl implements IDeptService {
	// 声明数据层接口
	@Resource(name = "deptDao")
	private IDeptDao deptDao;

	/**
	 * 添加部门方法
	 */
	@Override
	public boolean addDept(Dept dept) {
		return deptDao.addDept(dept);
	}

	/**
	 * 删除部门方法
	 */
	@Override
	public boolean deleteDept(Dept dept) {
		return deptDao.deleteDept(dept);
	}

	/**
	 * 修改部门方法
	 */
	@Override
	public boolean updateDept(Dept dept) {
		return deptDao.updateDept(dept);
	}

	/**
	 * 查询所有部门方法
	 */
	@Override
	public List selectAllDept() {
		String hql = "from Dept";
		return deptDao.selectAllDept(hql);
	}

	/**
	 * 查询指定部门方法
	 */
	@Override
	public Dept selectByIdDept(Dept dept) {
		return deptDao.selectByIdDept(dept);
	}

	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}

}
