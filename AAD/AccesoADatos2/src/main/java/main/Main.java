package main;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost","root","");
			//EJERCICIO 1
			System.out.println("Conexión completada");
			
			Statement smt = con.createStatement();
			
			String sql = "DROP DATABASE IF EXISTS EMPRESA";
			smt.execute(sql);
			sql = "CREATE DATABASE IF NOT EXISTS EMPRESA";
			smt.execute(sql);
			//
			smt.execute("USE EMPRESA");
			smt.execute("CREATE TABLE clientes (id INT PRIMARY KEY,"
					+ "nif VARCHAR(10) NOT NULL,"
					+ "nombre VARCHAR(60) NOT NULL,"
					+ "edad VARCHAR(2))");
			
			
			smt.executeUpdate("INSERT INTO clientes (id, nif, nombre, edad)"
					+ "VALUES (123, '45678903O', 'NOSENOSE', 77)");
			
			
			sql = "SELECT * FROM clientes";
			ResultSet cursor = smt.executeQuery(sql);
			
			while(cursor.next()) {
				int id = cursor.getInt("id");
				String nif = cursor.getString("nif");
				String nombre = cursor.getString("nombre");
				int edad = cursor.getInt("edad");
				//System.out.println("ID: "+id+", Nombre: "+nombre+", NIF: "+nif+", Edad: "+edad);
				
			}
			
			
			
			
			//AAAAAAAAAAAAA
			//EJERCICIO 2
			
			con = DriverManager.getConnection("jdbc:mysql://localhost","root","");
			smt = con.createStatement();
			
			smt.execute("DROP DATABASE IF EXISTS EJEMPLO");
			smt.execute("CREATE DATABASE IF NOT EXISTS EJEMPLO");
			smt.execute("USE EJEMPLO");
			
			smt.execute("CREATE TABLE coches (matricula varchar(8) primary key,"
					+ "nombre varchar(30),"
					+ "color varchar(20),"
					+ "numruedas int)");
			
			smt.executeUpdate("INSERT INTO COCHES (matricula, nombre, color, numruedas)"
					+ " VALUES('AS12312', 'Cochecito', 'rojo', 32)");
			cursor = smt.executeQuery("SELECT * FROM coches");
			
			while(cursor.next()) {
				String matricula = cursor.getString("matricula");
				String nombre = cursor.getString("nombre");
				String color = cursor.getString("color");
				int numruedas = cursor.getInt("numruedas");
				System.out.print(nombre);
				System.out.print(". De color "+color);
				System.out.print(". Con matrícula "+matricula);
				System.out.println(". Posee "+numruedas+" ruedas");
				
			}
			
			
			DatabaseMetaData meta = con.getMetaData();
			System.out.println();
			System.out.println("Versión del driver JDBC" + meta.getDriverVersion());
			System.out.println("Nombre "+ meta.getDatabaseProductName());
			System.out.println("Versión "+meta.getDatabaseProductVersion());
			cursor = meta.getColumns("phoneland", null, "ventas", null);
			
			System.out.println("BBDD EMPRESA");
			System.out.println("Columna    tipo    tamaño");
			System.out.println("........................");
			while(cursor.next()) {
				System.out.println(cursor.getString("COLUMN_NAME") +"  "+ cursor.getString("TYPE_NAME") + "   "+cursor.getString("COLUMN_SIZE"));
				
			}
			
			con.close();
		} catch (SQLException e) {
			System.out.println("Error "+e.getErrorCode());
			e.printStackTrace();
		}
		
		
		
		
			
	

	}

}