/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.semantic;

import analisis.semanticObjects.noDefine;
import analisis.semanticObjects.variableObject;
import exceptions.InputsVaciosException;
import java.util.LinkedList;
import languageConstants.languageConstants;

/**
 *
 * @author angel
 */
public class operation {

    languageConstants languageC = new languageConstants();
    private LinkedList<String> temp3Dir = new LinkedList<>();
    private int contador = 0;

    /**
     * add to different objects to be print
     *
     * this method don't add two decimal numbers, there is an arithmetic to do
     * those operations
     *
     *
     * this method need the position of the string operator
     *
     * @param dato1
     * @param dato2
     * @param row
     * @param column
     * @return
     * @throws InputsVaciosException
     */
    public noDefine stringOp(noDefine dato1, noDefine dato2, int row, int column) throws InputsVaciosException {
        if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return new noDefine((String.valueOf((int) dato1.getValueD()) + dato2.isValueB()), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));
        } else if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return new noDefine((int) dato1.getValueD() + dato2.getValueS().replaceAll("\"", ""), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            return new noDefine(((int) dato1.getValueD() + String.valueOf((int) dato2.getValueD())), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return new noDefine((String.valueOf(dato1.isValueB()) + String.valueOf(dato2.isValueB())), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return new noDefine((dato1.isValueB() + dato2.getValueS()).replaceAll("\"", ""), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            return new noDefine((dato1.getValueS().replaceAll("\"", "") + (int) dato2.getValueD()), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return new noDefine((dato1.getValueS().replaceAll("\"", "") + dato2.isValueB()), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return new noDefine((dato1.getValueS().replaceAll("\"", "") + dato2.getValueS()).replaceAll("\"", ""), languageC.STRING_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));

        } else {
            throw new InputsVaciosException("Los datos no se pueden imprimir juntos fila: " + row + " Columna: " + column);
        }
    }

    /**
     * take the entry values to operate the arithmetic equation
     *
     * this method need the position of the arithmetic operator
     *
     * @param operator
     * @param dato1
     * @param dato2
     * @param row
     * @param column
     * @return
     * @throws InputsVaciosException
     */
    public noDefine arithmeticOp(int operator, noDefine dato1, noDefine dato2, int row, int column) throws InputsVaciosException {
        if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            switch (operator) {
                case 1:
                    return new noDefine((dato1.getValueD() + dato2.getValueD()), languageC.DOUBLE_AUX, row, column, addToTemp3dir(dato1, dato2, "+"));
                case 2:
                    return new noDefine((dato1.getValueD() - dato2.getValueD()), languageC.DOUBLE_AUX, row, column, addToTemp3dir(dato1, dato2, "-"));
                case 3:
                    return new noDefine((dato1.getValueD() * dato2.getValueD()), languageC.DOUBLE_AUX, row, column, addToTemp3dir(dato1, dato2, "*"));
                case 4:
                    return new noDefine((dato1.getValueD() / dato2.getValueD()), languageC.DOUBLE_AUX, row, column, addToTemp3dir(dato1, dato2, "/"));
                default:
                    throw new InputsVaciosException("Operacion inexistente");
            }
        } else {
            catchIncorrectValues("\"Operacion Aritmatica\"", dato1, dato2, row, column, languageC.DOUBLE_AUX, languageC.DOUBLE_AUX);
        }
        return null;
    }

    /**
     * take the entry values to evaluate the logic operator en return an answer
     *
     * this method need the position of the logic operator
     *
     * @param operator
     * @param dato1
     * @param dato2
     * @param row1
     * @param column
     * @param row
     * @return
     * @throws InputsVaciosException
     */
    public noDefine logicOp(int operator, noDefine dato1, noDefine dato2, int row, int column) throws InputsVaciosException {
        switch (operator) {
            case 1:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() > dato2.getValueD()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, ">"));
                } else {
                    catchIncorrectValues(">", dato1, dato2, row, column, languageC.DOUBLE_AUX, languageC.DOUBLE_AUX);
                }
                break;
            case 2:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() < dato2.getValueD()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, "<"));
                } else {
                    catchIncorrectValues("<", dato1, dato2, row, column, languageC.DOUBLE_AUX, languageC.DOUBLE_AUX);
                }
                break;
            case 3:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() == dato2.getValueD()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, "=="));
                } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() == dato2.isValueB()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, "=="));
                } else if ((dato1.getNoTypeType() != languageC.DOUBLE_AUX) && (dato2.getNoTypeType() != languageC.DOUBLE_AUX) && ((dato1.getNoTypeType() == languageC.BOOL_AUX) || (dato2.getNoTypeType() == languageC.BOOL_AUX))) {
                    catchIncorrectValues("==", dato1, dato2, row, column, languageC.BOOL_AUX, languageC.BOOL_AUX);
                } else {
                    catchIncorrectValues("==", dato1, dato2, row, column, languageC.DOUBLE_AUX, languageC.DOUBLE_AUX);
                }
                break;
            case 4:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() != dato2.getValueD()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, "!="));
                } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() != dato2.isValueB()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, "!="));
                } else if ((dato1.getNoTypeType() != languageC.DOUBLE_AUX) && (dato2.getNoTypeType() != languageC.DOUBLE_AUX) && ((dato1.getNoTypeType() == languageC.BOOL_AUX) || (dato2.getNoTypeType() == languageC.BOOL_AUX))) {
                    catchIncorrectValues("!=", dato1, dato2, row, column, languageC.DOUBLE_AUX, languageC.DOUBLE_AUX);
                } else {
                    catchIncorrectValues("!=", dato1, dato2, row, column, languageC.DOUBLE_AUX, languageC.DOUBLE_AUX);
                }
                break;
            case 5:
                if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() && dato2.isValueB()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, "&&"));
                } else {
                    catchIncorrectValues("&&", dato1, dato2, row, column, languageC.BOOL_AUX, languageC.BOOL_AUX);
                }
                break;
            case 6:
                if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() || dato2.isValueB()), languageC.BOOL_AUX, row, column, addToTemp3dir(dato1, dato2, "||"));
                } else {
                    catchIncorrectValues("||", dato1, dato2, row, column, languageC.BOOL_AUX, languageC.BOOL_AUX);
                }
                break;
            default:
                throw new InputsVaciosException("Operacion inexistente");
        }
        throw new InputsVaciosException("Operacion logica inexistente");

    }

    public variableObject tempVar(String id, noDefine noDefineVar) throws InputsVaciosException {
        if (noDefineVar != null) {
            if (noDefineVar.getNoTypeType() == languageC.DOUBLE_AUX) {
                //variableObject(double valueTemp, int tempType, String id)
                if (noDefineVar.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                    addToTemp3dir(id, String.valueOf(noDefineVar.getValueD()));
                } else {
                    addToTemp3dir(id, noDefineVar.getName());
                }
                return new variableObject(noDefineVar.getValueD(), languageC.DOUBLE_AUX, id);
            } else if (noDefineVar.getNoTypeType() == languageC.BOOL_AUX) {
                //variableObject(boolean valueB, int tempType, String id)
                if (noDefineVar.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                    addToTemp3dir(id, String.valueOf(noDefineVar.isValueB()));
                } else {
                    addToTemp3dir(id, noDefineVar.getName());
                }
                addToTemp3dir(id, noDefineVar.getName());
                return new variableObject(noDefineVar.isValueB(), languageC.BOOL_AUX, id);
            } else if (noDefineVar.getNoTypeType() == languageC.STRING_AUX) {
                //variableObject(String valueS, int tempType, String id)
                if (noDefineVar.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                    addToTemp3dir(id, String.valueOf(noDefineVar.getValueS()));
                } else {
                    addToTemp3dir(id, noDefineVar.getName());
                }
                addToTemp3dir(id, noDefineVar.getName());
                return new variableObject(noDefineVar.getValueS(), languageC.STRING_AUX, id);
            } else {
                throw new InputsVaciosException("Datos incompatible para realizar la operacion");
            }
        } else {
            return new variableObject(languageC.NO_TYPE, id, null, 0);
        }
    }

    private void sendError(String name, String operator, int row, int column) throws InputsVaciosException {
        throw new InputsVaciosException("Dato incompatible para la operacion>> " + operator + " << \nDato: " + name + " Fila: " + row + " Columna: " + column);
    }

    private void catchIncorrectValues(String operator, noDefine dato1, noDefine dato2, int row, int column, int type1, int type2) throws InputsVaciosException {
        if ((dato1.getNoTypeType() != type1) && (dato2.getNoTypeType() != type2)) {
            if (!dato1.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty() && !dato1.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                sendError(dato1.getName(), operator, dato1.getRow(), dato1.getColumn());
                sendError(dato2.getName(), operator, dato2.getRow(), dato2.getColumn());
            } else if (!dato1.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                sendError(dato1.getName(), operator, dato1.getRow(), dato1.getColumn());
                sendError(String.valueOf(dato2.getValueD()), operator, row, column);
            } else if (!dato2.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                sendError(String.valueOf(dato1.getValueD()), operator, row, column);
                sendError(dato2.getName(), operator, dato2.getRow(), dato2.getColumn());
            } else {
                sendError(String.valueOf(dato1.getValueD()), ">", row, column);
                sendError(String.valueOf(dato2.getValueD()), ">", row, column);
            }
        } else if (dato1.getNoTypeType() != type1) {
            if (!dato1.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                sendError(dato1.getName(), operator, dato1.getRow(), dato1.getColumn());
            } else {
                sendError(String.valueOf(dato1.getValueD()), ">", row, column);
            }
        } else {
            if (!dato2.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
                sendError(dato2.getName(), operator, dato2.getRow(), dato2.getColumn());
            } else {
                sendError(String.valueOf(dato2.getValueD()), ">", row, column);
            }
        }
    }

    public LinkedList<String> getTemp3Dir() {
        return temp3Dir;
    }

    public void setTemp3Dir(LinkedList<String> temp3Dir) {
        this.temp3Dir = temp3Dir;
    }

    public String addToTemp3dir(noDefine dato1, noDefine dato2, String operator) throws InputsVaciosException {
        if (dato1.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty() && dato2.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
            String temp = "d" + contador;
            temp3Dir.add(temp + " = " + valueParsed(dato1) + " " + operator + " " + valueParsed(dato2));
            contador++;
            return temp;
        } else if (!dato1.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty() && dato2.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
            String temp = "d" + contador;
            temp3Dir.add(temp + " = " + dato1.getName() + " " + operator + " " + valueParsed(dato2));
            contador++;
            return temp;
        } else if (dato1.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty() && !dato2.getName().replaceAll(" ", "").replaceAll("\t", "").isEmpty()) {
            String temp = "d" + contador;
            temp3Dir.add(temp + " = " + valueParsed(dato1) + " " + operator + " " + dato2.getName());
            contador++;
            return temp;
        } else {
            String temp = "d" + contador;
            temp3Dir.add(temp + " = " + dato1.getName() + " " + operator + " " + dato2.getName());
            contador++;
            return temp;
        }

    }

    private String valueParsed(noDefine dato) throws InputsVaciosException {
        if (dato.getNoTypeType() == languageC.BOOL_AUX) {
            return String.valueOf(dato.isValueB());
        } else if (dato.getNoTypeType() == languageC.DOUBLE_AUX) {
            return String.valueOf(dato.getValueD());
        } else if (dato.getNoTypeType() == languageC.STRING_AUX) {
            return dato.getValueS();
        } else {
            throw new InputsVaciosException("No hay dato para devolver");
        }
    }

    public void addToTemp3dir(String id1, String id2) {
        temp3Dir.add(id1 + " = " + id2 + " ;");
    }

    public void resetTemp3Dir() {
        temp3Dir.clear();
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void addOneToContador() {
        contador++;
    }

}
