package contactmanagementsoftware.command;

import javax.swing.*;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.MUI;
import org.jdesktop.swingx.JXTable;

import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class DeleteButton {
    static MUI mui;

    public void deleteEntry(ActionEvent evt){
        mui = MUI.getInstance();
        JList jList1 = mui.getJList1();
        JXTable jXTable1 = mui.getjXTable1();
        ArrayList<ArrayList<Acquaintances>> a = mui.getA();

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
        int n = JOptionPane.showConfirmDialog(
                mui,
                "Are you sure you want to delete this?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);
        if(n==0){
            a.get(index).remove(tindex);
            JOptionPane.showMessageDialog(mui, "Successfully Deleted");
            mui.setUpTableData();
        }
    }
}
