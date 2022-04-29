package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicLong;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import models.ClientModel;
 
public class ClientController implements Initializable {
	
	static int userid;
	ClientModel cm;
	
	/***** TABLEVIEW intel *********************************************************************/

	@FXML
	private TableView<ClientModel> tblTennisCourseView;
	@FXML
	private TableColumn<ClientModel, String> courseID;
	@FXML
	private TableColumn<ClientModel, String> date;
	@FXML
	private TableColumn<ClientModel, String> availiable;

	public void initialize(URL location, ResourceBundle resources) {
		courseID.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("courseID"));
		date.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("date"));
		availiable.setCellValueFactory(new PropertyValueFactory<ClientModel, String>("availiable"));

		// auto adjust width of columns depending on their content
		tblTennisCourseView.setColumnResizePolicy((param) -> true);
		Platform.runLater(() -> customResize(tblTennisCourseView));

		tblTennisCourseView.setVisible(false); // set invisible initially
	}

    public void customResize(TableView<?> view) {

        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth()+((tableWidth-width.get())/view.getColumns().size()));
            });
        }
    }
    
	/*public void viewTennisCourse() throws IOException {

		tblAccounts.getItems().setAll(cm.getAccounts(userid)); // load table data from ClientModel List
		tblAccounts.setVisible(true); // set tableview to visible if not
		
		System.out.println(cm.getClientInfo());

	}*/

	/***** End TABLEVIEW intel *********************************************************************/

	public void logout() {
		// System.exit(0);
		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/LoginView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/styles.css").toExternalForm());
			Main.stage.setScene(scene);
			Main.stage.setTitle("Login");
		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}

	public void viewTennisCourse() {

		//tblTennisCourseView.getItems().setAll(cm.getAccounts(userid));
		
		
	}

	public static void setUserid(int user_id) {
		userid = user_id;
		System.out.println("Welcome id " + userid);
	}

	public ClientController() {

		/*
		 * Alert alert = new Alert(AlertType.INFORMATION);
		 * alert.setTitle("From Customer controller");
		 * alert.setHeaderText("Bank Of IIT- Chicago Main Branch");
		 * alert.setContentText("Welcome !"); alert.showAndWait();
		 */

		cm = new ClientModel();

	}

}
