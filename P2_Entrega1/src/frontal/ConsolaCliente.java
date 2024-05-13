package frontal;

import usuarios.Administrador;
import usuarios.Cliente;

public class ConsolaCliente extends Consola {
	private Cliente cliente;
	
	public ConsolaCliente() throws Exception {
		super();
	}

	public static void main(String[] args) throws Exception {
		ConsolaCliente consola = new ConsolaCliente();
		consola.mostrarMenu();
	}
	

	public void mostrarMenu() {
		System.out.println("< Inicio Sesion - Cliente >============================x>");
		String user = input("Ingrese su ID de usuario: ");
		String contrasenia = input("Ingrese su contrasenia: ");
		try {
			Cliente usuario = (Cliente) iniciarSesion(user, contrasenia, "Cliente");
			if (usuario != null) {
				this.cliente = usuario;
				String opcion = "opcion";
				do {
					System.out.println("< Bienvenido >=========================================x>");
					System.out.println(" 1. Ver pagos realizados");
					System.out.println(" 2. Consultar piezas bajo dominio");
					System.out.println(" 3. Ver historial pieza");
					System.out.println(" 4. Ver historial artista");
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
	
	
	
	private void pagosRealizados() {
		
	}
	
	private void consultarPiezas() {
		
	}
	
	private void getHistorialPieza() {
		
	}
	
	private void getHistorialArtista() {
		
	}

	
	
	@Override
	public void ejecutarOpcion(String opcion) {
		switch (opcion) {
		case "1":
			pagosRealizados();
			break;
		case "2":
			consultarPiezas();
			break;
		case "3":
			getHistorialPieza();
			break;
		case "4":
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
