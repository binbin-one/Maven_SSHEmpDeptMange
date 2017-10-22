<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>添加员工</h2>
	<div>
		<s:if test="#parameters.msg[0]=='success'">
			<p style="color:green">添加学生成功!</p>
		</s:if>
		<s:elseif test="#parameters.msg[0]=='error'">
			<p style="color:red">添加学生失败!</p>
		</s:elseif>
	</div>
	<s:form action="empAction_addEmp" method="post">
	学生姓名:<s:textfield name="emp.ename"/><br/>
	学生年龄:<s:textfield name="emp.eage"/><br/>
	学生性别:<s:radio list="#{'1':'男','0':'女'}" name="emp.esex" value="%{'1'}"/><br/>
	学生爱好:<s:checkboxlist name="emp.ehobby" list="{'体育','音乐','电影'}"/><br/>
	入学时间:<s:textfield name="emp.eintime"/><br/>
	选择班级:<select name="emp.dept.dno">
				<option value="">请选择部门</option>
			 </select><br/>
			 <s:submit value="添加员工"/>
	</s:form>
	<a href="empAction_selectAllEmp">返回员工列表</a>
</body>
</html>
<script type="text/javascript">
	$(function(){
		$(":input[name='emp.dept.dno'] option:not(:first)").remove();
		$.post("empAction_selectAllDept",null,function(data){
			$.each(data.deptlist,function(i,v){
				var option="<option value='"+v.dno+"'>"+v.dname+"</option>";
				$(":input[name='emp.dept.dno']").append(option);
			});
		},"json");
	});
</script>