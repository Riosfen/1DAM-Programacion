package org.monroy.clases;

public class FurgonetaCarga extends Vehiculo {

	private static final double ANIADIDO = 20;
	
	private double pesoMaxAutorizado;
	
	public FurgonetaCarga (String matricula, GamaVehiculo gamaVehiculo, double pesoMaxAutorizado){
		super(gamaVehiculo, matricula);
		this.pesoMaxAutorizado = pesoMaxAutorizado;
		//TODO Formatear matricula si me regañan.
		
	}
	
	public double calcularPrecio() {
		
		double importePeso = ANIADIDO * pesoMaxAutorizado;
		
		return precioBase() + importePeso;
	}

}
