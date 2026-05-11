/**
 * Clase que implementa el patrón de diseño Factory Method.
 * Se encarga de crear objetos de tipo Jugador o Enemigo
 * sin que el código principal necesite conocer cómo se crean.
 */
public class PersonajeFactory {

    // Constantes para identificar el tipo de personaje a crear
    public static final String TIPO_JUGADOR = "jugador";
    public static final String TIPO_ENEMIGO = "enemigo";

    /**
     * Método fábrica que crea y retorna un personaje según el tipo indicado.
     *
     * @param tipo    El tipo de personaje: "jugador" o "enemigo".
     * @param nombre  El nombre del personaje.
     * @return Un objeto de tipo Personaje (Jugador o Enemigo).
     */
    public static Personaje crearPersonaje(String tipo, String nombre) {
        if (tipo.equalsIgnoreCase(TIPO_JUGADOR)) {
            // Crea un jugador con el nombre dado
            return new Jugador(nombre);
        } else if (tipo.equalsIgnoreCase(TIPO_ENEMIGO)) {
            // Crea un enemigo con tipo "Oscuro" y 50 puntos de recompensa por defecto
            return new Enemigo(nombre, "Oscuro", 50);
        } else {
            // Si el tipo no es válido, lanza un error
            throw new IllegalArgumentException("Tipo de personaje no reconocido: " + tipo);
        }
    }
}
