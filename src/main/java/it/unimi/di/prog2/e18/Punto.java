package it.unimi.di.prog2.e18;

/**
 * Rappresenta un punto nello spazio tridimensionale.
 * Ogni punto ha tre coordinate intere ed è immutabile.
 * @param x la coordinata x
 * @param y la coordinata y
 * @param z la coordinata z
 */
public record Punto(int x, int y, int z) {
    /**
     * Restituisce la normalizzazione del punto.
     * @return la normalizzazione del punto
     */
    public int norm() {
        return Math.abs(x) + Math.abs(y) + Math.abs(z);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
