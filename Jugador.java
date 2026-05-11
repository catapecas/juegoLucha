/**
 * Clase que representa a un jugador humano.
 * Hereda de Personaje e incluye nivel y experiencia.
 */
public class Jugador extends Personaje {

    // Atributos propios del jugador
    private int nivel;
    private int experiencia;

    /**
     * Constructor: inicializa el jugador con nombre, nivel 1 y 0 de experiencia.
     * @param nombre El nombre del jugador.
     */
    public Jugador(String nombre) {
        super(nombre); // Llama al constructor de Personaje
        this.nivel = 1;
        this.experiencia = 0;
    }

    /**
     * Permite al jugador ganar puntos de experiencia al ganar una batalla.
     * @param puntos Los puntos de experiencia a ganar.
     */
    public void ganarExperiencia(int puntos) {
        this.experiencia += puntos;
        System.out.println(getNombre() + " gana " + puntos + " puntos de experiencia.");
    }

    /**
     * Retorna el nivel del jugador.
     * @return El nivel actual.
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Retorna la experiencia acumulada del jugador.
     * @return Los puntos de experiencia.
     */
    public int getExperiencia() {
        return experiencia;
    }
}
