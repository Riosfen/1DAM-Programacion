package Clases;

import java.util.HashMap;
import java.util.Iterator;

public class Club {

	private HashMap<String, Socio> cClub;
	
	public Club (){
		cClub = new HashMap<>();
	}
	
	public void altaSocio(String dni, String nombre, int telefono){
	
		Socio nuevoSocio = new Socio(dni, nombre, telefono);
		
		cClub.put(dni, nuevoSocio);
		
	}
	
	public boolean bajaSocio(String dni){
		
		cClub.
		
	}
	
	public boolean modificarSocio(String dni){
		
	}
	
	public boolean consultarSocio(String dni){
		
	}
	
	public String toString(){
		return ""
	}
	
}
