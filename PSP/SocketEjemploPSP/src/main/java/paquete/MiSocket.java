package paquete;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MiSocket {

	public static void main(String[] args) {
		
	
		try {
			String host = "192.168.0.29";
			int puerto = 2025;
			final ServerSocket server = new ServerSocket(puerto);
			
			
			Thread hilo = new Thread(() ->{
				try {
					Socket cliente1 = new Socket("192.168.0.29", 2025);
					imprimirCliente(cliente1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			hilo.start();
			
			Thread hilo2 = new Thread(() ->{
				try {
					Socket cliente2 = new Socket("192.168.0.29", 2025);
					imprimirCliente(cliente2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			hilo2.start();
			

		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void imprimirCliente(Socket cliente) {
		System.out.println(cliente.getLocalPort());
		System.out.println(cliente.getRemoteSocketAddress());
		System.out.println(cliente.getInetAddress());
	}
	

}
