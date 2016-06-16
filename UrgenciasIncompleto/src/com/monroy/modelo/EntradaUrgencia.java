package com.monroy.modelo;

import com.monroy.hora.Hora;

public class EntradaUrgencia {

	private static int totalMinutos = 0;
	private static int pacientesAtendidos = 0;
	
	private Paciente paciente;
	private int prioridad;
	private Hora horaEntrada;
	private Hora horaSalida;
	private int minutosDeEspera; // se actualizará cuando se atienda

	public EntradaUrgencia(Paciente paciente, int prioridad) {
		super();
		this.paciente = paciente;
		this.prioridad = prioridad;
		this.horaEntrada = new Hora(); // hora del sistema
		this.horaSalida = null;

	}

	public Paciente getPaciente() {
		return paciente;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public Hora getHoraEntrada() {
		return horaEntrada;
	}

	public Hora getHoraSalida() {
		return horaSalida;
	}

	public int getMinutosDeEspera() {
		calcularMinutos();
		return minutosDeEspera;
	}

	public void setHoraSalida() {
		this.horaSalida = new Hora();
	}
	
	private void calcularMinutos() {
		this.minutosDeEspera = horaSalida.totalMinutos() - horaEntrada.totalMinutos();
		totalMinutos = totalMinutos + this.minutosDeEspera;
		pacientesAtendidos++;
	}
	
	public static String tiempoEsperaMedio() throws UrgenciaException{
		if (pacientesAtendidos == 0)
			throw new UrgenciaException("Error, no se ha atendido a ningún paciente todabia.");
			
		return "El tiempo de espera medio es de: " + totalMinutos / pacientesAtendidos;
	}

	@Override
	public String toString() {
		String cadena;

		if (horaSalida == null)
			cadena = "Paciente=" + paciente + ", prioridad=" + prioridad + ", HoraEntrada=" + horaEntrada;
		else
			cadena = "Paciente=" + paciente + ", prioridad=" + prioridad + ", HoraEntrada=" + horaEntrada
					+ ", Hora Salida=" + horaSalida + ". Minutos esperando " + minutosDeEspera;

		return cadena;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EntradaUrgencia))
			return false;
		EntradaUrgencia other = (EntradaUrgencia) obj;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}

}
