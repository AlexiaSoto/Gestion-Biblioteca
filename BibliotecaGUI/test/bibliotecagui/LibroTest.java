/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package bibliotecagui;
import bibliotecagui.Libro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class LibroTest {

    public LibroTest() {
    }

    @Test
    public void testGetCodigoLibro() {
        System.out.println("testGetCodigoLibro");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "123";
        String result = instance.getCodigoLibro();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTitulo() {
        System.out.println("testGetTitulo");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "TítuloPrueba";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAutor() {
        System.out.println("testGetAutor");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "AutorPrueba";
        String result = instance.getAutor();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetPublicacion() {
        System.out.println("testGetPublicacion");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "PublicaciónPrueba";
        String result = instance.getPublicacion();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetIdioma() {
        System.out.println("testGetIdioma");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "IdiomaPrueba";
        String result = instance.getIdioma();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGenero() {
        System.out.println("testGetGenero");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "GéneroPrueba";
        String result = instance.getGenero();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetLink() {
        System.out.println("testGetLink");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "LinkPrueba";
        String result = instance.getLink();
        assertEquals(expResult, result);
    }

    @Test
    public void testIsPrestado() {
        System.out.println("testIsPrestado");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        boolean expResult = false;
        boolean result = instance.isPrestado();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCodigoLibro() {
        System.out.println("testSetCodigoLibro");
        String codigoLibro = "123";
        Libro instance = new Libro();
        instance.setCodigoLibro(codigoLibro);
        assertEquals(codigoLibro, instance.getCodigoLibro());
    }

    @Test
    public void testSetTitulo() {
        System.out.println("testSetTitulo");
        String titulo = "TítuloPrueba";
        Libro instance = new Libro();
        instance.setTitulo(titulo);
        assertEquals(titulo, instance.getTitulo());
    }

    @Test
    public void testSetAutor() {
        System.out.println("testSetAutor");
        String autor = "AutorPrueba";
        Libro instance = new Libro();
        instance.setAutor(autor);
        assertEquals(autor, instance.getAutor());
    }

    @Test
    public void testSetPublicacion() {
        System.out.println("testSetPublicacion");
        String publicacion = "PublicaciónPrueba";
        Libro instance = new Libro();
        instance.setPublicacion(publicacion);
        assertEquals(publicacion, instance.getPublicacion());
    }

    @Test
    public void testSetIdioma() {
        System.out.println("testSetIdioma");
        String idioma = "IdiomaPrueba";
        Libro instance = new Libro();
        instance.setIdioma(idioma);
        assertEquals(idioma, instance.getIdioma());
    }

    @Test
    public void testSetGenero() {
        System.out.println("testSetGenero");
        String genero = "GéneroPrueba";
        Libro instance = new Libro();
        instance.setGenero(genero);
        assertEquals(genero, instance.getGenero());
    }

    @Test
    public void testSetLink() {
        System.out.println("testSetLink");
        String link = "LinkPrueba";
        Libro instance = new Libro();
        instance.setLink(link);
        assertEquals(link, instance.getLink());
    }

    @Test
    public void testSetPrestado() {
        System.out.println("testSetPrestado");
        boolean prestado = false;
        Libro instance = new Libro();
        instance.setPrestado(prestado);
        assertEquals(prestado, instance.isPrestado());
    }

    @Test
    public void testToString() {
        System.out.println("testToString");
        Libro instance = new Libro("123", "TítuloPrueba", "AutorPrueba", "PublicaciónPrueba", "IdiomaPrueba", "GéneroPrueba", "LinkPrueba");
        String expResult = "Libro{CodigoLibro=123, titulo=TítuloPrueba, autor=AutorPrueba, publicacion=PublicaciónPrueba, idioma=IdiomaPrueba, genero=GéneroPrueba, link=LinkPrueba, prestado=false}";
       String result = instance.toString();
        assertEquals(expResult, result);
    }
}
