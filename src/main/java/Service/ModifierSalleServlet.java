package Service;

import Dao.ImplISalle;
import Metier.Place;
import Metier.Salle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/modifierSalle")
public class ModifierSalleServlet extends HttpServlet {

    private ImplISalle implISalle;

    @Override
    public void init() throws ServletException {
        implISalle = new ImplISalle();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long salleId = Long.parseLong(request.getParameter("id"));
            String nouveauNumero = request.getParameter("numeroSalle");
            int nouvelleCapacite = Integer.parseInt(request.getParameter("capacite"));

            Salle salle = implISalle.rechercherSalle(salleId);
            if (salle == null) {
                request.setAttribute("error", "Salle non trouvée !");
                request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
                return;
            }

            salle.setNumero(nouveauNumero);
            ajusterPlaces(salle, nouvelleCapacite);

            implISalle.modifierSalle(salle);

            response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
        } catch (NumberFormatException e) {
            request.setAttribute("error", "ID ou capacité invalide !");
            request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Erreur lors de la mise à jour de la salle !");
            request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
        }
    }

    private void ajusterPlaces(Salle salle, int nouvelleCapacite) {
        List<Place> placesActuelles = salle.getPlaces();
        int capaciteActuelle = placesActuelles.size();

        if (nouvelleCapacite > capaciteActuelle) {
            for (int i = capaciteActuelle + 1; i <= nouvelleCapacite; i++) {
                Place nouvellePlace = new Place();
                nouvellePlace.setNumero(i);
                nouvellePlace.setEstResrvee(false);
                nouvellePlace.setSalle(salle);
                placesActuelles.add(nouvellePlace);
            }
        } else if (nouvelleCapacite < capaciteActuelle) {
            placesActuelles.subList(nouvelleCapacite, capaciteActuelle).clear();
        }

        salle.setCapacite(nouvelleCapacite);
    }
}
