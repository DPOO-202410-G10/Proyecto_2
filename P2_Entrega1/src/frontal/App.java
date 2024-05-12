package frontal;

import modelo.Galeria;
import modelo.Historial;
import modelo.Pieza;
import modelo.Subasta;
import piezas.Escultura;
import piezas.Fotografia;
import piezas.Impresion;
import piezas.Pintura;
import usuarios.Propietario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
	private final Galeria galeria;
	public App() {
		this.galeria = new Galeria("Mi galeria");
	}

	private void menuCrearSubasta() {
		System.out.println("Creando subasta...");

		boolean agregandoPieza = true;
		List<Pieza> piezasASubastar = new ArrayList<>();

		while (agregandoPieza) {
			String idPieza = input("Ingrese el ID de la pieza a subastar:");

			Pieza pieza = galeria.getPieza(idPieza);

			if (pieza.isValorFijo()) {
				System.out.println("Esa pieza es de valor fijo y no se puede subastar.");
				continue;
			}

			piezasASubastar.add(pieza);

			String seguir = input("Desea agregar más piezas? (S/N):");
			if (!seguir.equalsIgnoreCase("S")) agregandoPieza = false;
		}

		Subasta subasta = new Subasta(piezasASubastar);

		galeria.addSubasta(subasta);
		System.out.println("Subasta creada.");
	}










	private Pieza crearPieza(String tipo) {
		Pieza piezaCreada;

		String idPropietario = input("Ingrese el id del propietario:");
		String titulo = input("Ingrese el titulo de la obra:");
		String lugarCreacion = input("Ingrese el lugar:");
		String idPieza = input("Ingrese el id de la escultura:");
		Propietario propietario = galeria.getPropietario(idPropietario);
		double ancho = Double.parseDouble(input("Ingrese el ancho de la escultura:"));
		double alto = Double.parseDouble(input("Ingrese el alto de la escultura:"));
		String valorFijoInput = input("Ingrese el valor fijo (true/false):");
		boolean valorFijo = Boolean.parseBoolean(valorFijoInput);
		double valorInicial = Double.parseDouble(input("Ingrese el valor inicial:"));
		String autoresInput = input("Ingrese autores:");
		List<String> autores = Arrays.asList(autoresInput.split(","));
		String fechaLimite = input("Ingrese la fecha limite:");
		String anioCreacion = input("Ingrese el anioCreacion de la escultura:");



		switch (tipo) {
			case "1": // Escultura
				double profundidad = Double.parseDouble(input("Ingrese el profundidad de la escultura:"));
				String materialesInput = input("Ingrese lista de materiales separados por comas:");
				List<String> materiales = Arrays.asList(materialesInput.split(","));
				String electricidadInput = input("¿Necesita energía? (si/true, no/false):");
				boolean necesidadElectricidad = electricidadInput.equalsIgnoreCase("si") || electricidadInput.equalsIgnoreCase("true");



				piezaCreada = new Escultura(idPieza , titulo, lugarCreacion, ancho, alto, fechaLimite ,
						idPieza, valorFijo, valorInicial, autores, propietario, anioCreacion, profundidad,
						materiales,necesidadElectricidad);
				break;

			case "2": // Pintura

				String tecnica= input("Ingrese el tecnica de la pintura:");
				double peso= Double.parseDouble(input("ingrese el peso de la pintura:"));



				piezaCreada = new Pintura( idPieza,  propietario,titulo, lugarCreacion,
						ancho,  alto,  fechaLimite, valorFijo,  valorInicial, autores,
						anioCreacion,  tecnica,  tipo,  peso);

				break;
			case "3": // Fotografía

				String tipoEscultura= input("Ingrese tipo escultura:");

				piezaCreada = new Fotografia( idPieza,  propietario,   titulo, lugarCreacion,  ancho,  alto,  fechaLimite,
						valorFijo,  valorInicial,  autores,
						anioCreacion,  tipoEscultura);

				break;
			case "4": // Impresion

				String material = input("Ingrese el material de la Impresion: ");



				piezaCreada = new Impresion( idPieza,  propietario,   titulo, lugarCreacion,  ancho,  alto,  fechaLimite,
						valorFijo,  valorInicial,  autores, anioCreacion,  material);
				break;
			default:
				System.out.println("Opcion no valida");
				return null;
		}

		return piezaCreada;
	}

	private void menuRegistrarPieza() {
		System.out.println("Registrando pieza...");

		System.out.println("1. Escultura");
		System.out.println("2. Pintura");
		System.out.println("2. Fotografía");
		System.out.println("2. Impresión");
		String tipo = input("Ingrese el tipo de pieza:");

		Pieza pieza = crearPieza(tipo);

		if (pieza == null) {
			menuRegistrarPieza();
			return;
		}

		galeria.addPieza(pieza);
	}


	//< Metodos >====================================================================================================x>
	public void programaAdministrador() {
		System.out.println("OPciones para administrador");
		System.out.println("1. Registrar pieza");
		System.out.println("2. Crear subasta");

		String opcionSelecciona = input("Seleccione una opción:");

		switch (opcionSelecciona) {
			case "1":
				menuRegistrarPieza();
				break;
			case "2":
				menuCrearSubasta();
				break;
			default:
				System.out.println("Opcion no valida");
				programaAdministrador();
		}
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


	public void menu() {
		boolean mostrar = true;
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
	public static void main(String[] args) {
		App aplicacion = new App();
		aplicacion.menu();
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