/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bibliotecagui;

import java.sql.Connection;
import java.sql.SQLException;
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
public class BibliotecaGUITest {
    
    public BibliotecaGUITest() {
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
     * Test of getConection method, of class BibliotecaGUI.
     */
  @Test
public void testGetConnection() {
    System.out.println("testGetConnection");
    
    Connection connection = null;
    
    try {
        connection = BibliotecaGUI.getConection(); // Obtiene la conexión
        assertNotNull(connection); // Asegura que la conexión no sea nula
    } catch (Exception e) {
        fail("Exception thrown while getting the connection: " + e.getMessage());
    } finally {
        if (connection != null) {
            try {
                connection.close(); // Cierra la conexión adecuadamente
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

    /**
     * Test of main method, of class BibliotecaGUI.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        BibliotecaGUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
