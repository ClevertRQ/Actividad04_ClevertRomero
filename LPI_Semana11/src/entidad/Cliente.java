package entidad;

import java.sql.Date;

public class Cliente {
	private int idCliente;
	private String nombres;
	private String apellidos;
	private String dni;
	private Date fechaNacimiento;
	private TipoCliente idTipoCliente;
	private String tipoClienteTexto;
	
	public String getTipoClienteTexto() {
		   tipoClienteTexto = idTipoCliente.getNombre();
		   return tipoClienteTexto;
	}
	   
	public void setTipoClienteTexto(String tipoClienteTexto) {
		   this.tipoClienteTexto = tipoClienteTexto;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public TipoCliente getIdTipoCliente() {
		return idTipoCliente;
	}

	public void setIdTipoCliente(TipoCliente idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
}