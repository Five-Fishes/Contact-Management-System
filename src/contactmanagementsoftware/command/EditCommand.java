package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class EditCommand implements Command{

    NavigateReceiver navigateReceiver;

    public EditCommand(NavigateReceiver navigateReceiver) {
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public boolean execute(ActionEvent evt) {
        navigateReceiver.toEditContactForm();
        return true;
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
