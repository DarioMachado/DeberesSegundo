module ControlesAvanzadosJavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens ej1calculadora to javafx.graphics, javafx.fxml;
	opens ej2videojuegos to javafx.graphics, javafx.fxml;
	opens ej3slider to javafx.graphics, javafx.fxml;
}
