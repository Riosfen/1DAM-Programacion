package org.monroy.clases;

public class Coche extends Vehiculo {
	
	public Coche (String matricula, GamaVehiculo gamaVehiculo, TipoCombustible tipoCombustible){
		
		this.matricula = matricula;
		//TODO Formatear matricula si me regañan.
		this.gamaVehiculo = gamaVehiculo;
		this.tipoCombustible = tipoCombustible;
		
	}
	
	public double calcularPrecio() {

		double precio = 0;
		
		switch(gamaVehiculo){
		case ALTA:
			
			if(tipoCombustible == TipoCombustible.GASOLINA){
				precio = 50 + 3.5;
			}else{
				precio = 50 + 2;
			}
			break;
		case MEDIA:
			if(tipoCombustible == TipoCombustible.GASOLINA){
				precio = 40 + 3.5;
			}else{
				precio = 40 + 2;
			}
			break;
		case BAJA:
			if(tipoCombustible == TipoCombustible.GASOLINA){
				precio = 30 + 3.5;
			}else{
				precio = 30 + 2;
			}
			break;
		default:
			break;
		}
			
		
		return precio;
	}

	
	
}
