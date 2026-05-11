/**
 * Clase que representa a un enemigo del juego.
 * Hereda de Personaje e incluye tipo y recompensa de experiencia.
 */
public class Enemigo extends Personaje {

    // Atributos propios del enemigo
    private String tipo;
    private int recompensaExperiencia;

    /**
     * Constructor: inicializa el enemigo con nombre, tipo y recompensa.
     * @param nombre El nombre del enemigo.
     * @param tipo El tipo de enemigo (ej: "Orco", "Mago oscuro").
     * @param recompensaExperiencia Experiencia que otorga al ser derrotado.
     */
    public Enemigo(String nombre, String tipo, int recompensaExperiencia) {
        super(nombre); // Llama al constructor de Personaje
        this.tipo = tipo;
        this.recompensaExperiencia = recompensaExperiencia;
    }

    /**
     * Retorna el tipo del enemigo.
     * @return El tipo de enemigo.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Retorna la experiencia que otorga este enemigo al ser derrotado.
     * @return Los puntos de experiencia de recompensa.
     */
    public int getRecompensaExperiencia() {
        return recompensaExperiencia;
    }
}
