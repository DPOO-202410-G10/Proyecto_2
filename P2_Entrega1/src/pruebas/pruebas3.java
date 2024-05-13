import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import modelo.Pago;
import modelo.Pieza;
import usuarios.Cliente;

public class PagoTest {

    @Test
    public void testConstructorAndGetters() {
        String idPago = "1";
        String fecha = "2024-05-14";
        int iva = 16;
        double precioFinal = 100.0;
        Pieza pieza = new Pieza("1", "Obra de arte", "Ciudad", 10.5, 20.7, "2024-12-31", true,
                100.0, Arrays.asList("Autor 1", "Autor 2"), "Propietario", "2020");
        Cliente cliente = new Cliente("1", "Cliente 1", "correo1@example.com", "contraseña1");

        Pago pago = new Pago(idPago, fecha, iva, precioFinal, pieza, cliente);

        assertEquals(idPago, pago.getIdPago());
        assertEquals(fecha, pago.getFecha());
        assertEquals(iva, pago.getIva());
        assertEquals(precioFinal, pago.getPrecioFinal());
        assertEquals(pieza, pago.getPieza());
        assertEquals(cliente, pago.getCliente());
        assertEquals(16.0, pago.getPagoFinalConIva());
    }

    @Test
    public void testSetters() {
        Pago pago = new Pago("1", "2024-05-14", 16, 100.0, new Pieza("1", "Obra de arte", "Ciudad", 10.5, 20.7, "2024-12-31", true,
                100.0, Arrays.asList("Autor 1", "Autor 2"), "Propietario", "2020"), 
                new Cliente("1", "Cliente 1", "correo1@example.com", "contraseña1"));

        String idPago = "2";
        String fecha = "2024-05-15";
        int iva = 18;
        double precioFinal = 120.0;
        Pieza pieza = new Pieza("2", "Otra obra de arte", "Otra ciudad", 15.5, 25.7, "2025-12-31", true,
                150.0, Arrays.asList("Autor 3", "Autor 4"), "Otro propietario", "2021");
        Cliente cliente = new Cliente("2", "Cliente 2", "correo2@example.com", "contraseña2");

        pago.setIdPago(idPago);
        pago.setFecha(fecha);
        pago.setIva(iva);
        pago.setPrecioFinal(precioFinal);
        pago.setPieza(pieza);
        pago.setCliente(cliente);

        assertEquals(idPago, pago.getIdPago());
        assertEquals(fecha, pago.getFecha());
        assertEquals(iva, pago.getIva());
        assertEquals(precioFinal, pago.getPrecioFinal());
        assertEquals(pieza, pago.getPieza());
        assertEquals(cliente, pago.getCliente());
    }
}
