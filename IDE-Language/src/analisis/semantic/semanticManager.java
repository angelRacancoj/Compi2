/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.semantic;

import analisis.semanticObjects.*;
import exceptions.InputsVaciosException;
import java.util.LinkedList;
import languageConstants.languageConstants;

/**
 *
 * @author angel
 */
public class semanticManager {

    languageConstants languageC = new languageConstants();
    LinkedList<dataType> typeList = new LinkedList<>();
    LinkedList<variableObject> varList = new LinkedList<>();
    LinkedList<String> threeDirectionsCode = new LinkedList<>();

    public semanticManager() {
        initDataType();
    }

    public void resetVarList() {
        varList.clear();
    }

    private void initDataType() {
        typeList.add(new dataType(languageC.INTEGER, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
        typeList.add(new dataType(languageC.FLOAT, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
        typeList.add(new dataType(languageC.BOOLEAN, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
        typeList.add(new dataType(languageC.STRING, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
    }

    /**
     * return an already created Variable inside of variablesList.
     *
     * @param id
     * @return
     * @throws InputsVaciosException
     */
    public noDefine returnNoDefineObject(String id) throws InputsVaciosException {
        variableObject varObj = findVariable(id);
        if (varObj != null) {
            if (varObj.getCategory() == languageC.INTEGER) {
                return new noDefine(varObj.getValueI(), languageC.DOUBLE_AUX);
            } else if (varObj.getCategory() == languageC.FLOAT) {
                return new noDefine(varObj.getValueF(), languageC.DOUBLE_AUX);
            } else if (varObj.getCategory() == languageC.BOOLEAN) {
                Boolean.valueOf("true");
                return new noDefine(varObj.isValueB(), languageC.BOOL_AUX);
            } else if (varObj.getCategory() == languageC.STRING) {
                return new noDefine(varObj.getValueS(), languageC.STRING_AUX);
            } else {
                throw new InputsVaciosException("No existe el tipo de dato indicado");
            }
        } else {
            throw new InputsVaciosException("No existe la variable >>> " + id + " <<<");
        }
    }

    /**
     *
     * @param var
     * @throws InputsVaciosException
     */
    public void modifyValue(variableObject var) throws InputsVaciosException {
        variableObject varFound = findVariable(var.getId());

        if (varFound != null) {
            if ((var.getTempType() == languageC.BOOL_AUX) && (varFound.getType().getNameData() == languageC.BOOLEAN)) {
                varFound.setValueB(var.isValueB());
            } else if ((var.getTempType() == languageC.STRING_AUX) && (varFound.getType().getNameData() == languageC.STRING)) {
                varFound.setValueS(var.getValueS());
            } else if ((var.getTempType() == languageC.DOUBLE_AUX)) {
                if ((varFound.getType().getNameData() == languageC.INTEGER) && languageC.isInteger(var.getValueTemp())) {
                    varFound.setValueI((int) var.getValueTemp());
                } else if (varFound.getType().getNameData() == languageC.FLOAT) {
                    varFound.setValueF((float) var.getValueTemp());
                } else {
                    throw new InputsVaciosException("Tipo de dato incompatible");
                }
            } else {
                throw new InputsVaciosException("No existe la variable el tipo de dato indicado " + var.getTempType());
            }
        } else {
            throw new InputsVaciosException("No existe la variable >>> " + var.getId() + " <<<");

        }
    }

    /**
     *
     * @param type
     * @param var
     * @throws InputsVaciosException
     */
    public void addVariableToList(int type, variableObject var) throws InputsVaciosException {
        if ((type == languageC.INTEGER) && (var.getTempType() == languageC.DOUBLE_AUX)) {
            if (languageC.isInteger(var.getValueTemp())) {
                addVariableToListInt(type, var.getId(), (int) var.getValueTemp());
            } else {
                throw new InputsVaciosException("El valor para >> " + var.getId() + " << no es Integer");
            }
        } else if ((type == languageC.FLOAT) && (var.getTempType() == languageC.DOUBLE_AUX)) {
            addVariableToList(type, var.getId(), (float) var.getValueTemp());
        } else if ((type == languageC.BOOLEAN) && (var.getTempType() == languageC.BOOL_AUX)) {
            addVariableToList(type, var.getId(), var.isValueB());
        } else if ((type == languageC.STRING) && (var.getTempType() == languageC.STRING_AUX)) {
            addVariableToList(type, var.getId(), var.getValueS());
        } else if (var.getValueS().equals(languageC.NO_TYPE)) {
            if (type == languageC.FLOAT) {
                addVariableToList(type, var.getId(), 0);
            } else if ((type == languageC.INTEGER)) {
                addVariableToListInt(type, var.getId(), 0);
            } else if (type == languageC.BOOLEAN) {
                addVariableToList(type, var.getId(), true);
            } else if (type == languageC.STRING) {
                addVariableToList(type, var.getId(), "");
            } else {
                throw new InputsVaciosException("No ha guardado la variable: >> " + var.getId() + " <<");
            }
        } else {
            throw new InputsVaciosException("No ha guardado la variable: >> " + var.getId() + " <<");
        }
    }

    /**
     * This method is to create a Integer object to be insert into the Variables
     * List
     *
     * @param type
     * @param id
     * @param value
     * @param category
     * @throws InputsVaciosException
     */
    private void addVariableToListInt(int type, String id, int value) throws InputsVaciosException {
        variableObject varObj = findVariable(id);
        if (varObj == null) {
            dataType actualType = findDataType(type);
            if (actualType != null) {
                varList.add(new variableObject(value, id, actualType, languageC.VARIABLE));
                System.out.println("Float " + id + " valor: " + value);
            } else {
                throw new InputsVaciosException("No existe el tipo de dato indicado");
            }
        } else {
            throw new InputsVaciosException("Ya existe la variable >>> " + id + " <<<");
        }
    }

    /**
     * This method is to create a Float object to be insert into the Variables
     * List
     *
     * @param type
     * @param id
     * @param value
     * @throws InputsVaciosException
     */
    private void addVariableToList(int type, String id, float value) throws InputsVaciosException {
        variableObject varObj = findVariable(id);
        if (varObj == null) {
            dataType actualType = findDataType(type);
            if (actualType != null) {
                varList.add(new variableObject(value, id, actualType, languageC.VARIABLE));
                System.out.println("Float " + id + " valor: " + value);
            } else {
                throw new InputsVaciosException("No existe el tipo de dato indicado");
            }
        } else {
            throw new InputsVaciosException("Ya existe la variable >>> " + id + " <<<");
        }
    }

    /**
     * This method is to create a String object to be insert into the Variables
     * List
     *
     * @param type
     * @param id
     * @param value
     * @throws InputsVaciosException
     */
    private void addVariableToList(int type, String id, String value) throws InputsVaciosException {
        variableObject varObj = findVariable(id);
        if (varObj == null) {
            dataType actualType = findDataType(type);
            if (actualType != null) {
                varList.add(new variableObject(value, id, actualType, languageC.VARIABLE));
                System.out.println("Float " + id + " valor: " + value);
            } else {
                throw new InputsVaciosException("No existe el tipo de dato indicado");
            }
        } else {
            throw new InputsVaciosException("Ya existe la variable >>> " + id + " <<<");
        }
    }

    /**
     * This method is to create a Boolean object to be insert into the Variables
     * List
     *
     * @param type
     * @param id
     * @param value
     * @throws InputsVaciosException
     */
    private void addVariableToList(int type, String id, boolean value) throws InputsVaciosException {
        variableObject varObj = findVariable(id);
        if (varObj == null) {
            dataType actualType = findDataType(type);
            if (actualType != null) {
                varList.add(new variableObject(value, id, actualType, languageC.VARIABLE));
                System.out.println("Float " + id + " valor: " + value);
            } else {
                throw new InputsVaciosException("No existe el tipo de dato indicado");
            }
        } else {
            throw new InputsVaciosException("Ya existe la variable >>> " + id + " <<<");
        }
    }

    /**
     *
     * @param var
     * @throws InputsVaciosException
     */
    public void correctIfOperator(noDefine var) throws InputsVaciosException {
        if (var.getNoTypeType() == languageC.BOOL_AUX) {
            System.out.println("Funcion if valida");
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    /**
     *
     * @param var
     * @throws InputsVaciosException
     */
    public void correctStringOperator(noDefine var) throws InputsVaciosException {
        if (var.getNoTypeType() == languageC.STRING_AUX) {
            System.out.println("Funcion print valida");
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    /**
     *
     * @param entry
     * @param actual
     * @return
     */
    public boolean findBreak(boolean entry, boolean actual) {
        return (entry || actual);
    }

    /**
     *
     * @param entry
     * @return
     */
    public boolean findBreakInWhile(boolean entry) {
        if (entry) {
            return false;
        }
        return entry;
    }

    /**
     *
     * @param entry
     * @throws InputsVaciosException
     */
    public void breakOutOfWhile(boolean entry) throws InputsVaciosException {
        if (!entry) {
            System.out.println("Todo \"Break\" dentro de un while");
        } else {
            resetVarList();
            throw new InputsVaciosException("Se encuentra un \"Break\" fuera de un \"While\"");
        }
    }

    /**
     *
     */
    public void printVars() {
        System.out.println("Variables: ");
        for (variableObject var : varList) {
            var.printVar();
        }
    }

    private dataType findDataType(int type) {
        for (dataType typeList1 : typeList) {
            if (typeList1.getNameData() == type) {
                return typeList1;
            }
        }
        return null;
    }

    private variableObject findVariable(String id) {
        for (variableObject varList1 : varList) {
            if (varList1.getId().equals(id)) {
                return varList1;
            }
        }
        return null;
    }

    public LinkedList<String> getThreeDirectionsCode() {
        return threeDirectionsCode;
    }

    public void setThreeDirectionsCode(LinkedList<String> threeDirectionsCode) {
        this.threeDirectionsCode = threeDirectionsCode;
    }

}
