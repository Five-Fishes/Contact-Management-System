package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;

import javax.swing.*;

public class CancelButton {
    static MUI mui;

    public void  cancel() {
        mui = mui.getInstance();
        JPanel jPanel1 = mui.getPanel1();
        JPanel jPanel3 = mui.getPanel3();
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
    }
}
