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
import tvs_testingunitario.LibroDataType;

public class LibrosPrestadosTest {
    public LibrosPrestadosTest(){
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
    
    /**
    * @author Juan Ibarra
    * Verifica:  No hay libros prestados
    *
    */
    @Test
    public void libroPrestadosVacioTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("libroPrestadosVacioTestMethod");
        System.out.println("----------------------------------");        
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        LinkedList<LibroDataType> expecteds1 = new LinkedList<LibroDataType>();
        LinkedList<LibroDataType> actuals1 = iBiblioteca.librosPrestados();            
        Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());   
    } 
      
      
    /**
    * @author Juan Ibarra
    * Verifica:  Orden de libros prestados
    *
    */
    @Test
    public void librosOrdenadosPrestadosTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("librosOrdenadosPrestadosTestMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {  
            iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");    
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio2");
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio3");
            iBiblioteca.prestarLibroAUnSocio("Libro4", "Socio4");             
            iBiblioteca.prestarLibroAUnSocio("Libro5", "Socio5");
            iBiblioteca.prestarLibroAUnSocio("Libro6", "Socio5");  
            
            LinkedList<LibroDataType> expecteds1 = new LinkedList<LibroDataType>();
            expecteds1.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1" ));
            expecteds1.add(new LibroDataType("Libro2", "Titulo2", "Autor2", "Tema2" ));
            expecteds1.add(new LibroDataType("Libro3", "Titulo3", "Autor3", "Tema3" ));
           expecteds1.add(new LibroDataType("Libro4", "Titulo4", "Autor4", "Tema4" ));
            expecteds1.add(new LibroDataType("Libro5", "Titulo5", "Autor5", "Tema5" ));
            expecteds1.add(new LibroDataType("Libro6", "Titulo6", "Autor6", "Tema6" ));            
            
            LinkedList<LibroDataType> actuals1 = iBiblioteca.librosPrestados();            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());  
            
            iBiblioteca.devolverLibro("Libro1", "Socio1");    
            iBiblioteca.devolverLibro("Libro2", "Socio2");
            iBiblioteca.devolverLibro("Libro3", "Socio3");
            iBiblioteca.devolverLibro("Libro4", "Socio4");             
            iBiblioteca.devolverLibro("Libro5", "Socio5");
            iBiblioteca.devolverLibro("Libro6", "Socio5"); 
                       
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }        
    }  
      
     /**
    * @author Juan Ibarra
    * Verifica:  Orden de libros prestados luego que fueron devueltos
    *
    */
    @Test
    public void librosOrdenadosPrestadosLuegoDevolverTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("librosOrdenadosPrestadosLuegoDevolverTestMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {
            iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");    
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio2");
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio3");
            iBiblioteca.prestarLibroAUnSocio("Libro4", "Socio4");             
            iBiblioteca.prestarLibroAUnSocio("Libro5", "Socio5");
            iBiblioteca.prestarLibroAUnSocio("Libro6", "Socio5"); 
            
            iBiblioteca.devolverLibro("Libro3", "Socio3");    
            iBiblioteca.devolverLibro("Libro5", "Socio5");
            
            LinkedList<LibroDataType> expecteds1 = new LinkedList<LibroDataType>();
            expecteds1.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1" ));
            expecteds1.add(new LibroDataType("Libro2", "Titulo2", "Autor2", "Tema2" ));          
           expecteds1.add(new LibroDataType("Libro4", "Titulo4", "Autor4", "Tema4" ));           
            expecteds1.add(new LibroDataType("Libro6", "Titulo6", "Autor6", "Tema6" ));            
            
            LinkedList<LibroDataType> actuals1 = iBiblioteca.librosPrestados();            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());
            
            iBiblioteca.devolverLibro("Libro1", "Socio1");    
            iBiblioteca.devolverLibro("Libro2", "Socio2");
            iBiblioteca.devolverLibro("Libro4", "Socio4");  
            iBiblioteca.devolverLibro("Libro6", "Socio5"); 
            
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }        
    }


/**
    * @author Juan Ibarra
    * Verifica:  Se prestan nuevamente los libros y se verifica el orden
    *
    */
     @Test
    public void represtarLibrosTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("librosOrdenadosPrestadosLuegoDevolverTestMethod");
        System.out.println("----------------------------------");
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {
                        
             System.out.println("2libros prestados tamaño: "+iBiblioteca.librosPrestados().size());
             
            iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");    
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio2");
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio3");
            iBiblioteca.prestarLibroAUnSocio("Libro4", "Socio4");             
            iBiblioteca.prestarLibroAUnSocio("Libro5", "Socio5");
            iBiblioteca.prestarLibroAUnSocio("Libro6", "Socio5"); 
            
            iBiblioteca.devolverLibro("Libro3", "Socio3");    
            iBiblioteca.devolverLibro("Libro5", "Socio5");
             
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio3");
            iBiblioteca.prestarLibroAUnSocio("Libro5", "Socio5");
            
            LinkedList<LibroDataType> expecteds1 = new LinkedList<LibroDataType>();
            expecteds1.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1" ));
            expecteds1.add(new LibroDataType("Libro2", "Titulo2", "Autor2", "Tema2" ));
            expecteds1.add(new LibroDataType("Libro4", "Titulo4", "Autor4", "Tema4" ));
            expecteds1.add(new LibroDataType("Libro6", "Titulo6", "Autor6", "Tema6" ));
            expecteds1.add(new LibroDataType("Libro3", "Titulo3", "Autor3", "Tema3" ));
            expecteds1.add(new LibroDataType("Libro5", "Titulo5", "Autor5", "Tema5" ));

            LinkedList<LibroDataType> actuals1 = iBiblioteca.librosPrestados();
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());

            iBiblioteca.devolverLibro("Libro1", "Socio1");    
            iBiblioteca.devolverLibro("Libro2", "Socio2");
            iBiblioteca.devolverLibro("Libro3", "Socio3");
            iBiblioteca.devolverLibro("Libro4", "Socio4");             
            iBiblioteca.devolverLibro("Libro5", "Socio5");
            iBiblioteca.devolverLibro("Libro6", "Socio5"); 
            
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }
    }

      
      
      
      
}
