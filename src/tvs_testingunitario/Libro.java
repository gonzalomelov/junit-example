/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tvs_testingunitario;

import java.util.LinkedList;

/**
 *
 * @author groupo2
 */
public class Libro {
    private String titulo;
    private String autor;
    private String tema;
    private String codigo;
    
    private LinkedList<Reserva> reservas;
    private Prestamo prestamoActual;
    
    public Libro(String codigo, String titulo, String autor, String tema){
        this.titulo = titulo;
        this.autor = autor;
        this.tema = tema;
        this.codigo = codigo;
        
        this.reservas = new LinkedList<Reserva>();
        this.prestamoActual = null;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Prestamo getPrestamoActual() {
        return prestamoActual;
    }

    public void setPrestamoActual(Prestamo prestamoActual) {
        this.prestamoActual = prestamoActual;
    }

    public LinkedList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(LinkedList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        if ((this.autor == null) ? (other.autor != null) : !this.autor.equals(other.autor)) {
            return false;
        }
        if ((this.tema == null) ? (other.tema != null) : !this.tema.equals(other.tema)) {
            return false;
        }
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        hash = 23 * hash + (this.autor != null ? this.autor.hashCode() : 0);
        hash = 23 * hash + (this.tema != null ? this.tema.hashCode() : 0);
        hash = 23 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 23 * hash + (this.reservas != null ? this.reservas.hashCode() : 0);
        hash = 23 * hash + (this.prestamoActual != null ? this.prestamoActual.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", autor=" + autor + ", tema=" + tema + ", codigo=" + codigo + '}';
    }
    
    public LibroDataType toLibroDataType(){
        return new LibroDataType(this.codigo, this.titulo, this.autor, this.tema);
    }

    
    public boolean isPrestado(){
        return this.prestamoActual!=null;
    }
    
    public void reservarlibro(Socio lec){
        Reserva res= new Reserva(this,lec);
        reservas.add(res);
    }     
    
    public void devolver(){
        this.prestamoActual=null;
    }
    
    public void eliminarReservas(){
        this.reservas.clear();
    }
    
    
}
