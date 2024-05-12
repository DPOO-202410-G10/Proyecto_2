package usuarios;

import java.util.Map;

import modelo.Historial;
import modelo.Pieza;
import modelo.Usuario;
import usuarios.Cliente;
import modelo.Subasta;

public class Administrador extends Usuario {
	
	//< Constructor >
	public Administrador(String idUsuario, String contrasenia, String nombre) {
		super(idUsuario, contrasenia, nombre);
	}
	

	
//< Metodos >=====================================================================================================x>
	public void crearSubasta(Map<String, Cliente> clientes, Map<String, Pieza> piezas, Subasta subastas) {
		String idSubasta = subastas.getIdSubasta();
		Subasta subasta = new Subasta(idSubasta);
		subasta.activarSubasta(piezas, clientes);
	}
	
	public void registrarPieza(Pieza pieza) {
		System.out.println("Pieza registrada: " + pieza.getTitulo());
	}
	
	public void confirmarVenta(Pieza pieza) {
		System.out.println("Venta confirmada para la pieza: " + pieza.getTitulo());
	}
	
	public void regresarPieza(Pieza pieza) {
		System.out.println("La siguiente pieza fue devuelta: " + pieza.getTitulo());
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
