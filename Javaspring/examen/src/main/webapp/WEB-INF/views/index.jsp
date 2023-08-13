<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ page isErrorPage="true" %>
		<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
			<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
				<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
						<div class="container-fluid row justify-content-center align-items-center bg-black bg-opacity-75 vh-100">
							<div class="row">
								<div class="col">
									<h1 class="text-white text-start mb-4">Register</h1>
									<form:form accept-charset="UTF-8" action="/registration" method="post"
										modelAttribute="user">
										<div class="mb-4">
											<form:label path="name" class="form-label text-white">Name: </form:label>
											<form:input path="name" class="form-control" />
											<p><form:errors path="name" /></p>
										</div>
										<div class="mb-4">
											<form:label path="email" class="form-label text-white">Email: </form:label>
											<form:input path="email" class="form-control" />
											<form:errors path="email" />
										</div>
										<div class="mb-4">
											<form:label path="password" class="form-label text-white">Password: </form:label>
											<form:input type="password" path="password" class="form-control" />
										</div>
										<div class="mb-4">
											<form:label path="passwordConfirmation" class="form-label text-white">Password Confirmation: </form:label>
											<form:input type="password" path="passwordConfirmation"
												class="form-control" />
											<form:errors path="passwordConfirmation" />
										</div>
										<div class="d-grid">
											<button type="submit" class="btn btn-primary">Sign Up</button>
										</div>
									</form:form>
								</div>
								<div class="col">
									<h1 class="text-white text-start mb-4">Login</h1>
									<form method="post" action="/login">
										<div class="mb-4">
											<label for="email" class="form-label text-white">Email</label>
											<input type="text" id="email" class="form-control" name="email" />
										</div>
										<div class="mb-4">
											<label class="form-label text-white" for="password ">Password</label>
											<input type="password" id="password" name="password" class="form-control " />
										</div>
										<div class="d-grid">
											<button type="submit" value="Login!" class="btn btn-primary">Sign
												In</button>
										</div>
									</form>
									<div class="mb-4">
										<c:out value="${error}" />
									</div>
								</div>
							</div>
						</div>
					</body>

					</html>