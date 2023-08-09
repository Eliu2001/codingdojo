<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student</title>
</head>
<body>
	<div class="container">
		<h1>New Person</h1>
		<form:form action="/student/new" method="post" modelAttribute="student">
			<p>
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" />
				<form:input class="input1" path="firstName" />
			</p>
			<p>
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName" />
				<form:input class="input1" path="lastName" />
			</p>
			<p>
				<form:label path="age">Age:</form:label>
				<form:errors path="age" />
				<form:input class="input1" path="age" />
			</p>
			<input type="submit" value="Create" id="create1" />
		</form:form>
	</div>
</body>
</html>