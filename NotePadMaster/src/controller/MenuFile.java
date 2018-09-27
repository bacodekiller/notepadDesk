package controller;

import form.MainForm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Sharp team
 */
public class MenuFile {

    private MainForm mainForm;

    private boolean saved;
    private boolean newFileFlag;

    private String fileName;
    private String applicationTitle = "Notepad";

    private File fileRef;
    private JFileChooser chooser;

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isNewFileFlag() {
        return newFileFlag;
    }

    public void setNewFileFlag(boolean newFileFlag) {
        this.newFileFlag = newFileFlag;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MenuFile() {
    }

    public MenuFile(MainForm mainForm) {
        this.mainForm = mainForm;
        saved = true;
        newFileFlag = true;
        fileName = "Untiled";
        fileRef = new File(fileName);
        this.mainForm.setTitle(fileName + " - " + applicationTitle);

        chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".java");
                }
            }

            @Override
            public String getDescription() {
                return "Java Source Files(*.java)";
            }
        });
        chooser.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().endsWith(".txt");
                }
            }

            @Override
            public String getDescription() {
                return "Text Files(*.txt)";
            }
        });
        chooser.setCurrentDirectory(new File("."));
    }

    //--- Save File ---
    public boolean saveFile(File temp) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(temp);
            fout.write(mainForm.getTxtArea().getText());
        } catch (IOException e) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                fout.close();
            } catch (IOException excp) {
            }
        }
        updateStatus(temp, true);
        return true;
    }
    
    // check status of file
    public void updateStatus(File temp, boolean saved) {
        if (saved) {
            this.saved = true;
            fileName = temp.getName();
            if (!temp.canWrite()) {
                fileName += "(Read only)";
                newFileFlag = true;
            }
            fileRef = temp;
            mainForm.setTitle(fileName + " - " + applicationTitle);
            newFileFlag = false;
        } 
    }

    // save old file current 
    public boolean saveThisFile() {
        // check file is new file?
        if (!newFileFlag) {
            return saveFile(fileRef);
        }
        return saveAsFile();
    }

    // save file as
    public boolean saveAsFile() {
        File temp = null;
        // loop until user choose true file
        do {
            if (chooser.showSaveDialog(this.mainForm) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();
            if (!temp.exists()) {
                break;
            }
            if (JOptionPane.showConfirmDialog(
                    this.mainForm, "<html>" + temp.getName() + " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                break;
            }
        } while (true);

        return saveFile(temp);
    }

    // open file
    public boolean openFile(File temp) {
        FileInputStream fin = null;
        BufferedReader din = null;

        try {
            fin = new FileInputStream(temp);
            din = new BufferedReader(new InputStreamReader(fin));
            String str = "";
            while (str != null) {
                str = din.readLine();
                if (str == null) {
                    break;
                }
                this.mainForm.getTxtArea().append(str + "\n");
            }

        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                din.close();
                fin.close();
            } catch (IOException excp) {
            }
        }
        updateStatus(temp, true);
        this.mainForm.getTxtArea().setCaretPosition(0);
        return true;
    }

    public boolean openFile() {
        // check user confirm wanna save file before open file
        if (!confirmSave()) {
            return false;
        }

        File temp = null;
        do {
            if (chooser.showOpenDialog(this.mainForm) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();

            if (temp.exists()) {
                break;
            }

            JOptionPane.showMessageDialog(this.mainForm,
                    "<html>" + temp.getName() + "<br>file not found.<br>"
                    + "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);

        this.mainForm.getTxtArea().setText("");

        if (!openFile(temp)) {
            fileName = "Untitled";
            saved = true;
            this.mainForm.setTitle(fileName + " - " + applicationTitle);
        }
        if (!temp.canWrite()) {
            newFileFlag = true;
        }
        return true;
    }

    // check user choose yes or no or cancel in dialog
    public boolean confirmSave() {
        String strMsg = "<html><div style = 'color:blue'>Do you want to save the changes to " + fileRef + "</div><html>";
        // check user choose yes or no
        if (!saved) {
            int x = JOptionPane.showConfirmDialog(this.mainForm, strMsg, applicationTitle,
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (x == JOptionPane.CANCEL_OPTION) {
                return false;
            }
            if (x == JOptionPane.YES_OPTION && !saveAsFile()) {
                return false;
            }
        }
        return true;
    }

    // create new file
    public void newFile() {
        // check user confirm wanna save file before create new file
        if (!confirmSave()) {
            return;
        }

        this.mainForm.getTxtArea().setText("");
        fileName = "Untitled";
        fileRef = new File(fileName);
        saved = true;
        newFileFlag = true;
        this.mainForm.setTitle(fileName + " - " + applicationTitle);
    }

    // check text area have be modify
    public void checkModify() {
        //track the change of Text Area and give status saved
        mainForm.getTxtArea().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                saved = false;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                saved = false;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                saved = false;
            }

        });
    }

    // exit app
    public void exitNote() {
        // check user confirm wanna save file before exit
        if (!confirmSave()) {
            return;
        } else {
            System.exit(0);
        }
    }
}
