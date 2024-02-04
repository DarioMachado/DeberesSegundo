package ej6reto;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Ejercicio6 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("ej6reto.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("ej6.css").toExternalForm());
			primaryStage.setScene(scene);
			
			
			primaryStage.setFullScreen(true);
			primaryStage.centerOnScreen();
			primaryStage.show();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}