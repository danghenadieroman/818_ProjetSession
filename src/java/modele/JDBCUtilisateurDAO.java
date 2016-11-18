/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Olena Lopatyuk
 */
public class JDBCUtilisateurDAO {
     Connection connection = null;
     
        public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
   
        
        
        public void insert(UserLogin login) {
            
            try {
                Connection conn = getConnection();
                
                PreparedStatement preparedStatement
                        = conn.prepareStatement("INSERT INTO users (userno, login, pwd) "
                                + "VALUES (users_seq.nextval , ?, ?)");
                preparedStatement.setString(1, login.getLogin());
                preparedStatement.setString(2, login.getPassword());

                preparedStatement.executeUpdate();
                
                preparedStatement.close();
                //conn.commit();
                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           
        }
        
        public boolean checkPassword(String login, String password){
            int userno = -1;
            Connection conn = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement("SELECT * FROM Users WHERE login = ? and pwd = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                userno = Integer.parseInt(resultSet.getString("userno"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return userno > 0;    
            
        }
        
        public int getUserId(String login) {
        int res = -1;
        Connection conn = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement("SELECT * FROM Users WHERE login = ?");
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                res = Integer.parseInt(resultSet.getString("userno"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            return res;
        }
        
        
        }
        
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
        }
    }
}
