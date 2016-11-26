package controleur;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.UserInfo;
import modele.UserLogin;

/**
 *
 * @author Olena Lopatyuk
 */
public class ControlleurUtilisateur extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        UserLogin userLogin = (UserLogin) session.getAttribute("info");
        if(userLogin!=null){
       // modele.JDBCUtilisateurDAO dao = new JDBCUtilisateurDAO();
        UserInfo profile = UserInfo.getUserInfo(userLogin);
        request.setAttribute("profile", profile);
         //   redirect("compte_profile.jsp", response);
         forward("compte_profile.jsp", request, response);
        } else {
            session.setAttribute("forward_url", "profile");
            redirect("compte_connexion.jsp",   response);
            //forward("compte_connexion.jsp", request,  response);
        }
        
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
        HttpSession session = request.getSession();
        processRequest(request, response);
        String attr = "";
        String val = "";
        Enumeration<String> attributes = request.getParameterNames();
        UserLogin uLogin = (UserLogin) session.getAttribute("info");
        UserInfo profile = (UserInfo) session.getAttribute("profile");
         if(profile == null) {
             profile = new UserInfo();
             session.setAttribute("profile", profile);
         }
        while (attributes.hasMoreElements()) {
            attr = attributes.nextElement();
            val = request.getParameter(attr);
            switch (attr) {
                case "nom":
                    profile.setNom(val);
                    break;
                case "prenom":
                    profile.setPrenom(val);
                    break;
                case "couriel":
                    profile.setCouriel(val);
                    break;
                case "zipcode":
                    profile.setZipcode(val);
                    break;
                case "tel":
                    profile.setTelephone(val);
                    break;
//                case "login":
//                    uLogin.setLogin(val);
//                    break;
//                case "pwd":
//                    if (request.getParameter("reppwd") != null
//                            && request.getParameter("pwd").equals(request.getParameter("reppwd"))) {
//                        uLogin.setPassword(val);
//                    }
//                    break;
            }   
        }
        profile.setUserno(uLogin.getUserno());
        profile.setLogin(uLogin.getLogin());
        profile.save();
        redirect("profile", response);
    }
    
    protected void forward(String destination, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (destination != null) {
            RequestDispatcher rd = request.getRequestDispatcher(destination);
            rd.forward(request, response);
        }
    }
    
      
  private void redirect(
    String  dest, HttpServletResponse response
  ) throws IOException {
    String urlWithSessionID = response.encodeRedirectURL(dest);
    response.sendRedirect( urlWithSessionID );
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
