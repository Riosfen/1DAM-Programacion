package Clases;

import java.util.Iterator;
import java.util.LinkedList;

public class ListaDeNumeros {

	private LinkedList<Integer> listaNumeros = new LinkedList<Integer>();

	public boolean aniadirNumero(int num) {
		return listaNumeros.add(num);
	}

	public boolean eliminarNumero(int num) {

		Iterator<Integer> itr = listaNumeros.iterator();
		Integer numero;
		boolean borrado = false;

		while (itr.hasNext()) {

			numero = itr.next();

			if (numero == num) {

				itr.remove();
				borrado = true;

			}

		}

		return borrado;
	}

	public String mostarAPartir(int pos) {

		StringBuilder resultado = new StringBuilder();
		Iterator<Integer> itr = listaNumeros.iterator();
		Integer numero;

		int contador = 1;

		resultado.append("( ");

		while (itr.hasNext()) {

			numero = itr.next();
			
			if (contador >= pos) {

				resultado.append(numero + " ");

			}
			contador++;
		}

		resultado.append(")");

		return resultado.toString();

	}

	public String ordenInverso() {

		StringBuilder resultado = new StringBuilder();
		Iterator<Integer> itr = listaNumeros.iterator();
		darVuelta(itr, resultado);

		return resultado.toString();
	}

	private void darVuelta(Iterator<Integer> itr, StringBuilder resultado) {

		if (itr.hasNext()) {
			
			int o = itr.next();
			
			darVuelta(itr, resultado);
			resultado.append(o + " ");
			
		}

	}

	public void concatenarListas(ListaDeNumeros otraLista) {

	}

	public String toString() {

		StringBuilder resultado = new StringBuilder();
		Iterator<Integer> itr = listaNumeros.iterator();
		Integer numero;

		resultado.append("( ");

		while (itr.hasNext()) {

			numero = itr.next();

			resultado.append(numero + " ");

		}

		resultado.append(")");

		return resultado.toString();
	}

}
