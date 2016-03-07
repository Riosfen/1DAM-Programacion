package Ejercicio9Arrays;

public class Refran {
	
	private String refran;
	
	public Refran(String refran) throws RefranException{
		
		setRefran(refran);
		
	}

	public void setRefran(String refran) throws RefranException {

		if(refran == null)
			throw new RefranException("Error, no se puede guardar un refran vacío.");
		
		this.refran = refran.trim().toLowerCase();
		
	}
	
	public String getRefran(){
		return refran;
	}
	
	public String toString(){
		
		return refran;
		
	}
	
	public boolean equals(Refran refran){
		
		boolean resultado = false;
		
		if(this.refran.equals(refran)){
			resultado = true;
		}
		
		return resultado;
		
	}

}
