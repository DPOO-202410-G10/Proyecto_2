package pruebas;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import modelo.Pieza;
import modelo.Subasta;
import usuarios.Cliente;
import modelo.Historial;

public class SubastaTest {

    @Test
    public void testConstructorAndGetters() {
        String idSubasta = "1";
        Subasta subasta = new Subasta(idSubasta);

        assertEquals(idSubasta, subasta.getId());
        assertEquals("ABIERTO", subasta.getEstado());
        assertEquals(0, subasta.getPiezas().size());
        assertEquals(0, subasta.getHistoriales().size());
    }

    @Test
    public void testAddAndRemovePieza() {
        Subasta subasta = new Subasta("1");
        Pieza pieza = new Pieza("1", "Obra de arte", "Ciudad", 10.5, 20.7, "2024-12-31", true,
                100.0, Arrays.asList("Autor 1", "Autor 2"), "Propietario", "2020");

        subasta.addPieza(pieza);
        assertEquals(1, subasta.getPiezas().size());

        subasta.removePieza(pieza);
        assertEquals(0, subasta.getPiezas().size());
    }

    @Test
    public void testAddAndRemoveHistorial() {
        Subasta subasta = new Subasta("1");
        Historial historial = new Historial("1", "Cliente 1", 100.0);

        subasta.addHistorial(historial);
        assertEquals(1, subasta.getHistoriales().size());

        subasta.removeHistorial(historial);
        assertEquals(0, subasta.getHistoriales().size());
    }

    @Test
    public void testActivarSubasta() {
        Subasta subasta = new Subasta("1");
        Map<String, Pieza> piezas = new HashMap<>();
        Map<String, Cliente> clientes = new HashMap<>();

        subasta.activarSubasta(piezas, clientes);
        assertEquals("ABIERTO", subasta.getEstado());
        assertEquals(piezas, subasta.getPiezas());
        assertEquals(clientes, subasta.getClientes());
    }

    @Test
    public void testEstaCliente() {
        Subasta subasta = new Subasta("1");
        Cliente cliente1 = new Cliente("1", "Cliente 1", "correo1@example.com", "contraseña1");
        Cliente cliente2 = new Cliente("2", "Cliente 2", "correo2@example.com", "contraseña2");

        subasta.getClientes().put(cliente1.getID(), cliente1);

        assertTrue(subasta.estaCliente(cliente1.getID()));
        assertFalse(subasta.estaCliente(cliente2.getID()));
    }
}

