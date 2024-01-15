package ej4vboxY5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Ej4Controlador {
	@FXML
	Button button1, button2, button3, button4;
	@FXML
	private void decirNombre(ActionEvent e) {
		String texto = ((Button)e.getSource()).getText();
		System.out.println("Has pulsado el "+texto);
	}

}
