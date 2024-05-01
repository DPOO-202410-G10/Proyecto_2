package piezas;

import java.util.List;

import modelo.Pieza;
import usuarios.Propietario;

public class Fotografia extends Pieza{
	//< Atributos >
	private String tipo;
	
	
	//< Constructor >
	public Fotografia(String idPieza, String idPropietario,  String titulo, String lugarCreacion, double ancho, double alto, String fechaLimite,
			boolean valorFijo, double valorinicial, String[] autores, String anioCreacion, String tipo) {

		super(idPieza, titulo, lugarCreacion, ancho, alto, fechaLimite, valorFijo, valorinicial, autores, idPropietario, anioCreacion);
		this.tipo = tipo;
	}

	
	
//< Getters >=====================================================================================================x>
	public String getTipo() {
		return tipo;
	}
//<x==============================================================================================================x>

	
	
//< Setters >=====================================================================================================x>
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
//<x==============================================================================================================x>
}