package controllers;

import java.sql.SQLException;
import java.sql.Statement;

import Dao.DBConnect;
import application.DynamicTable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class AdminController {

	@FXML
	private Pane pane1;
	@FXML
	private Pane pane2;
	@FXML
	private Pane pane3;
	@FXML
	private TextField textEnrollment;
	@FXML
	private TextField textCourseID;
	@FXML
	private TextField textUserName;
	@FXML
	private TextField textDate;
	
	@FXML
	private TextField textTennisCID;
	
	@FXML
	private TextField textTDate;
	@FXML
	private TextField textAvailable;
	
	@FXML
	private TextField textDelete;
	
	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;

	public AdminController() {
		conn = new DBConnect();
	}

	public void viewEnrollment() {

		DynamicTable d = new DynamicTable();
		// call method from DynamicTable class and pass some arbitrary query string
		d.buildData("Select * from xy_enrollment");
	}

	public void updateRec() {

		pane3.setVisible(false);
		pane2.setVisible(false);
		pane1.setVisible(true);

	}

	public void deleteRec() {

		pane1.setVisible(false);
		pane2.setVisible(true);
		pane3.setVisible(false);
	}

	public void addEnrollment() {

		pane1.setVisible(false);
		pane2.setVisible(false);
		pane3.setVisible(true);

	}

	public void submitInsert() {

		// INSERT INTO ENROLLMENT TABLE
		try {
			// Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.getConnection().createStatement();
			String sql = null;

			// Include all object data to the database table
			
			sql = "insert into xy_enrollment(EnrollmentID,UserName,Course,Date)"+ "values('" + textEnrollment.getText() + "','" + textUserName.getText() + "','" + textCourseID.getText()
					+ "','" + textDate.getText() + "')";
			stmt.executeUpdate(sql);
			System.out.println("Enrollment created");

			conn.getConnection().close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public void submitUpdate() {

				try {
					// Execute a query
					System.out.println("Update Submit button pressed");
					stmt = conn.getConnection().createStatement();
					String sql = null;

					sql = "update xy_tenniscourse set Available = "+textAvailable.getText()+" where CourseID = "+textTennisCID.getText()+" AND Date = "+"'"+textTDate.getText()+"'";
					stmt.executeUpdate(sql);
					System.out.println("Tenniscourse update");

					conn.getConnection().close();
				} catch (SQLException se) {
					se.printStackTrace();
				}

	}

	public void submitDelete() {

		try {
			// Execute a query
			System.out.println("Delete Submit button pressed");
			stmt = conn.getConnection().createStatement();
			String sql = null;

			sql = "delete from xy_enrollment where EnrollmentId ="+textDelete.getText() ;
			stmt.executeUpdate(sql);
			System.out.println("Tenniscourse update");

			conn.getConnection().close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		

	}

}
