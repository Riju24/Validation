<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Enter Information of Student</h1>
	${msg }
	<table align="center">
	<form:form action="insert" method="post" modelAttribute="student">
		<tr>
			<td><form:label path="id">Id</form:label></td>
			<td><form:input path="id" /></td>
			<td><form:errors path="id" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><form:label path="name">Name</form:label></td>
			<td><form:input path="name" /></td>
			<td><form:errors path="name" cssStyle="color: red;" /></td>
		</tr>
		
		<tr>
			<td><form:label path="course">Course</form:label></td>
			<td><form:input path="course" />
			<td><form:errors path="course" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><form:label path="address.houseNo">House No</form:label></td>
			<td><form:input path="address.houseNo" /></td>
			<td><form:errors path="address.houseNo" cssStyle="color: red;" /></td>
		</tr>
		<tr>
			<td><form:label path="address.city">City</form:label></td>
			<td><form:input path="address.city" /></td>
			<td><form:errors path="address.city" cssStyle="color: red;" /></td>
			
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="submit" /></td>
			<td><input type="reset" name="reset" value="reset" style ="float:right";/></td>
		</tr>

	</form:form>
	</table>
</body>
</html>