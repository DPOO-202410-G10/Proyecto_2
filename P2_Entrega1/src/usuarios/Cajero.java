package usuarios;

import modelo.Pago;
import modelo.Pieza;
import modelo.Usuario;
import usuarios.Cliente;

public class Cajero extends Usuario {
	
	//< Constructor >
	public Cajero(String idUsuario, String contrasenia, String nombre) {
		super(idUsuario, contrasenia, nombre);
	}
	
	
	
//< Metodos >=====================================================================================================x>
	public void generarPago(Cliente cliente, Pieza piezas, Pago pagos) {
		String fechaActual = pagos.getFecha();
		String idPago = cliente.getID() + "_" + piezas.getIdPieza() + "_" + fechaActual;
		double precioFinal = pagos.getPrecioFinal();
		int iva = (int) (precioFinal * pagos.getIva());
		Pago pago = new Pago(idPago, cliente, piezas, fechaActual, iva, precioFinal);
		
		System.out.println("Se ha generado un pago por la pieza " + piezas.getTitulo() + " .");
	}
	
	
	@Override
	public String toString() {
		return this.idUsuario + ";" + this.contrasenia + ";" + this.nombre + ";Cajero";
	}
//<x==============================================================================================================x>
}
