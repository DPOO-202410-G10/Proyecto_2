package piezas;

import java.util.List;

import modelo.Pieza;
import usuarios.Propietario;

public class Fotografia extends Pieza{

	private String tipo;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}








	public Fotografia(String idPieza, Propietario propietario,  String titulo,String lugarCreacion, double ancho, double alto, String fechaLimite,
					  boolean valorFijo, double valorInicial, List<String> autores,
					  String anioCreacion, String tipo) {
		super(idPieza, titulo, lugarCreacion, ancho, alto, fechaLimite, valorFijo, valorInicial, autores, propietario,
				anioCreacion);
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
	}

}
//acabado