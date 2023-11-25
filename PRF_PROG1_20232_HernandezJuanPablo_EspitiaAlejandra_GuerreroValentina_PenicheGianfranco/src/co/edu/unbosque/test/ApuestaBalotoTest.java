package co.edu.unbosque.test;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.ApuestaBaloto;

/**
 * Clase de prueba para la clase ApuestaBaloto.
 */
public class ApuestaBalotoTest {

    private ApuestaBaloto apuestaBaloto;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        apuestaBaloto = new ApuestaBaloto();
    }

    /**
     * Prueba para asegurarse de que el método crearApuestaBaloto funciona correctamente.
     */
    @Test
    public void testCrearApuestaBaloto() {
        apuestaBaloto.crearApuestaBaloto("Sede1", 123456789, "2023-01-01", 100.0, "1-2-3-4-5");

        // Obtener la lista de apuestas y verificar que se haya agregado una nueva
        String apuestas = apuestaBaloto.leerApuestaBaloto();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-01, Valor Apuesta: 100.0, "
                + "Numeros Apostados: 1-2-3-4-5\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método modificarApuestaBaloto funciona correctamente.
     */
    @Test
    public void testModificarApuestaBaloto() {
        // Crear una apuesta
        apuestaBaloto.crearApuestaBaloto("Sede1", 123456789, "2023-01-01", 100.0, "1-2-3-4-5");

        // Modificar la apuesta creada
        apuestaBaloto.modificarApuestaBaloto("Sede1", 123456789, "2023-01-01", 200.0, "1-2-3-4-5", "6-7-8-9-10");

        // Obtener la lista de apuestas y verificar que se haya modificado la apuesta
        String apuestas = apuestaBaloto.leerApuestaBaloto();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-01, Valor Apuesta: 200.0, "
                + "Numeros Apostados: 6-7-8-9-10\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método eliminarApuestaBaloto funciona correctamente.
     */
    @Test
    public void testEliminarApuestaBaloto() {
        // Crear una apuesta
        apuestaBaloto.crearApuestaBaloto("Sede1", 123456789, "2023-01-01", 100.0, "1-2-3-4-5");

        // Eliminar la apuesta creada
        apuestaBaloto.eliminarApuestaBaloto(123456789, "1-2-3-4-5");

        // Obtener la lista de apuestas y verificar que la apuesta se haya eliminado
        String apuestas = apuestaBaloto.leerApuestaBaloto();
        assertEquals("", apuestas);
    }
}
