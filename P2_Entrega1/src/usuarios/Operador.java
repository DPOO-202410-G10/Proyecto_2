package usuarios;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import modelo.Historial;
import modelo.Pieza;
import modelo.Subasta;
import modelo.Usuario;

public class Operador extends Usuario{

	//< Constructor >
	public Operador(String idUsuario, String contrasenia, String nombre) {
		super(idUsuario, contrasenia, nombre);
	}
	
	private Map<String, Pieza> piezas;
	private Subasta subasta;
	private String tituloPieza;
//< Metodos >=====================================================================================================x>
	public void crearHistorial(String tituloPieza) {
		Pieza pieza = null;
		for (Pieza p: piezas.values()) {
			if (p.getTitulo().equals(tituloPieza)) {
				pieza = p;
				break;
			}
		}
		if (pieza == null) {
			System.out.println("No se encontró una pieza con el título: " + tituloPieza);
			return;
		}
		String idHistorial = pieza.getIdPieza();
		Map<Integer, String> historialMap = new HashMap<>();
		Historial historial = new Historial(idHistorial, pieza, historialMap);
		
		subasta.addHistorial(historial);
	}
	
	public void aniadirPuja(String idComprador, int valor) {
		if (!subasta.estaCliente(idComprador)) {
			System.out.println("El comprador con ID " + idComprador + " no está registrado en la subasta.");
	        return;
		}
		Pieza pieza = null;
		for (Pieza p: subasta.getPiezas().values()) {
			if (p.getTitulo().equals(tituloPieza)) {
				pieza = p;
				break;
			}
		}
		if (pieza == null) {
			System.out.println("No se encontró una pieza con el título: " + tituloPieza);
			return;
		}
		Historial historial = null;
		for (Historial h: subasta.getHistoriales().values()) {
			if (h.getPieza().equals(pieza)) {
				historial = h;
				break;
			}
		}
		if (historial == null) {
			System.out.println("No se encontró un historial para la pieza: " + tituloPieza);
			return;
		}
		historial.agregarAlMapa(valor, idComprador);
	}
	
	
	
	
	public String[] eliminarPuja() {
		Pieza pieza = null;
		for (Pieza p: subasta.getPiezas().values()) {
			if (p.getTitulo().equals(tituloPieza)) {
				pieza = p;
				break;
			}
		}
		if (pieza == null) {
			System.out.println("No se encontró una pieza con el título: " + tituloPieza);
			return null;
		}
		Historial historial = null;
		for (Historial h: subasta.getHistoriales().values()) {
			if (h.getPieza().equals(pieza)) {
				historial = h;
				break;
			}
		}
		if (historial == null) {
			System.out.println("No se encontró un historial para la pieza: " + tituloPieza);
			return null;
		}
		Map<Integer, String> historialMap = historial.getHistorial();
		int ultimaPuja = Collections.max(historialMap.keySet());
		String idComprador = historialMap.get(ultimaPuja);
		
		historialMap.remove(ultimaPuja);
		
		return new String[] {idComprador, String.valueOf(ultimaPuja)};
	}
//<x==============================================================================================================x>
}
