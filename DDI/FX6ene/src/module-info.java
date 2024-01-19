module FX6ene {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens ej2layouts to javafx.graphics, javafx.fxml;
	opens ej3pulsame to javafx.graphics, javafx.fxml;
	opens ej4vboxY5 to javafx.graphics, javafx.fxml;
	opens ej6login to javafx.graphics, javafx.fxml;
	opens ej7caja to javafx.graphics, javafx.fxml;
	opens ej8flow to javafx.graphics, javafx.fxml;
	opens ej9grid to javafx.graphics, javafx.fxml;
	opens ejlibre10 to javafx.graphics, javafx.fxml;
}
