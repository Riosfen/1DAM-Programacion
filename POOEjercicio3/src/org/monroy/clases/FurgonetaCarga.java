package org.monroy.clases;

public class FurgonetaCarga extends Vehiculo {

	private static final double ANIADIDO = 20;
	
	private double pesoMaxAutorizado;
	
	public FurgonetaCarga (String matricula, GamaVehiculo gamaVehiculo, TipoCombustible tipoCombustible, double pesoMaxAutorizado){
		super(gamaVehiculo, tipoCombustible);
		this.pesoMaxAutorizado = pesoMaxAutorizado;
		this.matricula = matricula;
		//TODO Formatear matricula si me regañan.
		
	}
	
	public double calcularPrecio() {
		
		double importePeso = ANIADIDO * pesoMaxAutorizado;
		
		return this.precioBase + this.combustible + importePeso;
	}

}
