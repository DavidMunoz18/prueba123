package dijp.VistaMotosv2.servicios;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncriptarService {
	public static String encriptarContraseña(String password) {
		try {
			// Creamos una instancia de MessageDigest con el algoritmo SHA-256
			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			// Convertimos la contraseña a bytes y generamos el hash
			byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

			// Convertimos los bytes a una cadena hexadecimal
			StringBuilder hexString = new StringBuilder();
			for (byte b : encodedhash) {
				String hex = String.format("%02x", b);
				hexString.append(hex);
			}

			// Retornamos el hash en formato de String
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

}