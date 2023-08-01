<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
        
        <div class="row mt-3">
            <div class="col-md-4">
                <a href="/new" class="btn btn-primary">New Song</a>
                <a href="/topten" class="btn btn-primary ml-2">Top Songs</a>
            </div>
            <div class="col-md-8">
                <form action="/songs/searchbytitle" method="POST" class="d-flex align-items-center">
                    <div class="input-group">
                        <input type="text" class="form-control" name="artist">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary">Search artist</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <table class="table mt-3">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Artist</th>
                    <th>Rating</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="song" items="${table}">
                    <tr>
                        <td><a href="/songs/${song.id}">${song.title}</a></td>
                        <td>${song.artist}</td>
                        <td>${song.rating}</td>
                        <td>
                            <form action="/songs/${song.id}/delete" method="POST">
                                <input type="hidden" name="_method" value="DELETE">
                                <button class="btn btn-danger" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</body>
</html>
