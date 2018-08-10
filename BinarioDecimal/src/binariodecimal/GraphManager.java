/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binariodecimal;

import analisis.Node;
import analisis.ValueAndPosicion;
import fileManager.readAndWrite;
import java.io.IOException;

/**
 *
 * @author angel
 */
public class GraphManager {

    readAndWrite files = new readAndWrite();

    public void createGraph(ValueAndPosicion nodeToAdd) throws IOException {
        String textOut = "";
        textOut = "digraph G {\nnode [shape = record,height=.1];\n";
        //texto nodos
        textOut += "node" + nodeToAdd.getName() + nodeToAdd.getId() + "[shape=record, label = \"{<f0>" + nodeToAdd.getName() + "|Valor: " + nodeToAdd.getValue() + "|<f1>Posicion: " + nodeToAdd.getPosicion() + "}\"];\n";
        textOut += nodeToAdd.getGraph();
        //texto nodos
        textOut += "}";
        files.guardarArchivo("/home/angel/grafica1.dot", textOut);

        files.runGraphviz("/home/angel/grafica1");
    }

    public String crearNodo(ValueAndPosicion nodeToAdd, Node nodeP) {
        return ("node" + nodeToAdd.getName() + nodeToAdd.getId() + "[shape=record, label = \"{<f0>" + nodeToAdd.getName() + "|Valor: " + nodeToAdd.getValue() + "|<f1>Posicion: " + nodeToAdd.getPosicion() + "}\"];\n"
                + "\"node" + nodeP.getName() + nodeP.getId() + "\":f1 -> \"node" + nodeToAdd.getName() + nodeToAdd.getId() + "\":f0;\n");
    }

    public String addComa(int idNodo, Node nodeP) {
        return ("nodeComa[shape=record, label = \"{<f0>','}\"];\n"
                + "\"node" + nodeP.getName() + nodeP.getId() + "\":f0 -> \"nodeComa\":f0;\n");
    }

//    public String addNodes(ValueAndPosicion nodeToAdd, Node nodeP) {
//        return crearNodo(nodeToAdd.getName(), nodeToAdd.getId(), nodeP.getName(),nodeP.getId(), nodeToAdd.getValue(), nodeToAdd.getPosicion());
//    }
}
