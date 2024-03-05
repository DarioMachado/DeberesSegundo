package simulacro.ejercicio1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import simulacro.ejercicio3.Main;

public class Cliente1 {

	public static void main(String[] args) {
		new Cliente1();
		
	}
		public Cliente1(){
		final String host = "localhost";
		final int puerto = 6000;
		Socket servidor = null;
		try {
			servidor = new Socket(host, puerto);
			
			ObjectOutputStream oos = new ObjectOutputStream(servidor.getOutputStream());
			//Primero de todo, el cliente hace un sanity check porque por algún motivo si no pongo esta línea de mierda no va el programa no!!
			//Jajaja 1 hora perdida con esto!!! :)
			oos.writeObject(":)");
			
			
			ObjectInputStream ois = new ObjectInputStream(servidor.getInputStream());
			
			String recibido = (String) ois.readObject();
			//Tercero el cliente imprime la línea recibida por el cliente
			System.out.println(recibido);
			
			Scanner sca = new Scanner(System.in);
			
			//Cuarto el cliente escribe y envía la contraseña
			String pass = sca.nextLine();
			System.out.println("");
			oos.writeObject(pass);
			
			//Séptimo, el cliente descubre si lo ha hecho bien.
			
			String llamar = (String) ois.readObject();
			System.out.println(llamar);
			
			//Esto es para el ejercicio 3
			//En el ej3 tampoco dice que hay que combinarlos todos en un main así que imagino que querría que modificaramos los anteriores
			//por lo que esto no debería de causar ningún problema
			if(llamar.equalsIgnoreCase("Acceso permitido.")) {
				Main.empezarEj2();
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
