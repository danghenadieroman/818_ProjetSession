package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Annonce;
import modele.JDBCAnnonceDAO;

/**
 *
 * @author Irina Meghi-Roman
 */
public class ControleurIndex extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String destination = "index.jsp";
//        List catalogue = creerListeAnnonces();
        List catalogue = null;

        Annonce annonce = new Annonce();
        annonce.setNom("Test insert nom 3");
        annonce.setDate(new Date());
        annonce.setDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc");
        annonce.setImage("images/gallery/cats/cat01.jpg");

        JDBCAnnonceDAO jdbcAnnonceDAO = new JDBCAnnonceDAO();

        jdbcAnnonceDAO.getConnection();

//        jdbcAnnonceDAO.insert(annonce);
        
        catalogue = jdbcAnnonceDAO.select();
        jdbcAnnonceDAO.closeConnection();

        if (catalogue != null) {
            request.setAttribute("catalogue", catalogue);
        } else {
            annonce = new Annonce();
            annonce.setNom("Aucun annonce");
            annonce.setDate(new Date());
            annonce.setDetails("");
            annonce.setImage("");
            catalogue.add(annonce);
            request.setAttribute("catalogue", catalogue);
        }

        dispatch(destination, request, response);

    }

    protected void dispatch(String destination, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (destination != null) {
            RequestDispatcher rd = request.getRequestDispatcher(destination);
            rd.forward(request, response);
        }
    }

    protected List creerListeAnnonces() {

        List registre = new ArrayList();

        Annonce annonce = new Annonce();
        annonce.setNom("Chat1");
        annonce.setDate(new Date());
        annonce.setDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc");
        annonce.setImage("images/gallery/cats/cat02.jpg");
        registre.add(annonce);

        annonce = new Annonce();
        annonce.setNom("Chat2");
        annonce.setDate(new Date());
        annonce.setDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc");
        annonce.setImage("images/gallery/cats/cat01.jpg");
        registre.add(annonce);

        annonce = new Annonce();
        annonce.setNom("Dog");
        annonce.setDate(new Date());
        annonce.setDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc");
        annonce.setImage("images/gallery/dogs/dog01.jpg");
        registre.add(annonce);

        annonce = new Annonce();
        annonce.setNom("Poisson");
        annonce.setDate(new Date());
        annonce.setDetails("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec odio. Praesent libero. Sed cursus ante dapibus diam. Sed nisi. Nulla quis sem at nibh elementum imperdiet. Duis sagittis ipsum. Praesent mauris. Fusce nec tellus sed augue semper porta. Mauris massa. Vestibulum lacinia arcu eget nulla. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur sodales ligula in libero. Sed dignissim lacinia nunc");
        annonce.setImage("images/gallery/fish/f1.jpg");
        registre.add(annonce);

        return registre;

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
