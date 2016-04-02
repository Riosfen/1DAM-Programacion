package Utilidades;

import org.monroy.clases.MatriculaException;

public class Matricula {

	private String matricula;

	// 4 numeros y 3 letras,

	public Matricula(String matricula) throws MatriculaException {
		matricula.trim().toUpperCase();
		if (!comprobarCadena(matricula))
			throw new MatriculaException("Error! matricula no válida.");
		this.matricula = matricula;
	}

	private boolean comprobarCadena(String matricula){
			
		int contador = 0;
		boolean cadenaCorrectos = true;
		
		String numeros = matricula.substring(0, 3);
		String letras = matricula.substring(4, 6);
		
		while(contador < numeros.length() && cadenaCorrectos == true){
			char c = numeros.charAt(contador);
			if (!(Character.isDigit(c))){
				cadenaCorrectos = false;
			}
			contador++;	
		}
		
		contador = 0;
		
		while(contador < letras.length() && cadenaCorrectos == true){
			char c = letras.charAt(contador);
			if (Character.isDigit(c)){
				cadenaCorrectos = false;
			}
			contador++;	
		}
		
		return cadenaCorrectos;
			
	}
	
	public String toString(){
		
		return matricula;
		
	}

}
