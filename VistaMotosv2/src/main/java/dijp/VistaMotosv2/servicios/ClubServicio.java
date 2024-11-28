package dijp.VistaMotosv2.servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import dijp.VistaMotosv2.dtos.ClubDto;

public class ClubServicio {

	public String enviarRegistroClub(ClubDto nuevoClub) {
		
		try {
			
			URI uri = new URI("http://localhost:8081/apiMoteros/api/clubs");
			URL url = uri.toURL();
			
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			
			conexion.setRequestProperty("content-Type", "application/json");
			conexion.setDoOutput(true);
			
			//Pasar el dto  a json para enviarlo a la api
			
			ObjectMapper mapper = new ObjectMapper();
			
			String dtoAJson = mapper.writeValueAsString(nuevoClub);
			System.out.println(dtoAJson);
			
			//Se envian los datos al servidor
			try (OutputStream os = conexion.getOutputStream()) {
	            os.write(dtoAJson.getBytes());
	            os.flush();
	            
	            // Leer la respuesta del servidor
	            int codigoRespuesta = conexion.getResponseCode();
	            
	            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
	            	
	                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
	                
	                StringBuilder response = new StringBuilder();
	                
	                String inputLine;
	                
	                while ((inputLine = in.readLine()) != null) {
	                	
	                    response.append(inputLine);
	                }
	                in.close();
	                
	                return "success"; // Puedes analizar más la respuesta si es necesario
	                
	            } else {
	            	
	                System.out.println("Error en la conexión: " + codigoRespuesta);
	            }
	        }
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return "error";
	}
	
}
