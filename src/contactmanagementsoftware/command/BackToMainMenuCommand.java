package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class BackToMainMenuCommand implements Command{

    NavigateReceiver navigateReceiver;

    public BackToMainMenuCommand (NavigateReceiver navigateReceiver){
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public boolean execute(ActionEvent evt) {
        navigateReceiver.backToMainMenu();
        return true;
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
