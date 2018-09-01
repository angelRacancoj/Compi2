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
    public LinkedList<String> threeDirctionsAll = new LinkedList<>();
    private LinkedList<String> temp3Dir = new LinkedList<>();
    private int contador = 0;

    /**
     * add to different objects to be print
     *
     * this method don't add two decimal numbers, there is an arithmetic to do
     * those operations
     *
     * @param dato1
     * @param dato2
     * @return
     * @throws InputsVaciosException
     */
    public noDefine stringOp(noDefine dato1, noDefine dato2) throws InputsVaciosException {
        if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return new noDefine((String.valueOf(dato1.getValueD()) + dato2.isValueB()), languageC.STRING_AUX);
        } else if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return new noDefine(dato1.getValueD() + dato2.getValueS().replaceAll("\"", ""), languageC.STRING_AUX);

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            return new noDefine((dato1.getValueD() + String.valueOf(dato2.getValueD())), languageC.STRING_AUX);

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return new noDefine((String.valueOf(dato1.isValueB()) + String.valueOf(dato2.isValueB())), languageC.STRING_AUX);

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return new noDefine((dato1.isValueB() + dato2.getValueS()).replaceAll("\"", ""), languageC.STRING_AUX);

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            return new noDefine((dato1.getValueS().replaceAll("\"", "") + dato2.getValueD()), languageC.STRING_AUX);

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return new noDefine((dato1.getValueS().replaceAll("\"", "") + dato2.isValueB()), languageC.STRING_AUX);

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return new noDefine((dato1.getValueS().replaceAll("\"", "") + dato2.getValueS()).replaceAll("\"", ""), languageC.STRING_AUX);

        } else {
            throw new InputsVaciosException("Los datos no se pueden imprimir juntos");
        }
    }

    /**
     * take the entry values to operate the arithmetic equation
     *
     * @param operator
     * @param dato1
     * @param dato2
     * @return
     * @throws InputsVaciosException
     */
    public noDefine arithmeticOp(int operator, noDefine dato1, noDefine dato2) throws InputsVaciosException {
        if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            switch (operator) {
                case 1:
                    return new noDefine((dato1.getValueD() + dato2.getValueD()), languageC.DOUBLE_AUX);
                case 2:
                    return new noDefine((dato1.getValueD() - dato2.getValueD()), languageC.DOUBLE_AUX);
                case 3:
                    return new noDefine((dato1.getValueD() * dato2.getValueD()), languageC.DOUBLE_AUX);
                case 4:
                    return new noDefine((dato1.getValueD() / dato2.getValueD()), languageC.DOUBLE_AUX);
                default:
                    throw new InputsVaciosException("Operacion inexistente");
            }
        } else {
            throw new InputsVaciosException("Datos incompatible para realizar la operacion");
        }
    }

    /**
     * take the entry values to evaluate the logic operator en return an answer
     *
     * @param operator
     * @param dato1
     * @param dato2
     * @return
     * @throws InputsVaciosException
     */
    public noDefine logicOp(int operator, noDefine dato1, noDefine dato2) throws InputsVaciosException {
        switch (operator) {
            case 1:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() > dato2.getValueD()), languageC.BOOL_AUX);
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 2:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() < dato2.getValueD()), languageC.BOOL_AUX);
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 3:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() == dato2.getValueD()), languageC.BOOL_AUX);
                } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() == dato2.isValueB()), languageC.BOOL_AUX);
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 4:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return new noDefine((dato1.getValueD() != dato2.getValueD()), languageC.BOOL_AUX);
                } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() != dato2.isValueB()), languageC.BOOL_AUX);
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 5:
                if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() && dato2.isValueB()), languageC.BOOL_AUX);
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 6:
                if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return new noDefine((dato1.isValueB() || dato2.isValueB()), languageC.BOOL_AUX);
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            default:
                throw new InputsVaciosException("Operacion inexistente");
        }
    }

    public variableObject tempVar(String id, noDefine noDefineVar) throws InputsVaciosException {
        /*

         */
        if (noDefineVar != null) {
            if (noDefineVar.getNoTypeType() == languageC.DOUBLE_AUX) {
                //variableObject(double valueTemp, int tempType, String id)
                return new variableObject(noDefineVar.getValueD(), languageC.DOUBLE_AUX, id);
            } else if (noDefineVar.getNoTypeType() == languageC.BOOL_AUX) {
                //variableObject(boolean valueB, int tempType, String id)
                return new variableObject(noDefineVar.isValueB(), languageC.BOOL_AUX, id);
            } else if (noDefineVar.getNoTypeType() == languageC.STRING_AUX) {
                //variableObject(String valueS, int tempType, String id)
                return new variableObject(noDefineVar.getValueS(), languageC.STRING_AUX, id);
            } else {
                throw new InputsVaciosException("Datos incompatible para realizar la operacion");
            }
        } else {
            return new variableObject(languageC.NO_TYPE, id, null, 0);
        }
    }
}
