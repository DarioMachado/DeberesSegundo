package ej5otroformulario;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Ej5Controller{
	
	@FXML
	private Pane rojo;
	private int nivelRojo = 0;
	
	@FXML
	private Pane verde;
	private int nivelVerde = 0;
	
	@FXML
	private Pane azul;
	private int nivelAzul = 0;
	
	
	@FXML
	private void cambiarRojo(ActionEvent e) {
			Button b = (Button)e.getSource();
			if(b.getText().equalsIgnoreCase("Menos")) {
				nivelRojo-=10;
				if(nivelRojo < 0)
					nivelRojo = 0;
			}
			if(b.getText().equalsIgnoreCase("Más")) {
				nivelRojo+=10;
				if(nivelRojo > 255)
					nivelRojo = 255;
			}
			rojo.setStyle("-fx-background-color: rgb("+nivelRojo+",0,0)");

	}


	@FXML
	private void cambiarVerde(ActionEvent e) {
		Button b = (Button)e.getSource();
		if(b.getText().equalsIgnoreCase("Menos")) {
			nivelVerde-=10;
			if(nivelVerde < 0)
				nivelVerde = 0;
		}
		if(b.getText().equalsIgnoreCase("Más")) {
			nivelVerde+=10;
			if(nivelVerde > 255)
				nivelVerde = 255;
		}
		verde.setStyle("-fx-background-color: rgb(0,"+nivelVerde+",0)");

	}
	@FXML
	private void cambiarAzul(ActionEvent e) {
		Button b = (Button)e.getSource();
		if(b.getText().equalsIgnoreCase("Menos")) {
			nivelAzul-=10;
			if(nivelAzul < 0)
				nivelAzul = 0;
		}
		if(b.getText().equalsIgnoreCase("Más")) {
			nivelAzul+=10;
			if(nivelAzul > 255)
				nivelAzul = 255;
		}
		azul.setStyle("-fx-background-color: rgb(0,0,"+nivelAzul+")");

	}

	@FXML
	private void sumar(ActionEvent e){

		Pane root = new Pane();
		Scene escena = new Scene(root,300,300);
		root.setStyle("-fx-background-color: rgb("+nivelRojo+","+nivelVerde+","+nivelAzul+")");

		Stage stage = new Stage();
		stage.setScene(escena);
		stage.setTitle("Color elegidor");
		stage.show();
	}



}
