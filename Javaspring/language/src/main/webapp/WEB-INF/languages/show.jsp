<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Show Language</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
        crossorigin="anonymous">
    <style>
        body {
            font-family: "Comic Sans MS", cursive, sans-serif;
        }
    </style>
</head>

<body>
    <header class="p-4">
        <div class="container-fluid d-flex justify-content-between">
            <h1 class="m-0">Name: <c:out value="${language.name}" /></h1>
            <a href="/language" class="btn btn-primary">Dashboard</a>
        </div>
    </header>

    <div class="container-fluid">
        <div class="row">
            <div class="col">
                <h1>Creator: <c:out value="${language.creator}" /></h1>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <h1>Language: <c:out value="${language.currentVersion}" /></h1>
            </div>
        </div>
    </div>

    <div class="container mt-3">
        <div class="row">
            <div class="col">
                <a href="/language/${language.id}/edit" class="btn btn-primary">Edit</a>
            </div>
            <div class="col">
                <form action="/language/${language.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </div>
        </div>
    </div>
</body>

</html>
