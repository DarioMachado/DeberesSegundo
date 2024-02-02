package reto;

import java.sql.CallableStatement;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetoPLSQL {

	public static void main(String[] args) {
		/**
		 * CREATE TYPE perro AS OBJECT (
    nombre VARCHAR2(30),
    raza VARCHAR2(30),
    color VARCHAR2(40),
    MAP MEMBER FUNCTION get_nombre_perro RETURN VARCHAR2);
    /
     CREATE TYPE BODY perro AS MAP MEMBER FUNCTION get_nombre_perro RETURN VARCHAR2 IS
    BEGIN
        RETURN nombre;
    END;
END;
    /
    create or replace NONEDITIONABLE PROCEDURE ejecutar_bloque_plsqlreto(p_output OUT VARCHAR2) AS perr perro;
    BEGIN
        perr := perro('Garfield', 'Gato', 'Naranja');

        p_output := 'Nombre del perro: ' || perr.nombre || CHR(10) ||
                    'Raza: ' || perr.raza || CHR(10) ||
                    'Color: ' || perr.color || CHR(10) ||
                    'Nombre del perro desde la función:  ' || perr.get_nombre_perro();
    END;
    

		 */
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.doWork(connection -> {
			String procedimientoAlmacenado = "{ CALL "
					+ "ejecutar_bloque_plsqlreto(?) }";
			
			
			CallableStatement statement = connection.prepareCall(procedimientoAlmacenado);
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.execute();
			String output = statement.getString(1);
			System.out.println(output);
		});
		sessionFactory.close();
	}

}
