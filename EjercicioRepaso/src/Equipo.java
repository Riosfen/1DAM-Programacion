import java.util.ArrayList;

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
	
	public void aniadirAlumno(Alumno alum){
		
		for (Alumno alumno : grupo) {
			
			if (!(alum.equals(alumno))){
				grupo.add(alum);
			}
			
		}
		
	}
	
	public void borrarAlumno(Alumno alum){
		
		for (Alumno alumno : grupo) {
			
			if (alum.equals(alumno)){
				grupo.remove(alumno);
			}
			
		}
		
	}
	
	public boolean perteneceEquipo(Alumno alum){
		
		boolean resul = false;
		
		for (Alumno alumno : grupo) {
			
			if (alumno.getNombre().equals(alum.getNombre()))
				resul = true;
				
		}
		return resul;
		
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
			
			if (alumno.equals(buscarAlumno(otro)))
				equipoResul.grupo.add(alumno);
		}
		
		return equipoResul;
		
	}
	
	private Alumno buscarAlumno(Equipo otro) {

		Alumno resul;
		
		for (Alumno alumno : otro.grupo) {
			
		}
		
		return null;
	}

	public boolean equals(Equipo otro){
		
		boolean resul = false;
		
		if (nombreEquipo.equals(otro.nombreEquipo))
			resul = true;
		
		return resul;
		
	}
	
}
