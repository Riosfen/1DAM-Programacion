package org.monroy.clases;

public abstract class Vehiculo {

	private static final int GAMA_ALTA = 50;
	private static final int GAMA_MEDIA = 40;
	private static final int GAMA_BAJA = 30;
	
	protected GamaVehiculo gamaVehiculo;
	protected String matricula;
	
	public Vehiculo(GamaVehiculo gamaVehiculo, String matricula){
		
		this.gamaVehiculo = gamaVehiculo;
		this.matricula = matricula;
		
	}

	/**
	 * @return 
	 * Devuelve el precio base de la gama del vehiculo. Return (int).
	 */
	protected int precioBase() {
		
		int precioBase = 0;
		
		switch(gamaVehiculo){
		case ALTA:	precioBase = GAMA_ALTA;
			break;
		case MEDIA:	precioBase = GAMA_MEDIA;
			break;
		case BAJA:	precioBase = GAMA_BAJA;
			break;
		}
		
		return precioBase;
		
	}
	
	public abstract double calcularPrecio();

}
