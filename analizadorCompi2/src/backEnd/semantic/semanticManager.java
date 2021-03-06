/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd.semantic;

import backEnd.Objects.*;
import backEnd.files.ManejadorArchivo;
import backEnd.langConstants.languageConstants;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author angel
 */
public class semanticManager {

    boolean errorFound = false;

    languageConstants languageC = new languageConstants();
    LinkedList<dataType> typeList = new LinkedList<>();
    LinkedList<finalVar> varList = new LinkedList<>();
    LinkedList<String> threeDirectionsCode = new LinkedList<>();
    LinkedList<errorObject> errors = new LinkedList<>();

    public semanticOperations operations;
    public semanticFunctions functions;
    ManejadorArchivo files = new ManejadorArchivo();

    public semanticManager() {
        initDataType();
        operations = new semanticOperations(this);
        functions = new semanticFunctions(this);
    }

    public void resetVarList() {
        varList.clear();
    }

    /**
     * Return the value and id of a variable stored at the Variable List
     *
     * @param id
     * @param row
     * @param column
     * @return
     */
    public tempVar getTempVarFromList(String id, int row, int column) {
        finalVar tempFinalV = findVariable(id);

        if (tempFinalV != null) {
            if (tempFinalV.getdType().getNameData() == languageC.INTEGER) {
                return new tempVar(tempFinalV.getvInteger(), languageC.DOUBLE_AUX, row, column, id);
            } else if (tempFinalV.getdType().getNameData() == languageC.FLOAT) {
                return new tempVar(tempFinalV.getvFloat(), languageC.DOUBLE_AUX, row, column, id);
            } else if (tempFinalV.getdType().getNameData() == languageC.STRING) {
                return new tempVar(tempFinalV.getvFloat(), languageC.STRING, row, column, id);
            } else if (tempFinalV.getdType().getNameData() == languageC.BOOLEAN) {
                return new tempVar(tempFinalV.getvFloat(), languageC.BOOLEAN, row, column, id);
            } else {
                errorAndPlace(languageC.AN_SEMANTICO, "No existe el tipo de dato indicado\nPara: " + id + " en la linea: " + row + " Columna: " + column);
                reset3DirLists();
                return null;
            }
        } else {
            errorAndPlace(languageC.AN_SEMANTICO, "No existe la variable: " + id + "indicada en la linea: " + row + " Columna: " + column);
            reset3DirLists();
            return null;
        }
    }

    /**
     * Verify and add the modify over a Variable
     *
     * @param data
     * @param row
     */
    public void modifyValue(tempFinalVar data, int row) {
        finalVar tempVarFound = findVariable(data.getId());

        if ((tempVarFound != null) && (data != null)) {
            if ((tempVarFound.getdType().getNameData() == languageC.STRING) && (data.getDato().getCategory() == languageC.STRING)) {
                tempVarFound.setvString(data.getDato().getvString());
                addTemp3DirCodeOp();
            } else if ((tempVarFound.getdType().getNameData() == languageC.BOOLEAN) && (data.getDato().getCategory() == languageC.BOOLEAN)) {
                tempVarFound.setvBool(data.getDato().isvBool());
                addTemp3DirCodeOp();
            } else if (((tempVarFound.getdType().getNameData() == languageC.INTEGER) || (tempVarFound.getdType().getNameData() == languageC.FLOAT)) && (data.getDato().getCategory() == languageC.DOUBLE_AUX)) {
                if (tempVarFound.getdType().getNameData() == languageC.INTEGER) {
                    tempVarFound.setvInteger((int) data.getDato().getvDouble());
                    addTemp3DirCodeOp();
                } else {
                    tempVarFound.setvFloat((float) data.getDato().getvDouble());
                    addTemp3DirCodeOp();
                }
            } else {
                errorAndPlace(languageC.AN_SEMANTICO, "No es compatible la variable " + data.getId() + " del tipo " + languageC.getDataTypeName(data.getDato().getCategory()) + " linea: " + row);
                reset3DirLists();
            }
        } else if (tempVarFound == null) {
            errorAndPlace(languageC.AN_SEMANTICO, "No existe la variable " + data.getId() + " del tipo " + languageC.getDataTypeName(data.getDato().getCategory()) + " linea: " + row);
            reset3DirLists();
        } else {
            errorAndPlace(languageC.AN_SEMANTICO, "Existe la variable " + data.getId() + " pero el dato debe ser "
                    + languageC.getDataTypeName(tempVarFound.getdType().getNameData()) + ", revisar linea " + row);
            reset3DirLists();
        }
    }

    /**
     * Add the variables to list if doesn't exist in the variable List
     *
     * @param dType
     * @param data
     * @param row
     * @param column
     */
    public void addVariableToList(int dType, tempFinalVar data, int row, int column) {
        if (data != null) {
            finalVar tempVarFound = findVariable(data.getId());
            dataType tempType = findDType(dType);
            if ((tempVarFound == null) && (tempType != null) && (data.getDato().getCategory() != languageC.NO_TYPE_AUX)) {
                if (((dType == languageC.INTEGER) || (dType == languageC.FLOAT)) && (data.getDato().getCategory() == languageC.DOUBLE_AUX)) {
                    if (dType == languageC.INTEGER) {
                        varList.add(new finalVar((int) data.getDato().getvDouble(), tempType, data.getId(), languageC.VARIABLE));
                        addTemp3DirCodeOp();
                    } else {
                        varList.add(new finalVar((float) data.getDato().getvDouble(), tempType, data.getId(), languageC.VARIABLE));
                        addTemp3DirCodeOp();
                    }
                } else if ((dType == languageC.BOOLEAN) && (data.getDato().getCategory() == languageC.BOOLEAN)) {
                    varList.add(new finalVar(data.getId(), tempType, data.getDato().isvBool(), languageC.VARIABLE));
                    addTemp3DirCodeOp();
                } else if ((dType == languageC.STRING) && (data.getDato().getCategory() == languageC.STRING)) {
                    varList.add(new finalVar(data.getId(), tempType, data.getDato().getvString(), languageC.VARIABLE));
                    addTemp3DirCodeOp();
                } else {
                    errorAndPlace(languageC.AN_SEMANTICO, "No es compatible la variable " + data.getId() + " del tipo " + languageC.getDataTypeName(data.getDato().getCategory())
                            + " con el tipo de indicado " + languageC.getDataTypeName(dType) + " linea: " + row);
                    reset3DirLists();
                }
            } else if ((tempVarFound == null) && (tempType != null) && (data.getDato().getCategory() == languageC.NO_TYPE_AUX)) {
                if (((dType == languageC.INTEGER) || (dType == languageC.FLOAT))) {
                    if (dType == languageC.INTEGER) {
                        varList.add(new finalVar(0, tempType, data.getId(), languageC.INTEGER));
                        addTemp3DirCodeOp();
                        threeDirectionsCode.add(data.getId() + " = " + 0);
                    } else {
                        varList.add(new finalVar(0, tempType, data.getId(), languageC.FLOAT));
                        addTemp3DirCodeOp();
                        threeDirectionsCode.add(data.getId() + " = " + 0);
                    }
                } else if ((dType == languageC.BOOLEAN)) {
                    varList.add(new finalVar(data.getId(), tempType, true, languageC.BOOLEAN));
                    addTemp3DirCodeOp();
                    threeDirectionsCode.add(data.getId() + " = " + true);
                } else if ((dType == languageC.STRING)) {
                    varList.add(new finalVar(data.getId(), tempType, "", languageC.STRING));
                    addTemp3DirCodeOp();
                    threeDirectionsCode.add(data.getId() + " = " + ".");
                }
            } else if ((tempVarFound != null) && (tempType != null)) {
                errorAndPlace(languageC.AN_SEMANTICO, "Ya se ha declarado la variable " + tempVarFound.getIdVar() + " de tipo "
                        + languageC.getDataTypeName(tempVarFound.getdType().getNameData()) + ", revisar linea " + row);
                reset3DirLists();
            } else {
                errorAndPlace(languageC.AN_SEMANTICO, "No existe el tipo de dato indicado, revisar linea " + row);
                reset3DirLists();
            }
        } else {
            errorAndPlace(languageC.AN_SEMANTICO, "Imposible agregar revisar linea " + row + " revisar errores anteriores");
            reset3DirLists();
        }
    }

    private String text3DirOut() {
        String textOut = "";
        for (String threeDirectionsCode1 : threeDirectionsCode) {
            textOut += (threeDirectionsCode1 + "\n");
        }
        return textOut;
    }

    /**
     * Create the file where is going to be saved the "3 Directions Code"
     *
     * @throws IOException
     */
    public void create3DirCodeDoc() throws IOException {
        if (!errorFound) {
            files.guardarArchivo("3DirectionsCode.txt", text3DirOut());
        }
        resetAll();
    }

    /**
     * Print the variables
     *
     * @return
     */
    public String getVars() {
        if (!errorFound) {
            String vars = "Variables:\n";
            for (finalVar var : varList) {
                vars += (var.textVar() + "\n");
            }
            return vars;
        } else {
            return "";
        }
    }

    /**
     * Return in text all the error found
     *
     * @return
     */
    public String Errors() {
        String er = "Errors:\n";
        er += "Errores Lexicos:\n";
        er = errors.stream().filter((error) -> (error.getType() == languageC.AN_LEXICO)).map((error) -> (error.getInformation() + "\n")).reduce(er, String::concat);
        er += "Errores Sintactico:\n";
        er = errors.stream().filter((error) -> (error.getType() == languageC.AN_SINTACTICO)).map((error) -> (error.getInformation() + "\n")).reduce(er, String::concat);
        er += "Errores Semantico:\n";
        er = errors.stream().filter((error) -> (error.getType() == languageC.AN_SEMANTICO)).map((error) -> (error.getInformation() + "\n")).reduce(er, String::concat);
        return er;
    }

    private void initDataType() {
        typeList.add(new dataType(languageC.INTEGER, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
        typeList.add(new dataType(languageC.FLOAT, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
        typeList.add(new dataType(languageC.BOOLEAN, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
        typeList.add(new dataType(languageC.STRING, languageC.FIRST_DIMESION, languageC.INIT_SCOPE));
    }

    /**
     * set the analyzer where the problem come from, and set the information
     * about the problem
     *
     * @param analyzer
     * @param problem
     */
    public void errorAndPlace(int analyzer, String problem) {
        errors.add(new errorObject(analyzer, problem));
        errorFound = true;
    }

    private finalVar findVariable(String id) {
        for (finalVar varList1 : varList) {
            if (varList1.getIdVar().equals(id)) {
                return varList1;
            }
        }
        return null;
    }

    private dataType findDType(int type) {
        for (dataType typeList1 : typeList) {
            if (typeList1.getNameData() == type) {
                return typeList1;
            }
        }
        return null;
    }

    protected void addTemp3DirCodeOp() {
        threeDirectionsCode.addAll(operations.getTemp3dir());
        operations.resetTemp3VarList();
    }

    public void addTemp3DirCodeFuntion(String funtion) {
        threeDirectionsCode.add(funtion);
    }

    private void reset3DirLists() {
        threeDirectionsCode.clear();
        operations.resetTemp3VarList();
    }

    /**
     * return 3 Directions code (all directions and temporal), the counters, the
     * functions list and counters, and reset the flag for error Found
     */
    public void resetAll() {
        threeDirectionsCode.clear();
        operations.resetTemp3VarList();
        operations.resetContador();
        functions.resetAll();
        errorFound = false;
        errors.clear();
    }

    public boolean isErrorFound() {
        return errorFound;
    }

    public void setErrorFound(boolean errorFound) {
        this.errorFound = errorFound;
    }
}
