package piezas;

import java.util.List;

import modelo.Pieza;
import usuarios.Propietario;

public class Escultura extends Pieza{


	private double profundidad;
	private List<String> materiales;
	private boolean necesidadElectricidad;




	public double getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(double profundidad) {
		this.profundidad = profundidad;
	}
	public List<String> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<String> materiales) {
		this.materiales = materiales;
	}
	public boolean isNecesidadElectricidad() {
		return necesidadElectricidad;
	}
	public void setNecesidadElectricidad(boolean necesidadElectricidad) {
		this.necesidadElectricidad = necesidadElectricidad;
	}




	public Escultura(String idPieza, String propietario,String titulo, String lugarCreacion, double ancho, double alto, String fechaLimite,
					 boolean valorFijo , double valorinicial, List<String> autores,
					 String anioCreacion,double profundidad, List<String> materiales, boolean necesidadElectricidad) {


		//String pieza,

		super(idPieza, titulo, lugarCreacion, ancho, alto, fechaLimite, valorFijo, valorinicial, autores, propietario,
				anioCreacion);
		// TODO Auto-generated constructor stub
		this.profundidad=profundidad;
		this.materiales=materiales;
		this.necesidadElectricidad=necesidadElectricidad;

	}



}
//acabado



