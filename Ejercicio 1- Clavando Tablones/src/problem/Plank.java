package problem;

public class Plank {
    public final Integer start;
    public final Integer end;
    public boolean nailed;
    /**
     * La clase madera representa un objeto modelo para almacenar y trabajar de manera mas dinamica
     * los arreglos inicio - fin de los tablones.
     * @param start - Inicio de tablon.
     * @param end  - Fin de tablon.
     */
    
    public Plank(Integer start, Integer end) {
        this.start = start;
        this.end = end;
        nailed = false;
    }

    @Override
    public String toString() {
        return "Plank{" + "start=" + start + ", end=" + end + ", clavada=" + nailed + '}';
    }
    
}
