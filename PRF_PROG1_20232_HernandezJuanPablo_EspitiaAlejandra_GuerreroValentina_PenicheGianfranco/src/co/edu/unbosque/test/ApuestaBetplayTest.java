package co.edu.unbosque.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import co.edu.unbosque.model.ApuestaBetplay;

/**
 * Clase de prueba para la clase ApuestaBetplay.
 */
public class ApuestaBetplayTest {

    private ApuestaBetplay apuestaBetplay;

    /**
     * Configuración inicial para las pruebas.
     */
    @Before
    public void setUp() {
        apuestaBetplay = new ApuestaBetplay();
    }

    /**
     * Prueba para asegurarse de que el método crearApuestaBetplay funciona correctamente.
     */
    @Test
    public void testCrearApuestaBetplay() {
        apuestaBetplay.crearApuestaBetplay("Sede1", 123456789, "2023-01-01", 100.0, "Partido1", "Partido2", "Partido3",
                "Partido4", "Partido5", "Partido6", "Partido7", "Partido8", "Partido9", "Partido10", "Partido11",
                "Partido12", "Partido13", "Partido14");

        // Obtener la lista de apuestas y verificar que se haya agregado una nueva
        String apuestas = apuestaBetplay.leerApuestaBetplay();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-01, Valor Apuesta: 100.0, "
                + "Partido1: Partido1, Partido2: Partido2, Partido3: Partido3, Partido4: Partido4, Partido5: Partido5, "
                + "Partido6: Partido6, Partido7: Partido7, Partido8: Partido8, Partido9: Partido9, Partido10: Partido10, "
                + "Partido11: Partido11, Partido12: Partido12, Partido13: Partido13, Partido14: Partido14\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método modificarApuestaBetplay funciona correctamente.
     */
    @Test
    public void testModificarApuestaBetplay() {
        // Crear una apuesta
        apuestaBetplay.crearApuestaBetplay("Sede1", 123456789, "2023-01-01", 100.0, "Partido1", "Partido2", "Partido3",
                "Partido4", "Partido5", "Partido6", "Partido7", "Partido8", "Partido9", "Partido10", "Partido11",
                "Partido12", "Partido13", "Partido14");

        // Modificar la apuesta creada
        apuestaBetplay.modificarApuestaBetplay("Sede1", 123456789, "2023-01-01", "2023-01-02", 200.0, "NuevoPartido1",
                "NuevoPartido2", "NuevoPartido3", "NuevoPartido4", "NuevoPartido5", "NuevoPartido6", "NuevoPartido7",
                "NuevoPartido8", "NuevoPartido9", "NuevoPartido10", "NuevoPartido11", "NuevoPartido12",
                "NuevoPartido13", "NuevoPartido14");

        // Obtener la lista de apuestas y verificar que se haya modificado la apuesta
        String apuestas = apuestaBetplay.leerApuestaBetplay();
        assertEquals("Sede: Sede1, Cedula: 123456789, Dia Apuesta: 2023-01-02, Valor Apuesta: 200.0, "
                + "Partido1: NuevoPartido1, Partido2: NuevoPartido2, Partido3: NuevoPartido3, Partido4: NuevoPartido4, "
                + "Partido5: NuevoPartido5, Partido6: NuevoPartido6, Partido7: NuevoPartido7, Partido8: NuevoPartido8, "
                + "Partido9: NuevoPartido9, Partido10: NuevoPartido10, Partido11: NuevoPartido11, Partido12: NuevoPartido12, "
                + "Partido13: NuevoPartido13, Partido14: NuevoPartido14\n", apuestas);
    }

    /**
     * Prueba para asegurarse de que el método eliminarApuestaBetplay funciona correctamente.
     */
    @Test
    public void testEliminarApuestaBetplay() {
        // Crear una apuesta
        apuestaBetplay.crearApuestaBetplay("Sede1", 123456789, "2023-01-01", 100.0, "Partido1", "Partido2", "Partido3",
                "Partido4", "Partido5", "Partido6", "Partido7", "Partido8", "Partido9", "Partido10", "Partido11",
                "Partido12", "Partido13", "Partido14");

        // Eliminar la apuesta creada
        apuestaBetplay.eliminarApuestaBetplay(123456789, "2023-01-01");

        // Obtener la lista de apuestas y verificar que la apuesta se haya eliminado
        String apuestas = apuestaBetplay.leerApuestaBetplay();
        assertEquals("", apuestas);
    }
}
