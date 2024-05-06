package frontal;

import java.io.IOException;

import modelo.Galeria;

public abstract class Consola {
	protected Galeria galeria;
	
	public Consola() throws IOException {
		Galeria galeria = new Galeria("CasaSubasta");
		galeria.cargarDatos();
		this.galeria = galeria;
	}
	
	protected boolean iniciarSesion(String idUsuario, String contrasenia) {
		if (this.galeria.getUsuario(idUsuario).login(contrasenia)) {
			return true;
		}
		return false;
	}
	
	public abstract void mostrarMenu();
	
	public abstract void ejecutarOpcion();
	
}
