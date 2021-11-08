package temp;

import java.util.HashMap;
import java.util.Set;

public class ListaPeliculas {
	private HashMap<String,Pelicula> lista;
	private static ListaPeliculas miLista;
	
	private ListaPeliculas() {
		this.lista = new HashMap<String,Pelicula>();
	}
	
	//para propositos de testeo
	public int longitud() {
		return(this.lista.size());
	}
	
 	public static ListaPeliculas getListaPeliculas() {
		if (ListaPeliculas.miLista==null) {
			ListaPeliculas.miLista = new ListaPeliculas();
		}
		return (ListaPeliculas.miLista);
	}
	
	public Pelicula getPeli(String titulo) {
		//Si no está ya añadida añade la película a la lista y la devuelve
		Pelicula res = null;
		titulo = titulo.trim();
		if (this.lista.containsKey(titulo)) {
			res = lista.get(titulo);
		}else {
			res = new Pelicula(titulo,500);
			lista.put(titulo, res);
		}
		return res;
	}
	public boolean esta(String titulo) {
		return(this.lista.containsKey(titulo));
	}
		
	public HashMap<String,String> anadirPelisSolas(HashMap<String,String> pLista){
		Set<String> titulos = this.lista.keySet();
		for (String i: titulos) {
			String aux;
			if(!pLista.containsKey(i)&&this.lista.get(i).getActores().size()==0) {
				aux = i;
				while (ListaPeliculas.getListaPeliculas().esta(aux)&& ListaPeliculas.getListaPeliculas().esta(aux.replaceFirst(".",""))){
					aux = aux.replaceFirst(".","");
				}
				pLista.put(i, (aux + " " + "--->>>"));
			}
		}
		return (pLista);
	}
	
	public static void resetear() {
		ListaPeliculas.miLista = null;
	}
}