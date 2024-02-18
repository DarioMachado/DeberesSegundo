package ejreto;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;


import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class RetoController implements Initializable {

	@FXML
	private TableView<Libro> tabla;
	@FXML
	private TableColumn<Libro, String> tcTitulo;
	@FXML
	private TableColumn<Libro, String> tcEditorial;
	@FXML
	private TableColumn<Libro, String> tcAutore;
	@FXML
	private TableColumn<Libro, Integer> tcPaginas;

	private LibroModel model;

	@FXML
	private TextField tfTitulo;
	@FXML
	private ComboBox<String> cbEditorial;
	@FXML
	private TextField tfAutore;
	@FXML
	private TextField tfPaginas;
	@FXML
	private Button add;
	@FXML
	private Button borrar;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		List<String> editoriales = List.of("Planeta","Jajaja odio", "Mucho", "Los deberes!");
		cbEditorial.setItems(FXCollections.observableArrayList(editoriales));
		cbEditorial.setValue("Planeta");

		UnaryOperator<TextFormatter.Change> filter = change -> {
			String newText = change.getControlNewText();
			if (newText.matches("\\d*")) {
				return change;
			}
			return null;
		};

		TextFormatter<String> textFormatter = new TextFormatter<>(filter);

		tfPaginas.setTextFormatter(textFormatter);

		tcTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
		tcEditorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
		tcAutore.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutore()));
		tcPaginas.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPaginas()).asObject());

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		ThreadLocalSessionContext context = new ThreadLocalSessionContext((SessionFactoryImplementor) sessionFactory);
		context.bind(sessionFactory.openSession());

		Session session = context.currentSession();

		model = new LibroModel(session);

		add.setOnAction(click -> agregarLibro());
		borrar.setOnAction(click -> borrarLibro());
		actualizar();

	}

	private void agregarLibro(){
		String titulo = tfTitulo.getText();
		String editorial = cbEditorial.getValue();
		String autore = tfAutore.getText();
		int paginas = Integer.parseInt(tfPaginas.getText());

		Libro libro = new Libro(titulo, editorial, autore, paginas);
		model.agregarLibro(libro);
		actualizar();
		tfTitulo.clear();
		tfAutore.clear();
		tfPaginas.clear();
	}

	public void borrarLibro(){
		Libro libro = tabla.getSelectionModel().getSelectedItem();
		model.borrarLibro(libro);
		actualizar();
	}

	private void actualizar(){
		tabla.getItems().clear();
		List<Libro> libros = model.getAllLibros();
		tabla.getItems().addAll(libros);
	}



}
