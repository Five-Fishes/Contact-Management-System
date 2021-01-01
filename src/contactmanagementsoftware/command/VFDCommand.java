package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class VFDCommand implements Command{

    ContactReceiver contactReceiver;

    public VFDCommand(ContactReceiver contactReceiver) {
        this.contactReceiver = contactReceiver;
    }
    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.viewFullDetail();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
