module javaFXCSS {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	
	opens ej1hola to javafx.graphics, javafx.fxml;
	opens ej2formulario to javafx.graphics, javafx.fxml;
	opens ej3calculadora to javafx.graphics, javafx.fxml;
	opens ej4iva to javafx.graphics, javafx.fxml;
	opens ej42formulario to javafx.graphics, javafx.fxml;
	opens ej5hilos to javafx.graphics, javafx.fxml;
	opens ej6reto to javafx.graphics, javafx.fxml;
}
