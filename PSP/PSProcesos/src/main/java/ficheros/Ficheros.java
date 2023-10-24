package ficheros;

import java.io.*;

public class Ficheros {
	
	public static void main (String args[]) throws IOException {
		
		ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "tasklist");
		File fOut = new File("Salida.txt");
		
		File fErr = new File("Error.txt");
		
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.start();
		
	}
}
