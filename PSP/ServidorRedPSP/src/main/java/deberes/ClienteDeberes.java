package deberes;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClienteDeberes {
	
	public static void main(String[] args) {
		Socket cliente = null;
		Scanner sca = new Scanner(System.in);
		
		try {
			cliente = new Socket("localhost", 2301);
			
			//El cliente recibe el primer mensaje del servidor:
			InputStream input = cliente.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(input);
			String cadenaLeida = (ois.readObject().toString());
			System.out.println("Servidor: "+cadenaLeida);
			//El cliente da su respuesta
			String respuestaCliente = sca.nextLine();
			OutputStream output = cliente.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(output);
			oos.writeObject(respuestaCliente);
			
			//El cliente recibe la respuesta del servidor:
			String respuestaServidor = (ois.readObject().toString());
			System.out.println("Servidor: "+respuestaServidor);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {cliente.close();} catch (IOException e) {e.printStackTrace();}
		}
		
		
		
	}

}
