package psp;

import java.io.*;


public class Principal {

	
	public static void main (String args[]) throws IOException {
		
		ProcessBuilder pb = new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"");
		Process p = pb.start();
		
	}
}