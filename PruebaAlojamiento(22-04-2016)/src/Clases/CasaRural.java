package Clases;

import javax.print.attribute.standard.Media;

public class CasaRural extends Alojamiento {

	private boolean piscina;
	private int metros2;
	
	public CasaRural(String nombre, String direccion, boolean piscina, int metros2) throws AlojamientoException {
		super(nombre, direccion);

		this.piscina = piscina;
		setMetros2(metros2);
		
	}
	
	public int getMetros2() {
		return metros2;
	}
	
	public boolean isPiscina() {
		return piscina;
	}
	
	private void setMetros2(int metros2) throws AlojamientoException {

		if (metros2 < 0)
			throw new AlojamientoException("Error!! los metros cuadrados no puedens ser negativos.");
		this.metros2 = metros2;
	}

	@Override
	public double calcularPrecio(int numeronoche, Temporada tipo) {

		double porcentaje = 0;
		
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
		
		return numeronoche*metros2*porcentaje*0.75;
	}
	
	public String toString(){
		
		String hayPiscina = null;
		
		if (piscina){
			hayPiscina = "SI";
		}else{
			hayPiscina = "NO";
		}
		
		return "Casa rural: " + super.toString() + "\nMetros cuadrados: " + metros2 + "\nPiscina: " + hayPiscina;
	}
	
}
