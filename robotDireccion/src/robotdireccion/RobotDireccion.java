/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdireccion;

import Graph.Graphs;
import analisis.Lexer;
import analisis.sintactico;
import java.io.StringReader;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.data.xy.DefaultXYZDataset;

/**
 *
 * @author angel
 */
public class RobotDireccion {

    DefaultXYZDataset dataset = new DefaultXYZDataset();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RobotDireccion robot = new RobotDireccion();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese las direcciones para el robot:\n");
        String ruta = entrada.nextLine();

        try {
            if (!ruta.replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                Lexer lex = new Lexer(new StringReader(ruta));
                sintactico sintact = new sintactico(lex, robot);
                System.out.println("Posicion inicial X: 0, Y:0");
                sintact.parse();
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }

        Graphs grafica = new Graphs(robot.dataset);
        grafica.setSize(800, 600);
        grafica.setLocationRelativeTo(null);
        grafica.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        grafica.setVisible(true);
    }

    public void addStep(int id, int posX, int posY) {
        dataset.addSeries("Paso " + id, new double[][]{{posX * 10}, {posY * 10}, {3}});
    }

    public void addInicio(int id, int posX, int posY) {
        dataset.addSeries("Inicio", new double[][]{{posX * 10}, {posY * 10}, {3}});
    }
}
