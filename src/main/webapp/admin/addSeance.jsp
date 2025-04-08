<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Metier.Film" %>
<%@ page import="Metier.Salle" %>
<%@ page import="java.util.List" %>
<%@ page import="Dao.ImplFilm" %>
<%@ page import="Dao.ImplISalle" %>
<%@ page import="Dao.ImplFilm" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ajouter une séance</title>
  <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
  <style>
    :root {
      --primary-red: #e50914;
      --dark-red: #831818;
      --light-red: #fa8289;
      --black: #121212;
      --dark-gray: #212121;
      --white: #ffffff;
      --light-gray: #f5f5f5;
    }

    body {
      background-color: var(--black);
      color: var(--white);
    }

    .container {
      color: var(--white);
    }

    .card {
      background-color: var(--dark-gray);
      border: none;
    }

    .card-header {
      background-color: var(--primary-red) !important;
      color: var(--white);
    }

    .card-body {
      color: var(--white);
    }

    .card-footer {
      background-color: rgba(0, 0, 0, 0.2);
      border-top: 1px solid rgba(255, 255, 255, 0.1);
    }

    .form-control, .form-select {
      background-color: var(--black);
      color: var(--white);
      border: 1px solid rgba(255, 255, 255, 0.2);
    }

    .form-control:focus, .form-select:focus {
      background-color: var(--black);
      color: var(--white);
      border-color: var(--primary-red);
      box-shadow: 0 0 0 0.25rem rgba(229, 9, 20, 0.25);
    }

    .btn-primary {
      background-color: var(--primary-red);
      border-color: var(--primary-red);
    }

    .btn-primary:hover, .btn-primary:focus {
      background-color: var(--dark-red);
      border-color: var(--dark-red);
    }

    .btn-secondary {
      background-color: var(--dark-gray);
      border-color: var(--dark-gray);
    }

    .btn-secondary:hover, .btn-secondary:focus {
      background-color: #333;
      border-color: #333;
    }

    .btn-success {
      background-color: var(--dark-red);
      border-color: var(--dark-red);
    }

    .btn-success:hover, .btn-success:focus {
      background-color: #720e0e;
      border-color: #720e0e;
    }

    .btn-outline-secondary {
      color: var(--white);
      border-color: var(--white);
    }

    .btn-outline-secondary:hover {
      background-color: var(--white);
      color: var(--black);
    }

    .film-card {
      cursor: pointer;
      transition: all 0.3s;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.3);
      border: 1px solid rgba(255, 255, 255, 0.1);
    }

    .film-card:hover {
      transform: translateY(-5px);
      box-shadow: 0 10px 20px rgba(229, 9, 20, 0.3);
    }

    .film-card.selected {
      border: 3px solid var(--primary-red);
      box-shadow: 0 0 15px rgba(229, 9, 20, 0.5);
    }

    .film-img {
      height: 200px;
      object-fit: cover;
    }

    .salle-card {
      cursor: pointer;
      transition: all 0.3s;
      background-color: rgba(0, 0, 0, 0.3);
      border: 1px solid rgba(255, 255, 255, 0.1);
    }

    .salle-card:hover {
      transform: translateY(-5px);
      box-shadow: 0 10px 20px rgba(229, 9, 20, 0.3);
    }

    .salle-card.selected {
      border: 3px solid var(--primary-red);
      box-shadow: 0 0 15px rgba(229, 9, 20, 0.5);
    }

    .step-container {
      display: none;
    }

    .step-container.active {
      display: block;
    }

    .steps-indicator {
      display: flex;
      justify-content: space-between;
      margin-bottom: 30px;
    }

    .step {
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    .step-number {
      width: 40px;
      height: 40px;
      border-radius: 50%;
      background-color: rgba(255, 255, 255, 0.1);
      display: flex;
      align-items: center;
      justify-content: center;
      margin-bottom: 5px;
      font-weight: bold;
      color: var(--white);
    }

    .step.active .step-number {
      background-color: var(--primary-red);
      color: var(--white);
    }

    .step.completed .step-number {
      background-color: var(--dark-red);
      color: var(--white);
    }

    .step-title {
      font-size: 0.9rem;
      color: rgba(255, 255, 255, 0.6);
    }

    .step.active .step-title, .step.completed .step-title {
      color: var(--white);
      font-weight: bold;
    }

    .alert-danger {
      background-color: rgba(220, 53, 69, 0.2);
      color: #f8d7da;
      border-color: rgba(220, 53, 69, 0.3);
    }

    .alert-warning {
      background-color: rgba(255, 193, 7, 0.2);
      color: #ffc107;
      border-color: rgba(255, 193, 7, 0.3);
    }

    .alert-warning a {
      color: var(--primary-red);
    }

    label {
      color: rgba(255, 255, 255, 0.8);
    }

    h4 {
      color: var(--white);
      border-bottom: 2px solid var(--primary-red);
      padding-bottom: 10px;
      margin-bottom: 20px;
    }

    .form-label {
      color: var(--white);
    }

    input[type="date"], input[type="time"] {
      color-scheme: dark;
    }
  </style>
</head>
<body>
<div class="container my-5">
  <div class="card shadow-lg">
    <div class="card-header bg-primary text-white">
      <h3 class="mb-0"><i class="fas fa-calendar-plus me-2"></i>Ajouter une nouvelle séance</h3>
    </div>
    <div class="card-body">
      <% if(request.getAttribute("error") != null) { %>
      <div class="alert alert-danger" role="alert">
        <%= request.getAttribute("error") %>
      </div>
      <% } %>

      <form action="../addSeance" method="post" id="seanceForm">
        <!-- Steps Indicator -->
        <div class="steps-indicator">
          <div class="step active" id="step1-indicator">
            <div class="step-number">1</div>
            <div class="step-title">Choisir un film</div>
          </div>
          <div class="step" id="step2-indicator">
            <div class="step-number">2</div>
            <div class="step-title">Choisir une salle</div>
          </div>
          <div class="step" id="step3-indicator">
            <div class="step-number">3</div>
            <div class="step-title">Détails de la séance</div>
          </div>
        </div>

        <!-- Step 1: Choose a film -->
        <div class="step-container active" id="step1">
          <h4 class="mb-4">Sélectionnez un film</h4>

          <div class="row row-cols-1 row-cols-md-3 g-4">
            <%
              ImplFilm filmDao = new ImplFilm();
              List<Film> films = filmDao.getAllFilms();

              if(films != null && !films.isEmpty()) {
                for(Film film : films) {
            %>
            <div class="col">
              <div class="card film-card h-100" onclick="selectFilm('<%= film.getId() %>', this)">
                <% if(film.getImageUrl() != null) { %>
                <img src="../<%= film.getImageUrl() %>" class="card-img-top film-img" alt="<%= film.getTitle() %>">
                <% } else { %>
                <img src="/api/placeholder/300/200" class="card-img-top film-img" alt="Image non disponible">
                <% } %>
                <div class="card-body">
                  <h5 class="card-title"><%= film.getTitle() %></h5>
                </div>
              </div>
            </div>
            <%
              }
            } else {
            %>
            <div class="col-12">
              <div class="alert alert-warning" role="alert">
                Aucun film n'est disponible. <a href="ajouterFilm.jsp" class="alert-link">Ajouter un film</a>
              </div>
            </div>
            <% } %>
          </div>

          <input type="hidden" name="filmId" id="selectedFilmId">

          <div class="mt-4 text-end">
            <button type="button" class="btn btn-primary" onclick="goToStep(2)" id="step1Next" disabled>
              Suivant <i class="fas fa-arrow-right ms-1"></i>
            </button>
          </div>
        </div>

        <!-- Step 2: Choose a room -->
        <div class="step-container" id="step2">
          <h4 class="mb-4">Sélectionnez une salle</h4>

          <div class="row row-cols-1 row-cols-md-4 g-4">
            <%
              ImplISalle salleDao = new ImplISalle();
              List<Salle> salles = salleDao.afficherListSalle();

              if(salles != null && !salles.isEmpty()) {
                for(Salle salle : salles) {
            %>
            <div class="col">
              <div class="card salle-card text-center" onclick="selectSalle('<%= salle.getId() %>', this)">
                <div class="card-body">
                  <h5 class="card-title">Salle <%= salle.getNumero() %></h5>
                  <p class="card-text">
                    <i class="fas fa-chair me-2"></i>
                    <strong><%= salle.getCapacite() %></strong> places
                  </p>
                </div>
              </div>
            </div>
            <%
              }
            } else {
            %>
            <div class="col-12">
              <div class="alert alert-warning" role="alert">
                Aucune salle n'est disponible. <a href="addSalle.jsp" class="alert-link">Ajouter une salle</a>
              </div>
            </div>
            <% } %>
          </div>

          <input type="hidden" name="salleId" id="selectedSalleId">

          <div class="mt-4 d-flex justify-content-between">
            <button type="button" class="btn btn-secondary" onclick="goToStep(1)">
              <i class="fas fa-arrow-left me-1"></i> Précédent
            </button>
            <button type="button" class="btn btn-primary" onclick="goToStep(3)" id="step2Next" disabled>
              Suivant <i class="fas fa-arrow-right ms-1"></i>
            </button>
          </div>
        </div>

        <!-- Step 3: Date and time -->
        <div class="step-container" id="step3">
          <h4 class="mb-4">Détails de la séance</h4>

          <div class="row g-3">
            <div class="col-md-6">
              <label for="seanceDate" class="form-label">Date</label>
              <input type="date" class="form-control" id="seanceDate" name="seanceDate" required>
            </div>
            <div class="col-md-6">
              <label for="seanceTime" class="form-label">Heure</label>
              <input type="time" class="form-control" id="seanceTime" name="seanceTime" required>
            </div>
<%--            <div class="col-12">--%>
<%--              <label for="prix" class="form-label">Prix du ticket (DH)</label>--%>
<%--              <input type="number" class="form-control" id="prix" name="prix" required min="0" step="0.01">--%>
<%--            </div>--%>
          </div>

          <div class="mt-4 d-flex justify-content-between">
            <button type="button" class="btn btn-secondary" onclick="goToStep(2)">
              <i class="fas fa-arrow-left me-1"></i> Précédent
            </button>
            <button type="submit" class="btn btn-success">
              <i class="fas fa-save me-1"></i> Enregistrer la séance
            </button>
          </div>
        </div>
      </form>
    </div>
    <div class="card-footer">
      <a href="home.jsp" class="btn btn-outline-secondary">
        <i class="fas fa-home me-1"></i> Retour à l'accueil
      </a>
    </div>
  </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
<script>
  // Variables to track current step
  let currentStep = 1;

  // Functions to handle film selection
  function selectFilm(filmId, element) {
    document.querySelectorAll('.film-card').forEach(card => {
      card.classList.remove('selected');
    });
    element.classList.add('selected');
    document.getElementById('selectedFilmId').value = filmId;
    document.getElementById('step1Next').disabled = false;
  }

  // Functions to handle salle selection
  function selectSalle(salleId, element) {
    document.querySelectorAll('.salle-card').forEach(card => {
      card.classList.remove('selected');
    });
    element.classList.add('selected');
    document.getElementById('selectedSalleId').value = salleId;
    document.getElementById('step2Next').disabled = false;
  }

  // Function to navigate between steps
  function goToStep(step) {
    // Hide all steps
    document.querySelectorAll('.step-container').forEach(container => {
      container.classList.remove('active');
    });

    // Update step indicators
    document.querySelectorAll('.step').forEach(indicator => {
      indicator.classList.remove('active', 'completed');
    });

    // Show the requested step
    document.getElementById('step' + step).classList.add('active');

    // Update step indicators
    for (let i = 1; i <= 3; i++) {
      if (i < step) {
        document.getElementById('step' + i + '-indicator').classList.add('completed');
      } else if (i === step) {
        document.getElementById('step' + i + '-indicator').classList.add('active');
      }
    }

    currentStep = step;
  }

  // Set minimum date to today
  document.addEventListener('DOMContentLoaded', function() {
    const today = new Date();
    const yyyy = today.getFullYear();
    const mm = String(today.getMonth() + 1).padStart(2, '0');
    const dd = String(today.getDate()).padStart(2, '0');
    const formattedToday = yyyy + '-' + mm + '-' + dd;

    document.getElementById('seanceDate').min = formattedToday;
  });
</script>
</body>
</html>