package mvcproductos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelovistacontrolador.Cliente;

public class ProductoModel {
	 private Connection con;

	    public ProductoModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
	        con = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	    }

	    public List<Producto> getAllProductos() throws SQLException {
	        List<Producto> productos = new ArrayList<>(); 
	        PreparedStatement stmt = con.prepareStatement("SELECT * FROM productos"); 

	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String nombre = rs.getString("nombre");
	            String descripcion = rs.getString("descripcion");
	            String fabricante = rs.getString("fabricante");
	            int precio = rs.getInt("precio");
	            int n_serie = rs.getInt("n_serie");
	            productos.add(new Producto(id, nombre, descripcion, fabricante, precio, n_serie));
	        }

	        stmt.close(); 
	        rs.close(); 
	        return productos; 
	    }

	    public void close() throws SQLException {
	        con.close();
	    }
}
