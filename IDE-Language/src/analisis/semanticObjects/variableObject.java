/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.semanticObjects;

/**
 *
 * @author angel
 */
public class variableObject {

    int valueI;
    float valueF;
    String valueS;
    boolean valueB;
    double valueTemp;
    int tempType;
    String id;
    dataType type;
    int category;

    /**
     * This method is to create a Integer object
     *
     * @param valueI
     * @param id
     * @param type
     * @param category
     */
    public variableObject(int valueI, String id, dataType type, int category) {
        this.valueI = valueI;
        this.id = id;
        this.type = type;
        this.category = category;
    }

    /**
     * This method is to create a Float object
     *
     * @param valueF
     * @param id
     * @param type
     * @param category
     */
    public variableObject(float valueF, String id, dataType type, int category) {
        this.valueF = valueF;
        this.id = id;
        this.type = type;
        this.category = category;
    }

    /**
     * This method is to create a String object
     *
     * @param valueS
     * @param id
     * @param type
     * @param category
     */
    public variableObject(String valueS, String id, dataType type, int category) {
        this.valueS = valueS;
        this.id = id;
        this.type = type;
        this.category = category;
    }

    /**
     * This method is to create a Boolean object
     *
     * @param valueB
     * @param id
     * @param type
     * @param category
     */
    public variableObject(boolean valueB, String id, dataType type, int category) {
        this.valueB = valueB;
        this.id = id;
        this.type = type;
        this.category = category;
    }

    /**
     * this method is temporal to take up the variable
     *
     * @param valueTemp
     * @param tempType
     * @param id
     */
    public variableObject(double valueTemp, int tempType, String id) {
        this.valueTemp = valueTemp;
        this.tempType = tempType;
        this.id = id;
    }

    public variableObject(boolean valueB, int tempType, String id) {
        this.valueB = valueB;
        this.tempType = tempType;
        this.id = id;
    }

    public variableObject(String valueS, int tempType, String id) {
        this.valueS = valueS;
        this.tempType = tempType;
        this.id = id;
    }

    public int getValueI() {
        return valueI;
    }

    public void setValueI(int valueI) {
        this.valueI = valueI;
    }

    public float getValueF() {
        return valueF;
    }

    public void setValueF(float valueF) {
        this.valueF = valueF;
    }

    public String getValueS() {
        return valueS;
    }

    public void setValueS(String valueS) {
        this.valueS = valueS;
    }

    public boolean isValueB() {
        return valueB;
    }

    public void setValueB(boolean valueB) {
        this.valueB = valueB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public dataType getType() {
        return type;
    }

    public void setType(dataType type) {
        this.type = type;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getValueTemp() {
        return valueTemp;
    }

    public void setValueTemp(double valueTemp) {
        this.valueTemp = valueTemp;
    }

    public int getTempType() {
        return tempType;
    }

    public void setTempType(int tempType) {
        this.tempType = tempType;
    }

}
