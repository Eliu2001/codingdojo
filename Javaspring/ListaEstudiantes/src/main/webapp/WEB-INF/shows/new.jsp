<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
	<div class="container">
		<form:form accept-charset="UTF-8" action="/contact/new" method="post"
		modelAttribute="contact">
		<h1>Contact info</h1>
		<p>
			<c:choose>
				<c:when test="${empty students}">
				
				<select name="persona" id="persona1">
						<option >No hay estudiantes</option>
					</select>		      		
		    </c:when>
				<c:otherwise>
					<select name="student" id="student">
						<c:forEach items="${students}" var="student">
							<option value="${student.id}">${student.firstName} ${student.lastName}</option>
						</c:forEach>
					</select>
				</c:otherwise>
			</c:choose>
		</p>
		<p>
			<form:label path="address">Address:</form:label>
			<form:errors path="address" />
			<form:input id="input2" path="address" />
		</p>
		<p>
			<form:label path="city">City:</form:label>
			<form:errors path="city" />
			<form:input id="input2" path="city" />
		</p>
		<p>
			<form:label path="state">State:</form:label>
			<form:errors path="state" />
			<form:input id="input2" path="state" />
		</p>

		<input id="create2" type="submit" value="Create" />
	</form:form>
	</div>

</body>
</html>