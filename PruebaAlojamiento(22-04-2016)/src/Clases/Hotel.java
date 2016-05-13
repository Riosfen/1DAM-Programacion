package Clases;

public class Hotel extends Alojamiento{

	private static final int MAX_ESTRELLA = 5;
	private static final int MIN_ESTRELLA = 3;
	private int estrella;
	private int totalHabitacion;
	
	public Hotel(String nombre, String direccion, int estrella, int totalHabitacion) throws AlojamientoException {
		super(nombre, direccion);
		
		setTotalHabitacion(totalHabitacion);
		setEstrella(estrella);
		
	}
	
	public int getEstrella() {
		return estrella;
	}
	public int getTotalHabitacion() {
		return totalHabitacion;
	}

	private void setEstrella(int estrella) throws AlojamientoException {
		
		if (estrella < MIN_ESTRELLA || estrella > MAX_ESTRELLA)
			throw new AlojamientoException("Error!! número estrellas no válido.");
		
		this.estrella = estrella;
		
	}

	private void setTotalHabitacion(int totalHabitacion) throws AlojamientoException {
		
		if (totalHabitacion < 0)
			throw new AlojamientoException("Error!! número de habitaciones no válido.");
		
		this.totalHabitacion = totalHabitacion;
	}

	@Override
	public double calcularPrecio(int numeronoche, Temporada tipo) {

		int pEstrella = 0;
		double porcentaje = 0;
		
		switch(estrella){
		case 3:
			pEstrella = TRES_ESTRELLA;
			break;
		case 4:
			pEstrella = CUATRO_ESTRELLA;
			break;
		case 5:
			pEstrella = CINCO_ESTRELLA;
			break;
		}
		
		switch(tipo){
		case BAJA:
			porcentaje = 1;
			break;
		case MEDIA:
			porcentaje = 1.10;
			break;
		case ALTA:
			porcentaje = 1.20;
			break;
		}
		
		return numeronoche*pEstrella*porcentaje;
	}	
	
	public String toString(){
		return "Hotel: " + super.toString() + "\nNúmero de habitaciones: " + totalHabitacion + ", " + estrella + " Estrella/s";
	}
	
}
