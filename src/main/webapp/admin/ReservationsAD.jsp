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
    <title>Reservations</title>
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
</body>
</html>
