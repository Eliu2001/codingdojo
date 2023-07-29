<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
    <div class="container-xxl">
        <table class=" table table-striped table-bordered border-black">
            <thead>
                <th>Country Name</th>
                <th>Population</th>
            </thead>
            <tbody>
                <c:forEach var="row" items="${table}">
                    <tr>
                        <td>${row[0]}</td>
                        <td>${row[1]}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="container">
        <h1>Página de Inicio</h1>
        <!-- Botón que te lleva a la pantalla de inicio -->
        <a href="/" class="btn btn-primary">Ir a Inicio</a>
</body>
</html>