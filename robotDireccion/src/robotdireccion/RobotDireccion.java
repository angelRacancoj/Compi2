/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotdireccion;

import analisis.Lexer;
import analisis.sintactico;
import java.io.StringReader;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class RobotDireccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese las direcciones para el robot:\n");
        String ruta = entrada.nextLine();

        try {
            if (!ruta.replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                Lexer lex = new Lexer(new StringReader(ruta));
                sintactico sintact = new sintactico(lex);
                System.out.println("Posicion inicial X: 0, Y:0");
                sintact.parse();
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

}
