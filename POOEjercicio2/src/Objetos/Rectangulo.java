package Objetos;

import ClaseAbstracta.Figura;
import Exceptions.DatoIncorrectoException;

public class Rectangulo extends Figura{

	private double lado;
	private double lado2;

	public Rectangulo(int x, int y, int lado, int lado2){
		super(x,y);
		
		this.lado = lado;
		this.lado2 = lado2;
		
	}

	public double area() {
		double area = 0;
		
		area = lado * lado2;
		
		return area;
	}

	public String toString() {
		return "Rectangulo-> Base: " + lado + ", Altura: " + lado2;
	}

}
