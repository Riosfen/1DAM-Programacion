package Clases;

public class Pagina implements Comparable<Pagina>{

	private String nombre;
	private Fecha fecha;
	private Hora hora;
	
	public Pagina (String nombre, Fecha fecha, Hora hora){
		this.fecha = fecha;
		this.hora = hora;
		this.nombre = nombre;
	}
	
	public Fecha getFecha() {
		return fecha;
	}
	public Hora getHora() {
		return hora;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String toString(){
		return "Nombre: " + nombre + "\nFecha: " + fecha + "\nHora: " + hora;
	}
	
	public int compareTo(Pagina otro){
		int resul;
		int resFecha = fecha.compareTo(otro.fecha);
		int resHora = hora.compareTo(otro.hora);
		
		resul = resFecha;
		
		if (resul == 0){
			if (resHora > 0){
				resul = 1;
			}
			if (resHora < 0){
				resul = -1;
			}
		}
		
		return resul;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagina other = (Pagina) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
