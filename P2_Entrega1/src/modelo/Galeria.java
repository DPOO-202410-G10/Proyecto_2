package modelo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import persistencia.Cargador;
import persistencia.Guardador;
import usuarios.Administrador;
import usuarios.Cajero;
import usuarios.Cliente;
import usuarios.Operador;
import usuarios.Propietario;

public class Galeria {
	//< Atributos >
	private String nombre;
	private Subasta subasta;
	private Administrador administrador;
	private Inventario inventario;
	private Map<String, Cliente> clientes;
	private Map<String, Pago> pagos;
	private Map<String, Cajero> cajeros;
	private Map<String, Operador> operadores;
	private Map<String, Propietario> propietarios;
	
	
	
	//< Constructor >
	public Galeria(String nombre) {
		this.nombre = nombre;
		this.cajeros = new HashMap<String, Cajero>();
		this.operadores = new HashMap<String, Operador>();
	}
	
	
	
//< Carga de Datos >=============================================================================================x>
	public void cargarDatos() throws Exception {
		Cargador cargador = new Cargador();
		this.administrador = cargador.cargarAdmin("data" + File.separator + "administrador.csv");
		this.clientes = cargador.cargarClientes("data" + File.separator + "clientes.csv");
		cargador.cargarEmpleados("data" + File.separator + "empleados.csv", this.cajeros, this.operadores);
		this.inventario = new Inventario(cargador);
		this.propietarios = cargador.cargarPropietarios("data" + File.separator + "propietarios.csv", this.inventario);
		this.pagos = cargador.cargarPagos("data" + File.separator + "pagos.csv", this.clientes, this.inventario);
		this.subasta = cargador.cargarSubasta("data" + File.separator + "subasta.csv", this.clientes, this.inventario);
	}
//<x=============================================================================================================x>
	
	
	
//< Getters >====================================================================================================x>
	public Usuario getUsuario(String idUsuario, String tipoUsuario) {
		if (idUsuario.equals(this.administrador.getID()) && tipoUsuario.equals("Administrador")) {
			return this.administrador;
		} else if (this.clientes.containsKey(idUsuario) && tipoUsuario.equals("Cliente")) {
			return this.clientes.get(idUsuario);
		} else if (this.cajeros.containsKey(idUsuario) && tipoUsuario.equals("Cajero")) {
			return this.cajeros.get(idUsuario);
		} else if (this.operadores.containsKey(idUsuario) && tipoUsuario.equals("Operador")) {
			return this.operadores.get(idUsuario);
		} else if (this.propietarios.containsKey(idUsuario) && tipoUsuario.equals("Propietario")) {
			return this.propietarios.get(idUsuario);
		} else {
			return null;
		}
	}
	
	public Inventario getInventario() {
		return this.inventario;
	}
	
	public Pago getPago(String idPago) {
		return this.pagos.get(idPago);
	}
	
	public String getNombre() {
		return this.nombre;
	}
//<x=============================================================================================================x>
	
	
	
//< Adders >=====================================================================================================x>
	public void addUsuario(Usuario usuario, String tipo, boolean isModificated) {
		try {
			switch (tipo) {
			case "Cliente":
				this.clientes.put(usuario.getID(), (Cliente) usuario);
				if (isModificated) {Guardador.guardarClientes(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "clientes.csv", 
					this.clientes.values());}
			case "Cajero":
				this.cajeros.put(usuario.getID(), (Cajero) usuario);
				if (isModificated) {Guardador.guardarEmpleados(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "empleados.csv",
					this.cajeros.values(), this.operadores.values());}
			case "Operador":
				this.operadores.put(usuario.getID(), (Operador) usuario);
				if (isModificated) {Guardador.guardarEmpleados(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "empleados.csv",
					this.cajeros.values(), this.operadores.values());}
			case "Propietario":
				this.propietarios.put(usuario.getID(), (Propietario) usuario);
				if (isModificated) {Guardador.guardarPropietarios(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "propietarios.csv",
					this.propietarios.values());}
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void addPieza(Pieza pieza) throws Exception {
		this.inventario.addPieza(pieza);
	}
	
	
	public void addPago(Pago pago) throws Exception {
		this.pagos.put(pago.getID(), pago);
		Guardador.guardarPagos(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "pagos.csv",
				this.pagos.values());
	}
//<x=============================================================================================================x>
}
