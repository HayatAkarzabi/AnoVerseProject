<%--&lt;%&ndash;
  Created by IntelliJ IDEA.
  User: Clone
  Date: 4/2/2025
  Time: 7:40 PM
  To change this template use File | Settings | File Templates.
&ndash;%&gt;
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>description</title>
  </head>
  <body>
  <h1>${film.title}</h1>
  <img src="${film.imageUrl}" width="200px" height="300px">
  <p><b>Genre :</b> ${film.genre}</p>
  <p><b>Annee de publication :</b> ${film.year} </p>
  <p><b>Writer :</b> ${film.writer}</p>
  <p><b>Description :</b> ${film.description}</p>

  <a href="reservation?filmId=${film.id}">Réserver</a>

  </body>
</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>${film.title}</title>
  <%@include file="Component/CSS.jsp" %>

</head>
<body>
<header>
  <%@include file="Component/navbar.jsp" %><br><br>
</header>
<%--
<div class="container">
  <div class="card">
    <img src="${film.imageUrl}" alt="${film.title}">
    <div class="info">
      <h1>${film.title}</h1>
      <p><b>🎭 Genre :</b> ${film.genre}</p>
      <p><b>📅 Année :</b> ${film.year}</p>
      <p><b>✍️ Écrivain :</b> ${film.writer}</p>
      <p class="desc">${film.description}</p>
      <a href="reservation?filmId=${film.id}" class="btn">🎟 Réserver</a>
    </div>
  </div>
</div>--%>
<div class="description-container">
  <!-- Image en plein écran -->
  <div class="image-container">
    <img src="${film.imageUrl}" alt="${film.title}" class="film-image">
  </div>

  <!-- Détails du film et boutons -->
  <div class="film-details">
    <div class="film-info">
      <h1>${film.title}</h1>
      <p>${film.description}</p>
      <p><strong>Annee :</strong> ${film.year} </p>
      <p><strong>Genre :</strong> ${film.genre}</p>
    </div>
    <div class="film-buttons">
      <button class="watch-button">Regarder</button>
      <button class="favorite-button">Ajouter aux Favoris</button>
    </div>
  </div>

  <!-- Section des commentaires -->
  <div class="comments-section">
    <h2>Commentaires</h2>
    <div class="comments-list">
      <!-- Exemple de commentaire -->
      <div class="comment">
        <strong>Utilisateur1:</strong> Super film, j’ai adoré !
      </div>
      <div class="comment">
        <strong>Utilisateur2:</strong> Très intéressant !
      </div>
    </div>
    <form class="comment-form">
      <textarea placeholder="Ajoutez un commentaire..." required></textarea>
      <button type="submit">Envoyer</button>
    </form>
  </div>
</div>


</body>
</html>

<%--

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">

<head>
  <title>${film.title}</title>
  <%@ include file="Component/CSS.jsp" %>
  <style>
    /* Ajoutez ici des styles spécifiques à la page description */
    .anime-header {
      display: flex;
      align-items: center;
      justify-content: space-between;
      margin-bottom: 20px;
    }

    .anime-header img {
      width: 300px;
      border-radius: 15px;
      box-shadow: 0px 0px 10px rgba(212, 175, 55, 0.8);
    }

    .anime-details {
      color: goldenrod;
      font-size: 1.2rem;
    }

    .anime-description {
      margin-top: 20px;
      font-size: 1.1rem;
      color: #d4af37;
    }

    .anime-genres {
      margin-top: 20px;
      font-size: 1rem;
      color: #aaa;
    }

    .anime-actions {
      margin-top: 30px;
    }

    .anime-actions button {
      background-color: goldenrod;
      color: #1a1a1a;
      border-radius: 20px;
      padding: 10px 20px;
      font-size: 1.2rem;
      cursor: pointer;
      border: none;
    }

    .anime-actions button:hover {
      background-color: gold;
      box-shadow: 0 0 15px rgba(255, 215, 0, 0.6);
    }

    /* Section des commentaires */
    .comments-section {
      margin-top: 40px;
      background-color: rgba(0, 0, 0, 0.6);
      padding: 20px;
      border-radius: 10px;
    }

    .comments-section h4 {
      color: #f2f2f2;
    }

    .comment {
      background-color: #333;
      padding: 15px;
      margin-bottom: 10px;
      border-radius: 8px;
    }

    .comment-author {
      font-weight: bold;
      color: goldenrod;
    }

    .comment-text {
      color: #d4af37;
    }
  </style>
</head>

<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="text-custom">
    <img src="Images/logo.jpg" class="logo">
  </div>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="index.jsp"><i class="fa-solid fa-house"></i> Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="fa-solid fa-film"></i> Recent Anime</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#"><i class="fa-solid fa-film"></i> New Anime</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="#"><i class="fa-solid fa-film"></i> Old Anime</a>
      </li>
    </ul>
    <div class="d-flex justify-content-center">
      <div class="box">
        <input type="text" placeholder="Search....">
        <a href="#"><i class="fas fa-search"></i></a>
      </div>
    </div>
    <div class="col-md-3">
      <a href="Login.jsp" class="btn nav-item"><i class="fa-solid fa-right-from-bracket"></i> Login</a>
      <a href="Register.jsp" class="btn nav-item"><i class="fa-solid fa-user-plus"></i> Sign up</a>
    </div>
  </div>
</nav>

<!-- Anime Description -->
<div class="container">
  <div class="anime-header">
    <img src="${film.imageUrl}" alt="${film.title}" />
    <div>
      <h1>${film.title}</h1>
      <div class="anime-details">
        <p><strong>Genre:</strong> ${film.genre}</p>
        <p><strong>Release Date:</strong> ${film.year}</p>
        <p><strong>Writer:</strong> ${film.writer}</p>
      </div>
    </div>
  </div>

  <div class="anime-description">
    <h3>Description</h3>
    <p>${film.description}</p>
  </div>

  <div class="anime-actions">
    <button>Add to Favorites</button>
    <button>Watch Now</button>
  </div>

  <!-- Comments Section -->
  <div class="comments-section">
    <h4>Comments</h4>
    <div class="comment">
      <p class="comment-author">John Doe</p>
      <p class="comment-text">Great anime! The storyline was amazing and the characters were well-developed.</p>
    </div>
    <div class="comment">
      <p class="comment-author">Jane Smith</p>
      <p class="comment-text">I loved the art style! Definitely one of my favorites.</p>
    </div>
    <!-- Add more comments dynamically -->
  </div>
</div>

<!-- Add footer if needed -->
</body>
</html>
--%>

