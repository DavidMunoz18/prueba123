package dijp.VistaMotosv2.dtos;

import java.sql.Date;

public class Usuariosdtos {
	String nombreUsuario;
	String apellidosUsuario;
	Date fechaNacimientoUsuario;
	String mailUsuario;
	String telefonoUsuario;
	String nicknameUsuario;
	String dniUsuario;
	String contrasenyaUsuario;
	
	public Usuariosdtos(String nombreUsuario, String apellidosUsuario, Date fechaNacimientoUsuario, String mailUsuario,
			String telefonoUsuario, String nicknameUsuario, String dniUsuario, String contrasenyaUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
		this.mailUsuario = mailUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.nicknameUsuario = nicknameUsuario;
		this.dniUsuario = dniUsuario;
		this.contrasenyaUsuario = contrasenyaUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getApellidosUsuario() {
		return apellidosUsuario;
	}
	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}
	public Date getFechaNacimientoUsuario() {
		return fechaNacimientoUsuario;
	}
	public void setFechaNacimientoUsuario(Date fechaNacimientoUsuario) {
		this.fechaNacimientoUsuario = fechaNacimientoUsuario;
	}
	public String getMailUsuario() {
		return mailUsuario;
	}
	public void setMailUsuario(String mailUsuario) {
		this.mailUsuario = mailUsuario;
	}
	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}
	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}
	public String getNicknameUsuario() {
		return nicknameUsuario;
	}
	public void setNicknameUsuario(String nicknameUsuario) {
		this.nicknameUsuario = nicknameUsuario;
	}
	public String getDniUsuario() {
		return dniUsuario;
	}
	public void setDniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
	public String getContrasenyaUsuario() {
		return contrasenyaUsuario;
	}
	public void setContrasenyaUsuario(String contrasenyaUsuario) {
		this.contrasenyaUsuario = contrasenyaUsuario;
	}
}
