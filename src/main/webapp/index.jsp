<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Accueil - Réservation de Films</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

    <style>
        body {
            background: linear-gradient(to right, #ff9966, #ff5e62);
            color: white;
            font-family: Arial, sans-serif;
        }
        .navbar {
            background: #222831;
        }
        .hero {
            text-align: center;
            padding: 80px 20px;
        }
        .btn-primary {
            background-color: #222831;
            border: none;
            padding: 12px 20px;
            font-size: 18px;
        }
        .btn-primary:hover {
            background-color: #393E46;
        }
        .features {
            padding: 50px 20px;
            text-align: center;
        }
        .feature-box {
            padding: 20px;
            background: white;
            color: black;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.2);
            margin: 10px;
        }
        .carousel-item img {
            height: 400px;
            object-fit: cover;
        }
        .films {
            background: white;
            color: black;
            padding: 20px;
            border-radius: 10px;
            text-align: center;
        }
        footer {
            text-align: center;
            padding: 20px;
            background: #222831;
            color: white;
        }
    </style>
</head>
<body>

<!-- Barre de navigation -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="#">
            <i class="fas fa-film"></i> Animé Réservations
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item"><a class="nav-link" href="#">Accueil</a></li>
                <li class="nav-item"><a class="nav-link" href="reservation.jsp">Réserver</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Section Slider -->
<div id="filmSlider" class="carousel slide" data-bs-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="Images\anime1.jpg" class="d-block w-100" alt="Film 1">
        </div>
        <div class="carousel-item">
            <img src="Images\anime2.jpg" class="d-block w-100" alt="Film 2">
        </div>
        <div class="carousel-item">
            <img src="Images\anime3.png" class="d-block w-100" alt="Film 3">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#filmSlider" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#filmSlider" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>

<!-- Section de Présentation -->
<header class="hero">
    <h1><i class="fas fa-film"></i> Bienvenue sur Animé Réservations</h1>
    <p>Réservez vos films d'animation préférés en un clic !</p>
    <a href="reservations.jsp" class="btn btn-primary">Réserver maintenant</a>
</header>

<!-- Films disponibles (dynamique) -->
<section class="container films">
    <h2>Films disponibles</h2>
    <div class="row">
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/aniverse", "root", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM reservation");
                while (rs.next()) {
        %>
        <div class="col-md-4">
            <div class="feature-box">
                <h4><%= rs.getString("film") %></h4>
                <p>Date : <%= rs.getDate("date") %></p>
                <p>Lieu : <%= rs.getString("location") %></p>
                <p>Status : <%= rs.getString("status") %></p>
            </div>
        </div>
        <%
                }
                con.close();
            } catch (Exception e) {
                    System.out.println("<p>Erreur de connexion à la base de données</p>");
            }
        %>
    </div>
</section>

<!-- Pied de page -->
<footer>
    <p>&copy; 2025 Animé Réservations - Tous droits réservés</p>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
