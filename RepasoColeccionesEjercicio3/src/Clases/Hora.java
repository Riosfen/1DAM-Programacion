package Clases;

public class Hora implements Comparable<Hora>{

	private int segundo;
	private int minuto;
	private int hora;
	
	public Hora (int segundo, int minuto, int hora) throws HoraException{
		setHora(hora);
		setMinuto(minuto);
		setSegundo(segundo);
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) throws HoraException {
		if (segundo < 0 || segundo > 60)
			throw new HoraException("Error, segundo incorrecto");
		
		this.segundo = segundo;
	}

	public int getMinuto() {
		return minuto;
	}

	public void setMinuto(int minuto) throws HoraException {
		if (minuto < 0 || minuto > 60)
			throw new HoraException("Error, minuto incorrecto");
		
		this.minuto = minuto;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) throws HoraException {
		if (hora < 0 || hora > 23)
			throw new HoraException("Error, hora incorrecto");
		
		this.hora = hora;
	}
	
	public String toString(){
		return hora + ":" + minuto + ":" + segundo;
	}
	
	public int compareTo(Hora otro){
		int resul = 0;
		int totalActual = ((hora * 60 + minuto) * 60 + segundo);
		int totalOtro = ((otro.hora * 60 + otro.minuto) * 60 + otro.segundo);
		
		if (totalActual > totalOtro){
			resul = 1;
		}
		if (totalActual < totalOtro){
			resul = -1;
		}
		
		return resul;
	}
	
}
