package controleur;

import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Dan-Ghenadie Roman
 */
public class ControlleurPublier extends HttpServlet {

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
        JDBCAnnonceDAO jdbcAnnonceDAO = new JDBCAnnonceDAO();
        jdbcAnnonceDAO.getConnection();

        if (request.getParameter("submit") != null) {

            Annonce annonce = new Annonce();
            annonce.setTypeAnnonce(request.getParameter("radioTypeAnnonce"));
            annonce.setTypeAnimal(request.getParameter("radioTypeAnimal"));
            annonce.setSex(request.getParameter("radioSex"));
            annonce.setAge(Integer.parseInt(request.getParameter("age")));
            annonce.setDate(new Date());//a faire
            annonce.setDetails(request.getParameter("details"));
            annonce.setImage(request.getParameter("image"));

            destination = "index.jsp";

            jdbcAnnonceDAO.insert(annonce);

            //il faut remplir catalogue pour pouvoir afficher le catalogue dans index.jsp
            //sinon il va montrer liste vide
            List catalogue = jdbcAnnonceDAO.select();
            if (catalogue != null) {
                request.setAttribute("catalogue", catalogue);
            } else {
                request.setAttribute("catalogue", null);
            }

        } else {
            destination = "annonce_publier.jsp";
        }

        jdbcAnnonceDAO.closeConnection();
        dispatch(destination, request, response);
    }

    protected void dispatch(String destination, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (destination != null) {
            RequestDispatcher rd = request.getRequestDispatcher(destination);
            rd.forward(request, response);
        }
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
