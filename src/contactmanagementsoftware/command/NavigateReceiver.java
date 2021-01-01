package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NavigateReceiver {
    static MUI mui;
    JList jList1;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;

    public NavigateReceiver(){
        mui = mui.getInstance();
        jList1 = mui.getJList1();
        jPanel1 = mui.getPanel1();
        jPanel2 = mui.getPanel2();
        jPanel3 = mui.getPanel3();
    }

    public void createAddForm(ActionEvent evt){
        int index = jList1.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(mui, "select a category!");
            return;
        }
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        mui.setX(index);
        mui.setFlag(true);
        mui.setDFlag(false);
        mui.setDescription();
    }

    public void backToMainMenu(){
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }

    public void  cancel() {
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
    }

    public void exit(){
        System.exit(0);
    }
}
