package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TVideojuegoModel {
	
	private Connection con = null;
	
	public TVideojuegoModel(String url, String user, String pass) throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://"+url, user, pass);
	}
	
	public List<TVideojuego> getAllVideojuegos() throws SQLException{
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("SELECT * FROM tvideojuegos");
		List<TVideojuego> lista = new ArrayList<TVideojuego>();
		while(rs.next()) {
			lista.add(new TVideojuego(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getString(7)));
		}
		
		return lista;
	}
}
