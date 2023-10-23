/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bibliotecagui;

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
public class EquipoTest {
    
    public EquipoTest() {
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
     * Test of getCodigoEquipo method, of class Equipo.
     */
    @Test
    public void testGetCodigoEquipo() {
        System.out.println("getCodigoEquipo");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        String expResult = "E001";
        String result = instance.getCodigoEquipo();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCodigoEquipo() {
        System.out.println("setCodigoEquipo");
        Equipo instance = new Equipo("E002", "NombreEquipo", "Ubicacion", "Descripción");
        String CodigoEquipo = "E001";
        instance.setCodigoEquipo(CodigoEquipo);
        assertEquals(CodigoEquipo, instance.getCodigoEquipo());
    }

    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Equipo instance = new Equipo("E001", "PROYECTOR", "Ubicacion", "Descripción");
        String expResult = "PROYECTOR";
        String result = instance.getNombre();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetUbicacion() {
        System.out.println("getUbicacion");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        String expResult = "Ubicacion";
        String result = instance.getUbicacion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        String expResult = "Descripción";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPrestado() {
        System.out.println("isPrestado");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        boolean expResult = false;
        boolean result = instance.isPrestado();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        String nombre = "NuevoNombre";
        instance.setNombre(nombre);
        assertEquals(nombre, instance.getNombre());
    }

    @Test
    public void testSetUbicacion() {
        System.out.println("setUbicacion");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        String ubicacion = "NuevaUbicacion";
        instance.setUbicacion(ubicacion);
        assertEquals(ubicacion, instance.getUbicacion());
    }

    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        String descripcion = "NuevaDescripción";
        instance.setDescripcion(descripcion);
        assertEquals(descripcion, instance.getDescripcion());
    }

    @Test
    public void testSetPrestado() {
        System.out.println("setPrestado");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        boolean prestado = true;
        instance.setPrestado(prestado);
        assertEquals(prestado, instance.isPrestado());
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Equipo instance = new Equipo("E001", "NombreEquipo", "Ubicacion", "Descripción");
        String expResult = "Equipo{nombre=NombreEquipo, ubicacion=Ubicacion, estado=Descripción, prestado=false}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    
}
