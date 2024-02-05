package ej2productos;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import application.TVideojuego;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Ej2Controller implements Initializable {
	
	@FXML
	private TableView<Producto> tabla;
	
	@FXML
	private TableColumn<Producto, Integer> id;
	@FXML
	private TableColumn<Producto, String> nombre;
	@FXML
	private TableColumn<Producto, Double> precio;
	@FXML
	private TableColumn<Producto, Integer> codigo;
	
	private ProductoModel model;
	
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			model = new ProductoModel("localhost/tienda", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		id.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		precio.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
		codigo.setCellValueFactory(cellData -> cellData.getValue().codigoProperty().asObject());

		tabla.getItems().clear();
		
		try {
			List<Producto> productos = model.getAllProductos();
			tabla.getItems().addAll(productos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

}
