/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware.strategy.pattern;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.MUI;
import contactmanagementsoftware.Relatives;

/**
 *
 * @author luxianze
 */
public class RelativesUISetter extends UISetter {

    public RelativesUISetter(MUI muiInstance) {
        super(muiInstance);
    }

    @Override
    public void setUI() {
        /**
         * Set text to compose title
         */

        muiInstance.getjLabel7().setText("<html>Relatives Birthday:<br> (dd/mm/yyyy)</html>");
        muiInstance.getjLabel8().setText("<html>Last Date met:<br> (dd/mm/yyyy)</html>");

        muiInstance.textAreaTwo.setVisible(true);
        muiInstance.textAreaThree.setVisible(false);

        muiInstance.getjLabel7().setVisible(true);
        muiInstance.getjLabel8().setVisible(true);
        muiInstance.getjLabel9().setVisible(false);

        muiInstance.jScrollPane4.setVisible(true);
        muiInstance.jScrollPane5.setVisible(false);

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

            muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Relatives Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));

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

            Relatives rel = (Relatives) selectedAcquaintance;
            muiInstance.textAreaOne.setText(rel.getBDate());
            muiInstance.textAreaTwo.setText(rel.getLDate());

            if (muiInstance.getIsDisplayOnly()) {
                muiInstance.getjButton10().setText("Back to main menu");
                muiInstance.getjButton11().setVisible(false);
                muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            } else {
                muiInstance.op = "Edit";
                muiInstance.getjButton10().setText("Save");
                muiInstance.getjPanel3().setBorder(javax.swing.BorderFactory.createTitledBorder(null, muiInstance.op + " Relatives Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
            }
        }
    }

}
