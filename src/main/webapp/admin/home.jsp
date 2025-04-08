<%@ page import="java.util.List" %>
<%@ page import="Dao.*" %>
<%@ page import="Metier.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 29/03/2025
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <%@include file="CSS.jsp"%>
    <style>
        table {
            width: 100%; /* Le tableau occupe toute la largeur disponible */
            border-collapse: collapse; /* Fusionne les bordures des cellules pour un rendu plus propre */
            margin: 0 auto; /* Centre le tableau horizontalement */
        }
        th, td {
            border: 2px solid black; /* Bordures des cellules */
            padding: 8px; /* Espacement interne pour une meilleure lisibilité */
            text-align: center; /* Centre le texte à l'intérieur des cellules */
        }
    </style>

</head>
<body>
<%
    String message = (String) session.getAttribute("message");
    if (message != null) {
%>
<div id="message-alert" class="alert alert-success text-center">
    <%= message %>
</div>

<script>
    // Masquer le message après 4 secondes (4000 millisecondes)
    setTimeout(function() {
        var alertBox = document.getElementById("message-alert");
        if (alertBox) {
            alertBox.style.transition = "opacity 0.5s";
            alertBox.style.opacity = "0";
            setTimeout(() => alertBox.style.display = "none", 500);
        }
    }, 5000);
</script>

<%
        session.removeAttribute("message"); // Supprimer après affichage
    }
%>
<%@include file="SideBarra.jsp"%>
<!-- Contenu dynamique -->
<div id="content">
    <!-- affichage liste des animes -->
    <div id="all-animes-content" class="content-box">
        <div class="container-fluid mb-3">
            <div class="row align-items-center">
                <div class="col-md-4">
                    <!-- Colonne vide à gauche pour maintenir l'équilibre -->
                </div>
                <div class="col-md-4 text-center">
                    <h2>Liste des Films</h2>
                </div>
                <div class="col-md-4 text-end">
                    <a href="add%20film.jsp" class="btn btn-primary">
                        <i class="fa-solid fa-plus"></i> Ajouter Film
                    </a>
                </div>
            </div>
        </div>

        <div class="container mt-4">
            <div class="row">
                <%
                    ImplFilm implFilm = new ImplFilm();
                    List<Film> films = implFilm.getAllFilms();
                    if (films != null) {
                        for (Film film : films) {
                %>
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <img src="../<%= film.getImageUrl() %>" class="card-img-top" alt="Affiche du film">
                        <div class="card-body text-center">
                            <h5 class="card-title"><%= film.getTitle() %></h5>
                            <a href="DetailFilm.jsp?id=<%= film.getId() %>" >Voir Détails</a>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </div>





</div>
</body>
</html>
