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
        this.setPieza(pieza);
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



	public Pieza getPieza() {
		return pieza;
	}



	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}



	public Map<Integer, String> getHistorial() {
		return historial;
	}



	public void setHistorial(Map<Integer, String> historial) {
		this.historial = historial;
	}
}