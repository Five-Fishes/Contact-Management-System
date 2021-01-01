package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class ReadFromFileCommand implements Command{

    ContactReceiver contactReceiver;;

    public ReadFromFileCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.uploadContacts();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
