package it.unimi.di.prog2.e18;

import java.util.ArrayList;

public class AstronomicalSystem {
    private final ArrayList<CelestialBody> celestialBodies;

    public AstronomicalSystem(ArrayList<CelestialBody> bodies) {
        this.celestialBodies = bodies;
    }

    public void add(CelestialBody body) {
        celestialBodies.add(body);
    }

    public void updateSystem() {
        for (CelestialBody body : celestialBodies) {
            if (body instanceof Planet) {
                Planet planet = (Planet) body;
                for (CelestialBody otherBody : celestialBodies) {
                    if (otherBody != body) {
                        planet.updatePlanet(planet, otherBody);
                    }
                }
            }
        }
    }

    public int totalEnergy() {
        int totalEnergy = 0;
        for (CelestialBody body : celestialBodies) {
            totalEnergy += body.energy();
        }
        return totalEnergy;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CelestialBody body : celestialBodies) {
            sb.append(body.toString()).append("\n");
        }
        sb.append("Total Energy: ").append(totalEnergy());
        return sb.toString();
    }
}
