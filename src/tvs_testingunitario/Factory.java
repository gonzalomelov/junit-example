package tvs_testingunitario;

public class Factory {
    static IBiblioteca biblioteca;
	
    public static IBiblioteca getBiblioteca(){
	if (biblioteca == null){
		biblioteca = new Biblioteca();
	}
	return biblioteca;
    }
}
