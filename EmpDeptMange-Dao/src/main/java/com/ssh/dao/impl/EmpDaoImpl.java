package com.ssh.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssh.dao.IEmpDao;
import com.ssh.entity.Emp;

@Repository("empDao")
public class EmpDaoImpl extends BaseDao implements IEmpDao {
	/**
	 * 添加员工方法
	 */
	@Override
	public boolean addEmp(Emp emp) {
		try {
			getSession().save(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除员工方法
	 */
	@Override
	public boolean deleteEmp(Emp emp) {
		try {
			getSession().delete(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改员工方法
	 */
	@Override
	public boolean updateEmp(Emp emp) {
		try {
			getSession().update(emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询所有员工方法
	 */
	@Override
	public List<?> selectAllEmp(String hql) {
		return getSession().createQuery(hql).list();
	}

	/**
	 * 查询指定员工信息
	 */
	@Override
	public Emp selectByIdEmp(Emp emp) {
		return getSession().get(Emp.class, emp.getEno());
	}
}
