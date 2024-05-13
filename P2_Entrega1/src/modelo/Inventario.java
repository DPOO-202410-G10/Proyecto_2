package modelo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import persistencia.Cargador;

public class Inventario {
	//< Atributos >
	Map<String, Map<String, Pieza>> piezas;
	
	
	//< Constructor >
	public Inventario(Cargador cargador) throws IOException {
		this.piezas = cargador.cargarInventario("data" + File.separator + "piezas.csv");
	}
	
	
	
//< Metodos >=====================================================================================================x>
	public void addPieza(Pieza pieza) throws Exception {
		if (getPieza(pieza.getIdPieza()) != null) {
			this.piezas.get("bodega").put(pieza.getIdPieza(), pieza);
		}
	}
	
	
	public void cambiarEstadoPieza(String idPieza, String estadoNuevo) throws Exception {
		for (String estado: this.piezas.keySet()) {
			if (piezas.get(estado).containsKey(idPieza) && !estadoNuevo.equals(estado)) {
				piezas.get(estado).remove(idPieza);
				piezas.get(estadoNuevo).put(idPieza, getPieza(idPieza));
			}
		}
	}
	
	
	public Pieza getPieza(String idPieza) throws Exception {
		for (Map<String, Pieza> conjuntos: this.piezas.values()) {
			if (conjuntos.containsKey(idPieza)) {
				return conjuntos.get(idPieza);
			}
		}
		throw new Exception("La pieza no se encuentra registrada");
	}
	
	public Map<String, Map<String, Pieza>> getPiezas(){
		return this.piezas;
	}
//<x==============================================================================================================x>
}
