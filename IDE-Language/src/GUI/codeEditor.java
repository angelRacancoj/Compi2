/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import analisis.Lexer;
import analisis.semantic.operation;
import analisis.semantic.semanticManager;
import analisis.sintactico;
import files.ManejadorArchivo;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author orlan
 */
public class codeEditor extends javax.swing.JPanel {

    String path;
    ManejadorArchivo filesManager;
    TextLineNumber textLine;
    LinkedList<String> errors = new LinkedList<>();
    semanticManager semanticM;
    operation ops;

    Lexer lex;
    sintactico sintact;

    /**
     * Creates new form codeEditor
     *
     * @param path
     */
    public codeEditor(String path) {
        semanticM = new semanticManager();
        ops = new operation();

        this.lex = new Lexer(new StringReader(""));
        this.sintact = new sintactico(lex, semanticM, ops);

        filesManager = new ManejadorArchivo();
        this.path = path;
        initComponents();
        textLine = new TextLineNumber(codeTextArea);
        jScrollPane1.setRowHeaderView(textLine);

        codeTextArea.addCaretListener(new CaretListener() {

            public void caretUpdate(CaretEvent e) {

                JTextArea editArea = (JTextArea) e.getSource();

                int linenum = 1;
                int columnnum = 1;

                try {

                    int caretpos = editArea.getCaretPosition();
                    linenum = editArea.getLineOfOffset(caretpos);

                    columnnum = caretpos - editArea.getLineStartOffset(linenum);

                    linenum += 1;

                } catch (BadLocationException ex) {

                }

                updateStatus(linenum, columnnum);
            }
        });

    }

    private void updateStatus(int linenumber, int columnnumber) {
        lineColumn.setText("Line: " + linenumber + " Column: " + columnnumber);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        codeTextArea = new javax.swing.JTextArea();
        guardarButton = new javax.swing.JButton();
        lineColumn = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        errorsTextArea = new javax.swing.JTextArea();
        testButton = new javax.swing.JButton();

        codeTextArea.setColumns(20);
        codeTextArea.setRows(5);
        jScrollPane1.setViewportView(codeTextArea);

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        lineColumn.setText("Errores");

        errorsTextArea.setColumns(20);
        errorsTextArea.setRows(5);
        jScrollPane2.setViewportView(errorsTextArea);

        testButton.setText("Analizar");
        testButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lineColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(testButton)
                        .addGap(18, 18, 18)
                        .addComponent(guardarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarButton)
                    .addComponent(lineColumn)
                    .addComponent(testButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        saveProgress();
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void testButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testButtonActionPerformed
        clearErrorList();
        errorsTextArea.setText("");
        saveProgress();
        semanticM.resetVarList();

        try {
            lex.yyreset(new StringReader(codeTextArea.getText()));
            this.sintact.parse();
            System.out.println("No hay errores");
        } catch (Exception e) {
            System.out.println("Error:" + e);
        }

        semanticM.printVars();
    }//GEN-LAST:event_testButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea codeTextArea;
    private javax.swing.JTextArea errorsTextArea;
    private javax.swing.JButton guardarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lineColumn;
    private javax.swing.JButton testButton;
    // End of variables declaration//GEN-END:variables

    public void setText(String textIn) {
        codeTextArea.setText(textIn);
    }

    public String returnText() {
        return codeTextArea.getText();
    }

    public void saveProgress() {
        try {
            if (!filesManager.lecturaArchivo(path).equals(codeTextArea.getText())) {
                filesManager.guardarArchivo(path, codeTextArea.getText());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearErrorList() {
        errors.clear();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
