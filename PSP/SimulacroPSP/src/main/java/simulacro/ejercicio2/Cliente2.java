package simulacro.ejercicio2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente2 {

	public static void main(String[] args) {
		new Cliente2();
	}
		public Cliente2(){
		final String host = "localhost";
		final int puerto = 61000;
		Socket servidor = null;
		try {
			servidor = new Socket(host, puerto);
			
			ObjectOutputStream oos = new ObjectOutputStream(servidor.getOutputStream());
			//Primero el cliente envía un nuevo Pikachu que acaba de generar 
			Pikachu pikachu = new Pikachu();
			oos.writeObject(pikachu);
			
			ObjectInputStream ois = new ObjectInputStream(servidor.getInputStream());
			//El cliente recibe la pregunta
			String pregunta = (String)ois.readObject();
			
			String respuesta = "";
			Scanner sca = new Scanner(System.in);
			do {
				System.out.println(pregunta);
				respuesta = sca.nextLine();
			}while(!(respuesta.equalsIgnoreCase("y")|| respuesta.equalsIgnoreCase("n")));
			//El cliente envía su respuesta
			oos.writeObject(respuesta);
			
			//El cliente recibe a su pikachu
			String mensaje = (String) ois.readObject();
			System.out.println(mensaje);
			if(!mensaje.equalsIgnoreCase("Qué lástima!")) {
			pikachu = (Pikachu) ois.readObject();
			System.out.println(pikachu.getNombre());
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
