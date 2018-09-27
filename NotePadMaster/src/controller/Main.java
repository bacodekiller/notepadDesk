package controller;

import form.MainForm;
import javax.swing.undo.UndoManager;

/**
 *
 * @author Sharp team
 */
public class Main {
    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
        MenuEdit edit = new MenuEdit();
        edit.controller(mainForm);
    }
}
