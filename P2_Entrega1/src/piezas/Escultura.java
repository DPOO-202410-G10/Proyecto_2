package piezas;

import java.util.ArrayList;
import java.util.List;

import modelo.Pieza;
import usuarios.Propietario;

public class Escultura extends Pieza{
	//< Atributos >
	private double profundidad;
	private String[] materiales;
	private boolean necesidadElectricidad;
	
	
	//< Constructor >
	public Escultura(String idPieza, String idPropietario,  String titulo, String lugarCreacion, double ancho, double alto, String fechaLimite,
			boolean valorFijo, double valorinicial, String[] autores, String anioCreacion, double profundidad, String[] materiales,boolean necesidadElectricidad) {

		super(idPieza, titulo, lugarCreacion, ancho, alto, fechaLimite, valorFijo, valorinicial, autores, idPropietario, anioCreacion);
		this.materiales = materiales;
		this.necesidadElectricidad = necesidadElectricidad;
		this.profundidad = profundidad;
	}
	
	
	
//< Getters >=====================================================================================================x>
	public double getProfundidad() {
		return profundidad;
	}
	
	public String[] getMateriales() {
		return materiales;
	}
	public boolean isNecesidadElectricidad() {
		return necesidadElectricidad;
	}
//<x==============================================================================================================x>
	
	
	
//< Setters >=====================================================================================================x>
	public void setProfundidad(double profundidad) {
		this.profundidad = profundidad;
	}
	
	public void setMateriales(String[] materiales) {
		this.materiales = materiales;
	}
	
	public void setNecesidadElectricidad(boolean necesidadElectricidad) {
		this.necesidadElectricidad = necesidadElectricidad;
	}
//<x==============================================================================================================x>
}
	
	
	

