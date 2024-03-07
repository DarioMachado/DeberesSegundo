package deberes;

import java.lang.reflect.InvocationTargetException;

import javax.xml.transform.OutputKeys;

import org.exist.xmldb.DatabaseImpl;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;

public class ConectarXML {

	private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc/db";
	
	private static String COLLECTION = "";
	
	private static String RESOURCE = "productos.xml";
	
	public static void main (String args[]) {
		final String driver = "org.exist.xmldb.DatabaseImpl";
		
		try {
			Class cl = Class.forName(driver);
			
			Database database = (Database) cl.newInstance();
			database.setProperty("create-database", "true");
			DatabaseManager.registerDatabase(database);
			
			Collection coll = DatabaseManager.getCollection(URI+COLLECTION, "admin", "admin");
			coll.setProperty(OutputKeys.INDENT, "no");
			XMLResource res =  (XMLResource) coll.getResource(RESOURCE);
			
			if(res == null) 
				System.out.println("Base de datos no encontrada.");
			else{
				//ESto muestra todo el contenido
				System.out.println(res.getContent());

				
				// Esto muestra lo soleccionado con xquery..
				XPathQueryService xpathService = (XPathQueryService) col.getService("XPathQueryService", "1.0");
				xpathService.setProperty("indent", "yes");
				String xquery = "/series/serie[inicio_emision >= 2000]";
				ResourceSet result = xpathService.query(xquery);

				// Imprime los resultados de la consulta
				ResourceIterator i = result.getIterator();
				while (i.hasMoreResources()) {
					Resource r = i.nextResource();
					System.out.println(r.getContent());
				
			}


			}
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException | XMLDBException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
