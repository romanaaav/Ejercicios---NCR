package problem;

import java.util.Arrays;

public class Init {
    public static void main(String[] args) {
        
        /*
        Debido a la complejidad que se presentó en el problema, se optó por 
        abordarlo con orientacion a objetos y dividirlo en clases, para luego
        asignarles responsabilidades propias para abstraer el funcionamiento, de esta
        forma se puede abordar el problema en distintas piezas menos complejas, más 
        manejables y entendibles
        */
        Integer[] a = new Integer[] {1,4,5,8};
        Integer[] b = new Integer[] {4,5,9,10};
        Integer N = 4;
        
        Integer[] c = new Integer[] {4,6,7,10,2};
        
        /*
        La clase ProblemaMaderas se encarga de determinar si los clavos sirven para
        clavar alguno de los tablones, tambien notifica si todos los tablones estan
        clavados finalmente y en caso de romperse la secuencia, puede reiniciar el
        conteo de tablas ya clavadas.
        */
        PlankOperator problemaMaderas = new NailOperatorImpl(a,b,N);
        
        /*
        ProblemaClavos mantiene la cuenta de cuantos clavos secuenciales estan siendo
        utilizados de manera secuencial, asi como tambien entregar el resultado final.
        */
        NailOperator problem = new NailOperator(
                problemaMaderas, 
                c);
        
        int cantClavosCosecutivos = problem.run();
        System.out.println(cantClavosCosecutivos);
    }
}
