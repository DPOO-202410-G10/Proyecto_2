package modelo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public abstract class Usuario implements InformacionHistorial {
	//< Atributos >
	protected String idUsuario;
	protected String contrasenia;
	protected String nombre;
	
	
	//< Constructor >
	public Usuario(String idUsuario, String contrasenia, String nombre) {
		this.idUsuario = idUsuario;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
	}
	
	
	
//< Metodos >=====================================================================================================x>
	public boolean login(String contrasenia) {
		if (contrasenia.equals(this.contrasenia)) {
			return true;
		}
		return false;
	}
	
	public LinkedList<Pago> historialPieza(Map<String,Pago> pagos, String idPieza) throws Exception{
		LinkedList<Pago> pagosRegistradosPieza = new LinkedList<Pago>();
		for (Pago pago: pagos.values()) {
			if (pago.getPieza().getIdPieza().equals(idPieza)) {
				pagosRegistradosPieza.add(pago);
			}
		}
		if (pagosRegistradosPieza.size() != 0) {
			return pagosRegistradosPieza;
		} else {
			throw new Exception("No existe información de la pieza");
		}
	}
	
	public LinkedList<Pieza> historialArtista(Map<String, Map<String, Pieza>> piezas, String nombreArtista) throws Exception{
		LinkedList<Pieza> piezasArtista = new LinkedList<Pieza>();
		for (Map<String, Pieza> piezasClasificadas: piezas.values()) {
			for (Pieza pieza: piezasClasificadas.values()) {
			for (String autor: pieza.getAutores()) {
				if (autor.toLowerCase().equals(nombreArtista.toLowerCase())) {
					piezasArtista.add(pieza);
				}
			}
			}
		}
		if (piezasArtista.size() != 0) {
			return piezasArtista;
		} else {
			throw new Exception("No existe información del artista en las piezas");
		}
	}
//<x==============================================================================================================x>

	
	
//< Getters >=====================================================================================================x>
	public String getContrasenia() {
		return contrasenia;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getID(){
		return this.idUsuario;
	}
//<x==============================================================================================================x>
}
