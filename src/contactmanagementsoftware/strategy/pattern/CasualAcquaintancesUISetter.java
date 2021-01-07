/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware.strategy.pattern;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.CasualAcquaintances;
import contactmanagementsoftware.MUI;

/**
 *
 * @author luxianze
 */
public class CasualAcquaintancesUISetter extends UISetter {

    public CasualAcquaintancesUISetter(MUI muiInstance) {
        super(muiInstance);
    }

    @Override
    public void setUI() {
        /**
         * Set text to compose title
         */

        muiInstance.getjScrollPane5().setVisible(true);
        muiInstance.getjScrollPane4().setVisible(true);
        muiInstance.getTextAreaTwo().setVisible(true);
        muiInstance.getTextAreaThree().setVisible(true);
        muiInstance.getjLabel7().setVisible(true);
        muiInstance.getjLabel8().setVisible(true);
        muiInstance.getjLabel9().setVisible(true);
        muiInstance.getjLabel7().setText("First meeting time & location:");
        muiInstance.getjLabel8().setText("First meeting CIrcumstances:");
        muiInstance.getjLabel9().setText("Other useful information:");

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
            muiInstance.getTextAreaOne().setText("");
            muiInstance.getTextAreaTwo().setText("");
            muiInstance.getTextAreaThree().setText("");

            muiInstance.setOp("Add");;

            muiInstance.getjButton10().setText("Add");

            muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));

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

            CasualAcquaintances casualAcquaintances = (CasualAcquaintances) selectedAcquaintance;
            muiInstance.textAreaOne.setText(casualAcquaintances.getWhenWhere());
            muiInstance.textAreaTwo.setVisible(true);
            muiInstance.textAreaThree.setVisible(true);
            muiInstance.textAreaTwo.setText(casualAcquaintances.getCircumstances());
            muiInstance.textAreaThree.setText(casualAcquaintances.getOtherInfo());

            if (muiInstance.getIsDisplayOnly()) {
                muiInstance.getjButton10().setText("Back to main menu");
                muiInstance.getjButton11().setVisible(false);
                muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            } else {
                muiInstance.setOp("Edit");
                muiInstance.getjButton10().setText("Save");
                muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            }
        }
    }

}
