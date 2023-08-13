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
						<div class="container-fluid row bg-black bg-opacity-75 vh-100 m-0 align-items-center justify-content-center">
							<div class="col">
								<div class="col text-start text-white mb-4">
									<h1>
										<c:out value="${show.name}" />
									</h1>
								</div>
								<div class="col text-white mb-4">
									<h2>
										Network:
										<c:out value="${show.network}" />
									</h2>
								</div>

								<table class="table table-dark table-striped table-responsive">
									<thead>
										<tr>
											<th>Name</th>
											<th>Rating</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${ratings}" var="notas">
											<tr>
												<td>
													<c:out value="${notas[0]}" />
												</td>
												<td>
													<c:out value="${notas[1]}" />
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="col">
									<c:choose>
										<c:when test="${show.user.id == user.id}">
											<a class="btn btn-primary" href="/shows/${show.id}/edit">Editar</a>
										</c:when>
										<c:otherwise>

										</c:otherwise>
									</c:choose>
								</div>
								<div class="col">
									<c:choose>
										<c:when test="${show.usersJoin.contains(user)}">
											<h2>Rated</h2>
										</c:when>
										<c:otherwise>
											<form action="/shows/${show.id}/rate" method="post">
												<label class="form-label" for="rating">Rating (1.0 - 5.0):</label>
												<input class="form-floating" type="number" step="0.1" min="1" max="5"
													name="rating" required>
												<button class="btn btn-primary" type="submit">Rate!</button>
											</form>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
						</div>
					</body>

					</html>