
import java.util.Iterator;
import java.util.LinkedList;

public class ListaGenerica<T> {

	private LinkedList<T> lista;

	ListaGenerica() {

		lista = new LinkedList<T>();
	}

	public void annadirElemento(T elemento) {
		lista.add(elemento);
	}

	public ListaGenerica<T> listaHastaElemento(T elementoBuscado) {

		ListaGenerica<T> listaNueva = new ListaGenerica<T>();
		Iterator<T> itr = lista.iterator();
		T elemento;
		boolean encontrado = false;

		while (itr.hasNext() && encontrado == false) {
			elemento = itr.next();

			if (elemento.equals(elementoBuscado)) {
				encontrado = true;
			}
			
			listaNueva.annadirElemento(elemento);

		}

		if (encontrado == false)
			listaNueva = null;

		return listaNueva;
	}

	public Visualizable[] arrayElementosVisibles() throws ListaException {

		int contador = 0;
		int total = contarElementosVisibles();
		
		if (total == 0)
			throw new ListaException("Error, no hay elementos visibles");
		
		Visualizable[] visibles = new Visualizable[total];
		for(T elemento: lista){
			
			if (((Visualizable) elemento).isVisible()){
				visibles[contador] = (Visualizable) elemento;
				contador++;
			}
		}
		
		return visibles;

	}

	private int contarElementosVisibles() throws ListaException {
		int resul = 0;
		
		for (T elemento : lista) {
			
			if (elemento instanceof Visualizable) {
				if ( ((Visualizable) elemento).isVisible())
					resul++;
			}
			else {
				throw new ListaException("No es visualizable");
			}
			
		}
		
		return resul;
	}

	@Override
	public String toString() {
		return "ListaGenerica=" + lista;
	}

}
