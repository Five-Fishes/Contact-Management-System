package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class SearchCommand implements Command{

    ContactReceiver contactReceiver;

    public SearchCommand(ContactReceiver contactReceiver) {
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.searchContact();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
