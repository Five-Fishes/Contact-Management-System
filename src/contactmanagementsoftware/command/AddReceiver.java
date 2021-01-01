package contactmanagementsoftware.command;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddReceiver extends Receiver {

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
}
