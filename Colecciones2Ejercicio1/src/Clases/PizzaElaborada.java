package Clases;

public class PizzaElaborada extends Pizza {

	private static final int MAX_PIZZA = 20;
	private static final int MIN_PIZZA = 1;
	
	private int numPizza;
	
	public PizzaElaborada(Tamanio tamanio, int numPizza) throws PizzaException {
		super(tamanio);
		setNumPizza(numPizza);
	}

	private void setNumPizza(int numPizza) throws PizzaException {
		if (numPizza > MAX_PIZZA || numPizza < MIN_PIZZA)
			throw new PizzaException("Error! esa pizza no existe.");
		
		this.numPizza = numPizza;
	}
	
	public int getNumPizza() {
		return numPizza;
	}

	public String toString(){
		return super.toString() + ", Numero de pizza: " + numPizza;
	}
	
}
