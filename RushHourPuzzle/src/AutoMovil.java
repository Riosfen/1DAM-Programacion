
public class AutoMovil {
	
	private int fila;
	private int columna;
	private char direccion;
	private char icono;
	private int casillas;

	public AutoMovil(int fila, int columna, int casillas, char icono, char direccion) throws AutoMovilException{
		
		if (casillas < 2 || casillas > 4)
			throw new AutoMovilException("Error, tamaño no aceptado");
			
		this.casillas = casillas;
		this.fila = fila;
		this.columna = columna;
		this.icono = icono;
		this.direccion = direccion;
		
	}
	
	public char getIcono(){
		return icono;
	}
	
	public int getCasillas(){
		return casillas;
	}
	
	public int getFila(){
		return fila;
	}
	
	public void setFila(int fila){
		this.fila = fila;
	}
	
	public int getColumna(){
		return columna;
	}
	
	public void setColumna(int columna){
		this.columna = columna;
	}
	
	public char getDireccion(){
		return direccion;
	}
	
}
