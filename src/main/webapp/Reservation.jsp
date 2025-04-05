<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Réservation de Film</title>
    <link rel="stylesheet" href="Component/css/reservation.css">
</head>
<body>
<div class="reservation-container">
    <c:if test="${not empty film}">
        <h1>Réservation pour : ${film.title}</h1>
        <p><strong>Genre:</strong> ${film.genre}</p>
        <p><strong>Année:</strong> ${film.year}</p>
        <p><strong>Réalisateur:</strong> ${film.director}</p>
        <p><strong>Acteurs:</strong> ${film.actors}</p>
        <p><strong>Description:</strong> ${film.description}</p>
        <img src="${film.imageUrl}" alt="${film.title}" class="film-image">

        <h2>Formulaire de Réservation</h2>
        <form action="reservation" method="POST">
            <input type="hidden" name="filmId" value="${film.id}">

            <label for="userName">Nom :</label>
            <input type="text" id="userName" name="userName" required>

            <label for="userEmail">Email :</label>
            <input type="email" id="userEmail" name="userEmail" required>
            <label for="nombreDeTickets">Nombre de tickets :</label>
            <input type="number" id="nombreDeTickets" name="nombreDeTickets" required>

            <button type="submit">Réserver</button>
        </form>
    </c:if>
</div>
</body>
</html>