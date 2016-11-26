/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modele.UserInfo;
import modele.UserLogin;

/**
 *
 * @author Myasus
 */
@WebServlet(name = "UploadPhoto", urlPatterns = {"/UploadPhoto"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // // 10MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 10)	// // 10MB
public class UploadPhoto extends HttpServlet {

    private static final String SAVE_DIR = "Profile";

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
        HttpSession session = request.getSession();
        UserLogin user = (UserLogin)session.getAttribute("info");
        if(user == null) redirect("compte_connexion.jsp",   response);
        String fname = "";
        String fileName = "";
        fname = user.getLogin();
        String savePath= request.getServletContext().getInitParameter("server.Sauvegardes") + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        int i = 0;
        for (Part part : request.getParts()) {
            if (i > 0) {
                break; //seuement 1 photo
            }
            String s = extractFileName(part);
            String ext = s.substring(s.lastIndexOf('.') , s.length());
            fileName =   fname +  ext;
            File file = new File(savePath, fileName);
            try  {
                 InputStream input = part.getInputStream();
                 Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            catch(Exception ex){
                 ex.getMessage();
            }
            i++;
        }
        UserInfo ui =  (UserInfo)session.getAttribute("profile");
        if(ui == null) ui = UserInfo.getUserInfo(user);
        ui.setPhoto(fileName);
        ui.save();
        redirect("profile", response);

    }

    private void redirect(
            String dest, HttpServletResponse response
    ) throws IOException {
        String urlWithSessionID = response.encodeRedirectURL(dest);
        response.sendRedirect(urlWithSessionID);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("\"") + 1, s.length() - 1);
            }
        }
        return "";
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
