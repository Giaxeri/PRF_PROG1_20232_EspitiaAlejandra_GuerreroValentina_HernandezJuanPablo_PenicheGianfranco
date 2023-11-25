/**
 * Clase de pruebas unitarias para la clase ApostadorDAO.
 * Se utilizan assertions de JUnit para verificar el comportamiento esperado de los métodos.
 * Cada prueba se inicia con la anotación @Before para establecer el estado inicial necesario.
 * Se proporciona un resumen de las pruebas al inicio y al final de la ejecución.
 */
package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApostadorDAO;

/**
 * Clase de pruebas unitarias para la clase ApostadorDAO.
 */
public class ApostadorDAOTest {

    static ApostadorDAO apostadorDAO;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Inicializa la instancia de ApostadorDAO para su uso en las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de ApostadorDAO");
        apostadorDAO = new ApostadorDAO();
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
    }

    /**
     * Prueba para el método create de ApostadorDAO.
     * Verifica que se añade correctamente un apostador a la lista.
     */
    @Test
    public void testCreate() {
        System.out.println("Empezando la prueba de create");
        apostadorDAO.create("Juan", "123456789", "Sede1", "Dirección1", "987654321");
        assertEquals(1, apostadorDAO.getListaApostador().size());
    }

    /**
     * Prueba para el método readAll de ApostadorDAO.
     * Verifica que se devuelve una cadena con la información de todos los apostadores.
     */
    @Test
    public void testReadAll() {
        System.out.println("Empezando la prueba de readAll");
        apostadorDAO.create("Ana", "987654321", "Sede2", "Dirección2", "123456789");
        String result = apostadorDAO.readAll();
        assertTrue(result.contains("Nombre: Juan"));
        assertTrue(result.contains("Nombre: Ana"));
    }

    /**
     * Prueba para el método updateByIndex de ApostadorDAO.
     * Verifica que se actualiza correctamente el nombre de un apostador en la lista.
     */
    @Test
    public void testUpdateByIndex() {
        System.out.println("Empezando la prueba de updateByIndex");
        apostadorDAO.create("Carlos", "111111111", "Sede3", "Dirección3", "222222222");
        assertTrue(apostadorDAO.updateByIndex(0, "NuevoNombre", null, null, null, null));
        assertEquals("NuevoNombre", apostadorDAO.getListaApostador().get(0).getNombre());
    }

    /**
     * Prueba para el método delete de ApostadorDAO.
     * Verifica que se elimina correctamente un apostador de la lista.
     */
    @Test
    public void testDelete() {
        System.out.println("Empezando la prueba de delete");
        apostadorDAO.create("Maria", "333333333", "Sede4", "Dirección4", "444444444");
        assertTrue(apostadorDAO.delete(333333333));
        assertFalse(apostadorDAO.delete(555555555));
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
        System.out.println("Finalizando pruebas de ApostadorDAO");
    }
}

