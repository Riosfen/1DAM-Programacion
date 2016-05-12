package Clases;

import java.util.ArrayList;
import java.util.Iterator;

public class Historial {
	
	private ArrayList<Pagina> cPagina;
	
	public Historial(){
		cPagina = new ArrayList<Pagina>();
	}
	
	public boolean introducirNombreFecha(Pagina pagina){
		
		Iterator<Pagina> itr = cPagina.iterator();
		Pagina paginaAnterior;
		boolean resultado = false;
		
		while(itr.hasNext() && resultado == false){
			
			paginaAnterior = itr.next();
			
			if (!(itr.hasNext())){
				
				if(paginaAnterior.getFecha().compareTo(pagina.getFecha()) < 1){
					resultado = cPagina.add(pagina);
				}
				
			}
			
		}
		
		return resultado;
	}
	
	public String toString(){
		StringBuilder resultado = new StringBuilder();
	
		Iterator<Pagina> itr = cPagina.iterator();
		Pagina pagina;
		
		while(itr.hasNext()){
			pagina = itr.next();
			
			resultado.append(pagina + "\n");
			
		}
		
		return resultado.toString();
	}

}
