package temp;

import java.util.ArrayList;
import java.util.HashMap;


public class Actor {
	//ATRIBUTOS
	/*private*/public String nombre;
	private HashMap<String,Pelicula> listaPeliculas;
	/*private*/public ArrayList<Actor> actoresRel;
	
	//METODOS
	
	//Constructora
	public Actor(String pNom) {
		this.nombre = pNom;
		this.listaPeliculas = new HashMap<String,Pelicula>();
	}
	
	public void getActoresRel() {
		ArrayList<Actor> res = new ArrayList<Actor>();
		Pelicula aux;
		for (String i: this.listaPeliculas.keySet()) {
			aux=(this.listaPeliculas.get(i));
			for (String j : aux.getActores().keySet()) {
				res.add(ListaActores.getListaActores().getActor(j));
			}
		}
	}
	
	//Añadir pelicula a la lista
	public void anadirPeli(String tit) {
		tit=tit.trim();
		if (!this.tienePeli(tit)) {
			this.listaPeliculas.put(tit, ListaPeliculas.getListaPeliculas().getPeli(tit));
		}
	}
	
	public boolean tienePeli(String peli){
		peli=peli.trim();
		return this.listaPeliculas.containsKey(peli);
				
	}
	
	//Buscar pelicula por nombre
	public Pelicula buscarPeli(String peli) {
		Pelicula aux =  null;
		peli= peli.trim();
		if (this.listaPeliculas.containsKey(peli)){
			aux =  listaPeliculas.get(peli);
		}
		return aux;
	}	
	
	//Devolver lista de peliculas
	public HashMap<String,Pelicula> getPeliculas(){
		return this.listaPeliculas;
	}
	
	public void anadirHM(HashMap<String, Actor> hashMap) {
		// Añade el actor a un hashmap, para luego guardarlo
		hashMap.put(this.nombre, this);
	}

}