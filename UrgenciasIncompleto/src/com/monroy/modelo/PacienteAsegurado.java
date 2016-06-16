package com.monroy.modelo;

public class PacienteAsegurado  extends Paciente{
	
	private String aseguradora;
	
	public PacienteAsegurado(String dni, String nombre, String aseguradora){
		super(dni, nombre);
		this.aseguradora = aseguradora;
	}
	
	public String getAseguradora() {
		return aseguradora;
	}
	
}
