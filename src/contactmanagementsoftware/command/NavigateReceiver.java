package contactmanagementsoftware.command;

import contactmanagementsoftware.MUI;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NavigateReceiver {
    static MUI mui;
    JPanel jPanel1;
    JPanel jPanel2;
    JPanel jPanel3;

    public NavigateReceiver(){
        mui = mui.getInstance();
        jPanel1 = mui.getjPanel1();
        jPanel2 = mui.getjPanel2();
        jPanel3 = mui.getjPanel3();
    }

    public void toAddContactForm(ActionEvent evt){
        if (mui.getSelectedContactTypeIndex() < 0) {
            JOptionPane.showMessageDialog(mui, "select a category!");
            return;
        }
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        mui.setIsAddContact(true);
        mui.setIsDisplayOnly(false);
        mui.contactDetailsPanelSetterSetUI();
    }

    public void toEditContactForm(){
        if(mui.getSelectedContactTypeIndex() < 0){
            JOptionPane.showMessageDialog(mui, "Select a category!");
            return;
        }
        if(mui.getSelectedContactIndex() < 0){
            JOptionPane.showMessageDialog(mui, "Select an entry!");
            return;
        }

        mui.setIsAddContact(false);
        mui.setIsDisplayOnly(false);
        mui.contactDetailsPanelSetterSetUI();
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
    }

    public void backToMainMenu(){
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }

    public void cancel() {
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
    }

    public void exit(){
        System.exit(0);
    }
}
