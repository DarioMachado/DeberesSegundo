package otroPrograma;
import capturarError.Eeeerror;
import java.io.*;

public class Ejecucion {

	public static void main(String[] args) throws IOException {
		
		//File ruta = new File (".\\bin");
		File ruta = new File ("src\\main\\java");
		
		ProcessBuilder pb = new ProcessBuilder ("java", "ipconfig.EjIPConfig");
		
		pb.directory(ruta);
		
		Process p = pb.start();
		
		InputStream is = p.getInputStream();
		
		int c;
		
		while((c=is.read())!=-1) {
			System.out.print((char) c);
		}
		
		is.close();

	}

}
