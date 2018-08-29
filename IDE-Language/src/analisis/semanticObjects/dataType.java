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
public class dataType {

    int nameData;
    int dimension;
    int Scope;

    public dataType(int nameData, int dimension, int Scope) {
        this.nameData = nameData;
        this.dimension = dimension;
        this.Scope = Scope;
    }

    public int getNameData() {
        return nameData;
    }

    public void setNameData(int nameData) {
        this.nameData = nameData;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getScope() {
        return Scope;
    }

    public void setScope(int Scope) {
        this.Scope = Scope;
    }

}
