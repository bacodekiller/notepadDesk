package controller;

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

        isEdit(mainForm);

        undo(mainForm, manager);
        redo(mainForm, manager);
        copyPasteCut(mainForm);
        delete(mainForm);

        findController(mainForm);
        replaceController(mainForm);
    }

    // check user can undo/redo
    public void isEdit(MainForm mainForm) {
        // when open editor can't undo, redo
        mainForm.getEditRedo().setEnabled(false);
        mainForm.getEditUndo().setEnabled(false);
        // check when content text area change
        mainForm.getTxtArea().addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                String textCurrent = mainForm.getTxtArea().getText();
                // can undo redo when user change text
                if (textCurrent.length() != 0) {
                    mainForm.getEditRedo().setEnabled(true);
                    mainForm.getEditUndo().setEnabled(true);
                }
            }
        });
    }

    // undo
    public void undo(MainForm mainForm, UndoManager manager) {
        mainForm.getEditUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.undo();
            }
        });
    }

    // redo TODO: check cannot redo, undo
    public void redo(MainForm mainForm, UndoManager manager) {
        mainForm.getEditRedo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manager.redo();
            }
        });
    }

    // copy, past, cut
    public void copyPasteCut(MainForm mainForm) {
        Action copy = new DefaultEditorKit.CopyAction();
        Action paste = new DefaultEditorKit.PasteAction();
        Action cut = new DefaultEditorKit.CutAction();

        mainForm.getEditCopy().addActionListener(copy);
        mainForm.getEditPaste().addActionListener(paste);
        mainForm.getEditCut().addActionListener(cut);

    }

    // delete: change text selectd by empty then set text area by text change
    public void delete(MainForm mainForm) {
        mainForm.getEditDelete().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textChange = mainForm.getTxtArea().getText().replace(mainForm.getTxtArea().getSelectedText(), "");
                mainForm.getTxtArea().setText(textChange);
            }
        });
    }

    // find controller
    public void findController(MainForm mainForm) {
        mainForm.getFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindForm find = new FindForm(mainForm, true);
                find.setVisible(true);
                find(mainForm, find);
            }
        });
    }

    // find
    public void find(MainForm mainForm, FindForm findForm) {
        // when user click button find
        findForm.getBtnFind().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check textarea empty to show warning
                if (mainForm.getTxtArea().getText().isEmpty()) {
                    JOptionPane.showConfirmDialog(findForm, "No text field found!!!", "Error", 1);
                } else {
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
                        JOptionPane.showConfirmDialog(findForm, "Cannot find \"" + txtFind + "\"", "Result", 1);
                    }
                }
            }
        });
        // when user click button cancel
        findForm.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findForm.setVisible(false);
            }
        });
    }

    // replace controller
    public void replaceController(MainForm mainForm) {
        mainForm.getReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReplaceForm replace = new ReplaceForm(mainForm, false);
                replace.setVisible(true);
                replace(mainForm, replace);
            }
        });
    }

    //replace
    public void replace(MainForm mainForm, ReplaceForm replace) {
        // when user click replace
        replace.getBtnReplace().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check textarea empty to show warning
                if (mainForm.getTxtArea().getText().isEmpty()) {
                    JOptionPane.showConfirmDialog(replace, "No text field found!!!", "Error", 1);
                } else {
                    String textAreaCurrent = mainForm.getTxtArea().getText();
                    String textFind = replace.getTxtFind().getText();
                    String textReplace = replace.getTxtReplace().getText();
                    mainForm.getTxtArea().setText(textAreaCurrent.replaceFirst(textFind, textReplace));
                }
            }
        });

        // when user click replace all
        replace.getBtnReplaceAll().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check textarea empty to show warning
                if (mainForm.getTxtArea().getText().isEmpty()) {
                    JOptionPane.showConfirmDialog(replace, "No text field found!!!", "Error", 1);
                } else {
                    String textAreaCurrent = mainForm.getTxtArea().getText();
                    String textFind = replace.getTxtFind().getText();
                    String textReplace = replace.getTxtReplace().getText();
                    mainForm.getTxtArea().setText(textAreaCurrent.replaceAll(textFind, textReplace));
                }
            }
        });

        // when user click cancel
        replace.getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replace.setVisible(false);
            }
        });
    }
}
