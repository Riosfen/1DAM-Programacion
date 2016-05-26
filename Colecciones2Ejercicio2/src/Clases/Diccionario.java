package Clases;

import java.util.HashMap;

public class Diccionario {

	private String nombreDiccionario;
	private HashMap<String, Idioma> cIdioma;

	public Diccionario(String nombreDiccionario) {

		this.nombreDiccionario = nombreDiccionario;
		cIdioma = new HashMap<String, Idioma>();

	}

	public void nuevoIdioma(String idioma) throws DiccionarioException {
		
		if (cIdioma.containsKey(idioma)){
			throw new DiccionarioException("Error!! ese idioma ya se encuentra en el diccionario");
		}
		
		cIdioma.put(idioma, new Idioma(idioma));
	}
	
	public Idioma obtenerIdioma(String idioma) throws DiccionarioException{
		
		Idioma resul = cIdioma.get(idioma);
		
		if (resul == null)
			throw new DiccionarioException("Error!! idioma no encontrado");
		
		return resul;
	}

	public String toString(){
		
		return "Diccionario: " + nombreDiccionario;
		
	}
	
}
