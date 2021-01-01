package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class CancelCommand implements Command{
    NavigateReceiver navigateReceiver;

    public CancelCommand (NavigateReceiver navigateReceiver) {
        this.navigateReceiver = navigateReceiver;

    }

    @Override
    public void execute(ActionEvent evt) {
        navigateReceiver.cancel();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
