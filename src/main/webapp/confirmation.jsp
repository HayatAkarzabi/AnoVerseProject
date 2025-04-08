<%--
  Created by IntelliJ IDEA.
  User: Clone
  Date: 4/5/2025
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Confirmation de réservation</title>
    <%@include file="Component/CSS.jsp" %>
    <link rel="stylesheet" href="Component/css/confirmation.css">
</head>
<body>
<header>
    <%@include file="Component/navbar.jsp" %><br><br>
</header>
<main>
    <div class="confirmation-container">
        <h1>Confirmation de Réservation</h1>
        <p>Merci pour votre réservation ! Voici les détails :</p>
        <ul>
            <li><strong>Film :</strong> ${film.title}</li>
            <li><strong>Date de la séance :</strong> ${dateFormatee}</li>

            <li><strong>Nombre de places réservées :</strong> ${nbPlaces}</li>
            <li><strong>Salle :</strong> ${salle.getNumero()}</li>
        </ul>
        <a href="index.jsp">Retour à l'accueil</a>
    </div>
</main>
</body>
</html>
