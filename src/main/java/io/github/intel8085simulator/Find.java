package io.github.intel8085simulator;

public class Find extends javax.swing.JFrame {

    private final Assembler assembler;

    public Find(Assembler assembler) {
        this.assembler = assembler;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelFind = new javax.swing.JLabel();
        jTextFieldFind = new javax.swing.JTextField();
        jTextFieldReplace = new javax.swing.JTextField();
        jLabelReplace = new javax.swing.JLabel();
        jCheckBoxMatchCase = new javax.swing.JCheckBox();
        jButtonFind = new javax.swing.JButton();
        jButtonReplace = new javax.swing.JButton();
        jButtonReplaceAll = new javax.swing.JButton();
        jLabelStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(300, 300, 0, 0));
        setResizable(false);

        jLabelFind.setText("Find: ");
        jLabelFind.setName("jLabelFind"); // NOI18N

        jTextFieldFind.setName("jTextFieldFind"); // NOI18N
        jTextFieldFind.addActionListener(this::jTextFieldFindActionPerformed);

        jLabelReplace.setText("Replace:");
        jLabelReplace.setName("jLabelReplace"); // NOI18N

        jTextFieldReplace.setName("jTextFieldReplace"); // NOI18N

        jCheckBoxMatchCase.setMnemonic('m');
        jCheckBoxMatchCase.setText("Match Case");
        jCheckBoxMatchCase.setName("jCheckBoxMatchCase"); // NOI18N

        jButtonFind.setMnemonic('f');
        jButtonFind.setText("Find");
        jButtonFind.setName("jButtonFind"); // NOI18N
        jButtonFind.addActionListener(this::jButtonFindActionPerformed);

        jButtonReplace.setMnemonic('r');
        jButtonReplace.setText("Replace");
        jButtonReplace.setName("jButtonReplace"); // NOI18N
        jButtonReplace.addActionListener(this::jButtonReplaceActionPerformed);

        jButtonReplaceAll.setMnemonic('a');
        jButtonReplaceAll.setText("Replace All");
        jButtonReplaceAll.setName("jButtonReplaceAll"); // NOI18N
        jButtonReplaceAll.addActionListener(this::jButtonReplaceAllActionPerformed);

        jLabelStatus.setForeground(new java.awt.Color(102, 102, 255));
        jLabelStatus.setName("jLabelStatus"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabelFind)
                                                                                .addGap(26, 26, 26))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(jLabelReplace)
                                                                                .addGap(18, 18, 18)))
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTextFieldReplace, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jCheckBoxMatchCase)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(83, 83, 83)
                                                .addComponent(jButtonFind)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonReplace)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonReplaceAll)))
                                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelFind)
                                        .addComponent(jTextFieldFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelReplace))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jCheckBoxMatchCase)
                                        .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonFind)
                                        .addComponent(jButtonReplace)
                                        .addComponent(jButtonReplaceAll))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean status = false;

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFindActionPerformed
        jLabelStatus.setText("");
        if (!status) {
            assembler.find = 0;
        }
        assembler.jTextAreaAssemblyLanguageEditor.requestFocus();
        String text = assembler.jTextAreaAssemblyLanguageEditor.getText();
        int n = text.length();
        String findString = jTextFieldFind.getText().trim();
        int wordLength = findString.length();
        status = false;

        for (int i = (assembler.find == 0) ? assembler.find : assembler.find + 1; i < n - wordLength; i++) {
            if (jCheckBoxMatchCase.isSelected()) {

                if (text.substring(i, i + wordLength).equals(findString)) {
                    assembler.jTextAreaAssemblyLanguageEditor.select(i, i + wordLength);
                    assembler.find = i;
                    status = true;
                    break;
                }
            } else {
                if (text.substring(i, i + wordLength).equalsIgnoreCase(findString)) {
                    assembler.jTextAreaAssemblyLanguageEditor.select(i, i + wordLength);
                    assembler.find = i;
                    status = true;
                    break;
                }
            }
        }
        if (!status) {
            jLabelStatus.setText("Not found.");
        }

    }//GEN-LAST:event_jButtonFindActionPerformed

    private int past = 0;

    private void jButtonReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReplaceActionPerformed
        jButtonFindActionPerformed(evt);
        if (assembler.find < assembler.jTextAreaAssemblyLanguageEditor.getText().length() && past != assembler.find) {
            past = assembler.find;
            if (status) {
                assembler.jTextAreaAssemblyLanguageEditor.replaceSelection(jTextFieldReplace.getText());
                assembler.textEditor.colorEditor();
                assembler.textEditor.undo[++assembler.textEditor.undoIndex] = assembler.jTextAreaAssemblyLanguageEditor.getText();
                assembler.textEditor.caretPos[++assembler.textEditor.undoIndex] = assembler.jTextAreaAssemblyLanguageEditor.getCaretPosition();
            }
        }

    }//GEN-LAST:event_jButtonReplaceActionPerformed

    private void jButtonReplaceAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReplaceAllActionPerformed
        status = true;
        while (status) {
            jButtonFindActionPerformed(evt);
            if (assembler.find < assembler.jTextAreaAssemblyLanguageEditor.getText().length() && past != assembler.find) {
                past = assembler.find;
                if (status) {
                    assembler.jTextAreaAssemblyLanguageEditor.replaceSelection(jTextFieldReplace.getText());
                    assembler.textEditor.colorEditor();
                    assembler.textEditor.undo[++assembler.textEditor.undoIndex] = assembler.jTextAreaAssemblyLanguageEditor.getText();
                    assembler.textEditor.caretPos[++assembler.textEditor.undoIndex] = assembler.jTextAreaAssemblyLanguageEditor.getCaretPosition();
                }
            }
        }


    }//GEN-LAST:event_jButtonReplaceAllActionPerformed

    private void jTextFieldFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFindActionPerformed

    public void find() {
        initComponents();
        jLabelReplace.setVisible(false);
        jTextFieldReplace.setVisible(false);
        jButtonReplace.setVisible(false);
        jButtonReplaceAll.setVisible(false);
        jLabelStatus.setText("");
        jTextFieldFind.setText(assembler.jTextAreaAssemblyLanguageEditor.getSelectedText());
    }

    public void replace() {
        initComponents();
        jLabelReplace.setVisible(true);
        jTextFieldReplace.setVisible(true);
        jButtonReplace.setVisible(true);
        jButtonReplaceAll.setVisible(true);
        jLabelStatus.setText("");
        jTextFieldFind.setText(assembler.jTextAreaAssemblyLanguageEditor.getSelectedText());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFind;
    private javax.swing.JButton jButtonReplace;
    private javax.swing.JButton jButtonReplaceAll;
    private javax.swing.JCheckBox jCheckBoxMatchCase;
    private javax.swing.JLabel jLabelFind;
    private javax.swing.JLabel jLabelReplace;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JTextField jTextFieldFind;
    private javax.swing.JTextField jTextFieldReplace;
    // End of variables declaration//GEN-END:variables
}
