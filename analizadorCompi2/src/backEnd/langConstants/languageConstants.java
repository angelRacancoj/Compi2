/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd.langConstants;

import backEnd.Objects.tempVar;
import backEnd.exceptions.InputsVaciosException;

/**
 *
 * @author angel
 */
public class languageConstants {

    public languageConstants() {
    }

    /*aux Operators*/
    public final int DOUBLE_AUX = -1;
    //public final int BOOL_AUX = 2;
    //public final int STRING_AUX = 3;

    /*Data type*/
    public final String NO_TYPE = "Dont have type";
    public final int NO_TYPE_AUX = 0;
    public final int INTEGER = 1;
    public final int FLOAT = 2;
    public final int BOOLEAN = 3;
    public final int STRING = 4;
    public final String INTEGER_NAME = "Integer";
    public final String FLOAT_NAME = "Float";
    public final String BOOLEAN_NAME = "Boolean";
    public final String STRING_NAME = "String";

    /*Dimensions*/
    public final int FIRST_DIMESION = 1;

    /*Scope (ambito)*/
    public final int INIT_SCOPE = 0;

    /*Categories*/
    public final int VARIABLE = 1;

    /*Etiquetas para ciclos*/
    public final int IF_ID = 1;
    public final int WHILE_ID = 2;
    public final int ELSE_ID = 3;

    public final String IF_NAME = "if";
    public final String WHILE_NAME = "While";
    public final String ELSE_NAME = "else";

    public final String IF_LABLE = "lf";
    public final String WHILE_LABLE = "lw";
    public final String else_LABLE = "";

    /*Etiquetas para analizadores*/
    public final int AN_LEXICO = 1;
    public final int AN_SINTACTICO = 2;
    public final int AN_SEMANTICO = 3;
    public final String AN_LEXICO_STR = "Lexico";
    public final String AN_SINTACTICO_STR = "Sintactico";
    public final String AN_SEMANTICO_STR = "Semantico";

    /**
     * This list have all the logic, arithmetic and others operator
     */
    public final String MAS = "+";
    public final String MENOS = "-";
    public final String POR = "*";
    public final String DIV = "/";
    public final String MAYOR_Q = ">";
    public final String MENOR_Q = "<";
    public final String IGUAL = "==";
    public final String DIF = "!=";
    public final String AND = "&&";
    public final String OR = "||";

    public boolean stringIsEmpty(String textoIn) {
        if (textoIn != null) {
            return textoIn.replaceAll(" ", "").replaceAll("\t", "").isEmpty();
        } else {
            return true;
        }
    }

    public boolean isInteger(double variable) {
        return (variable == (int) variable);
//        return ((variable == Math.floor(variable)) && !Double.isInfinite(variable));
    }

    public String clearString(String textoIn) {
        return textoIn.replaceAll("\"", "");
    }

    public String valueParsed(tempVar dato) throws InputsVaciosException {
        if (dato.getCategory() == BOOLEAN) {
            return String.valueOf(dato.isvBool());
        } else if (dato.getCategory() == DOUBLE_AUX) {
            return String.valueOf(dato.getvDouble());
        } else if (dato.getCategory() == STRING) {
            return dato.getvString();
        } else {
            return null;
        }
    }

    public String getDataTypeName(int type) {
        switch (type) {
            case BOOLEAN:
                return BOOLEAN_NAME;
            case STRING:
                return STRING_NAME;
            case INTEGER:
                return INTEGER_NAME;
            case FLOAT:
                return FLOAT_NAME;
            default:
                return null;
        }
    }
}
