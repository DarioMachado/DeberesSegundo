module com.example.fxprueba {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.fxprueba to javafx.fxml;
    exports com.example.fxprueba;
}