/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.semantic;

import analisis.semanticObjects.noDefine;
import exceptions.InputsVaciosException;
import languageConstants.languageConstants;

/**
 *
 * @author angel
 */
public class operation {

    languageConstants languageC = new languageConstants();

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
    public String stringOp(noDefine dato1, noDefine dato2) throws InputsVaciosException {
        if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return (String.valueOf(dato1.getValueD()) + dato2.isValueB());

        } else if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return (dato1.getValueD() + dato2.getValueS());

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            return (dato1.getValueD() + String.valueOf(dato2.getValueD()));

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return (String.valueOf(dato1.isValueB()) + String.valueOf(dato2.isValueB()));

        } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return (dato1.isValueB() + dato2.getValueS());

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            return (dato1.getValueS() + dato2.getValueD());

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
            return (dato1.getValueS() + dato2.isValueB());

        } else if ((dato1.getNoTypeType() == languageC.STRING_AUX) && (dato2.getNoTypeType() == languageC.STRING_AUX)) {
            return (dato1.getValueS() + dato2.getValueS());

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
    public double arithmeticOp(int operator, noDefine dato1, noDefine dato2) throws InputsVaciosException {
        if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
            switch (operator) {
                case 1:
                    return (dato1.getValueD() + dato2.getValueD());
                case 2:
                    return (dato1.getValueD() - dato2.getValueD());
                case 3:
                    return (dato1.getValueD() * dato2.getValueD());
                case 4:
                    return (dato1.getValueD() / dato2.getValueD());
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
    public boolean logicOp(int operator, noDefine dato1, noDefine dato2) throws InputsVaciosException {
        switch (operator) {
            case 1:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return (dato1.getValueD() > dato2.getValueD());
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 2:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return (dato1.getValueD() < dato2.getValueD());
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 3:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return (dato1.getValueD() == dato2.getValueD());
                } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return (dato1.isValueB() == dato2.isValueB());
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 4:
                if ((dato1.getNoTypeType() == languageC.DOUBLE_AUX) && (dato2.getNoTypeType() == languageC.DOUBLE_AUX)) {
                    return (dato1.getValueD() != dato2.getValueD());
                } else if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return (dato1.isValueB() != dato2.isValueB());
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 5:
                if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return (dato1.isValueB() && dato2.isValueB());
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            case 6:
                if ((dato1.getNoTypeType() == languageC.BOOL_AUX) && (dato2.getNoTypeType() == languageC.BOOL_AUX)) {
                    return (dato1.isValueB() || dato2.isValueB());
                } else {
                    throw new InputsVaciosException("Datos incompatible para realizar la operacion");
                }
            default:
                throw new InputsVaciosException("Operacion inexistente");
        }
    }

}
