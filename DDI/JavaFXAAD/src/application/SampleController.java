package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SampleController implements Initializable {
	@FXML
	private TableView<TVideojuego> tabla;
	@FXML
	private TableColumn<TVideojuego, String> nombre;
	@FXML
	private TableColumn<TVideojuego, Integer> year;
	@FXML
	private TableColumn<TVideojuego, String> compania;
	@FXML
	private TableColumn<TVideojuego, Double> precio;
	@FXML
	private TableColumn<TVideojuego, String> sinopsis;
	@FXML
	private TableColumn<TVideojuego, String> plataforma;
	
	private TVideojuegoModel model;
	
	public void inicializar(String url, String username, String pass) {
		
		try {
			model = new TVideojuegoModel(url, username, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		year.setCellValueFactory(cellData -> cellData.getValue().yearProperty().asObject());
		compania.setCellValueFactory(cellData -> cellData.getValue().companiaProperty());
		precio.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
		sinopsis.setCellValueFactory(cellData -> cellData.getValue().sinopsisProperty());
		plataforma.setCellValueFactory(cellData -> cellData.getValue().plataformaProperty());
		
		
		cargarJuegos();
		
	}
	
	private void cargarJuegos() {
		tabla.getItems().clear();
		
		try {
			List<TVideojuego> videojuegos = model.getAllVideojuegos();
			tabla.getItems().addAll(videojuegos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		inicializar("localhost/dbgametop", "root", "");
	}
}
