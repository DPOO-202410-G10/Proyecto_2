package frontal;

import java.io.IOException;

public class ConsolaAdministrador extends Consola{
	public ConsolaAdministrador() throws IOException {
		super();
	}
	public static void main(String[] args) throws IOException {
		ConsolaAdministrador consola = new ConsolaAdministrador();
		consola.mostrarMenu();
	}

	
	
	@Override
	public void mostrarMenu() {
		String user = input("Ingrese su ID de usuario: ");
		String contrasenia = input("Ingrese su contrasenia: ");
		try {
			if (iniciarSesion(user, contrasenia)) {
				String opcion = "opcion";
				do {
					System.out.println("< Bienvenido >");
					System.out.println("\t1. Crear pieza");
					System.out.println("\t2. Confirmar venta");
					System.out.println("\t3. Registrar empleado");
					System.out.println("\t4. Cambiar cupo de cliente");
					System.out.println("\t5. Crear subasta");
					System.out.println("\t6. Activar subasta");
					System.out.println("\t0. Salir");
					opcion = input("Seleccione una opción:\t");
					ejecutarOpcion(opcion);
				} while (!opcion.equals("0"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	private void crearPieza() {
		
	}
	
	private void confirmarVenta() {
		
	}

	private void registrarEmpleado() {
		
	}
	
	private void cambiarCupo() {
		
	}
	
	private void crearSubasta() {
		
	}
	
	private void activarSubasta() {
		
	}
	
	
	
	@Override
	public void ejecutarOpcion(String opcion) {
		switch (opcion) {
		case "1":
			crearPieza();
			break;
		case "2":
			confirmarVenta();
			break;
		case "3":
			registrarEmpleado();
			break;
		case "4":
			cambiarCupo();
			break;
		case "5":
			crearSubasta();
			break;
		case "6":
			activarSubasta();
			break;
		case "0":
			System.out.println("Gracias por ser parte de " + super.getNombreGaleria());
			break;
		default:
			System.out.println("Opcion invalida");
		}
	}
}

