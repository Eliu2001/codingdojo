<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isErrorPage="true" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="ISO-8859-1">
						<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
							rel="stylesheet"
							integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
							crossorigin="anonymous">
						<title></title>
					</head>

					<body>
						<div
							class="container-fluid row align-items-center justify-content-center bg-black bg-opacity-75 vh-100 m-0">
							<div class="col">
								<div class=" col text-white text-start mb-4">
									<h1>
										<c:out value="${show.name}" />
									</h1>
								</div>
								<form:form method="POST" action="/shows/${show.id}/edit" modelAttribute="show">
									<div class="mb-4">
										<form:label path="name" class="form-label">Titulo:</form:label>
										<form:input type="name" path="name" class="form-control"/>
										<form:errors path="name" />
									</div>

									<div class="mb-4">
										<form:label path="network" class="form-label">Network:</form:label>
										<form:input type="network" class="form-control" path="network" />
										<form:errors path="network" />
									</div>
									<div class="mb-4">
										<input type="submit" value="Update" class="btn btn-primary" />
									</div>
								</form:form>
								<form:form method="POST" action="/shows/${show.id}/delete">
									<input type="submit" value="Delete" class="btn btn-danger" />
								</form:form>
							</div>
						</div>

					</body>

					</html>