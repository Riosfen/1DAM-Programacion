package Clases;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaDeNumeros {

	private LinkedList<Integer> cNumero;
	
	public ListaDeNumeros (){
		cNumero = new LinkedList<Integer>();
	}
	
	public boolean aniadirNumero(int num){
		return cNumero.add(num);
	}
	
	// Esto solo borra el primero (no se por que)
	public void borrarNumero(int num){
		Iterator<Integer> itr = cNumero.iterator();
		Integer numero;
		
		while (itr.hasNext()) {
			numero = itr.next();

			if (numero.intValue() == num)
				itr.remove();
		}
	}
	
	public String toString(){
		StringBuilder resul = new StringBuilder();
		
		for (Integer num : cNumero) {
			resul.append(num + ",");
		}
		
		return resul.toString();
	}
	
	public String imprimirLista(int num) throws ListaDeNumerosException{
		StringBuilder resul = new StringBuilder();
		int contador = 1;
		
		if (num <= 0 || num > cNumero.size())
			throw new ListaDeNumerosException("Error, posición incorrecta");
		
		for (Integer num1 : cNumero) {
			
			if (contador >= num)
				resul.append(num1.intValue() + ",");
			
			contador++;
		}
		
		return resul.toString();
	}
	
	public String listaInversa(){
		StringBuilder resul = new StringBuilder();
		Iterator<Integer> itr = cNumero.iterator();
		
		imprimirRecursiva(itr, resul);
		
		return resul.toString();
	}

	private void imprimirRecursiva(Iterator<Integer> itr, StringBuilder resul) {
		
		Integer num = null;
		
		if (itr.hasNext()){
			num = itr.next();
			imprimirRecursiva(itr, resul);
			resul.append(num + ",");
		}
	}
	
	public ListaDeNumeros concatenar(ListaDeNumeros otro){
		ListaDeNumeros resul = new ListaDeNumeros();
		
		resul.cNumero.addAll(cNumero);
		
		for (Integer num : otro.cNumero) {
			resul.aniadirNumero(num);
		}
		
		return resul;
	}
	
	public int sumarNumero(){
		int resul = 0;
		
		for (Integer num : cNumero) {
			resul = resul + num.intValue();
		}
		
		return resul;
	}
	
	public int sumarNumeroRecursivo(){
		int resul = 0;
		Iterator<Integer> itr = cNumero.iterator();
		
		resul = elementoRecursivo(itr);
		
		return resul;
	}

	private int elementoRecursivo(Iterator<Integer> itr) {

		int resul = 0;
		
		if (itr.hasNext()){
			resul = itr.next();
			resul = resul + elementoRecursivo(itr);
		}
		
		return resul;
	}
	
}
