package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.DBConnect;

public class LoginModel extends DBConnect {
 
	private Boolean admin;
	private int id;
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Boolean isAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
		
	public Boolean getCredentials(String username, String password){
           
        	String query = "SELECT * FROM xy_users WHERE UserName = ? and Password = ?;";
            try(PreparedStatement stmt = connection.prepareStatement(query)) {
               stmt.setString(1, username);
               stmt.setString(2, password);
               ResultSet rs = stmt.executeQuery();
                if(rs.next()) { 
                 
                	setId(rs.getInt("id"));
                	setAdmin(rs.getBoolean("admin"));
                	return true;
               	}
             }catch (SQLException e) {
            	e.printStackTrace();   
             }
			return false;
    }

}//end class