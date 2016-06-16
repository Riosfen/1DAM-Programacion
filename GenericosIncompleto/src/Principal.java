import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		
		ListaGenerica<Objeto> listaGenerica=new ListaGenerica<Objeto>();
		ListaGenerica<Objeto> listaResultado;
		
		introducirDatosEnLista(listaGenerica);
		
		listaResultado=listaGenerica.listaHastaElemento(new Objeto(67,true));
		
		System.out.println(listaResultado);
		
		try {
			Visualizable[] arrayResultado = listaGenerica.arrayElementosVisibles();
			System.out.println(Arrays.toString(arrayResultado));
		} catch (ListaException e) {
			System.out.println(e.getMessage());
		}
		
		

	}

	private static void introducirDatosEnLista(ListaGenerica<Objeto> listaGenerica) {
		
		listaGenerica.annadirElemento(new Objeto(65,true));
		listaGenerica.annadirElemento(new Objeto(66,true));
		listaGenerica.annadirElemento(new Objeto(67,true));
		listaGenerica.annadirElemento(new Objeto(68,false));
		listaGenerica.annadirElemento(new Objeto(69,false));
		listaGenerica.annadirElemento(new Objeto(70,true));
	}

}
