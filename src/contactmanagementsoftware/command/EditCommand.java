package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class EditCommand implements Command{

    EditButton editButton;

    public EditCommand(EditButton editButton) {
        this.editButton = editButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        editButton.edit();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
