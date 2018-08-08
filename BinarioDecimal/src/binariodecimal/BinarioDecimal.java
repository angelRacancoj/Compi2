/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binariodecimal;

import analisis.Lexer;
import analisis.sintacticoBD;
import java.io.StringReader;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class BinarioDecimal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese el numero binario a convertir:\n");
        String binario = entrada.nextLine();

        try {
            if (!binario.replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                Lexer lex = new Lexer(new StringReader(binario));
                sintacticoBD sintact = new sintacticoBD(lex);
                sintact.parse();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
