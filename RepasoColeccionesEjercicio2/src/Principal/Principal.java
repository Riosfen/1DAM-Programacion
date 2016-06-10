package Principal;

import Clases.ListaDeNumeros;
import Clases.ListaDeNumerosException;

public class Principal {
	
	public static void main(String[] args) {
		
ListaDeNumeros lista1 = new ListaDeNumeros();
		
		lista1.aniadirNumero(1);
		lista1.aniadirNumero(5);
		lista1.aniadirNumero(7);
		lista1.aniadirNumero(2);
		lista1.aniadirNumero(8);
		lista1.aniadirNumero(9);
		lista1.aniadirNumero(6);
		lista1.aniadirNumero(5);
		lista1.aniadirNumero(2);
		lista1.aniadirNumero(8);
		lista1.aniadirNumero(2);
		lista1.aniadirNumero(1);
		
		ListaDeNumeros lista = new ListaDeNumeros();
		
		lista.aniadirNumero(1);
		lista.aniadirNumero(5);
		lista.aniadirNumero(76);
		lista.aniadirNumero(234);
		lista.aniadirNumero(8);
		lista.aniadirNumero(97);
		lista.aniadirNumero(69);
		lista.aniadirNumero(506);
		lista.aniadirNumero(212);
		lista.aniadirNumero(89);
		lista.aniadirNumero(64);
		lista.aniadirNumero(1);
		
		System.out.println(lista);
		
		lista.borrarNumero(1);
		
		System.out.println(lista);
		
		try {
			System.out.println(lista.imprimirLista(6));
		} catch (ListaDeNumerosException e) {
			System.out.println("Error, no s ha podido imprimir la lista");
		}
		
		System.out.println(lista.listaInversa());
		
		ListaDeNumeros nuevaLista = lista.concatenar(lista1);
		
		System.out.println(nuevaLista);
		
		System.out.println("Suma lista1: " + lista.sumarNumero());
		System.out.println("Suma lista2: " + lista1.sumarNumero());
		System.out.println("Suma lista3: " + nuevaLista.sumarNumero());
		
	}
}
