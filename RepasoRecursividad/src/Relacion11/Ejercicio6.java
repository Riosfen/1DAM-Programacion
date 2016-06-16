package Relacion11;

public class Ejercicio6 {

	public static void main(String[] args) {

		String s = "hola soy pepe";
		
		System.out.println(vuelta(s)); 
		
	}

	private static String vuelta(String s) {
		StringBuilder resul = new StringBuilder();
		vueltaRecursiva(s, resul, s.length()-1);
		
		return resul.toString();
		
	}

	private static void vueltaRecursiva(String s, StringBuilder resul, int i) {
		
		if(i >= 0){
			resul.append(s.charAt(i));
			vueltaRecursiva(s, resul, i-1);
		}
	}

}
