package tvs_testingunitario;


public class LibroDataType implements Comparable {
    private String codigo;
    private String titulo;
    private String autor;
    private String tema;
    
    public LibroDataType(String codigo, String titulo, String autor, String tema){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.tema = tema;
    }
   
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
	
    public String getAutor() {
        return autor;
    }

    public String getTema() {
        return tema;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    } 
	
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String toString() {
        return "LibroDataType{" + "codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", tema=" + tema + '}';
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LibroDataType other = (LibroDataType) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        if ((this.autor == null) ? (other.autor != null) : !this.autor.equals(other.autor)) {
            return false;
        }
        if ((this.tema == null) ? (other.tema != null) : !this.tema.equals(other.tema)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        hash = 67 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        hash = 67 * hash + (this.autor != null ? this.autor.hashCode() : 0);
        hash = 67 * hash + (this.tema != null ? this.tema.hashCode() : 0);
        return hash;
    }

    
    
    @Override
    public int compareTo(Object o) { 
        LibroDataType dL = (LibroDataType)o;     
        return this.codigo.compareToIgnoreCase(dL.codigo);
     } 
    
    
}
