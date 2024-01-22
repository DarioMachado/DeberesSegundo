package ej3formulario;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class Ej3Controller implements Initializable{
	
	@FXML
	private ComboBox<String> cbServicios;
	
	@FXML
	private RadioButton rbParticular;
	
	@FXML
	private RadioButton rbEmpresa;
	
	private ObservableList<String> pagos = FXCollections.observableArrayList("Contado", "Transferencia", "Paypal");
	
	@FXML
	private ChoiceBox<String> chbPagos;
	
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		if(cbServicios == null) {
			cbServicios = new ComboBox<>();
		}
		ObservableList<String> items = FXCollections.observableArrayList("Opción 1", "Opción 2", "Opción 3");
		cbServicios.setItems(items);
		
		if(cbServicios.getValue() == null) {
			cbServicios.setValue(items.get(0)); //Esto tiene más sentido
		}
		
		ToggleGroup toggleGroup = new ToggleGroup();
		rbParticular.setToggleGroup(toggleGroup);
		rbEmpresa.setToggleGroup(toggleGroup);
		
		
	}
	
	
	
}
