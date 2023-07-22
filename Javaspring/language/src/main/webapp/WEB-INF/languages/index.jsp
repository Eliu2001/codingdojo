<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>languages</title>
            <link rel="stylesheet" href="css/styindex.css">
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
            <div class="container-fluid">
                <div class="m-4 align-content-center">
                    <table class="table table-ligth table-striped ">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Creator</th>
                                <th>Current Version</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${languages}" var="lang">
                                <tr>
                                    <td><a href="/language/${lang.id}">${lang.name}</a></td>
                                    <td>
                                        <c:out value="${lang.creator}" />
                                    </td>
                                    <td>
                                        <c:out value="${lang.currentVersion}" />
                                    </td>
                                    <td>
                                        <a href="/language/${lang.id}/edit" class="btn btn-primary">Edit</a>
                                        <form class="d-inline" action="/language/${lang.id}" method="post">
                                            <input type="hidden" name="_method" value="delete">
                                            <input type="submit" value="Delete" class="btn btn-danger">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="text-center">
                        <h1>New Language</h1>
                        <form action="/add" method="post" class="mx-auto" style="max-width: 300px;">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name:</label>
                                <input type="text" name="name" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label for="creator" class="form-label">Creator:</label>
                                <input type="text" name="creator" class="form-control" required>
                            </div>
                            <div class="mb-3">
                                <label for="currentVersion" class="form-label">Current Version:</label>
                                <input type="text" name="currentVersion" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>