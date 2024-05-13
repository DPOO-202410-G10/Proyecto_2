package frontal;

import java.io.IOException;

import modelo.Pago;
import modelo.Pieza;
import usuarios.Cajero;
import usuarios.Cliente;

public class ConsolaCajero extends Consola{
	private Cajero cajero;
	private Cliente cliente;
	private Pieza piezas;
	private Pago pagos;
	
	public ConsolaCajero() throws IOException {
		super();
	}

	public static void main(String[] args) throws IOException {
		ConsolaCajero consola = new ConsolaCajero();
		consola.mostrarMenu();
	}
	

	public void mostrarMenu() {
		System.out.println("< Inicio Sesion - Cajero >=============================x>");
		String user = input("Ingrese su ID de usuario: ");
		String contrasenia = input("Ingrese su contrasenia: ");
		try {
			Cajero usuario = (Cajero) iniciarSesion(user, contrasenia, "Cajero");
			if (usuario != null) {
				this.cajero = usuario;
				String opcion = "opcion";
				do {
					System.out.println("< Bienvenido >=========================================x>");
					System.out.println(" 1. Generar pago");
					System.out.println(" 2. Ver historial pieza");
					System.out.println(" 3. Ver historial artista");
					System.out.println(" 0. Salir");
					opcion = input("Seleccione una opción:\t");
					System.out.println("<x=====================================================x>");
					ejecutarOpcion(opcion);
				} while (!opcion.equals("0"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	private void generarPago() {
		cajero.generarPago(cliente, piezas, pagos);
	}
	
	private void getHistorialPieza() {
		//TODO: test
	}
	
	private void getHistorialArtista() {
		
	}

	
	
	@Override
	public void ejecutarOpcion(String opcion) {
		switch (opcion) {
		case "1":
			generarPago();
			break;
		case "2":
			getHistorialPieza();
			break;
		case "3":
			getHistorialArtista();
			break;
		case "0":
			System.out.println("Gracias por ser parte de " + super.getNombreGaleria());
			break;
		default:
			System.out.println("Opcion invalida");
		}
	}
}
