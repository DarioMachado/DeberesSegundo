package ipconfig;

import java.io.IOException;
import java.io.InputStream;

public class EjIPConfig {

	public static void main(String[] args) throws IOException {
		
		
		ProcessBuilder pb = new ProcessBuilder("CMD","/c", "tasklist");
		Process p = pb.start();
		InputStream is = p.getInputStream();
		
		int c;
		
		while((c=is.read())!=-1) {
			System.out.print((char) c);
		}
		
		is.close();
	}

}
