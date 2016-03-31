package Objetos;

import ClaseAbstracta.Figura;
import Exceptions.DatoIncorrectoException;

public class Triangulo extends Figura{

	private double base;
	private double altura;
	
	public Triangulo(int x, int y, int base, int altura) {
		super (x,y);
		
		this.base = base;
		this.altura = altura;
		
	}
	
	public double area() {
		double area = 0;
		
		area = base * altura / 2;
		
		return area;
	}

	@Override
	public String toString() {
		return "Triangulo-> Base: " + base + ", Altura: " + altura;
	}

}