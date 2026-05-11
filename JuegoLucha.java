/**
 * Clase que controla el flujo del juego de lucha.
 * Se encarga de manejar los turnos y determinar el ganador.
 */
public class JuegoLucha {

    // Los dos personajes que participan en la batalla
    private Personaje jugador1;
    private Personaje jugador2;

    /**
     * Constructor: recibe los dos personajes que pelearán.
     * @param jugador1 El primer personaje.
     * @param jugador2 El segundo personaje.
     */
    public JuegoLucha(Personaje jugador1, Personaje jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    /**
     * Inicia la pelea y controla el flujo por turnos.
     * El juego continúa hasta que uno de los personajes llegue a 0 HP.
     */
    public void iniciarPelea() {
        System.out.println("==============================================");
        System.out.println("  La pelea comienza entre " + jugador1.getNombre()
                + " y " + jugador2.getNombre() + "!");
        System.out.println("==============================================");

        // Bucle principal: continúa mientras ambos estén vivos
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            // Turno del jugador 1
            turno(jugador1, jugador2);

            // Solo ataca el jugador 2 si el jugador 1 sigue vivo después del turno
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
        }

        // Mostrar el resultado final de la pelea
        mostrarGanador();
    }

    /**
     * Ejecuta un turno de ataque: el atacante ataca al defensor.
     * @param atacante El personaje que ataca.
     * @param defensor El personaje que recibe el ataque.
     */
    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("----------------------------------------------");
        System.out.println("Turno de " + atacante.getNombre()
                + " | HP de " + defensor.getNombre() + ": " + defensor.getPuntosDeVida());
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene "
                + defensor.getPuntosDeVida() + " puntos de vida.");
    }

    /**
     * Muestra el ganador de la pelea al finalizar.
     */
    private void mostrarGanador() {
        System.out.println("==============================================");
        if (jugador1.estaVivo()) {
            System.out.println("  ¡" + jugador1.getNombre() + " ha ganado la pelea!");

            // Si el ganador es un Jugador, gana experiencia
            if (jugador1 instanceof Jugador && jugador2 instanceof Enemigo) {
                Jugador ganador = (Jugador) jugador1;
                Enemigo perdedor = (Enemigo) jugador2;
                ganador.ganarExperiencia(perdedor.getRecompensaExperiencia());
            }
        } else {
            System.out.println("  ¡" + jugador2.getNombre() + " ha ganado la pelea!");

            // Si el ganador es un Jugador, gana experiencia
            if (jugador2 instanceof Jugador && jugador1 instanceof Enemigo) {
                Jugador ganador = (Jugador) jugador2;
                Enemigo perdedor = (Enemigo) jugador1;
                ganador.ganarExperiencia(perdedor.getRecompensaExperiencia());
            }
        }
        System.out.println("==============================================");
    }
}
