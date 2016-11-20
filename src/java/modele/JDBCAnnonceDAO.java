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
//                connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "scott");
                connection = DriverManager.getConnection("jdbc:oracle:thin:@oracleadudb1.bdeb.qc.ca:1521:GDNA10", "UG200E19", "U927fc");

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
                    = connection.prepareStatement("INSERT INTO annonces (id, typeAnnonce, typeAnimal, sex, age, dateAnnonce, details, image) "
                            + "VALUES (seqAnnonces.nextval , ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, annonce.getTypeAnnonce());
            preparedStatement.setString(2, annonce.getTypeAnimal());
            preparedStatement.setString(3, annonce.getSex());
            preparedStatement.setInt(4, annonce.getAge());
            preparedStatement.setDate(5, new Date(2016, 11, 15));
            preparedStatement.setString(6, annonce.getDetails());
            preparedStatement.setString(7, annonce.getImage());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Annonce> select() {

        List<Annonce> annonces = new LinkedList<Annonce>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Annonces ORDER BY dateAnnonce DESC");

            Annonce annonce = null;
            while (resultSet.next()) {
                annonce = new Annonce();
                annonce.setId(Integer.parseInt(resultSet.getString("id")));
                annonce.setTypeAnnonce(resultSet.getString("typeAnnonce"));
                annonce.setTypeAnimal(resultSet.getString("typeAnimal"));
                annonce.setSex(resultSet.getString("sex"));
                annonce.setAge(resultSet.getInt("age"));
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

    @Override
    public List<Annonce> select(Chercher chercher) {
        List<Annonce> annonces = new LinkedList<Annonce>();
        try {
            System.out.println("select(chercher): " + chercher);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from annonces "
                    + "where (typeAnnonce = ? and typeAnimal = ? and sex = ? and  age >= ? and age <= ?)");

            preparedStatement.setString(1, chercher.getTypeAnnonce());
            preparedStatement.setString(2, chercher.getTypeAnimal());
            preparedStatement.setString(3, chercher.getSex());
            preparedStatement.setString(4, String.valueOf(chercher.getAgeMin()));
            preparedStatement.setString(5, String.valueOf(chercher.getAgeMax()));

            ResultSet resultSet = preparedStatement.executeQuery();

            Annonce annonce = null;
            while (resultSet.next()) {
                annonce = new Annonce();
                annonce.setId(Integer.parseInt(resultSet.getString("id")));
                annonce.setTypeAnnonce(resultSet.getString("typeAnnonce"));
                annonce.setTypeAnimal(resultSet.getString("typeAnimal"));
                annonce.setSex(resultSet.getString("sex"));
                annonce.setAge(resultSet.getInt("age"));
                annonce.setDate(resultSet.getDate("dateAnnonce"));
                annonce.setDetails(resultSet.getString("details"));
                annonce.setImage(resultSet.getString("image"));

                annonces.add(annonce);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonces;
    }
}
