package deberes;

import java.io.IOException;
import java.net.ServerSocket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor {

	public static void main(String[] args) {
		
		int puerto = 5533;
		
		ServerSocket servidor;
		
		try {
			servidor = new ServerSocket(puerto);
			
			System.out.println("Estoy esperando");
			
			String mensaje = hashing("El cuco está en el nido.");
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	static String Hexadecimal(byte[] resumen) {
		String hex = " ";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			if (h.length() == 1)
				hex += "0";
			hex += h;
		}
		return hex.toUpperCase();
	}
	
	public static String hashing(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			
			byte hash[] = pass.getBytes();
			md.update(hash);
			hash = md.digest();
			return Hexadecimal(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
