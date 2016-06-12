package Clases;

public class Fecha implements Comparable<Fecha>{

	private int dia;
	private int mes;
	private int anio;
	
	public Fecha(int dia, int mes, int anio) throws FechaException{
		setDia(dia);
		setMes(mes);
		setAnio(anio);
		
	}

	private void setAnio(int anio) {
		this.anio = anio;
	}
	private void setMes(int mes) throws FechaException {
		if (mes < 1 || mes > 12)
			throw new FechaException("Error, mes no válido.");
		this.mes = mes;
	}
	private void setDia(int dia) throws FechaException {
		if (dia < 1 || dia > 30)
			throw new FechaException("Error, día no válido.");
		this.dia = dia;
	}
	
	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getAnio() {
		return anio;
	}
	
	private int valorFecha (){
		return (mes * 30 + dia);
	}
	
	public String toString(){
		return dia + " / " + mes + " / " + anio;
	}
	
	public int compareTo(Fecha otro){
		int resul = 0;
		
		if (anio > otro.anio){
			resul = 1;
		}
		if (anio < otro.anio){
			resul = -1;
		}
		if (anio == otro.anio){
			if (valorFecha() < otro.valorFecha()){
				resul = -1;
			}
			if (valorFecha() > otro.valorFecha()){
				resul = 1;
			}
		}
		
		return resul;
	}
	
	public boolean equals(Fecha otro){
		boolean resul = false;
		
		if (dia == otro.dia && mes == otro.mes && anio == otro.anio)
			resul = true;
		
		return resul;
	}
	
}
