package capturarError;

import java.io.*;

public class Eeeerror {

	public static void main(String[] args) throws IOException {
		
		
		ProcessBuilder pb = new ProcessBuilder("CMD","/c", "ipconfgi");
		Process p = pb.start();
		InputStream is = p.getErrorStream();
		
		int c;
		
		while((c=is.read())!=-1) {
			System.out.print((char) c);
		}
		
		is.close();

	}

}