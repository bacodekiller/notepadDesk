package controller;

import form.MainForm;

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
        MenuFile file = new MenuFile();
        file.controller(mainForm);
    }
}
