/**
 * Clase de pruebas unitarias para la clase Apuesta.
 * Se utilizan assertions de JUnit para verificar el comportamiento esperado de los métodos.
 * Cada prueba se inicia con la anotación @Before para establecer el estado inicial necesario.
 * Se proporciona un resumen de las pruebas al inicio y al final de la ejecución.
 */
package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.Apuesta;

/**
 * Clase de pruebas unitarias para la clase Apuesta.
 */
public class ApuestaTest {

    static Apuesta apuesta;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Imprime un mensaje indicando el inicio de todas las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de Apuesta");
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     * Crea una instancia de Apuesta para su uso en las pruebas.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        apuesta = new MockApuesta("Sede1", 123456789, "2023-01-01", 100.0);
    }

    /**
     * Prueba para el método getNombreSede de Apuesta.
     * Verifica que se devuelve correctamente el nombre de la sede.
     */
    @Test
    public void testGetNombreSede() {
        System.out.println("Empezando la prueba de getNombreSede");
        assertEquals("Sede1", apuesta.getNombreSede());
    }

    /**
     * Prueba para el método getNumCedula de Apuesta.
     * Verifica que se devuelve correctamente el número de cédula.
     */
    @Test
    public void testGetNumCedula() {
        System.out.println("Empezando la prueba de getNumCedula");
        assertEquals(123456789, apuesta.getNumCedula());
    }

    /**
     * Prueba para el método getDiaApuesta de Apuesta.
     * Verifica que se devuelve correctamente el día de la apuesta.
     */
    @Test
    public void testGetDiaApuesta() {
        System.out.println("Empezando la prueba de getDiaApuesta");
        assertEquals("2023-01-01", apuesta.getDiaApuesta());
    }

    /**
     * Prueba para el método getValorApuesta de Apuesta.
     * Verifica que se devuelve correctamente el valor de la apuesta.
     */
    @Test
    public void testGetValorApuesta() {
        System.out.println("Empezando la prueba de getValorApuesta");
        assertEquals(100.0, apuesta.getValorApuesta(), 0.001);
    }

    /**
     * Método ejecutado después de cada prueba.
     * Imprime un mensaje indicando el final de la prueba actual.
     * Incrementa el número de prueba para la siguiente ejecución.
     */
    @After
    public void afterEachTest() {
        System.out.println("Finalizando la prueba " + testNumber);
        testNumber++;
        System.out.println();
    }

    /**
     * Método ejecutado después de todas las pruebas.
     * Imprime un mensaje indicando el final de todas las pruebas.
     */
    @AfterClass
    public static void afterAll() {
        System.out.println("Finalizando pruebas de Apuesta");
    }

    // MockApuesta para propósitos de prueba
    private static class MockApuesta extends Apuesta {
        public MockApuesta(String nombreSede, long numCedula, String diaApuesta, double valorApuesta) {
            super(nombreSede, numCedula, diaApuesta, valorApuesta);
        }
    }
}

