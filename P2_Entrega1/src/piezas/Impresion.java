package piezas;

import java.util.List;

import modelo.Pieza;
import usuarios.Propietario;

public class Impresion extends Pieza{
	//< Atributos >
	private String material;
	
	
	//< Constructor >
	public Impresion(String idPieza, String idPropietario,  String titulo, String lugarCreacion, double ancho, double alto, String fechaLimite,
			boolean valorFijo, double valorinicial, String[] autores, String anioCreacion, String material) {
		
		super(idPieza, titulo, lugarCreacion, ancho, alto, fechaLimite, valorFijo, valorinicial, autores, idPropietario, anioCreacion);
		this.material=material;
	}

	
	
//< Getters >=====================================================================================================x>
	public String getMaterial() {
		return material;
	}
//<x==============================================================================================================x>

	
	
//< Setters >=====================================================================================================x>
	public void setMaterial(String material) {
		this.material = material;
	}
//<x==============================================================================================================x>
}
