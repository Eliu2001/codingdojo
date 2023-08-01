<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Song</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<form:form accept-charset="UTF-8" action="/add" method="post" modelAttribute="song">
    <h1>New product</h1>
    <p>
        <form:label path="title">Title:</form:label>
        <form:errors path="title" />
        <form:input id="input2" path="title" />
    </p>
    <p>
        <form:label path="artist">Artist:</form:label>
        <form:errors path="artist" />
        <form:input id="input2" path="artist" />
    </p>
    <p>
        <form:label path="rating">Rating:</form:label>
        <form:errors path="rating" />
        <form:input id="input2" path="rating" />
    </p>
    <input type="hidden" name="id" value="0" />
    <!-- El campo "id" debe ser hidden y su valor debe ser un número válido (por ejemplo, 0 para un nuevo registro) -->
    <input id="create2" type="submit" value="Create" />
</form:form>
	</div>

</body>
</html>