package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static Stage stage; // set global stage object!!!

	@Override
	public void start(Stage primaryStage) {
	
		//primaryStage.hide();

		try {
			stage = primaryStage;
			FXMLLoader fxmlLoader=new FXMLLoader();
			fxmlLoader.setLocation(getClass().getResource("/views/LoginView.fxml"));
			AnchorPane root = (AnchorPane) fxmlLoader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
			stage.setTitle("Login View");
			stage.setScene(scene);
			stage.show();

		} catch (Exception e) {
			System.out.println("Error occured while inflating view: " + e);
		}
	}
	
	public static void main(String[] args) {

		launch(args);
		
	}
}
