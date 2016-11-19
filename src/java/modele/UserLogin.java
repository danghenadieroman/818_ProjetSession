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
public class UserLogin {

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
    private int userno;
    private String login;
    private String password;

    public UserLogin(){}
    
     public UserLogin(int _userno, String _login, String _pwd){
        this.setLogin(_login);
        this.setPassword(_pwd);
        this.setUserno(_userno); 
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void save(){
        JDBCUtilisateurDAO dao = new JDBCUtilisateurDAO();
        dao.updatePassword(this);
    }
    
}
