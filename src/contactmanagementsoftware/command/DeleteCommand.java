package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class DeleteCommand implements Command{

    ContactReceiver contactReceiver;

    public DeleteCommand (ContactReceiver contactReceiver) {
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.deleteContact();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
