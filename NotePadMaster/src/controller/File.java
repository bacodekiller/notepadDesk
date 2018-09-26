package controller;

import form.MainForm;
import javax.swing.JOptionPane;

/**
 *
 * @author Sharp team
 */
public class File {
    
    // action check user wannpa create new file
    public void newAction(MainForm form){
        int confirm = JOptionPane.showConfirmDialog(
                form,
                "Do you want to save file"
                + " before close ?",
                "Save or not",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (confirm == JOptionPane.YES_OPTION || confirm == JOptionPane.NO_OPTION) {
            if (confirm == JOptionPane.YES_OPTION) {
                fileSaveActionPerformed(evt);
            }
        } else if (confirm == JOptionPane.CLOSED_OPTION) {
            //do nothing
        }
    }
}
