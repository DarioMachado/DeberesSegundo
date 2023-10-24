package deberes;

import java.io.*;
import java.nio.charset.Charset;
public class DEBERES {

	public static void main(String[] args) throws IOException {

		
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DATE");
		Process p = pb.start();
		
		
		InputStream is = p.getInputStream();
		OutputStream os = p.getOutputStream();
		
		os.write("10-10-23".getBytes());
		os.flush();
		
		int c;
		
		while((c=is.read())!=-1) {
			System.out.print((char) c);
		}
		is.close();
		
		//Va a darme error porque no tengo privilegios, pero debería de funcionar.
		InputStream err = p.getErrorStream();
		
		while((c=err.read())!=-1) {
			System.out.print((char) c);
		}
	
		err.close();
		
		
	}

}
