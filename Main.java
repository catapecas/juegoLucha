import java.util.Scanner;

/**
 * Clase principal del juego de lucha.
 * Pide los nombres de los personajes y comienza la batalla.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("       Bienvenido al Juego de Lucha");
        System.out.println("==============================================");

        // Pedir el nombre del jugador
        System.out.print("Introduce el nombre del Jugador: ");
        String nombreJugador = scanner.nextLine();

        // Pedir el nombre del enemigo
        System.out.print("Introduce el nombre del Enemigo: ");
        String nombreEnemigo = scanner.nextLine();

        // Usar la fábrica para crear los personajes (Patrón Factory Method)
        Personaje jugador = PersonajeFactory.crearPersonaje(PersonajeFactory.TIPO_JUGADOR, nombreJugador);
        Personaje enemigo = PersonajeFactory.crearPersonaje(PersonajeFactory.TIPO_ENEMIGO, nombreEnemigo);

        // Crear el juego y comenzar la pelea
        JuegoLucha juego = new JuegoLucha(jugador, enemigo);
        juego.iniciarPelea();

        scanner.close();
    }
}
