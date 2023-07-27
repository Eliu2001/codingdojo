<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<form:form accept-charset="UTF-8" action="/products/new" method="post"
		modelAttribute="product">
		<h1>New product</h1>
		<p>
			<form:label path="name">Name:</form:label>
			<form:errors path="name" />
			<form:input id="input2" path="name" />
		</p>
		
		<p>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" />
			<form:input id="input2" path="description" />
		</p>
		<p>
			<form:label path="price">Price:</form:label>
			<form:errors path="price" />
			<form:input id="input2" path="price" />
		</p>
		<input id="create2" type="submit" value="Create" />
	</form:form>
	</div>

</body>
</html>