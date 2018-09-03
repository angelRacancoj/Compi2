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
public class noDefine {

    boolean valueB;
    double valueD;
    String valueS;
    int noTypeType;
    int row;
    int column;
    String name;

    /**
     * this method is to carrier the "Boolean" value to be operated, is
     * necessary to add the row and column, it's to show friendly the error
     *
     * Doesn't care of the name of the variable
     *
     * @param valueB
     * @param noTypeType
     * @param row
     * @param column
     */
    public noDefine(boolean valueB, int noTypeType, int row, int column) {
        this.valueB = valueB;
        this.noTypeType = noTypeType;
        this.row = row;
        this.column = column;
        this.name = "";
    }

    /**
     * this method is to carrier the "Integer" value to be operated, is
     * necessary to add the row and column, it's to show friendly the error
     *
     * Doesn't care of the name of the variable
     *
     * @param valueD
     * @param noTypeType
     * @param row
     * @param column
     */
    public noDefine(double valueD, int noTypeType, int row, int column) {
        this.valueD = valueD;
        this.noTypeType = noTypeType;
        this.row = row;
        this.column = column;
        this.name = "";
    }

    /**
     * this method is to carrier the "String" value to be operated, is necessary
     * to add the row and column, it's to show friendly the error
     *
     * Doesn't care of the name of the variable
     *
     * @param valueS
     * @param noTypeType
     * @param row
     * @param column
     */
    public noDefine(String valueS, int noTypeType, int row, int column) {
        this.valueS = valueS;
        this.noTypeType = noTypeType;
        this.row = row;
        this.column = column;
        this.name = "";
    }

    /**
     * this method is to carrier the "String" value to be operated, is necessary
     * to add the row and column, it's to show friendly the error
     *
     * this method include the name to add it at the "three directions code"
     *
     * @param valueS
     * @param noTypeType
     * @param row
     * @param column
     * @param name
     */
    public noDefine(String valueS, int noTypeType, int row, int column, String name) {
        this.valueS = valueS;
        this.noTypeType = noTypeType;
        this.row = row;
        this.column = column;
        this.name = name;
    }

    /**
     * this method is to carrier the "Integer" value to be operated, is
     * necessary to add the row and column, it's to show friendly the error
     *
     * this method include the name to add it at the "three directions code"
     *
     * @param valueD
     * @param noTypeType
     * @param row
     * @param column
     * @param name
     */
    public noDefine(double valueD, int noTypeType, int row, int column, String name) {
        this.valueD = valueD;
        this.noTypeType = noTypeType;
        this.row = row;
        this.column = column;
        this.name = name;
    }

    /**
     * this method is to carrier the "Boolean" value to be operated, is
     * necessary to add the row and column, it's to show friendly the error
     *
     * this method include the name to add it at the "three directions code"
     *
     * @param valueB
     * @param noTypeType
     * @param row
     * @param column
     * @param name
     */
    public noDefine(boolean valueB, int noTypeType, int row, int column, String name) {
        this.valueB = valueB;
        this.noTypeType = noTypeType;
        this.row = row;
        this.column = column;
        this.name = name;
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

    public double getValueD() {
        return valueD;
    }

    public void setValueD(double valueD) {
        this.valueD = valueD;
    }

    public int getNoTypeType() {
        return noTypeType;
    }

    public void setNoTypeType(int noTypeType) {
        this.noTypeType = noTypeType;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

}
