package ej5otroformulario;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Ej5Controller {
	
	@FXML
	private Pane rojo;
	private int nivelRojo = 0;
	
	@FXML
	private Pane verde;
	
	@FXML
	private Pane azul;
	
	
	@FXML
	private void cambiarRojo(ActionEvent e) {
		ScheduledExecutorService see = Executors.newScheduledThreadPool(1);
		see.scheduleAtFixedRate(() -> {
			Button b = (Button)e.getSource();
			if(b.getText().equalsIgnoreCase("Menos") && nivelRojo != 0) {
				nivelRojo--;
			}
			if(b.getText().equalsIgnoreCase("Más") && nivelRojo!= 255) {
				nivelRojo++;
			}
			rojo.setStyle("-fx-background-color: rgb("+nivelRojo+",0,0)");
		},0,50,TimeUnit.MILLISECONDS);
	}
	
	

}
