module JavaFXAADAvanzado {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.base;
	requires javaee.api;
	requires java.persistence;
	requires org.hibernate.orm.core;

	opens application to javafx.graphics, javafx.fxml;
	opens ejreto to javafx.graphics, javafx.fxml;
}
