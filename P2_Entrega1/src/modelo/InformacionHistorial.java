package modelo;

import java.util.Collection;
import java.util.Map;

public interface InformacionHistorial {
	
	public Collection<Pago> historialPieza(Map<String,Pago> pagos, String idPieza) throws Exception;
	
	public Collection<Pieza> historialArtista(Map<String, Map<String, Pieza>> piezas, String nombreArtista) throws Exception;
}
