package ej2productos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductoModel {

	
	Connection con = null;
	
	public ProductoModel(String url, String user, String pass) throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://"+url, user, pass);
	}
	
	public List<Producto> getAllProductos() throws SQLException{
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("SELECT * FROM producto");
		List<Producto> lista = new ArrayList<Producto>();
		while(rs.next()) {
			lista.add(new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
		}
		
		return lista;
	}
}
