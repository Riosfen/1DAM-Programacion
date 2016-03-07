import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		DatosElecciones elecciones = new DatosElecciones();

		System.out.println(elecciones);
		
		menuPrincipal(elecciones);
		
		
	}

	private static void menuPrincipal(DatosElecciones elecciones) {
		boolean condicion = true;
		
		do {
			try {
				
				System.out.println("Introduce provincia: ");
				String provincia = teclado.nextLine().toUpperCase();
				provincia = elecciones.partidoMenosVotado(provincia);
				System.out.println(provincia);
				System.out.println(elecciones.provinciaPartidoGanador());
				condicion = false;
				
			} catch (DatosEleccionesException e) {
				System.out.println(e.getMessage());
			}
		} while (condicion);
	}

}
