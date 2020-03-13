package com.romanalicando;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("Cantidad de anagramas hallados: " + numOfAnagrams("“hola, que buena ola laomir","OAL"));

    }

    public static int numOfAnagrams(String string, String anagram) {
        //Transformacion para soportar mayusculas y minusculas.
        String str = string.toLowerCase();
        String an = anagram.toLowerCase();
        //Verificacion de validez para poder continuar con la funcion.
        if (str == null || str.length() == 0 || str.length() < an.length())
            return -1;
        //Acumulador de coincidencias de anagrama.
        int sum = 0;
        //Mapa de caracteres y cantidad de cada uno del anagrama.
        Map<Character, Integer> anagramMap = new HashMap<>();
        for (char c : an.toCharArray()) {
            anagramMap.put(c, anagramMap.getOrDefault(c, 0) + 1);
        }

        //Cantidad de caracteres distintos del anagrama.
        int counter = an.length();

        /*
            A continuacion el String es recorrido a modo del "sliding window algorithm", tomando como referencia
            sus caracteres extremos, donde se corre la referencia "right" hasta que la variable "counter"
            indique que se han conseguido todos los caracteres del anagrama.
         */

        for (int left = 0, right = 0; right < str.length(); right++) {
            System.out.println(counter);
            char cRight = str.charAt(right);
            if (anagramMap.containsKey(cRight)) {
                anagramMap.put(cRight, anagramMap.get(cRight) - 1);
                if (anagramMap.get(cRight) == 0) {
                    counter -= 1;
                }
            }
            //Se evalua la existencia del anagrama desplazando y evaluando la referencia "left" contra "anagramMap"
            while (counter <= 0) {
                char cLeft = str.charAt(left);
                if (anagramMap.containsKey(cLeft)) {
                    anagramMap.put(cLeft, anagramMap.get(cLeft) + 1);
                    //Si counter es mayor a 0 sobra un caracter y romple el ciclo, para continuar moviendo la referencia "right".
                    if (anagramMap.get(cLeft) > 0) {
                        counter += 1;
                    }
                }
                if (right - left + 1 == an.length()) {
                    sum++;
                }
                left++;
            }

        }
        return sum;
    }
}
