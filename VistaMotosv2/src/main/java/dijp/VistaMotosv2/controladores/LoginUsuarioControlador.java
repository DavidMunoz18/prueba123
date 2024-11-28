package dijp.VistaMotosv2.controladores;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dijp.VistaMotosv2.dtos.LoginDto;
import dijp.VistaMotosv2.dtos.Usuariosdtos;
import dijp.VistaMotosv2.servicios.AutentificacionServicio;
import jakarta.servlet.http.HttpSession;



@Controller
public class LoginUsuarioControlador {

    @Autowired
    private AutentificacionServicio apiService;

    // Redirige al login cuando se accede a la raíz
    @GetMapping("/")
    public String firstPage() {
        return "redirect:/login";
    }

    // Muestra la página de login
    @GetMapping("/login")
    public String showLoginPage() {
        return "iniciarSesionUsuario"; // Vista de login
    }

    // Maneja el proceso de login cuando se envía el formulario
    @PostMapping("/login")
    public String handleLogin(@RequestParam String mail, @RequestParam String contrasenya, HttpSession session) {
        // Objeto que representa la solicitud de login
        LoginDto loginRequest = new LoginDto(mail, contrasenya);

        // Llamada al servicio API para procesar el login
        String response = apiService.sendLoginData(loginRequest, "usuarios", session);

        // Si la respuesta es "success", redirige a la ventana principal
        if ("success".equalsIgnoreCase(response)) {
            return "redirect:/index"; // Redirige al panel principal
        } else {
            // Si las credenciales son incorrectas, muestra el error en la vista de login
            return "iniciarSesionUsuario?error"; // Vuelve a la página de login con error
        }
    }

    // Maneja el registro de un nuevo usuario
    @PostMapping("/addUsu")
    public String addUsu(@RequestParam String nombre, @RequestParam String apellidos,
                         @RequestParam Date fechaNacimiento, @RequestParam String email, 
                         @RequestParam String telefono, @RequestParam String nick, 
                         @RequestParam String dni, @RequestParam String contrasenya) {
        
        // Crea el objeto Usuariosdtos con los datos proporcionados
        Usuariosdtos usuDto = new Usuariosdtos(nombre, apellidos, fechaNacimiento, email, telefono, nick, dni, contrasenya);
        
        // Llama al servicio para registrar el usuario
        String response = apiService.sendAddUsu(usuDto);

        // Si la respuesta es "success", redirige al panel principal
        if ("success".equalsIgnoreCase(response)) {
            return "redirect:/index";
        }
        
        // Si ocurre un error, redirige al login con un parámetro de error
        return "redirect:/iniciarSesionUsuario?error";
    }

    
}
