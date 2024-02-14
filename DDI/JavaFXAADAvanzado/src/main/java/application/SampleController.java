package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SampleController implements Initializable {
	
	@FXML
	private TableView<Alumno> tabla;
	@FXML
	private TableColumn<Alumno,Integer> id;
	@FXML
	private TableColumn<Alumno,String> nombre;
	@FXML
	private TableColumn<Alumno,String> apellido1;
	@FXML
	private TableColumn<Alumno,String> apellido2;
	@FXML
	private TableColumn<Alumno,Date> fecha;
	@FXML
	private TableColumn<Alumno,Boolean> repetidor;
	@FXML
	private TableColumn<Alumno,String> tlf;
	
	private AlumnoModel model;
	
	
	public void inicializar(String url, String username, String pass) {
		
		try {
			model = new AlumnoModel(url, username, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		id.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
		nombre.setCellValueFactory(cellData -> cellData.getValue().getNombreProperty());
		apellido1.setCellValueFactory(cellData -> cellData.getValue().getApellido1Property());
		apellido2.setCellValueFactory(cellData -> cellData.getValue().getApellido2Property());
		fecha.setCellValueFactory(cellData -> cellData.getValue().getFechaProperty());
		repetidor.setCellValueFactory(cellData -> cellData.getValue().getRepetidorProperty().asObject());
		tlf.setCellValueFactory(cellData -> cellData.getValue().getTelefonoProperty());
		
		
		cargarAlumnos();
		
	}


	private void cargarAlumnos() {
		tabla.getItems().clear();
		
		try {
			List<Alumno> alumnos = model.getAllAlumnos();
			tabla.getItems().addAll(alumnos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializar("localhost/instituto", "root", "");
	}
	
}
