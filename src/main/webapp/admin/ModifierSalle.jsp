<%@ page import="Metier.Salle" %>
<%@ page import="Dao.ImplISalle" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 04/04/2025
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifier Salle</title>
    <%@include file="CSS.jsp"%>

</head>
<body>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 04/04/2025
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add Salle</title>
</head>
<body>
<%
    // Récupération et traitement du paramètre id
    Long id = null;
    Salle salle= null;
    String errorMessage = null;

    try {
        id = Long.parseLong(request.getParameter("id"));
        ImplISalle implISalle = new ImplISalle();
        salle = implISalle.rechercherSalle(id);

        if (salle == null) {
            errorMessage = "Salle non trouvé";
        }
    } catch (NumberFormatException e) {
        errorMessage = "ID de Salle invalide";
    } catch (Exception e) {
        errorMessage = "Erreur: " + e.getMessage();
    }

    // Afficher l'erreur si elle existe
    if (errorMessage != null) {
%>
<div class='alert alert-danger'><%= errorMessage %></div>
<%
        return;
    }
%>
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
<div class="row">
    <div class="col-md-6 offset-md-4">
        <div class="card">
            <div class="card-body">
                <form action="../modifierSalle" method="post">
                    <input type="hidden" name="id" value="<%=salle.getId()%>">
                    <h3 class="text-center">Moifier Salle</h3>
                    <% String error = (String) request.getAttribute("error"); %>
                    <% if (error != null) { %>
                    <div class="alert alert-danger" role="alert">
                        <%= error %>
                    </div>
                    <% } %>
                    <div class="form-group">
                        <label for="numeroSalle">Numero Salle</label>
                        <input type="number" name="numeroSalle" class="form-control" id="numeroSalle" value="<%=salle.getNumero()%>"  placeholder=" Numero du Salle">
                    </div>
                    <div class="form-group">
                        <label for="capacite">Capacite</label>
                        <input type="number" name="capacite" class="form-control" id="capacite" value="<%=salle.getCapacite()%>" placeholder="Capacite du Salle">
                    </div>
                    <button type="submit" class="btn btn-primary">ajouter</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>

</body>
</html>
