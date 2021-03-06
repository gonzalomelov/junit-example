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

public class LibrosReservadosDeUnSocioTest {
    public LibrosReservadosDeUnSocioTest(){
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
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio5");
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio5");
            iBiblioteca.prestarLibroAUnSocio("Libro4", "Socio5");             
            iBiblioteca.prestarLibroAUnSocio("Libro5", "Socio5");
            iBiblioteca.prestarLibroAUnSocio("Libro6", "Socio5");
            
            
            iBiblioteca.reservarLibroAUnSocio("Libro3", "Socio1"); 
            iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio1"); 
            iBiblioteca.reservarLibroAUnSocio("Libro2", "Socio1"); 
            iBiblioteca.reservarLibroAUnSocio("Libro5", "Socio1"); 
            iBiblioteca.reservarLibroAUnSocio("Libro6", "Socio1"); 
            iBiblioteca.reservarLibroAUnSocio("Libro4", "Socio1");  
            
            
            
            
            
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
    
   /*
     * Devuelve la información de los libros reservados por el lector de código codigoSocio al momento
     * de invocar la operación. La lista de libros debe estar ordenada en forma ascendente por código de libro.
     * En caso de que no exista ningún libro reservado al momento de invocar la operación se devuelve la lista vacía.
     * Pre-condición: el lector de código codigoSocio existe.
     * 
     * @author Gonzalo Melo
     */
       @Test(expected=BibliotecaError.class)
    public void noExisteSocioTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("noExisteSocioTestMethod");
        System.out.println("-----------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.librosReservadosDeUnSocio("Socio100");
        Assert.assertTrue(false);
    }  
    
    
    @Test
    public void libroReservadoVacioTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("libroPrestadoVacioTestMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {          
            LinkedList<String> expecteds1 = new LinkedList<String>();
            LinkedList<LibroDataType> actuals1 = iBiblioteca.librosReservadosDeUnSocio("Socio5");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());            
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }        
    }  
  
       @Test
    public void librosOrdenadosReservadosTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("librosOrdenadosReservadosTestMethod");
        System.out.println("----------------------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {          
            LinkedList<LibroDataType> expecteds1 = new LinkedList<LibroDataType>();
            expecteds1.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1" ));
            expecteds1.add(new LibroDataType("Libro2", "Titulo2", "Autor2", "Tema2" ));
            expecteds1.add(new LibroDataType("Libro3", "Titulo3", "Autor3", "Tema3" ));
           expecteds1.add(new LibroDataType("Libro4", "Titulo4", "Autor4", "Tema4" ));
            expecteds1.add(new LibroDataType("Libro5", "Titulo5", "Autor5", "Tema5" ));
            expecteds1.add(new LibroDataType("Libro6", "Titulo6", "Autor6", "Tema6" ));            
            
            LinkedList<LibroDataType> actuals1 = iBiblioteca.librosReservadosDeUnSocio("Socio1");            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());            
           
        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }        
    }

   @Test
    public void obtenerReservaTestMethod() throws BibliotecaError{
        System.out.println();
        System.out.println("librosOrdenadosReservadosTestMethod");
        System.out.println("----------------------------------");
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {
            LinkedList<LibroDataType> expecteds1 = new LinkedList<LibroDataType>();
            expecteds1.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1" ));
            expecteds1.add(new LibroDataType("Libro2", "Titulo2", "Autor2", "Tema2" ));
            expecteds1.add(new LibroDataType("Libro3", "Titulo3", "Autor3", "Tema3" ));
           expecteds1.add(new LibroDataType("Libro4", "Titulo4", "Autor4", "Tema4" ));
            expecteds1.add(new LibroDataType("Libro5", "Titulo5", "Autor5", "Tema5" ));
            expecteds1.add(new LibroDataType("Libro6", "Titulo6", "Autor6", "Tema6" ));
            LinkedList<LibroDataType> actuals1 = iBiblioteca.librosReservadosDeUnSocio("Socio1");
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());
            iBiblioteca.devolverLibro("Libro4","Socio5");
            iBiblioteca.prestarLibroAUnSocio("Libro4","Socio1");
            expecteds1.clear();
            expecteds1.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1" ));
            expecteds1.add(new LibroDataType("Libro2", "Titulo2", "Autor2", "Tema2" ));
            expecteds1.add(new LibroDataType("Libro3", "Titulo3", "Autor3", "Tema3" ));
           
            expecteds1.add(new LibroDataType("Libro5", "Titulo5", "Autor5", "Tema5" ));
            expecteds1.add(new LibroDataType("Libro6", "Titulo6", "Autor6", "Tema6" ));
            actuals1 = iBiblioteca.librosReservadosDeUnSocio("Socio1");
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());



        }
        catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
        }
    }


}
