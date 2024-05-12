package frontal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Galeria;

public abstract class Consola {
	protected Galeria galeria;
	
	public Consola() throws IOException {
		Galeria galeria = new Galeria("CasaSubasta");
		galeria.cargarDatos();
		this.galeria = galeria;
	}
	
	protected boolean iniciarSesion(String idUsuario, String contrasenia) throws Exception {
		if (this.galeria.getUsuario(idUsuario).login(contrasenia)) {
			return true;
		}
		throw new Exception("El ID del usuario o la clave no son correctas");
	}
	
	
	protected String getNombreGaleria() {
		return this.galeria.getNombre();
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
