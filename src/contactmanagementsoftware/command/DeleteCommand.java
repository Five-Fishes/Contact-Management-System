package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class DeleteCommand implements Command{

    DeleteReceiver deleteReceiver;

    public DeleteCommand (DeleteReceiver deleteReceiver) {
        this.deleteReceiver = deleteReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        deleteReceiver.deleteEntry(evt);
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
