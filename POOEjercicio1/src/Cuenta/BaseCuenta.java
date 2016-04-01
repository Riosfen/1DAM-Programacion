package Cuenta;

public abstract class BaseCuenta {
	
	private double saldo;
	
	abstract void sacar(double dinero);
	abstract void ingresar(double dinero);
	abstract int getSaldo();
	
}
