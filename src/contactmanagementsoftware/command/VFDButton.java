package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;

public class VFDButton {
    static MUI mui;

    public void viewFullDetail(){
        mui = mui.getInstance();
        mui = MUI.getInstance();
        JList jList1 = mui.getJList1();
        JPanel jPanel1 = mui.getPanel1();
        JPanel jPanel3 = mui.getPanel3();
        JXTable jXTable1 = mui.getjXTable1();

        int index = jList1.getSelectedIndex();
        if(index<0){
            JOptionPane.showMessageDialog(mui, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if(tindex < 0){
            JOptionPane.showMessageDialog(mui, "Select an entry!");
            return;
        }

        mui.setNum(tindex);
        mui.setFlag(false);
        mui.setX(index);
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        mui.setDFlag(true);
        mui.setDescription();

    }
}
