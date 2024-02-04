package ej42formulario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Ej42Controller implements Initializable{
	
	@FXML
	private ComboBox<String> cbServicios;
	
	@FXML
	private RadioButton rbParticular;
	
	@FXML
	private RadioButton rbEmpresa;
	
	private ObservableList<String> pagos = FXCollections.observableArrayList("Contado", "Transferencia", "Paypal");
	
	@FXML
	private ChoiceBox<String> chbPagos;
	
	ToggleGroup toggleGroup = new ToggleGroup();
	
	@FXML
	private CheckBox tv, tlf, wifi;
	
	@FXML
	private DatePicker fecha;
	
	@FXML
	private ColorPicker color;
	
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
		
		
		rbParticular.setToggleGroup(toggleGroup);
		rbEmpresa.setToggleGroup(toggleGroup);
		
		chbPagos.setItems(pagos);
		if(chbPagos.getValue() == null)
			chbPagos.setValue(pagos.get(0));
		
	}
	@FXML
	private void mostrarResultado() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ej42respuesta.fxml"));
			Parent root = loader.load();
			RespuestaController respuestaController = loader.getController();
			
			StringBuilder resultado = new StringBuilder();
			resultado.append("ComboBox: ").append(cbServicios.getValue()).append("\n");
			
			resultado.append("Forma de pago: ").append(chbPagos.getValue()).append("\n");
			
			RadioButton eleccion = (RadioButton) toggleGroup.getSelectedToggle();
			
			if(eleccion!=null)
				resultado.append("Es ").append(eleccion.getText()+"\n");
			
			boolean algo = false;
			resultado.append("Tiene contratado: ");
			if(tv.isSelected()) {
				resultado.append("Televisión ");
				algo = true;
			}
			if(tlf.isSelected()) {
				resultado.append("Teléfono ");
				algo = true;
			}
			if(wifi.isSelected()) {
				resultado.append("Wi-Fi");
				algo = true;
			}
			if(!algo)
				resultado.append("Nada");
			
			resultado.append("\n");
			
			if(fecha.getValue()!=null)
				resultado.append("Fecha: ").append(fecha.getValue()).append("\n");
			if(color.getValue()!=null)
				resultado.append("Color elegido: ").append(color.getValue()).append("\n");
			
			
			
			respuestaController.resultado.setText(resultado.toString());
			
			Stage stage = new Stage();
			stage.setScene(new Scene(root,300,200));
			stage.setTitle("Resultado");
			stage.show();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
