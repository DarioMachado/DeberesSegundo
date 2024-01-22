package ej1calcular;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Ej1Controller {
	
	@FXML
	private TextField op1;
	
	@FXML
	private TextField op2;
	
	@FXML
	private Text resultado;
	
	@FXML
	private void calcular(ActionEvent e) {
		System.out.println("hola");
		Button botonPulsado = (Button) e.getSource();
		String cuenta = botonPulsado.getText();
		
		double num1 = Double.parseDouble(op1.getText());
		double num2 = Double.parseDouble(op2.getText());
		double resultado = 0;
		switch(cuenta.toUpperCase()) {
				
		case "SUMAR":
			resultado = num1 + num2;
			break;
		case "RESTAR":
			resultado = num1 - num2;
			break;
		case "MULTIPLICAR":
			resultado = num1 * num2;
			break;
		case "DIVIDIR":
			try {
			resultado = num1 / num2;
			}catch(Exception exc) {
				resultado = 0; 
			}
			break;
		}
		this.resultado.setText(resultado+"");
		
	}
	
	@FXML
	private void limpiar() {
		this.op1.setText("");
		this.op2.setText("");
		this.resultado.setText("");
	}
	
	@FXML
	private void salir() {
		System.exit(0);
	}
	
}
