package Clases;

import java.util.HashMap;
import java.util.LinkedList;

public class Club {

	private HashMap<String, Socio> cSocio;
	
	public Club(){
		cSocio = new HashMap<String, Socio>();
	}
	
	public void altaSocio(Socio otro) throws SocioException{
		
		if (cSocio.containsKey(otro.getDni()))
			throw new SocioException("Error, el socio ya esta registrado");
		
		cSocio.put(otro.getDni(), otro);
	}
	
	public Socio bajaSocio(String dni){
		return cSocio.remove(dni);
	}
	
	public void modificaDatos(Socio otro) throws SocioException{
		if (!cSocio.containsKey(otro.dni))
			throw new SocioException("Error, ese socio no existe");
			
		cSocio.put(otro.dni, otro);
		
	}
	
	public Socio consultaSocio(String dni) throws SocioException{
		
		if (!cSocio.containsKey(dni))
			throw new SocioException("Error, ese socio no existe");
		
		return cSocio.get(dni);
		
	}
	
	public String listarTelefono(){
		StringBuilder resul = new StringBuilder();
		
		LinkedList<Socio> s = (LinkedList<Socio>) cSocio.values();
		
		for (Socio socio : s) {
			resul.append(socio.telefono + "\n");
		}
		return resul.toString();
	}
	
	public String iterarTelefono(){
		StringBuilder resul = new StringBuilder();
		
		for (Socio element : cSocio.values()) {
			resul.append(element.telefono + "\n");
		}
		
		return resul.toString();
	}
	
}
