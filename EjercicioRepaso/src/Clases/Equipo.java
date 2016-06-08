package Clases;
import java.util.ArrayList;
import java.util.Iterator;

public class Equipo {
	
	private String nombreEquipo;
	private ArrayList<Alumno> grupo;
	
	public Equipo(String nombreEquipo){
		this.nombreEquipo = nombreEquipo;
		grupo = new ArrayList<Alumno>();
	}
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	
	public boolean aniadirAlumno(Alumno alum){
		
		boolean resul = false;
		
		if (!(grupo.contains(alum)))
			resul = grupo.add(alum);
			
		return resul;
		
	}
	
	public boolean borrarAlumno(Alumno alum){
		
		boolean resul = false;
		
		Iterator<Alumno> itr = grupo.iterator();
		Alumno alumno;
		
		while (itr.hasNext()) {
			
			alumno = itr.next();
			
			if (alumno.equals(alum))
				resul = grupo.remove(alumno);
		}
		
		return resul;
	}
	
	public boolean perteneceEquipo(Alumno alum){
		
		return grupo.contains(alum);
		
	}
	
	public String mostrarPersonasEquipo(){
		
		StringBuilder resul = new StringBuilder();
		
		for (Alumno alumno : grupo) {
			
			resul.append(alumno + "\n");
			
		} 
		return resul.toString();
	}
	
	public Equipo unionEquipo(Equipo otro){
		
		Equipo equipoResul = new Equipo(nombreEquipo + otro.nombreEquipo);
		
		equipoResul.grupo.addAll(grupo);
		equipoResul.grupo.addAll(otro.grupo);
		
		return equipoResul;
		
	}
	
	public Equipo amboEquipo(Equipo otro){
		
		Equipo equipoResul = new Equipo(nombreEquipo + otro.nombreEquipo);
		
		for (Alumno alumno : grupo) {
			
			if (otro.grupo.contains(alumno))
				equipoResul.grupo.add(alumno);
		}
		
		return equipoResul;
		
	}

	public boolean equals(Equipo otro){
		
		boolean resul = false;
		
		if (nombreEquipo.equals(otro.nombreEquipo))
			resul = true;
		
		return resul;
		
	}
	
}
