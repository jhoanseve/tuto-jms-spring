package tuto.jms.spring.dto;

import java.io.Serializable;

public class PersonaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String identificacion;
	private String nombres;
	private String apellidos;
	

	public PersonaDTO() {
		super();
	}

	public PersonaDTO(String identificacion, String nombres, String apellidos) {
		super();
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	@Override
	public String toString() {
		return "PersonaDTO [identificacion=" + identificacion + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ "]";
	}
}
