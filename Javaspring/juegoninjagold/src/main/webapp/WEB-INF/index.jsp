<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <!DOCTYPE html>
        <html>

        <head>
            <title>Ninja Money Maker</title>
            <link rel="stylesheet" href="css/style.css">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
                crossorigin="anonymous">

        </head>

        <body>
            <div class="container-fluid p-2">


                <div class="col-3 d-inline">
                    <h3 class="d-inline">Gold:
                    </h3>
                    <h3 class="d-inline">
                        <%= session.getAttribute("gold") %>
                    </h3>



                    <div class="row p-4 justify-content-center mx-3">
                        <div class="col-2 p-4 caja text-center">
                            <h3>Granja</h3>
                            <p>Generar entre 10 y 20 de oro</p>
                            <form action="actividades" method="post">
                                <button class="btn btn-light border-black border-2 btn-lg" type="submit" name="place"
                                    value="farm">Go to Farm</button>
                            </form>
                        </div>
                        <div class="col-2 p-1 caja text-center mx-3">
                            <h3>Cueva</h3>
                            <p>Generar entre 5 y 10 de oro</p>
                            <form action="actividades" method="post">
                                <button class="btn btn-light border-black border-2 btn-lg" type="submit" name="place"
                                    value="cave">Go to Cave</button>
                            </form>
                        </div>
                        <div class="col-2 p-1 caja text-center mx-3">
                            <h3>Casa</h3>
                            <p>Generar entre 2 y 5 de oro</p>
                            <form action="actividades" method="post">
                                <button class="btn btn-light border-black border-2 btn-lg" type="submit" name="place"
                                    value="house">Go to House</button>
                            </form>
                        </div>
                        <div class="col-2 p-1 caja text-center mx-3">
                            <h3>Casino</h3>
                            <p>Ganas o pierdes entre 0 y 50 </p>
                            <form action="actividades" method="post">
                                <button class="btn btn-light border-black border-2 btn-lg" type="submit" name="place"
                                    value="casino">Go to Casino</button>
                            </form>
                        </div>
                    </div>
                </div>

                <div id="activities-box">
                    <h2>Activities:</h2>
                    <ul>
                        <% for (String activity : (List<String>) session.getAttribute("activities")) { %>
                            <% if (activity.contains("ganado") && !activity.contains("perdido")) { %>
                                <li class="ganancia">
                                    <%= activity %>
                                </li>
                                <% } else { %>
                                    <li class="perdida">
                                        <%= activity %>
                                    </li>
                                    <% } %>
                                        <% } %>
                    </ul>
                </div>
        </body>

        </html>