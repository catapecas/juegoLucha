import java.util.Random;

/**
 * Clase abstracta que representa a un personaje del juego de lucha.
 * Es la clase base de la que heredan Jugador y Enemigo.
 */
public abstract class Personaje {

    // Atributos del personaje
    private String nombre;
    private int puntosDeVida;

    // Constantes para el daño aleatorio
    private final int DANO_MINIMO = 10;
    private final int DANO_MAXIMO = 30;

    /**
     * Constructor: inicializa el personaje con nombre y 100 puntos de vida.
     * @param nombre El nombre del personaje.
     */
    public Personaje(String nombre) {
        this.nombre = nombre;
        this.puntosDeVida = 100; // Todos comienzan con 100 HP
    }

    /**
     * Ataca a otro personaje causando un daño aleatorio entre 10 y 30.
     * @param oponente El personaje que recibirá el daño.
     */
    public void atacar(Personaje oponente) {
        Random rand = new Random();
        int dano = rand.nextInt((DANO_MAXIMO - DANO_MINIMO) + 1) + DANO_MINIMO;
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre()
                + " causando " + dano + " puntos de daño.");
    }

    /**
     * Reduce los puntos de vida del personaje. No permite vida negativa.
     * @param dano La cantidad de daño a recibir.
     */
    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0; // La vida no puede ser negativa
        }
    }

    /**
     * Verifica si el personaje sigue vivo.
     * @return true si tiene puntos de vida mayores a 0.
     */
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    /**
     * Retorna el nombre del personaje.
     * @return El nombre del personaje.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Retorna los puntos de vida actuales.
     * @return Los puntos de vida del personaje.
     */
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }
}
