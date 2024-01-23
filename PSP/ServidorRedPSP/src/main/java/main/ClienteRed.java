package main;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.io.ObjectOutputStream;
public class ClienteRed {

	public static void main(String[] args) {
		Socket cliente = null;
		
		try {
			cliente = new Socket("localhost", 62000);
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject("Dabuten");
			System.out.println("Fin del mensaje.");
			//
			InputStream input = cliente.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(input);
			String cadenaLeida = (ois.readObject().toString());
			System.out.println("El servidor dice : "+cadenaLeida);
			
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {cliente.close();} catch (IOException e) {e.printStackTrace();}
		}

	}

}
