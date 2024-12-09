package it.unimi.di.prog2.e18;

public class Star extends CelestialBody {

    /*
     * AF(nome, pos) =  una stella con nome nome e posizione pos
     * IR: condizioni di celestialBody
    */

    /**
     * Costruisce una stella con il nome e la posizione specificati.
     * 
     */
    public Star(String name, int x, int y, int z) {
        super(name, x, y, z);
    }

    @Override
    public int energy() {
        return 0;
    }

    @Override
    public String toString() {
        return "Stella " + getName() + " in posizione " + getPosition();
    }

}
