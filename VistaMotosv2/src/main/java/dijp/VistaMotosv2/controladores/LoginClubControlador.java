package dijp.VistaMotosv2.controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dijp.VistaMotosv2.dtos.ClubDto;
import dijp.VistaMotosv2.servicios.ClubServicio;
import dijp.VistaMotosv2.servicios.EncriptarService;

public class LoginClubControlador {

	@PostMapping("/darAltaClub")
	public String darAltaClub(@RequestParam String nombreClub, @RequestParam String coloresClub, @RequestParam String mailClub, @RequestParam String contraseniaClub) {
	
	ClubDto nuevoClub = new ClubDto(  nombreClub,  coloresClub,   mailClub,   EncriptarService.encriptarContraseña(contraseniaClub));
	
	String respuesta = ClubServicio.enviarRegistroClub(nuevoClub);
	
	if("success".equalsIgnoreCase(respuesta)) {
		
		return "redirect:/ventanaPrincipal";
	}else {
		
		return "redirect:/login?error";
	}
}

}
