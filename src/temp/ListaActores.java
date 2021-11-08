package temp;

import java.util.HashMap;
import java.util.Set;

public class ListaActores {
	//ATRIBUTOS
	private static ListaActores miLista;
	private HashMap<String,Actor> lista;
	
	//METODOS
	//Constructora
	private ListaActores() {
		this.lista = new HashMap<String,Actor>();
	}
	
	//Llamar objeto singleton
	public static ListaActores getListaActores() {
		if (ListaActores.miLista==null) {
			ListaActores.miLista = new ListaActores();
		}
		return (ListaActores.miLista);
	}
	
	//Modificar para checkear actores ya añadidos
	public void anadirActor(String actor) {
		actor= actor.trim();
		if (!ListaActores.getListaActores().esta(actor)) {
			this.lista.put(actor, new Actor(actor));
		}
	}
	
	public boolean esta(String actor) {
		actor= actor.trim();
		return(this.lista.containsKey(actor));
	}
	
	//Eliminar actor de lista 
	public void eliminarActor(String actor) {
		actor= actor.trim();
		this.lista.remove(actor);
		
	}
	
	//Devuelve la lista de actores ordenados alfabeticamente
	public Actor[] obtenerListaOrdenada(){
		String [] var = new String[this.lista.size()];
		Set<String> nombres = this.lista.keySet();
		QuickSortNombres qs = new QuickSortNombres();
		int indice = -1;
		for (String i:nombres) {
			indice++;
			var[indice] = i;
		}
		var = qs.sort(var);
		Actor[] res = new Actor[var.length];
		indice = -1;
		for (String i: var) {
			indice++;
			res[indice]=this.lista.get(i);
		}
	return res;	
	}
	
	//Devuelve el actor con el nombre buscado
	public Actor getActor(String nom) {
		Actor aux = null;
		if (this.lista.containsKey(nom)){
			aux = this.lista.get(nom);
		}
		return aux;
	}
	
	public HashMap<String,Actor> getActoresXPelicula(String titulo) {
		//A revisar, se atascaba con titulos con espacios (puede ser algo con el formateo)
		Set<String> nombres = this.lista.keySet();
		HashMap<String,Actor> res = new HashMap<String,Actor>();
		for (String i: nombres) {
			if(this.getActor(i).getPeliculas().containsKey(titulo)) {
				this.getActor(i).anadirHM(res);
				}
		}
		return res;
	}
	
	public HashMap<String,String> devolverTextoCod() {
		HashMap<String,String> res = new HashMap<String,String>();
		Set<String> nombres = this.lista.keySet();
		Set<String> titulos;
		HashMap<String,Pelicula> pelis;
		String aux, ant;
		for (String i:nombres) {
			pelis = this.lista.get(i).getPeliculas();
			titulos = pelis.keySet();
			for(String j:titulos) {
				if(!res.containsKey(j)) {
					ant = j;
					aux = j.replaceFirst(".","");
					while (ListaPeliculas.getListaPeliculas().esta(aux)&&(aux.replaceFirst(".","")!=aux)) {
						ant = aux;
						aux = aux.replaceFirst(".","");
					}
					res.put(j, (ant + " " + "--->>>" + i));
				}else {
					res.put(j, (res.get(j)+"#####"+i));
				}
			}
		}
		ListaPeliculas.getListaPeliculas().anadirPelisSolas(res);
		return(res);
	}

	public void relacionarActores() {
		for(String i: this.lista) {
			this.lista.get(i).getActoresRel();
		}
	}
	
	public void generarGrafo() {
//		A definir...
	}
	
	public static void reset() {
		ListaActores.miLista = null;
	}
}