<%--
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
--%>



<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Réservation - ${film.title}</title>

    <%@include file="Component/CSS.jsp" %>
    <link rel="stylesheet" href="Component/css/reservation.css">

    <script>
        const placesMap = {};
        <c:forEach var="seance" items="${seances}">
        placesMap["${seance.id}"] = ${seance.placesDisponibles};
        </c:forEach>

        function updatePlacesDisponibles() {
            const seanceId = document.getElementById("seanceId").value;
            const placesRestantes = placesMap[seanceId] || 0;
            document.getElementById("placesRestantes").innerText = "Places restantes : " + placesRestantes;
            document.getElementById("maxPlaces").value = placesRestantes;
            document.getElementById("placesInput").max = placesRestantes;
        }
    </script>
</head>
<body>
<header>
    <%@include file="Component/navbar.jsp" %><br><br>
</header>
<main>
    <div class="reservation-container">
        <h1>Réserver pour: ${film.title}</h1>

        <h2>Séances disponibles</h2>
        <c:if test="${not empty message}">
            <p>${message}</p>
        </c:if>

        <!-- Formulaire de réservation -->
        <form action="validerReservation" method="post">
            <%-- @declare id="seanceid" --%>

            <input type="hidden" name="filmId" value="${film.id}" />
            <label for="seanceId">Choisir une séance :</label>
                <select id="seanceId" name="seanceId" onchange="updatePlacesDisponibles()">
                <option value="">Sélectionnez une séance</option>
                <c:forEach items="${seances}" var="seance">
                    <option value="${seance.id}">
                        <!-- Utiliser fmt:formatDate pour formater la date -->
                        ID: ${seance.id} - DATE: ${seance.date} - FORMAT: ${seance.formattedDate} -  - Places: ${seance.placesDisponibles}
                    </option>
                </c:forEach>
            </select>



                <div id="placesRestantes">Places restantes : </div>

                <label for="placesInput">Nombre de tickets à réserver :</label>
                <input type="number" id="placesInput" name="nbPlaces" min="1" required />
                <input type="hidden" id="maxPlaces" />

                <button type="submit">Valider</button>
        </form>
    </div>
</main>
</body>
</html>
