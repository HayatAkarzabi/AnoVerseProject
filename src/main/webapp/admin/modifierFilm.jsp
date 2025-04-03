<%@ page import="Metier.Film" %>
<%@ page import="Dao.ImplFilm" %>

<%@ page import="java.io.PrintWriter" %>
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
    Film film = null;
    String errorMessage = null;

    try {
        id = Long.parseLong(request.getParameter("id"));
        ImplFilm f = new ImplFilm();
        film = f.getFilm(id);

        if (film == null) {
            errorMessage = "Film non trouvé";
        }
    } catch (NumberFormatException e) {
        errorMessage = "ID de film invalide";
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
                    <h3 class="text-center">Modifier Anime</h3>
                    <form action="../modifierFilm" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" value="<%=film.getId()%>">
                        <input type="hidden" name="oldImage" value="<%=film.getImageUrl()%>">
                        <div class="form-group">
                            <input type="text" id="title" name="title" class="form-control" placeholder="Titre :" value="<%=film.getTitle()%>" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="genre" name="genre" class="form-control" placeholder="Genre :" value="<%=film.getGenre()%>" required>
                        </div>
                        <div class="form-group">
                            <input type="number" id="year" name="year" class="form-control" placeholder="Année :" value="<%=film.getYear()%>" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="director" name="director" class="form-control" placeholder="Réalisateur :" value="<%=film.getDirector()%> "required>
                        </div>
                        <div class="form-group" >
                            <input type="text" id="actors" name="actors" class="form-control" placeholder="Acteurs :" value="<%=film.getActors()%>" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="writer" name="writer" class="form-control" placeholder="Scénariste :" value="<%=film.getWriter()%>" required>
                        </div>
                        <div class="form-group">
                            <textarea name="description" id="description" class="form-control" rows="4" cols="50" PLACEHOLDER="description" required> <%=film.getDescription()%> </textarea>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlFile1">Upload photo</label>
                            <input name="bimg" type="file" class="form-control-file"  id="exampleFormControlFile1" >
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Modifier</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
