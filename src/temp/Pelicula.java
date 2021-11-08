package temp;

import java.util.HashMap;

public class Pelicula {
	//ATRIBUTOS
	private String titulo;
	private int ganancia;
	//METODOS
	//Constructor
	public Pelicula(String pTit, int pGanan) {
		this.titulo = pTit;
		this.ganancia = pGanan;
	}
	
	//Aumentar el valor del atributo ganancia
	public void incrementarGanancia(int inc) {
		this.ganancia = this.ganancia + inc;
	}
	
	//Devolver actore involucrados en la pelicula
	public HashMap<String,Actor> getActores(){
		return(ListaActores.getListaActores().getActoresXPelicula(this.titulo));
	}
	
	//Para propositos de testear
	public int getGanancia() {
		return(this.ganancia);
	}
}
