/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware.strategy.pattern;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.MUI;
import contactmanagementsoftware.PersonalFriends;

/**
 *
 * @author luxianze
 */
public class PersonalFriendsUISetter extends UISetter {

    public PersonalFriendsUISetter(MUI muiInstance) {
        super(muiInstance);
    }

    @Override
    public void setUI() {
        /**
         * Set text to compose title
         */

        muiInstance.textAreaTwo.setVisible(true);
        muiInstance.textAreaThree.setVisible(true);

        muiInstance.getjLabel7().setText("Specific Events:");
        muiInstance.getjLabel8().setText("First Acquaintance Context:");
        muiInstance.getjLabel9().setText("<html>First Acquaintance Date:<br>(dd/mm/yyyy)</html>");
        muiInstance.getjLabel9().setVisible(true);
        muiInstance.getjLabel3().setVisible(true);
        muiInstance.getjLabel8().setVisible(true);
        muiInstance.getjLabel7().setVisible(true);
        muiInstance.jScrollPane5.setVisible(true);
        muiInstance.jScrollPane4.setVisible(true);

        muiInstance.getjButton10().setVisible(true);
        muiInstance.getjButton11().setVisible(true);

        muiInstance.getNameTextField().setEditable(!muiInstance.getIsDisplayOnly());
        muiInstance.getMobileTextField().setEditable(!muiInstance.getIsDisplayOnly());
        muiInstance.getEmailTextField().setEditable(!muiInstance.getIsDisplayOnly());
        muiInstance.textAreaOne.setEditable(!muiInstance.getIsDisplayOnly());
        muiInstance.textAreaTwo.setEditable(!muiInstance.getIsDisplayOnly());
        muiInstance.textAreaThree.setEditable(!muiInstance.getIsDisplayOnly());
        
        if (muiInstance.getIsAddContact()) {
            /**
             * If we are adding new, set all input boxes content to empty
             */
            muiInstance.getNameTextField().setText("");
            muiInstance.getMobileTextField().setText("");
            muiInstance.getEmailTextField().setText("");
            muiInstance.textAreaOne.setText("");
            muiInstance.textAreaTwo.setText("");
            muiInstance.textAreaThree.setText("");

            muiInstance.op = "Add";

            muiInstance.getjButton10().setText("Add");

            muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Personal Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));

        } else {
            /**
             * - Set the text for all the fields since they should already have
             * some values - If we are not adding, we can fall into edit/view
             * full details mode, therefore do another checking here
             */
            Acquaintances selectedAcquaintance = muiInstance.getCurrentAcquaintance();
            muiInstance.getNameTextField().setText(selectedAcquaintance.getName());
            muiInstance.getMobileTextField().setText(selectedAcquaintance.getMobileNo());
            muiInstance.getEmailTextField().setText(selectedAcquaintance.getEmail());

            PersonalFriends personalFriend = (PersonalFriends) selectedAcquaintance;
            muiInstance.textAreaOne.setText(personalFriend.getEvents());
            muiInstance.textAreaTwo.setText(personalFriend.getAContext());
            muiInstance.textAreaThree.setText(personalFriend.getADate());

            if (muiInstance.getIsDisplayOnly()) {
                muiInstance.getjButton10().setText("Back to main menu");
                muiInstance.getjButton11().setVisible(false);
                muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            } else {
                muiInstance.op = "Edit";
                muiInstance.getjButton10().setText("Save");
                muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Personal Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            }
        }
    }

}
