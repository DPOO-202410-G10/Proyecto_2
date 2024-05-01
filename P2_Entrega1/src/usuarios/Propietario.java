package usuarios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Pieza;
import modelo.Usuario;

public class Propietario extends Usuario{
	//< Atributos >
	private boolean esComprador;
	private String telefono;
	private String direccion;
	private Map<String, Map<String, Pieza>> piezas;

	
	//< Constructor >
	public Propietario(String idUsuario, String contrasenia, String nombre, 
			boolean esComprador, String telefono, String direccion, Map<String, Map<String, Pieza>> piezas) {
		
		super(idUsuario, contrasenia, nombre);
		this.esComprador = esComprador;
		this.telefono = telefono;
		this.direccion = direccion;
		this.piezas = piezas;
	}
	
	
	
//< Metodos >=====================================================================================================x>
	public List<Pieza> consultarPiezasBajoDominio(){
		List<Pieza> piezasBajoDom = new ArrayList<>();
		for (Map<String, Pieza> categoria: piezas.values()) {
			for (Pieza pieza: categoria.values()) {
				if (pieza.getPropietario() == this.getID()) {
					piezasBajoDom.add(pieza);
				}
			}
		}
		return piezasBajoDom;
	}
//<x==============================================================================================================x>
}
