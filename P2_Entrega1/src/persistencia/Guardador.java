package persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import modelo.Pago;
import modelo.Pieza;
import usuarios.Cajero;
import usuarios.Cliente;
import usuarios.Operador;
import usuarios.Propietario;

public class Guardador {
	
	public static void guardarPiezas(String rutaArchivo, Collection<Pieza> piezas) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
		for (Pieza pieza: piezas) {
			writer.write(pieza.toString());
		}
		writer.close();
	}
	
	
	public static void guardarEmpleados(String rutaArchivo, Collection<Cajero> cajeros, Collection<Operador> operadores) throws Exception {
		eliminarArchivo(rutaArchivo);
		crearArchivo(rutaArchivo);
		BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
		for (Cajero cajero: cajeros) {
			writer.write(cajero.toString());
		}
		for (Operador operador: operadores) {
			writer.write(operador.toString());
		}
		writer.close();
	}
	
	
	public static void guardarClientes(String rutaArchivo, Collection<Cliente> clientes) throws Exception {
		eliminarArchivo(rutaArchivo);
		crearArchivo(rutaArchivo);
		BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
		for (Cliente cliente: clientes) {
			writer.write(cliente.toString());
		}
		writer.close();
	}
	
	
	public static void guardarPropietarios(String rutaArchivo, Collection<Propietario> propietarios) throws Exception {
		eliminarArchivo(rutaArchivo);
		crearArchivo(rutaArchivo);
		BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
		for (Propietario propietario: propietarios) {
			writer.write(propietario.toString());
		}
		writer.close();
	}
	
	
	public static void guardarPagos(String rutaArchivo, Collection<Pago> pagos) throws Exception {
		eliminarArchivo(rutaArchivo);
		crearArchivo(rutaArchivo);
		BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
		for (Pago pago: pagos) {
			writer.write(pago.toString());
		}
		writer.close();
	}
	
	
	
	
	private static void eliminarArchivo(String rutaArchivo) throws Exception {
		File archivo = new File(rutaArchivo);
		if (!archivo.delete()) {
			throw new Exception("El archivo no se puedo eliminar");
		}
	}
	
	private static void crearArchivo(String rutaArchivo) throws IOException, Exception {
		File archivo = new File(rutaArchivo);
		if(!archivo.createNewFile()) {
			throw new Exception("El archivo no se pudo crear");
		}
	}
}
