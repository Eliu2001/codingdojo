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
		<c:out value="${category.name}"></c:out>
	</h1>
			<h2>products </h2>
			<ul> 
			<c:forEach items="${category.products}" var="product">
				<li>${product.name}</li>
			</c:forEach>
			</ul>
<form:form accept-charset="UTF-8" action="/category_product/${category.id}" method="post"
		modelAttribute="product_category">
		<p>
			add product:

					<select name="product" id="product">
						<c:forEach items="${products}" var="product">
							<option value="${product.id}">${product.name}</option>
						</c:forEach>
					</select>
		</p>
		<form:input type="hidden" path="category" value="${category.id}"/>
		<input id="create2" type="submit" value="Add" />
	</form:form>
			


</body>
</html>