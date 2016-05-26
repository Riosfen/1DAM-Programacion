package Clases;

public class Palabra implements Comparable<Palabra> {

	private String nativa;
	private String traduccion;

	public Palabra(String nativa, String traduccion) {
		this.nativa = nativa;
		setTraduccion(traduccion);
	}

	public String getNativa() {
		return nativa;
	}

	private void setTraduccion(String traduccion) {
		this.traduccion = traduccion;
	}

	public void modificarTraduccion(String traduccion) {
		setTraduccion(traduccion);
	}

	public boolean equals(Palabra otro) {
		boolean resul = false;

		if (nativa.equals(otro.nativa))
			resul = true;

		return resul;

	}

	public String toString() {
		return "\t" + nativa + " -> " + traduccion;
	}

	@Override
	public int compareTo(Palabra otro) {

		int resul;

		if (nativa.compareTo(otro.nativa) == 0)
			resul = 0;
		else {
			if (nativa.compareTo(otro.nativa) < 0)
				resul = -1;
			else
				resul = 1;
		}

		return resul;
	}

}
