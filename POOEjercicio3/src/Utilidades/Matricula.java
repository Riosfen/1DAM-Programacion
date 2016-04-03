package Utilidades;

public class Matricula {

	private String matricula;
	private static final int ABECEDARIO_INICIO = 10;
	private static final int ABECEDARIO_FINAL = 35;

	// 4 numeros y 3 letras,

	public Matricula(String matricula) throws MatriculaException {
		matricula.trim().toUpperCase();
		if (!comprobarCadena(matricula))
			throw new MatriculaException("Error! matricula no válida.");
		this.matricula = matricula;
	}

	private boolean comprobarCadena(String matricula){
			
		int contador = 0;
		boolean cadenaCorrecta = true;
		
		String numeros = matricula.substring(0, 3);
		String letras = matricula.substring(4, 6);
		
		while(contador < numeros.length() && cadenaCorrecta == true){
			
			char c = numeros.charAt(contador);
			
			if (Character.getNumericValue(c) >= ABECEDARIO_INICIO && Character.getNumericValue(c) <= ABECEDARIO_FINAL){
				cadenaCorrecta = false;
			}
			contador++;	
		}
		
		contador = 0;
		
		while(contador < letras.length() && cadenaCorrecta == true){
			
			char c = letras.charAt(contador);
			
			if (Character.isDigit(c)){
				cadenaCorrecta = false;
			}
			contador++;	
		}
		
		return cadenaCorrecta;
			
	}
	
	public String toString(){
		
		return matricula;
		
	}

}
