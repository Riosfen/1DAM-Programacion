package Clases;

public class Fecha implements Comparable<Fecha> {

	private int minuto;
	private int hora;

	private int dia;
	private int mes;
	private int anno;

	public Fecha(int dia, int mes, int anno, int hora, int minuto) throws FechaException {
		setDia(dia);
		setMes(mes);
		setAnno(anno);
		setHora(hora);
		setMinuto(minuto);
	}

	private void setMinuto(int minuto) throws FechaException {
		if (minuto < 0 || minuto > 59)
			throw new FechaException("Error!! minuto incorrecto.");
	}

	private void setHora(int hora) throws FechaException {
		if (hora < 0 || hora > 23)
			throw new FechaException("Error!! hora incorrecta.");
	}

	private void setAnno(int anno) throws FechaException {
		if (anno < 2016)
			throw new FechaException("Error!! año incorrecto.");
	}

	private void setMes(int mes) throws FechaException {
		if (mes < 1 || mes > 12)
			throw new FechaException("Error!! mes incorrecto.");
	}

	private void setDia(int dia) throws FechaException {
		if (dia < 1 || dia > 30)
			throw new FechaException("Error!! día incorrecto.");
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAnno() {
		return anno;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public String toString() {
		return "Fecha: " + dia + "/" + mes + "/" + anno;
	}

	@Override
	public int compareTo(Fecha o) {

		int resultado;
		
		int hora = o.getHora();
		int minuto = o.getMinuto();
		int dia = o.getDia();
		int mes = o.getMes();
		int anno = o.getAnno();
		
		if(getHora() > hora && getMinuto() > minuto && getDia() > dia && getMes() > mes && getAnno() > anno){
			resultado = 1;
		}else{
			if(getHora() < hora && getMinuto() < minuto && getDia() < dia && getMes() < mes && getAnno() < anno){
				resultado = -1;
			}else{
				resultado = 0;
			}
		}
		
		return resultado;
	}

}
