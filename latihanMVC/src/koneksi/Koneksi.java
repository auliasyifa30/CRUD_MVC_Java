package koneksi;

//untuk library mysql data connection 
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
//library try catch
import java.sql.SQLException;

public class Koneksi {

    //conn adalah variabel
    static Connection conn;

    //getConnection adalah variabel
    public static Connection getConnection() {
        if (conn == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("user_management");
            data.setUser("root");
            data.setPassword("");
            try {
                conn = data.getConnection();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }

}
