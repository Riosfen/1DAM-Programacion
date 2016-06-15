package Clases;

public class Socio {

	public String dni;
	public String nombre;
	public String telefono;
	
	public Socio(String dni, String nombre, String telefono){
		
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Socio))
			return false;
		Socio other = (Socio) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	
	
}
