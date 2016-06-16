
public class Objeto implements Visualizable{

	private int identificador;
	private boolean visible;
	public Objeto(int identificador, boolean visible) {
		super();
		this.identificador = identificador;
		this.visible = visible;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	@Override
	public String toString() {
		return "[" + (char) identificador + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identificador;
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
		Objeto other = (Objeto) obj;
		if (identificador != other.identificador)
			return false;
		return true;
	}
	
	
	
	
}
