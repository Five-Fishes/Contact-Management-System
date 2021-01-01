package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class BackToMainMenuCommand implements Command{

    NavigateReceiver navigateReceiver;

    public BackToMainMenuCommand (NavigateReceiver navigateReceiver){
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        navigateReceiver.backToMainMenu();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
