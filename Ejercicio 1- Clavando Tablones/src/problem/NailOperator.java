package problem;

public class NailOperator {

    private PlankOperator plankOperator;
     
    Integer[] nails = null;
    Integer clavosUtilizados = 0;
    /**
     * Clase responsable de la ejecucion y resolucion final del problema. 
     * Contiene la logica responsable de operar los clavos.
     * @param plankOperator
     * @param nails 
     */
    public NailOperator(PlankOperator plankOperator, Integer[] nails) {
        this.plankOperator = plankOperator;
        this.nails = nails;
    }
    /*
    La logica fundamental del programa se encuentra en el metodo run.
    El método manipula los clavos y evalua si fueron efectivos,
    en caso de poder clavar continua aumentando la secuencia de clavos usados,
    si en alguna iteracion fue imposible clavar alguna tabla la cuenta de 
    tablas usadas secuencialmente es reiniciado, al igual que el estado de las tablas.
    */
    public int run() {   
        int nailsUsed = 0;
        for (int nail : nails) {
            boolean canItNail = plankOperator.canItNail(nail);
            if (canItNail) {
                nailsUsed++;
                if (plankOperator.isDone()) {
                    return nailsUsed;
                }
            }
            else {
                nailsUsed = 0;
                plankOperator.reset();
            }
        }
        return -1;
    }    
}
