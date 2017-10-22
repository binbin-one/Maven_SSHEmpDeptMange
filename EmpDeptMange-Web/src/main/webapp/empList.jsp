<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>员工信息列表</h2>
	<div>
		<s:if test="#parameters.msg[0]=='success'">
			<p style="color:green">操作员工成功!</p>
		</s:if>
		<s:elseif test="#parameters.msg[0]=='error'">
			<p style="color:red">操作员工失败!</p>
		</s:elseif>
	</div>
	<table border="1" width="700">
	<tr>
	<td>编号</td><td>部门名称</td>
	<td>姓名</td><td>年龄</td>
	<td>性别</td><td>爱好</td>
	<td>入学时间</td><td>管理</td>
	</tr>
	<s:iterator value="#request.emplist" var="em" status="ids">
	<tr>
	<td>${ids.count }</td><td>${em[1].dname}</td>
	<td>${em[0].ename}</td><td>${em[0].eage}</td>
	<td>${em[0].esex==1?"男":"女"}</td><td>${em[0].ehobby}</td>
	<td>${em[0].eintime.toString().substring(0,10)}</td>
	<td>
		<a href="addEmp.jsp">添加</a>&nbsp;|&nbsp;
		<a href="empAction_toUpdateEmp?emp.eno=${em[0].eno }">修改</a>&nbsp;|&nbsp;
		<a href="empAction_deleteEmp?emp.eno=${em[0].eno }">删除</a>
	</td>
	</tr>
	</s:iterator>
	</table>
	<a href="${pageContext.request.contextPath}/index.jsp">返回主页</a>
</body>
</html>