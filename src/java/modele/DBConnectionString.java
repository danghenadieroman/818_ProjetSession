package modele;

/**
 *
 * @author Olena Lopatyuk
 */
class DBConnectionString {

    static final String url = "jdbc:oracle:thin:@oracleadudb1.bdeb.qc.ca:1521:GDNA10";
    static String user = "UG3ED01";
    static String password = "hmqm28";

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }
}
