/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bibliotecagui;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Usuario
 */
public class DevolucionTest {
    
    public DevolucionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrestamo method, of class Devolucion.
     */
@Test
public void testGetPrestamo() {
    System.out.println("testGetPrestamo");
    Devolucion instance = new Devolucion(); // Crea una instancia de Devolucion
    Prestamo expResult = new Prestamo(); // Crea una instancia de Prestamo (o ajusta según tu caso)
    instance.setPrestamo(expResult); // Establece el Prestamo en la instancia de Devolucion
    Prestamo result = instance.getPrestamo(); // Obtiene el Prestamo desde la instancia de Devolucion
    assertEquals(expResult, result); // Compara el Prestamo esperado con el obtenido
}

@Test
public void testGetFechaDevolucion() {
    System.out.println("testGetFechaDevolucion");
    Devolucion instance = new Devolucion(); // Crea una instancia de Devolucion
    Date expResult = new Date(); // Crea una instancia de Date (o ajusta según tu caso)
    instance.setFechaDevolucion(expResult); // Establece la fecha de devolución en la instancia de Devolucion
    Date result = instance.getFechaDevolucion(); // Obtiene la fecha de devolución desde la instancia de Devolucion
    assertEquals(expResult, result); // Compara la fecha de devolución esperada con la obtenida
}

    
}
