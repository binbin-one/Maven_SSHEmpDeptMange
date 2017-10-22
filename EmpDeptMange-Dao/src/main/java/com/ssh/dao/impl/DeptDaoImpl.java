package com.ssh.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.ssh.dao.IDeptDao;
import com.ssh.entity.Dept;



@Repository("deptDao")
public class DeptDaoImpl extends BaseDao implements IDeptDao {
	/**
	 * 添加部门方法
	 */
	@Override
	public boolean addDept(Dept dept) {
		try {
			getSession().save(dept);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除部门方法
	 */
	@Override
	public boolean deleteDept(Dept dept) {
		try {
			getSession().delete(dept);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改部门方法
	 */
	@Override
	public boolean updateDept(Dept dept) {
		try {
			getSession().update(dept);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询所有部门方法
	 */
	@Override
	public List<?> selectAllDept(String hql) {
		return getSession().createQuery(hql).list();
	}

	/**
	 * 查询指定部门信息
	 */
	@Override
	public Dept selectByIdDept(Dept dept) {
		return getSession().get(Dept.class, dept.getDno());
	}

}
