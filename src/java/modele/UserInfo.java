/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Olena Lopatyuk
 */
public class UserInfo {

    /**
     * @return the userno
     */
    public int getUserno() {
        return userno;
    }

    /**
     * @param userno the userno to set
     */
    public void setUserno(int userno) {
        this.userno = userno;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the couriel
     */
    public String getCouriel() {
        return couriel;
    }

    /**
     * @param couriel the couriel to set
     */
    public void setCouriel(String couriel) {
        this.couriel = couriel;
    }

    /**
     * @return the zipcode
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    private int userno;
    private String login;
    private String nom;
    private String prenom;
    private String couriel;
    private String zipcode;
    private String telephone;
    
    public UserInfo(){}
    
    public UserInfo(int userno, String login, String nom, String couriel, String zipcode, String telephone) {
        this.userno = userno;
        this.login = login;
        this.nom = nom;
        this.couriel = couriel;
        this.zipcode = zipcode;
        this.telephone = telephone;
    }

    public static UserInfo getUserInfo(UserLogin ul){
        JDBCUtilisateurDAO dao = new JDBCUtilisateurDAO();
        return dao.getUserInfo(ul);
    }
    
    public void save(){
        //TODO write changes to DB
        JDBCUtilisateurDAO dao = new JDBCUtilisateurDAO();
        dao.updateUserInfo(this);
    }
    
    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    
}
