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

@WebServlet("/modifierFilm")
@MultipartConfig( // Active le support des fichiers
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB avant d'écrire sur disque
        maxFileSize = 1024 * 1024 * 10,      // 10MB pour un fichier
        maxRequestSize = 1024 * 1024 * 50    // 50MB pour la requête complète
)
public class ModifierFilmServlet extends HttpServlet {
    private ImplFilm filmDao;

    @Override
    public void init() throws ServletException {
        filmDao = new ImplFilm();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            int year = Integer.parseInt(request.getParameter("year"));
            String director = request.getParameter("director");
            String actors = request.getParameter("actors");
            String writer = request.getParameter("writer");
            String description = request.getParameter("description");

            String oldImage = request.getParameter("oldImage");

            Part filePart = request.getPart("bimg");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

            // Vérifier si le dossier "uploads" existe, sinon le créer
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // Enregistrer le fichier sur le serveur
            if(fileName != null && !fileName.isEmpty()){
                String filePath = uploadPath + File.separator + fileName;
                filePart.write(filePath);
            }else {
                fileName = oldImage;
            }

            if (title == null || genre == null || director == null || actors == null || writer == null || description == null || fileName == null) {
                request.getSession().setAttribute("message", "Erreur lors de la modification du film !(Veuillez remplir tous les champs !) ");
                response.sendRedirect(request.getContextPath() + "/admin/DetailFilm.jsp");

                System.out.println("Veuillez remplir tous les champs !");
                return;
            }

            Film film = new Film(id,title, genre, year, director, actors, writer, description, fileName);

            filmDao.UpdateFilm(film);
            request.getSession().setAttribute("message", "Film modifie avec succès !");
            response.sendRedirect(request.getContextPath() + "/admin/DetailFilm.jsp?id=" + film.getId());


        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("message", "Erreur lors de la modification du film !");
            response.sendRedirect(request.getContextPath() + "/admin/home.jsp");
        }
    }
}