package piezas;

import java.util.List;

import modelo.Pieza;
import usuarios.Propietario;

public class Pintura extends Pieza{
	//< Atributos >
	private String tecnica;
	private String tipo;
	private double peso;
	
	
	//< Constructor >
	public Pintura(String idPieza, String idPropietario,  String titulo, String lugarCreacion, double ancho, double alto, String fechaLimite,
			boolean valorFijo, double valorinicial, String[] autores, String anioCreacion, String tecnica, String tipo, double peso) {
		
		super(idPieza, titulo, lugarCreacion, ancho, alto, fechaLimite, valorFijo, valorinicial, autores, idPropietario, anioCreacion);
		this.tecnica = tecnica;
		this.tipo = tipo;
		this.peso = peso;
	}
	
	
	
//< Getters >=====================================================================================================x>
	public String getTecnica() {
		return tecnica;
	}
	public String getTipo() {
		return tipo;
	}
	public double getPeso() {
		return  peso;
	}
//<x==============================================================================================================x>
	
	
	
//< Setters >=====================================================================================================x>
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
//<x==============================================================================================================x>
}