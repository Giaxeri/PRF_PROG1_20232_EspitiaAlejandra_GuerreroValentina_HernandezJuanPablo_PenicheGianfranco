/**
 * Clase de pruebas unitarias para la clase ApuestaBetplayDAO.
 * Se utilizan assertions de JUnit para verificar el comportamiento esperado de los métodos.
 * Cada prueba se inicia con la anotación @Before para establecer el estado inicial necesario.
 * Se proporciona un resumen de las pruebas al inicio y al final de la ejecución.
 */
package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaBetplayDAO;

/**
 * Clase de pruebas unitarias para la clase ApuestaBetplayDAO.
 */
public class ApuestaBetplayDAOTest {

    static ApuestaBetplayDAO apuestaBetplayDAO;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Imprime un mensaje indicando el inicio de todas las pruebas.
     * Inicializa la instancia de ApuestaBetplayDAO para su uso en las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de ApuestaBetplayDAO");
        apuestaBetplayDAO = new ApuestaBetplayDAO();
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     * Crea una apuesta de Betplay para su uso en las pruebas.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        apuestaBetplayDAO.crearApuestaBetplay("Sede1", 123456789, "2023-01-01", 100.0, "1", "2", "3", "4", "5", "6",
                "7", "8", "9", "10", "11", "12", "13", "14");
    }

    /**
     * Prueba para el método crearApuestaBetplay de ApuestaBetplayDAO.
     * Verifica que se crea correctamente una apuesta de Betplay.
     */
    @Test
    public void testCrearApuestaBetplay() {
        System.out.println("Empezando la prueba de crearApuestaBetplay");
        assertEquals(1, apuestaBetplayDAO.getApuestaBetplay().size());
    }

    /**
     * Prueba para el método modificarApuestaBetplay de ApuestaBetplayDAO.
     * Verifica que se modifica correctamente una apuesta de Betplay existente.
     */
    @Test
    public void testModificarApuestaBetplay() {
        System.out.println("Empezando la prueba de modificarApuestaBetplay");
        apuestaBetplayDAO.modificarApuestaBetplay("Sede1", 123456789, "2023-01-01", "2023-01-02", 150.0, "1", "2", "3",
                "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14");
        assertEquals(1, apuestaBetplayDAO.getApuestaBetplay().size());
        assertEquals("2023-01-02", apuestaBetplayDAO.getApuestaBetplay().get(0).getDiaApuesta());
        assertEquals(150.0, apuestaBetplayDAO.getApuestaBetplay().get(0).getValorApuesta(), 0.001);
    }

    /**
     * Prueba para el método leerApuestas de ApuestaBetplayDAO.
     * Verifica que se lee correctamente la información de todas las apuestas.
     */
    @Test
    public void testLeerApuestas() {
        System.out.println("Empezando la prueba de leerApuestas");
        String result = apuestaBetplayDAO.leerApuestas();
        assertTrue(result.contains("Sede1") && result.contains("123456789") && result.contains("2023-01-01")
                && result.contains("100.0") && result.contains("1") && result.contains("2") && result.contains("3")
                && result.contains("4") && result.contains("5") && result.contains("6") && result.contains("7")
                && result.contains("8") && result.contains("9") && result.contains("10") && result.contains("11")
                && result.contains("12") && result.contains("13") && result.contains("14"));
    }

    /**
     * Prueba para el método eliminarApuestaBetplay de ApuestaBetplayDAO.
     * Verifica que se elimina correctamente una apuesta de Betplay existente.
     */
    @Test
    public void testEliminarApuestaBetplay() {
        System.out.println("Empezando la prueba de eliminarApuestaBetplay");
        apuestaBetplayDAO.eliminarApuestaBetplay(123456789, "2023-01-01");
        assertEquals(0, apuestaBetplayDAO.getApuestaBetplay().size());
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
     * Elimina el archivo de prueba generado durante las pruebas.
     */
    @AfterClass
    
    public static void afterAll() {
        System.out.println("Finalizando pruebas de ApuestaBetplayDAO");
        // Eliminar el archivo de prueba generado durante las pruebas
        File tmp = new File("data/apuestas-betplay.dat");
        tmp.delete();
    }
}