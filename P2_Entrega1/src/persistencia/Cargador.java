package persistencia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Historial;
import modelo.Inventario;
import modelo.Pago;
import modelo.Pieza;
import modelo.Subasta;
import piezas.Escultura;
import piezas.Fotografia;
import piezas.Impresion;
import piezas.Pintura;
import usuarios.Administrador;
import usuarios.Cajero;
import usuarios.Cliente;
import usuarios.Operador;
import usuarios.Propietario;

public class Cargador {
	public Cargador() {
	}
	
//< Carga de Datos Individuales >================================================================================x>
	public Administrador cargarAdmin(String rutaArchivo) throws IOException {
		FileReader file = new FileReader(rutaArchivo);
		BufferedReader br = new BufferedReader(file);
		String[] linea = br.readLine().split(";");
		linea = br.readLine().split(";");
		Administrador admin = new Administrador(linea[0], linea[1], linea[2]);
		br.close();
		return admin;
		}
		
	//<x========================================================================================================x>
		
	public Map<String, Cliente> cargarClientes(String rutaArchivo) throws IOException {
		Map<String, Cliente> clientes = new HashMap<String, Cliente>();
		
		FileReader file = new FileReader(rutaArchivo);
		BufferedReader br = new BufferedReader(file);
		String l = br.readLine(); l = br.readLine();
		String[] linea;
		
		while(l != null) {
			linea = l.split(";");
			Cliente cliente = new Cliente(linea[0], linea[1], linea[2], 
								Boolean.parseBoolean(linea[3]), linea[4], linea[5], 
								Integer.parseInt(linea[6]));
			clientes.put(linea[0], cliente);
			l = br.readLine();
		}
		br.close();
		return clientes;
	}
		
	//<x========================================================================================================x>
		
	public void cargarEmpleados(String rutaArchivo, Map<String, Cajero> cajeros, Map<String, Operador> operadores) throws IOException {
		
		FileReader file = new FileReader(rutaArchivo);
		BufferedReader br = new BufferedReader(file);
		String l = br.readLine(); l = br.readLine();
		String[] linea;
		
		while(l != null) {
			linea = l.split(";");
			if(linea[3].equals("Cajero")) {
				Cajero empleado = new Cajero(linea[0], linea[1], linea[2]);
				cajeros.put(linea[0], empleado);
			} else if(linea[3].equals("Operador")) {
				Operador empleado = new Operador(linea[0], linea[1], linea[2]);
				operadores.put(linea[0], empleado);
			}
			l = br.readLine();
		}
		br.close();
		}
		
	//<x========================================================================================================x>
		
	public Map<String, Map<String, Pieza>> cargarInventario(String rutaArchivo) throws IOException{
		Map<String, Map<String, Pieza>> piezasCargar = new HashMap<String, Map<String, Pieza>>();
		
		FileReader file = new FileReader(rutaArchivo);
		BufferedReader br = new BufferedReader(file);
		String l = br.readLine(); l = br.readLine();
		String[] linea;
		
		while(l != null) {
			linea = l.split(";");
			String[] caracteristicas = linea[12].split(",");
			Pieza pieza = null;
			switch (linea[11].toLowerCase()) {
			case "pintura":
				pieza = new Pintura(
						linea[0], linea[1], linea[2], linea[3], Double.parseDouble(linea[4]),
						Double.parseDouble(linea[5]), linea[6], Boolean.parseBoolean(linea[7]), Double.parseDouble(linea[8]),
                        List.of(linea[9].split(",")), linea[10], caracteristicas[0], caracteristicas[1], Double.parseDouble(caracteristicas[2]));
				break;
			case "escultura":
				pieza = new Escultura(

						linea[0], linea[1], linea[2], linea[3], Double.parseDouble(linea[4]),
						Double.parseDouble(linea[5]), linea[6], Boolean.parseBoolean(linea[7]), Double.parseDouble(linea[8]),
                        List.of(linea[9].split(",")), linea[10], Double.parseDouble(caracteristicas[0]), List.of(caracteristicas[1].split(",")),
						Boolean.parseBoolean(caracteristicas[2]));
				break;
			case "fotografia":
				pieza = new Fotografia(


						linea[0], linea[1], linea[2], linea[3], Double.parseDouble(linea[4]),
						Double.parseDouble(linea[5]), linea[6], Boolean.parseBoolean(linea[7]), Double.parseDouble(linea[8]),
                        List.of(linea[9].split(",")), linea[10], caracteristicas[0]);
				break;
			case "impresion":
				pieza = new Impresion(linea[0], linea[1], linea[2], linea[3], Double.parseDouble(linea[4]),
						Double.parseDouble(linea[5]), linea[6], Boolean.parseBoolean(linea[7]), Double.parseDouble(linea[8]),
                        List.of(linea[9].split(",")), linea[10], caracteristicas[0]);
				break;
			}
			
			if (piezasCargar.get(linea[13]) != null) {
				piezasCargar.get(linea[13]).put(linea[0], pieza);
			} else {
				piezasCargar.put(linea[13], new HashMap<String, Pieza>());
				piezasCargar.get(linea[13]).put(linea[0], pieza);
			}
			l = br.readLine();
		}
		br.close();
		
		return piezasCargar;
	}
	
	//<x========================================================================================================x>
	
	public Map<String, Propietario> cargarPropietarios(String rutaArchivo, Inventario inventario) throws IOException{
		Map<String, Propietario> propietarios = new HashMap<String, Propietario>();
		
		FileReader file = new FileReader(rutaArchivo);
		BufferedReader br = new BufferedReader(file);
		String l = br.readLine(); l = br.readLine();
		String[] linea;
		
		while(l != null) {
			linea = l.split(";");
			Map<String, Map<String, Pieza>> piezasHistorial = new HashMap<String, Map<String, Pieza>>();
			Map<String, Pieza> antiguas = new HashMap<String, Pieza>();
			Map<String, Pieza> actuales = new HashMap<String, Pieza>();
			
			for (String idPieza: linea[6].split(",")) {
				antiguas.put(idPieza, inventario.getPieza(idPieza));
			}
			for (String idPieza: linea[7].split(",")) {
				actuales.put(idPieza, inventario.getPieza(idPieza));
			}
			
			piezasHistorial.put("Antiguas" , antiguas);
			piezasHistorial.put("Actuales", actuales);
			
			Propietario propietario = new Propietario(linea[0], linea[1], linea[2],
										Boolean.valueOf(linea[3]), linea[4], linea[5], piezasHistorial);
			propietarios.put(linea[0], propietario);
			l = br.readLine();
		}
		br.close();
		
		return propietarios;
	}
	
	//<x========================================================================================================x>
	
	public Map<String, Pago> cargarPagos(String rutaArchivo, Map<String, Cliente> clientes, Inventario inventario) throws IOException{
		Map<String, Pago> pagos = new HashMap<String, Pago>();
		
		FileReader file = new FileReader(rutaArchivo);
		BufferedReader br = new BufferedReader(file);
		String l = br.readLine(); l = br.readLine();
		String[] linea;
		
		while(l != null) {
			linea = l.split(";");
			Pago pago = new Pago(linea[0],linea[3], Integer.parseInt(linea[4]),Double.parseDouble(linea[5]),
					inventario.getPieza(linea[2]),clientes.get(linea[1])
					);
			pagos.put(linea[0], pago);
			l = br.readLine();
		}
		br.close();
		
		return pagos;
	}
	
	//<x========================================================================================================x>
	
	public Subasta cargarSubasta(String rutaArchivo, Map<String, Cliente> clientes, Inventario inventario) throws IOException {
		Subasta subasta = null;
		
		FileReader file = new FileReader(rutaArchivo);
		BufferedReader br = new BufferedReader(file);
		String l = br.readLine(); String[] infoSubasta = br.readLine().split(";"); l = br.readLine(); l = br.readLine();
		if (infoSubasta != null) { 
			String[] linea;
			Map<String, Historial> historiales = new HashMap<String, Historial>();
			Historial historialActual = null;
			
			while(l != null) {
				linea = l.split(";");
				Map<Integer, String> pujas = new HashMap<Integer, String>();
				for (String pareja: linea[2].split(",")) {
					String[] datosPuja = pareja.split(":");
					pujas.put(Integer.parseInt(datosPuja[0]), datosPuja[1]);
				}
				Historial historial = new Historial(linea[0], inventario.getPieza(linea[1]), pujas);
				
				if (historialActual == null) {
					historialActual = historial;
				} else {
					historiales.put(linea[0], historial);
				}
				l = br.readLine();
			}
			if (infoSubasta[1].equals("Pendiente")) {
				subasta = new Subasta(infoSubasta[0]);
			} else if (infoSubasta[1].equals("Activa")) {
				subasta = new Subasta(infoSubasta[0], infoSubasta[1], historialActual, clientesPiezasSubasta(clientes, inventario)[1],
						clientesPiezasSubasta(clientes, inventario)[0], historiales);
			}
			br.close();
		}
		return subasta;
	}
	
	//<x========================================================================================================x>
	
	private Map[] clientesPiezasSubasta(Map<String, Cliente> clientes, Inventario inventario) throws IOException{
		Map<String, Cliente> usuariosSubasta = new HashMap<String, Cliente>();
		Map<String, Pieza> piezaSubasta = new HashMap<String, Pieza>();
		FileReader file = new FileReader("data" + File.separator + "piezas_clientes_subasta.csv");
		BufferedReader br = new BufferedReader(file);
		String l = br.readLine(); l = br.readLine();
		String[] linea;
		
		while (l != null) {
			linea = l.split(";");
			if (linea[0].equals("Cliente")) {
				usuariosSubasta.put(linea[1], clientes.get(linea[1]));
			} else if (linea[0].equals("Pieza")) {
				piezaSubasta.put(linea[0], inventario.getPieza(linea[0]));
			}
			l = br.readLine();
		}
		br.close();
		Map[] mapas = new Map[]{usuariosSubasta,piezaSubasta};

		return mapas;
	}
//<x=============================================================================================================x>
}
