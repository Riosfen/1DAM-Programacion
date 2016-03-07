package Ejercicio9Arrays;

import java.util.Arrays;

public class Refranes {
	
	private static final int REFRANES_MINIMOS = 2;
	private Refran[] vrefran;
	private int contRefran;

	public Refranes(int longRefranes) throws RefranesException{
		
		if (longRefranes < REFRANES_MINIMOS)
			throw new RefranesException("Error, no se puede crear una lista de refranes de menos de " + REFRANES_MINIMOS + " refranes.");
		vrefran = new Refran[longRefranes];
		contRefran = 0;
	
	}
	
	public int getContRefran(){
		return contRefran;
	}
	
	public void guardarRefran(Refran refran) throws RefranesException{
		
		if(contRefran >= vrefran.length)
			throw new RefranesException("Error, no se pueden guardar mas refranes.");
		
		for (int i = 0; i < contRefran; i++) {
		
			if(refran.equals(vrefran[i]))
				throw new RefranesException("Error, ya existe este refrán en la lista.");
			
		}
		
		vrefran[contRefran] = refran;
		contRefran++;
		
	}
	
	public Refran buscarRefranPorPalabra(String palabraABuscar) throws RefranesException{
		
		int i = 0;
		boolean encontrado = false;

		while(i < contRefran && encontrado == false){
			
			if(vrefran[i].getRefran().contains(palabraABuscar)){
				System.out.println(vrefran[i]);
				encontrado = true;
			}
			else{
				i++;
			}
		}
		if (encontrado == false)
			throw new RefranesException("Error, no se ha encontrado ninguna coincidencia.");
		
		return vrefran[i];
	}
	
	public String listarRefranes() throws RefranesException{
		
		if(contRefran < 2)
			throw new RefranesException("Error, no se puede mostrar, lista vacía o hay menos de 2 refranes.");
		
		Refran[] vrefran2 = vrefran.clone();
		
		StringBuilder resultado = new StringBuilder();
		
		int i,j,menor;
		Refran aux;
		
		for (i = 0; i < contRefran -1; i++) {
			menor = i;
			for (j=i+1; j < contRefran; j++) {
				
				if (vrefran2[j].getRefran().compareTo(vrefran2[menor].getRefran()) == -1){
					menor = i;
				}
				
			}
			
			aux = vrefran2[i];
			vrefran2[i] = vrefran2[menor];
			vrefran2[menor] = aux;
			
		}
		
		for (int k = 0; k < vrefran2.length; k++) {
			resultado.append("\n"+vrefran2[k].getRefran());
		}
		
		return resultado.toString();
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder("Lista de refranes: ");
		
		for (int i = 0; i < vrefran.length; i++) {
			resultado.append("\n" + vrefran[i].getRefran());
		}
		
		return resultado.toString();
		
	}

}
