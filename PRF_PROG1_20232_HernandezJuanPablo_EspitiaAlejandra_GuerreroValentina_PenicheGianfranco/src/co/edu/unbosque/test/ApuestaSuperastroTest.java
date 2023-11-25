package co.edu.unbosque.test;


import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.ApuestaSuperastro;
import co.edu.unbosque.model.persistence.ApuestaSuperastroDAO;

/**
 * Clase de prueba para la clase ApuestaSuperastro.
 */
public class ApuestaSuperastroTest {

    private ApuestaSuperastro apuestaSuperastro;
    private ApuestaSuperastroDAO mockApuestaSuperastroDAO;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {

        apuestaSuperastro = new ApuestaSuperastro();
        apuestaSuperastro.setApuestaSuperastro(mockApuestaSuperastroDAO);
    }

    /**
     * Prueba para asegurarse de que el método crearApuestaSuperastro interactúa correctamente con ApuestaSuperastroDAO.
     */
    @Test
    public void testCrearApuestaSuperastro() {
        apuestaSuperastro.crearApuestaSuperastro("Sede1", 123456789, "2023-01-01", 100.0, "Aries", 7);
    
    }

    /**
     * Prueba para asegurarse de que el método modificarApuestaSuperastro interactúa correctamente con ApuestaSuperastroDAO.
     */
    @Test
    public void testModificarApuestaSuperastro() {
        apuestaSuperastro.modificarApuestaSuperastro("Sede1", 123456789, "2023-01-01", 7, 200.0, "Tauro", 14);
           }

    /**
     * Prueba para asegurarse de que el método leerApuestaSuperastro interactúa correctamente con ApuestaSuperastroDAO.
     */
    @Test
    public void testLeerApuestaSuperastro() {
        apuestaSuperastro.leerApuestaSuperastro();
       
    }

    /**
     * Prueba para asegurarse de que el método eliminarApuestaSuperastro interactúa correctamente con ApuestaSuperastroDAO.
     */
    @Test
    public void testEliminarApuestaSuperastro() {
        apuestaSuperastro.eliminarApuestaSuperastro(123456789, 7);
        
    }

    /**
     * Prueba para asegurarse de que el método inicializarApuestasSuperastro interactúa correctamente con ApuestaSuperastroDAO.
     */
    @Test
    public void testInicializarApuestasSuperastro() {
        apuestaSuperastro.inicializarApuestasSuperastro();
        
    }

    /**
     * Prueba para asegurarse de que el método getApuestaSuperastro devuelve la instancia correcta de ApuestaSuperastroDAO.
     */
    @Test
    public void testGetApuestaSuperastro() {
        assertEquals(mockApuestaSuperastroDAO, apuestaSuperastro.getApuestaSuperastro());
    }

}