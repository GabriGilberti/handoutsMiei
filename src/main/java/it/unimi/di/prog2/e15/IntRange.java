package it.unimi.di.prog2.e15;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Classe mutabile che rappresenta un intervallo di interi, con limite superiore, inferiore e passo modificabili.
 * 
 * <p>La classe è iterabile.
 * Quando viene creato l'iteratore, se il passo è minore di zero allora il limite inferiore dell'intervallo deve essere maggiore di quello superiore.
 * Altrimenti se il passo è maggiore di zero allora il limite inferiore deve essere minore di quello superiore
 */
public class IntRange implements Iterable<Integer> {

    /** Limite inferiore dell'intervallo. */
    private int from;

    /** Limite superiore dell'intervallo.  */
    private int to;

    /** Passo */
    private int step;

    /*
     * AF(from, to, step) = intervallo numerico con limite inferiore "from", limite superiore "to" e passo "step"
     * 
     * 
     * RI:
     * step != 0
     * 
     */

    /**
     * Crea un nuovo intervallo con valori di default che parte da {@link Integer#MIN_VALUE} a {@link Integer#MAX_VALUE}.
     * Con passo 1
     */
    public IntRange() {
        this.from = Integer.MIN_VALUE;
        this.to = Integer.MAX_VALUE;
        this.step = 1;
    } 

    /**
     * Imposta il limite inferiore dell'intervallo
     * 
     * @param from limite inferiore
     */
    public void setFrom(int from) {
        this.from = from;
    }

    /**
     * Imposta il limite superiore dell'intervallo
     * 
     * @param to limite superiore
     */
    public void setTo(int to) {
        this.to = to;
    }

    /**
     * Imposta il passo dell'intervallo
     * 
     * @param step passo
     * @throws IllegalArgumentException se {@code step} è 0
     */
    public void setStep(int step) throws IllegalArgumentException {
        if (step < 1) throw new IllegalArgumentException("il passo non può essere minore di 1");
        this.step = step;
    }

    
    @Override
    public Iterator<Integer> iterator() {

        if ((step < 0 && from < to) || (step > 0 && from > to)) {
            throw new IllegalArgumentException("il passo non è compatibile con i limiti dell'intervallo");
        }

        return new Iterator<>() {

            private int current = from;
            private final int step = IntRange.this.step;
            private final int last = IntRange.this.to;

            @Override
            public boolean hasNext() {
                if (step > 0) {
                    return current < last;
                }
                return current > last;
            }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();
                final int result = current;
                if (step > 0 && current >= Integer.MAX_VALUE - step) current = Integer.MAX_VALUE;
                else if (step < 0 && current <= Integer.MIN_VALUE - step) current = Integer.MIN_VALUE;
                else current += step;
                return result;
            }
        };
       
    }
}