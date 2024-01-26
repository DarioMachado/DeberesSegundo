package deberes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
		String sql = "CREATE TABLE categorias("
				+ "id NUMBER PRIMARY KEY,"
				+ "categoria VARCHAR(30),"
				+ "subcategoria VARCHAR(30)"
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
		int[] id = {1,2};
		String[] categoria = {"Informática", "Alimentación"};
		String[] subcategoria = {"Portátiles", "Monitor"};
		
		
		String sql = "INSERT INTO categorias(id, categoria, subcategoria) VALUES (?,?,?)";
		for(int i = 0 ; i< id.length; i++) {
			smt = con.prepareStatement(sql);
			smt.setInt(1, id[i]);
			smt.setString(2, categoria[i]);
			smt.setString(3, subcategoria[i]);
			smt.executeUpdate();
		}
		//Ahora a mostrar los datos insertados
		String consulta = "SELECT * FROM categorias";
		smt = con.prepareStatement(consulta);
		ResultSet rs = smt.executeQuery();
	
		while(rs.next()) {
			System.out.println("ID: "+rs.getInt("id")+""
					+ "\nCategoría: "+rs.getString("categoria")+""
							+ "\nSubcategoría: "+rs.getString("subcategoria"));
		}
		con.commit();
	
		cerrar(smt,con);
		
	}
	@Test
	@Order(3)
	void modificarRegistro() throws SQLException {
		Connection con = conectarse();
		PreparedStatement smt = null;
		
		String modificar = "UPDATE categorias SET subcategoria=? WHERE id=?";
		smt = con.prepareStatement(modificar);
		
		String nuevaSubcategoria = "Verduras";
		int id = 2;
		
		smt.setString(1,nuevaSubcategoria);
		smt.setInt(2, id);
		
		int filasAfectadas = smt.executeUpdate();
		
		if(filasAfectadas > 0) {
			System.out.println("Registro actualizado");
			System.out.println(id + " , su nueva subcategoría es: "+nuevaSubcategoria);
		}else {
			System.out.println("No se encontró el registro con id: "+id);
		}
		
		cerrar(smt, con);
	}
	
	
	@Test
	@Order(4)

	void mostrarRegistros() throws SQLException {
		Connection con = conectarse();
		
		String consulta = "SELECT * FROM categorias";
		
		PreparedStatement smt = con.prepareStatement(consulta);
		
		ResultSet rs = smt.executeQuery();
		
		while(rs.next()) {
			System.out.println("ID: "+rs.getInt("id")+""
					+ "\nCategoría: "+rs.getString("categoria")+""
							+ "\nSubcategoría: "+rs.getString("subcategoria"));
		}
		rs.close();
		cerrar(smt,con);
	}
	
	@Test
	@Order(5)

	void eliminarRegistros() throws SQLException {
		Connection con = conectarse();
		
		String eliminar = "DELETE FROM categorias WHERE id=?";
		
		PreparedStatement smt = con.prepareStatement(eliminar);
		
		smt.setInt(1, 2);
		
		int filasAfectadas = smt.executeUpdate();
		
		if(filasAfectadas > 0) 
			System.out.println("Registro con id 2 eliminado");
		else
			System.out.println("No se encontró el registro");
		
		
		cerrar(smt, con);
		
		
	}
	
	
	
	
	
}
