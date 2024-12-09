package it.unimi.di.prog2.e18;

/**
 * Rappresenta un corpo celeste. Può essere una stella o un pianeta.
 * Ogni corpo celeste ha un nome, una posizione e una velocità e un'energia.
 */
public abstract class CelestialBody {
    private final String nome;
    private Punto pos;

    /*
     * AF(nome, pos) =  un corpo celeste con nome nome e posizione pos
     * IR: nome != null, stringa vuota e soli spazi && pos != null
    */

    /**
     * Costruisce un corpo celeste con il nome e la posizione specificati.
     * 
     * @param nome il nome del corpo celeste
     * @param x la coordinata x del corpo celeste
     * @param y la coordinata y del corpo celeste
     * @param z la coordinata z del corpo celeste
     * @throws IllegalArgumentException se il nome è nullo, vuoto o contiene solo spazi
     */
    protected CelestialBody(String nome, int x, int y, int z) {
        if (nome == null || nome.isBlank() || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Il nome non può essere nullo o vuoto");
        }
        this.nome = nome;
        this.pos = new Punto(x, y, z);
    }

    /**
     * Restituisce il nome del corpo celeste.
     * 
     * @return nome del corpo celeste.
     */
    public String getName() {
        return nome;
    }
    
    /**
     * Restituisce la posizione del corpo celeste.
     * 
     * @return la posizione del corpo celeste
     */
    public Punto getPosition() {
        return pos;
    }

    /**
     * Imposta la posizione del corpo celeste.
     * @param x la coordinata x
     * @param y la coordinata y
     * @param z la coordinata z
     */
    public void setPosition(int x, int y, int z) {
        this.pos = new Punto(x, y, z);
    }

    /**
     * Ritorna l'energia totale del corpo celeste. L'energia totale è data dal prodotto 
     * dell'energia potenziale e cinetica.
     * @return intero che rappresenta l'energia totale del corpo celeste
     */
    public abstract int energy();

    @Override
    public String toString() {
        return "CelestialBody, name: " + nome + ", pos: " + pos;
    }
}
