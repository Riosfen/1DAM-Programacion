package Clases;

import java.util.LinkedList;

public class Historial {

	private LinkedList<Pagina> historial;
	
	public Historial (){
		historial = new LinkedList<Pagina>();
	}
	
	public boolean aniadirPagina(Pagina pagina){
		boolean resul = false;
		
		if (historial.isEmpty()){
			historial.push(pagina);
			resul = true;
		}
		if (historial.getFirst().compareTo(pagina) < 0){
			historial.push(pagina);
			resul = true;
			}
		
			
		return resul;
	}
	
	public String toString(){
		StringBuilder resul = new StringBuilder();
		
		for (Pagina pagina : historial) {
			if (pagina != null){
				resul.append(pagina + "\n");
			}
		}
		
		return resul.toString();
	}
	
	public String historialDia(Fecha fecha){
		StringBuilder resul = new StringBuilder();
		
		for (Pagina pagina : historial) {
			if (pagina != null && pagina.getFecha().equals(fecha)){
				resul.append(pagina + "\n");
			}
		}
		
		return resul.toString();
	}
	
	public void borrarHistorial(){
		historial.clear();
	}
	
}
