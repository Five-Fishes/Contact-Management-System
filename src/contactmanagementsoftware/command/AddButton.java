package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddButton {
    static MUI mui;

    public void createAddForm(ActionEvent evt){
        mui = MUI.getInstance();
        JList jList1 = mui.getJList1();
        JPanel jPanel1 = mui.getPanel1();
        JPanel jPanel3 = mui.getPanel3();
        boolean flag = mui.getFlag();

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
}
