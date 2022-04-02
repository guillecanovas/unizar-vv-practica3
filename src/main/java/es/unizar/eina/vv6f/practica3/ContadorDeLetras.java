package es.unizar.eina.vv6f.practica3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.Normalizer;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Clase para el análisis de la frecuencia de aparición de letras del alfabeto español en un
 * fichero de texto. Los objetos de esta clase se construyen utilizando como argumento un objeto de
 * la clase File que representa el fichero de texto que se quiere analizar. La primera invocación al
 * método frecuencias() analiza el contenido del fichero de texto y, si se ha podido procesar,
 * devuelve un vector de siempre 27 componentes de tipo entero. Las primeras 26 componentes
 * almacenan el número de apariciones de las 26 letras del alfabeto inglés. La última componente
 * almacena el número de apariciones de la letra Ñ.
 *
 * No se distingue entre mayúsculas y minúsculas. En español, la letra Ñ es una letra distinta a la
 * N. El resto de apariciones de letras voladas y caracteres con diacríticos (acentos agudos,
 * graves, diéresis, cedillas), se consideran como ocurrencias de la letra correspondiente sin
 * diacríticos.
 *
 */
public class ContadorDeLetras {
    private File fichero;
    private int[] frecuencias = null;

    /**
     * Construye un ContadorDeLetras para frecuencias la frecuencia en las que aparecen las letras
     * del fichero «fichero».
     *
     * @param fichero fichero de texto cuyo contenido será analizado.
     */
    public ContadorDeLetras(File fichero) {
        this.fichero = fichero;
    }

    /**
     * Si no ha sido analizado ya, analiza el contenido del fichero de texto asociado a este
     * objeto en el constructor. Devuelve un vector de 27 componentes con las frecuencias
     * absolutas de aparición de cada letra del alfabeto español en el fichero.
     *
     * @return vector de 27 componentes de tipo entero. Las primeras 26 componentes almacenan el
     * número de apariciones de las 26 letras del alfabeto inglés: la componente indexada
     * por 0 almacena el número de apariciones de la letra A, la componente indexada por 1,
     * el de la letra B y así sucesivamente. La última componente, almacena el número de
     * apariciones de la letra Ñ.
     * @throws FileNotFoundException si el fichero de texto que se especificó al construir este objeto no existe o no
     *                               puede abrirse.
     */
    public int[] frecuencias() throws FileNotFoundException {
        if (frecuencias == null) {
            frecuencias = new int[27];
            try {
                FileReader fr = new FileReader(this.fichero);
                BufferedReader br = new BufferedReader(new FileReader(this.fichero));
                String linea;
                while ((linea = br.readLine()) != null) {
                    for (int i = 0; i < linea.length(); i++) {
                        char letra = linea.charAt(i);
                        if (letra == 'Ñ') { //las tratamos aqui porque el normalize las transforma a N
                            frecuencias[26]++;
                        } else if (letra == 'ñ') { //las tratamos aqui porque el normalize las transforma a n
                            frecuencias[26]++;
                        } else if (letra == 'ª') { //el normalize no los transforma bien
                            int indice = 'a' - 'a';
                            frecuencias[indice]++;
                        } else if (letra == 'º') { //el normalize no los transforma bien
                            int indice = 'o' - 'a';
                            frecuencias[indice]++;
                        }
                    }
                    linea = linea.replace("Ñ", "");
                    linea = linea.replace("ñ", "");

                    if (linea != null) {
                        linea = Normalizer.normalize(linea, Normalizer.Form.NFD)
                                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                        linea = linea.replaceAll("[^a-zA-Z]", "");
                        linea = linea.toLowerCase();
                        for (int i = 0; i < linea.length(); i++) {
                            char letra = linea.charAt(i);
                            int indice = letra - 'a';
                            frecuencias[indice]++;
                        }
                    }
                }
            }
            catch (FileNotFoundException f) {
                throw new FileNotFoundException("El fichero" + f + " no existe");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return frecuencias;
    }
}

