package Service;

import Metier.Place;
import Metier.Salle;
import Dao.ImplISalle;
import Metier.User;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/addSalle")
public class AddSalleServlet extends HttpServlet {
    ImplISalle implISalle;

    public void init(ServletConfig config) throws ServletException {
        super.init();
        implISalle = new ImplISalle();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numero = request.getParameter("numero");
        int capacite = Integer.parseInt(request.getParameter("capacite"));
        if(numero == null || numero.isEmpty()||capacite == 0){
            request.getSession().setAttribute("message", "Veuillez remplir tous les champs !");
            request.getRequestDispatcher("/admin/SallesAD.jsp").forward(request, response);
            return;
        }
        try {
            Salle s =new Salle(numero,capacite);
            for(int i=1;i<=capacite;i++){
                Place place =  new Place(false,i,s);
                s.getPlaces().add(place);
            }
            implISalle.ajouterSalle(s);
            request.getSession().setAttribute("message","Salle ajoutee avec succès!");
            response.sendRedirect(request.getContextPath() + "/admin/SallesAD.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("message",  "Erreur lors de l'ajout de la salle !");
            request.getRequestDispatcher("/admin/SallesAD.jsp").forward(request, response);
        }
    }
}