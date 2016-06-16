package com.monroy.principal;

import java.util.Scanner;
import com.monroy.hora.*;
import com.monroy.modelo.*;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opc = 0;
		Urgencias urgencias = new Urgencias();
		Pacientes pacientes = new Pacientes();
		
		cargarPacientes(pacientes);
		
		System.out.println("Son las " + new Hora());
		
		do {
			try {
				
				opc = mostrarMenu();
				tratarMenu(opc, urgencias, pacientes);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (opc != 6);

	}

	private static void cargarPacientes(Pacientes pacientes) {
		pacientes.addPaciente(new Paciente("11", "Pepe Perez"));
		pacientes.addPaciente(new Paciente("22", "Pepa Perez"));
		pacientes.addPaciente(new Paciente("33", "Pepito Perez"));
		pacientes.addPaciente(new Paciente("44", "Pepita Perez"));
		
		pacientes.addPaciente(new PacienteAsegurado("55", "Manuel Lopez", "ADESLAS"));
		pacientes.addPaciente(new PacienteAsegurado("66", "Ana Lopez", "ADESLAS"));
		
		pacientes.addPaciente(new PacienteAsegurado("77", "Juan Garcia", "SANITAS"));
		pacientes.addPaciente(new PacienteAsegurado("88", "Rosa Garcia", "SANITAS"));
		pacientes.addPaciente(new PacienteAsegurado("99", "Ana Garcia", "SANITAS"));
		

		
	}

	private static void tratarMenu(int opc, Urgencias urgencias, Pacientes pacientes) throws UrgenciaException {
		String aseguradora;
		Paciente p;
		String dni;
		int prioridad;
		
		switch (opc) {
		
		case 1: // listado de pacientes de una aseguradora
			aseguradora=solicitarAseguradora();
			System.out.println(pacientes.listadoPacientesAseguradora(aseguradora));
			break;

		
		case 2: // nueva Entrada en urgencias
			dni = solicitarDni();
			prioridad = solicitarPrioridad();
			p = pacientes.buscarPaciente(dni);
			
			if (p != null){
				urgencias.nuevaUrgencia(p, prioridad);
			}else{
				p = new Paciente(dni, solicitarNombre());
				pacientes.addPaciente(p);
				urgencias.nuevaUrgencia(p, prioridad);
			}
				
			break;

		case 3: // Atender paciente de urgencias

			System.out.println(urgencias.atenderPaciente());
			
			break;

		case 4: // tiempo medio

			System.out.println(EntradaUrgencia.tiempoEsperaMedio());
			
			break;

		case 5: // listado de pacientes esperando en urgencias

			System.out.println(urgencias.listadoPacientesUrgencias());
			
			break;
		
		
			
		}
	}

	

	private static String solicitarDni() {
		String cadena;
		System.out.println("Introduce el DNI del paciente:");
		cadena = teclado.nextLine().toUpperCase();

		return cadena;
	}

	private static int solicitarPrioridad() {

		int prioridad;

		System.out.println("Introduce la prioridad (1-5): ");
		prioridad = Integer.parseInt(teclado.nextLine());

		return prioridad;

	}
	
	private static String solicitarAseguradora() {
		String cadena;
		System.out.println("Introduce el nombre de la compannia aseguradora: ");
		cadena = teclado.nextLine().toUpperCase();

		return cadena;
	}

	private static String solicitarNombre() {
		String cadena;
		System.out.println("Introduce el nombre del paciente: ");
		cadena = teclado.nextLine().toUpperCase();

		return cadena;
	}

	private static int mostrarMenu() {

		int opc;
		do {
			System.out.println("1.Mostrar listado de pacientes de una Aseguradora");
			System.out.println("2.Nueva entrada en urgencias ");
			System.out.println("3.Atender paciente de urgencias");
			System.out.println("4.Mostrar tiempo de espera medio");
			System.out.println("5.Mostrar listado de pacientes esperando en Urgencias");
			System.out.println("6.Salir \nIntroduce opcion:");
			opc = Integer.parseInt(teclado.nextLine());

		} while (opc < 1 || opc > 6);
		return opc;

	}

}
