package simulacro.ejercicio1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor1 {
	
	
	
	public static void main(String[] args) {
		new Servidor1();
	}
		public Servidor1(){
		final int puerto = 6000;
		
		ServerSocket servidor = null;
		
		try {
			final String pass = hashear("cenec", "SHA-256"); 
			
			servidor = new ServerSocket(puerto);
			
			Socket cliente = servidor.accept();
			

			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			
			ois.readObject();
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			
			//Segundo, el servidor pide la contraseña
			oos.writeObject("Bro... tienes que poner una contraseña... o algo...");
			
			//Quinto, el servidor recibe la contraseña
			String passCliente = (String) ois.readObject();
			
			//Sexto, el servidor compara las contraseñas y envía su respuesta final
			if(pass.equals(hashear(passCliente, "SHA-256"))) {
				oos.writeObject("Acceso permitido.");
			}else {
				oos.writeObject("Acceso denegado");
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				servidor.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	//Todo en un mismo método.
	public static String hashear(String original, String metodo) throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance(metodo);
		byte hash[] = original.getBytes();
		md.update(hash);
		hash = md.digest();
		
		StringBuilder hex = new StringBuilder();
		for(byte digito: hash) {
			String h = Integer.toHexString(digito & 0xFF);
			if(h.length() == 1) hex.append(0);
			hex.append(h);
		}
		return hex.toString().toUpperCase();
			
	}

}
