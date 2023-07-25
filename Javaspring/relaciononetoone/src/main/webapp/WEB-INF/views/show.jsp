<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Show Person and License</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <div class="m-4">
            <h1 class="mb-4">Nombre del person: <c:out value="${person.firstName} ${person.lastName}" /></h1>
            <p><strong>License Number:</strong> <c:out value="${person.license.number}" /></p>
            <p><strong>State:</strong> <c:out value="${person.license.state}" /></p>
            <p><strong>Expiration Date:</strong> <c:out value="${person.license.expirationDate}" /></p>
            <hr>

            <a href="/dashboard" class="btn btn-primary">Dashboard</a>
        </div>
    </div>
</body>
</html>