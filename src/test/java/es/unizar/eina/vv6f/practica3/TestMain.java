package es.unizar.eina.vv6f.practica3;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMain {

    private static final String path =  "src/main/res/";
    private static final String testPath =  "src/test/res/";
    ByteArrayInputStream bInput;
    PrintStream bOutput;
    static InputStream in;
    static PrintStream out;

    @BeforeAll
    static void op_principio(){
        in = System.in;
        out = System.out;
    }

    @AfterAll
    static void op_final(){
        System.setIn(in);
        System.setOut(out);
    }

    void comparar(File fich1, File fich2) throws IOException {
        byte[] bytes_fich1 = Files.readAllBytes(fich1.toPath());
        byte[] bytes_fich2 = Files.readAllBytes(fich2.toPath());
        assertArrayEquals(bytes_fich1,bytes_fich2);
    }

    @Test
    void HamletTest() throws IOException {
        String fichero = path + "hamlet.txt";
        byte[] numBytes = fichero.getBytes();
        bInput = new ByteArrayInputStream(numBytes);

        File salidaActual = new File(path + "out.txt");
        FileOutputStream fos = new FileOutputStream(salidaActual);
        File ficheroOutput = new File(testPath + "salida-hamlet.txt");
        bOutput = new PrintStream(fos);

        System.setIn(bInput);
        System.setOut(bOutput);
        Main.main(null);

        comparar(ficheroOutput, salidaActual);
    }

    @Test
    void QuijoteTest() throws IOException {
        String fichero = path + "quijote.txt";
        byte[] numBytes = fichero.getBytes();
        bInput = new ByteArrayInputStream(numBytes);

        File salidaActual = new File(path + "out.txt");
        FileOutputStream fos = new FileOutputStream(salidaActual);
        File ficheroOutput = new File(testPath + "salida-quijote.txt");
        bOutput = new PrintStream(fos);

        System.setIn(bInput);
        System.setOut(bOutput);
        Main.main(null);

        comparar(ficheroOutput, salidaActual);
    }

    @Test
    void RegentaTest() throws IOException {
        String fichero = path + "regenta.txt";
        byte[] numBytes = fichero.getBytes();
        bInput = new ByteArrayInputStream(numBytes);

        File salidaActual = new File(path + "out.txt");
        FileOutputStream fos = new FileOutputStream(salidaActual);
        File ficheroOutput = new File(testPath + "salida-regenta.txt");
        bOutput = new PrintStream(fos);

        System.setIn(bInput);
        System.setOut(bOutput);
        Main.main(null);

        comparar(ficheroOutput, salidaActual);
    }

}

