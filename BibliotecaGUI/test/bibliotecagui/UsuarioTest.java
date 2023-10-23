/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bibliotecagui;

import java.util.ArrayList;
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
public class UsuarioTest {
    
    public UsuarioTest() {
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
     * Test of getNombre method, of class Usuario.
     */
   @Test
    public void testGetNombre() {
        System.out.println("testGetNombre");
        Usuario instance = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
        String expResult = "NombrePrueba";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNombre() {
        System.out.println("testSetNombre");
        Usuario instance = new Usuario();
        String nombre = "NombrePrueba";
        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    @Test
    public void testGetNumeroDeUsuario() {
        System.out.println("testGetNumeroDeUsuario");
      Usuario instance = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
        String expResult = "12345";
        String result = instance.getNumeroDeUsuario();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNumeroDeUsuario() {
        System.out.println("testSetNumeroDeUsuario");
        Usuario instance = new Usuario();
        String numeroDeUsuario = "12345";
        instance.setNumeroDeUsuario(numeroDeUsuario);
        assertEquals(numeroDeUsuario, instance.getNumeroDeUsuario());
    }

    @Test
    public void testGetCorreo() {
        System.out.println("testGetCorreo");
        Usuario instance = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
        String expResult = "correo@prueba.com";
        String result = instance.getCorreo();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCorreo() {
        System.out.println("testSetCorreo");
        Usuario instance = new Usuario();
        String correo = "correo@prueba.com";
        instance.setCorreo(correo);
        assertEquals(correo, instance.getCorreo());
    }

    @Test
    public void testGetApellido1() {
        System.out.println("testGetApellido1");
        Usuario instance = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
        String expResult = "Apellido1";
        String result = instance.getApellido1();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetApellido1() {
        System.out.println("testSetApellido1");
        Usuario instance = new Usuario();
        String apellido1 = "Apellido1";
        instance.setApellido1(apellido1);
        assertEquals(apellido1, instance.getApellido1());
    }

    @Test
    public void testGetTelefono() {
        System.out.println("testGetTelefono");
        Usuario instance = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
        String expResult = "123-456-7890";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetApellido2() {
        System.out.println("testGetApellido2");
        Usuario instance = new Usuario("12345", "NombrePrueba", "Apellido1", "Apellido2", "123-456-7890", "correo@prueba.com");
        String expResult = "Apellido2";
        String result = instance.getApellido2();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetApellido2() {
        System.out.println("testSetApellido2");
        Usuario instance = new Usuario();
        String apellido2 = "Apellido2";
        instance.setApellido2(apellido2);
        assertEquals(apellido2, instance.getApellido2());
    }

    @Test
    public void testSetTelefono() {
        System.out.println("testSetTelefono");
        Usuario instance = new Usuario();
        String telefono = "123-456-7890";
        instance.setTelefono(telefono);
        assertEquals(telefono, instance.getTelefono());
    }

    /**
     * Test of getLibrosPrestados method, of class Usuario.
     */
   
    @Test
    public void testGetLibrosPrestados() {
        System.out.println("testGetLibrosPrestados");
        Usuario instance = new Usuario();
        List<Libro> expResult = new ArrayList<Libro>(); // Crea una lista válida de libros
        // Asigna la lista de libros a la instancia
        instance.setLibrosPrestados(expResult);
        List<Libro> result = instance.getLibrosPrestados();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetLibrosPrestados() {
        System.out.println("testSetLibrosPrestados");
        Usuario instance = new Usuario();
        List<Libro> librosPrestados = new ArrayList<Libro>(); // Crea una lista válida de libros
        instance.setLibrosPrestados(librosPrestados);
        assertEquals(librosPrestados, instance.getLibrosPrestados());
    }
}
