/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bibliotecagui;
import bibliotecagui.Libro;
import bibliotecagui.Usuario;
import bibliotecagui.Prestamo;
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
public class PrestamoTest {
    
    public PrestamoTest() {
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

   @Test
public void testGetLibro() {
    System.out.println("testGetLibro");
    Libro libro = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
    Prestamo instance = new Prestamo(libro, null, null, null);
    Libro expResult = libro;
    Libro result = instance.getLibro();
    assertEquals(expResult, result);
}


   @Test
public void testGetUsuario() {
    System.out.println("testGetUsuario");
    Usuario usuario = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
    Prestamo instance = new Prestamo(null, usuario, null, null);
    Usuario expResult = null;
    Usuario result = instance.getUsuario();
    assertEquals(expResult, result);
}

    @Test
    public void testGetFechaPrestamo() {
        System.out.println("testGetFechaPrestamo");
        Date fechaPrestamo = new Date();
        Prestamo instance = new Prestamo(null, null, fechaPrestamo, null);
        Date expResult = null;
        Date result = instance.getFechaPrestamo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFechaDevolucion() {
        System.out.println("testGetFechaDevolucion");
        Date fechaDevolucion = new Date();
        Prestamo instance = new Prestamo(null, null, null, fechaDevolucion);
        Date expResult = null;
        Date result = instance.getFechaDevolucion();
        assertEquals(expResult, result);
    }

    @Test
    public void testDevolver() {
        System.out.println("testDevolver");
        Libro libro = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        Usuario usuario = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
        Prestamo instance = new Prestamo(libro, usuario, new Date(), null);
        instance.devolver();
        assertFalse(instance.estaPrestado());
    }

    @Test
    public void testEstaPrestado() {
        System.out.println("testEstaPrestado");
        Prestamo instance = new Prestamo(null, null, new Date(), null);
        assertTrue(instance.estaPrestado());
    }
}
