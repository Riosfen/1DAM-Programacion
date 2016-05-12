package Clases;

import java.util.ArrayList;

public class Pagina {

	private String nombrePagina;
	private Fecha fecha;
	
	public Pagina(String nombrePagina, Fecha fecha){
		this.nombrePagina = nombrePagina;
		this.fecha = fecha;
	}
	
	public String getNombrePagina(){
		return nombrePagina;
	}
	public Fecha getFecha(){
		return fecha;
	}
	
	public String toString(){
		return "Página WEP: " + nombrePagina + "\n" + fecha;
	}
	
}
