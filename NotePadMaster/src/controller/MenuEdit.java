package controller;

import form.ChangeFontForm;
import form.FindForm;
import form.ReplaceForm;
import form.MainForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultEditorKit;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Sharp team
 */
public class MenuEdit {

    // controller edit
    public void controller(MainForm mainForm) {
        UndoManager manager = new UndoManager();
        mainForm.getTxtArea().getDocument().addUndoableEditListener(manager);
        
        enableEdit(mainForm);
        checkUndoRedo(mainForm, manager);
        
        undo(mainForm, manager);
        redo(mainForm, manager);
        copyPasteCut(mainForm);
        selectAll(mainForm);
        
        findController(mainForm);
        replaceController(mainForm);
        changeFontController(mainForm);
    }

    // check user can undo/redo
    private void enableEdit(MainForm mainForm) {
        // when open editor can't undo, redo
        mainForm.getEditCopy().setEnabled(false);
        mainForm.getEditCut().setEnabled(false);
        mainForm.getFind().setEnabled(false);
        mainForm.getReplace().setEnabled(false);
        mainForm.getEditDelete().setEnabled(false);

        // check when content text area change
        mainForm.getTxtArea().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String textCurrent = mainForm.getTxtArea().getText();
                // can undo redo when user change text
                if (textCurrent.length() != 0) {
                    mainForm.getEditCopy().setEnabled(true);
                    mainForm.getEditCut().setEnabled(true);
                    mainForm.getFind().setEnabled(true);
                    mainForm.getReplace().setEnabled(true);
                    mainForm.getEditDelete().setEnabled(true);
                }
            }
        });
    }

    // undo
    private void undo(MainForm mainForm, UndoManager manager) {
        //  FIXME: check can not undo, redo
        // FIXME: have undo then show redo
        mainForm.getEditUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.undo();
            }
        });
    }

    // redo TODO: check cannot redo, undo
    private void redo(MainForm mainForm, UndoManager manager) {
        mainForm.getEditRedo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.redo();
            }
        });
    }

    // copy, past, cut
    private void copyPasteCut(MainForm mainForm) {
        Action copy = new DefaultEditorKit.CopyAction();
        Action paste = new DefaultEditorKit.PasteAction();
        Action cut = new DefaultEditorKit.CutAction();
        
        mainForm.getEditCopy().addActionListener(copy);
        mainForm.getEditPaste().addActionListener(paste);
        mainForm.getEditCut().addActionListener(cut);
        
    }

    // select all
    private void selectAll(MainForm mainForm) {
        mainForm.getEditDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainForm.getTxtArea().selectAll();
            }
        });
    }

    // find controller
    private void findController(MainForm mainForm) {
        mainForm.getFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindForm findForm = new FindForm(mainForm, true);
                findForm.setVisible(true);
                findForm.getBtnFind().setEnabled(false);
                
                checkEmptyFind(findForm);
                find(mainForm, findForm);
                cancelFind(findForm);
            }
        });
    }

    // find
    private void find(MainForm mainForm, FindForm findForm) {
        // when user click button find
        findForm.getBtnFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtFind = findForm.getTxtFind().getText();
                int indexCurrent;
                int indexTextSearch = -1;
                // check user want to find after
                if (findForm.getIsDown().isSelected()) {
                    // must choose selectionend to change index cusor
                    indexCurrent = mainForm.getTxtArea().getSelectionEnd();
                    indexTextSearch = mainForm.getTxtArea().getText().indexOf(txtFind, indexCurrent);
                } else {
                    try {
                        indexCurrent = mainForm.getTxtArea().getSelectionStart();
                        String textCurrentCheck = mainForm.getTxtArea().getText(0, indexCurrent);
                        indexTextSearch = textCurrentCheck.lastIndexOf(txtFind);
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }
                }
                // check have text want to search or not
                if (indexTextSearch != -1) {
                    mainForm.getTxtArea().setSelectionStart(indexTextSearch);
                    mainForm.getTxtArea().setSelectionEnd(indexTextSearch + txtFind.length());
                } else {
                    JOptionPane.showMessageDialog(findForm, "Cannot find \"" + txtFind + "\"", "Result", 2);
                }
            }
        });
    }

    // when user click button cancel
    private void cancelFind(FindForm findForm) {
        findForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findForm.setVisible(false);
            }
        });
    }

    // check user not input
    private void checkEmptyFind(FindForm findForm) {
        findForm.getTxtFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (findForm.getTxtFind().getText().trim().isEmpty()) {
                    findForm.getBtnFind().setEnabled(false);
                } else {
                    findForm.getBtnFind().setEnabled(true);
                }
            }
        });
    }

    // replace controller
    private void replaceController(MainForm mainForm) {
        mainForm.getReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReplaceForm replaceForm = new ReplaceForm(mainForm, false);
                replaceForm.setVisible(true);
                replaceForm.getBtnReplace().setEnabled(false);
                replaceForm.getBtnReplaceAll().setEnabled(false);
                
                checkEmptyReplace(replaceForm);
                replace(mainForm, replaceForm);
                replaceAll(mainForm, replaceForm);
                cancelReplace(replaceForm);
            }
        });
    }

    // check empty replace 
    private void checkEmptyReplace(ReplaceForm replaceForm) {
        replaceForm.getTxtFind().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                if (replaceForm.getTxtFind().getText().trim().isEmpty()) {
                    replaceForm.getBtnReplace().setEnabled(false);
                    replaceForm.getBtnReplaceAll().setEnabled(false);
                } else {
                    replaceForm.getBtnReplace().setEnabled(true);
                    replaceForm.getBtnReplaceAll().setEnabled(true);
                }
            }
        });
    }

    //replace
    public void replace(MainForm mainForm, ReplaceForm replaceForm) {
        replaceForm.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textAreaCurrent = mainForm.getTxtArea().getText();
                String textFind = replaceForm.getTxtFind().getText();
                String textReplace = replaceForm.getTxtReplace().getText();
                mainForm.getTxtArea().setText(textAreaCurrent.replaceFirst(textFind, textReplace));
                int indexCurrent = mainForm.getTxtArea().getText().lastIndexOf(textReplace) + textReplace.length();
                
                int indexTextSearch = -1;
                indexTextSearch = mainForm.getTxtArea().getText().indexOf(textFind, indexCurrent);
                // check have text want to search or not
                if (indexTextSearch != -1) {
                    mainForm.getTxtArea().setSelectionStart(indexTextSearch);
                    mainForm.getTxtArea().setSelectionEnd(indexTextSearch + textFind.length());
                } else {
                    JOptionPane.showMessageDialog(replaceForm, "Cannot find \"" + textFind + "\"", "Result", 2);
                }
            }
        });
    }

    // replace all
    private void replaceAll(MainForm mainForm, ReplaceForm replaceForm) {
        replaceForm.getBtnReplaceAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check textarea empty to show warning
                if (mainForm.getTxtArea().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(replaceForm, "No text field found!!!", "Error", 2);
                } else {
                    String textAreaCurrent = mainForm.getTxtArea().getText();
                    String textFind = replaceForm.getTxtFind().getText();
                    String textReplace = replaceForm.getTxtReplace().getText();
                    mainForm.getTxtArea().setText(textAreaCurrent.replaceAll(textFind, textReplace));
                }
            }
        });
    }

    // cancel replace
    private void cancelReplace(ReplaceForm replaceForm) {
        replaceForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceForm.setVisible(false);
            }
        });
    }

    // check can undo redo 
    private void checkUndoRedo(MainForm mainForm, UndoManager manager) {
        // when new app, user can't undo redo
        mainForm.getEditUndo().setEnabled(false);
        mainForm.getEditRedo().setEnabled(false);
        mainForm.getTxtArea().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                
                if (manager.canUndo()) {
                    mainForm.getEditUndo().setEnabled(true);
                } else {
                    mainForm.getEditUndo().setEnabled(false);
                }
                if (manager.canRedo()) {
                    mainForm.getEditRedo().setEnabled(true);
                } else {
                    mainForm.getEditRedo().setEnabled(false);
                }
            }
        });
    }
    
    private void changeFontController (MainForm mainForm){
        ChangeFontForm changeFontForm = new ChangeFontForm();
        changeFontForm.setVisible(true);
    }
}
