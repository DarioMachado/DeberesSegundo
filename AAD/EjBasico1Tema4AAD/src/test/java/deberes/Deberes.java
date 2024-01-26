package deberes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Deberes {

	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String nombre = "system";
	private final String pass = "admin";
	
	Connection conectarse() {
		Connection conexion = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(URL, nombre, pass);
		} catch (ClassNotFoundException e) {
			System.out.println("Ha pasado algo malo con la conexión");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
		
	}
	void cerrar(Statement smt, Connection con) {
		try {
			smt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(1)
	void crearTabla() throws SQLException{
		Connection con = conectarse();
		Statement smt = null;
		
		smt = con.createStatement();
		String sql = "CREATE TABLE empresa("
				+ "id NUMBER PRIMARY KEY,"
				+ "nombre VARCHAR(50),"
				+ "pais VARCHAR(50)"
				+ ")";
		smt.executeUpdate(sql);

		cerrar(smt,con);
	
	}
	
	@Test
	@Order(2)
	void insertarRegistro() throws SQLException {
		Connection con = conectarse();
		PreparedStatement smt = null;
		
		
		con.setAutoCommit(false);
		int id = 5;
		String nombre = "Alberto";
		String pais = "España";
		
		String sql = "INSERT INTO empresa(id, nombre, pais) VALUES (?,?,?)";
		smt = con.prepareStatement(sql);
		smt.setInt(1, id);
		smt.setString(2, nombre);
		smt.setString(3, pais);
		smt.executeUpdate();
		
		//Ahora a mostrar los datos insertados
		String consulta = "SELECT * FROM empresa";
		smt = con.prepareStatement(consulta);
		ResultSet rs = smt.executeQuery();
		System.out.println("hola");
		while(rs.next()) {
			System.out.println("ID: "+rs.getInt("id")+""
					+ "\nNombre: "+rs.getString("nombre")+""
							+ "\nPaís: "+rs.getString("pais"));
		}
		con.commit();
	
		cerrar(smt,con);
		
	}
	@Test
	@Order(3)
	void modificarRegistro() throws SQLException {
		Connection con = conectarse();
		PreparedStatement smt = null;
		
		String modificar = "UPDATE empresa SET nombre=?, pais=? WHERE id=?";
		smt = con.prepareStatement(modificar);
		
		String nuevoNombre = "Berto";
		String nuevoPais = "Andorra";
		int id = 5;
		
		smt.setString(1,nuevoNombre);
		smt.setString(2, nuevoPais);
		smt.setInt(3, id);
		
		int filasAfectadas = smt.executeUpdate();
		
		if(filasAfectadas > 0) {
			System.out.println("Registro actualizado");
			System.out.println(id + " , "+nuevoNombre+" , "+nuevoPais);
		}else {
			System.out.println("No se encontró el registro con id: "+id);
		}
		
		cerrar(smt, con);
	}
	
	
	@Test
	@Order(4)
	void mostrarRegistros() throws SQLException {
		Connection con = conectarse();
		
		String consulta = "SELECT * FROM empresa";
		
		PreparedStatement smt = con.prepareStatement(consulta);
		
		//TODO SEGUIR Y ADEMÁS HACER LO DE ELIMINAR
		ResultSet rs = smt.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID: "+rs.getInt("id")+""
					+ "\nNombre: "+rs.getString("nombre")+""
							+ "\nPaís: "+rs.getString("pais"));
		}
		rs.close();
		cerrar(smt,con);
	}
	
	@Test
	@Order(5)
	void eliminarRegistros() throws SQLException {
		Connection con = conectarse();
		
		String eliminar = "DELETE FROM empresa WHERE id=?";
		
		PreparedStatement smt = con.prepareStatement(eliminar);
		
		smt.setInt(1, 5);
		
		int filasAfectadas = smt.executeUpdate();
		
		if(filasAfectadas > 0) 
			System.out.println("Registro con id 5 eliminado");
		else
			System.out.println("No se encontró el registro");
		
		
		cerrar(smt, con);
		
		
	}
	
	
	
	
	
}
