<%@ page import="java.util.List" %>
<%@ page import="Dao.*" %>
<%@ page import="Metier.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 07/04/2025
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seances</title>
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

<div id="seances-content" class="content-box">
    <div class="row align-items-center">
        <div class="col-md-4">
            <!-- Colonne vide à gauche pour maintenir l'équilibre -->
        </div>
        <div class="col-md-4 text-center">
            <h2>Liste des Seances Disponibles</h2>
        </div>
        <div class="col-md-4 text-end">
            <a href="addSeance.jsp" class="btn btn-primary">
                <i class="fa-solid fa-plus"></i> Ajouter Seance
            </a>
        </div>
    </div>
    <div>
        <div class="container my-4">
            <%
                ImplISeance seanceDao = new ImplISeance();
                List<Seance> seances = seanceDao.afficherListSeance();

                if(seances != null && !seances.isEmpty()) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

                    for(Seance seance : seances) {
                        Film film = seance.getFilm();
                        Salle salle = seance.getSalle();
            %>

            <div class="card seance-card">
                <div class="card-header d-flex justify-content-between align-items-center">
                    <span>Séance #<%= seance.getId() %></span>
                    <span class="date-info"><%= seance.getDate().format(formatter) %></span>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-3">
                            <% if(film != null && film.getImageUrl() != null) { %>
                            <img src="../<%= film.getImageUrl() %>" alt="<%= film.getTitle() %>" class="img-fluid film-img rounded">
                            <% } else { %>
                            <img src="/api/placeholder/300/200" alt="Image non disponible" class="img-fluid film-img rounded">
                            <% } %>
                        </div>
                        <div class="col-md-9">
                            <h5 class="card-title">
                                <% if(film != null) { %>
                                <%= film.getTitle() %>
                                <% } else { %>
                                Film non spécifié
                                <% } %>
                            </h5>
                            <p class="card-text">
                                <strong>Salle:</strong>
                                <% if(salle != null) { %>
                                <%= salle.getNumero() %> (Capacité: <%= salle.getCapacite() %> places)
                                <% } else { %>
                                Non assignée
                                <% } %>
                            </p>
                            <p class="card-text">
                                <strong>Places réservées:</strong>
                                <%= seance.getReservations() != null ? seance.getReservations().size() : 0 %>
                                <% if(salle != null) { %>
                                sur <%= salle.getCapacite() %>
                                <% } %>
                            </p>
                            <div class="mt-3">
                                <a href="modifierSeance.jsp?id=<%= seance.getId() %>" class="btn ms-2">Modifier</a>
                                <a href="../supprimerSeance?id=<%= seance.getId() %>">Supprimer</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    <% if(seance.getDate().isAfter(java.time.LocalDateTime.now())) { %>
                    <span class="badge bg-success">À venir</span>
                    <% } else { %>
                    <span class="badge bg-secondary">Passée</span>
                    <% } %>
                </div>
            </div>

            <%
                }
            } else {
            %>
            <div class="alert alert-info" role="alert">
                Aucune séance n'est disponible pour le moment.
            </div>
            <% } %>

            <div class="text-center mt-4">
                <a href="home.jsp" class="btn btn-secondary ms-2">Retour à l'accueil</a>
            </div>
        </div>
    </div>

</div>
</body>
</html>
