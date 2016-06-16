package com.monroy.hora;

import java.util.Calendar;

public class Hora {
	private int hora;
	private int minutos;
	private Calendar cal ;
	
	// Este constructor devuelve la hora del sistema
	public Hora () {
		cal= Calendar.getInstance();
		minutos=cal.get(Calendar.MINUTE);
		hora=cal.get(Calendar.HOUR);
	}
	
	public Hora (int hora, int minutos) throws HoraException{
		setHora(hora);
		setMinutos(minutos);
	}

	

	
	
	public int getHora(){
		return this.hora;
	}
	
	public int getMinutos(){
		return this.minutos;
	}
	
	private void setMinutos(int minutos) throws HoraException {
		if ( minutos<0 || minutos > 60)
			throw new HoraException("Minutos incorrectos");
		this.minutos=minutos;
		
	}

	private void setHora(int hora) throws HoraException {
		
		if ( hora<0 || hora > 23)
			throw new HoraException("Hora incorrecta");
		this.hora=hora;
	}
	
	public int totalMinutos(){
		return this.hora*60+this.minutos;
	}
	
	
	public String toString(){
		String cadena;
		String cadenaMinutos;
		if ( minutos < 10)
			cadenaMinutos="0" + minutos;
		else
			cadenaMinutos="" + minutos;
		cadena= hora + ":" +  cadenaMinutos;
		
		return cadena;
	}
}
