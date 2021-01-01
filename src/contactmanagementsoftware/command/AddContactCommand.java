package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class AddContactCommand implements Command{
    AddContactButton addContactButton;

    public AddContactCommand(AddContactButton addContactButton){
        this.addContactButton = addContactButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        addContactButton.addContact();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
