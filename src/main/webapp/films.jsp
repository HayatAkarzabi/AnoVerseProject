<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Liste des Films</title>
</head>
<body>
<h1>Liste des Films</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Genre</th>
        <th>Année</th>
        <th>Réalisateur</th>
        <th>Acteurs</th>
        <th>Scénariste</th>
    </tr>
    <c:forEach var="film" items="${films}">
        <tr>
            <td>${film.id}</td>
            <td>${film.title}</td>
            <td>${film.genre}</td>
            <td>${film.year}</td>
            <td>${film.director}</td>
            <td>${film.actors}</td>
            <td>${film.writer}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
