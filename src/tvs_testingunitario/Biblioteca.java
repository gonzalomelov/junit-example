package tvs_testingunitario;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Biblioteca implements IBiblioteca{
    
    private Map <String,Libro> libros=new HashMap<String,Libro>();
    private Map <String,Socio> socios=new HashMap<String,Socio>();
    private LinkedList<LibroDataType> librosPrestados = new LinkedList<LibroDataType>();
    
             
    /*
     * Agrega un nuevo libro a la biblioteca.
     * Precondiciones: no existe un libro de igual código. El código es no vacío.
     * 
     * @author Juan Ibarra
     */
    @Override
    public void agregarLibro(String codigo, String titulo, String autor, String tema) throws BibliotecaError{
        
        if (codigo == null || codigo.equals("")){
            System.out.println("Codigo invalido");
            throw new BibliotecaError("Codigo invalido");
        }
        
         if(libros.containsKey(codigo) ){
             System.out.println("Ya existe el libro");
            throw new BibliotecaError("Ya existe el libro");
        }  
         
        Libro nuevo= new Libro(codigo,titulo,autor,tema);
        libros.put(codigo,nuevo);
       
    }
    
    /*
     * Agrega un nuevo socio a la biblioteca.
     * Precondiciones: no existe un socio de igual código. El código es no vacío.
     * 
     * @author Gonzalo Melo
     */
    @Override
    public void agregarSocio(String codigo, String direccion, String telefono) throws BibliotecaError{
        
        if (codigo == null || codigo.equals("")){
            System.out.println("Codigo invalido");
            throw new BibliotecaError("Codigo invalido");
        }       

        if (socios.containsKey(codigo)){
            System.out.println("Socio ya existente");
            throw new BibliotecaError("Socio ya existente");
        }      
        
        Socio socio = new Socio(codigo, direccion, telefono);
        this.socios.put(codigo,socio);
    }
    
    /*
     * Devuelve para cada libro que se encuentra en préstamo, su información.
     * La información de los libros debe devolverse ordenada cronológicamente en forma ascendente según cuando se prestó el libro.
     * En caso de que no exista ningún libro en préstamo al momento de invocar la operación se devuelve la lista vacía. 
     * 
     * @author Juan Ibarra
     */
    @Override
    public LinkedList<LibroDataType> librosPrestados(){
        
     /*   LinkedList<LibroDataType> salida=new LinkedList<>();
        Socio auxLec;
        Libro auxLib;
        //Map <String,Prestamo> librosLector ;    
        LinkedList<Prestamo> librosLector = new LinkedList<>();
                
        Iterator it = socios.entrySet().iterator();
        while (it.hasNext()) {                      
            auxLec= (Socio) it.next();
            librosLector=auxLec.getPrestamosActuales();
            java.util.Iterator it2 = librosLector.iterator();
            while (it2.hasNext()) {
                auxLib= (Libro) it2.next();
                salida.add(auxLib.toLibroDataType());
            }
        }
        //falta ordenaar*/
        
        return this.librosPrestados;
    }
    
    /*
     * Devuelve la información de los libros prestados al lector de código codigoSocio al momento que se invoca la operación.
     * La lista de libros debe estar ordenada en forma ascendente por código de libro. En caso de que no exista ningún
     * libro en préstamo al momento de invocar la operación se devuelve la lista vacía.
     * Pre-condición: el lector de código codigoSocio existe.
     * 
     * @author Gonzalo Melo
     */
    @Override
    public LinkedList<LibroDataType> librosPrestadosAUnSocio(String codigoSocio) throws BibliotecaError{
		
        if (codigoSocio == null || codigoSocio.equals("")){
            System.out.println("Codigo invalido");
            throw new BibliotecaError("Codigo invalido");
        }
        
        if (!socios.containsKey(codigoSocio)){
            System.out.println("Socio no existe");
            throw new BibliotecaError("Socio no existe");
        }
        
        Socio socio = socios.get(codigoSocio);
        
        LinkedList<LibroDataType> retList = new LinkedList<LibroDataType>();
        
        for(Prestamo p: socio.getPrestamosActuales()){
           retList.add(p.getLibro().toLibroDataType());
        }  
        
        java.util.Collections.sort(retList);
        
        return retList;
    }

    /*
     * Dado el código del libro codigoLibro y el código del lector codigoSocio, se reserva
     * el libro de código codigoLibro al lector de código codigoSocio. 
     * Pre-condiciones: el libro de código codigoLibro y el lector de código codigoSocio existen.
     * Solo se puede reservar un libro si el mismo se encuentra prestado al momento de invocar esta
     * operación. Dado un socio, en un momento dado, éste no puede tener más de una reserva a un mismo libro.
     * 
     * * @author Juan Ibarra
     */
    @Override
    public void reservarLibroAUnSocio(String codigoLibro, String codigoSocio) throws BibliotecaError{
        if (codigoLibro == null || codigoLibro.equals("")){
            System.out.println("Codigo Libro invalido");
            throw new BibliotecaError("Codigo Libro invalido");
        }

        if (codigoSocio == null || codigoSocio.equals("")){
            System.out.println("Codigo Socio invalido");
            throw new BibliotecaError("Codigo Socio invalido");
        }
        if(!libros.containsKey(codigoLibro) ){
            System.out.println("no existe el libro");
            throw new BibliotecaError("no existe el libro");
        }        
        if(!socios.containsKey(codigoSocio) ){
            System.out.println("no existe el socio");
            throw new BibliotecaError("no existe el socio");
        } 
        Libro libro=libros.get(codigoLibro);
        if(!libro.isPrestado()){
            System.out.println("el libro no esta prestado");
            throw new BibliotecaError("el libro no esta prestado");
        }        
        Socio socio=socios.get(codigoSocio);
        //verificar que el lector no tenga una reserva sobre es libro
        if(socio.libroYaReservado(codigoLibro)){
            System.out.println("el libro fue reservado por el lector previamente");
            throw new BibliotecaError("el libro fue reservado por el lector previamente");
        }   
        
        socio.reservarLibro(libro);  
        libro.reservarlibro(socio);
    }
    
    /*
     * Devuelve la información de los libros reservados por el lector de código codigoSocio al momento
     * de invocar la operación. La lista de libros debe estar ordenada en forma ascendente por código de libro.
     * En caso de que no exista ningún libro reservado al momento de invocar la operación se devuelve la lista vacía.
     * Pre-condición: el lector de código codigoSocio existe.
     * 
     * @author Gonzalo Melo
     */
    @Override
    public LinkedList<LibroDataType> librosReservadosDeUnSocio(String codigoSocio) throws BibliotecaError{
		
        if (codigoSocio == null || codigoSocio.equals("")){
            System.out.println("Codigo invalido");
            throw new BibliotecaError("Codigo invalido");
        }
       
        if (!socios.containsKey(codigoSocio)){
            System.out.println("Socio no existe");
            throw new BibliotecaError("Socio no existe");
        }
        
        Socio socio = socios.get(codigoSocio);
        
        LinkedList<LibroDataType> retList = new LinkedList<LibroDataType>();
        for(Reserva r: socio.getReservasActuales()){
           retList.addLast(r.getLibro().toLibroDataType()); 
        }
        
        java.util.Collections.sort(retList);
                
        return retList;
    }
	
    /*
     * Devuelve el código de los socios que tienen reserva para el libro de código codigoLibro.
     * Los códigos de socio deben devolverse ordenados cronológicamente en forma ascendente según
     * cuando se reservó el libro. En caso de que no existan reservas para el libro al momento de
     * invocar la operación se devuelve la lista vacía. 
     * Pre-condición: el libro de código codigoLibro existe.
     * 
     * @author Juan Ibarra
     */
    @Override
    public LinkedList<String> libroListaReserva(String codigoLibro) throws BibliotecaError{
        
        if (codigoLibro == null || codigoLibro.equals("")){
            System.out.println("Codigo Libro invalido");
            throw new BibliotecaError("Codigo Libro invalido");
        }
         if(!libros.containsKey(codigoLibro) ){
            System.out.println("no existe el libro");
            throw new BibliotecaError("no existe el libro");
        }    
        LinkedList<String> salida=new LinkedList<String>();
        Reserva res;
        String codSocio;
        
        Libro libro=libros.get(codigoLibro);
        
        Iterator it = libro.getReservas().iterator();
        while (it.hasNext()) {
            res= (Reserva) it.next();
            codSocio=res.getUsuario().getCodigo();
            salida.add(codSocio);
        }
        
        //TODO La lista ya se encuentra ordenada cronologicamente
        //java.util.Collections.sort(salida);
        
        return salida;
    }
	
    /*
     * Dado el código del libro codigoLibro y el código del lector codigoSocio, se presta
     * el libro de código codigoLibro al lector de código codigoSocio. 
     * El préstamo de un libro será exitoso, si el libro no se encuentra prestado al momento de
     * invocar esta operación, y además, si el libro a prestar se encuentra reservado, el
     * préstamo del mismo solo será exitoso, si el lector que intenta llevar a préstamo el libro,
     * tiene hecha una reserva y a su vez, es el que tiene la reserva más antigua para dicho libro.
     * Si el lector tenía una reserva del libro al momento de llevar a préstamo el mismo, el libro
     * deberá ser borrado del conjunto de libros que tiene reservado.
     * Pre-condiciones: el libro de código codigoLibro y el lector de código codigoSocio existen. 
     * 
     * @author Gonzalo Melo
     */
    @Override
    public void prestarLibroAUnSocio(String codigoLibro, String codigoSocio) throws BibliotecaError{
               
        if (codigoLibro == null || codigoLibro.equals("")){
            System.out.println("Codigo Libro invalido");
            throw new BibliotecaError("Codigo Libro invalido");
        }
        
        if (codigoSocio == null || codigoSocio.equals("")){
            System.out.println("Codigo Socio invalido");
            throw new BibliotecaError("Codigo Socio invalido");
        }
        
       if (!libros.containsKey(codigoLibro)){
            System.out.println("Libro no existe");
            throw new BibliotecaError("Libro no existe");
        }      
       
        if (!socios.containsKey(codigoSocio)){
            System.out.println("Socio no existe");
            throw new BibliotecaError("Socio no existe");
        }
        
        Libro libro = libros.get(codigoLibro);
        Socio socio = socios.get(codigoSocio);
        
        if (libro.getPrestamoActual() != null){
            System.out.println("Libro ya se encuentra a prestamo");
            throw new BibliotecaError("Libro ya se encuentra a prestamo");
        }
        
        Reserva reserva = null;
		if (!libro.getReservas().isEmpty()){
            reserva = libro.getReservas().peek();
            if (!reserva.getUsuario().equals(socio)){
                System.out.println("No es el turno de reserva del socio");
                throw new BibliotecaError("No es el turno de reserva del socio");
            }
        }
        
        if (reserva != null){
            socio.getReservasActuales().remove(reserva);
            libro.getReservas().pollFirst();
        }
        
        Prestamo prestamo = new Prestamo(libro,socio);
        socio.getPrestamosActuales().add(prestamo);
        libro.setPrestamoActual(prestamo);
        
        this.librosPrestados.add(libro.toLibroDataType());//se agrega el codigo para la recorrida cronologica
        
        
    }
    
    
    
    /*
     * Dado el libro codigoLibro y el lector codigoSocio, se devuelve el libro a la biblioteca. 
     * Pre-condiciones: el libro de código codigoLibro y el lector de código codigoSocio existen,
     * y el libro de código codigoLibro lo tiene a préstamo el lector de código codigoSocio al momento de invocar la operación. 
     * 
     * @author Juan Ibarra
     */
    @Override
    public void devolverLibro(String codigoLibro, String codigoSocio) throws BibliotecaError{


       if (codigoLibro == null || codigoLibro.equals("")){
            System.out.println("Codigo Libro invalido");
            throw new BibliotecaError("Codigo Libro invalido");
        }

        if (codigoSocio == null || codigoSocio.equals("")){
            System.out.println("Codigo Socio invalido");
            throw new BibliotecaError("Codigo Socio invalido");
        }

        if(!libros.containsKey(codigoLibro) ){
            System.out.println("no existe el libro");
            throw new BibliotecaError("no existe el libro");
        }        
        if(!socios.containsKey(codigoSocio) ){
            System.out.println("no existe el socio");
            throw new BibliotecaError("no existe el socio");
        } 
        if(!libros.get(codigoLibro).isPrestado()){//se podria eliminar
            System.out.println("El libro no se encuentra prestado"); 
            throw new BibliotecaError("El libro no se encuentra prestado"); 
        }
        if(!libros.get(codigoLibro).getPrestamoActual().getSocio().getCodigo().equals(codigoSocio)){
            System.out.println("El libro no se encuentra prestado al socio");
            throw new BibliotecaError("El libro no se encuentra prestado al socio"); 
        }
        
        socios.get(codigoSocio).borrarPrestamo(codigoLibro);//se saca de los prestados
        libros.get(codigoLibro).devolver(); 
        
        boolean encontro=false;
        LibroDataType data=null;
        Iterator it = this.librosPrestados.iterator();
        while (!encontro && it.hasNext()) {
            data= (LibroDataType) it.next();
            encontro =(data.getCodigo().equals(codigoLibro));
        }
        this.librosPrestados.remove(data);
    }
	
    /*
     * Dado el lector de código codigoSocio se borra al mismo de la  biblioteca. En caso de
     * que tenga reserva de libros, las reservas se cancelan (se eliminan del sistema).
     * Pre-condiciones: el lector de código codigoSocio existe, y el lector no tiene libros
     * prestados al momento de invocar la operación. 
     * 
     * @author Gonzalo Melo
     */
    @Override
    public void borrarSocio(String codigoSocio) throws BibliotecaError{
		
		//si el socio tiene reservas se eliminan
		//elimino el socio
        
        if (codigoSocio == null || codigoSocio.equals("")){
            System.out.println("Codigo Socio invalido");
            throw new BibliotecaError("Codigo Socio invalido");
        }
        
       if (socios.containsKey(codigoSocio)){
            System.out.println("Socio no existe");
            throw new BibliotecaError("Socio no existe");
        }
        
        Socio socio = socios.get(codigoSocio);
        
        if (!socio.getPrestamosActuales().isEmpty()){
            System.out.println("No se puede eliminar un Socio con prestamos");
            throw new BibliotecaError("No se puede eliminar un Socio con prestamos");
        }
        
       for(Reserva r: socio.getReservasActuales()){  
            socio.getReservasActuales().remove(r);
            Libro libro = r.getLibro();
            libro.getReservas().remove(r);         
        }   
        
        socios.remove(socio.getCodigo());
		
    }
	
    /*
     * Dado el libro de código codigoLibro se borra al mismo de la  biblioteca.
     * En caso de que hayan reservas del libro, las reservas se cancelan (se eliminan del sistema).
     * Pre-condiciones: el libro de código codigoLibro existe, y el libro no
     * se encuentra prestado al momento de invocar la operación.
     * 
     * @author Juan Ibarra
     */
    @Override
    public void borrarLibro(String codigoLibro) throws BibliotecaError{
        if (codigoLibro == null || codigoLibro.equals("")){
            System.out.println("Codigo invalido");
            throw new BibliotecaError("Codigo invalido");
        }
        if(!libros.containsKey(codigoLibro)){
            System.out.println("No existe el libro con ese codigo");
             throw new BibliotecaError("No existe el libro con ese codigo");
        }
        if(libros.get(codigoLibro).isPrestado()){
            System.out.println("El libro se encuentra prestado");
             throw new BibliotecaError("El libro se encuentra prestado"); 
        }
        //hay que ver las reservas al libro obtener el usuario asociado y removerlo de
        //la lista de reservados del usuario
        Libro libro=libros.get(codigoLibro);
        Reserva res;
        String codSocio;
        
          
        
        Iterator it = libro.getReservas().iterator();
        while (it.hasNext()) {
            res= (Reserva) it.next();
            codSocio=res.getUsuario().getCodigo();
            socios.get(codSocio).borrarReserva(codigoLibro);

        }
        libros.remove(codigoLibro);
        libro.eliminarReservas();
    }
}
