package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class AddContactCommand implements Command{
    AddContactReceiver addContactReceiver;

    public AddContactCommand(AddContactReceiver addContactReceiver){
        this.addContactReceiver = addContactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        addContactReceiver.addContact();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
