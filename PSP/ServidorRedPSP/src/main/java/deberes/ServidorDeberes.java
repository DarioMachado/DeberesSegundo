package deberes;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorDeberes {

	public static void main(String[] args) {
		
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 2301;
		
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando en el puerto: "+puerto);
			cliente = servidor.accept();
			
			//Primero el servidor envía un mensaje.
			OutputStream output = cliente.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(output);
			oos.writeObject("Dime un número y te daré su cuadrado. O dime una string y te la diré en minísculas.");
			
			//La respuesta del cliente ha sido:
			InputStream input = cliente.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(input);
			String respuesta = (ois.readObject().toString());
			
			//La respuesta cambiará dependiendo de lo que haya dicho el cliente:
			
			
			try {
				int calculo = Integer.parseInt(respuesta); 
				calculo = calculo * calculo;
				oos.writeObject("El cuadrado del número es "+calculo);
			}catch(NumberFormatException e) {
				respuesta = respuesta.toLowerCase();
				oos.writeObject("Esa string en minúsculas es: "+respuesta);
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {cliente.close();} catch (IOException e) {e.printStackTrace();}
			try {servidor.close();} catch (IOException e) {e.printStackTrace();}
		}
		

	}

}
