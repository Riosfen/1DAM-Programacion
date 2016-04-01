package org.monroy.clases;

public class Coche extends Vehiculo {
	
	private enum Combustible {GASOLINA, DIESSEL};

	private static final double GASOLINA = 3.5;
	private static final double DIESSEL = 2;
	
	private Combustible combustible;
	
	private double precioCombustible;
	
	public Coche (String matricula, GamaVehiculo gamaVehiculo, Combustible combustible){
		super(gamaVehiculo, matricula);
		this.combustible = combustible;
		//TODO Formatear matricula si me regañan.
		
	}
	
	public double calcularPrecio() {
		
		switch(combustible){
		case GASOLINA:	precioCombustible = GASOLINA;
			break;
		case DIESSEL:	precioCombustible = DIESSEL;
			break;
		default:	System.out.println("Error! probablemente sea debido a que se ha agregado un tipo de carburante nuevo, contacte con el programador.");
			break;
		}
		
		return this.precioBase + this.precioCombustible;
	}

	
	
}
