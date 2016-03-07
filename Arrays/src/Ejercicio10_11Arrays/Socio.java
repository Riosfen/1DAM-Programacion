package Ejercicio10_11Arrays;

public class Socio {

	private static final int MAX_LETRA = 90;
	private static final int MIN_LETRA = 64;
	private static final int TAMANIO_DNI = 9;
	private String dni;
	private int numSocio;
	private String nombre;
	private int telefono;

	public Socio(String dni, String nombre, int telefono) throws SocioException {
		setDni(dni);
		setNombre(nombre);
		setTelefono(telefono);
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) throws SocioException {

		boolean error = false;

		dni.toLowerCase();
		dni.trim();

		if (dni.length() != TAMANIO_DNI) {
			throw new SocioException("Error, un DNI tiene que tener 9 caracteres.");
		}
		int i = 0;
		while (i < dni.length() - 1 && error == false) {
			if (!Character.isDigit(dni.charAt(i))) {
				error = true;
			}
			i++;
		}
		if (dni.charAt(dni.length() - 1) > MIN_LETRA && dni.charAt(dni.length() - 1) < MAX_LETRA && error == false) {
			error = false;
		}
		if (error)
			throw new SocioException("Error, no se ha podido validar el dni.");

		this.dni = dni;
	}
	
	public void setNumSocio(int numSocio) {
		this.numSocio = numSocio;
	}

	public int getNumSocio() {
		return numSocio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String toString(){
		return "DNI: "+ dni + ", Nombre: " + 
				nombre + ", Teléfono: " + telefono + 
				", Número de socio: " + numSocio + 
				"---------------------";
	}
	
	public boolean equals(Socio socio){
		
		boolean resultado = false;
		
		if(dni.equals(socio.dni)){
			resultado = true;
		}
		
		return resultado;
	}
	
}
