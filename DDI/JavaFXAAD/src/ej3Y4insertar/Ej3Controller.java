package ej3Y4insertar;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import application.TVideojuego;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Ej3Controller implements Initializable{
	@FXML
	private TableView<TVideojuego> tabla;
	@FXML
	private TableColumn<TVideojuego, String> tcNombre;
	@FXML
	private TableColumn<TVideojuego, Integer> tcYear;
	@FXML
	private TableColumn<TVideojuego, String> tcCompania;
	@FXML
	private TableColumn<TVideojuego, Double> tcPrecio;
	@FXML
	private TableColumn<TVideojuego, String> tcSinopsis;
	@FXML
	private TableColumn<TVideojuego, String> tcPlataforma;
	
	private TVJModel3 model;
	
	@FXML
	private TextField tfNombre;
	@FXML
	private TextField tfYear;
	@FXML
	private ComboBox<String> cbCompania;
	@FXML
	private TextField tfPrecio;
	@FXML
	private TextField tfSinopsis;
	@FXML
	private ComboBox<String> cbPlataforma;
	@FXML
	private Button bAgregar;
	@FXML
	private Button bLimpiar;
	@FXML
	private Button bBorrar;
	
	private void inicializar(String url, String usuario, String pass) throws SQLException {
		
		model = new TVJModel3(url, usuario, pass);
		
		bAgregar.setOnAction(event -> agregarJuego());
		
		cargarCompanias();
		cargarPlataformas();
		
		bLimpiar.setOnAction(event -> limpiarCampos());
		
		bBorrar.setOnAction(event -> borrarJuego());
	}
	
	private void cargarCompanias() {
		List<String> companias = List.of("EA", "Ubisoft", "Activision", "Nintendo", "Sony", "Microsoft");
		cbCompania.setItems(FXCollections.observableArrayList(companias));
	}
	
	private void cargarPlataformas() {
		List<String> plataformas = List.of("PC", "PlayStation", "Xbox", "Nintendo Switch");
		cbPlataforma.setItems(FXCollections.observableArrayList(plataformas));
	}
	
	@FXML
	private void agregarJuego() {
		String nombre = tfNombre.getText();
		int year = Integer.parseInt(tfYear.getText());
		String compania = cbCompania.getValue();
		double precio = Double.parseDouble(tfPrecio.getText());
		String sinopsis = tfSinopsis.getText();
		String plataforma = cbPlataforma.getValue();
		Random rng = new Random(); //LOL! LMAO!
		TVideojuego jueguito = new TVideojuego(0,nombre,year,compania,precio,sinopsis,plataforma);
		
		try {
			model.addVideojuego(jueguito);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String mensaje = "Jueguito añadido:"
				+ "\nNombre: "+nombre
				+ "\nAño: " +year
				+ "\nCompañía: "+compania
				+ "\nPrecio: "+precio
				+ "\nSinopsis: "+sinopsis
				+ "\nPlataforma: "+plataforma;
		
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		
		alert.setTitle("Jueguito añadido");
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();
		
		
		
	}
	
	private void limpiarCampos() {
		tfNombre.clear();
		tfYear.clear();
		cbCompania.setValue(null);
		tfPrecio.clear();
		tfSinopsis.clear();
		cbPlataforma.setValue(null);
	}
	
	private void borrarJuego() {
		String nombre = tfNombre.getText();
		try {
			boolean borrado = model.borrarJuego(nombre);
			if(borrado) {
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Jueguito añadido");
				alert.setHeaderText(null);
				alert.setContentText("Se ha borrado el juego: "+nombre);
				alert.showAndWait();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			inicializar("localhost/dbgametop", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
