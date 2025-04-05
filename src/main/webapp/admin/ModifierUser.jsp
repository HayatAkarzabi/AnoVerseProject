
<%@ page import="java.io.PrintWriter" %>
<%@ page import="Dao.ImplUser" %>
<%@ page import="Metier.User" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 02/04/2025
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="CSS.jsp"%>
</head>
<body>
<%
    // Récupération et traitement du paramètre id
    Long id = null;
    User u = null;
    String errorMessage = null;

    try {
        id = Long.parseLong(request.getParameter("id"));
        ImplUser implUser = new ImplUser();
        u = implUser.findUserById(id);

        if (u == null) {
            errorMessage = "User non trouvé";
        }
    } catch (NumberFormatException e) {
        errorMessage = "ID de User invalide";
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
<div class="continer">
    <div class="row">
        <div class="col-md-6 offset-md-4">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">Modifier User</h3>
                    <form action="../modifierUser" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="<%=u.getId()%>">
                        <div class="form-group">
                            <input type="text" id="email" name="email" class="form-control" placeholder="email :" value="<%=u.getEmail()%>" required>
                        </div>
                        <div class="form-group">
                            <label for="role">Rôle</label>
                            <select name="role" id="role" class="form-control">
                                <option value="">-- Sélectionner un rôle --</option>
                                <option value="admin">admin</option>
                                <option value="client">client</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="newpassword">Password</label>
                            <input type="password" name="newpassword" class="form-control" id="newpassword" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Modifier</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="mt-3">
    <a href="../admin/DetailFilm.jsp" class="btn btn-secondary">
        <i class="bi bi-arrow-left"></i> Retour
    </a>
</div>
</body>
</html>
