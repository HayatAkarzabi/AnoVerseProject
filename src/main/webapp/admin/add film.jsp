<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 03/04/2025
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajouter film</title>
    <%@include file="CSS.jsp"%>
</head>
<body>
<div class="continer">
    <div class="row">
        <div class="col-md-6 offset-md-4">
            <div class="card">
                <div class="card-body">
                    <h3 class="text-center">Add Anime</h3>
                    <form action="../ajouterFilm" method="post">
                        <div class="form-group">
                            <input type="text" id="title" name="title" class="form-control" placeholder="Titre :" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="genre" name="genre" class="form-control" placeholder="Genre :" required>
                        </div>
                        <div class="form-group">
                            <input type="number" id="year" name="year" class="form-control" placeholder="Année :" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="director" name="director" class="form-control" placeholder="Réalisateur :" required>
                        </div>
                        <div class="form-group" >
                            <input type="text" id="actors" name="actors" class="form-control" placeholder="Acteurs :" required>
                        </div>
                        <div class="form-group">
                            <input type="text" id="writer" name="writer" class="form-control" placeholder="Scénariste :" required>
                        </div>
                        <div class="form-group">
                            <textarea name="description" id="description" class="form-control" rows="4" cols="50" PLACEHOLDER="description" required></textarea>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlFile1">Upload photo</label>
                            <input name="bimg" type="file" class="form-control-file"  id="exampleFormControlFile1">
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Ajouter</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
