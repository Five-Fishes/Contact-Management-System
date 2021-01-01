package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class ExitCommand implements  Command{

    ExitReceiver exitReceiver;

    public ExitCommand(ExitReceiver exitReceiver) {
        this.exitReceiver = exitReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        exitReceiver.exit();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
