package tvs_testingunitarioTest;

import java.util.Iterator;
import java.util.LinkedList;
import org.junit.*;
import tvs_testingunitario.BibliotecaError;
import tvs_testingunitario.Factory;
import tvs_testingunitario.IBiblioteca;
import tvs_testingunitario.LibroDataType;

public class PrestarLibroTest {
    
    public PrestarLibroTest(){
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
            iBiblioteca.agregarLibro("Libro7", "Titulo7", "Autor7", "Tema7");
             iBiblioteca.agregarLibro("Libro8", "Titulo8", "Autor8", "Tema8");

            iBiblioteca.agregarSocio("Socio1", "Direccion1", "Telefono1");
            iBiblioteca.agregarSocio("Socio2", "Direccion2", "Telefono2");
            iBiblioteca.agregarSocio("Socio3", "Direccion3", "Telefono3");
            iBiblioteca.agregarSocio("Socio4", "Direccion4", "Telefono4");
            iBiblioteca.agregarSocio("Socio5", "Direccion5", "Telefono5");

            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio1").size(), 0);
            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio2").size(), 0);
            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio3").size(), 0);
            
            iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");
            
            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio1").size(), 1);
            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio2").size(), 0);
            
            LinkedList<LibroDataType> expecteds1 = new LinkedList<LibroDataType>();
            expecteds1.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1"));
            
//            System.out.println("expecteds1");
//            Utils.printLibroDataTypeList(expecteds1);
//            System.out.println("actuals1");
//            Utils.printLibroDataTypeList(iBiblioteca.librosPrestadosAUnSocio("Socio1"));
            
            Assert.assertArrayEquals(expecteds1.toArray(), iBiblioteca.librosPrestadosAUnSocio("Socio1").toArray());
            
            iBiblioteca.prestarLibroAUnSocio("Libro2", "Socio1");
            iBiblioteca.prestarLibroAUnSocio("Libro3", "Socio1");
            iBiblioteca.prestarLibroAUnSocio("Libro4", "Socio2");
            iBiblioteca.prestarLibroAUnSocio("Libro5", "Socio3");
            
            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio1").size(), 3);
            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio2").size(), 1);
            Assert.assertEquals(iBiblioteca.librosPrestadosAUnSocio("Socio3").size(), 1);
            
            LinkedList<LibroDataType> expecteds2 = new LinkedList<LibroDataType>();
            expecteds2.add(new LibroDataType("Libro1", "Titulo1", "Autor1", "Tema1"));
            expecteds2.add(new LibroDataType("Libro2", "Titulo2", "Autor2", "Tema2"));
            expecteds2.add(new LibroDataType("Libro3", "Titulo3", "Autor3", "Tema3"));
            
            Assert.assertArrayEquals(expecteds2.toArray(), iBiblioteca.librosPrestadosAUnSocio("Socio1").toArray());
            
            LinkedList<LibroDataType> expecteds3 = new LinkedList<LibroDataType>();
            expecteds3.add(new LibroDataType("Libro4", "Titulo4", "Autor4", "Tema4"));
            
            Assert.assertArrayEquals(expecteds3.toArray(), iBiblioteca.librosPrestadosAUnSocio("Socio2").toArray());
            
            LinkedList<LibroDataType> expecteds5 = new LinkedList<LibroDataType>();
            expecteds5.add(new LibroDataType("Libro5", "Titulo5", "Autor5", "Tema5"));
            
            Assert.assertArrayEquals(expecteds5.toArray(), iBiblioteca.librosPrestadosAUnSocio("Socio3").toArray());
            
//            System.out.println("expecteds2");
//            Utils.printLibroDataTypeList(expecteds2);
//            System.out.println("actuals2");
//            Utils.printLibroDataTypeList(iBiblioteca.librosPrestadosAUnSocio("Socio1"));
            
//            System.out.println("expecteds3");
//            Utils.printLibroDataTypeList(expecteds3);
//            System.out.println("actuals3");
//            Utils.printLibroDataTypeList(iBiblioteca.librosPrestadosAUnSocio("Socio2"));
            
//            System.out.println("expecteds5");
//            Utils.printLibroDataTypeList(expecteds5);
//            System.out.println("actuals5");
//            Utils.printLibroDataTypeList(iBiblioteca.librosPrestadosAUnSocio("Socio3"));
            
        } catch(BibliotecaError exc){
            Assert.assertTrue(false);
        }
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        // TODO por el estudiante
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }
    
    /**
    * @author Gonzalo Melo
    * Verifica: No existe el libro
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
    * @author Gonzalo Melo
    * Verifica: No existe el socio
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
    * @author Gonzalo Melo
    * Verifica: Codigo libro invalido
    *
    */
    @Test(expected=BibliotecaError.class)
    public void codigoLibroInvalidoTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("codigoLibroInvalidoTestMethod");
        System.out.println("-----------------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio(null, "Socio1");
    }
    
    /**
    * @author Gonzalo Melo
    * Verifica: Codigo socio invalido
    *
    */
    @Test(expected=BibliotecaError.class)
    public void codigoSocioInvalidoTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("codigoSocioInvalidoTestMethod");
        System.out.println("-----------------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("Libro1", null);
    }
    
    /**
    * @author Gonzalo Melo
    * Verifica: Ya se presto el libro y se encuentra sin reservas
    *
    */
    @Test(expected=BibliotecaError.class)
    public void libroPrestadoSinReservasTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("libroPrestadoSinReservasTestMethod");
        System.out.println("----------------------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");
    }
    

    
    /**
    * @author Gonzalo Melo
    * Verifica: Ya se presto el libro y se encuentra con reservas
    *
    */
    @Test(expected=BibliotecaError.class)
    public void libroPrestadoConReservasTestMethod() throws BibliotecaError
    {
        System.out.println();
        System.out.println("libroPrestadoConReservasTestMethod");
        System.out.println("----------------------------------");
        
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {
            iBiblioteca.reservarLibroAUnSocio("Libro1", "Socio2");
            
            LinkedList<String> expecteds1 = new LinkedList<String>();
            expecteds1.add("Socio2");
            LinkedList<String> actuals1 = iBiblioteca.libroListaReserva("Libro1");
            
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());
        }
        catch(BibliotecaError exc){
            Assert.assertTrue(false);
        }
        
        iBiblioteca.prestarLibroAUnSocio("Libro1", "Socio1");
    }
    
    /**
    * @author Gonzalo Melo
    * Verifica: Se presta un libro sin reservas y que no esta prestado
    *
    */
    @Test
    public void prestamoExitosoLibroSinReservasTestMethod()
    {
        System.out.println();
        System.out.println("prestamoExitosoLibroSinReservasTestMethod");
        System.out.println("-----------------------------------------");
        IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {    
            iBiblioteca.prestarLibroAUnSocio("Libro8", "Socio5");
 }
        catch(BibliotecaError exc){
            System.out.println(exc.getMessage());
            Assert.assertTrue(false);
        }
    }
    
    /**
    * @author Gonzalo Melo
    * Verifica: Se presta un libro con reservas donde se incluye la primera del usuario
    *
    */
    @Test
    public void prestamoExitosoLibroConReservasTestMethod()
    {
        System.out.println();
        System.out.println("prestamoExitosoLibroConReservasTestMethod");
        System.out.println("-----------------------------------------");
        
        //Comparar que se quito la reserva del usuario
         IBiblioteca iBiblioteca = Factory.getBiblioteca();
        try {
            iBiblioteca.reservarLibroAUnSocio("Libro8", "Socio2");
            iBiblioteca.reservarLibroAUnSocio("Libro8", "Socio3");
            iBiblioteca.reservarLibroAUnSocio("Libro8", "Socio1");

            LinkedList<String> expecteds1 = new LinkedList<String>();
            expecteds1.add("Socio2");
            expecteds1.add("Socio3");
            expecteds1.add("Socio1");
            LinkedList<String> actuals1 = iBiblioteca.libroListaReserva("Libro8");

//            System.out.println("expecteds1: ");
//            for(String str: expecteds1){ System.out.println(str); }
//            System.out.println("actuals1: ");
//            for(String str: actuals1){ System.out.println(str); }
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());

            iBiblioteca.devolverLibro("Libro8", "Socio5");
             iBiblioteca.prestarLibroAUnSocio("Libro8", "Socio2");
            expecteds1.clear();
            expecteds1.add("Socio3");
            expecteds1.add("Socio1");
            actuals1 = iBiblioteca.libroListaReserva("Libro8");

            
//            for(String str: expecteds1){ System.out.println(str); }
//            System.out.println("actuals1: ");
//            for(String str: actuals1){ System.out.println(str); }
            Assert.assertArrayEquals(expecteds1.toArray(), actuals1.toArray());
            
        }
        catch(BibliotecaError exc){
            Assert.assertTrue(false);
        }
        
    }
    
}
