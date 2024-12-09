package it.unimi.di.prog2.e18;

public class Planet extends CelestialBody {

    private Punto velocity;

    /*
     * AF(nome, pos, velocity) =  un pianeta con nome nome, posizione pos e velocità velocity.
     * IR: condizioni di celestialBody && velocity != null
    */

    /**
     * Costruisce un pianeta con il nome, la posizione specificata e la velocità iniziale.
     * 
     * @param name il nome del pianeta
     * @param x la coordinata x del pianeta
     * @param y la coordinata y del pianeta
     * @param z la coordinata z del pianeta
     * @throws IllegalArgumentException se il nome è nullo, vuoto o contiene solo spazi
     */
    public Planet(String name, int x, int y, int z) {
        super(name, x, y, z);
        this.velocity = new Punto(0, 0, 0);
    }

    /**
     * Imposta la velocità del pianeta.
     * 
     * @param x la componente x della velocità
     * @param y la componente y della velocità
     * @param z la componente z della velocità
     */
    public void setVelocity(int x, int y, int z) {
        this.velocity = new Punto(x, y, z);
    }

    /**
     * Restituisce la velocità del pianeta.
     * 
     * @return la velocità del pianeta
     */
    public Punto getVelocity() {
        return velocity;
    }

    public void updatePlanet(Planet p, CelestialBody c) {
        updateVelocity(p, c);
        updatePosition(p);
    }
    
    private void updateVelocity(Planet p, CelestialBody c) {
        Punto posP = p.getPosition();
        Punto posC = c.getPosition();
        Punto velP = p.getVelocity();
        setVelocity(velP.x() + (posP.x() < posC.x() ? 1 : -1), velP.y() + (posP.y() < posC.y() ? 1 : -1), velP.z() + (posP.z() < posC.z() ? 1 : -1));
    }
    
    private void updatePosition(Planet planet) {
        Punto pos = getPosition();
        Punto vel = getVelocity();
        setPosition(pos.x() + vel.x(), pos.y() + vel.y(), pos.z() + vel.z());
    }
    
    @Override
    public int energy() {
        return getPosition().norm() * getVelocity().norm();
    }

    @Override
    public String toString() {
        return "Planet " + getName() + " at " + getPosition() + " with velocity " + getVelocity();
    }
    
}
