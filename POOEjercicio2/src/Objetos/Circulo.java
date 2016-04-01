package Objetos;

import ClaseAbstracta.Figura;
import Exceptions.DatoIncorrectoException;

public class Circulo extends Figura{

	private double radio;
	
	public Circulo(int x, int y, int radio) {
		super(x,y);
		
		this.radio = radio;
		
	}
	
	public double area() {
		double area = 0;
		
		area = Math.PI * Math.pow(radio, 2);
		
		return area;
	}

	@Override
	public String toString() {
		return "Circulo-> Radio: " + radio ;
	}

}
