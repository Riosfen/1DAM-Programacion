import java.util.Scanner;

public class Principal {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		boolean terminado = false;
		
		do {

			try {

				Tablero juego = new Tablero();


				AutoMovil rojo = new AutoMovil(2, 0, 2, 'R', 'H');
				AutoMovil verde = new AutoMovil(0, 0, 2, 'V', 'V');
				AutoMovil amarillo = new AutoMovil(0, 3, 3, 'A', 'H');
				AutoMovil naranja = new AutoMovil(1, 1, 2, 'N', 'H');
				AutoMovil rosa = new AutoMovil(2, 2, 2, 'S', 'V');
				AutoMovil azul = new AutoMovil(1, 3, 2, 'Z', 'V');
				AutoMovil verdeOscuro = new AutoMovil(4, 2, 2, 'O', 'V');
				AutoMovil morado = new AutoMovil(3, 3, 2, 'M', 'H');
				AutoMovil negro = new AutoMovil(4, 3, 2, 'G', 'H');
				AutoMovil azulOscuro = new AutoMovil(5, 3, 3, 'F', 'H');
				AutoMovil verdeClarito = new AutoMovil(2, 5, 3, 'C', 'V');

				juego.colocarVehiculo(rojo);
				juego.colocarVehiculo(verde);
				juego.colocarVehiculo(amarillo);
				juego.colocarVehiculo(naranja);
				juego.colocarVehiculo(rosa);
				juego.colocarVehiculo(azul);
				juego.colocarVehiculo(verdeOscuro);
				juego.colocarVehiculo(morado);
				juego.colocarVehiculo(negro);
				juego.colocarVehiculo(azulOscuro);
				juego.colocarVehiculo(verdeClarito);

				System.out.println(juego);

				System.out.println("Vehiculo que desea mover: ");
				char opcion = teclado.nextLine().toUpperCase().charAt(0);

				int[] serie;

				switch (opcion) {

				case 'V':
					serie = mover(verde);
					juego.moverVehiculo(verde, serie[0], serie[1]);
					break;
				case 'A':
					serie = mover(amarillo);
					juego.moverVehiculo(amarillo, serie[0], serie[1]);
					break;
				case 'N':
					serie = mover(naranja);
					juego.moverVehiculo(naranja, serie[0], serie[1]);
					break;
				case 'S':
					serie = mover(rosa);
					juego.moverVehiculo(rosa, serie[0], serie[1]);
					break;
				case 'Z':
					serie = mover(azul);
					juego.moverVehiculo(azul, serie[0], serie[1]);
					break;
				case 'O':
					serie = mover(verdeOscuro);
					juego.moverVehiculo(verdeOscuro, serie[0], serie[1]);
					break;
				case 'M':
					serie = mover(morado);
					juego.moverVehiculo(morado, serie[0], serie[1]);
					break;
				case 'G':
					serie = mover(negro);
					juego.moverVehiculo(negro, serie[0], serie[1]);
					break;
				case 'F':
					serie = mover(azulOscuro);
					juego.moverVehiculo(azulOscuro, serie[0], serie[1]);
					break;
				case 'C':
					serie = mover(verdeClarito);
					juego.moverVehiculo(verdeClarito, serie[0], serie[1]);
					break;
				case 'R':
					serie = mover(rojo);
					juego.moverVehiculo(rojo, serie[0], serie[1]);
					break;

				}

			} catch (JuegoGanadoException e) {
				System.out.println(e.getMessage());
				terminado = true;
			}catch (AutoMovilException e) {
				System.out.println(e.getMessage());
			} catch (TableroException e) {
				System.out.println(e.getMessage());
			}

		} while (!terminado);

	}

	private static int[] mover(AutoMovil coche) {

		int[] xY = new int[2];

		if (coche.getDireccion() == 'H') {

			System.out.println("Números negativos para ir acia la izquierda y positivos para la derecha: ");

			int mov = Integer.parseInt(teclado.nextLine());
			xY[0] = 0;
			xY[1] = mov;
		} else {

			System.out.println("Números negativos para ir hacia arriba y positivos para hacia abajo: ");

			int mov = Integer.parseInt(teclado.nextLine());
			xY[0] = mov;
			xY[1] = 0;
		}
		return xY;

	}

}
