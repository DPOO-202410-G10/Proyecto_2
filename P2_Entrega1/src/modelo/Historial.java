package modelo;

import java.util.HashMap;
import java.util.Map;

public class Historial {
  private static int cantidadHistoriales = 0;
  private final Integer idHistorial;
  private final Pieza pieza;
  private final Map<Double, String> compradorPorPuja;
  private final double valorPuja;



  public Historial(Pieza pieza, double valorPuja) {
    this.pieza = pieza;
    this.compradorPorPuja = new HashMap<>();
    this.valorPuja = valorPuja;
    this.idHistorial = cantidadHistoriales + 1;
    cantidadHistoriales += 1;
  }


  public void agregarAlMapa(double valorPuja, String idComprador) {
    if (valorPuja > this.valorPuja) compradorPorPuja.put(valorPuja, idComprador);
  }

  public String getIdComprador() {
    double maximo = Double.MIN_VALUE;
    String id = null;
    for (Map.Entry<Double, String> puja : compradorPorPuja.entrySet()) {
      if (puja.getKey() > maximo) {
        maximo = puja.getKey();
        id = puja.getValue();
      }
    }

    return id;
  }

  public String getIdHistorial() {
    return this.idHistorial.toString();
  }


  public Pieza getPieza() {
    return pieza;
  }
}
//acabado
