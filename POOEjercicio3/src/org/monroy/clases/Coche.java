package org.monroy.clases;

public class Coche extends Vehiculo {
	
	public Coche (String matricula, GamaVehiculo gamaVehiculo, TipoCombustible tipoCombustible){
		super(gamaVehiculo, tipoCombustible);
		this.matricula = matricula;
		//TODO Formatear matricula si me regañan.
		
	}
	
	public double calcularPrecio() {
		return this.precioBase + this.combustible;
	}

	
	
}
