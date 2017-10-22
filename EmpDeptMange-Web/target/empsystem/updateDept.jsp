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
	<h2>修改部门信息</h2>
	<div id="showMessage">
	</div>
	<form action="" id="updateCls">
			  <input type="hidden" name="dept.dno" value="${param.dno }"/>
		部门名:<input name="dept.dname" onfocus="javascript:$('#showMessage').html('');"><br/>
			 <input type="button" value="修改部门" onclick="updateClass()"/>
	</form>
	<a href="deptList.jsp">返回部门信息</a>
</body>
<script type="text/javascript">
	//页面加载完毕后显示要更新的部门信息
	$(function(){
		var dno = $("input[type='hidden']").val();
		$.post("deptAction_toUpdateDept",{"dept.dno":dno},function(data){
			$("input[name='dept.dname']").val(data.dept.dname);
		},"json");
	});
	//异步修改班级
	function updateClass(){
		//异步修改班级
		var param=$("#updateCls").serialize();
		$.post("deptAction_updateDept",param,function(data){
			if(data.msg=="success"){
				$("#showMessage").css("color","green").html("修改部门成功!");
			}else{
				$("#showMessage").css("color","red").html("修改部门失败!");
			}	
		});
	}
</script>
</html>