/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                //connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
                connection = DriverManager.getConnection(DBConnectionString.getUrl(), DBConnectionString.getUser(), DBConnectionString.getPassword());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void createUser(UserLogin login) {

        try {
            Connection conn = getConnection();

            PreparedStatement preparedStatement
                    = conn.prepareStatement("INSERT INTO users (userno, login, pwd) "
                            + "VALUES (users_seq.nextval , ?, ?)");
            preparedStatement.setString(1, login.getLogin());
            preparedStatement.setString(2, login.getPassword());

            preparedStatement.executeUpdate();

            preparedStatement.close();

            createUserInfo(login);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public UserInfo getUserInfo(UserLogin uLogin) {
        UserInfo uInfo = null;
        Connection conn = getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement("SELECT * FROM userinfo WHERE userno = ?");
            statement.setString(1, String.valueOf(uLogin.getUserno()));
            resultSet = statement.executeQuery();
            uInfo = new UserInfo();
            uInfo.setUserno(uLogin.getUserno());
            uInfo.setLogin(uLogin.getLogin());
            int i = 0;
            while (resultSet.next()) {
                uInfo.setNom(resultSet.getString("nom"));
                uInfo.setPrenom(resultSet.getString("prenom"));
                uInfo.setZipcode(resultSet.getString("zipcode"));
                uInfo.setCouriel(resultSet.getString("couriel"));
                uInfo.setTelephone(resultSet.getString("telephone"));
                uInfo.setPhoto(resultSet.getString("photo"));
                i++;
            }
            resultSet.close();
            statement.close();
            if(i==0) createUserInfo(uLogin);            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uInfo;
    }

    public void updateUserInfo(UserInfo ui) {

        Connection conn = getConnection();
        try {
            PreparedStatement preparedStatement
                    = conn.prepareStatement("UPDATE userinfo SET "
                            + " nom = ? , prenom = ? , zipcode = ? , couriel = ? , telephone= ? , photo=?"
                            + "where userno = ?"
                    );
            preparedStatement.setString(1, ui.getNom());
            preparedStatement.setString(2, ui.getPrenom());
            preparedStatement.setString(3, ui.getZipcode());
            preparedStatement.setString(4, ui.getCouriel());
            preparedStatement.setString(5, ui.getTelephone());
            preparedStatement.setString(6, ui.getPhoto());
            preparedStatement.setString(7, String.valueOf(ui.getUserno()));

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updatePassword(UserLogin u) {

        Connection conn = getConnection();
        try {
            PreparedStatement preparedStatement
                    = conn.prepareStatement("UPDATE users SET "
                            + " login = ? , pwd = ? "
                            + "where userno = ?"
                    );
            preparedStatement.setString(1, u.getLogin());
            preparedStatement.setString(2, u.getPassword());
            preparedStatement.setString(3, String.valueOf(u.getUserno()));

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void createUserInfo(UserLogin login) throws SQLException {
        int id = getUserId(login.getLogin());
        Connection conn = getConnection();
        PreparedStatement preparedStatement
                = conn.prepareStatement("INSERT INTO userinfo (userno) "
                        + "VALUES ( ?)");
        preparedStatement.setString(1, String.valueOf(id));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public int checkPassword(String login, String password) {
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

        return userno;

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
