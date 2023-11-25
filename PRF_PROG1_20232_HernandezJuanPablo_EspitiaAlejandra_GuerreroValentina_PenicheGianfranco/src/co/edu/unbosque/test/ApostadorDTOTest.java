/**
 * Clase de pruebas unitarias para la clase ApostadorDTO.
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

import co.edu.unbosque.model.persistence.ApostadorDTO;

/**
 * Clase de pruebas unitarias para la clase ApostadorDTO.
 */
public class ApostadorDTOTest {

    static ApostadorDTO apostadorDTO;
    static int testNumber = 1;

    /**
     * Método ejecutado antes de todas las pruebas.
     * Imprime un mensaje indicando el inicio de todas las pruebas.
     */
    @BeforeClass
    public static void beforeAll() {
        System.out.println("Iniciando pruebas unitarias de ApostadorDTO");
    }

    /**
     * Método ejecutado antes de cada prueba.
     * Imprime un mensaje indicando el inicio de la prueba actual.
     * Inicializa un objeto ApostadorDTO para su uso en las pruebas.
     */
    @Before
    public void beforeEachTest() {
        System.out.println("Empezando la prueba número " + testNumber);
        apostadorDTO = new ApostadorDTO("Juan", 123456789, "Sede1", "Dirección1", 987654321);
    }

    /**
     * Prueba para el método getNombre de ApostadorDTO.
     * Verifica que se devuelve correctamente el nombre del apostador.
     */
    @Test
    public void testGetNombre() {
        System.out.println("Empezando la prueba de getNombre");
        assertEquals("Juan", apostadorDTO.getNombre());
    }

    /**
     * Prueba para el método getCedula de ApostadorDTO.
     * Verifica que se devuelve correctamente la cédula del apostador.
     */
    @Test
    public void testGetCedula() {
        System.out.println("Empezando la prueba de getCedula");
        assertEquals(123456789, apostadorDTO.getCedula());
    }

    /**
     * Prueba para el método getSede de ApostadorDTO.
     * Verifica que se devuelve correctamente la sede del apostador.
     */
    @Test
    public void testGetSede() {
        System.out.println("Empezando la prueba de getSede");
        assertEquals("Sede1", apostadorDTO.getSede());
    }

    /**
     * Prueba para el método getDireccion de ApostadorDTO.
     * Verifica que se devuelve correctamente la dirección del apostador.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("Empezando la prueba de getDireccion");
        assertEquals("Dirección1", apostadorDTO.getDireccion());
    }

    /**
     * Prueba para el método getNumCelular de ApostadorDTO.
     * Verifica que se devuelve correctamente el número de celular del apostador.
     */
    @Test
    public void testGetNumCelular() {
        System.out.println("Empezando la prueba de getNumCelular");
        assertEquals(987654321, apostadorDTO.getNumCelular());
    }

    /**
     * Prueba para el método toString de ApostadorDTO.
     * Verifica que se genera correctamente una representación en cadena del objeto.
     */
    @Test
    public void testToString() {
        System.out.println("Empezando la prueba de toString");
        String expectedString = "<html>Nombre=Juan   Cedula=123456789 Sede=Sede1, direccion=Dirección1, numCelular=987654321<br><html>";
        assertEquals(expectedString, apostadorDTO.toString());
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
        System.out.println("Finalizando pruebas de ApostadorDTO");
    }
}
