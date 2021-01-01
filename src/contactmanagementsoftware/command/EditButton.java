package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;

public class EditButton {
    static MUI mui;

    public void edit(){
        mui = mui.getInstance();
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
        mui.setDFlag(false);
        mui.setX(index);
        mui.setDescription();
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
    }
}
