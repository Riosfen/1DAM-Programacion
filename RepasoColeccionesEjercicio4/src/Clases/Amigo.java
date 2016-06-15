package Clases;

public class Amigo {

	private String nombre;
	private Fecha fecha;
	private int horaAviso;
	
	public Amigo(String nombre, Fecha fecha, int horaAviso) throws AmigoException{
		this.nombre = nombre;
		this.fecha = fecha;
		setHoraAviso(horaAviso);
	}
	
	public Amigo(String nombre){
		this.nombre = nombre;
	}

	public Fecha getFecha() {
		return fecha;
	}
	
	public int getHoraAviso() {
		return horaAviso;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setHoraAviso(int horaAviso) throws AmigoException {
		if (horaAviso < 0 || horaAviso > 23)
			throw new AmigoException("Error, hora de aviso incorrecta");
		this.horaAviso = horaAviso;
	}

	public int compareTo(Amigo otro) {
		int resul = 0;
	
		resul = fecha.compareTo(otro.fecha);
		
		if (resul == 0){
			if (horaAviso > otro.horaAviso){
				resul = 1;
			}
			else{
				if (otro.horaAviso > horaAviso){
					resul = -1;
				}
			}
		}
		
		return resul;
	}
	
	public String toString(){
		return "Nombre: " + getNombre() + ", Cumpleaños: " + getFecha() + ", Aviso: " + getHoraAviso();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amigo other = (Amigo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
