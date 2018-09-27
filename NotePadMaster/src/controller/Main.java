package controller;

import form.TabbedNotepad;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Sharp team
 */
public class Main {
    public static void main(String[] args) {
        TabbedNotepad mainForm = new TabbedNotepad();
        mainForm.setVisible(true);
        Edit edit = new Edit();
        edit.controller(mainForm);
    }
}
