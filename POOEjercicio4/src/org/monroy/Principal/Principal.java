package org.monroy.Principal;

import java.util.Scanner;

import org.monroy.Clases.Clerigo;
import org.monroy.Clases.Mago;
import org.monroy.Clases.Personaje;
import org.monroy.Clases.PersonajeException;
import org.monroy.Clases.Raza;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		Prueba1();
//		Prueba2();

	}

private static void Prueba2() {

	Personaje pjA = null;
	Personaje pjB = null;
	
	try {
		pjA = new Mago("Mago A", Raza.HUMANO, 10, 17, 50);
		pjB = new Mago("Mago A", Raza.HUMANO, 10, 17, 50);
	} catch (PersonajeException e) {
		System.out.println(e.getMessage());
	}
	
	if (pjA instanceof Mago) {
		Mago mago = (Mago) pjA;
		
		try {
			mago.aprendeHechizo("hola");
		} catch (PersonajeException e) {
			System.out.println(e.getMessage());
		}
		
		if (!mago.lanzaHechizo(pjB, "hola")){
			System.out.println("El pjA lanza un hechizo sobre pjB");
		}
		
	}

	System.out.println(pjB);
		
	}

private static void Prueba1() {

	Mago pjMA = null;
	Mago pjMB = null;
	Clerigo pjCC = null;
	
	Personaje[] pj = new Personaje[3];

	try {

		pj[0] = new Mago("A", Raza.HUMANO, 10, 20, 50);
		pj[1] = new Mago("B", Raza.HUMANO, 6, 18, 50);
		pj[2] = new Clerigo("C", Raza.ELFO, 20, 14, 100, "ra");
		
		System.out.println("Mostrando datos de los personajes: ");
		for (int i = 0; i < pj.length; i++) {
			System.out.println(pj[i] + "\n");
		}

	} catch (PersonajeException e) {
		System.out.println(e.getMessage());
	}

	if (pj[0] instanceof Mago) {
		pjMA = (Mago) pj[0];
	}
	
	if (pj[1] instanceof Mago) {
		pjMB = (Mago) pj[1];
	}
	
	if (pj[2] instanceof Clerigo) {
		pjCC = (Clerigo) pj[2];
	}
	
	try {
		pjMA.aprendeHechizo("bola de fuego");
		pjMA.aprendeHechizo("lanza de alma");
		
		pjMB.aprendeHechizo("inmolacion");
		
		for (int i = 0; i < pj.length; i++) {
			if (pj[i] instanceof Mago){
				System.out.println(pj[i] + "\n");
			}
		}
		
		pjMA.lanzaHechizo(pj[1], "bola de fuego");
		pjMB.lanzaHechizo(pj[0], "inmolacion");
		
		pjCC.curar(pjMB);
		
		pjMA.lanzaHechizo(pj[1], "lanza de alma");
		
		for (int i = 0; i < pj.length; i++) {
			System.out.println(pj[i] + "\n");
		}
		
	} catch (PersonajeException e) {
		System.out.println(e.getMessage());
	}
		
	}

}