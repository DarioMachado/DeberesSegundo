package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AlumnoModel {
	
	private Connection con = null;
	
	public AlumnoModel(String url, String user, String pass) throws SQLException{
		con = DriverManager.getConnection("jdbc:mysql://"+url, user, pass);
	}
	
	public List<Alumno> getAllAlumnos() throws SQLException{
		
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("SELECT * FROM alumno");
		List<Alumno> alumnos = new ArrayList<Alumno>();
		while(rs.next()) alumnos.add(new Alumno(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6).equalsIgnoreCase("sí"), rs.getString(7)));
		return alumnos;
	}
	
	

}
