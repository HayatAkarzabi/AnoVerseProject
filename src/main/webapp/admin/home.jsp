<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 29/03/2025
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="CSS.jsp"%>
</head>
<body>
    <div class="main_box">
        <input type="checkbox" id="check">
        <div class="btn_one">
            <label for="check">
                <i class="fas fa-bars"></i>
            </label>
        </div>
        <div class="sidebr_menu">
            <div class="logodiv">
                <img src="b.jpg" class="logo">
            </div>
            <div class="btn_two">
                <label for="check">
                    <i class="fas fa-times"></i>
                </label>
            </div>
            <div class="menu">
            <ul>
                <li><a href="#" id="all-animes"><i class="fa-solid fa-video "></i> All Animes</a></li>
                <li><a href="#" id="add-anime"><i class="fas fa-plus-square "></i> Add Anime</a></li>
                <li><a href="#" id="sales"><i class="fa-solid fa-ticket "></i> Sales</a></li>
                <li><a href="#" id="add-user"><i class="fa-solid fa-user-plus "></i> Add User</a></li>
                <li><a href="#" id="logout"> <i class="fa-solid fa-arrow-right-to-bracket "></i> Log Out</a></li>
            </ul>
            </div>
        </div>
    </div>
    <!-- Contenu dynamique -->
    <div id="content">
        <!-- affichage liste des animes -->
        <div id="all-animes-content" class="content-box">
            <h2>All Films</h2>
            <p>Liste des films disponibles...</p>
        </div>
        <!-- ajouter  un anime-->
        <div id="add-anime-content" class="content-box">
            <div class="continer">
                <div class="row">
                    <div class="col-md-4 offset-md-4">
                        <div class="card">
                            <div class="card-body">
                                <form action="addFilmServlet" method="POST">
                                    <label for="title">Titre :</label>
                                    <input type="text" id="title" name="title" required>

                                    <label for="genre">Genre :</label>
                                    <input type="text" id="genre" name="genre" required>

                                    <label for="year">Année :</label>
                                    <input type="number" id="year" name="year" required>

                                    <label for="director">Réalisateur :</label>
                                    <input type="text" id="director" name="director" required>

                                    <label for="actors">Acteurs :</label>
                                    <input type="text" id="actors" name="actors" required>

                                    <label for="writer">Scénariste :</label>
                                    <input type="text" id="writer" name="writer" required>

                                    <button type="submit">Ajouter</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- rapport des ventes  -->
        <div id="sales-content" class="content-box">
            <h2>Sales</h2>
            <p>Rapport des ventes...</p>
        </div>
        <!-- ajouter un utilisateur ou un film -->
        <div id="add-user-content" class="content-box">
            <h2>Add User</h2>
            <p >Formulaire d'inscription...</p>
        </div>
        <!-- pour logout -->
        <div id="logout-content" class="content-box">
            <h2>Log Out</h2>
            <p>Déconnexion en cours...</p>
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

            document.getElementById("add-anime").addEventListener("click", function () {
                showSection("add-anime-content");
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
        });
    </script>
</body>
</html>
