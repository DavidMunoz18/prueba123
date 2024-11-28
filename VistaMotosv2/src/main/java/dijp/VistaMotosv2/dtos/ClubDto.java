
package dijp.VistaMotosv2.dtos;

/**
 * Clase Para el Dto Club
 */
public class ClubDto {

	String nombreClub = "aaaaa";
	String coloresClub = "aaaaa";
	String mailClub = "aaaaa";
	String contrasenyaClub = "aaaaa";

	// Getters y Setters

	public String getNombreClub() {
		return nombreClub;
	}

	public void setNombre_Club(String nombreClub) {
		this.nombreClub = nombreClub;
	}

	public String getColoresClub() {
		return coloresClub;
	}

	public void setColoresClub(String coloresClub) {
		this.coloresClub = coloresClub;
	}

	public String getMailClub() {
		return mailClub;
	}

	public void setMailClub(String mailClub) {
		this.mailClub = mailClub;
	}

	public String getContrasenyaClub() {
		return contrasenyaClub;
	}

	public void setContrasenyaClub(String contraseniaClub) {
		this.contrasenyaClub = contraseniaClub;
	}

	public ClubDto(String nombreClub, String coloresClub, String mailClub, String contraseniaClub) {
		super();
		this.nombreClub = nombreClub;
		this.coloresClub = coloresClub;
		this.mailClub = mailClub;
		this.contrasenyaClub = contraseniaClub;

	}
}
