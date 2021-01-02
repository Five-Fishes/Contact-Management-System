package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class EditCommand implements Command{

    NavigateReceiver navigateReceiver;

    public EditCommand(NavigateReceiver navigateReceiver) {
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        navigateReceiver.toEditContactForm();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
