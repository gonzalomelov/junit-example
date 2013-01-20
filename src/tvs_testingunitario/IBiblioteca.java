package tvs_testingunitario;

import java.util.LinkedList;

public interface IBiblioteca {
   
     /*
     * Precondicion: ver letra del obligatorio
     */
    public void agregarLibro(String codigo, String titulo, String autor, String tema) throws BibliotecaError;
    
    /*
     * Precondicion: ver letra del obligatorio
     */
    public void agregarSocio(String codigo, String direccion, String telefono) throws BibliotecaError;
    
    /*
     * Precondicion: no tiene
     */
    public LinkedList<LibroDataType> librosPrestados();
    
    /*
     * Precondicion: ver letra del obligatorio
     */
    public LinkedList<LibroDataType> librosPrestadosAUnSocio(String codigoSocio) throws BibliotecaError;

    /*
     * Precondicion: ver letra del obligatorio
     */
    public void reservarLibroAUnSocio(String codigoLibro, String codigoSocio) throws BibliotecaError;
    
    /*
     * Precondicion: ver letra del obligatorio
     */
    public LinkedList<LibroDataType> librosReservadosDeUnSocio(String codigoSocio) throws BibliotecaError;
	
    /*
     * Precondicion: ver letra del obligatorio
     */
    public LinkedList<String> libroListaReserva(String codigoLibro) throws BibliotecaError;
	 
    /*
     * Precondicion: ver letra del obligatorio
     */
    public void prestarLibroAUnSocio(String codigoLibro, String codigoSocio) throws BibliotecaError;
    
    /*
     * Precondicion: ver letra del obligatorio
     */
    public void devolverLibro(String codigoLibro, String codigoSocio) throws BibliotecaError;
	
    /*
     * Precondicion: ver letra del obligatorio
     */
    public void borrarSocio(String codigoSocio) throws BibliotecaError;
    
    /*
     * Precondicion: ver letra del obligatorio
     */
    public void borrarLibro(String codigoLibro) throws BibliotecaError;
}
