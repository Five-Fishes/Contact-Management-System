package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class ExitCommand implements  Command{

    NavigateReceiver navigateReceiver;

    public ExitCommand(NavigateReceiver navigateReceiver) {
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        navigateReceiver.exit();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
