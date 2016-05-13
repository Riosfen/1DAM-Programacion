package Clases;

public abstract class Alojamiento {

	protected static final int TRES_ESTRELLA = 30;
	protected static final int CUATRO_ESTRELLA = 55;
	protected static final int CINCO_ESTRELLA = 72;

	private String nombre;
	private String direccion;
	private int nota;
	private int totalOpiniones;

	public enum Temporada {
		ALTA, MEDIA, BAJA
	};

	public Alojamiento(String nombre, String direccion) {
		nota = 0;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	
	abstract public double calcularPrecio(int numeronoche, Temporada tipo);

	public void darNota(int nota) throws AlojamientoException {
		if (nota < 0 || nota > 10)
			throw new AlojamientoException("Error!! no nota inválida");
		totalOpiniones++;
		this.nota += nota;
	}

	public String toString() {
		Integer resultado;
		String media = null;

		if (nota == 0) {
			media = "SIN OPINIONES";
		} else {
			resultado = nota / totalOpiniones;
			media = resultado.toString();
		}

		return nombre + "\nDireccion: " + direccion + "\nMedia: " + media;
	}

	public boolean equals(Alojamiento otro) {

		boolean resultado = false;

		if (nombre.equals(otro.nombre))
			resultado = true;

		return resultado;
	}

}
