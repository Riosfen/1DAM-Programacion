package Clases;

import java.util.HashMap;

public class Diccionario {

	private HashMap<String, Idioma> diccionario;
	
	public Diccionario(){
		diccionario = new HashMap<String, Idioma>();
	}
	
	public void crearNuevoIdioma(Idioma idioma) throws DiccionarioExcepion{
		if (diccionario.containsKey(idioma.getIdioma()))
			throw new DiccionarioExcepion("Error, el idioma ya existe.");
		
		diccionario.put(idioma.getIdioma(), idioma);
	}
	
	public void introducirPalabraDiccionario(String idioma, Palabra palabra) throws DiccionarioExcepion{
		Idioma id;
		
		id = localizarDiccionario(idioma);
		id.introducirPalabra(palabra);
	}
	
	public String listadoPalabraIdioma(String idioma) throws DiccionarioExcepion{
		Idioma id;
		
		id = localizarDiccionario(idioma);
		return id.listarPalabras();
	}

	public void eliminarPalabraIdioma(String idioma, String palabra) throws DiccionarioExcepion{
		Idioma id;
		
		id = localizarDiccionario(idioma);
		id.eliminarPalabra(new Palabra(palabra, ""));
	}
	
	public void modificarTraducuionIdioma(String idioma,String palabra, String traduccion) throws DiccionarioExcepion{
		Idioma id;
		
		id = localizarDiccionario(idioma);
		id.modificarTraduccion(palabra, traduccion);
	}
	
	private Idioma localizarDiccionario(String idioma) throws DiccionarioExcepion {
		Idioma id;
		idioma = idioma.toUpperCase();
		id = diccionario.get(idioma);
		
		if (id == null)
			throw new DiccionarioExcepion("Error, el idioma no existe");
		
		return id;
	}
	
}
