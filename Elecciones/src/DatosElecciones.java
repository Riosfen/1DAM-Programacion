import java.util.Random;

public class DatosElecciones {

	private double[][] tabla;
	private static final int PARTIDO = 4;
	private static final int PROVINCIA = 8;

	private String[] partido = { "PARTIDO A", "PARTIDO B", "PARTIDO C", "PARTIDO D" };
	private String[] provincia = { "SEVILLA", "HUELVA", "CADIZ", "MALAGA", "GRANADA", "JAEN", "ALMERIA", "CORDOBA" };

	public DatosElecciones() {

		tabla = new double[PARTIDO][PROVINCIA];
		rellenarTabla();

	}

	private void rellenarTabla() {

		Random serie = new Random();

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				tabla[i][j] = (double)serie.nextInt(300) / 100;
			}
		}

	}

	public String toString() {

		StringBuilder resultado = new StringBuilder();

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				resultado.append("[" + tabla[i][j] + "]");
			}
			resultado.append("\n");
		}

		return resultado.toString();

	}

	public String partidoMenosVotado(String provincia) throws DatosEleccionesException {

		int i = 0;
		int columna = -1;
		boolean encontrado = false;
		
		while (i < this.provincia.length && encontrado == false) {

			if (this.provincia[i].equals(provincia)){
				encontrado = true;
				columna = i;
			}
			
			i++;
		}
		
		if(columna == -1)
			throw new DatosEleccionesException("Error, esa provincia no existe.");

		int menor = 0;
		
		for (int j = 0; j < tabla.length; j++) {
			if (tabla[j][columna] < tabla[j][menor]){
				menor = j;
			}
		}
		
		return "Partido menos votado en " + this.provincia[columna] + ": " + this.partido[menor];

	}
	
	public String provinciaPartidoGanador(){
		
		StringBuilder resultado = new StringBuilder();
		
		int[] masGanado = new int[PARTIDO];
		int mayor = 0;
		
		resultado.append("Listado de provincias con partido ganador"
				+ "\n-----------------------------------------"
				+ "\n-----------------------------------------\n");
		
		for (int i = 0; i < tabla[0].length; i++) {
			for (int j = 0; j < tabla.length; j++) {
				if (tabla[j][i] > tabla[mayor][i]){
					mayor = j;
				}
			}
			masGanado[mayor]++; 
			resultado.append("\t" + provincia[i] + "\t" + partido[mayor] + "\n");
		}
		
		int ganador = 0;
		
		for (int i = 0; i < masGanado.length; i++) {
			if(masGanado[i] > masGanado[ganador]){
				ganador = i;
			}
		}
		
		resultado.append("\nPartido que ha ganado en más provincias: " + partido[ganador]);
		
		return resultado.toString();
		
	}

}
