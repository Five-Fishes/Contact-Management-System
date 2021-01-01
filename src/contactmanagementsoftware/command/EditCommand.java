package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class EditCommand implements Command{

    EditReceiver editReceiver;

    public EditCommand(EditReceiver editReceiver) {
        this.editReceiver = editReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        editReceiver.edit();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
