package usuarios;

import java.util.Map;

import modelo.Pieza;
import modelo.Usuario;
import usuarios.Cliente;

public class Administrador extends Usuario {
	
	//< Constructor >
	public Administrador(String idUsuario, String contrasenia, String nombre) {
		super(idUsuario, contrasenia, nombre);
	}
	

	
//< Metodos >=====================================================================================================x>
	public void crearSubasta(Map<String, Cliente> clientes, Map<String, Pieza> piezas) {
		//TODO: FALTA CREAR MÉTODO
	}
	
	public void registrarPieza() {
		//TODO: FALTA CREAR METODO
	}
	
	public void confirmarVenta() {
		//TODO: FALTA CREAR METODO
	}
	
	public void regresarPieza() {
		//TODO: FALTA CREAR METODO
	}
	
	public int aumentarNumComprasCliente(Cliente cliente) {
		int cantidadCompras = cliente.getNumCompras();
		if (cliente.verificacion == true) {
			cantidadCompras++;
		}else {
			System.out.println("Aumento de compras rechazado.");
		}return cantidadCompras;
	}
//<x==============================================================================================================x>
}
