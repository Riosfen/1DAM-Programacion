package com.monroy.modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Pacientes {
	private HashMap<String, Paciente> mapPacientes;
	
	
	public Pacientes ( ){
		mapPacientes=new HashMap<String,Paciente>();
	}
	
	public void addPaciente( Paciente p){
		mapPacientes.put(p.getDni(), p);
	}
	
	public String listadoPacientesAseguradora(String aseguradora) throws UrgenciaException{
		StringBuilder resul = new StringBuilder();
		
		LinkedList<Paciente> listaPacientes = new LinkedList<Paciente>();
		
		for (Paciente paciente : mapPacientes.values()) {
			if (paciente instanceof PacienteAsegurado) {
				if ( ((PacienteAsegurado) paciente).getAseguradora().equals(aseguradora)){
					int sitio = colocarEnSuSitio(listaPacientes, paciente);
					listaPacientes.add(sitio, paciente);
				}
			}
		}
		
		if (listaPacientes.isEmpty())
			throw new UrgenciaException("Error, no hay pacientes con esa aseguradora.");
		
		for (Paciente paciente : listaPacientes) {
			resul.append(paciente + "\n");
		}
		
		return resul.toString();
	}

	private int colocarEnSuSitio(LinkedList<Paciente> listaPacientes, Paciente paciente) {
		int resul = 0;
		Iterator<Paciente> it = listaPacientes.iterator();
		Paciente otro;
		boolean encontrado = false;
		
		while (it.hasNext() && encontrado == false) {
			otro = it.next();
			if (otro.getNombre().compareTo(paciente.getNombre()) > 0){
				encontrado = true;
			}
			else{
				resul++;
			}
		}
		
		return resul;
	}
	
	public Paciente buscarPaciente(String dni){
		
		return mapPacientes.get(dni);
		
	}
	
}
