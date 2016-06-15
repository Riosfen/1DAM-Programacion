package Clases;

public class PizzaPrehecha extends Pizza {

	public static final int TOTAL_PIZZAS_PREPARADAS = 20;
	private int pizzaNum;
	
	public PizzaPrehecha(Tamanio tamanio, int pizzaNum) throws PizzaException {
		super(tamanio);
		
		setPizzanum(pizzaNum);
	}

	private void setPizzanum(int pizzaNum) throws PizzaException {
		if (pizzaNum > 20 || pizzaNum < 1)
			throw new PizzaException("Error!! no ha seleccionado una pizza válida");
		
		this.pizzaNum = pizzaNum;
	}
	
	public int getPizzaNum() {
		return pizzaNum;
	}
	
	public String toString(){
		return super.toString() + "prehecha :" + " Número: " + pizzaNum + ", tamaño: " + this.getTamanio();
	}
	
}
