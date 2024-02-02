package ej1;

import java.sql.CallableStatement;
import java.sql.Types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PLSQL {

	public static void main(String[] args) {

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.doWork(connection -> {
			String procedimientoAlmacenado = "{ CALL "
					+ "ejecutar_bloque_plsql(?) }";
			
			
			CallableStatement statement = connection.prepareCall(procedimientoAlmacenado);
			statement.registerOutParameter(1, Types.VARCHAR);
			statement.execute();
			String output = statement.getString(1);
			System.out.println(output);
		});
		sessionFactory.close();
		
	}

}
