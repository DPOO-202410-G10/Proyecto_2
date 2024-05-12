package modelo;

import java.util.ArrayList;
import java.util.List;

public class Subasta {
    private static int cantidadSubastas = 0;
    private int idSubasta;
    private List<Pieza> piezas;
    private List<Historial> historiales;

    public Subasta(List<Pieza> piezasASubastar) {
        this.idSubasta = cantidadSubastas + 1;
        this.piezas = piezasASubastar;
        this.historiales = new ArrayList<>();

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


}




