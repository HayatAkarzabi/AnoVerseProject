package Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.ImplFilm;
import Dao.ImplISalle;
import Dao.ImplISeance;
import Metier.Film;
import Metier.Salle;
import Metier.Seance;

@WebServlet("/updateSeance")
public class ModifierSeanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ImplISeance seanceDao = new ImplISeance();
    private ImplFilm filmDao = new ImplFilm();
    private ImplISalle salleDao = new ImplISalle();



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Récupération des paramètres du formulaire
            String seanceIdStr = request.getParameter("seanceId");
            String filmIdStr = request.getParameter("filmId");
            String salleIdStr = request.getParameter("salleId");
            String seanceDateStr = request.getParameter("seanceDate");
            String seanceTimeStr = request.getParameter("seanceTime");

            // Validation des données
            if (seanceIdStr == null || seanceIdStr.trim().isEmpty() ||
                    filmIdStr == null || filmIdStr.trim().isEmpty() ||
                    salleIdStr == null || salleIdStr.trim().isEmpty() ||
                    seanceDateStr == null || seanceDateStr.trim().isEmpty() ||
                    seanceTimeStr == null || seanceTimeStr.trim().isEmpty()) {

                request.setAttribute("error", "Tous les champs sont obligatoires");

                // Si l'ID de la séance est disponible, récupérer la séance pour réafficher le formulaire
                if (seanceIdStr != null && !seanceIdStr.trim().isEmpty()) {
                    try {
                        Long seanceId = Long.parseLong(seanceIdStr);
                        Seance seance = seanceDao.chercherSeance(seanceId);
                        request.setAttribute("seance", seance);
                    } catch (Exception e) {
                        // Ignorer les erreurs ici
                    }
                }

                request.getRequestDispatcher("/vues/modifierSeance.jsp").forward(request, response);
                return;
            }

            // Conversion des identifiants
            Long seanceId = Long.parseLong(seanceIdStr);
            Long filmId = Long.parseLong(filmIdStr);
            Long salleId = Long.parseLong(salleIdStr);

            // Récupération des objets existants
            Seance seanceExistante = seanceDao.chercherSeance(seanceId);
            Film film = filmDao.getFilm(filmId);
            Salle salle = salleDao.rechercherSalle(salleId);

            if (seanceExistante == null || film == null || salle == null) {
                request.setAttribute("error", "Séance, film ou salle introuvable");
                request.getRequestDispatcher("/vues/modifierSeance.jsp").forward(request, response);
                return;
            }

            // Conversion et combinaison de la date et l'heure
            LocalDate date = LocalDate.parse(seanceDateStr);
            LocalTime time = LocalTime.parse(seanceTimeStr);
            LocalDateTime dateTime = LocalDateTime.of(date, time);

            // Vérification des conflits (sauf avec la séance actuelle)
//            if (seanceDao.hasConflictingSeanceExcept(salleId, dateTime, seanceId)) {
//                request.setAttribute("error", "Une autre séance est déjà programmée dans cette salle à cette date et heure");
//                request.setAttribute("seance", seanceExistante);
//                request.getRequestDispatcher("/vues/modifierSeance.jsp").forward(request, response);
//                return;
//            }

            // Mise à jour de l'objet Seance
            seanceExistante.setFilm(film);
            seanceExistante.setSalle(salle);
            seanceExistante.setDate(dateTime);

            // Mise à jour de la séance dans la base de données
           seanceDao.modifierSeance(seanceExistante);

           response.sendRedirect(request.getContextPath() + "/admin/home.jsp");

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Format de numéro invalide");
            request.getRequestDispatcher("/vues/modifierSeance.jsp").forward(request, response);
        } catch (DateTimeParseException e) {
            request.setAttribute("error", "Format de date ou d'heure invalide");
            request.getRequestDispatcher("/vues/modifierSeance.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Une erreur est survenue: " + e.getMessage());
            request.getRequestDispatcher("/vues/modifierSeance.jsp").forward(request, response);
        }
    }
}
