package Clases;

public class Palabra {

	private String palabra;
	private String traduccion;

	public Palabra(String palabra, String traduccion) {
		this.palabra = palabra.toUpperCase();
		setTraduccion(traduccion);
	}

	public void setTraduccion(String traduccion) {
		this.traduccion = traduccion.toUpperCase();
	}

	public String getPalabra() {
		return palabra;
	}

	public String getTraduccion() {
		return traduccion;
	}

	public String toString() {
		return palabra + " : " + traduccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((palabra == null) ? 0 : palabra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Palabra))
			return false;
		Palabra other = (Palabra) obj;
		if (palabra == null) {
			if (other.palabra != null)
				return false;
		} else if (!palabra.equals(other.palabra))
			return false;
		return true;
	}

	public int compareTo(Palabra otra) {
		return palabra.compareTo(otra.palabra);
	}

}