<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="${pageContext.request.contextPath }/emp/${emp.id }" method="POST" modelAttribute="emp">
		
		<c:if test="${emp.id == null }">
		LastName: <form:input path="lastName"/>
		<br><br>
		</c:if>
		
		<c:if test="${emp.id != null }">
		<form:hidden path="id"/>
		<input type="hidden" name="_method" value="PUT"/>
		</c:if>
		
		Email: <form:input path="email"/>
		<br><br>
		
		<% 
			Map<String, Object> genders = new HashMap();
			genders.put("1", "Male");
			genders.put("0", "Female");
			
			request.setAttribute("genders", genders);
		%>
		Gender: <form:radiobuttons path="gender" items="${genders }"/>
		<br><br>
		
		Department: 
		<form:select items="${depts }" itemLabel="departmentName" itemValue="id" path="department.id"></form:select>
		<br><br>
		
		<input type="submit" value="Submit"/>
		
	</form:form>

</body>
</html>