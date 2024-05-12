package modelo;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import usuarios.Cliente;
>>>>>>> refs/heads/DavidC

public class Subasta {
<<<<<<< HEAD
    private static int cantidadSubastas = 0;
    private int idSubasta;
    private List<Pieza> piezas;
    private List<Historial> historiales;
=======
	//< Atributos >
    private String idSubasta;
    private String estadoActivo;
    private Historial historialActual;
    private Map<String, Pieza> piezas;
    private Map<String, Cliente> clientes;
    private Map<String, Historial> historiales;
>>>>>>> refs/heads/DavidC

<<<<<<< HEAD
    public Subasta(List<Pieza> piezasASubastar) {
        this.idSubasta = cantidadSubastas + 1;
        this.piezas = piezasASubastar;
        this.historiales = new ArrayList<>();
=======
    
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
    
>>>>>>> refs/heads/DavidC

        for (Pieza p: piezas) {
            Historial historial = new Historial(p, p.getValorInicial());
            this.historiales.add(historial);
        }

        cantidadSubastas++;
    }

    public List<Pieza> getPiezas() {
        return piezas;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public Integer getId() {
        return this.idSubasta;
    }

    public void addPieza(Pieza pieza) {
        this.piezas.add(pieza);
    }

    public void removePieza(Pieza pieza) {
        this.piezas.remove(pieza);
    }

    public void addHistorial(Historial historial) {
        this.historiales.add(historial);
    }

    public void removeHistorial(Historial historial) {
        this.historiales.remove(historial);
    }
<<<<<<< HEAD


=======
    
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
>>>>>>> refs/heads/DavidC
}
//acabado
