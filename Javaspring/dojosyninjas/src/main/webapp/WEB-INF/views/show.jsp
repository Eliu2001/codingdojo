<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Show Dojo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
        crossorigin="anonymous">
</head>

<body>
    <div class="container text-center mt-5">
        <h1>Show Dojo</h1>
        <h2>${dojos.name}</h2>
    </div>

    <div class="container mt-5">
        <h3>Ninjas in this Dojo:</h3>
        <table class="table table-striped table-responsive">
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dojos.ninjas}" var="ninja">
                    <tr>
                        <td>${ninja.firstName}</td>
                        <td>${ninja.lastName}</td>
                        <td>${ninja.age}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>

</html>
