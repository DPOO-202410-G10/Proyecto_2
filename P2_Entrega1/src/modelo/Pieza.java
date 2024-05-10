package modelo;

import java.util.List;

import usuarios.Propietario;

public abstract class Pieza {
	//< Atributos >
	protected String idPieza;
	protected String titulo;
	protected String lugarCreacion;
	protected double ancho;
	protected double alto;
	protected String fechaLimite;
	protected boolean valorFijo;
	protected double valorinicial;
	protected String[] autores;
	protected String idPropietario;
	protected String anioCreacion;
	
	
	//< Constructor >
	public Pieza(String idPieza, String titulo, String lugarCreacion, double ancho, double alto, String fechaLimite,
			boolean valorFijo, double valorinicial, String[] autores, String idPropietario,
			String anioCreacion) {
		super();
		this.idPieza = idPieza;
		this.titulo = titulo;
		this.lugarCreacion = lugarCreacion;
		this.ancho = ancho;
		this.alto = alto;
		this.fechaLimite = fechaLimite;
		this.valorFijo = valorFijo;
		this.valorinicial = valorinicial;
		this.autores = autores;
		this.idPropietario = idPropietario;
		this.anioCreacion = anioCreacion;
	}
	
	

//< Getters >=====================================================================================================x>
	public String getIdPieza() {
		return idPieza;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getLugarCreacion() {
		return lugarCreacion;
	}	
	public double getAncho() {
		return ancho;
	}
	public double getAlto() {
		return alto;
	}
	public String getFechaLimite() {
		return fechaLimite;
	}
	public String getAnioCreacion() {
		return this.anioCreacion;
	}
	public boolean isValorFijo() {
		return valorFijo;
	}
	public double isValorinicial() {
		return valorinicial;
	}
	public String[] getAutores() {
		return autores;
	}
	public String getPropietario() {
		return this.idPropietario;
	}
//<x==============================================================================================================x>
	

	
//< Setters >=====================================================================================================x>
	public void setIdPieza(String idPieza) {
		this.idPieza = idPieza;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setLugarCreacion(String lugarCreacion) {
		this.lugarCreacion = lugarCreacion;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}
	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}
	public void setAnioCreacion(String anioCreacion) {
		this.anioCreacion = anioCreacion;
	}
	public void setValorFijo(boolean valorFijo) {
		this.valorFijo = valorFijo;
	}
	public void setValorinicial(double valorinicial) {
		this.valorinicial = valorinicial;
	}
	public void setAutores(String[] autores) {
		this.autores = autores;
	}
	public void setPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}
//<x==============================================================================================================x>
}