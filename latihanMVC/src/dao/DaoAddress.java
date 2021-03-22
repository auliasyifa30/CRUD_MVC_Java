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
import model.Address;

public class DaoAddress {
    
    //mengarahkan ke class koneksi
    Connection connection = Koneksi.getConnection();
    private List<Address> listAdress;
    
    //tambah data address
    public boolean insert(Address address) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("INSERT INTO address (prefix, address_id, street1, street2, village_id) VALUES (?,?,?,?,?);");
            statement.setString(1, address.getPrefix());
            statement.setInt(2, address.getAddressId());
            statement.setString(3, address.getStreet1());
            statement.setString(4, address.getStreet2());
            statement.setInt(5, address.getVillageId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
     public boolean update(Address address) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("UPDATE address SET street1=?,  village_id=? WHERE address_id=? ;");
            statement.setInt(3, address.getAddressId());
            statement.setString(1, address.getStreet1());
            statement.setInt(2, address.getVillageId());
            statement.executeUpdate(); //execute
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    //menghapus data
    public boolean delete(Address address) {
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement("DELETE FROM address WHERE address_id=? ;");
            statement.setInt(1, address.getAddressId()); //set
            statement.executeUpdate(); //execute
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //melihat list data 
    public List<Address> getAll() {
       List<Address> listAddress = new ArrayList<Address>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM address");
            while (rs.next()) {
                listAddress.add(new Address(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listAddress;
    }
}
