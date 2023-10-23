/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bibliotecagui;

import java.util.List;
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
public class BibliotecaTest {
    
    public BibliotecaTest() {
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
     * Test of registrarLibro method, of class Biblioteca.
     */
    @Test
    public void testRegistrarLibro() {
        System.out.println("registrarLibro");
        Libro libro = null;
        Biblioteca instance = new Biblioteca();
        instance.registrarLibro(libro);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of registrarEquipo method, of class Biblioteca.
     */
    @Test
    public void testRegistrarEquipo() {
        System.out.println("registrarEquipo");
        Equipo equipo = null;
        Biblioteca instance = new Biblioteca();
        instance.registrarEquipo(equipo);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of registrarUsuario method, of class Biblioteca.
     */
    @Test
    public void testRegistrarUsuario() {
        System.out.println("registrarUsuario");
        Usuario usuario = null;
        Biblioteca instance = new Biblioteca();
        instance.registrarUsuario(usuario);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of registrarPrestamo method, of class Biblioteca.
     */
    @Test
    public void testRegistrarPrestamo() {
        System.out.println("registrarPrestamo");
        Prestamo prestamo = null;
        Biblioteca instance = new Biblioteca();
        instance.registrarPrestamo(prestamo);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getRegistroLibros method, of class Biblioteca.
     */
    @Test
    public void testGetRegistroLibros() {
        System.out.println("getRegistroLibros");
        Biblioteca instance = new Biblioteca();
        List<Libro> expResult = null;
        List<Libro> result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getRegistroEquipos method, of class Biblioteca.
     */
    @Test
    public void testGetRegistroEquipos() {
        System.out.println("getRegistroEquipos");
        Biblioteca instance = new Biblioteca();
        List<Equipo> expResult = null;
        List<Equipo> result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getRegistroUsuarios method, of class Biblioteca.
     */
    @Test
    public void testGetRegistroUsuarios() {
        System.out.println("getRegistroUsuarios");
        Biblioteca instance = new Biblioteca();
        List<Usuario> expResult = null;
        List<Usuario> result = null;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
