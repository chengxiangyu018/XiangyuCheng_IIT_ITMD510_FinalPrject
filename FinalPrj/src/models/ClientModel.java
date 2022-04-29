package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import Dao.DBConnect;

public class ClientModel extends DBConnect {

	private int cid;
	private int tid;
	private double balance;

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;
	

	public ClientModel() {

		conn = new DBConnect();
	}
 

	

}