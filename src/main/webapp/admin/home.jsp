<%@ page import="Metier.Film" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.ImplFilm" %>
<%@ page import="Dao.ImplUser" %>
<%@ page import="Metier.User" %><%--
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

<div class="main_box">
    <input type="checkbox" id="check">
    <div class="btn_one">
        <label for="check">
            <i class="fas fa-bars"></i>
        </label>
    </div>
    <div class="sidebr_menu">
        <div class="logodiv">
            <img src="b.jpg" class="logo">
        </div>
        <div class="btn_two">
            <label for="check">
                <i class="fas fa-times"></i>
            </label>
        </div>
        <div class="menu">
            <ul>
                <li><a href="#" id="all-animes"><i class="fa-solid fa-video "></i>gestion Animes</a></li>
                <li><a href="#" id="reservations"><i class="fas fa-plus-square "></i>gestion Reservations</a></li>
                <li><a href="#" id="sales"><i class="fa-solid fa-ticket "></i> Sales</a></li>
                <li><a href="#" id="add-user"><i class="fa-solid fa-user-plus "></i> gestion users</a></li>
                <li><a href="#" id="logout"> <i class="fa-solid fa-arrow-right-to-bracket "></i> Log Out</a></li>
            </ul>
        </div>
    </div>
</div>
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
                        <i class="fa-solid fa-plus"></i> Add Film
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

    <div id="all-reservation-content" class="content-box">


    </div>
    <!-- rapport des ventes  -->
    <div id="sales-content" class="content-box">
        <h2>Sales</h2>
        <p>Rapport des ventes...</p>
    </div>
    <!-- ajouter un utilisateur ou un film -->
    <div id="add-user-content" class="content-box">
        <h2 class="text-center">gestion users</h2>
        <%--            <%--%>
        <%--                ImplUser implUser = new ImplUser();--%>
        <%--                List<User> users = implUser.AllUsers();--%>
        <%--                if (users != null) {--%>
        <%--                    for (User u : films) {--%>
        <%--            %>--%>
        <%--                    --%>


        <%--            <%--%>
        <%--                    }--%>
        <%--                }--%>
        <%--            %>--%>
    </div>
    <!-- pour logout -->
    <div id="logout-content" class="content-box">
        <h2>Log Out</h2>
        <p>Déconnexion en cours...</p>
    </div>
</div>

<script>
    document.addEventListener("DOMContentLoaded", function () {
        // Cacher tout le contenu au début
        let sections = document.querySelectorAll(".content-box");
        sections.forEach(section => section.style.display = "none");

        // Afficher la section "All Films" par défaut
        document.getElementById("all-animes-content").style.display = "block";

        // Fonction pour afficher la section correspondante
        function showSection(sectionId) {
            sections.forEach(section => section.style.display = "none"); // Cacher tout
            document.getElementById(sectionId).style.display = "block"; // Afficher la section cliquée
        }

        // Ajout des événements sur les liens
        document.getElementById("all-animes").addEventListener("click", function () {
            showSection("all-animes-content");
        });

        document.getElementById("reservations").addEventListener("click", function () {
            showSection("all-reservation-content");
        });

        document.getElementById("sales").addEventListener("click", function () {
            showSection("sales-content");
        });

        document.getElementById("add-user").addEventListener("click", function () {
            showSection("add-user-content");
        });

        document.getElementById("logout").addEventListener("click", function () {
            showSection("logout-content");
        });
    });

</script>
</body>
</html>
