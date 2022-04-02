package es.unizar.eina.vv6f.practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Programa Java que, al iniciar su ejecución, solicita al usuario el nombre de un fichero de texto.
 * A continuación, si el fichero existe y se puede leer, muestra en la salida estándar una lista de
 * las letras del alfabeto español y el número de veces que dicha letra aparece en el fichero
 * introducido. En caso contrario, escribe en la salida estándar un mensaje de error de la forma
 * «El fichero 'f' no existe.», donde 'f' es el nombre de fichero introducido por el usuario.
 * 
 * No se distingue entre mayúsculas y minúsculas. La letra Ñ es una letra en español. El resto de
 * apariciones de letras voladas y caracteres con diacríticos (acentos agudos, graves, diéresis y
 * cedillas), se consideran como ocurrencias de la letra correspondiente sin diacríticos.
 */
public class Main {

    private static final String FORMATO_SALIDA_FRECUENCIAS = "%c: %7d%n";

    public static void imprimir(int[] vecSalida) {
        System.out.println();
        char letra;
        for (int i = 0; i < 27; i++) {
            if(i < 14) {
                letra = (char) ('A' + i);
            } else if(i == 14) {
                letra = 'Ñ';
            } else {
                letra = (char) ('A' + i - 1);
            }
            System.out.format(FORMATO_SALIDA_FRECUENCIAS, letra, vecSalida[i]);
        }
        System.out.println();
    }

    /**
     * Método que, al iniciar su ejecución, solicita al usuario el nombre de un fichero de texto.
     * A continuación, si el fichero existe y se puede leer, muestra en la salida estándar una lista
     * de las letras del alfabeto español y el número de veces que dicha letra aparece en el fichero
     * introducido. En caso contrario, escribe en la salida estándar un mensaje de error de la forma
     * «El fichero 'f' no existe.», donde 'f' es el nombre de fichero introducido por el usuario.
     *
     * No se distingue entre mayúsculas y minúsculas. La letra Ñ es una letra en español. El resto
     * de apariciones de letras voladas y caracteres con diacríticos (acentos agudos, graves,
     * diéresis y cedillas), se consideran como ocurrencias de la letra correspondiente sin
     * diacríticos.
     *
     * @param args
     *            no utilizado.
     */
    public static void main(String[] args) {

        System.out.print("Nombre de un fichero de texto: ");
        Scanner entradaEscaner = new Scanner(System.in); //Creación de un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine(); //Invocamos un método sobre un objeto Scanner
        File fichero = new File(entradaTeclado);

        try {
            ContadorDeLetras cont = new ContadorDeLetras(fichero);
            int[] vecFrecuencias = cont.frecuencias();
            int[] vecSalida = new int[27];

            for(int i=0; i<14; i++){
                vecSalida[i] = vecFrecuencias[i];
            }
            vecSalida[14] = vecFrecuencias[26];
            for(int i=15; i<27; i++){
                vecSalida[i] = vecFrecuencias[i-1];
            }
            imprimir(vecSalida);

        } catch (NullPointerException e) {
            System.out.println("El fichero " + fichero + " es un fichero nulo");
        } catch (FileNotFoundException fne) {
            System.out.println("El fichero " + fichero + " no existe");
        }
    }
}
