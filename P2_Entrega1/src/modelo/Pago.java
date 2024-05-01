package modelo;

import usuarios.Cliente;

public class Pago {
	//< Atributos >
	private String idPago;
	private String fecha;
	private int iva;
	private double precioFinal;
	private Pieza pieza;
	private Cliente cliente;
	
	
	//< Constructor >
	public Pago(String idPago, Cliente cliente, Pieza pieza, String fecha, int iva, double precioFinal) {
		this.idPago = idPago;
		this.fecha = fecha;
		this.iva = iva;
		this.precioFinal = precioFinal;
		this.pieza = pieza;
		this.cliente = cliente;
	}
	
	
	
//< Getters >=====================================================================================================x>
	public String getID() {
		return idPago;
	}
	public String getFecha() {
		return fecha;
	}
	public int getIva() {
		return iva;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public Cliente getCliente() {
		return cliente;
	}
//<x==============================================================================================================x>
	
	
	
//< Setters >=====================================================================================================x>
	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
//<x==============================================================================================================x>
}