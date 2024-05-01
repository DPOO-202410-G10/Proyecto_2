package modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import usuarios.Cliente;

public class Subasta {
	//< Atributos >
    private String idSubasta;
    private String estadoActivo;
    private Historial historialActual;
    private Map<String, Pieza> piezas;
    private Map<String, Cliente> clientes;
    private Map<String, Historial> historiales;

    
    //< Contructor >
    public Subasta(String idSubasta, String estadoActivo, Historial historialActual, Map<String, Pieza> piezas, Map<String, Cliente> clientes, Map<String, Historial> historiales) {
        this.idSubasta = idSubasta;
        this.estadoActivo = estadoActivo;
        this.historialActual = historialActual;
        this.piezas = piezas;
        this.clientes = clientes;
        this.historiales = historiales;
    }
    
    //< Contructor >
    public Subasta(String idSubasta) {
    	this.idSubasta = idSubasta;
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
    
    public Collection<Historial> getHistoriales(){
    	return this.historiales.values();
    }
    
    public Collection<String> getCodigoPiezas(){
    	return this.piezas.keySet();
    }
    
    public Collection<String> getCodigoClientes(){
    	return this.clientes.keySet();
    }
//<x==============================================================================================================x>
}

		


