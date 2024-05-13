package frontal;

import usuarios.Operador;

public class ConsolaOperador extends Consola {
	private Operador operador;
	
	public ConsolaOperador() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {
		ConsolaOperador consola = new ConsolaOperador();
		consola.mostrarMenu();
	}
	

	public void mostrarMenu() {
		System.out.println("< Inicio Sesion - Operador >===========================x>");
		String user = input("Ingrese su ID de usuario: ");
		String contrasenia = input("Ingrese su contrasenia: ");
		try {
			Operador usuario = (Operador) iniciarSesion(user, contrasenia, "Operador");
			if (usuario != null) {
				this.operador = usuario;
				String opcion = "opcion";
				do {
					System.out.println("< Bienvenido >=========================================x>");
					System.out.println(" 1. Ingresar a subasta");
					System.out.println(" 2. Crear historial");
					System.out.println(" 3. Crear puja");
					System.out.println(" 4. Elimianar puja");
					System.out.println(" 5. Cerrar historial");
					System.out.println(" 6. Ver historial pieza");
					System.out.println(" 7. Ver historial artista");
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
	
	
	
	private void ingrearASubasta() {
		
	}
	
	private void crearHistorial() {
		
	}
	
	private void crearPuja() {
		
	}
	
	private void eliminarPuja() {
		
	}
	
	private void cerrarHistorial() {
		
	}

	
	
	@Override
	public void ejecutarOpcion(String opcion) throws Exception {
		switch (opcion) {
		case "1":
			ingrearASubasta();
			break;
		case "2":
			crearHistorial();
			break;
		case "3":
			crearPuja();
			break;
		case "4":
			eliminarPuja();
			break;
		case "5":
			cerrarHistorial();
			break;
		case "6":
			String idPieza = input("Ingrese el id de la pieza a consultar: ");
			super.historialPieza(this.operador.historialPieza(this.galeria.getPagos(), idPieza));
			break;
		case "7":
			String artista = input("Ingrese el nombre del artista a consultar: ");
			super.historialArtista(this.operador.historialArtista(super.galeria.getInventario().getPiezas(), artista), this.operador, super.galeria.getPagos());
			break;
		case "0":
			System.out.println("Gracias por ser parte de " + super.getNombreGaleria());
			break;
		default:
			System.out.println("Opcion invalida");
		}
	}
}
