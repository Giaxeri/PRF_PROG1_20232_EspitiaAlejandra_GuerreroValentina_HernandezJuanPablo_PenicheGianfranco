package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.ApuestaChance;

/**
 * Clase de prueba para la clase ApuestaChance.
 */
public class ApuestaChanceTest {

    private ApuestaChance apuestaChance;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        apuestaChance = new ApuestaChance();
    }

    /**
     * Prueba para asegurarse de que el método crearApuestaChance funciona correctamente.
     */
    @Test
    public void testCrearApuestaChance() {
        apuestaChance.crearApuestaChance("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 7);

        // Obtener la lista de apuestas y verificar que se haya agregado una nueva
        String apuestas = apuestaChance.leerApuestaChance();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-01, Valor Apuesta: 100.0, "
                + "Nombre Loteria: Loteria1, Numero Apostado: 7\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método modificarApuestaChance funciona correctamente.
     */
    @Test
    public void testModificarApuestaChance() {
        // Crear una apuesta
        apuestaChance.crearApuestaChance("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 7);

        // Modificar la apuesta creada
        apuestaChance.modificarApuestaChance("Sede1", 123456789, "2023-01-01", 7, 200.0, "Loteria2", 10);

        // Obtener la lista de apuestas y verificar que se haya modificado la apuesta
        String apuestas = apuestaChance.leerApuestaChance();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-01, Valor Apuesta: 200.0, "
                + "Nombre Loteria: Loteria2, Numero Apostado: 10\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método eliminarApuestaChance funciona correctamente.
     */
    @Test
    public void testEliminarApuestaChance() {
        // Crear una apuesta
        apuestaChance.crearApuestaChance("Sede1", 123456789, "2023-01-01", 100.0, "Loteria1", 7);

        // Eliminar la apuesta creada
        apuestaChance.eliminarApuestaChance(123456789, 7);

        // Obtener la lista de apuestas y verificar que la apuesta se haya eliminado
        String apuestas = apuestaChance.leerApuestaChance();
        assertEquals("", apuestas);
    }
}
