/**
 * Clase de pruebas unitarias para la clase ApuestaBalotoDAO.
 * Se utilizan assertions de JUnit para verificar el comportamiento esperado de los métodos.
 * Cada prueba se inicia con la anotación @Before para establecer el estado inicial necesario.
 * Se proporciona un resumen de las pruebas al inicio y al final de la ejecución.
 */
package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaBalotoDAO;

/**
 * Clase de pruebas unitarias para la clase ApuestaBalotoDAO.
 */
public class ApuestaBalotoDAOTest {

    static ApuestaBalotoDAO apuestaBalotoDAO;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Imprime un mensaje indicando el inicio de todas las pruebas.
     * Inicializa la instancia de ApuestaBalotoDAO para su uso en las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de ApuestaBalotoDAO");
        apuestaBalotoDAO = new ApuestaBalotoDAO();
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     * Crea una apuesta de Baloto para su uso en las pruebas.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        apuestaBalotoDAO.crearApuestaBaloto("Sede1", 123456789, "2023-01-01", 100.0, "1 2 3 4 5 6");
    }

    /**
     * Prueba para el método crearApuestaBaloto de ApuestaBalotoDAO.
     * Verifica que se crea correctamente una apuesta de Baloto.
     */
    @Test
    public void testCrearApuestaBaloto() {
        System.out.println("Empezando la prueba de crearApuestaBaloto");
        assertEquals(1, apuestaBalotoDAO.getApuestasBaloto().size());
    }

    /**
     * Prueba para el método modificarApuestaBaloto de ApuestaBalotoDAO.
     * Verifica que se modifica correctamente una apuesta de Baloto existente.
     */
    @Test
    public void testModificarApuestaBaloto() {
        System.out.println("Empezando la prueba de modificarApuestaBaloto");
        apuestaBalotoDAO.modificarApuestaBaloto("Sede1", 123456789, "2023-01-01", 100.0, "1 2 3 4 5 6", "7 8 9 10 11 12");
        assertEquals(1, apuestaBalotoDAO.getApuestasBaloto().size());
    }

    /**
     * Prueba para el método leerApuestas de ApuestaBalotoDAO.
     * Verifica que se lee correctamente la información de todas las apuestas.
     */
    @Test
    public void testLeerApuestas() {
        System.out.println("Empezando la prueba de leerApuestas");
        String result = apuestaBalotoDAO.leerApuestas();
        assertTrue(result.contains("Sede1") && result.contains("123456789") && result.contains("2023-01-01")
                && result.contains("100.0") && result.contains("1 2 3 4 5 6"));
    }

    /**
     * Prueba para el método eliminarApuestaBaloto de ApuestaBalotoDAO.
     * Verifica que se elimina correctamente una apuesta de Baloto existente.
     */
    @Test
    public void testEliminarApuestaBaloto() {
        System.out.println("Empezando la prueba de eliminarApuestaBaloto");
        apuestaBalotoDAO.eliminarApuestaBaloto(123456789, "1 2 3 4 5 6");
        assertEquals(0, apuestaBalotoDAO.getApuestasBaloto().size());
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
        System.out.println("Finalizando pruebas de ApuestaBalotoDAO");
        File tmp = new File("data/apuestas-baloto.dat");
        tmp.delete();
    }
}

