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
 * @author Dan-Ghenadie Roman
 *
 */
public class JDBCAnnonceDAO implements AnnonceDAO {

    Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            if (connection == null) {
                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "scott");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insert(Annonce annonce) {
        try {
            PreparedStatement preparedStatement
                    = connection.prepareStatement("INSERT INTO annonces (id, nom, dateAnnonce, details, image) VALUES (seqAnnonces.nextval , ?, ?, ?, ?)");
            preparedStatement.setString(1, annonce.getNom());
            preparedStatement.setDate(2, new Date(0));
            preparedStatement.setString(3, annonce.getDetails());
            preparedStatement.setString(4, annonce.getImage());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public List<Annonce> select() {

        List<Annonce> annonces = new LinkedList<Annonce>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Annonces ORDER BY id DESC");

            Annonce annonce = null;
            while (resultSet.next()) {
                annonce = new Annonce();
                annonce.setId(Integer.parseInt(resultSet.getString("id")));
                annonce.setNom(resultSet.getString("nom"));
                annonce.setDate(resultSet.getDate("dateAnnonce"));
                annonce.setDetails(resultSet.getString("details"));
                annonce.setImage(resultSet.getString("image"));

                annonces.add(annonce);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(annonces);
        return annonces;
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