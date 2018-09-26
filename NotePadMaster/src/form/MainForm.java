package form;

/**
 *
 * @author Sharp team
 */
public class MainForm extends javax.swing.JFrame {

    public MainForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileNew = new javax.swing.JMenuItem();
        fileOpen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        fileSave = new javax.swing.JMenuItem();
        fileSaveAs = new javax.swing.JMenuItem();
        fileSaveAll = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        fileClose = new javax.swing.JMenuItem();
        fileCloseAll = new javax.swing.JMenuItem();
        fileExit = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        editUndo = new javax.swing.JMenuItem();
        editRedo = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        editCut = new javax.swing.JMenuItem();
        editCopy = new javax.swing.JMenuItem();
        editPaste = new javax.swing.JMenuItem();
        editDelete = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        editFind = new javax.swing.JMenuItem();
        editReplace = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        editSelectAll = new javax.swing.JMenuItem();
        formatMenu = new javax.swing.JMenu();
        formatFont = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneStateChanged(evt);
            }
        });

        fileMenu.setText("File");

        fileNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        fileNew.setText("New");
        fileNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNewActionPerformed(evt);
            }
        });
        fileMenu.add(fileNew);

        fileOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        fileOpen.setText("Open");
        fileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileOpenActionPerformed(evt);
            }
        });
        fileMenu.add(fileOpen);
        fileMenu.add(jSeparator1);

        fileSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        fileSave.setText("Save");
        fileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveActionPerformed(evt);
            }
        });
        fileMenu.add(fileSave);

        fileSaveAs.setText("Save As");
        fileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveAsActionPerformed(evt);
            }
        });
        fileMenu.add(fileSaveAs);

        fileSaveAll.setText("Save All");
        fileSaveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSaveAllActionPerformed(evt);
            }
        });
        fileMenu.add(fileSaveAll);
        fileMenu.add(jSeparator2);

        fileClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        fileClose.setText("Close");
        fileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileCloseActionPerformed(evt);
            }
        });
        fileMenu.add(fileClose);

        fileCloseAll.setText("Close All");
        fileCloseAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileCloseAllActionPerformed(evt);
            }
        });
        fileMenu.add(fileCloseAll);

        fileExit.setText("Exit");
        fileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExitActionPerformed(evt);
            }
        });
        fileMenu.add(fileExit);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        editUndo.setText("Undo");
        editMenu.add(editUndo);

        editRedo.setText("Redo");
        editMenu.add(editRedo);
        editMenu.add(jSeparator3);

        editCut.setText("Cut");
        editMenu.add(editCut);

        editCopy.setText("Copy");
        editMenu.add(editCopy);

        editPaste.setText("Paste");
        editMenu.add(editPaste);

        editDelete.setText("Delete");
        editDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDeleteActionPerformed(evt);
            }
        });
        editMenu.add(editDelete);
        editMenu.add(jSeparator4);

        editFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        editFind.setText("Find");
        editFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editFindActionPerformed(evt);
            }
        });
        editMenu.add(editFind);

        editReplace.setText("Replace");
        editReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editReplaceActionPerformed(evt);
            }
        });
        editMenu.add(editReplace);
        editMenu.add(jSeparator5);

        editSelectAll.setText("Select All");
        editSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSelectAllActionPerformed(evt);
            }
        });
        editMenu.add(editSelectAll);

        menuBar.add(editMenu);

        formatMenu.setText("Format");

        formatFont.setText("Font");
        formatFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formatFontActionPerformed(evt);
            }
        });
        formatMenu.add(formatFont);

        menuBar.add(formatMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileSaveActionPerformed

    private void fileNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileNewActionPerformed

    private void fileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileOpenActionPerformed

    private void fileCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileCloseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileCloseActionPerformed

    private void formatFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formatFontActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formatFontActionPerformed

    private void fileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveAsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileSaveAsActionPerformed

    private void fileCloseAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileCloseAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileCloseAllActionPerformed

    private void fileSaveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSaveAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileSaveAllActionPerformed

    private void editSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editSelectAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editSelectAllActionPerformed

    private void editReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editReplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editReplaceActionPerformed

    private void editFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editFindActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editFindActionPerformed

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fileExitActionPerformed

    private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbedPaneStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_tabbedPaneStateChanged

    private void editDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem editCopy;
    private javax.swing.JMenuItem editCut;
    private javax.swing.JMenuItem editDelete;
    private javax.swing.JMenuItem editFind;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem editPaste;
    private javax.swing.JMenuItem editRedo;
    private javax.swing.JMenuItem editReplace;
    private javax.swing.JMenuItem editSelectAll;
    private javax.swing.JMenuItem editUndo;
    private javax.swing.JMenuItem fileClose;
    private javax.swing.JMenuItem fileCloseAll;
    private javax.swing.JMenuItem fileExit;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem fileNew;
    private javax.swing.JMenuItem fileOpen;
    private javax.swing.JMenuItem fileSave;
    private javax.swing.JMenuItem fileSaveAll;
    private javax.swing.JMenuItem fileSaveAs;
    private javax.swing.JMenuItem formatFont;
    private javax.swing.JMenu formatMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
