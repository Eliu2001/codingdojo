<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Song Details</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Song Details</h1>
        <table class="table">
            <tr>
                <th>Title:</th>
                <td>${song.title}</td>
            </tr>
            <tr>
                <th>Artist:</th>
                <td>${song.artist}</td>
            </tr>
            <tr>
                <th>Rating:</th>
                <td>${song.rating}</td>
            </tr>
        </table>
        <a href="/dashboard" class="btn btn-secondary">Back to Dashboard</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
