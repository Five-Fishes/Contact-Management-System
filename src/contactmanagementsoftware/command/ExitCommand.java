package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class ExitCommand implements  Command{

    ExitButton exitButton;

    public ExitCommand(ExitButton exitButton) {
        this.exitButton = exitButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        exitButton.exit();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
