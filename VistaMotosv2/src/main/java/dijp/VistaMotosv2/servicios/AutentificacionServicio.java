package dijp.VistaMotosv2.servicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import dijp.VistaMotosv2.dtos.LoginDto;
import dijp.VistaMotosv2.dtos.UsuarioDto;
import dijp.VistaMotosv2.dtos.Usuariosdtos;
import jakarta.servlet.http.HttpSession;



@Service
public class AutentificacionServicio {

    @Value("${api.endpoint}")
    private String apiEndpoint;

    public String sendLoginData(LoginDto loginRequest, String campo, HttpSession session) {
        try {
            // Encriptar la contraseña antes de enviarla
            String contrasenyaEncriptada = EncriptarService.encriptarContraseña(loginRequest.getContrasenya());
            loginRequest.setContrasenya(contrasenyaEncriptada); // Establecer la contraseña encriptada

            // Crear la URI para la API
            URI uri = new URI("http://localhost:8081/apiMoteros/api/" + campo + "/login");
            URL url = uri.toURL();
            
            // Establecer la conexión HTTP
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Convertir la solicitud de login a JSON usando Jackson
            ObjectMapper mapper = new ObjectMapper();
            String jsonInput = mapper.writeValueAsString(loginRequest);
            
            // Enviar los datos al servidor
            try (OutputStream os = conexion.getOutputStream()) {
                os.write(jsonInput.getBytes());
                os.flush();
            }
            
            // Obtener el código de respuesta
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                // Leer la respuesta del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                // Convertir la respuesta JSON a un objeto UsuarioDto
                UsuarioDto usuario = mapper.readValue(response.toString(), UsuarioDto.class);
                
                // Si el usuario no es nulo, guardar la información del usuario en la sesión
                if (usuario != null) {
                    session.setAttribute("usuario", usuario);
                    return "success"; // Login exitoso
                } else {
                    System.out.println("Error: La respuesta de la API no contiene un usuario válido.");
                    return "error"; // Error si no se obtiene un usuario válido
                }
            } else {
                System.out.println("Error en la conexión: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error"; // Error por problemas con la conexión o datos incorrectos
    }

  
    public String sendAddUsu(Usuariosdtos usuDto) {
        // Crear una instancia de RestTemplate
        try {
            System.out.println("entramos en addUsu");
            URI uri = new URI("http://localhost:8081/apiMoteros/api/usuarios");
            URL url = uri.toURL();
            
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json");
            conexion.setDoOutput(true);

            // Crear el cuerpo de la solicitud con Jackson
            ObjectMapper mapper = new ObjectMapper();
            String jsonInput = mapper.writeValueAsString(usuDto);
            
            System.out.println(jsonInput);
            
            try (OutputStream os = conexion.getOutputStream()) {
                os.write(jsonInput.getBytes());
                os.flush();
            }
            System.out.print("Estamos en el final");

            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK) {
                System.out.print("credenciales validas");
                BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return "success";
            } else {
                System.out.println("Error en la conexión: " + codigoRespuesta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "asdf";
    }
}
