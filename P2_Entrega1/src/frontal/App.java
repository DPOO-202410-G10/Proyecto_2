package frontal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.Galeria;

public class App {
	public App() {
	}
	
	
//< Metodos >====================================================================================================x>
	public void programaAdministrador() {
		
	}
	
	public void programaCliente() {
		
	}
	
	public void programaPropietario() {
		
	}
	
	public void programaCajero() {
		
	}
	
	public void programaOperador() {
		
	}
//<x=============================================================================================================x>
	
	
	
//< MENU >=======================================================================================================x>
	public void opciones() {
		System.out.println("<x BIENVENIDO A ESTA, SU CASA x>");
		System.out.println(" 1. Administrador");
		System.out.println(" 2. Cliente");
		System.out.println(" 3. Propietario");
		System.out.println(" 4. Cajero");
		System.out.println(" 5. Operador");
		System.out.println(" 0. Salir");
	}
	
	
	public void menu(Galeria galeria) {
		Boolean mostrar = true;
		String opcion;
		do {
			opciones();
			opcion = input("Ingrese una opcion: ");
			switch (opcion) {
			case "1":
				programaAdministrador();
				break;
			case "2":
				programaCliente();
				break;
			case "3":
				programaPropietario();
				break;
			case "4":
				programaCajero();
				break;
			case "5":
				programaOperador();
				break;
			case "0":
				mostrar = false;
				System.out.println("Vuela pronto!");
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (mostrar);
	}
//<x=============================================================================================================x>
	
	
	
//< MAIN >=======================================================================================================x>
	public static void main(String[] args) throws Exception {
		App aplicacion = new App();
		Galeria galeria = new Galeria("Galeria Alpes");
		galeria.cargarDatos();
		aplicacion.menu(galeria);
	}
//<x=============================================================================================================x>	
	
	
	
//< Input Dinamico >=============================================================================================x>
	public static String input(String texto) {
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
