package modelo;

import java.util.HashMap;
import java.util.Map;

import usuarios.Cliente;

public class Subasta {
	//< Atributos >
    private String idSubasta;
    private String estadoActivo;
    private Map<String, Pieza> piezas;
    private Map<String, Cliente> clientes;
    private Map<String, Historial> historiales;

    
    //< Contructor >
    public Subasta(String idSubasta, String estadoActivo, Map<String, Pieza> piezas, Map<String, Cliente> clientes, Map<String, Historial> historiales) {
        this.setIdSubasta(idSubasta);
        this.estadoActivo = estadoActivo;
        this.piezas = piezas;
        this.clientes = clientes;
        this.historiales = historiales;
    }
    
    //< Contructor >
    public Subasta(String idSubasta) {
    	this.setIdSubasta(idSubasta);
    	this.estadoActivo = "Pendiente";
    	this.historiales = new HashMap<String, Historial>();
    }
    

    
//< Metodos >=====================================================================================================x>
    public void activarSubasta(Map<String, Pieza> piezas, Map<String, Cliente> clientes) {
    	this.estadoActivo = "Activo";
    	this.piezas = piezas;
    	this.clientes = clientes;
    }
    
    public void addPieza(Pieza pieza) {
        this.piezas.put(pieza.getIdPieza(), pieza);
    }

    public void removePieza(String idPieza) {
        this.piezas.remove(idPieza);
    }

    public void addHistorial(Historial historial) {
        this.historiales.put(historial.getId(), historial);
    }

    public void removeHistorial(String idHistorial) {
        this.historiales.remove(idHistorial);
    }
    
    public String getEstado() {
    	return this.estadoActivo;
    }
    
    public boolean estaCliente(String idCliente) {
    	return this.clientes.containsKey(idCliente);
    }
//<x==============================================================================================================x>

	public Map<String, Historial> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(Map<String, Historial> historiales) {
		this.historiales = historiales;
	}

	public Map<String, Pieza> getPiezas() {
		return piezas;
	}

	public void setPiezas(Map<String, Pieza> piezas) {
		this.piezas = piezas;
	}

	public String getIdSubasta() {
		return idSubasta;
	}

	public void setIdSubasta(String idSubasta) {
		this.idSubasta = idSubasta;
	}
}

		


