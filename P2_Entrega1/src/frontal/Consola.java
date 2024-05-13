package frontal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

import modelo.Galeria;
import modelo.Usuario;

public abstract class Consola {
	protected Galeria galeria;
	
	public Consola() throws Exception {
		Galeria galeria = new Galeria("CasaSubasta");
		galeria.cargarDatos();
		this.galeria = galeria;
	}
	
	protected Usuario iniciarSesion(String idUsuario, String contrasenia, String tipoUsuario) throws Exception {
		if (this.galeria.getUsuario(idUsuario, tipoUsuario).login(contrasenia)) {
			return this.galeria.getUsuario(idUsuario, tipoUsuario);
		}
		throw new Exception("El ID del usuario o la clave no son correctas");
	}
	
	
	
	protected String getNombreGaleria() {
		return this.galeria.getNombre();
	}
	
	protected Collection<String> historialPieza(String idPieza){
		return null;
	}
	
	protected Collection<String> historialArtista(String nombreArtista){
		return null;
	}
	
	
	
	public abstract void mostrarMenu();
	
	public abstract void ejecutarOpcion(String opcion);
	
	
//< Input Dinamico >=============================================================================================x>
	protected String input(String texto) {
		try {
			System.out.print(texto);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input = reader.readLine();
			return input;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
//<x=============================================================================================================x>
}
