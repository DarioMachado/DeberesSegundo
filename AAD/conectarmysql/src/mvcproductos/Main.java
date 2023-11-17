package mvcproductos;

import java.sql.SQLException;

import modelovistacontrolador.ClienteController;

public class Main {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost/simulacro"; // URL de la base de datos
        String dbUser = "root"; // Usuario de la base de datos
        String dbPassword = ""; // Contraseña del usuario

        try {
            ProductoController controller = new ProductoController(dbURL, dbUser, dbPassword); // Crea una instancia del controlador
            controller.mostrarProductos(); // Llama al método del controlador para mostrar los clientes
            controller.cerrarConexion(); // Llama al método del controlador para cerrar la conexión a la base de datos
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones de SQL imprimiendo el error
        }

	}

}
