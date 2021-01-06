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

        muiInstance.jScrollPane5.setVisible(true);
        muiInstance.jScrollPane4.setVisible(true);
        muiInstance.textAreaTwo.setVisible(true);
        muiInstance.textAreaThree.setVisible(true);
        muiInstance.jLabel7.setVisible(true);
        muiInstance.jLabel8.setVisible(true);
        muiInstance.jLabel9.setVisible(true);
        muiInstance.jLabel7.setText("First meeting time & location:");
        muiInstance.jLabel8.setText("First meeting CIrcumstances:");
        muiInstance.jLabel9.setText("Other useful information:");

        if (muiInstance.isAddContact) {
            /**
             * If we are adding new, set all input boxes content to empty
             */
            muiInstance.name.setText("");
            muiInstance.mobile.setText("");
            muiInstance.email.setText("");
            muiInstance.textAreaOne.setText("");
            muiInstance.textAreaTwo.setText("");
            muiInstance.textAreaThree.setText("");

            muiInstance.op = "Add";

            muiInstance.jButton10.setText("Add");

            muiInstance.jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));

        } else {
            /**
             * - Set the text for all the fields since they should already have
             * some values - If we are not adding, we can fall into edit/view
             * full details mode, therefore do another checking here
             */
            Acquaintances selectedAcquaintance = muiInstance.a.get(muiInstance.selectedContactType).get(muiInstance.selectedContactIndex);
            muiInstance.name.setText(selectedAcquaintance.getName());
            muiInstance.mobile.setText(selectedAcquaintance.getMobileNo());
            muiInstance.email.setText(selectedAcquaintance.getEmail());

            CasualAcquaintances casualAcquaintances = (CasualAcquaintances) selectedAcquaintance;
            muiInstance.textAreaOne.setText(casualAcquaintances.getWhenWhere());
            muiInstance.textAreaTwo.setVisible(true);
            muiInstance.textAreaThree.setVisible(true);
            muiInstance.textAreaTwo.setText(casualAcquaintances.getCircumstances());
            muiInstance.textAreaThree.setText(casualAcquaintances.getOtherInfo());

            muiInstance.jButton10.setVisible(true);
            muiInstance.jButton11.setVisible(true);

            muiInstance.name.setEditable(muiInstance.isDisplayOnly);
            muiInstance.mobile.setEditable(muiInstance.isDisplayOnly);
            muiInstance.email.setEditable(muiInstance.isDisplayOnly);
            muiInstance.textAreaOne.setEditable(muiInstance.isDisplayOnly);
            muiInstance.textAreaTwo.setEditable(muiInstance.isDisplayOnly);
            muiInstance.textAreaThree.setEditable(muiInstance.isDisplayOnly);

            if (muiInstance.isDisplayOnly) {
                muiInstance.jButton10.setText("Back to main menu");
                muiInstance.jButton11.setVisible(false);
                muiInstance.jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            } else {
                muiInstance.op = "Edit";
                muiInstance.jButton10.setText("Save");
                muiInstance.jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            }
        }
    }

}
