package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class CancelCommand implements Command{
    CancelButton cancelButton;

    public CancelCommand (CancelButton cancelButton) {
        this.cancelButton = cancelButton;

    }

    @Override
    public void execute(ActionEvent evt) {
        cancelButton.cancel();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
