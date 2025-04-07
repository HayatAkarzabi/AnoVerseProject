<%@ page import="java.util.List" %>
<%@ page import="Dao.*" %>
<%@ page import="Metier.*" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 07/04/2025
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
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
                    <i class="fa-solid fa-plus"></i> ajouter utilisateur
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
</body>
</html>
