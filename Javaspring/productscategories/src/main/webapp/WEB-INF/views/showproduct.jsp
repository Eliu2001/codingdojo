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

	<h1>
		<c:out value="${product.name}"></c:out>
	</h1>
			<h2>categories: </h2>
			<ul> 
			<c:forEach items="${product.categories}" var="category">
				<li>${category.name}</li>
			</c:forEach>
			</ul>
<form:form accept-charset="UTF-8" action="/product_category/${product.id}" method="post"
		modelAttribute="category_product">
		<p>
			add category:

					<select name="category" id="category">
						<c:forEach items="${categories}" var="category">
							<option value="${category.id}">${category.name}</option>
						</c:forEach>
					</select>
		</p>
		<form:input type="hidden" path="product" value="${product.id}"/>
		<input id="create2" type="submit" value="Add" />
	</form:form>
			


</body>
</html>