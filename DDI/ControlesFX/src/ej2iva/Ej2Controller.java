package ej2iva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Ej2Controller {
	
	@FXML
	private TextField importe;
	
	@FXML
	private Text resultado;
	
	@FXML
	private void calcularIVA(ActionEvent e) {
		Button botonPulsado = (Button) e.getSource();
		double iva = Double.parseDouble(
				botonPulsado.getText()
				.substring(0, botonPulsado.getText().length()-1));
		
		iva = iva/100;
		
		double num = Double.parseDouble(importe.getText());
		
		resultado.setText(""+num * iva);
		
	}
	
	@FXML
	private void limpiar() {
		importe.setText("");
		resultado.setText("");
	}
	
	@FXML
	private void salir() {
		System.exit(0);
	}

}
