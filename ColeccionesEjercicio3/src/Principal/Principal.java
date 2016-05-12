package Principal;

import Clases.*;

public class Principal {

	public static void main(String[] args) {

		Historial historial = new Historial();
		
		Fecha fecha;
		try {
			
			fecha = new Fecha(1, 1, 2017, 00, 00);
			fecha2 = new Fecha(1, 12, 2016, 00, 00);
		
			Pagina aux = new Pagina("hola que pasa1", fecha);
		
			historial.introducirNombreFecha(aux);
			
		
		} catch (FechaException e) {
			System.out.println(e.getMessage());
		}

	}

}
