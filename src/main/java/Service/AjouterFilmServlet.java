package Service;

import Dao.ImplFilm;
import Metier.Film;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/ajouterFilm")
@MultipartConfig( // Active le support des fichiers
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB avant d'écrire sur disque
        maxFileSize = 1024 * 1024 * 10,      // 10MB pour un fichier
        maxRequestSize = 1024 * 1024 * 50    // 50MB pour la requête complète
)
public class AjouterFilmServlet extends HttpServlet {
    private ImplFilm filmDao;

    @Override
    public void init() throws ServletException {
        filmDao = new ImplFilm();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            String director = request.getParameter("director");
            String actors = request.getParameter("actors");
            String writer = request.getParameter("writer");
            String description = request.getParameter("description");

            Part filePart = request.getPart("bimg");
            String fileName =Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String Images = getServletContext().getRealPath("") + File.separator + "Images";

            // Vérifier si le dossier "Images" existe, sinon le créer
            File ImagesDir = new File(Images);
            if (!ImagesDir.exists()) {
                ImagesDir.mkdir();
            }

            // Enregistrer le fichier sur le serveur
            String filePath = Images + File.separator + fileName;
            filePart.write(filePath);

            if (title == null || genre == null || director == null || actors == null || writer == null || description == null || fileName == null) {
                request.getSession().setAttribute("message", "Veuillez remplir tous les champs ! ");
                System.out.println("Veuillez remplir tous les champs !");
                return;
            }
//                public Film(String title, String genre, int year, String director, String actors, String writer, String description, String imageUrl) {


                Film film = new Film(title, genre, year, director, actors, writer, description, "Images/" +fileName);

            filmDao.AddFilm(film);
            request.getSession().setAttribute("message", "Film ajouté avec succès !");
            response.sendRedirect(request.getContextPath() + "/admin/home.jsp");

            // Rediriger vers la page principale
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("message", "Erreur lors de l'ajout du film !");
            response.sendRedirect(request.getContextPath() + "/admin/home.jsp");



        }
    }
}