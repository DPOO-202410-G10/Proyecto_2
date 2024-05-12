package frontal;

import java.io.IOException;
import usuarios.Operador;

public class ConsolaOperador extends Consola {
	private Operador operador;
	
	public ConsolaOperador() throws IOException {
		super();
	}

	public static void main(String[] args) throws IOException {
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
	public void ejecutarOpcion(String opcion) {
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
		case "0":
			System.out.println("Gracias por ser parte de " + super.getNombreGaleria());
			break;
		default:
			System.out.println("Opcion invalida");
		}
	}
}
