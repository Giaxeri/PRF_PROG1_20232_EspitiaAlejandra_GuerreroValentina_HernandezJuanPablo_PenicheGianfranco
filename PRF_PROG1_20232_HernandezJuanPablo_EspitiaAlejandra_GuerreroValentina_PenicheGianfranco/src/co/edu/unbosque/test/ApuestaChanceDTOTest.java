/**
 * Clase de pruebas unitarias para la clase ApuestaChanceDTO.
 * Se utilizan assertions de JUnit para verificar el comportamiento esperado de los constructores y el método toString.
 */
package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import co.edu.unbosque.model.persistence.ApuestaChanceDTO;

/**
 * Clase de pruebas unitarias para la clase ApuestaChanceDTO.
 */
public class ApuestaChanceDTOTest {

    /**
     * Prueba para el primer constructor de ApuestaChanceDTO.
     * Verifica que los valores se establecen correctamente al crear una instancia con este constructor.
     */
    @Test
    public void testConstructor1() {
        ApuestaChanceDTO apuesta = new ApuestaChanceDTO("Sede1", 123456789, "2023-01-01", 50.0);
        assertEquals("Sede1", apuesta.getNombreSede());
        assertEquals(123456789, apuesta.getNumCedula());
        assertEquals("2023-01-01", apuesta.getDiaApuesta());
        assertEquals(50.0, apuesta.getValorApuesta(), 0.001);
    }

    /**
     * Prueba para el segundo constructor de ApuestaChanceDTO.
     * Verifica que los valores se establecen correctamente al crear una instancia con este constructor.
     */
    @Test
    public void testConstructor2() {
        ApuestaChanceDTO apuesta = new ApuestaChanceDTO("Sede2", 987654321, "2023-02-02", 75.0, "Loteria1", 10);
        assertEquals("Sede2", apuesta.getNombreSede());
        assertEquals(987654321, apuesta.getNumCedula());
        assertEquals("2023-02-02", apuesta.getDiaApuesta());
        assertEquals(75.0, apuesta.getValorApuesta(), 0.001);
        assertEquals("Loteria1", apuesta.getNombreLoteria());
        assertEquals(10, apuesta.getNumeroApostado());
    }

    /**
     * Prueba para el método toString de ApuestaChanceDTO.
     * Verifica que se genera correctamente una representación en cadena del objeto.
     */
    @Test
    public void testToString() {
        ApuestaChanceDTO apuesta = new ApuestaChanceDTO("Sede3", 111111111, "2023-03-03", 100.0, "Loteria2", 20);
        String expectedString = "Apuesta Superastro:\n" +
                "Nombre sede: Sede3 Cedula: 111111111 Dia apuesta: 2023-03-03 Valor apuesta: 100.0 " +
                "Nombre Loteria: Loteria2 Número apostado: 20\n";
        assertEquals(expectedString, apuesta.toString());
    }
}
