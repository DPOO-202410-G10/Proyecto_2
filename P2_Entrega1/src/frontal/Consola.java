package frontal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import modelo.Galeria;
import modelo.Pago;
import modelo.Pieza;
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
	
	protected void historialPieza(LinkedList<Pago> pagos){
		Pieza pieza = pagos.getFirst().getPieza();
		System.out.println("La informacion de la pieza " + pieza.getTitulo());
		System.out.println("Id pieza: " + pieza.getIdPieza()
						   + "\nAutores: "+ pieza.getAutores()
						   + "\nAnio creacion: "+pieza.getAnioCreacion()
						   + "\nLugar creacion: "+pieza.getLugarCreacion());
		System.out.println("Fecha venta\t Propietario\t Precio venta");
		for (Pago pago: pagos) {
			System.out.println(pago.getFecha() + "\t"+pago.getCliente().getNombre() + "\t " + pago.getPrecioFinal());
			System.out.println("------------------------------------------------------------");
		}
	}
	
	protected void historialArtista(LinkedList<Pieza> piezas, Usuario usuario, Map<String, Pago> pagos) throws Exception{
		System.out.println("La informacion de las piezas del artista ingresado son: ");
		for (Pieza pieza: piezas) {
			historialPieza(usuario.historialPieza(pagos, pieza.getIdPieza()));
		}
	}
	
	
	
	public abstract void mostrarMenu();
	
	public abstract void ejecutarOpcion(String opcion) throws Exception;
	
	
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
