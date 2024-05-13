import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class PiezaTest {

    @Test
    public void testConstructorAndGetters() {
        String idPieza = "123";
        String titulo = "Obra de arte";
        String lugarCreacion = "Ciudad";
        double ancho = 10.5;
        double alto = 20.7;
        String fechaLimite = "2024-12-31";
        boolean valorFijo = true;
        double valorInicial = 100.0;
        List<String> autores = Arrays.asList("Autor 1", "Autor 2");
        String propietario = "Propietario";
        String anioCreacion = "2020";

        Pieza pieza = new Pieza(idPieza, titulo, lugarCreacion, ancho, alto, fechaLimite, valorFijo,
                valorInicial, autores, propietario, anioCreacion);

        assertEquals(idPieza, pieza.getIdPieza());
        assertEquals(titulo, pieza.getTitulo());
        assertEquals(lugarCreacion, pieza.getLugarCreacion());
        assertEquals(ancho, pieza.getAncho(), 0.001);
        assertEquals(alto, pieza.getAlto(), 0.001);
        assertEquals(fechaLimite, pieza.getFechaLimite());
        assertEquals(valorFijo, pieza.isValorFijo());
        assertEquals(valorInicial, pieza.getValorInicial(), 0.001);
        assertEquals(autores, pieza.getAutores());
        assertEquals(propietario, pieza.getPropietario());
        assertEquals(anioCreacion, pieza.getAnioCreacion());
    }

    
}
