package ej3;

import java.sql.CallableStatement;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PLSQL3 {

	public static void main(String[] args) {
		
		/***
		 * create or replace NONEDITIONABLE PROCEDURE ejecutar_bloque_plsql3(p_output OUT VARCHAR2) AS alu alumno;
    BEGIN
        alu := alumno(1, 'XDXDXD', 'XDXD');

        p_output := 'ID Alumno: ' || alu.id_alumno || CHR(10) ||
                    'Nombre: ' || alu.nombre || CHR(10) ||
                    'Apellido: ' || alu.apellido || CHR(10) ||
                    'ID Alumno desde la función: ' || alu.get_id_alumno();
    END;
		 */

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.doWork(connection -> {
			String procedimientoAlmacenado = "{ CALL "
					+ "ejecutar_bloque_plsql3(?) }";
			
			
			CallableStatement statement = connection.prepareCall(procedimientoAlmacenado);
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.execute();
			String output = statement.getString(1);
			System.out.println(output);
		});
		sessionFactory.close();
	}

}
