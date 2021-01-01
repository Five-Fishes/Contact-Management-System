package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class AddCommand implements Command{

    NavigateReceiver navigateReceiver;

    public AddCommand(NavigateReceiver navigateReceiver){
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        navigateReceiver.createAddForm(evt);
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
