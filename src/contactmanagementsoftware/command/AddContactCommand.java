package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class AddContactCommand implements Command{
    ContactReceiver contactReceiver;

    public AddContactCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.addContact();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
