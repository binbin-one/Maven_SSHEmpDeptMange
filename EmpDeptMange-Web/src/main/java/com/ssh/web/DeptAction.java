package com.ssh.web;
/**
 * 处理部门对象Action
 * @author Bin
 *
 */

import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ssh.entity.Dept;
import com.ssh.entity.Emp;
import com.ssh.service.IDeptService;
import com.ssh.service.IEmpService;

@Controller("deptAction")
@Scope("prototype")
public class DeptAction {
	// 声明服务层接口
	private Dept dept;
	private Emp emp;
	private String msg;
	private List<?> deptlist;
	@Resource(name="empService")
	private IEmpService empService;
	@Resource(name = "deptService")
	private IDeptService deptService;

	/**
	 *  查询所有部门
	 * @return
	 */
	public String selectAllDept() {
		// 调用服务层方法保存部门信息
		deptlist = deptService.selectAllDept();
		return "success";
	}

	/**
	 *  添加部门方法
	 * @return
	 */
	public String addDept() {
		if (deptService.addDept(dept)) {
			msg = "success";
		} else {
			msg = "error";
		}
		return "addDept";
	}

	/**
	 *  删除部门方法
	 * @return
	 */
	public String deleteDept() {
		//查询指定班级员工并删除
		List<Emp> list=(List<Emp>)empService.selectByIdEmp(emp);
		for (Emp emplist : list) {
			empService.deleteEmp(emplist);
		}
		if (deptService.deleteDept(dept)) {
			msg = "success";
		} else {
			msg = "error";
		}
		return "deleteDept";
	}

	/**
	 * 修改部门信息
	 * @return
	 */
	public String toUpdateDept() {
		// 查询指定部门信息
		dept = (Dept) deptService.selectByIdDept(dept);
		return "toUpdateDept";
	}

	public String updateDept() {
		if (deptService.updateDept(dept)) {
			msg = "success";
		} else {
			msg = "error";
		}
		return "updateDept";
	}
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<?> getDeptlist() {
		return deptlist;
	}

	public void setDeptlist(List<?> deptlist) {
		this.deptlist = deptlist;
	}
	
	public void setEmpService(IEmpService empService) {
		this.empService = empService;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
}
