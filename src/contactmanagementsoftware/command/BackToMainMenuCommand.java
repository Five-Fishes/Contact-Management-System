package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class BackToMainMenuCommand implements Command{

    BackToMainMenuReceiver backToMainMenuReceiver;

    public BackToMainMenuCommand (BackToMainMenuReceiver backToMainMenuReceiver){
        this.backToMainMenuReceiver = backToMainMenuReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        backToMainMenuReceiver.backToMainMenu();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
