package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;

import javax.swing.*;

public class BackToMainMenuButton {
    static MUI mui;

    public void backToMainMenu(){
        mui = mui.getInstance();
        JPanel jPanel2 = mui.getPanel2();
        JPanel jPanel1 = mui.getPanel1();
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }
}
