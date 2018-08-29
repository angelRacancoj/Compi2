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

    languageConstants languajeC = new languageConstants();
    LinkedList<dataType> typeList = new LinkedList<>();
    LinkedList<variableObject> varList = new LinkedList<>();

    public semanticManager() {
        initDataType();
    }

    private void initDataType() {
        typeList.add(new dataType(languajeC.INTEGER, languajeC.FIRST_DIMESION, languajeC.INIT_SCOPE));
        typeList.add(new dataType(languajeC.FLOAT, languajeC.FIRST_DIMESION, languajeC.INIT_SCOPE));
        typeList.add(new dataType(languajeC.BOOLEAN, languajeC.FIRST_DIMESION, languajeC.INIT_SCOPE));
        typeList.add(new dataType(languajeC.STRING, languajeC.FIRST_DIMESION, languajeC.INIT_SCOPE));
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

    public String addText(String comdand, String toAdd) {
        return (comdand += toAdd);
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
        if (varObj.getCategory() == languajeC.INTEGER) {
            return new noDefine(varObj.getValueI(), languajeC.DOUBLE_AUX);
        } else if (varObj.getCategory() == languajeC.FLOAT) {
            return new noDefine(varObj.getValueF(), languajeC.DOUBLE_AUX);
        } else if (varObj.getCategory() == languajeC.BOOLEAN) {
            return new noDefine(varObj.isValueB(), languajeC.BOOL_AUX);
        } else if (varObj.getCategory() == languajeC.STRING) {
            return new noDefine(varObj.getValueS(), languajeC.STRING_AUX);
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    public double returnDoubleValue(String id) throws InputsVaciosException {
        variableObject varObj = findVariable(id);

        if ((varObj.getCategory() == languajeC.INTEGER)) {
            return varObj.getValueI();
        } else if ((varObj.getCategory() == languajeC.FLOAT)) {
            return varObj.getValueF();
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    public boolean returnBooleanValue(String id) throws InputsVaciosException {
        variableObject varObj = findVariable(id);

        if ((varObj.getCategory() == languajeC.BOOLEAN)) {
            return varObj.isValueB();
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    public String returnStringValue(String id) throws InputsVaciosException {
        variableObject varObj = findVariable(id);

        if ((varObj.getCategory() == languajeC.BOOLEAN)) {
            return varObj.getValueS();
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
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
    public void addVariableToList(int type, String id, int value) throws InputsVaciosException {
        dataType actualType = findDataType(type);
        if (actualType != null) {
            varList.add(new variableObject(value, id, actualType, languajeC.VARIABLE));
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    /**
     * This method is to create a Float object to be insert into the Variables
     * List
     *
     * @param type
     * @param id
     * @param value
     * @param category
     * @throws InputsVaciosException
     */
    public void addVariableToList(int type, String id, float value) throws InputsVaciosException {
        dataType actualType = findDataType(type);
        if (actualType != null) {
            varList.add(new variableObject(value, id, actualType, languajeC.VARIABLE));
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    /**
     * This method is to create a String object to be insert into the Variables
     * List
     *
     * @param type
     * @param id
     * @param value
     * @param category
     * @throws InputsVaciosException
     */
    public void addVariableToList(int type, String id, String value) throws InputsVaciosException {
        dataType actualType = findDataType(type);
        if (actualType != null) {
            varList.add(new variableObject(value, id, actualType, languajeC.VARIABLE));
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

    /**
     * This method is to create a Boolean object to be insert into the Variables
     * List
     *
     * @param type
     * @param id
     * @param value
     * @param category
     * @throws InputsVaciosException
     */
    public void addVariableToList(int type, String id, boolean value) throws InputsVaciosException {
        dataType actualType = findDataType(type);
        if (actualType != null) {
            varList.add(new variableObject(value, id, actualType, languajeC.VARIABLE));
        } else {
            throw new InputsVaciosException("No existe el tipo de dato indicado");
        }
    }

}
