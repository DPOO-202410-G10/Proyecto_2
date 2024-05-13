package frontal;

import java.io.IOException;

import usuarios.Administrador;

public class ConsolaAdministrador extends Consola{
	private Administrador administrador;
	
	public ConsolaAdministrador() throws Exception {
		super();
	}
	public static void main(String[] args) throws Exception {
		ConsolaAdministrador consola = new ConsolaAdministrador();
		consola.mostrarMenu();
	}

	
	public void mostrarMenu() {
		System.out.println("< Inicio Sesion - Administrador >======================x>");
		String user = input("Ingrese su ID de usuario: ");
		String contrasenia = input("Ingrese su contrasenia: ");
		try {
			Administrador usuario = (Administrador) iniciarSesion(user, contrasenia, "Administrador");
			if (usuario != null) {
				this.administrador = usuario;
				String opcion = "opcion";
				do {
					System.out.println("< Bienvenido >=========================================x>");
					System.out.println(" 1. Crear pieza");
					System.out.println(" 2. Confirmar venta");
					System.out.println(" 3. Registrar empleado");
					System.out.println(" 4. Cambiar cupo de cliente");
					System.out.println(" 5. Crear subasta");
					System.out.println(" 6. Activar subasta");
					System.out.println(" 7. Ver historial pieza");
					System.out.println(" 8. Ver historial artista");
					System.out.println(" 9. Ver historial comprador");
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
	
	
	
	private void crearPieza() {
		
	}
	
	private void confirmarVenta() {
		
	}

	private void registrarEmpleado() throws IOException {
		String tipoEmpleado = input("Seleccione el tipo de empleado que desea registrar: \n"
				+ "1. Operador\n"
				+ "2. Cajero\n"
				+ "0. Salir\n");
		switch (tipoEmpleado){
		case "1":
			tipoEmpleado = "Operador";
			break;
		case "2":
			tipoEmpleado = "Cajero";
			break;
		case "0":
			break;
		default:
			System.out.println("Ingrese una opcion valida");
		}
		String id = input("Ingrese el id del empleado: ");
		String clave = input("Ingrese la clave del empleado: ");
		String nombre = input("Ingrese el nombre del empleado: ");
		galeria.addUsuario(this.administrador.registrarEmpleado(tipoEmpleado, id, clave, nombre), tipoEmpleado, false);
	}
	
	private void cambiarCupo() {
		
	}
	
	private void crearSubasta() {
		
	}
	
	private void activarSubasta() {
		
	}
	
	private void getHistorialPieza() {
		
	}
	
	private void getHistorialArtista() {
		
	}
	
	private void getHistorialComprador() {
		
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
			try {
				registrarEmpleado();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
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
		case "7":
			getHistorialPieza();
			break;
		case "8":
			getHistorialArtista();
			break;
		case "9":
			getHistorialComprador();
			break;
		case "0":
			System.out.println("Gracias por ser parte de " + super.getNombreGaleria());
			break;
		default:
			System.out.println("Opcion invalida");
		}
	}
}

