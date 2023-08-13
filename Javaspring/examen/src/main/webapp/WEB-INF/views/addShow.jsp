<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isErrorPage="true" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="ISO-8859-1">
						<title></title>
						<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
							rel="stylesheet"
							integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
							crossorigin="anonymous">
					</head>

					<body>
						<div class="container-fluid row align-items-center justify-content-center vh-100 bg-black bg-opacity-75 m-0">
							<div class="col-6">
								<form:form accept-charset="UTF-8" action="/shows/new" method="post"
									modelAttribute="show">
									<div class="mb-4">
										<form:label class="form-label" path="name">Title: </form:label>
										<form:input class="form-control" path="name" />
										<form:errors path="name" />
										<c:if test="${not empty showExistsError}">
											<p>${showExistsError}</p>
										</c:if>
									</div>
									<div class="mb-4">
										<form:label class="form-label" path="network">Network:</form:label>
										<form:input class="form-control" path="network" />
										<form:errors path="network" />
									</div>
									<input type="hidden" id="user" name="user" value="${userId}" />
									<div class="mb-4 d-inline-block"><input type="submit" value="Create"
											class="btn btn-primary" />
									</div>


								</form:form>

							</div>

						</div>



					</body>

					</html>