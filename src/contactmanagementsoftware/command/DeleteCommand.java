package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class DeleteCommand implements Command{

    DeleteButton deleteButton;

    public DeleteCommand (DeleteButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        deleteButton.deleteEntry(evt);
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
