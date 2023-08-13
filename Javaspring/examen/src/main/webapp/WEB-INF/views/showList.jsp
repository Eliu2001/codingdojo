<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isErrorPage="true" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
				<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
					<!DOCTYPE html>
					<html>

					<head>
						<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
							rel="stylesheet"
							integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
							crossorigin="anonymous">
						<meta charset="ISO-8859-1">
						<title></title>
					</head>

					<body>
						<div class="container-fluid row align-items-center justify-content-center vh-100 bg-black bg-opacity-75 m-0">
							<div class="col-8">
								<div class="col text-center text-white mb-5">
									<h1 class="">Welcome, ${user.name}!</h1>
								</div>
								<div class="col text-white">
									<h2>Shows</h2>
								</div>
								<table class="table table-responsive table-striped table-dark">
									<thead>
										<tr>
											<th>Show</th>
											<th>Network</th>
											<th>Avg Rating</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${showList}" var="show" varStatus="loop">
											<tr>
												<td><a href="/shows/${show.id}">
														<c:out value="${show.name}" />
													</a></td>
												<td>
													<c:out value="${show.network}" />
												</td>
												<td>
													<c:out value="${averages[loop.index]}" />
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<div class="col d-block">
									<form action="/shows/new" method="GET">
										<input type="submit" value="ADD" class="btn btn-primary">
									</form>
								</div>
							</div>


					</body>