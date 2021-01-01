package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class EditCommand implements Command{

    ContactReceiver contactReceiver;

    public EditCommand(ContactReceiver contactReceiver) {
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.editContact();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
