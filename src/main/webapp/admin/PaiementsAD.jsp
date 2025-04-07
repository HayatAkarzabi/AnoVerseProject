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
    <title>Paiments</title>
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
</body>
</html>
