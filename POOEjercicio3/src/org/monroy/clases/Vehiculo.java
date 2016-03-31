package org.monroy.clases;

public abstract class Vehiculo {
	
	protected GamaVehiculo gamaVehiculo;
	protected TipoCombustible tipoCombustible;
	protected String matricula;
	
	public abstract double calcularPrecio();

}
