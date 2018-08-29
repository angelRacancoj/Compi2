/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languageConstants;

/**
 *
 * @author angel
 */
public class languageConstants {

    /*aux Operators*/
    public final int DOUBLE_AUX = 1;
    public final int BOOL_AUX = 2;
    public final int STRING_AUX = 3;

    /*Data type*/
    public final String NO_TYPE = "Dont have type";
    public final int INTEGER = 1;
    public final int FLOAT = 2;
    public final int BOOLEAN = 3;
    public final int STRING = 4;

    /*Dimensions*/
    public final int FIRST_DIMESION = 1;

    /*Scope (ambito)*/
    public final int INIT_SCOPE = 0;

    /*Categories*/
    public final int VARIABLE = 1;

    /*arithmetic operator*/
    public final int ADD = 1;
    public final int LESS = 2;
    public final int MUL = 3;
    public final int DIV = 4;

    /*logic operator*/
    /**
     * Symbol '>'
     */
    public final int MAYOR_Q = 1;

    /**
     * Symbol '<'
     */
    public final int MENOR_Q = 2;
    public final int IGUAL = 3;
    public final int DIFERENTE = 4;
    public final int AND = 5;
    public final int OR = 6;

    public boolean isInteger(double variable) {
        return ((variable == Math.floor(variable)) && !Double.isInfinite(variable));
    }
}
