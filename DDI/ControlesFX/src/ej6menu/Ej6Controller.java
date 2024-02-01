package ej6menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class Ej6Controller {

	@FXML
	private void handleMenuAction(ActionEvent event) {
		String inicio = "";

		MenuItem item = (MenuItem) event.getSource();

		if(item.getParentMenu().getText().equalsIgnoreCase("File")){
			inicio = "\u001B[31m";
		}
		if(item.getParentMenu().getText().equalsIgnoreCase("Edit")) {
			inicio = "\u001B[32m";
		}
		if(item.getParentMenu().getText().equalsIgnoreCase("View")) {
			inicio = "\u001B[34m";
		}

		System.out.println(inicio+"Se ha pulsado la opción: "+item.getText());
	}
}
