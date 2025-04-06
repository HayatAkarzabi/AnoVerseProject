<%@ page import="Dao.ImplFilm" %>
<%@ page import="Metier.Film" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détail du Film</title>
    <%@include file="CSS.jsp"%>
</head>
<body>
<div class="container mt-5">
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

    <div class="card mb-3">
        <div class="row g-0">
            <div class="col-md-4">
                <img src="../<%= film.getImageUrl() %>" class="img-fluid rounded-start" alt="<%= film.getTitle() %>">

            </div>
            <div class="col-md-8">
                <div class="card-body">
                    <h2 class="card-title mb-4"><%= film.getTitle() %> (<%= film.getYear() %>)</h2>



                    <table class="table">
                        <tr>
                            <th>Genre :</th>
                            <td><%= film.getGenre() %></td>
                        </tr>
                        <tr>
                            <th>Réalisateur :</th>
                            <td><%= film.getDirector() %></td>
                        </tr>
                        <tr>
                            <th>Acteurs :</th>
                            <td><%= film.getActors() %></td>
                        </tr>
                        <tr>
                            <th>Scénariste :</th>
                            <td><%= film.getWriter() %></td>
                        </tr>
                    </table>

                    <h5 class="mt-4">discreption</h5>
                    <p class="card-text"><%= film.getDescription() %></p>

                    <div class="mt-4 d-flex justify-content-end">
                        <a href="modifierFilm.jsp?id=<%= film.getId() %>" class="btn btn-warning me-2">
                            <i class="bi bi-pencil"></i> Modifier
                        </a>
                        <a href="../supprimerFilm?id=<%= film.getId() %>" class="btn ">
                            <i class="bi bi-trash"></i> Supprimer
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="mt-3">
        <a href="../admin/home.jsp" class="btn btn-secondary">
            <i class="bi bi-arrow-left"></i> Retour
        </a>
    </div>
</div>
</body>
</html>