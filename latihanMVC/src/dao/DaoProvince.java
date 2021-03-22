package dao;

//library
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import koneksi.Koneksi;
import model.Province;

public class DaoProvince {
    
    //koneksi
    Connection connection = Koneksi.getConnection();
    
    //menambah data
    public boolean insert(Province province) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO province (province_id, province_name) VALUES (?, ?);");
            statement.setInt(1, province.getProvinceId()); //set
            statement.setString(2, province.getProvinceName()); //set
            statement.executeUpdate(); //execute
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    //mengubah data nama, berdasarkan id
    public boolean update(Province province) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("UPDATE province SET province_name=? WHERE province_id=? ;");
            statement.setString(1, province.getProvinceName());
            statement.setInt(2, province.getProvinceId());
            statement.executeUpdate();
            statement.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    //menghapus data
   public boolean delete(Province province) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("DELETE FROM  province  WHERE province_id=?;");
            statement.setInt(1, province.getProvinceId()); //set
            statement.executeUpdate(); //execute
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    //melihat list data
    public List<Province> getAll() {
        List<Province> listProvince = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PROVINCE");
            while (rs.next()) {
                listProvince.add(new Province(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listProvince;
    }

}