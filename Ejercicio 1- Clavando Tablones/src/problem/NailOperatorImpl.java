package problem;

import java.util.ArrayList;
import java.util.List;

public class NailOperatorImpl implements PlankOperator {

    private Integer[] starts;
    private Integer[] ends;
    private Integer n;
    private List<Plank> planks;
    /**
     * Clase responsable de manejar la logica referente a los tablones, notifica la totalidad de tablas clavadas.
     * @param starts - Arreglo con los inicios de cada tablon sobre un eje coordenado.
     * @param ends   - Arreglo con los finales de cada tablon sobre un eje coordenado.
     * @param n  - Cantidad de tablones a evaluar.
     */
    public NailOperatorImpl(Integer[] starts, Integer[] ends, Integer n) {
        this.starts = starts;
        this.ends = ends;
        this.n = n;
        planks = new ArrayList<Plank>();
        
        for (int x = 0; x < n; x++) {
            planks.add(new Plank(starts[x], ends[x]));
        }
    }
    
    /**
     * Este metodo toma un clavo como parametro y evalua si puede ser clavado en alguna tabla.
     * @param nailPosition - Posicion del clavo
     * @return
     */
    @Override
    public boolean canItNail(int nailPosition) {        
        boolean couldItNail = false;
        for (Plank plank : planks) {
           if ((nailPosition >= plank.start) && (nailPosition <= plank.end)) {
               plank.nailed = true;
               couldItNail = true;
           }
        }
        return couldItNail;
    }
    
    /**
     * Este metodo notifica si la totalidad de las tablas evaluadas ya ha sido clavada.
     * @return 
     */
    @Override
    public boolean isDone() {
        int idx = -1;
        for (Plank m : planks) {
            idx++;
            System.out.println(m.nailed);
            if (m.nailed==false) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Reinicia el conteo de tablas que han sido clavadas.
     */
    @Override
    public void reset() {
        for (Plank m : planks) {
            m.nailed = false;
        }
    }
}
