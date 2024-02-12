module JavaFXAAD {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens ej2productos to javafx.graphics, javafx.fxml;
	opens ej3Y4insertar to javafx.graphics, javafx.fxml;
}
