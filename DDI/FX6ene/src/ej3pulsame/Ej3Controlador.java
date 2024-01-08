package ej3pulsame;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Ej3Controlador {
	
	
	@FXML
	private Button botoncolor;
	@FXML
	private Button botonmover;
	
	@FXML
	public void agradecer() {
		
		System.out.println("Gracias, bro...");
		
	}
	@FXML
	public void cambiarColor() {
		Random rng = new Random();
		String colores[] = {"red", "blue", "green", "yellow", "orange"};
		String color = colores[rng.nextInt(colores.length)];
		botoncolor.setStyle("-fx-background-color:"+color);
		
		
	}
	
	public void mover() {
		botonmover.setLayoutX(botonmover.getLayoutX()+10);
	}
	
	
	
}
