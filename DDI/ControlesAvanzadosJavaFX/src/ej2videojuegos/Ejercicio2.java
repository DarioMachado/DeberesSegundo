package ej2videojuegos;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;


public class Ejercicio2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("ej2videojuegos.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Videojuegos");
			//Dejar claro que los de freepik son unos pringados y que te puedes descargar las imagenes sin tener cuenta simplemente dandole a ver source code y buscando cdn-icons
			primaryStage.getIcons().add(new Image(Ejercicio2.class.getResourceAsStream("icono.png")));
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
