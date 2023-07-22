<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Language</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <style>
        .container {
            margin-top: 20px;
        }
        .delete-dashboard-links {
            display: flex;
            justify-content: flex-end;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="delete-dashboard-links">
            <a href="/language" class="btn btn-primary me-2">Dashboard</a>
            <form action="/language/${language.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input type="submit" class="btn btn-danger" value="Delete">
            </form>
        </div>
        <form:form action="/language/${language.id}" method="post" modelAttribute="language" class="container">
            <input type="hidden" name="_method" value="PUT">
            <p>
                <form:label path="name">Name</form:label>
                <form:errors path="name" />
                <form:input path="name" class="form-control" />
            </p>
            <p>
                <form:label path="creator">Creator</form:label>
                <form:errors path="creator" />
                <form:input path="creator" class="form-control" />
            </p>
            <p>
                <form:label path="currentVersion">Current Version</form:label>
                <form:errors path="currentVersion" />
                <form:input type="number" path="currentVersion" class="form-control" />
            </p>
            <input type="submit" value="Submit" class="btn btn-primary" />
        </form:form>
    </div>
</body>
</html>
