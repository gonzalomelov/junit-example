/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tvs_testingunitario;


/**
 *
 * @author groupo2
 */
public class Prestamo {
    private Libro libro;
    private Socio socio;

    public Prestamo(Libro libro, Socio socio) {
        this.libro = libro;
        this.socio = socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestamo other = (Prestamo) obj;
        if (this.libro != other.libro && (this.libro == null || !this.libro.equals(other.libro))) {
            return false;
        }
        if (this.socio != other.socio && (this.socio == null || !this.socio.equals(other.socio))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.libro != null ? this.libro.hashCode() : 0);
        hash = 97 * hash + (this.socio != null ? this.socio.hashCode() : 0);
        return hash;
    }


    





    @Override
    public String toString() {
        return "Prestamo{" + "libro=" + libro + ", socio=" + socio + '}';
    }
    
    
}
