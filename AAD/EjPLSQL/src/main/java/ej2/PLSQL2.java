package ej2;

import java.sql.CallableStatement;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PLSQL2 {

	public static void main(String[] args) {
		
		/**
		 * create or replace NONEDITIONABLE PROCEDURE ejecutar_bloque_plsql2(p_output OUT VARCHAR2) AS emp empleado3;
    BEGIN
        emp := empleado3(1, 'XDDXDXDXDXD', 'XDAASGAASFGSDASGASG');

        p_output := 'ID Empleado: ' || emp.id_empleado || CHR(10) ||
                    'Nombre: ' || emp.nombre || CHR(10) ||
                    'Apellido: ' || emp.apellido || CHR(10) ||
                    'ID Empleado desde la función: ' || emp.get_id_empleado();
    END;
		 */
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.doWork(connection -> {
			String procedimientoAlmacenado = "{ CALL "
					+ "ejecutar_bloque_plsql2(?) }";
			
			
			CallableStatement statement = connection.prepareCall(procedimientoAlmacenado);
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.execute();
			String output = statement.getString(1);
			System.out.println(output);
		});
		sessionFactory.close();
	}

}
