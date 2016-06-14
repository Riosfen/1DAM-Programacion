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
	
}
