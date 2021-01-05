package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;
import org.jdesktop.swingx.JXTable;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NavigateReceiver {
    static MUI mui;
    JList jList1;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;
    JXTable jXTable1;

    public NavigateReceiver(){
        mui = mui.getInstance();
        jList1 = mui.getJList1();
        jPanel1 = mui.getPanel1();
        jPanel2 = mui.getPanel2();
        jPanel3 = mui.getPanel3();
        jXTable1 = mui.getjXTable1();
    }

    public void toAddContactForm(ActionEvent evt){
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

    public void toEditContactForm(){
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
