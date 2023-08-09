<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<table id="table">
			<thead id="thead">
				<tr id="">
					<th class="col">Name</th>
					<th class="col">Age</th>
					<th class="col">Adress</th>
					<th class="col">City</th>
					<th class="col">State</th>
				</tr>
			</thead>
			<tbody>
				<%-- Mostrar los lenguajes reales --%>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.student.firstName} ${contact.student.lastName}</td>
						<td>${contact.student.age}</td>
						<td>${contact.address}</td>
						<td>${contact.city}</td>
						<td>${contact.state}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
