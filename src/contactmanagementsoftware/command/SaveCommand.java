package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class SaveCommand implements Command {

    ContactReceiver contactReceiver;

    public SaveCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.saveContacts();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
