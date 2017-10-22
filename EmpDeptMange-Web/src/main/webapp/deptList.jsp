<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.2.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>部门信息列表</h2>
	<div id="showMessage">
	</div>
	<table id="tab" border="1" width="500">
		<tr>
			<td>编号</td><td>部门名称</td>
			<td>管理</td>
		</tr>
	</table>
	<a href="${pageContext.request.contextPath }/index.jsp">返回首页</a>
</body>
</html>
<script type="text/javascript">
function loadData(){
			$("#tab tr:not(:first)").remove();
			$.get("deptAction_selectAllDept","",function(data){
				$.each(data.deptlist,function(i,v){
					var tr="<tr>";
						tr+="<td>"+(i+1)+"</td>";
						tr+="<td>"+v.dname+"</td>";
						tr+="<td><a href='addDept.jsp'>添加</a>&nbsp;|&nbsp;<a href='updateDept.jsp?dno="+v.dno+"'>修改</a>&nbsp;|&nbsp;<a href='javascript:deleteClass("+v.dno+")'>删除</a>|&nbsp;"
						tr+="</td>";
						tr+="</tr>";
					$("#tab").append(tr);
				});
			},"json");
	} 
	window.onload=loadData;

	function deleteClass(id){
		$.post("deptAction_deleteDept",{"dept.dno":id},function(data){
			if(data.msg=="success"){
				$("#showMessage").css("color","green").html("删除部门成功!");
				loadData();//刷新数据
			}else{
				$("#showMessage").css("color","red").html("删除部门失败!");
			}
		});
	}
</script>