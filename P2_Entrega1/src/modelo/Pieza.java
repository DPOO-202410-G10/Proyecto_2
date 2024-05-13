package modelo;

import java.util.List;

import usuarios.Propietario;

public abstract class Pieza {
	protected String idPieza;
	protected String titulo;
	protected String lugarCreacion;
	protected double ancho;
	protected double alto;
	protected String fechaLimite;
	protected boolean valorFijo;
	protected double valorinicial;
	protected List<String> autores;
	protected String propietario;
	protected String anioCreacion;

	public Pieza(String idPieza, String titulo, String lugarCreacion, double ancho, double alto, String fechaLimite,
				 boolean valorFijo, double valorinicial, List<String> autores, String propietario,
				 String anioCreacion) {
		this.idPieza = idPieza;
		this.titulo = titulo;
		this.lugarCreacion = lugarCreacion;
		this.ancho = ancho;
		this.alto = alto;
		this.fechaLimite = fechaLimite;
		this.valorFijo = valorFijo;
		this.valorinicial = valorinicial;
		this.autores = autores;
		this.propietario = propietario;
		this.anioCreacion = anioCreacion;
	}


	public String getIdPieza() {
		return idPieza;
	}
	public void setIdPieza(String idPieza) {
		this.idPieza = idPieza;
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getLugarCreacion() {
		return lugarCreacion;
	}
	public void setLugarCreacion(String lugarCreacion) {
		this.lugarCreacion = lugarCreacion;
	}


	public double getAncho() {
		return ancho;
	}
	public void setAncho(float ancho) {
		this.ancho = ancho;
	}


	public double getAlto() {
		return alto;
	}
	public void setAlto(float alto) {
		this.alto = alto;
	}

	public String getFechaLimite() {
		return fechaLimite;
	}
	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getAnioCreacion() {
		return anioCreacion;
	}
	public void setAnioCreacion(String anioCreacion) {
		this.anioCreacion = anioCreacion;
	}
	public boolean isValorFijo() {
		return valorFijo;
	}
	public void setValorFijo(boolean valorFijo) {
		this.valorFijo = valorFijo;
	}

	public double getValorInicial() {
		return valorinicial;
	}
	public void setValorinicial(double valorinicial) {
		this.valorinicial = valorinicial;
	}

	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
}
//acabado