package simulacro.ejercicio3;

import simulacro.ejercicio1.Cliente1;
import simulacro.ejercicio1.Servidor1;
import simulacro.ejercicio2.Cliente2;
import simulacro.ejercicio2.Servidor2;

public class Main {

	public static void main(String[] args) {
		Thread servidor = new Thread(()->{
			new Servidor1();
		});
		
		Thread cliente = new Thread(()->{
			new Cliente1();
		});
		
		servidor.start();
		cliente.start();
		
	}
	//Este método es llamado desde Cliente1 si la contraseña es correcta.
	public static void empezarEj2() {
		Thread servidor = new Thread(()->{
			new Servidor2();
		});
		
		Thread cliente = new Thread(()->{
			new Cliente2();
		});
		
		servidor.start();
		cliente.start();
	}
	
	
	

}
