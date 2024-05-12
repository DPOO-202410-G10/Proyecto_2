package modelo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import persistencia.Guardador;
import usuarios.Administrador;
import usuarios.Cajero;
import usuarios.Cliente;
import usuarios.Operador;
import usuarios.Propietario;

public class Galeria {
	//Atributos
	private String nombre;
	private Administrador administrador;
	private Inventario inventario;
	private Map<String, Cliente> clientes;
	private Map<String, Pago> pagos;
	private Map<Integer, Subasta> subastas;
	private Map<String, Cajero> cajeros;
	private Map<String, Operador> operadores;
	private Map<String, Propietario> propietarios;



	//Constructor
	public Galeria(String nombre) {
		this.nombre = nombre;
	}



	//< Carga de Datos >=============================================================================================x>
	public void cargarDatos() throws IOException {
//		Cargador cargador = new Cargador();
//		this.administrador = cargador.cargarAdmin(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "administrador.csv");
//		this.clientes = cargador.cargarClientes(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "clientes.csv");
//		cargador.cargarEmpleados(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "empleados.csv",
//							this.cajeros, this.operadores);
//		this.inventario = new Inventario(cargador);
//		this.propietarios = cargador.cargarPropietarios(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "propietarios.csv",
//							this.inventario);
//		this.pagos = cargador.cargarPagos(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "pagos.csv",
//							this.clientes, this.inventario);
	}
//<x=============================================================================================================x>



	//< Getters >====================================================================================================x>
	public Administrador getAdmin(String idAdmin) {
		return this.administrador;
	}

	public Cliente getCliente(String idCliente) {
		return this.clientes.get(idCliente);
	}

	public Inventario getInventario() {
		return this.inventario;
	}

	public Cajero getCajero(String idCajero) {
		return this.cajeros.get(idCajero);
	}

	public Operador getOperador(String idOperador) {
		return this.operadores.get(idOperador);
	}

	public Propietario getPropietario(String idPropietario) {
		return this.propietarios.get(idPropietario);
	}

	public Pago getPago(String idPago) {
		return this.pagos.get(idPago);
	}

	public Pieza getPieza(String id) {
		return this.inventario.getPieza(id);
	}
//<x=============================================================================================================x>



	//< Adders >=====================================================================================================x>
	public void addUsuario(Usuario usuario, String tipo) {
		try {
			switch (tipo) {
				case "Cliente":
					this.clientes.put(usuario.getID(), (Cliente) usuario);
					Guardador.guardarClientes(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "clientes.csv",
							this.clientes.values());
				case "Cajero":
					this.cajeros.put(usuario.getID(), (Cajero)usuario);
					Guardador.guardarEmpleados(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "empleados.csv",
							this.cajeros.values(), this.operadores.values());
				case "Operador":
					this.operadores.put(usuario.getID(), (Operador) usuario);
					Guardador.guardarEmpleados(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "empleados.csv",
							this.cajeros.values(), this.operadores.values());
				case "Propietario":
					this.propietarios.put(usuario.getID(), (Propietario) usuario);
					Guardador.guardarPropietarios(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "propietarios.csv",
							this.propietarios.values());
			}
		} catch(Exception e) {
			e.getMessage();
		}
	}

	public void addPieza(Pieza pieza) {
		this.inventario.addPieza(pieza);
	}

	public void addPago(Pago pago) throws Exception {
		this.pagos.put(pago.getIdPago(), pago);
		Guardador.guardarPagos(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "pagos.csv",
				this.pagos.values());
	}

	public void addSubasta(Subasta subasta) {
		this.subastas.put(subasta.getId(), subasta);
	}
//<x=============================================================================================================x>
}