/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tvs_testingunitario;


/**
 *
 * @author groupo2
 */
public class Reserva {
    private Libro libro;
    private Socio usuario;

    public Reserva(Libro libro, Socio usuario) {
        this.libro = libro;
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Socio getUsuario() {
        return usuario;
    }

    public void setUsuario(Socio usuario) {
        this.usuario = usuario;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reserva other = (Reserva) obj;
        if (this.libro != other.libro && (this.libro == null || !this.libro.equals(other.libro))) {
            return false;
        }
        if (this.usuario != other.usuario && (this.usuario == null || !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.libro != null ? this.libro.hashCode() : 0);
        hash = 41 * hash + (this.usuario != null ? this.usuario.hashCode() : 0);
        return hash;
    }

  

    @Override
    public String toString() {
        return "Reserva{" + "libro=" + libro + ", usuario=" + usuario + '}';
    }
    
    
}
