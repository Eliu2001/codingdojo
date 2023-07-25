<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Index</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    </head>

    <body class="bg-body-secondary d-flex flex-column justify-content-center align-items-center" style="height: 100vh;">

        <div class="container-fluid">
            <h1 class="text-center m-4">Persons and Licenses</h1>
            <div class="d-flex justify-content-between">
                <a href="/persons/new" class="btn btn-secondary col-5 p-3 fs-2 ">New Person</a>
                <a href="/licenses/new" class="btn btn-secondary col-5 p-3 fs-2 ">New License</a>
            </div>
            <div class="container">
                <h1 class="text-center mt-5 mb-3">Tabla de Licencias</h1>
                <table class="table table-bordered table-striped">
                    <thead class="thead-dark">
                        <tr>
                            <th>Name</th>
                            <th>License Number</th>
                            <th>State</th>
                            <th>Expiration Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${persons}" var="person">
                            <tr>
                                <td><a href="/persons/${person.id}"><c:out value="${person.firstName} ${person.lastName}" /></a></td>
                                <td><c:out value="${person.license.number}" /></td>
                                <td><c:out value="${person.license.state}" /></td>
                                <td><c:out value="${person.license.expirationDate}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Gn5384xqQ1aoW1TaGbRjvAKtZpLvkuV4MwUl/EmzC4z6a8C0F5GgFZGJNskYj4x"
            crossorigin="anonymous"></script>
    </body>

    </html>