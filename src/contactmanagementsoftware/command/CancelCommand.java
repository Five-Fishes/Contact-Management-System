package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class CancelCommand implements Command{
    CancelReceiver cancelReceiver;

    public CancelCommand (CancelReceiver cancelReceiver) {
        this.cancelReceiver = cancelReceiver;

    }

    @Override
    public void execute(ActionEvent evt) {
        cancelReceiver.cancel();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
