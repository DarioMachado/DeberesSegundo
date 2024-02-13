package ej2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		String original = hashing("perro");
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Escribe la contraseña");
		
		String nueva = hashing(sca.nextLine());
		
		if(original.equals(nueva))
			System.out.println("Esa era la contraseña");
		else
			System.out.println("Has fallado, recibirás 5 latigazos.");
		
	}
	
	static String Hexadecimal(byte[] resumen) {
		String hex = " ";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			if (h.length() == 1)
				hex += "0";
			hex += h;
		}
		return hex.toUpperCase();
	}
	
	public static String hashing(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			
			byte hash[] = pass.getBytes();
			md.update(hash);
			hash = md.digest();
			return Hexadecimal(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}
