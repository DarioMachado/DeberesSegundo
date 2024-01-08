module FX6ene {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens ej2layouts to javafx.graphics, javafx.fxml;
	opens ej3pulsame to javafx.graphics, javafx.fxml;
	opens ej4vbox to javafx.graphics, javafx.fxml;
}
