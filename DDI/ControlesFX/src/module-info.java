module ControlesFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens ej1calcular to javafx.graphics, javafx.fxml;
	opens ej2iva to javafx.graphics, javafx.fxml;
	opens ej3formulario to javafx.graphics, javafx.fxml;
}
