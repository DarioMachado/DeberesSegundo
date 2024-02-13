package deberes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cliente {

	public static void main(String[] args) {
		
		String enviar = hashing("El cuco está en el nido.");
		
		String host = "localhost";
		int puerto = 5533;
		
		try {
			Socket server = new Socket(host, puerto);
			
			ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
			//Primero el cliente envía el mensaje
			oos.writeObject(enviar);			
			
			//Quinto, el cliente recibe la respuesta
			ObjectInputStream ois = new ObjectInputStream(server.getInputStream());
			
			System.out.println(ois.readObject());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
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
	
	private static String hashing(String pass) {
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
