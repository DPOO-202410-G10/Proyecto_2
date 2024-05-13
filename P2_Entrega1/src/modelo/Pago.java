package modelo;

import usuarios.Cliente;

public class Pago {
	private String idPago;
	private String fecha;
	private int iva;
	private double precioFinal;
	private Pieza pieza;
	private Cliente cliente;
	private final double pagoFinalConIva;








	public Pago(String idPago, String fecha, int iva, double precioFinal, Pieza pieza, Cliente cliente) {
		this.idPago = idPago;
		this.fecha = fecha;
		this.iva = iva;
		this.precioFinal = precioFinal;
		this.pieza = pieza;
		this.cliente = cliente;
		this.pagoFinalConIva= (precioFinal * iva)/100;
	}






	public String getIdPago() {
		return idPago;
	}
	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getIva() {
		return iva;
	}
	public void setIva(int iva) {
		this.iva = iva;
	}
	public double getPrecioFinal() {
		return precioFinal;
	}
	public void setPrecioFinal(float precioFinal) {
		this.precioFinal = precioFinal;
	}
	public Pieza getPieza() {
		return pieza;
	}
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPagoFinalConIva() {
		return pagoFinalConIva;
	}
}
//acabado