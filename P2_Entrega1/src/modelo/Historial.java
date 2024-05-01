package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Historial {
	//< Atributos >
	private String idHistorial;
    private Pieza pieza;
    private Map<Integer, String> historial; 
    
    
    //< Constructor >
    public Historial(String idHistorial, Pieza pieza, Map<Integer, String> historial) {
    	this.idHistorial = idHistorial;
        this.pieza = pieza;
        this.historial = historial;     
    }
    
    
    
//< Metodos >=====================================================================================================x>
    public void agregarAlMapa(int valorPuja, String idComprador) {
        historial.put(valorPuja, idComprador);
    }
//<x==============================================================================================================x>
    
    

//< Getters >=====================================================================================================x>
    public String getId() {
    	return this.idHistorial;
    }
//<x==============================================================================================================x>
}