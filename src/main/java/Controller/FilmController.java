package Controller;

import Metier.Film;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Contrôleur REST pour la gestion des films.
 */
@Path("/films123") // Convention : nom de l'entité au pluriel
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FilmController {

    /**
     * Stockage temporaire des films (⚠ À remplacer par une base de données).
     */
    private static List<Film> films = new ArrayList<>();

    /**
     * Récupérer la liste de tous les films.
     *
     * @return Une réponse HTTP contenant la liste des films en JSON.
     */
    @GET
    public Response getFilms() {
        return Response.ok(films).build(); // 200 OK avec la liste des films
    }

    /**
     * Ajouter un nouveau film.
     *
     * @param film L'objet `Film` envoyé en JSON dans la requête.
     * @return Une réponse HTTP 201 CREATED contenant le film ajouté.
     */
    @POST
    public Response postFilm(Film film) {
        films.add(film); // Ajout du film
        return Response.status(Response.Status.CREATED) // 201 Created
                .entity(film) // Retourner le film ajouté
                .build();
    }

    /**
     * Supprimer un film par son ID.
     *
     * @param id L'index du film à supprimer.
     * @return Une réponse HTTP 204 NO CONTENT si suppression réussie, sinon 404 NOT FOUND.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteFilm(@PathParam("id") int id) {
        if (id < 0 || id >= films.size()) {
            return Response.status(Response.Status.NOT_FOUND) // 404 Not Found
                    .entity("Film avec ID " + id + " introuvable.")
                    .build();
        }
        films.remove(id); // Suppression du film
        return Response.status(Response.Status.NO_CONTENT).build(); // 204 No Content
    }
}
