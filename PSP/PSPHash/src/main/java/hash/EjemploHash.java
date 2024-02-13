package hash;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class EjemploHash {
	public static void main(String[] args) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		String texto = "Se dice Odú porque lo dice Estiik.";
		byte dataBytes[] = texto.getBytes();
		md.update(dataBytes);
		byte resumen[] = md.digest();
		System.out.println("Mensaje original: " + texto);
		System.out.println("Número de bytes: " + md.getDigestLength());
		System.out.println("Algoritmo: " + md.getAlgorithm());
		System.out.println("Mensaje resumen: " + Base64.getEncoder().encodeToString(resumen));
		System.out.println("Mensaje en Hexadecimal: " + Hexadecimal(resumen));
	};

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
}
