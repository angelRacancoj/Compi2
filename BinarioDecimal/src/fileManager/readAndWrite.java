package fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author angelrg
 */
public class readAndWrite {

    BufferedReader lectura;

    public String lecturaArchivo(String path) throws FileNotFoundException, IOException {
        System.out.println(path);
        File file = new File(path);
        String textoTotal = "";
        String linea = "";
        lectura = new BufferedReader(new FileReader(file));
        while ((linea = lectura.readLine()) != null) {
            textoTotal += (linea + "\n");
        }
        System.out.println(textoTotal);
        return textoTotal;
    }

    public void guardarArchivo(String path, String texto) throws IOException {
        FileWriter fichero = null;
        File file = new File(path);
        fichero = new FileWriter(file);
        fichero.write(texto);
        fichero.close();
    }

    public void runGraphviz(String path) {
        String s = "";

        try {

            // run the Unix "ps -ef" command
            Process p = Runtime.getRuntime().exec("dot -Tpng " + path + ".dot -o /home/angel/grafica1.png");

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: " + e);
            System.exit(-1);
        }

        try {

            // run the Unix "ps -ef" command
            Process p = Runtime.getRuntime().exec("nohup display /home/angel/grafica1.png");

            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println("exception happened - here's what I know: " + e);
            System.exit(-1);
        }
    }
}
