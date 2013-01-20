package tvs_testingunitarioTest;

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

public class ReservarLibroTest {
    public ReservarLibroTest(){
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
    * Verifica: condiciones vacias o nulas
    *
    */
    @Test(expected=BibliotecaError.class)
    public void codigoVaciaTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("codigoVaciaTestMethod");
        System.out.println("-----------------------");

        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.reservarLibroAUnSocio("","");
    }

    /**
    * @author Juan Ibarra
    * Verifica: condiciones vacias o nulas
    *
    */
   @Test(expected=BibliotecaError.class)
    public void cogdigoNuloTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("cogdigoNuloTestMethod");
        System.out.println("-----------------------");

        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.reservarLibroAUnSocio("", null);
    }

     /**
    * @author Juan Ibarra
    * Verifica:  No existe el libro
    *
    */
        @Test(expected=BibliotecaError.class)
    public void noExisteLibroTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("noExisteLibroTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.reservarLibroAUnSocio("Libro100", "Socio1");
        Assert.assertTrue(false);
    }
          
        /**
    * @author Juan Ibarra
    * Verifica:  No existe el socio
    *
    */
    @Test(expected=BibliotecaError.class)
    public void noExisteSocioTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("noExisteSocioTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio100");
        Assert.assertTrue(false);
    }  
        
        
    /**
    * @author Juan Ibarra
    * Verifica:  Reservar libro no prestado
    *
    */
    @Test(expected=BibliotecaError.class)
    public void reservarNoPrestadoTestMethod()throws BibliotecaError
    {
       System.out.println();
        System.out.println("reservarNoPrestadoTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.reservarLibroAUnSocio("Libro2", "Socio1");
        Assert.assertTrue(false);
    }
    
    /**
    * @author Juan Ibarra
    * Verifica:  Reserva 2 veces un mismo libro po rel mismo socio
    *
    */
    @Test(expected=BibliotecaError.class)
    public void reservar2VecesTestMethod()throws BibliotecaError
    {
       System.out.println();
        System.out.println("reservar2VecesTestMethod");
        System.out.println("-----------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio5");        
        
        iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio1");
        iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio1");        
        Assert.assertTrue(false);
    }

    /**
    * @author Juan Ibarra
    * Verifica:  Reserva un libro a prestamo a el mismo. Esta bien esto!
    *
    */
    @Test
    public void reservaLibroPrestadoASiMismoTestMethod()throws BibliotecaError
    {
         try{
            System.out.println();
            System.out.println("reservaLibroPrestadoASiMismo");
            System.out.println("-----------------------");
            
            IBiblioteca iBiblioteca = Factory.getBiblioteca();
            iBiblioteca.prestarLibroAUnSocio("Libro4", "Socio4");
            iBiblioteca.reservarLibroAUnSocio("Libro4", "Socio4");
            
        } catch(BibliotecaError exc){
            System.out.println(exc);
            Assert.assertTrue(false);
            
        }

    }


    /**
    * @author Juan Ibarra
    * Verifica:  Reserva exitosa
    *
    */
    @Test
    public void reservaExitosaTestMethod()throws BibliotecaError
    {
        try{
            System.out.println();       
            System.out.println("reservaExitosaTestMethod");
            System.out.println("-----------------------");
            IBiblioteca iBiblioteca = Factory.getBiblioteca();
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio5");        
            iBiblioteca.reservarLibroAUnSocio("Libro3", "Socio1");
        } catch(BibliotecaError exc){
            Assert.assertTrue(false);
            System.out.println(exc);
        }
    }    
    
}
