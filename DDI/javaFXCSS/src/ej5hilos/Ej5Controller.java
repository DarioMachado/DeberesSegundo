package ej5hilos;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class Ej5Controller implements Initializable{

	@FXML
	private Button hola;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Thread thread = new Thread(() -> { 
			try {
				Thread.sleep(3000);
				Platform.runLater(() -> {
					hola.setText("¡Hilo ejecutado");
					hola.setAlignment(Pos.CENTER);
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			});
		thread.start();
	}

}
