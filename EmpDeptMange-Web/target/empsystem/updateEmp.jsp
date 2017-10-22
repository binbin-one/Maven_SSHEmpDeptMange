<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>修改员工</h2>
	<s:form method="post" action="empAction_updateEmp">
		   <s:hidden name="emp.eno"/><br/>
	学生姓名:<s:textfield name="emp.ename"/><br/>
	学生年龄:<s:textfield name="emp.eage"/><br/>
	学生性别:<s:radio list="#{'1':'男','0':'女'}" name="emp.esex"/><br/>
	学生爱好:<s:checkboxlist name="emp.ehobby" list="{'体育','音乐','电影'}"/><br/>
	入学时间:<s:textfield name="emp.eintime"/><br/>
	选择班级:<select name="emp.dept.dno">
				<option value="">请选择部门</option>
			 </select><br/>
			 <s:submit value="修改员工"/>
	</s:form>
	<a href="empAction_selectAllEmp">返回员工列表</a>
</body>
<script type="text/javascript">

	$(function(){
		//更新爱好显示
		var hobbys="${emp.ehobby}";
		var chkHobbys=document.getElementsByName("emp.ehobby");
		for (var i= 0; i < chkHobbys.length; i++) {
			if(hobbys.indexOf(chkHobbys[i].value)>=0){
				chkHobbys[i].checked=true;
			}
		}
		//取出所有可选的班级
		$(":input[name='emp.dept.dno'] option:not(:first)").remove();
		$.post("empAction_selectAllDept","",function(data){
			$.each(data.deptlist,function(i,v){
				var option="<option value='"+v.dno+"'>"+v.dname+"</option>";
				$(":input[name='emp.dept.dno']").append(option);
			});
		},"json");
	});
</script>
</html>