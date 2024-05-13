package frontal;

import usuarios.Cajero;

public class ConsolaCajero extends Consola{
	private Cajero cajero;
	
	public ConsolaCajero() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {
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
		
	}
	
	
	
	@Override
	public void ejecutarOpcion(String opcion) throws Exception {
		switch (opcion) {
		case "1":
			generarPago();
			break;
		case "2":
			String idPieza = input("Ingrese el id de la pieza a consultar: ");
			super.historialPieza(this.cajero.historialPieza(this.galeria.getPagos(), idPieza));
			break;
		case "3":
			String artista = input("Ingrese el nombre del artista a consultar: ");
			super.historialArtista(this.cajero.historialArtista(super.galeria.getInventario().getPiezas(), artista), this.cajero, super.galeria.getPagos());
			break;
		case "0":
			System.out.println("Gracias por ser parte de " + super.getNombreGaleria());
			break;
		default:
			System.out.println("Opcion invalida");
		}
	}
}
