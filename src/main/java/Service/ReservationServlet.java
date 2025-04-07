/*

package Service;

import Dao.ImplFilm;
import Dao.ImplIReservation;
import Metier.Film;
import Metier.Reservation;
import Metier.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    // Méthode GET pour afficher la page de réservation
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer le paramètre filmId depuis l'URL
        String filmId = request.getParameter("filmId");

        // Vérifier si filmId existe dans la requête
        if (filmId != null) {
            // Récupérer les informations sur le film (utiliser la logique d'accès aux données ici)
            Film film = getFilmById(Long.parseLong(filmId)); // Remplacer cette méthode avec ton code de récupération du film

            // Ajouter le film à l'objet request pour l'afficher dans la page JSP
            request.setAttribute("film", film);

            // Rediriger vers la page reservation.jsp
            request.getRequestDispatcher("Reservation.jsp").forward(request, response);
        } else {
            // Si filmId est invalide ou manquant, rediriger vers une page d'erreur ou une autre page
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Film ID manquant");
        }
    }

    // Méthode pour récupérer le film par son ID (remplace par ta propre logique)
    private Film getFilmById(Long id) {
        // Utilise ton DAO ou méthode pour récupérer le film à partir de la base de données
        ImplFilm implFilm = new ImplFilm();
        return implFilm.getFilm(id);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Traiter la soumission du formulaire (réservation)
        String filmId = request.getParameter("filmId"); // ou d'autres paramètres du formulaire
        String nombreDeTickets = request.getParameter("nombreDeTickets");

        // Logique pour enregistrer la réservation, par exemple :
        ImplFilm implFilm = new ImplFilm();
        Film film = implFilm.getFilm(Long.parseLong(filmId));
        Reservation reservation = new Reservation(film, new Date(),Integer.parseInt(nombreDeTickets));
        ImplIReservation reservationImpl = new ImplIReservation();
        reservationImpl.ajouterReservation(reservation);

        // Rediriger vers une page de confirmation ou d'accueil
        response.sendRedirect("confirmation.jsp"); // ou une autre page après réservation
    }
}*/

package Service;

import Dao.ImplFilm;
import Dao.ImplISalle;
import Dao.ImplISeance;
import Metier.Film;
import Metier.Salle;
import Metier.Seance;
import Metier.SeanceDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long filmId = Long.parseLong(request.getParameter("filmId"));

        ImplFilm filmDAO = new ImplFilm();
        ImplISeance seanceDAO = new ImplISeance();
        ImplISalle salleDAO = new ImplISalle();

        Film film = filmDAO.getFilm(filmId);
        List<Seance> seances = seanceDAO.getSeancesByFilmId(filmId);
        List<SeanceDTO> seanceDTOs = new ArrayList<>();
        for (Seance seance : seances) {
            SeanceDTO seanceDTO = new SeanceDTO(seance);
            Salle salle = seanceDAO.getSalleBySeance(seance.getId()); // Récupérer la salle de la séance
            int nombreTotalPlaces = salle.getCapacite();
            int nombrePlacesReservees = salleDAO.getPlacesReservees(salle.getId()); // Récupérer les places réservées pour la séance
            int placesDisponibles = nombreTotalPlaces - nombrePlacesReservees;
            seanceDTO.setPlacesDisponibles(placesDisponibles);
            seanceDTOs.add(seanceDTO);
        }


        System.out.println("Séances récupérées : " + (seances == null ? "Aucune séance" : seances.size()));
        if (film == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Film non trouvé");
            return;
        }

        if (seances == null || seances.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Aucune séance disponible pour ce film.");
            return;
        }
        request.setAttribute("film", film);
        request.setAttribute("seances", seanceDTOs);
        request.getRequestDispatcher("Reservation.jsp").forward(request, response);



    }
}

