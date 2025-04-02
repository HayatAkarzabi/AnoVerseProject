<%--
  Created by IntelliJ IDEA.
  User: Clone
  Date: 4/2/2025
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>description</title>
  </head>
  <body>
  <h1>${film.title}</h1>
  <img src="${film.imageUrl}" width="200px" height="300px">
  <p><b>Genre :</b> ${film.genre}</p>
  <p><b>Durée :</b> ${film.year} min</p>
  <p><b>Réalisateur :</b> ${film.writer}</p>
  <p><b>Description :</b> ${film.description}</p>

  <a href="reservation?filmId=${film.id}">Réserver</a>

  </body>
</html>
