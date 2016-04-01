package org.monroy.clases;

public abstract class Vehiculo {

	private static final int GAMA_ALTA = 50;
	private static final int GAMA_MEDIA = 40;
	private static final int GAMA_BAJA = 30;
	
	protected int precioBase;
	protected GamaVehiculo gamaVehiculo;
	protected TipoCombustible tipoCombustible;
	protected String matricula;
	
	public Vehiculo(GamaVehiculo gamaVehiculo, String matricula){
		
		this.gamaVehiculo = gamaVehiculo;
		this.tipoCombustible = tipoCombustible;
		this.matricula = matricula;
		
		
		switch(gamaVehiculo){
		case ALTA:	precioBase = GAMA_ALTA;
			break;
		case MEDIA:	precioBase = GAMA_MEDIA;
			break;
		case BAJA:	precioBase = GAMA_BAJA;
			break;
		default:	System.out.println("Error! probablemente sea debido a que se ha agregado un vehiculo nuevo, contacte con el programador.");
			break;
		}
		
	}
	
	public abstract double calcularPrecio();

}
