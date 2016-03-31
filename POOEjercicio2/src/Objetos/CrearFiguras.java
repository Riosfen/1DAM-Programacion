package Objetos;

import java.util.Random;

import ClaseAbstracta.Figura;

public class CrearFiguras {

	private int longitud;
	private int longitudAleatoria = new Random().nextInt(9)+1;
	private int posicionAleatoria = new Random().nextInt(100);
	private Figura[] f;

	public CrearFiguras(int tamanio) {

		f = new Figura[tamanio];

		for (int i = 0; i < f.length; i++) {
			longitud = new Random().nextInt(3);

			if (longitud == 0) {
				crearRectangulo(i);
			}
			if (longitud == 1) {
				crearTriangulo(i);
			}
			if (longitud == 2) {
				crearCirculo(i);
			}

		}

	}

	private void crearCirculo(int i) {
		
		f[i] = new Rectangulo(posicionAleatoria, posicionAleatoria, 
				longitudAleatoria, longitudAleatoria);
		
	}

	private void crearTriangulo(int i) {
		f[i] = new Triangulo(posicionAleatoria, posicionAleatoria, 
				longitudAleatoria, longitudAleatoria);
		
	}

	private void crearRectangulo(int i) {
		f[i] = new Circulo(posicionAleatoria, posicionAleatoria, 
				longitudAleatoria);
		
	}
	
	public Figura figuraMayor(){
		
		Figura fMayor = f[0];
		
		for (int i = 0; i < f.length-1; i++) {
			if (f[i].area() < f[(i+1)].area()){
				fMayor = f[(i+1)];
			}
		}
		
		return fMayor;
		
	}
	
	public String toString(){
		
		StringBuilder resultado = new StringBuilder();
		resultado.append("\n");
		
		for (int i = 0; i < f.length; i++) {
			resultado.append(f[i].toString() + ", Área: " + f[i].area() + "\n");
		}
		
		return resultado.toString();
	}

}
