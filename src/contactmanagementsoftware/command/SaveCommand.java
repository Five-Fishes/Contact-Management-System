package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class SaveCommand implements Command {

    ContactReceiver contactReceiver;

    public SaveCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public boolean execute(ActionEvent evt) {
        contactReceiver.saveContacts();
        return true;
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
