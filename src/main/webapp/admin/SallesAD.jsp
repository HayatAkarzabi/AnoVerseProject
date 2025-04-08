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
    <title>Salles</title>
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
                <i class="fa-solid fa-plus"></i> Ajouter Salle
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
</body>
</html>
