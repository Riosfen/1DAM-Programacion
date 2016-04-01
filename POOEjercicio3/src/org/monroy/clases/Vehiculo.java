package org.monroy.clases;

public abstract class Vehiculo {

	private static final int GAMA_ALTA = 50;
	private static final int GAMA_MEDIA = 40;
	private static final int GAMA_BAJA = 30;

	private static final double GASOLINA = 3.5;
	private static final double DIESSEL = 2;
	
	protected int numeroDias;
	protected double combustible;
	protected int precioBase;
	protected GamaVehiculo gamaVehiculo;
	protected TipoCombustible tipoCombustible;
	protected String matricula;
	
	public Vehiculo(GamaVehiculo gamaVehiculo, TipoCombustible tipoCombustible){
		
		this.gamaVehiculo = gamaVehiculo;
		this.tipoCombustible = tipoCombustible;
		
		
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
		
		switch(tipoCombustible){
		case GASOLINA:	combustible = GASOLINA;
			break;
		case DIESSEL:	combustible = DIESSEL;
			break;
		default:	System.out.println("Error! probablemente sea debido a que se ha agregado un tipo de carburante nuevo, contacte con el programador.");
			break;
		}
		
	}
	
	public abstract double calcularPrecio();

}
