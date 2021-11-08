package temp;

import java.util.ArrayList;
import java.util.HashMap;


public class Actor {
	//ATRIBUTOS
	private String nombre;
	private HashMap<String,Pelicula> listaPeliculas;
	private ArrayList<Actor> actoresRel;
	
	//METODOS
	
	//Constructora
	public Actor(String pNom) {
		this.nombre = pNom;
		this.listaPeliculas = new HashMap<String,Pelicula>();
	}
	
	public void getActoresRel() {
		ArrayList<Peliculas> res = new ArrayList<Pelicula>();
		Pelicula aux;
		for (String i: this.listaPeliculas) {
			aux=(this.listaPeliculas.get(i));
			for (String j : aux.getActores) {
				res.add(j);
			}
		}
	}
	
	//A�adir pelicula a la lista
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
		// A�ade el actor a un hashmap, para luego guardarlo
		hashMap.put(this.nombre, this);
	}

}