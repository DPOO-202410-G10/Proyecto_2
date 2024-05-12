package modelo;

import java.io.File;
import java.io.IOException;
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
	}



	//< Carga de Datos >=============================================================================================x>
	public void cargarDatos() throws IOException {
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
	public Usuario getUsuario(String idUsuario) {
		if (idUsuario.equals(this.administrador.getID())) {
			return this.administrador;
		} else if (this.clientes.containsKey(idUsuario)) {
			return this.clientes.get(idUsuario);
		} else if (this.cajeros.containsKey(idUsuario)) {
			return this.cajeros.get(idUsuario);
		} else if (this.operadores.containsKey(idUsuario)) {
			return this.operadores.get(idUsuario);
		} else if (this.propietarios.containsKey(idUsuario)) {
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
	public void addUsuario(Usuario usuario, String tipo) {
		try {
			switch (tipo) {
				case "Cliente":
					this.clientes.put(usuario.getID(), (Cliente) usuario);
					Guardador.guardarClientes(File.separator + "Entrega_2" + File.separator + "data" + File.separator + "clientes.csv",
							this.clientes.values());
				case "Cajero":
					this.cajeros.put(usuario.getID(), (Cajero) usuario);
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
			System.out.println(e.getMessage());
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
//<x=============================================================================================================x>
}