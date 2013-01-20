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

public class DevolverLibroTest {
    public DevolverLibroTest(){
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
           
            iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");    
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio1");
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio1");
            iBiblioteca.prestarLibroAUnSocio("Libro4", "Socio2");
            iBiblioteca.prestarLibroAUnSocio("Libro5", "Socio3");
            
            iBiblioteca.reservarLibroAUnSocio("Libro4", "Socio1");
            
            
        } catch(BibliotecaError exc){
            Assert.assertTrue(false);
            System.out.println(exc);
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
    * Verifica: Codigos vacios
    *
    */
    @Test(expected=BibliotecaError.class)
    public void codigoVaciaTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("condiciones vacias o nulas");
        System.out.println("-----------------------");

        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("","");
    }

    /**
    * @author Juan Ibarra
    * Verifica: Codigo nulo
    *
    */
   @Test(expected=BibliotecaError.class)
    public void codigoNuloTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("condiciones vacias o nulas");
        System.out.println("-----------------------");

        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("", null);
    }

   /**
    * @author Juan Ibarra
    * Verifica: No existe libro
    *
    */
    @Test(expected=BibliotecaError.class)
    public void noExisteLibroTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("noExisteLibroTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("Libro100", "Socio1");
    }
    
    /**
    * @author Juan Ibarra
    * Verifica: No existe socio
    *
    */
    @Test(expected=BibliotecaError.class)
    public void noExisteSocioTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("noExisteSocioTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio100");
    }        
    
    /**
    * @author Juan Ibarra
    * Verifica: No tiene el libro prestado
    *
    */
    @Test(expected=BibliotecaError.class)
    public void noTieneLibroPrestadoTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("noTieneLibroPrestadoTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();  
        iBiblioteca.devolverLibro("Libro1", "Socio2");   
        Assert.assertTrue(false); //si el anterior no lanzo error el test esta mal
    }
    
    /**
    * @author Juan Ibarra
    * Verifica: intentar devolver un libro ya devuelto
    *
    */
    @Test(expected=BibliotecaError.class)
    public void libroYaDevueltoTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("libroYaDevueltoTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();  
        iBiblioteca.devolverLibro("Libro1", "Socio1");   
        iBiblioteca.devolverLibro("Libro1", "Socio1");
        Assert.assertTrue(false);        
    }
    
    /**
    * @author Juan Ibarra
    * Verifica: libro prestado a otro usuario
    *
    */
     @Test(expected=BibliotecaError.class)
    public void libroPrestadoAOtroSocioTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("libroPrestadoAOtroSocioTestMethod");
        System.out.println("-----------------------");        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();  
        iBiblioteca.devolverLibro("Libro4", "Socio1");   
        Assert.assertTrue(false);        
    }


     /**
    * @author Juan Ibarra
    * Verifica: libro devuelto con exito
    *
    */
    @Test
    public void libroDevueltoExitosamenteTestMethod() {
       try{
        System.out.println();
        System.out.println("libroDevueltoExitosamenteTestMethod");
        System.out.println("-----------------------");

        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.devolverLibro("Libro2", "Socio1");

        } catch(BibliotecaError exc){
            System.out.println("error :" + exc.getMessage());
            Assert.assertTrue(false);
        }
    }
    



}
