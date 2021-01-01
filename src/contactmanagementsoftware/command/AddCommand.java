package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class AddCommand implements Command{

    AddReceiver addReceiver;

    public AddCommand(AddReceiver addReceiver){
        this.addReceiver = addReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        addReceiver.createAddForm(evt);
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
