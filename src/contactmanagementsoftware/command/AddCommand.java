package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class AddCommand implements Command{

    NavigateReceiver navigateReceiver;

    public AddCommand(NavigateReceiver navigateReceiver){
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public boolean execute(ActionEvent evt) {
        navigateReceiver.toAddContactForm();
        return true;
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
