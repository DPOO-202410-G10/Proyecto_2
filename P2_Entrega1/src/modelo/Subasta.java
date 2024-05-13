package modelo;

import usuarios.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subasta {
    private static int cantidadSubastas = 0;
    private String idSubasta;
    private Map<String,Pieza> piezas;
    private Map<String, Historial> historiales;
    private Map<String, Cliente> clientes;
    private Historial historial;
    private String estado;


    public Subasta(String idSubasta) {
        this.idSubasta = idSubasta;
        this.piezas = new HashMap<>();
        this.historiales = new HashMap<>();
        this.estado = "ABIERTO";
        this.historial= null;

        cantidadSubastas++;
    }

    public Subasta(String idSubasta, String estado, Historial historialActual, Map<String, Cliente> usuariosSubasta, Map<String,Pieza> piezasSubasta, Map<String, Historial> historiales) {
        this.idSubasta=idSubasta;
        this.estado=estado;
        this.historiales=historiales;
        this.clientes=usuariosSubasta;
        this.piezas=piezasSubasta;
        this.historial=historialActual;


    }


    public Map<String, Pieza> getPiezas() {
        return piezas;
    }

    public Map<String, Historial> getHistoriales() {
        return historiales;
    }

    public String getId() {
        return this.idSubasta;
    }

    public void addPieza(Pieza pieza) {
        this.piezas.put(pieza.getIdPieza(),pieza);
    }

    public void removePieza(Pieza pieza) {
        this.piezas.remove(pieza.getIdPieza());
    }

    public void addHistorial(Historial historial) {
        this.historiales.put(historial.getIdHistorial(),historial);
        this.historial=historial;
    }

    public void removeHistorial(Historial historial) {
        this.historiales.remove(historial.getIdHistorial());
    }
    
    public void activarSubasta(Map<String, Pieza> piezas, Map<String, Cliente> clientes) {
    	this.estado = "ABIERTO";
    	this.piezas = piezas;
    	this.clientes = clientes;
    }


}



