package ej3Y4insertar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.TVideojuego;
import application.TVideojuegoModel;

public class TVJModel3 extends TVideojuegoModel{
	
	private Connection con = null;

	public TVJModel3(String url, String user, String pass) throws SQLException {
		super(url, user, pass);
		con = DriverManager.getConnection("jdbc:mysql://"+url, user, pass);
		
	}
	
	String columnaAnio = "año"; //En mi base de datos tengo puesto año, dejo esto string para ver que todo funciona. Si se me ha olvidado
							//cambiarlo antes de entregarlo, puede cambiarlo aquí
	String columnaCompania = "compañia"; //lo mismo...
	public void addVideojuego(TVideojuego jueguito) throws SQLException{
		String query = "INSERT INTO tvideojuegos(nombre, "+columnaAnio+", "+columnaCompania+", precio, sinopsis, plataforma) VALUES (?,?,?,?,?,?)";
		
		try (PreparedStatement smt = con.prepareStatement(query)){
			smt.setString(1, jueguito.getNombre());
			smt.setInt(2, jueguito.getYear());
			smt.setString(3, jueguito.getCompania());
			smt.setDouble(4, jueguito.getPrecio());
			smt.setString(5, jueguito.getSinopsis());
			smt.setString(6, jueguito.getPlataforma());
			
			smt.executeUpdate();
		}
		
	}
	//Lo cerrar la conexión con una función close no tiene ningún sentido, sería mejor crear la conexión afuera y pasarle 
		//la conexión por el constructor, pero bueno
	public boolean borrarJuego(String nombre) throws SQLException{
		String query = "DELETE FROM tvideojuegos WHERE nombre = '"+nombre+"'";
		PreparedStatement smt = con.prepareStatement(query);
		return smt.executeUpdate() > 0;
	}
	

	
	
}
