package paquete;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	
	
	public static void main(String[] args) {
		
		Connection con = null;
		
		PreparedStatement smt = null;
		
		String sql="CREATE DATABASE simulacro";
		
		CallableStatement cbt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/", "root","");
			/*
			smt = con.prepareStatement(sql);
			
			smt.executeUpdate();
			*/
			smt = con.prepareStatement("USE simulacro");
			
			smt.executeUpdate();
			/*
			String sqltable = "CREATE TABLE clientes (id INT PRIMARY KEY,"
					+ "nif VARCHAR (10) NOT NULL,"
					+ "nombre VARCHAR (60) NOT NULL,"
					+ "edad VARCHAR(2))";
			
			smt = con.prepareStatement(sqltable);
			
			smt.executeUpdate();
			*/
			/*
			String sqltable = "CREATE TABLE productos (id int primary key,"
					+ "nombre varchar (50) not null,"
					+ "descripcion varchar (50),"
					+ "fabricante varchar (30),"
					+ "precio float,"
					+ "n_serie varchar(10))";
			smt = con.prepareStatement(sqltable);
			smt.executeUpdate();
			*/
			/*
			smt = con.prepareStatement("INSERT INTO productos (id, nombre, descripcion, fabricante, precio, n_serie) VALUES "
					+ "(1, 'portátil 1', 'portatil gama alta', 'HP', 1500, 111),"
					+ "(2, 'portátil 2', 'portátil gama baja', 'Apple', 1000, 222),"
					+ "(3, 'monitor 1', 'monitor gama alta', 'LG', 800, 333),"
					+ "(4, 'monitor 2', 'monitor gama baja', 'HP', 200, 444); ");
			smt.executeUpdate();
			*/
			smt = con.prepareStatement("DROP PROCEDURE IF EXISTS consultarIvaDescuento");
			smt.executeUpdate();
			smt = con.prepareStatement("CREATE PROCEDURE consultarIvaDescuento()"
					+ "BEGIN "
					+ "SET @iva = 0.21;"
					+ "SET @descuento = 0.10; "
					+ "SELECT precio, (precio + precio * @iva) as precioIva, (precio - precio * @descuento) + (precio - precio * @descuento) * @iva as precioFinal FROM productos; "
					+ "END;");
			smt.executeUpdate();
			cbt = con.prepareCall("call consultarIvaDescuento");
			cbt.execute();
			ResultSet rs = cbt.getResultSet();
			
			while(rs.next()) {
				System.out.print("Precio unitario: "+ rs.getFloat(1));
				System.out.print("   Precio con iva: "+rs.getFloat(2));
				System.out.println("   Precio final con descuento " + rs.getFloat(3));
			}
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(con!= null) try { con.close(); } catch (SQLException e) {e.printStackTrace();}
			if(smt!= null) try { smt.close(); } catch (SQLException e) {e.printStackTrace();}
			if(cbt!= null) try { cbt.close(); } catch (SQLException e) {e.printStackTrace();}
		}
			
			
			
		

	}

}
