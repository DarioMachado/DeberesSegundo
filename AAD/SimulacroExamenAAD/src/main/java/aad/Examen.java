package aad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class Examen {
	
	
	public static void main (String args[]) {
		String menu = "¿Qué quieres hacer?"
				+ "\n\n\t1. Crear carpeta."
				+ "\n\t2. Crear fichero."
				+ "\n\t3. Borrar carpeta."
				+ "\n\t4. Borrar fichero."
				+ "\n\t5. Leer fichero."
				+ "\n\t6. Ver información de una carpeta."
				+ "\n\t7. Ver información de un fichero."
				+ "\n\t8. Salir.";
		File directorio = new File("C:\\SimulacroAccesoADatos");
		directorio.mkdir();
		Scanner sc = new Scanner(System.in);
		
		boolean salida = false;
		while(true) {
		System.out.println(menu);
		int respuesta = 0;
		try {
		 respuesta = Integer.parseInt(sc.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("\tNo se ha podido leer el número. \n\tInténtalo otra vez.\n");
			continue;
		}
		if(respuesta<1 || respuesta>8) {
			System.out.println("\tEl número introducido no es válido. \n\tInténtalo otra vez.\n");
		}
		switch(respuesta) {
			case 1:
				System.out.println("\t\tDime el nombre que quieres para tu carpeta");
				File nuevaCarpeta = new File(directorio+"\\"+sc.nextLine());
				if(nuevaCarpeta.mkdir())
					System.out.println("\t\tCarpeta creada correctamente.");
				else
					System.out.println("\t\tAlgo salió mal...");
				break;
				
				
			case 2:
				System.out.println("\t\tDime en qué carpeta quieres crear el fichero. Puedes dejarlo vacío.");
				File nueva = new File(directorio+"\\"+sc.nextLine());
				if(!nueva.exists()) {
					System.out.println("Esa carpeta no existe...");
					break;
				}
				System.out.println("\t\tDime cómo quieres llamar a tu nuevo archivo. Sin extensión.");
				File nuevoArchivo = new File(nueva+"\\"+sc.nextLine()+".txt");
				System.out.println("\t\tDime qué quieres escribir dentro del archivo.");
				String contenido = sc.nextLine();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(nuevoArchivo));
					bw.write(contenido);
					bw.flush();
					bw.close();
					System.out.println("\t\tArchivo creado.");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("\t\tAlgo salió mal...");
				}
				break;
				
				
			case 3:
				System.out.println("\t\t¿Cómo se llama la carpeta que quieres borrar?");
				File carpetaBorrar = new File(directorio+"\\"+sc.nextLine());
				if(!carpetaBorrar.isDirectory()) {
					System.out.println("Esa carpeta no existe...");
					break;
				}
				if(carpetaBorrar.delete()) {
					System.out.println("\t\tCarpeta borrada correctamente.");
				}else {
					System.out.println("\t\tAlgo salió mal..."
							+ "\n\t\tEs posible que el directorio que hayas intentado borrar tuviese archivos dentro.");
				}
				break;
				
				
			case 4:
				System.out.println("\t\t¿En qué carpeta está el fichero que quieres borrar? Puedes dejarlo vacío.");
				File borrarCarpeta = new File(directorio+"\\"+sc.nextLine()); //Ya....
				if(!borrarCarpeta.exists()) {
					System.out.println("Esa carpeta no existe...");
					break;
				}
				System.out.println("\t\t¿Cómo se llama el fichero que quieres borrar? Se da por hecho que es un .txt");
				File ficheroBorrar = new File(borrarCarpeta+"\\"+sc.nextLine()+".txt");
				if(ficheroBorrar.delete()) {
					System.out.println("\t\tFichero eliminado correctamente.");
				}else {
					System.out.println("\t\tAlgo salió mal...");
				}
				break;
				
				
			case 5:
				System.out.println("\t\t¿En qué carpeta está el fichero que quieres leer? Puedes dejarlo vacío.");
				File carpetaLeer = new File(directorio+"\\"+sc.nextLine());
				if(!carpetaLeer.exists()) {
					System.out.println("Esa carpeta no existe...");
					break;
				}
				System.out.println("\t\t¿Cómo se llama el fichero que quieres leer? Se da por hecho ya que es un .txt");
				File ficheroLeer = new File(carpetaLeer+"\\"+sc.nextLine()+".txt");
				if(!ficheroLeer.exists()) {
					System.out.println("Parece que ese archivo no existe...");
				}
					
				try {
					BufferedReader br = new BufferedReader(new FileReader(ficheroLeer));
					
					String linea;
					while((linea = br.readLine())!=null) {
						System.out.println("\t\t\t"+linea);
					}
					br.close();
					
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
				
			case 6:
				System.out.println("\t\t\t¿Cómo se llama la carpeta de la que quieres ver información? Puedes dejarlo vacío.");
				File carpetaInfo = new File(directorio+"\\"+sc.nextLine());
				if(!carpetaInfo.exists()) {
					System.out.println("Esa carpeta no existe...");
					break;
				}
				
				File archivos[] = carpetaInfo.listFiles();
				String nombres = "";
				for(File archivo: archivos)
					nombres+="\n\t\t\t"+archivo.getName();
				System.out.println("\t\t\tNombre: "+carpetaInfo.getName()
									+"\n\t\t\tRuta absoluta: "+carpetaInfo.getAbsolutePath()
									+"\n\t\t\tFecha de modificación: "+new Date(carpetaInfo.lastModified())
									+"\n\t\t\tArchivos dentro: "+nombres);
				
				break;
				
			case 7:
				
				System.out.println("\t\t\t¿En qué carpeta está el archivo que quieres ver? Puedes dejarlo vacío.");
				File infoCarpeta = new File(directorio+"\\"+sc.nextLine());
				if(!infoCarpeta.exists()) {
					System.out.println("Esa carpeta no existe...");
					break;
				}
				System.out.println("\t\t\t¿De qué archivo quieres la información? Se da por hecho que es un .txt");
				File infoArchivo = new File(infoCarpeta+"\\"+sc.nextLine()+".txt");
				
				if(!infoArchivo.exists()) {
					System.out.println("Ese archivo no existe...");
					break;
				}
				System.out.println("\t\t\tNombre: "+infoArchivo.getName()
				+"\n\t\t\tRuta absoluta: "+infoArchivo.getAbsolutePath()
				+"\n\t\t\tFecha de modificación: "+new Date(infoArchivo.lastModified())
				+"\n\t\t\tContenidos: ");
				
				try {
					BufferedReader br = new BufferedReader(new FileReader(infoArchivo));
					
					String linea;
					while((linea = br.readLine())!=null) {
						System.out.println("\t\t\t\t"+linea);
					}
					br.close();
					
				}catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}
				
			case 8:
				salida = true;
				break;
				
		}
		if(salida)
			break;
		
		}
	}
	
	
	
	
}
