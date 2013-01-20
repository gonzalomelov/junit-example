package tvs_testingunitarioTest;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import tvs_testingunitario.BibliotecaError;
import tvs_testingunitario.Factory;
import tvs_testingunitario.IBiblioteca;

public class LibroListaReservaTest {
    public LibroListaReservaTest(){
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {
            iBiblioteca.agregarLibro("Libro1", "Titulo1", "Autor1", "Tema1");
            iBiblioteca.agregarLibro("Libro2", "Titulo2", "Autor2", "Tema2");
            iBiblioteca.agregarLibro("Libro3", "Titulo3", "Autor3", "Tema3");
            iBiblioteca.agregarLibro("Libro4", "Titulo4", "Autor4", "Tema4");
            iBiblioteca.agregarLibro("Libro5", "Titulo5", "Autor5", "Tema5");
            iBiblioteca.agregarLibro("Libro6", "Titulo6", "Autor6", "Tema6");

            iBiblioteca.agregarSocio("Socio1", "Direccion1", "Telefono1");
            iBiblioteca.agregarSocio("Socio2", "Direccion2", "Telefono2");
            iBiblioteca.agregarSocio("Socio3", "Direccion3", "Telefono3");
            iBiblioteca.agregarSocio("Socio4", "Direccion4", "Telefono4");            
            iBiblioteca.agregarSocio("Socio5", "Direccion5", "Telefono5");            
           
            iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio5");
            
            iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio1");    
            iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio2");
            iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio3");
            iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio4");
            
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio5");
            
            iBiblioteca.reservarLibroAUnSocio("Libro2", "Socio3");    
            iBiblioteca.reservarLibroAUnSocio("Libro2", "Socio2");
            iBiblioteca.reservarLibroAUnSocio("Libro2", "Socio1");            
            
        } catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);            
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // TODO por el estudiante
    }

    @Before
    public void setUp() {
        // TODO por el estudiante
    }

    @After
    public void tearDown() {
        // TODO por el estudiante
    }
    
     
      
     @Test(expected=BibliotecaError.class)
    public void noExisteLibroTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("noExisteLibroTestMethod");
        System.out.println("-----------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("Libro100", "Socio1");
    }    
    
     @Test
    public void libroPrestadoConReservasTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("libroPrestadoConReservasTestMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {          
            LinkedList<String> expecteds1 = new LinkedList<String>();
            expecteds1.add("Socio1");
            expecteds1.add("Socio2");
            expecteds1.add("Socio3");
            expecteds1.add("Socio4");          
            LinkedList<String> actuals1 = iBiblioteca.libroListaReserva("Libro1");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());
            
            expecteds1.clear();
            expecteds1.add("Socio3");
            expecteds1.add("Socio2");
            expecteds1.add("Socio1");        
            actuals1 = iBiblioteca.libroListaReserva("Libro2");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray()); 
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }        
    }  
        
    @Test
    public void listaVaciaTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("listaVaciaTestMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {          
            LinkedList<String> expecteds1 = new LinkedList<String>();
            LinkedList<String> actuals1 = iBiblioteca.libroListaReserva("Libro3");            
                        
            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());
            
            actuals1 = iBiblioteca.libroListaReserva("Libro4");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray()); 
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }        
    }  
    
    @Test
     public void listaDespuesDeDevolverMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("listaDespuesDeDevolverMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {      
            iBiblioteca.devolverLibro("Libro1", "Socio5");  
            iBiblioteca.devolverLibro("Libro2", "Socio5");
            LinkedList<String> expecteds1 = new LinkedList<String>();
            expecteds1.add("Socio1");
            expecteds1.add("Socio2");
            expecteds1.add("Socio3");
            expecteds1.add("Socio4");  
            LinkedList<String> actuals1 = iBiblioteca.libroListaReserva("Libro1");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());
            
            expecteds1.clear();
            expecteds1.add("Socio3");
            expecteds1.add("Socio2");
            expecteds1.add("Socio1");    
            actuals1 = iBiblioteca.libroListaReserva("Libro2");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray()); 
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }        
     }   
     @Test   
    public void listaDespuesDePrestarMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("listaDespuesDePrestarMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {      
            iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");  
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio3");
            LinkedList<String> expecteds1 = new LinkedList<String>();

            expecteds1.add("Socio2");
            expecteds1.add("Socio3");
            expecteds1.add("Socio4");          

            LinkedList<String> actuals1 = iBiblioteca.libroListaReserva("Libro1");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());

            
            expecteds1.clear();
            expecteds1.add("Socio2");
            expecteds1.add("Socio1"); 
            actuals1 = iBiblioteca.libroListaReserva("Libro2");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray()); 
        }
        catch(BibliotecaError exc){
            System.out.println("error "+exc);
            Assert.assertTrue(false);
        }     
    }
}