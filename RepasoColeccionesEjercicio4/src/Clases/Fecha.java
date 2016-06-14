package Clases;

public class Fecha implements Comparable<Fecha> {

	private int mes;
	private int dia;
	
	public Fecha(int mes, int dia) throws FechaException{
		setMes(mes);
		setDia(dia);
	}

	public int getDia() {
		return dia;
	}
	
	public int getMes() {
		return mes;
	}
	
	private void setDia(int dia) throws FechaException {
		if (dia < 1 || dia > 30)
			throw new FechaException("Error, día no válido.");
		
		this.dia = dia;
	}

	private void setMes(int mes) throws FechaException {
		if (mes < 1 || mes > 312)
			throw new FechaException("Error, mes no válido.");
		
		this.mes = mes;
	}
	
	public String toString(){
		return dia + "/" + mes;
	}
	
	public boolean equals(Object o){
		boolean resul = false;
		
		Fecha otro = (Fecha) o;
		
		if (mes == otro.mes && dia == otro.dia){
			resul = true;
		}
		return resul;
	}

	@Override
	public int compareTo(Fecha o) {
		int resul = 0;
		
		if (dia + (mes - 1) * 60 < o.dia + (o.mes - 1) * 60){
			resul = -1;
		}
		if (dia + (mes - 1) * 60 > o.dia + (o.mes - 1) * 60){
			resul = 1;
		}
		
		return resul;
	}
	
}
