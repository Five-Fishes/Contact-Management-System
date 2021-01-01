package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class SaveCommand implements Command {
    SaveButton saveButton;

    public SaveCommand(SaveButton saveButton){
        this.saveButton = saveButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        saveButton.save();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
