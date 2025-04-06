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

<div class="main_box">
    <input type="checkbox" id="check">
    <div class="btn_one">
        <label for="check">
            <i class="fas fa-bars"></i>
        </label>
    </div>
    <div class="sidebr_menu">
        <div class="logodiv">
            <img src="logo1.jpeg" class="logo">
        </div>
        <div class="btn_two">
            <label for="check">
                <i class="fas fa-times"></i>
            </label>
        </div>
        <div class="menu">
            <ul>
                <li><a href="#" id="all-animes"><i class="fa-solid fa-video "></i>Gestion Fimles</a></li>
                <li><a href="#" id="reservations"><i class="fa-solid fa-ticket "></i>Gestion Reservations</a></li>
                <li><a href="#" id="sales"><i class="fa-solid fa-person-shelter"></i>Gestion Salles</a></li>
                <li><a href="#" id="add-user"><i class="fa-solid fa-users"></i>Gestion users</a></li>
                <li><a href="#" id="paiments"><i class="fa-solid fa-money-bill"></i>Paiements</a></li>
                <li><a href="#" id="seances"><i class="fa-solid fa-tv"></i>Gestion seances</a></li>
                <li><a href="../index.jsp" id="logout"> <i class="fa-solid fa-arrow-right-to-bracket "></i> Log Out</a></li>

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

        <div class="container-fluid py-4">
            <div class="row mb-4">
                <div class="col">
                    <h2 class="text-center"><i class="fas fa-ticket-alt me-2"></i>Gestion des Réservations</h2>
                </div>
            </div>





            <!-- Tableau des réservations -->
            <div class="row">
                <div class="col-12">
                    <div class="card shadow-sm">
                        <div class="card-header bg-white d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">Liste des Réservations</h5>
                        </div>
                        <div class="card-body p-0">
                            <div class="table-responsive">
                                <table class="table table-hover mb-0">
                                    <thead class="table-light">
                                    <tr>
                                        <th>ID</th>
                                        <th>Client</th>
                                        <th>Séance</th>
                                        <th>Date Réservation</th>
                                        <th>Places</th>
                                        <th>Paiement</th>
                                        <th>Montant</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                <tbody>
                                <%
                                    ImplIReservation implIReservation = new ImplIReservation();
                                    List<Reservation> reservations = implIReservation.afficherTousReservations();
                                    if (reservations != null&& !reservations.isEmpty()) {
                                        for (Reservation reservation : reservations) {
                                %>
                                <tr>
                                    <td><%=reservation.getId()%></td>
                                    <td><div><%=reservation.getUser().getEmail()%></div></td>
                                    <td><div>ID: <%=reservation.getSeance().getId()%></div></td>
                                    <td>
                                        <%= new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(reservation.getDateReservation()) %>
                                    </td>
                                    <td><%=reservation.getNombrePlaces()%></td>
                                    <td>
                                            <span class="badge bg-success badge-payment">
                                                <%=reservation.getPaiement().getMéthode()%>
                                            </span>
                                    </td>
                                    <td><%=reservation.getPaiement().getMontant()%></td>
                                    <td class="action-buttons">
                                        <div class="btn-group">
                                            <a href="../AdminDeleteReservationServlet?id=<%=reservation.getId()%>">
                                                <i class="fas fa-trash"></i>
                                            </a>
                                        </div>
                                    </td>
                                </tr>
                                <%
                                        }
                                    }else {
                                %>
                                <tr>
                                    <td colspan="8" class="text-center py-4">
                                        <div class="text-muted">
                                            <i class="fas fa-info-circle me-2"></i>Aucune réservation trouvée
                                        </div>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>


                                </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!-- Scripts -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
        <script>
            // Script pour les modals
            document.addEventListener('DOMContentLoaded', function() {
                // Modal de paiement
                const addPaymentModal = document.getElementById('addPaymentModal');
                if (addPaymentModal) {
                    addPaymentModal.addEventListener('show.bs.modal', function (event) {
                        const button = event.relatedTarget;
                        const reservationId = button.getAttribute('data-reservation-id');
                        document.getElementById('paymentReservationId').value = reservationId;
                    });
                }

                // Modal de suppression
                const deleteConfirmModal = document.getElementById('deleteConfirmModal');
                if (deleteConfirmModal) {
                    deleteConfirmModal.addEventListener('show.bs.modal', function (event) {
                        const button = event.relatedTarget;
                        const reservationId = button.getAttribute('data-reservation-id');
                        document.getElementById('deleteReservationId').value = reservationId;
                    });
                }
            });
        </script>

    </div>

    <div id="sales-content" class="content-box">
        <div class="row align-items-center">
            <div class="col-md-4">
                <!-- Colonne vide à gauche pour maintenir l'équilibre -->
            </div>
            <div class="col-md-4 text-center">
                <h2>Liste des Salles</h2>
            </div>
            <div class="col-md-4 text-end">
                <a href="addSalle.jsp" class="btn btn-primary">
                    <i class="fa-solid fa-plus"></i> Add Salle
                </a>
            </div>
        </div>
        <div class="container mt-4">
            <div class="row">

                <table>
                    <tr>
                        <th>ID</th>
                        <th>NUMERO</th>
                        <th>Capaite</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                        <!--ajouter les seance dans chaque salle-->
                    </tr>
                    <%
                        ImplISalle implISalle =new ImplISalle();
                        List<Salle> salles = implISalle.afficherListSalle();
                        if(salles!=null){
                        for (Salle s : salles){
                    %>
                    <tr>
                        <td><%=s.getId()%></td>
                        <td><%=s.getNumero()%></td>
                        <td><%=s.getCapacite()%></td>
                        <td><a  href="ModifierSalle.jsp?id=<%=s.getId()%>">modifier</a> </td>
                        <td><a href="../supprimerSalle?id=<%=s.getId()%>">supprimer</a></td>
                    </tr>
                    <%}
                        }
                    %>
                </table>

            </div>
        </div>

    </div>
    <!-- ajouter un utilisateur  -->
    <div id="add-user-content" class="content-box">
        <div class="container-fluid mb-3">
            <div class="row align-items-center">
                <div class="col-md-4">
                    <!-- Colonne vide à gauche pour maintenir l'équilibre -->
                </div>
                <div class="col-md-4 text-center">
                    <h2>Liste des utilisateurs</h2>
                </div>
                <div class="col-md-4 text-end">
                    <a href="addUser.jsp" class="btn btn-primary">
                        <i class="fa-solid fa-plus"></i> Add utilisateur
                    </a>
                </div>
            </div>
        </div>
        <table border="2">
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Role</th>
                <th>Modifier</th>
                <th>Supprimer</th>
            </tr>
                    <%
                        ImplUser implUser = new ImplUser();
                        List<User> users = implUser.getAllUsers();
                        if (users != null) {
                            for (User u : users) {
                    %>
            <tr>
                <td><%= u.getId() %></td>
                <td><%= u.getEmail() %></td>
                <td><%=u.getRole()%></td>
                <td><a href="ModifierUser.jsp?id=<%=u.getId()%>">Modifier</a></td>
                <td><a href="../deletUser?id=<%=u.getId()%>">Supprimer</a> </td>
            </tr>

                    <%
                            }
                        }
                    %>
        </table>
    </div>
    <!-- pour logout -->
    <div id="logout-content" class="content-box">
        <h2>Log Out</h2>
        <p>Déconnexion en cours...</p>

    </div>


    <div id="paiments-content" class="content-box">
        <h2 class="text-center">Paiements</h2>
        <table border="2">
        <tr>
            <th>ID</th>
            <th>Montant</th>
            <th>Date</th>
            <th>Methode</th>
            <!--Reservation-->
        </tr>
        <%
            ImplIPaiement implIPaiement = new ImplIPaiement();
            List<Paiement> paiements = implIPaiement.afficherListPaiement();
            if (paiements!=null){
                for (Paiement paiement:paiements){
        %>
            <td><%=paiement.getId()%></td>
            <td><%=paiement.getMontant()%></td>
            <td><%=paiement.getDate()%></td>
            <td><%=paiement.getMontant()%></td>
            <!--Reservation-->
        <%
                }
            }
        %>
        </table>

    </div>


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
                    <i class="fa-solid fa-plus"></i> Add Seance
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
        document.getElementById("paiments").addEventListener("click", function () {
            showSection("paiments-content");
        });
        document.getElementById("seances").addEventListener("click", function () {
            showSection("seances-content");
        });
    });

</script>
</body>
</html>
