package com.monroy.modelo;

import java.util.Iterator;
import java.util.LinkedList;

public class Urgencias {
	private LinkedList<EntradaUrgencia> listaUrgencias;
	
	public Urgencias(){
		listaUrgencias = new LinkedList<EntradaUrgencia>();
	}
	
	public void nuevaUrgencia(Paciente paciente, int prioridad) throws UrgenciaException{
		EntradaUrgencia ur = new EntradaUrgencia(paciente, prioridad);
		if (listaUrgencias.contains(ur))
			throw new UrgenciaException("Error, esa urgencia ya esta en proceso");
		
		listaUrgencias.add(encontrarPos(ur), ur);
		
	}

	private int encontrarPos(EntradaUrgencia ur) {
		int resul = 0;
		Iterator<EntradaUrgencia> it = listaUrgencias.iterator();
		EntradaUrgencia otro;
		boolean encontrado = false;
		
		while (it.hasNext() && encontrado == false) {
			otro = it.next();
			
			if (otro.getPrioridad() > ur.getPrioridad()){
				encontrado = true;
			}else{
				resul++;
			}
			
		}
		
		return resul;
	}
	
	public String listadoPacientesUrgencias(){
		StringBuilder resul = new StringBuilder();
		
		for (EntradaUrgencia entradaUrgencia : listaUrgencias) {
			resul.append(entradaUrgencia + "\n");
		}
		return resul.toString();
	}
	
	public String atenderPaciente() throws UrgenciaException{
		
		EntradaUrgencia ur = listaUrgencias.poll();
		
		if (ur == null)
			throw new UrgenciaException("Error, no hay pacientes esperando.");
			
		ur.setHoraSalida();
		
		return "El paciente " + ur.getPaciente().getNombre() + " con prioridad " + ur.getPrioridad() + " entró a la " + ur.getHoraEntrada() + " y fue atendido a la " + ur.getHoraSalida() + ". Esperó " + ur.getMinutosDeEspera() + " minutos.";
	}

}
