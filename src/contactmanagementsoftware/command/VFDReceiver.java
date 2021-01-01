package contactmanagementsoftware.command;

import javax.swing.*;

public class VFDReceiver extends Receiver {

    public void viewFullDetail(){

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
