package com.ssh.web;
/**
 * 处理员工对象Action
 * @author Bin
 *
 */
import java.util.List;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.ssh.entity.Emp;
import com.ssh.service.IDeptService;
import com.ssh.service.IEmpService;

@Controller("empAction")
@Scope("prototype")
public class EmpAction {
	
	private Emp emp;
	private String msg;
	private List<?> deptlist;
	//声明服务层接口
	@Resource(name = "empService")
	private IEmpService empService;
	@Resource(name = "deptService")
	private IDeptService deptService;

	// 查询所有部门
	public String selectAllDept() {
		// 调用服务层方法保存部门信息
		deptlist = deptService.selectAllDept();
		return "success";
	}

	// 添加员工方法
	public String addEmp() {
		if (empService.addEmp(emp)) {
			msg = "success";
		} else {
			msg = "error";
		}
		return "addEmp";
	}

	// 删除员工方法
	public String deleteEmp() {
		if (empService.deleteEmp(emp)) {
			msg = "success";
		} else {
			msg = "error";
		}
		return "deleteEmp";
	}

	// 修改员工信息
	public String toUpdateEmp() {
		// 查询指定员工信息
		emp = (Emp) empService.selectByIdEmp(emp);
		return "toupdateEmp";
	}

	public String updateEmp() {
		if (empService.updateEmp(emp)) {
			msg = "success";
		} else {
			msg = "error";
		}
		return "updateEmp";
	}

	// 查询所有学生方法
	public String selectAllEmp() {
		ActionContext.getContext().put("emplist", empService.selectAllEmp());
		return "emplist";
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
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
