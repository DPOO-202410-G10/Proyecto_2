package pruebas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Pieza;

import java.util.Arrays;
import java.util.List;

public class pruebas {

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

    @Test
    public void testSetters() {
        Pieza pieza = new Pieza("123", "Obra de arte", "Ciudad", 10.5, 20.7, "2024-12-31", true,
                100.0, Arrays.asList("Autor 1", "Autor 2"), "Propietario", "2020");

        // Probamos los setters
        pieza.setIdPieza("456");
        assertEquals("456", pieza.getIdPieza());

        pieza.setTitulo("Nueva obra");
        assertEquals("Nueva obra", pieza.getTitulo());

        pieza.setLugarCreacion("Nuevo lugar");
        assertEquals("Nuevo lugar", pieza.getLugarCreacion());

        pieza.setFechaLimite("2025-12-31");
        assertEquals("2025-12-31", pieza.getFechaLimite());

        pieza.setValorFijo(false);
        assertFalse(pieza.isValorFijo());

        pieza.setValorinicial(200.0);
        assertEquals(200.0, pieza.getValorInicial(), 0.001);

        pieza.setAutores(Arrays.asList("Nuevo Autor"));
        assertEquals(Arrays.asList("Nuevo Autor"), pieza.getAutores());

        pieza.setPropietario("Nuevo Propietario");
        assertEquals("Nuevo Propietario", pieza.getPropietario());

        pieza.setAnioCreacion("2021");
        assertEquals("2021", pieza.getAnioCreacion());
    }


}
