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

    public noDefine(boolean valueB, int noTypeType) {
        this.valueB = valueB;
        this.noTypeType = noTypeType;
    }

    public noDefine(double valueD, int noTypeType) {
        this.valueD = valueD;
        this.noTypeType = noTypeType;
    }

    public noDefine(String valueS, int noTypeType) {
        this.valueS = valueS;
        this.noTypeType = noTypeType;
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

}
