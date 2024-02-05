module JavaFXAAD {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens ej2productos to javafx.graphics, javafx.fxml;
}
