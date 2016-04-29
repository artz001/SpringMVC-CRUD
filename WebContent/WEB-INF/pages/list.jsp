<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		//为超链接添加 click 响应函数
		
		$(".delete").click(function(){
			//设置 #hiddenForm 的 action
			var url = this.href;
			$("#hiddenForm").attr("action", url);
			//设置 #_method 的 value 值
			$("#_method").val("DELETE");
			//再提交 #hiddenForm 的表单
			$("#hiddenForm").submit();
			
			//取消默认行为
			return false;
		})
	})
</script>
</head>
<body>
	
	<form action="" method="POST" id="hiddenForm">
		<input type="hidden" name="_method"  id="_method"/>
	</form>
	
	<h4>List Page</h4>
	
	<c:if test="${empty emps }">
		没有任何信息
	</c:if>
	
	<c:if test="${!empty emps }">
	
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>LastName</td>
			<td>Email</td>
			<td>Gender</td>
			<td>Department</td>
			<td>Edit</td>
			<td>Delete</td>
		</tr>
		
		<c:forEach items="${emps }" var="emp">
			<tr>
				<td>${emp.id }</td>
				<td>${emp.lastName }</td>
				<td>${emp.email }</td>
				<td>${emp.gender == 1 ? '男':'女' }</td>
				<td>${emp.department.departmentName }</td>
				<td><a href="emp/${emp.id }">Edit</a></td>
				<td><a href="emp/${emp.id }" class="delete">Delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	
	</c:if>
	
</body>
</html>