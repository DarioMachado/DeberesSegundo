package aaaaa;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class Inicial {

	
	public static void main (String args[]) {
		
		Connection con;
		PreparedStatement smt;
		CallableStatement cbt;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
			
			/*
			smt = con.prepareStatement("DROP PROCEDURE IF EXISTS ObtenerClientes");
			smt.executeUpdate();
			
			smt = con.prepareStatement("CREATE PROCEDURE ObtenerClientes() "
					+ "BEGIN "
					+ "SELECT * FROM clientes;"
					+ "END;");
			smt.executeUpdate();	
			*/
			/*
			smt = con.prepareStatement("CREATE PROCEDURE ObtenerPorID()"
					+ "BEGIN "
					+ "SELECT * FROM CLIENTES WHERE clientes.id = 222;"
					+ "END;");
			
			smt.executeUpdate();
			*/
			
			/*
			smt = con.prepareStatement("CREATE PROCEDURE MayoresDe40() "
					+ "BEGIN "
					+ "SELECT * FROM CLIENTES WHERE clientes.edad > 40; "
					+ "END;");
			smt.executeUpdate();
			*/
			/*
			
			smt = con.prepareStatement("CREATE PROCEDURE Alberto() "
					+ "BEGIN "
					+ "SELECT * FROM CLIENTES WHERE clientes.nombre = 'Alberto'; "
					+ "END;");
			smt.executeUpdate();
			*/
			
			
			
			
			
			cbt = con.prepareCall("call CalcularEdad(?,?)");
			cbt.setInt(1, 1997);
			cbt.registerOutParameter(2, Types.INTEGER);
		
			cbt.execute();
			
			System.out.println( cbt.getInt(2));
			
			/*
			ResultSet cursor = cbt.getResultSet();
			
			while(cursor.next()) {
				int id = cursor.getInt("id");
				String nif = cursor.getString("nif");
				String nombre = cursor.getString("nombre");
				int edad = cursor.getInt("edad");
				System.out.println("ID: "+id+", Nombre: "+nombre+", NIF: "+nif+", Edad: "+edad);
				
			}
			*/
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
}
