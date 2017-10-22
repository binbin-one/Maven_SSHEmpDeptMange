<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h2>添加新部门</h2>
	<div id="message">
	</div>
	<form id="addDept" action="">
		部门名:<input name="dept.dname" onfocus="javascript:$('#message').html('');"><br/>
		     <input type="button" value="添加部门" onclick="addClass()">
	</form>
	<a href="deptList.jsp">部门信息列表</a>
</body>
</html>
<script type="text/javascript">
	function addClass(){
		//异步添加部门
		var param=$("#addDept").serialize();
		$.post("deptAction_addDept",param,function(data){
			if(data.msg=="success"){
				$("#message").css("color","green").html("添加部门成功!");
			}else{
				$("#message").css("color","red").html("添加部门失败!");
			}	
		});
	}
</script>