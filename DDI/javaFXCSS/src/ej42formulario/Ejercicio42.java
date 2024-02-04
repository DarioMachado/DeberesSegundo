package ej42formulario;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.fxml.FXMLLoader;


public class Ejercicio42 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("ej42formulario.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("ej42.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
