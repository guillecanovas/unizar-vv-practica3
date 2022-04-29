package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class TestContadorDeLetras {
    ContadorDeLetras contadorDeLetras = null;
    private static final String path = "src/main/res/";

    @Test
    public void prueba1() throws FileNotFoundException{ //Fichero vacio
        String ficheroEntrada = "vacio.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba2() { //null
        File f = null;
        contadorDeLetras = new ContadorDeLetras(f);
        assertThrows(NullPointerException.class,()->contadorDeLetras.frecuencias());
    }

    @Test
    public void prueba3() throws FileNotFoundException { //Fichero no existe
        assertThrows(FileNotFoundException.class, () -> {
            File f = new File(path + "noExiste.txt");
            contadorDeLetras = new ContadorDeLetras(f);
            contadorDeLetras.frecuencias();
        });
    }

    @Test
    public void prueba4() throws FileNotFoundException { //letras minusculas
        String ficheroEntrada = "alfabeto_ingles_minuscula.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        for(int i=0; i<26; i++){
            resultado[i]=1;
        }
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba5() throws FileNotFoundException { //letras mayusculas
        String ficheroEntrada = "alfabeto_ingles_mayuscula.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        for(int i=0; i<26; i++){
            resultado[i]=1;
        }
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba6() throws FileNotFoundException { //letra ñ
        String ficheroEntrada = "ene_tilde_minuscula.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        resultado[26] = 1;
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba7() throws FileNotFoundException { //letra Ñ
        String ficheroEntrada = "ene_tilde_mayuscula.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        resultado[26] = 1;
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba8() throws FileNotFoundException { //acento agudo
        String ficheroEntrada = "acento_agudo.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        resultado[0] = 1;
        resultado[4] = 1;
        resultado[8] = 1;
        resultado[14] = 1;
        resultado[20] = 1;
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba9() throws FileNotFoundException { //acento agudo mayuscula
        String ficheroEntrada = "acento_agudo_mayuscula.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        resultado[0] = 1;
        resultado[4] = 1;
        resultado[8] = 1;
        resultado[14] = 1;
        resultado[20] = 1;
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba10() throws FileNotFoundException { //acento dieresis
        String ficheroEntrada = "accento_dieresis.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        for (int i=0;i<resultado.length;++i){ resultado[i]=0;}
        resultado[0] = 1;
        resultado[4] = 1;
        resultado[8] = 1;
        resultado[14] = 1;
        resultado[20] = 1;
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba11() throws FileNotFoundException { //acento dieresis mayuscula
        String ficheroEntrada = "accento_dieresis_mayuscula.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        resultado[0] = 1;
        resultado[4] = 1;
        resultado[8] = 1;
        resultado[14] = 1;
        resultado[20] = 1;
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba12() throws FileNotFoundException { //acento circunflejo
        String ficheroEntrada = "accento_circunflejo.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        resultado[0] = 2;
        assertArrayEquals(resultado,frecuencias_fichero);
    }

    @Test
    public void prueba13() throws FileNotFoundException { //letras voladas
        String ficheroEntrada = "subrayado.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        resultado[0] = 1;
        resultado[14] = 1;
        assertArrayEquals(resultado,frecuencias_fichero);

    }

    @Test
    public void prueba14() throws FileNotFoundException { //digitos
        String ficheroEntrada = "vacio.txt";
        File f = new File(path + ficheroEntrada);
        contadorDeLetras = new ContadorDeLetras(f);
        int[] frecuencias_fichero = contadorDeLetras.frecuencias();
        int[] resultado = new int[27];
        assertArrayEquals(resultado,frecuencias_fichero);
    }

}