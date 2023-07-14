<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Las veces que has visitado</h1>
    <p><c:out value="${count}"/> contador</p>
    <a href="http://localhost:8080/">intenta otra visita</a>
    <a href="http://localhost:8080/cerrarsesion">Limpiar el contador</a>
    
</body>
</html>