package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class SaveCommand implements Command {
    SaveReceiver saveReceiver;

    public SaveCommand(SaveReceiver saveReceiver){
        this.saveReceiver = saveReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        saveReceiver.save();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
