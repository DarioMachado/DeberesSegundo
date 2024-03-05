package simulacro.ejercicio2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor2 {

	public static void main(String[] args) {
		
		new Servidor2();
	}
		public Servidor2(){
		final int puerto = 61000;
		
		ServerSocket servidor = null;
		
		try {
			servidor = new ServerSocket(puerto);
			Socket cliente = servidor.accept();
			

			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			//Segundo el servidor recibe el pikachu del cliente...
			Pikachu pikachuRecibido = (Pikachu) ois.readObject();
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			//El servidor le pregunta al cliente si quiere que su pikachu pierda la plot armor
			oos.writeObject("¿Quieres usar la piedra trueno en tu "+pikachuRecibido.getNombre() + " Y/N");
			//El servidor recibe la respuesta y actua acorde
			String respuesta = (String)ois.readObject();
			if(respuesta.equalsIgnoreCase("y")) {
				pikachuRecibido.setNombre("Raichu");
				oos.writeObject("Felicidades, pikachu ha perdido su plot armor");
				oos.writeObject(pikachuRecibido);
				
			}else {
				pikachuRecibido.setNombre("Pichu");
				oos.writeObject("Qué lástima!");
				servidor.close();
			}
			
			
		} catch (IOException e) {
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

}
