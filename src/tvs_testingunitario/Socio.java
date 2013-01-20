/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tvs_testingunitario;

import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
/**
 *
 * @author groupo2
 */
public class Socio {
    private String codigo;
    private String direccion;
    private String telefono;
    
    
    //private Map <String,Prestamo> prestamosActuales;
    //private Map <String,Reserva> reservasActuales;
    
    private LinkedList<Prestamo> prestamosActuales;
    private LinkedList<Reserva> reservasActuales;
    
    public Socio(String codigo, String direccion, String telefono){
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
        
        this.reservasActuales = new LinkedList<Reserva>();
        this.prestamosActuales = new LinkedList<Prestamo>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LinkedList<Prestamo> getPrestamosActuales() {
        return prestamosActuales;
    }

    public void setPrestamosActuales(LinkedList<Prestamo> prestamosActuales) {
        this.prestamosActuales = prestamosActuales;
    }

    public LinkedList<Reserva> getReservasActuales() {
        return reservasActuales;
    }

    public void setReservasActuales(LinkedList<Reserva> reservasActuales) {
        this.reservasActuales = reservasActuales;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Socio other = (Socio) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        if ((this.direccion == null) ? (other.direccion != null) : !this.direccion.equals(other.direccion)) {
            return false;
        }
        if ((this.telefono == null) ? (other.telefono != null) : !this.telefono.equals(other.telefono)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 59 * hash + (this.direccion != null ? this.direccion.hashCode() : 0);
        hash = 59 * hash + (this.telefono != null ? this.telefono.hashCode() : 0);
        hash = 59 * hash + (this.prestamosActuales != null ? this.prestamosActuales.hashCode() : 0);
        hash = 59 * hash + (this.reservasActuales != null ? this.reservasActuales.hashCode() : 0);
        return hash;
    }

  

    @Override
    public String toString() {
        return "Socio{" + "codigo=" + codigo + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    public boolean libroYaReservado(String codigo){
        ListIterator it = this.reservasActuales.listIterator();
        boolean reservo = false;
        while (!reservo && it.hasNext()){
            reservo = ((Reserva)it.next()).getLibro().getCodigo().equals(codigo);
        }
        
        return reservo;
    }
    
    public void borrarReserva(String codigoLibro){
        ListIterator it = this.reservasActuales.listIterator();
        boolean reservo = false;
        while (!reservo && it.hasNext()){
            reservo = ((Reserva)it.next()).getLibro().getCodigo().equals(codigo);
        }
        it.remove();
    }
    
    public void reservarLibro(Libro libro){       
       Reserva res=new Reserva(libro,this);       
       //Agrego la reserva como ultima reserva del socio
       reservasActuales.add(res);
       
   }
    
    public void borrarPrestamo(String codigoLibro){
        ListIterator it = this.prestamosActuales.listIterator();
        boolean prestamo = false;
        while (!prestamo && it.hasNext()){
            prestamo = ((Prestamo)it.next()).getLibro().getCodigo().equals(codigo);
        }
        it.remove();
    }
    
    
    
    
}
