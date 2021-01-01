package contactmanagementsoftware.command;

import javax.swing.*;

public class EditReceiver extends Receiver {

    public void edit(){
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
