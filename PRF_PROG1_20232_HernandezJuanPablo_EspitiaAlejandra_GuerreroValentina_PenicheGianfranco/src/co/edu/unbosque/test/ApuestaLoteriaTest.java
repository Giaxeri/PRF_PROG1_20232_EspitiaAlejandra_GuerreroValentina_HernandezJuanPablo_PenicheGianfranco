package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.ApuestaLoteria;

/**
 * Clase de prueba para la clase ApuestaLoteria.
 */
public class ApuestaLoteriaTest {

    private ApuestaLoteria apuestaLoteria;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        apuestaLoteria = new ApuestaLoteria();
    }

    /**
     * Prueba para asegurarse de que el método crearApuestaLoteria funciona correctamente.
     */
    @Test
    public void testCrearApuestaLoteria() {
        apuestaLoteria.crearApuestaLoteria("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 7, 123);

        // Obtener la lista de apuestas y verificar que se haya agregado una nueva
        String apuestas = apuestaLoteria.leerApuestaLoteria();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-01, Valor Apuesta: 100.0, "
                + "Nombre Loteria: Loteria1, Numero Apostado: 7, Numero Serie: 123\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método modificarApuestaLoteria funciona correctamente.
     */
    @Test
    public void testModificarApuestaLoteria() {
        // Crear una apuesta
        apuestaLoteria.crearApuestaLoteria("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 7, 123);

        // Modificar la apuesta creada
        apuestaLoteria.modificarApuestaLoteria("Sede1", 123456789, "2023-01-01", 7, 200.0, "Loteria2", 10, 456);

        // Obtener la lista de apuestas y verificar que se haya modificado la apuesta
        String apuestas = apuestaLoteria.leerApuestaLoteria();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-01, Valor Apuesta: 200.0, "
                + "Nombre Loteria: Loteria2, Numero Apostado: 10, Numero Serie: 456\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método eliminarApuestaLoteria funciona correctamente.
     */
    @Test
    public void testEliminarApuestaLoteria() {
        // Crear una apuesta
        apuestaLoteria.crearApuestaLoteria("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 7, 123);

        // Eliminar la apuesta creada
        apuestaLoteria.eliminarApuestaLoteria(123456789, 7);

        // Obtener la lista de apuestas y verificar que la apuesta se haya eliminado
        String apuestas = apuestaLoteria.leerApuestaLoteria();
        assertEquals("", apuestas);
    }
}
