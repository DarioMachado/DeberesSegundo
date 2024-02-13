package deberes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
			
			Socket cliente = servidor.accept();
			
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			//Segundo, el cliente lee el mensaje
			
			String recibido = (String) ois.readObject();
			
			System.out.println(recibido);
			System.out.println(mensaje);
			//Tercero compara la string recibida con el mensaje que quiere recibir
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			//Cuarto, envía el mensaje al servidor
			if(recibido.equals(mensaje)) 
				oos.writeObject("Mensaje recibido...");
			else
				oos.writeObject("Mensaje interceptado");
			
			
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
